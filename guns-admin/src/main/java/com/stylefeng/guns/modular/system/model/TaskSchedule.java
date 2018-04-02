package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 定时任务执行计划
 * </p>
 *
 * @author stylefeng123
 * @since 2018-03-27
 */
@TableName("sys_task_schedule")
public class TaskSchedule extends Model<TaskSchedule> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("job_name")
    private String jobName;
    @TableField("job_group")
    private String jobGroup;
    @TableField("job_status")
    private Integer jobStatus;
    @TableField("cron_expression")
    private String cronExpression;
    private String description;
    @TableField("bean_class")
    private String beanClass;
    /**
     * 是否同步 1同步 0不同步
     */
    @TableField("is_concurrent")
    private Integer isConcurrent;
    @TableField("spring_id")
    private String springId;
    @TableField("method_name")
    private String methodName;
    /**
     * 最后一次执行开始时间
     */
    @TableField("last_start_time")
    private Date lastStartTime;
    /**
     * 最后一次执行结束时间
     */
    @TableField("last_end_time")
    private Date lastEndTime;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public Integer getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(Integer isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getSpringId() {
        return springId;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(Date lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public Date getLastEndTime() {
        return lastEndTime;
    }

    public void setLastEndTime(Date lastEndTime) {
        this.lastEndTime = lastEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TaskSchedule{" +
        "id=" + id +
        ", jobName=" + jobName +
        ", jobGroup=" + jobGroup +
        ", jobStatus=" + jobStatus +
        ", cronExpression=" + cronExpression +
        ", description=" + description +
        ", beanClass=" + beanClass +
        ", isConcurrent=" + isConcurrent +
        ", springId=" + springId +
        ", methodName=" + methodName +
        ", lastStartTime=" + lastStartTime +
        ", lastEndTime=" + lastEndTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
