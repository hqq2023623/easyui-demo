<#--菜单栏-->
<div data-options="region:'west',title:'West',split:true" style="width:150px;">
    <ul id="menu">
    </ul>
<#--定义右键菜单-->
    <input type="hidden" id="tempUrl" value=""/>
    <div id="mm" class="easyui-menu" style="width:120px;">
        <div onclick="newTab()">新标签页打开</div>
    </div>

</div>

<script>
    $(function () {
        $('#menu').tree({
            url: '${request.contextPath}/common/menus',
            lines: true,
            animate: true,
            width: 500,
            height: 300,
            onClick: function (node) {
                var url = node.attributes.url;
                var menus = $('#menu').tree('getRoots');
                var menusStr = "";

                $.each(menus, function (i) {
                    var cm = menus[i];
                    if (cm.state == 'open') {
                        menusStr += cm.id + "-";
                    }
                });
                if (url != "") {
                    if (url.indexOf("?") > 0) {
                        window.location.href = "${rc.contextPath}" + url + "&nodes=" + menusStr;
                    } else {
                        window.location.href = "${rc.contextPath}" + url + "?nodes=" + menusStr;
                    }
                } else {
                    if (node.state == 'closed') {
                        $(this).tree('expand', node.target);
                    } else {
                        $(this).tree('collapse', node.target);
                    }
                }
            },
            onContextMenu: function (e, node) {
                e.preventDefault();
                var url = node.attributes.url;
                if (url != "") {//是链接
                    // 查找节点
                    $('#menu').tree('select', node.target);
                    $('#tempUrl').val(node.attributes.url);
                    // 显示快捷菜单
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                }
            }

        });


    });

    //用新标签页打开页面
    function newTab() {
        var url = '${rc.contextPath}' + $('#tempUrl').val();
        window.open(url, '_blank');
    }

</script>


