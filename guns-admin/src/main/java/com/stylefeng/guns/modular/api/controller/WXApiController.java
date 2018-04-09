package com.stylefeng.guns.modular.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogManager;
import com.stylefeng.guns.core.log.factory.LogTaskFactory;
import com.stylefeng.guns.modular.system.model.News;
import com.stylefeng.guns.modular.system.service.INewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stylefeng.guns.core.support.HttpKit.getIp;

/**
 * 小程序API
 *
 * @author zhanglongxiang
 * @Date 2018-04-09 10:23:46
 */
@Controller
@RequestMapping("/api/wx")
public class WXApiController extends BaseController {
    /**
     * 小程序打开日志
     */
    @ApiOperation("小程序打开日志")
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public void newsUpdate(@ApiParam(required=true, name="userInfo", value="微信用户信息") @RequestParam(value = "userInfo") String userInfo) {
        LogManager.me().executeLog(LogTaskFactory.wxLoginLog(userInfo, getIp()));
    }
}
