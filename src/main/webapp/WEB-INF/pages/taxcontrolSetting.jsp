<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 15/12/27
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>税控基础设置</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="//cdn.bootcss.com/bootstrap-switch/3.3.2/css/bootstrap2/bootstrap-switch.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h2>税控基础设置</h2>
    <hr/>
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/invoice">开发票</a></li>
        <li role="presentation"><a href="/clientData">用户管理</a></li>
        <li role="presentation"><a href="/invoiceRecord">开票记录</a></li>
        <li role="presentation" class="active"><a href="/taxcontrolSetting">税控设置</a></li>
    </ul>
    <c:forEach items="${taxcontrolSettingList}" var="taxcontrolSetting" varStatus="status">
        <c:if test="${taxcontrolSetting.isDefault == 1}">
    <div class="default_setting">
        <h4>当前默认开票设置</h4>
        <p>企业名称:&nbsp${taxcontrolSetting.companyName}</p>
        <p>识&nbsp&nbsp别&nbsp&nbsp号:&nbsp${taxcontrolSetting.taxpayerId}</p>
        <p>注册地址:&nbsp${taxcontrolSetting.companyAddress}</p>
        <p>联系电话:&nbsp${taxcontrolSetting.phoneNumber}</p>
        <p>开户银行:&nbsp${taxcontrolSetting.bankName}</p>
        <p>银行帐号:&nbsp${taxcontrolSetting.accountName}</p>
    </div>
        </c:if>
    </c:forEach>

    <br />
    <form:form action="/searchTaxcontrolSetting" method="post" commandName="taxcontrolSetting" role="form">
        <div class="row">
            <div class="col-md-6">
                <input type="text" class="form-control input-sm" id="companyNameOrTaxpayerId" name="companyNameOrTaxpayerId" placeholder="请输入用户企业名称或者纳税人识别号">
            </div>
            <div class="col-md-6">
                <a href="/searchTaxcontrolSetting" type="button" class="btn btn-default btn-sm">查询</a>
                <a href="/addTaxcontrolSetting" type="button" class="btn btn-success btn-sm">新增</a>
            </div>
        </div>
    </form:form>
    <br />

    <!-- 如果用户列表为空 -->
    <!-- <c>标签：在jsp中使用了jstl语法，可以方便地进行一些判断 c:if 与遍历操作 c:forEach -->
    <div class="table-responsive">
    <c:if test="${empty taxcontrolSettingList}">
        <p class="bg-warning">
            <br/>
            税控基础设置为空
            <br/>
            <br/>
        </p>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty taxcontrolSettingList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>编号</th>
                <th>企业名称</th>
                <th>店面名称</th>
                <th>税控机编号</th>
                <th>纳税人识别号</th>
                <th>设为默认</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${taxcontrolSettingList}" var="taxcontrolSetting" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>
                        <a title="公司详细信息"
                                data-container="body" data-toggle="popover" data-placement="right"
                                data-html="true"
                                data-content="注册地址:${taxcontrolSetting.companyAddress}<br />
                                              联系电话:${taxcontrolSetting.phoneNumber}<br />
                                              开户银行:${taxcontrolSetting.bankName}<br />
                                              银行帐号:${taxcontrolSetting.accountName}">
                                ${taxcontrolSetting.companyName}
                        </a>
                    </td>
                    <td>${taxcontrolSetting.shopName}</td>
                    <td>${taxcontrolSetting.machineId}</td>
                    <td>${taxcontrolSetting.taxpayerId}</td>
                    <td>
                        <div class="switch switch-mini" data-on-label="<i class='icon-ok icon-white'></i>" data-off-label="<i class='icon-remove'></i>">
                        <c:choose>
                            <c:when test="${taxcontrolSetting.isDefault == 1}">
                                <input type="checkbox" name="checkbox" checked />
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                        </div>
                    </td>
                    <td>
                        <a href="/deleteTaxcontrolSetting/${taxcontrolSetting.shopName}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="../../invoiceSystem/js/bootstrap-switch.js"></script>
<script type="text/javascript">
    $(function () {
        $("[name='checkbox']").bootstrapSwitch();
        $("[data-toggle='popover']").popover()({

        });
    })
</script>
</body>
</html>