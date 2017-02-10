<html>

<head>
    <title>用户列表</title>
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
            <form id="searchForm" method="post">
                <div class="searchParamRoot">
                    <div class="searchParam">
                        <label>用户ID:</label>
                        <input type="text" name="userId"/>
                    </div>

                    <div class="searchParam">
                        <label>combobox:</label>
                        <input id="userName" name="userName"/>
                    </div>

                    <div class="searchParam">
                        <label>创建时间:</label>
                        <input id="createTime" name="createTime"/>
                    </div>

                </div>

                <div class="searchBtn">
                    <a id="searchBtn" href="javascript:;" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'">查询</a>
                    <a id="clearBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
                    <a id="exportBtn" href="javascript:;" class="easyui-linkbutton"
                       data-options="iconCls:'icon-reload'">导出查询结果</a>
                </div>

            </form>
        </div>

        <div data-options="region:'center'">
            <div id="contentGrid"></div>
        </div>

    </div>
</div>


<#--点击名称弹出对话框-->
<div id="nameDialog">
    <div style="margin-top:50px;margin-left:50px;">
        <input type="hidden" id="editId"/>
        name : <input type="text" id="editName" name="name"/>
    </div>


</div>

</body>

<script type="text/javascript">
    $(function () {

        function init() {
            //列表
            $('#contentGrid').datagrid({
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
                    {field: 'id', title: '用户ID', width: 20, align: 'center'},
                    {
                        field: 'name', title: '用户名', width: 20, align: 'center',
                        formatter: function (value, row, index) {
                            var redName = "<a class='nameDialog' href='javascript:void(0)' onclick='nameDialog(" + JSON.stringify(row) + ")'>" + row.name + "</a>";
                            return redName;
                        }
                    },
                ]],
                toolbar: [{
                    id: '_add',
                    text: '新增',
                    iconCls: 'icon-add',
                    handler: function () {
                        console.log("点击新增按钮");
                    }
                }],
                pagination: true,
                onLoadSuccess: function () {
                    //给name添加点击弹窗事件 , 事件顺序颠倒了, 先执行了点击事件才发生 selected
//                    $("a.nameDialog").click(function () {
//                        console.log($("#contentGrid").datagrid('getSelected'));
//                    });
                }
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

            //日期
            $("#createTime").datetimebox({});


            //按钮事件
            //点击查询按钮
            $("#searchBtn").click(function () {
                $("#contentGrid").datagrid('load', getSubmitParam());
            });

            //获取提交的参数
            function getSubmitParam() {
                var userName = $("#userName").combobox('getValue');
                return param;
            }

            //点击导出按钮
            $("#exportBtn").click(function () {
                $('#searchForm').submit();
            });

            //清空输入框
            $("#clearBtn").click(function () {
                //jquery没有reset方法,先转为js对象
                $("#searchForm")[0].reset();
                $("#userName").combobox('select', '请选择');
                $("#userName").combobox('clear');
            });

            //弹出框
            $('#nameDialog').dialog({
                title: "编辑",
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
                            $.post("${request.contextPath}/user/save",{id : $("#editId").val(),name:$("#editName").val()},function (data) {
                                $.messager.alert("result",data.msg);
                            });
                            $("#contentGrid").datagrid("load");
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
            $("#editName").val(row.name);
            $("#editId").val(row.id);
            $("#nameDialog").dialog('open');
        }
    }

</script>

</html>