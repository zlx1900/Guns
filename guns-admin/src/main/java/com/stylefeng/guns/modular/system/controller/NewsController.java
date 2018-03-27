package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.News;
import com.stylefeng.guns.modular.system.service.INewsService;

/**
 * 新闻管理控制器
 *
 * @author fengshuonan
 * @Date 2018-03-27 10:23:46
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    private String PREFIX = "/system/news/";

    @Autowired
    private INewsService newsService;

    /**
     * 跳转到新闻管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "news.html";
    }

    /**
     * 跳转到添加新闻管理
     */
    @RequestMapping("/news_add")
    public String newsAdd() {
        return PREFIX + "news_add.html";
    }

    /**
     * 跳转到修改新闻管理
     */
    @RequestMapping("/news_update/{newsId}")
    public String newsUpdate(@PathVariable Integer newsId, Model model) {
        News news = newsService.selectById(newsId);
        model.addAttribute("item",news);
        LogObjectHolder.me().set(news);
        return PREFIX + "news_edit.html";
    }

    /**
     * 获取新闻管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return newsService.selectList(null);
    }

    /**
     * 新增新闻管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(News news) {
        newsService.insert(news);
        return SUCCESS_TIP;
    }

    /**
     * 删除新闻管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer newsId) {
        newsService.deleteById(newsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改新闻管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(News news) {
        newsService.updateById(news);
        return SUCCESS_TIP;
    }

    /**
     * 新闻管理详情
     */
    @RequestMapping(value = "/detail/{newsId}")
    @ResponseBody
    public Object detail(@PathVariable("newsId") Integer newsId) {
        return newsService.selectById(newsId);
    }
}
