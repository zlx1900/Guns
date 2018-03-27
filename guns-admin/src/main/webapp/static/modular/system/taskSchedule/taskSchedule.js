/**
 * 任务管理管理初始化
 */
var TaskSchedule = {
    id: "TaskScheduleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TaskSchedule.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '名称', field: 'jobName', visible: true, align: 'center', valign: 'middle'},
            {title: 'group', field: 'jobGroup', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'jobStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '表达式', field: 'cronExpression', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '类路径', field: 'beanClass', visible: true, align: 'center', valign: 'middle'},
            {title: '是否同步', field: 'isConcurrent', visible: true, align: 'center', valign: 'middle'},
            {title: 'spring_id', field: 'springId', visible: true, align: 'center', valign: 'middle'},
            {title: '方法名', field: 'methodName', visible: true, align: 'center', valign: 'middle'},
            {title: '最后一次执行开始时间', field: 'lastStartTime', visible: true, align: 'center', valign: 'middle'},
            {title: '最后一次执行结束时间', field: 'lastEndTime', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TaskSchedule.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TaskSchedule.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加任务管理
 */
TaskSchedule.openAddTaskSchedule = function () {
    var index = layer.open({
        type: 2,
        title: '添加任务管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/taskSchedule/taskSchedule_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看任务管理详情
 */
TaskSchedule.openTaskScheduleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '任务管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/taskSchedule/taskSchedule_update/' + TaskSchedule.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除任务管理
 */
TaskSchedule.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/taskSchedule/delete", function (data) {
            Feng.success("删除成功!");
            TaskSchedule.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("taskScheduleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询任务管理列表
 */
TaskSchedule.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TaskSchedule.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TaskSchedule.initColumn();
    var table = new BSTable(TaskSchedule.id, "/taskSchedule/list", defaultColunms);
    table.setPaginationType("client");
    TaskSchedule.table = table.init();
});
