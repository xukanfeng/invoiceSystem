<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 15/12/27
  Time: 下午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 添加用户</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>SpringMVC 添加用户</h1>
    <hr/>
    <form:form action="/addClientDataPost" method="post" commandName="clientData" role="form">
        <!-- 使用Spring的form标签，可以方便的收集整块数据，commondName=“user”说明form内的内容都保存在这个user实例中 -->
        <!-- 然后将整个user实例传递给controller处理。在所有的input标签中，name一定要与UserEntity中的成员相同，不然无法找到 -->
        <result column="companyName" property="companyName" />
        <result column="shopName" property="shopName" />
        <result column="machineId" property="machineId" />
        <result column="taxpayerId" property="taxpayerId" />
        <result column="companyAddress" property="companyAddress" />
        <result column="phoneNumber" property="phoneNumber" />
        <result column="bankName" property="bankName" />
        <result column="accountName" property="accountName" />
        <result column="isDefault" property="isDefault" />

        <div class="form-group">
            <label for="companyName">公司名称:</label>
            <input type="text" class="form-control" id="companyName" name="companyName" placeholder="请输入公司名称:"/>
        </div>
        <div class="form-group">
            <label for="taxpayerId">纳税人识别号:</label>
            <input type="text" class="form-control" id="taxpayerId" name="taxpayerId" placeholder="请输入纳税人识别号:"/>
        </div>
        <div class="form-group">
            <label for="shopName">店面名称:</label>
            <input type="text" class="form-control" id="shopName" name="shopName" placeholder="请出入店铺名称:"/>
        </div>
        <div class="form-group">
            <label for="machineId">税控机编号:</label>
            <input type="text" class="form-control" id="machineId" name="machineId" placeholder="请输入税控机编号:"/>
        </div>

        <div class="form-group">
            <label for="companyAddress">注册地址:</label>
            <input type="text" class="form-control" id="companyAddress" name="companyAddress" placeholder="请输入公司注册地址:"/>
        </div>
        <div class="form-group">
            <label for="phoneNumber">联系电话:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="请输入联系电话:"/>
        </div>
        <div class="form-group">
            <label for="bankName">开户银行:</label>
            <input type="text" class="form-control" id="bankName" name="bankName" placeholder="请输入开户银行名称:"/>
        </div>
        <div class="form-group">
            <label for="accountName">银行帐号:</label>
            <input type="text" class="form-control" id="accountName" name="accountName" placeholder="请输入银行账户:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
