package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.News;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 新闻 Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2018-03-27
 */
public interface NewsMapper extends BaseMapper<News> {
    /**
     * 根据标题md5获取新闻条数
     * @param titleMd5
     * @return
     */
    int countByTitleMd5(String titleMd5);

    /**
     * 获取新闻内容
     * @param id
     * @return
     */
    String getContentById(Integer id);
}
