<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 16/1/24
  Time: 下午5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>开发票</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        window.onload = function(){
            document.getElementById("content").focus();
        }
        function toDecimal2(x) {
            var f = parseFloat(x);
            if (isNaN(f)) {
                return false;
            }
            var f = Math.round(x*100)/100;
            var s = f.toString();
            var rs = s.indexOf('.');
            if (rs < 0) {
                rs = s.length;
                s += '.';
            }
            while (s.length <= rs + 2) {
                s += '0';
            }
            return s;
        }
        function calculatePrice() {
            var totalPriceWithoutTax = document.getElementById("amount").value * document.getElementById("unitPrice").value;
            document.getElementById("totalPriceWithoutTax").value = toDecimal2(totalPriceWithoutTax);
            if(document.getElementById("taxRate").value == "17%"){
                document.getElementById("taxPrice").value = toDecimal2(totalPriceWithoutTax * 0.17);
            }
            else{
                document.getElementById("taxPrice").value = toDecimal2(totalPriceWithoutTax * 0.06);
            }

        }
    </script>
</head>
<style>
    .invoiceBackground{
        margin-left: 100px;
        margin-right: 10%;
        width:800px;
        height: 100%;
        background:url(../../invoiceSystem/images/invoice_template.jpg);
        background-size: 100%;
        background-repeat: no-repeat;
    }
    .clientData{
        margin-top: 100px;
        margin-left: 176px;
        height: 68px;
        width: 260px;
        float: left;
    }
    .clientDataInput{
        height: 16px;
        width: 260px;
        margin: 1px;
        padding: 0px;
        font-size: 10px;
        float: left;
    }
    .invoiceContent{
        margin-top: 20px;
        margin-left: 68px;
    }
    .column1{
        width: 170px;
        height: 16px;
        margin-left: 2px;
        margin-right: 2px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .column2{
        width: 82px;
        height: 16px;
        margin-left: 0px;
        margin-right: 2px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .column3{
        width: 40px;
        height: 16px;
        margin-left: 1px;
        margin-right: 1px;
        text-align: left;
        font-size: 10px;
        float: left;
    }
    .column4{
        width: 65px;
        height: 16px;
        margin-left: 1px;
        margin-right: 1px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .column5{
        width: 65px;
        height: 16px;
        margin-left: 1px;
        margin-right: 1px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .column6{
        width: 98px;
        height: 16px;
        margin-left: 1px;
        margin-right: 0px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .column7{
        width: 40px;
        height: 12px;
        margin-left: 0px;
        margin-right: 0px;
        padding-left: -2px;
        display: inline;
        text-align: left;
        font-size: 5px;
        float: left;
    }
    .column8{
        width: 95px;
        height: 16px;
        margin-left: 0px;
        margin-right: 0px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .priceSum{
        margin-top: 400px;
        font-size: 10px;
    }
    .taxSum{
        margin-top: 400px;
        font-size: 10px;
    }
    .sum{
        margin-top: 400px;
        font-size: 10px;
    }
    .confirm{
        margin-top: 280px;
    }
    .clear{
        clear:both;
        margin-left: 2px;
        margin-right: 2px;
    }
</style>
<body>
<div class="container">
    <div>
        <h2>开发票</h2>
        <hr/>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="/invoice">开发票</a></li>
            <li role="presentation"><a href="/clientData">用户管理</a></li>
            <li role="presentation"><a href="/invoiceRecord">开票记录</a></li>
            <li role="presentation"><a href="/taxcontrolSetting">税控设置</a></li>
        </ul>
        <div align="center">
        <div class="invoiceBackground">
            <form:form action="/doInvoice" method="post" commandName="client" role="form">
            <c:if test="${!empty clientData}">
                <div class="clientData">
                    <input type="text" class="clientDataInput" id="companyName" value=${clientData.companyName}>
                    <input type="text" class="clientDataInput" id="taxpayerId" value=${clientData.taxpayerId}>
                    <input type="text" class="clientDataInput" id="companyAddressAndphoneNumber" value=${clientData.companyAddress} + ${clientData.phoneNumber}>
                    <input type="text" class="clientDataInput" id="bankNameAndaccountName" value=${clientData.bankName} + ${clientData.accountName}>
                </div>
            </c:if>
            <div class="clear"></div>
            <div class="invoiceContent">
                        <input type="text" class="column1" id="content" placeholder="货物或应税劳务名称"/>
                        <input type="text" class="column2" id="model" placeholder="规格型号"/>
                        <select class="column3" id="unit">
                            <option value="个">个</option>
                            <option value="件">件</option>
                            <option value="套" selected="selected">套</option>
                        </select>
                        <input type="text" class="column4" id="amount" placeholder="数量" onblur="calculatePrice()"/>
                        <input type="text" class="column5" id="unitPrice" placeholder="单价" onblur="calculatePrice()"/>
                        <input type="text" class="column6" id="totalPriceWithoutTax" readonly="readonly" placeholder="金额"/>
                        <select class="column7" id="taxRate" onchange="calculatePrice()">
                            <option value="6%">6%</option>
                            <option value="17%" selected="selected">17%</option>
                        </select>
                        <input type="text" class="column8" id="taxPrice" readonly="readonly" placeholder="税额"/>
            </div>
                <!--
            <div class="priceSum">
                <input type="number" readonly="readonly" id="priceSum"/>
            </div>
            <div class="taxSum">
                <input type="number" readonly="readonly" id="taxSum"/>
            </div>
            <div class="sum">
                <input type="number" readonly="readonly" id="sum"/>
            </div>
            -->
                <div class="confirm">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-success btn-sm btn-block">确定</button>
                    </div>
                    <div class="col-md-4"></div>
                </div>

            </form:form>
        </div>
        </div>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>