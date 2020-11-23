<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <style>
        body {
            font-family: SimHei;
        }
        .pageNext{
            page-break-after: always;
        }
    </style>
</head>
<body>
<#list list as user>
    用户名：${user.username}<br/>
    密码：${user.password}<br/>
</#list>
</body>
</html>