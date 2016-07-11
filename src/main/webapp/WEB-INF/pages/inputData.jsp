<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 15/12/27
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>开票信息</title>
    <link rel="stylesheet" href="../../invoiceSystem/css/weui.css"/>
    <script type="text/javascript">
        window.onload = function(){
            document.getElementById("companyNameInput").focus();
        }
        function verifyCompanyName() {
            //var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            var reg = /(^[\u4e00-\u9fa5]{2,100}$)|(^[a-zA-Z]{2,100}$)/;
            if (reg.test(document.getElementById("companyNameInput").value) === false) {
                document.getElementById("companyName").setAttribute("class", "weui_cell weui_cell_warn");
                document.getElementById("companyNameWarning").style.visibility = "visible";
                document.getElementById("companyNameInput").focus();
            }
            else{
                document.getElementById("companyName").setAttribute("class", "weui_cell");
                document.getElementById("companyNameWarning").style.visibility = "hidden";
            }
        }
        function verifyTaxpayerId() {
            var reg = /(^([0-9]|L|l|X|x){15}$)|(^([0-9]|L|l|X|x){18}$)|(^([0-9]|L|l|X|x){20}$)/;
            //var reg = /(^[\u4e00-\u9fa5]{2,100}$)|(^[a-zA-Z]{2,100}$)/;
            if (reg.test(document.getElementById("taxpayerIdInput").value) === false) {
                document.getElementById("taxpayerId").setAttribute("class", "weui_cell weui_cell_warn");
                document.getElementById("taxpayerIdWarning").style.visibility = "visible";
                document.getElementById("taxpayerIdInput").focus();
            }
            else{
                document.getElementById("taxpayerId").setAttribute("class", "weui_cell");
                document.getElementById("taxpayerIdWarning").style.visibility = "hidden";
            }
        }
    </script>
</head>
<body>
    <div class="hd">
        <h1 class="page_title" align="center">开票通</h1>
    </div>
    <form:form action="/generateQRcode" method="post" commandName="clientData" role="form">
        <div class="weui_cells weui_cells_form">
            <div id="companyName" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">企业名称</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" onblur="verifyCompanyName()" id="companyNameInput" name="companyNameInput" placeholder="营业执照上的法定名称"/>
                </div>
                <div class="weui_cell_ft">
                    <i id="companyNameWarning" class="weui_icon_warn" style="visibility:hidden"></i>
                </div>
            </div>
            <!--
            <div class="weui_cell weui_cell_warn">
                <div class="weui_cell_hd"><label for="" class="weui_label">卡号</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="number" pattern="[0-9]*" value="weui input error" placeholder="请输入卡号"/>
                </div>
                <div class="weui_cell_ft">
                    <i class="weui_icon_warn"></i>
                </div>
            </div>
-->
            <div id="taxpayerId" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">识别号</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" onblur="verifyTaxpayerId()" id="taxpayerIdInput" name="taxpayerIdInput" placeholder="纳税人识别号"/>
                </div>
                <div class="weui_cell_ft">
                    <i id="taxpayerIdWarning" class="weui_icon_warn" style="visibility:hidden"></i>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">注册地址</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" onfocus="" id="companyAddress" name="companyAddress" placeholder="公司注册地址"/>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">联系电话</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="phoneNumber" name=phoneNumber" placeholder="区号-总机"/>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">开户银行</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="bankName" name="bankName" placeholder="对外付款的开户行"/>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">银行帐号</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="accountName" name="accountName" placeholder="对外付款的银行帐号"/>
                </div>
            </div>
        </div>
        <div class="weui_btn_area">
            <button type="submit" class="weui_btn weui_btn_primary">保存</button>
        </div>

    </form:form>

<script type="text/javascript">
    $(function() {


    });
</script>
</body>
</html>