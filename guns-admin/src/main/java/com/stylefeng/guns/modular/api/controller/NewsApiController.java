package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.model.News;
import com.stylefeng.guns.modular.system.service.INewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 新闻API
 *
 * @author zhanglongxiang
 * @Date 2018-03-27 10:23:46
 */
@Controller
@RequestMapping("/api/news")
public class NewsApiController extends BaseController {
    Logger logger = LoggerFactory.getLogger(NewsApiController.class);

    @Autowired
    private INewsService newsService;

    /**
     * 获取新闻详情
     */
    @ApiOperation("获取新闻详情")
    @RequestMapping(value = "/detail/{newsId}", method = RequestMethod.GET)
    @ResponseBody
    public Object newsUpdate(@ApiParam(required=true, name="newsId", value="新闻ID") @PathVariable(value = "newsId") Integer newsId) {
        logger.info("/detail/{newsId},参数: newsId={}", newsId);
        return newsService.getById(newsId);
    }

    /**
     * 获取新闻管理列表
     */
    @ApiOperation("获取新闻管理列表")
    @RequestMapping(value = "/list/{current}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@ApiParam(required=true, name="current", value="当前页") @PathVariable(value = "current") Integer current,
                       @ApiParam(required=true, name="size", value="每页显示条数") @PathVariable(value = "size") Integer size) {
        Page<News> page = new Page<>(current, size);
        return newsService.selectPage(page).getRecords();
    }


}
