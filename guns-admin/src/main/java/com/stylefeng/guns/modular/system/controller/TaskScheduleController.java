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
import com.stylefeng.guns.modular.system.model.TaskSchedule;
import com.stylefeng.guns.modular.system.service.ITaskScheduleService;

/**
 * 任务管理控制器
 *
 * @author fengshuonan
 * @Date 2018-03-27 10:41:45
 */
@Controller
@RequestMapping("/taskSchedule")
public class TaskScheduleController extends BaseController {

    private String PREFIX = "/system/taskSchedule/";

    @Autowired
    private ITaskScheduleService taskScheduleService;

    /**
     * 跳转到任务管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "taskSchedule.html";
    }

    /**
     * 跳转到添加任务管理
     */
    @RequestMapping("/taskSchedule_add")
    public String taskScheduleAdd() {
        return PREFIX + "taskSchedule_add.html";
    }

    /**
     * 跳转到修改任务管理
     */
    @RequestMapping("/taskSchedule_update/{taskScheduleId}")
    public String taskScheduleUpdate(@PathVariable Integer taskScheduleId, Model model) {
        TaskSchedule taskSchedule = taskScheduleService.selectById(taskScheduleId);
        model.addAttribute("item",taskSchedule);
        LogObjectHolder.me().set(taskSchedule);
        return PREFIX + "taskSchedule_edit.html";
    }

    /**
     * 获取任务管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return taskScheduleService.selectList(null);
    }

    /**
     * 新增任务管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TaskSchedule taskSchedule) {
        taskScheduleService.insert(taskSchedule);
        return SUCCESS_TIP;
    }

    /**
     * 删除任务管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer taskScheduleId) {
        taskScheduleService.deleteById(taskScheduleId);
        return SUCCESS_TIP;
    }

    /**
     * 修改任务管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TaskSchedule taskSchedule) {
        taskScheduleService.updateById(taskSchedule);
        return SUCCESS_TIP;
    }

    /**
     * 任务管理详情
     */
    @RequestMapping(value = "/detail/{taskScheduleId}")
    @ResponseBody
    public Object detail(@PathVariable("taskScheduleId") Integer taskScheduleId) {
        return taskScheduleService.selectById(taskScheduleId);
    }
}
