package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 新闻
 * </p>
 *
 * @author stylefeng123
 * @since 2018-03-27
 */
@TableName("sys_news")
public class News extends Model<News> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    @TableField("publish_time")
    private Date publishTime;
    /**
     * 内容简介
     */
    @TableField("short_content")
    private String shortContent;
    /**
     * 来源
     */
    private String source;
    /**
     * 来源链接
     */
    @TableField("source_url")
    private String sourceUrl;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否删除
     */
    @TableField("is_delete")
    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "News{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", publishTime=" + publishTime +
        ", shortContent=" + shortContent +
        ", source=" + source +
        ", sourceUrl=" + sourceUrl +
        ", createTime=" + createTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
