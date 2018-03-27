package com.stylefeng.guns.core.common.constant.state;

/**
 * 定时任务状态枚举
 *
 * @author zhanglongxiang
 * @date 2018年3月27日22:50:11
 */
public enum TaskState {

    RUNNING(1, "启用"),
    STOP(0, "停用");

    int code;
    String message;

    TaskState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (TaskState s : TaskState.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
