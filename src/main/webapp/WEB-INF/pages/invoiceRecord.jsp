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
    <title>开票记录</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="//cdn.bootcss.com/bootstrap-switch/3.3.2/css/bootstrap2/bootstrap-switch.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
    <script type="text/javascript">
        function searchInvoiceRecord() {
            if (document.getElementById("companyNameOrTaxpayerId").value != "") {
                document.getElementById("searchInvoiceRecord").href = "/searchInvoiceRecord?companyNameOrTaxpayerId=" + document.getElementById("companyNameOrTaxpayerId").value;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h2>开票记录</h2>
    <hr/>
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/invoice">开发票</a></li>
        <li role="presentation"><a href="/clientData">用户管理</a></li>
        <li role="presentation" class="active"><a href="/invoiceRecord">开票记录</a></li>
        <li role="presentation"><a href="/taxcontrolSetting">税控设置</a></li>
    </ul>

    <br />
    <div class="row">
        <div class="col-md-6">
            <input type="text" class="form-control input-sm" id="companyNameOrTaxpayerId" name="companyNameOrTaxpayerId" placeholder="请输入用户企业名称或者纳税人识别号">
        </div>
        <div class="col-md-6">
            <a href="#" type="button" id="searchInvoiceRecord" class="btn btn-default btn-sm" onclick="searchInvoiceRecord()">查询</a>
            <!--
            <a href="/addInvoiceRecord" type="button" class="btn btn-success btn-sm">新增</a>
            -->
        </div>
    </div>
    <br />

    <!-- 如果用户列表为空 -->
    <!-- <c>标签：在jsp中使用了jstl语法，可以方便地进行一些判断 c:if 与遍历操作 c:forEach -->
    <c:if test="${empty invoiceRecordList}">
        <p class="bg-warning">
            <br/>
            开票记录为空
            <br/>
            <br/>
        </p>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty invoiceRecordList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>编号</th>
                <th>店面名称</th>
                <th>微信号</th>
                <th>开票时间</th>
                <th>开票内容</th>
                <th>数量</th>
                <th>单价</th>
                <th>金额(不含税)</th>
                <th>税率</th>
                <th>税额</th>
                <th>价税合计</th>
                <th>开票状态</th>
            </tr>

            <c:forEach items="${invoiceRecordList}" var="invoiceRecord" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>
                        <a title="详细信息"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-html="true"
                           data-content="税控机编号:${invoiceRecord.machineId}<br />
                                         公司名称:${invoiceRecord.companyName}<br />
                                         纳税人识别号:${invoiceRecord.taxpayerId}">
                                ${invoiceRecord.shopName}
                        </a>
                    </td>
                    <td>${invoiceRecord.wechatId}</td>
                    <td>${invoiceRecord.invoiceDate}</td>
                    <td>${invoiceRecord.invoiceContent}</td>
                    <td>${invoiceRecord.amount}</td>
                    <td>${invoiceRecord.unitPrice}</td>
                    <td>${invoiceRecord.totalPriceWithoutTax}</td>
                    <td>${invoiceRecord.taxRate}</td>
                    <td>${invoiceRecord.taxPrice}</td>
                    <td>${invoiceRecord.totalPrice}</td>
                    <td>
                        <div class="switch switch-mini" data-on-label="<i class='icon-ok icon-white'></i>" data-off-label="<i class='icon-remove'></i>">
                            <c:choose>
                                <c:when test="${invoiceRecord.status == 1}">
                                    <input type="checkbox" name="checkbox" checked />
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="checkbox"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="../../invoiceSystem/js/bootstrap-switch.js"></script>
<script type="text/javascript">
    $(function () {
        $("[name='checkbox']").bootstrapSwitch();
        $("[data-toggle='popover']").each(function() {
            $(this).popover({
                trigger: 'manual',
            }).on("mouseenter", function() {
                $(this).popover("show");
            }).on("mouseleave", function() {
                $(this).popover("hide");
            });
        });
    })
</script>
</body>
</html>
