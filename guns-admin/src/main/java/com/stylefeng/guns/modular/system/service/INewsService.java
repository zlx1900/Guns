package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.News;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 新闻 服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-03-27
 */
public interface INewsService extends IService<News> {

    News getById(Integer id);

    /**
     * 根据标题md5获取新闻条数
     * @param titleMd5
     * @return
     */
    int countByTitleMd5(String titleMd5);
}
