package com.stylefeng.guns.core.common.constant.state;

/**
 * 定时任务状态枚举
 *
 * @author zhanglongxiang
 * @date 2018年3月27日22:50:11
 */
public enum TaskIsConcurrent {

    CONCURRENT(1, "同步"),
    NO_CONCURRENT(0, "不同步");

    int code;
    String message;

    TaskIsConcurrent(int code, String message) {
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
            for (TaskIsConcurrent s : TaskIsConcurrent.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
