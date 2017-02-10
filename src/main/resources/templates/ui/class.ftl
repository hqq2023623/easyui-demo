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

<div>

</div>

<#--中间列表栏-->
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div class="easyui-layout" data-options="fit:true">

        <div data-options="region:'center'">
            <div id="p" style="padding:10px;">
                <p>panel content.</p>
                <p>panel content.</p>
            </div>
        </div>

    </div>
</div>

</body>

<script type="text/javascript">
    $(function () {
        $('#p').panel({
            width: 500,
            height: 150,
            title: 'My Panel',
            tools: [{
                iconCls: 'icon-add',
                handler: function () {
                    alert('new')
                }
            }, {
                iconCls: 'icon-save',
                handler: function () {
                    console.log('save');
                }
            }]
        });

    });


</script>

</html>