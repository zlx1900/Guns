/**
 * 初始化任务管理详情对话框
 */
var TaskScheduleInfoDlg = {
    taskScheduleInfoData : {}
};

/**
 * 清除数据
 */
TaskScheduleInfoDlg.clearData = function() {
    this.taskScheduleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TaskScheduleInfoDlg.set = function(key, val) {
    this.taskScheduleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TaskScheduleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TaskScheduleInfoDlg.close = function() {
    parent.layer.close(window.parent.TaskSchedule.layerIndex);
}

/**
 * 收集数据
 */
TaskScheduleInfoDlg.collectData = function() {
    this
    .set('jobName')
    .set('jobGroup')
    .set('jobStatus')
    .set('cronExpression')
    .set('description')
    .set('beanClass')
    .set('isConcurrent')
    .set('springId')
    .set('methodName')
    .set('lastStartTime')
    .set('lastEndTime')
    .set('createTime');
}

/**
 * 提交添加
 */
TaskScheduleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/taskSchedule/add", function(data){
        Feng.success("添加成功!");
        window.parent.TaskSchedule.table.refresh();
        TaskScheduleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.taskScheduleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TaskScheduleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/taskSchedule/update", function(data){
        Feng.success("修改成功!");
        window.parent.TaskSchedule.table.refresh();
        TaskScheduleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.taskScheduleInfoData);
    ajax.start();
}

$(function() {

});
