<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>网上商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body bgcolor="#FFFFFF" text="#000000" topmargin="2">
<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td background="images/topback.gif" width="130"><img src="images/sitelogo.gif" height="88"></td>
    <td background="images/topback.gif" width="500" align="center" valign="middle"><a href="http://www.fans8.com" target="_blank"><img src="images/fans8.gif" width="468" height="60" border="0"></a> 
    </td>
    <td background="images/topback.gif" width="130"> 
    
<table width="100%" border="0" cellspacing="2" cellpadding="2">
        <tr> 
          <td valign="middle" align="center"><a href="cart.asp"><img src="images/button_cart.gif" width="87" height="18" border="0"></a></td>
        </tr>
        <tr> 
          <td valign="middle" align="center"><a href="checkorder_login.asp"><img src="images/button_ddcx.gif" width="87" height="18" border="0"></a></td>
        </tr>
        <tr> 
          
    <td valign="middle" align="center"><a href="customer_register.asp"><img src="images/button_regist.gif" width="87" height="18" border="0"></a></td>
        </tr>
      </table>
</td>
  </tr>
</table>
<table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
  <tr> 
    <td bgcolor="#FF9900" height="22" valign="middle" align="center">
    
<table width="80%" border="0" cellspacing="2" cellpadding="2">
          <tr align="center" valign="middle"> 
            <td><a href="newproduct.asp" class="white">新品快递</a></td>
            
    <td><a href="commend.asp" class="white">重点推荐</a></td>
            
    <td><a href="bestsell.asp" class="white">销售排行</a></td>
            
    <td><a href="bestprice.asp" class="white">特价商品</a></td>
          </tr>
        </table>
</td>
  </tr>
  <tr> 
    <td bgcolor="#FFCC66" height="22"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>　<a href="default.asp">首页</a> &gt; 定单确认</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td width="1" bgcolor="#000000"></td>
    <td align="center" valign="top" width="758"> 
      <p>&nbsp;</p>
      <span class="productName">${customer.name},您好~！</span><br>
      <form name="form1" method="POST" action="">
        <table width="90%" border="0" cellspacing="2" cellpadding="2">
          <tr bgcolor="#E1E1E1"> 
            <td colspan="3" height="24" class="productName">以下是您所购买的商品</td>
          </tr>
          <tr bgcolor="#999999"> 
            <td colspan="3" height="1"></td>
          </tr>
          <!-- 购物的商品列表开始 -->
          <tr> 
            <td width="50%"><b>商品编号：</b>${ProductID}</td>
            <td colspan="2"><b>商品名称：</b>${ProductName}</td>
          </tr>
          <tr> 
            <td width="50%"><b>单　　价：</b>${Price}元</td>
            <td colspan="2"><b>重　　量：</b>${UnitWeight}公斤</td>
          </tr>
          <tr> 
            <td width="50%"><b>数　　量：</b>${Quantity}</td>
            <td colspan="2">&nbsp;</td>
          </tr>
          <tr> 
            <td colspan="3" height="1" bgcolor="#999999"></td>
          </tr>
          <!-- 购物的商品列表结束 -->
          <tr bgcolor="#E1E1E1" valign="middle"> 
            <td colspan="2">您共购买了${Quantity}个商品，总重为${TotalWeight}公斤，总计费用为：${Total}元。</td>
            <td width="20%" align="center">
            <a href="cart.jsp"><img src="images/updatecart.gif" width="87" height="24" border="0"></a></td>
          </tr>
        </table>
        <br>
        <table width="90%" border="0" cellspacing="2" cellpadding="2">
          <tr bgcolor="#E1E1E1"> 
            <td colspan="3" height="24" class="productName">请认真填写收货人的详细信息（默认为您的注册信息）</td>
          </tr>
          <tr> 
            <td colspan="3" height="1" bgcolor="#999999"></td>
          </tr>
          <tr> 
            <td colspan="2"><b>收货人姓名： 
              <input type="text" name="DeliverName" value="${Name}" class="textbox">
              </b></td>
            <td width="48%"><b>收货人城市： 
              <input type="text" name="DeliverCity" value="${City}" class="textbox">
              </b></td>
          </tr>
          <tr> 
            <td colspan="2"><b>收货人电话： 
              <input type="text" name="DeliverPhone" value="${Phone}" class="textbox">
              </b></td>
            <td width="48%"><b>收货人邮编： 
              <input type="text" name="DeliverZip" value="${Zip}" class="textbox">
              </b></td>
          </tr>
          <tr> 
            <td width="13%"><b>收货人地址： </b></td>
            <td valign="top" colspan="2"><b> 
              <textarea name="DeliverAddres" cols="50" rows="3" class="textbox">${Address}</textarea>
              </b></td>
          </tr>
          <tr> 
            <td valign="top" colspan="2"><b>付款方式： 
              <select name="PayMethodID">
                <!-- 列表选项 -->
                <option value="${PaymethodID}" >${PaymethodName}</option>
                <!-- 列表选项 -->

              </select>
              </b></td>
            <td width="48%"><b>收货方式： 
              <select name="ShippingID">
                <!-- 列表选项 -->
                <option value="${ShippingID}" >${ShipName}</option>
                <!-- 列表选项 -->
                
              </select>
              </b></td>
          </tr>
          <tr> 
            <td colspan="3" height="1" bgcolor="#999999"></td>
          </tr>
          <tr bgcolor="#E1E1E1" align="center" valign="middle"> 
            <td colspan="3" height="25"> 
              <input type="submit" value="提交定单">
              <input type="hidden" name="OrderID" value="${OrderID}">
              <input type="hidden" name="CustomerID" value="${CustomerID}">
            </td>
          </tr>
        </table>
        <input type="hidden" name="MM_insert" value="true">
      </form>
    </td>
    <td width="1" bgcolor="#000000"></td>
  </tr>
</table>
<br>

<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td background="images/topback.gif" align="center" height="16"><font color="#FFFFFF">copyright 
      2001 Powered by Peter.HJ</font></td>
  </tr>
</table>
</body>
</html>
