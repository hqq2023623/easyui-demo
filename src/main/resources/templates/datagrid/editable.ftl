<html>

<head>
    <title>可编辑的datagrid</title>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/easyui/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/easyui/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${reqeust.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${reqeust.contextPath}/easyui/jquery.easyui.min.js"></script>

</head>

<body class="easyui-layout">
<#include "common/menu.ftl" />

<#--中间列表栏-->
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div class="easyui-layout" data-options="fit:true">

        <div data-options="region:'north',title:'north',split:true">
        </div>

        <div data-options="region:'center'">
            <div id="contentGrid"></div>
        </div>

    </div>
</div>


<#--点击名称弹出对话框-->
<div id="nameDialog">
    <h1>nameDialog</h1>
</div>

</body>

<script type="text/javascript">
    $(function () {

        function init() {
            var datagrid; //定义全局变量datagrid
            var editRow = undefined; //定义全局变量：当前编辑的行
            //列表
            datagrid = $('#contentGrid').datagrid({
                nowrap: false,
                striped: true,
                collapsible: true,
                idField: 'id',
                url: '${request.contextPath}/user/list/json',
                loadMsg: '正在装载数据...',
                queryParams: {},
                singleSelect: true,
                fitColumns: true,
                remoteSort: true,
                pageSize: 50,
                columns: [[
                    {
                        field: 'id',
                        title: '用户ID',
                        width: 20,
                        align: 'center',
                        editor: {
                            type: 'validatebox'
                        },
                        options: {
                            required: true
                        }
                    },
                    {
                        field: 'name', title: '用户名', width: 20, align: 'center',
                        formatter: function (value, row, index) {
                            var redName = "<a class='nameDialog' href='javascript:void(0)' onclick='nameDialog(" + JSON.stringify(row) + ")'>" + row.name + "</a>";
                            return redName;
                        }
                    },
                ]],

                pagination: true,
                onLoadSuccess: function () {
                    //给name添加点击弹窗事件 , 事件顺序颠倒了, 先执行了点击事件才发生 selected
//                    $("a.nameDialog").click(function () {
//                        console.log($("#contentGrid").datagrid('getSelected'));
//                    });
                },
                onAfterEdit: function (rowIndex, rowData, changes) {
                    //endEdit该方法触发此事件
                    editRow = undefined;
                },
                toolbar: [
                    {
                        id: '_edit',
                        text: '编辑',
                        iconCls: 'icon-edit',
                        handler: function () {
                            //修改时要获取选择到的行
                            var rows = datagrid.datagrid("getSelections");
                            //如果只选择了一行则可以进行修改，否则不操作
                            if (rows.length == 1) {
                                //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                                if (editRow != undefined) {
                                    datagrid.datagrid("endEdit", editRow);
                                }
                                //当无编辑行时
                                if (editRow == undefined) {
                                    //获取到当前选择行的下标
                                    var index = datagrid.datagrid("getRowIndex", rows[0]);
                                    //开启编辑
                                    datagrid.datagrid("beginEdit", index);
                                    //把当前开启编辑的行赋值给全局变量editRow
                                    editRow = index;
                                    //当开启了当前选择行的编辑状态之后，
                                    //应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
                                    datagrid.datagrid("unselectAll");
                                }
                            }
                        }
                    }, '-',
                    {
                        text: '保存', iconCls: 'icon-save',
                        handler: function () {
                            //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                            datagrid.datagrid("endEdit", editRow);
                        }
                    }, '-',
                    {
                        text: '取消编辑', iconCls: 'icon-redo',
                        handler: function () {
                            //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                            editRow = undefined;
                            datagrid.datagrid("rejectChanges");
                            datagrid.datagrid("unselectAll");
                        }
                    }
                ]
            });

            //combobox
            $("#userName").combobox({
                mode: 'remote',
                url: '${rc.contextPath}/user/combobox',
                valueField: 'id',
                textField: 'name',
                editable: true
            });
//            $("#userName").combobox('setValue',1);
            $("#userName").combobox('select', '请选择');


            //弹出框
            $('#nameDialog').dialog({
                title: "nameDialog",
                height: 300,
                width: 400,
                collapsible: true,
                closed: true,
                modal: true,
                resizable: true,
                buttons: [
                    {
                        text: '保存',
                        iconCls: 'icon-ok',
                        handler: function () {
                            console.log('点击保存');
                        }
                    },
                    {
                        text: '取消',
                        align: 'left',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#nameDialog').dialog('close');
                        }
                    }]
            });

        }

        init();

    });

    //点击名称弹出对话框
    function nameDialog(row) {
        if (row) {
            console.log(row);
            $("#nameDialog").dialog('open');
        }
    }

</script>

</html>