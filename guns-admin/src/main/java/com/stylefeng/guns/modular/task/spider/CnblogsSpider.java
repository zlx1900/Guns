package com.stylefeng.guns.modular.task.spider;

import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.modular.system.model.News;
import com.stylefeng.guns.modular.system.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import java.util.*;

@Component("cnblogsSpider")
public class CnblogsSpider implements PageProcessor {

    @Autowired
    private INewsService newsService;

    private Map<String, News> newsMap = new HashMap<>();

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

    public void process(Page page) {
        //获取新闻列表
        if (page.getUrl().regex("^https://www\\.cnblogs\\.com/news/$").match()) {
            //page.addTargetRequests(page.getHtml().xpath("//*[@id=\"post_list\"]/div/div[@class='post_item_body']/h3/a/@href").all());
            List<String> requestList = new ArrayList<>();
            List<Selectable> selectableList = page.getHtml().xpath("//*[@class='post_item_body']").nodes();
            for (Selectable selectable : selectableList ) {
                try{
                    String title = selectable.xpath("//*[@class='titlelnk']/text()").get();
                    String titleMd5 = MD5Util.encrypt(title);
                    if (newsService.countByTitleMd5(titleMd5) == 0) {
                        News news = new News();
                        news.setTitle(title);
                        news.setTitleMd5(titleMd5);
                        news.setShortContent(selectable.xpath("//*[@class='post_item_summary']/text()").get());
                        news.setSmallImage("https:" + selectable.xpath("//*[@class='post_item_summary']/a/img/@src").get());

                        String publishTime = selectable.xpath("//*[@class='post_item_foot']/text()").get().trim();
                        publishTime = publishTime.substring(publishTime.indexOf("2"), publishTime.length()) + ":00";
                        news.setPublishTime(DateUtil.parseTime(publishTime));
                        news.setCreateTime(new Date());

                        newsMap.put(titleMd5, news);
                        requestList.add(selectable.xpath("//*[@class='titlelnk']/@href").get());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (!requestList.isEmpty()){
                page.addTargetRequests(requestList);
            }
        } else {
            // 获取新闻内容
            String titleMd5 = MD5Util.encrypt(page.getHtml().xpath("//*[@id='news_title']/a/text()").get());
            if (newsMap.containsKey(titleMd5)){
                News news = newsMap.get(titleMd5);
                news.setContent(page.getHtml().xpath("//*[@id='news_body']").get().replace("<div id=\"news_body\"> \n", "").replace("</div>", ""));
                news.setSourceUrl(page.getHtml().xpath("//*[@id=\"link_source1\"]/@href").get());
                news.setSource(page.getHtml().xpath("//*[@id='link_source2']/text()").get());
                newsService.insert(news);
                newsMap.remove(titleMd5);
            }
        }

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CnblogsSpider()).addUrl("https://www.cnblogs.com/news/").thread(3).run();
    }
}