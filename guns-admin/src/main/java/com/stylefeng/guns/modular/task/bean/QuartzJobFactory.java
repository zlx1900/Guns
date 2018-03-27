package com.stylefeng.guns.modular.task.bean;

import com.stylefeng.guns.core.util.TaskUtils;
import com.stylefeng.guns.modular.system.model.TaskSchedule;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJobFactory implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	public void execute(JobExecutionContext context) throws JobExecutionException {
		TaskSchedule scheduleJob = (TaskSchedule) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);
	}
}