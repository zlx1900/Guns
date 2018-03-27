package com.stylefeng.guns.modular.task.job;

import com.stylefeng.guns.core.util.SpringUtils;
import com.stylefeng.guns.modular.task.spider.CnblogsSpider;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Spider;

public class CnBlogNewsJob {
	public final Logger log = Logger.getLogger(this.getClass());
	private static Boolean IS_RUNNING = false;

	public void execute() {
		log.info("<<<<<获取博客园新闻>>>>>" + IS_RUNNING);
		if(!IS_RUNNING){
			IS_RUNNING=true;
			try{
				CnblogsSpider cnblogsSpider = SpringUtils.getBean("cnblogsSpider");
				Spider.create(cnblogsSpider).addUrl("https://www.cnblogs.com/news/").thread(3).run();
			}catch(Exception e){
				log.error("CnblogsSpider",e);
			}
			IS_RUNNING=false;
		}
	}
}
