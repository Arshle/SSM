<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>添加角色</title>
</head>
<body>
    <form action="../params/addrole" method="post">
        <table>
            <tr>
                <td>角色名称</td>
                <td><input id="roleName" name="roleName" value=""/></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input id="note" name="note" value=""/></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</body>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" >
    setInterval(function(){
        $(function(){
            $.ajax({
                url : "../params/findRoleInfo",
                data : {roleData : "datadata"},
                dataType : 'json',
                type : 'POST',
                success : function(data){

                }
            });
        })
    },1000);
</script>
</html>

