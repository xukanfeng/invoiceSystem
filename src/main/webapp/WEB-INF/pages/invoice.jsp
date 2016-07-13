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
            document.getElementById("cCompanyName").focus();
        }
//        document.addEventListener("DOMContentLoaded", function(){
//              document.body.style.display = "block";
//        });
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
            document.getElementById("priceSum").value = document.getElementById("totalPriceWithoutTax").value;
            document.getElementById("taxSum").value = document.getElementById("taxPrice").value;
            //document.getElementById("sum").value = document.getElementById("priceSum").value + document.getElementById("taxSum").value;
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
    .invoiceHeader{
        margin-top: 100px;
        margin-left: 176px;
        height: 68px;
        width: 260px;
        float: left;
    }
    .invoiceHeaderInput{
        height: 16px;
        width: 260px;
        margin: 1px;
        padding: 0px;
        font-size: 10px;
        float: left;
    }
    .invoiceContent{
        height: 150px;
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
    .padding{
        height: 45px;
    }
    .sum{
        height: 16px;
        margin-top: 48px;
        float: left;
    }
    .priceSum{
        width: 95px;
        height: 16px;
        margin-left: 436px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .taxSum{
        width: 94px;
        height: 16px;
        margin-left: 40px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .priceAndTaxSum{
        margin-top: 8px;
        height: 16px;
        float: left;
    }
    .chineseNumerals{
        width: 280px;
        height: 16px;
        margin-left: 180px;
        text-align: left;
        font-size: 10px;
        float: left;
    }
    .arabicNumerals{
        width: 100px;
        height: 16px;
        margin-left: 80px;
        text-align: left;
        font-size: 10px;
        float: left;
    }
    .invoiceFooter{
        margin-top: 7px;
        height: 68px;
    }
    .leftFooter{
        height: 68px;
        margin-left: 178px;
        width: 268px;
        float: left;
    }
    .rightFooter{
        height: 63px;
        width: 250px;
        float: left;
    }
    .invoiceFooterInput{
        height: 16px;
        width: 260px;
        margin: 0px;
        padding: 0px;
        font-size: 10px;
        float: left;
    }
    .comment{
        height: 63px;
        width: 230px;
        margin-left: 30px;
        padding: 0px;
        font-size: 10px;
    }
    .footer{
        margin-top: -2px;
        height: 16px;
        float: left;
    }
    .receiver{
        width: 130px;
        height: 16px;
        margin-left: 130px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .reviewer{
        width: 105px;
        height: 16px;
        margin-left: 40px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .drawer{
        width: 78px;
        height: 16px;
        margin-left: 52px;
        text-align: right;
        font-size: 10px;
        float: left;
    }
    .confirm{
        margin-top: 45px;
    }
    .clear{
        clear:both;
        margin-left: 2px;
        margin-right: 2px;
    }
</style>
<body>
<div class="container">
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
            <form:form action="/invoicePost" method="post" commandName="invoiceData" role="form">
                <div class="invoiceHeader">
                    <input type="text" class="invoiceHeaderInput" id="cCompanyName" value="wewefw">
                    <input type="text" class="invoiceHeaderInput" id="cTaxpayerId" value="efef">
                    <input type="text" class="invoiceHeaderInput" id="cCompanyAddressAndPhoneNumber" value="wefwe">
                    <input type="text" class="invoiceHeaderInput" id="cBankNameAndAccountName" value="weg">
                </div>
                <div class="clear"></div>
                <div class="invoiceContent">
                    <div item1>
                        <input type="text" class="column1" id="content1" placeholder="货物或应税劳务名称"/>
                        <input type="text" class="column2" id="model1" placeholder="规格型号"/>
                        <select class="column3" id="unit1">
                            <option value="个">个</option>
                            <option value="件">件</option>
                            <option value="套" selected="selected">套</option>
                        </select>
                        <input type="text" class="column4" id="amount1" placeholder="数量" onblur="calculatePrice()"/>
                        <input type="text" class="column5" id="unitPrice1" placeholder="单价" onblur="calculatePrice()"/>
                        <input type="text" class="column6" id="totalPriceWithoutTax1" readonly="readonly" placeholder="金额"/>
                        <select class="column7" id="taxRate1" onchange="calculatePrice()">
                            <option value="6%">6%</option>
                            <option value="17%" selected="selected">17%</option>
                        </select>
                        <input type="text" class="column8" id="taxPrice1" readonly="readonly" placeholder="税额"/>
                    </div>
                    <div item2>
                        <input type="text" class="column1" id="content2" placeholder="货物或应税劳务名称"/>
                        <input type="text" class="column2" id="model2" placeholder="规格型号"/>
                        <select class="column3" id="unit2">
                            <option value="个">个</option>
                            <option value="件">件</option>
                            <option value="套" selected="selected">套</option>
                        </select>
                        <input type="text" class="column4" id="amount2" placeholder="数量" onblur="calculatePrice()"/>
                        <input type="text" class="column5" id="unitPrice2" placeholder="单价" onblur="calculatePrice()"/>
                        <input type="text" class="column6" id="totalPriceWithoutTax2" readonly="readonly" placeholder="金额"/>
                        <select class="column7" id="taxRate2" onchange="calculatePrice()">
                            <option value="6%">6%</option>
                            <option value="17%" selected="selected">17%</option>
                        </select>
                        <input type="text" class="column8" id="taxPrice2" readonly="readonly" placeholder="税额"/>
                    </div>
                    <div item3>
                        <input type="text" class="column1" id="content3" placeholder="货物或应税劳务名称"/>
                        <input type="text" class="column2" id="model3" placeholder="规格型号"/>
                        <select class="column3" id="unit3">
                            <option value="个">个</option>
                            <option value="件">件</option>
                            <option value="套" selected="selected">套</option>
                        </select>
                        <input type="text" class="column4" id="amount3" placeholder="数量" onblur="calculatePrice()"/>
                        <input type="text" class="column5" id="unitPrice3" placeholder="单价" onblur="calculatePrice()"/>
                        <input type="text" class="column6" id="totalPriceWithoutTax3" readonly="readonly" placeholder="金额"/>
                        <select class="column7" id="taxRate3" onchange="calculatePrice()">
                            <option value="6%">6%</option>
                            <option value="17%" selected="selected">17%</option>
                        </select>
                        <input type="text" class="column8" id="taxPrice3" readonly="readonly" placeholder="税额"/>
                    </div>
                    <div item4>
                        <input type="text" class="column1" id="content4" placeholder="货物或应税劳务名称"/>
                        <input type="text" class="column2" id="model4" placeholder="规格型号"/>
                        <select class="column3" id="unit4">
                            <option value="个">个</option>
                            <option value="件">件</option>
                            <option value="套" selected="selected">套</option>
                        </select>
                        <input type="text" class="column4" id="amount4" placeholder="数量" onblur="calculatePrice()"/>
                        <input type="text" class="column5" id="unitPrice4" placeholder="单价" onblur="calculatePrice()"/>
                        <input type="text" class="column6" id="totalPriceWithoutTax4" readonly="readonly" placeholder="金额"/>
                        <select class="column7" id="taxRate4" onchange="calculatePrice()">
                            <option value="6%">6%</option>
                            <option value="17%" selected="selected">17%</option>
                        </select>
                        <input type="text" class="column8" id="taxPrice4" readonly="readonly" placeholder="税额"/>
                    </div>
                    <div class="sum">
                        <input type="text" class="priceSum" readonly="readonly" id="priceSum"/>
                        <input type="text" class="taxSum" readonly="readonly" id="taxSum"/>
                    </div>
                    <div class="priceAndTaxSum">
                        <input type="text" class="chineseNumerals" readonly="readonly" id="chineseNumeralsSum"/>
                        <input type="text" class="arabicNumerals" readonly="readonly" id="arabicNumeralsSum"/>
                    </div>
                </div>
                <div class="clear"></div>

                <c:if test="${!empty taxcontrolSetting}">
                    <div class="invoiceFooter">
                        <div class="leftFooter">
                            <input type="text" class="invoiceFooterInput" id="_companyName" readonly="readonly" value=${taxcontrolSetting.companyName}>
                            <input type="text" class="invoiceFooterInput" id="_taxpayerId" readonly="readonly" value=${taxcontrolSetting.taxpayerId}>
                            <input type="text" class="invoiceFooterInput" id="_companyAddressAndPhoneNumber" readonly="readonly" value="${taxcontrolSetting.companyAddress} ${taxcontrolSetting.phoneNumber}">
                            <input type="text" class="invoiceFooterInput" id="_bankNameAndAccountName" readonly="readonly" value="${taxcontrolSetting.bankName} ${taxcontrolSetting.accountName}">
                        </div>
                        <div class="rightFooter">
                            <input type="text" class="comment"/>
                        </div>
                    </div>
                </c:if>
                <div class="footer">
                    <input type="text" class="receiver"/>
                    <input type="text" class="reviewer"/>
                    <input type="text" class="drawer"/>
                </div>
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>