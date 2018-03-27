package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TaskSchedule;
import com.stylefeng.guns.modular.system.dao.TaskScheduleMapper;
import com.stylefeng.guns.modular.system.service.ITaskScheduleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务执行计划 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-03-27
 */
@Service
public class TaskScheduleServiceImpl extends ServiceImpl<TaskScheduleMapper, TaskSchedule> implements ITaskScheduleService {

}
