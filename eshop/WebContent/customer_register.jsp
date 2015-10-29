<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<html>
<head>
<title>网上商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style.css" type="text/css">
<script language="JavaScript">
<!--
function isEmpty(s)
{
return ((s == null) || (s.length == 0))
}
function isWhitespace (s)
{
var whitespace = " \t\n\r";
var i;
// 以下代码判断是否有空字符
for (i = 0; i < s.length; i++)
{
var c = s.charAt(i);
if (whitespace.indexOf(c) >= 0)
{
return true;
}
}

return false;
}
function isCharsInBag (s, bag)
{
var i;
for (i = 0; i < s.length; i++)
{
var c = s.charAt(i);
if (bag.indexOf(c) == -1) return false;
}
return true;
}
function isEmail (s)
{
//判断Email是否为空
if (isEmpty(s))
{
window.alert("输入的E-mail地址不能为空，请输入！");
return false;
}
//判断Email中是否包含空格
if (isWhitespace(s))
{
window.alert("输入的E-mail地址中不能包含空格符，请重新输入！");
return false;
}
//判断Email地址长度
var i = 1;
var len = s.length;
if (len > 100)
{
window.alert("Email地址长度不能超过100位!");
return false;
}
pos1 = s.indexOf("@");
pos2 = s.indexOf(".");
pos3 = s.lastIndexOf("@");
pos4 = s.lastIndexOf(".");
//判断Email地址中是否包含符号 "@" 
if ((pos1 <= 0)||(pos1 == len)||(pos2 <= 0)||(pos2 == len))
{
window.alert("请输入有效的E-mail地址！");
return false;
}
else
{
if( (pos1 == pos2 - 1) || (pos1 == pos2 + 1)
|| ( pos1 != pos3 ) //find two @
|| ( pos4 < pos3 ) ) //. should behind the "@"
{
window.alert("请输入有效的E-mail地址！");
return false;
}
}
if ( !isCharsInBag( s, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@"))
{
window.alert("email地址中只能包含字符ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@\n" + "请重新输入" );
return false;
}
//判断是否包含有效的字符
/*
var badChar = "><,[]{}?/+=|\\"\":;!#$%^&()`";
if ( isCharsInBag( s, badChar))
{
alert("请不要在email地址中输入字符 " + badChar + "\n" );
alert("请重新输入" );
return false;
}
*/
return true;
}
function checkdata() {
if (document.form1.Email.value=="") {
window.alert ("请输入您的E-mail地址 ！")
return false
}
if ( !isEmail(document.form1.Email.value) )
return false
if (document.form1.Pass.value=="") {
window.alert ("请输入您的密码 ！")
return false
}
if (document.form1.Pass.value.length<5) {
window.alert ("您的密码数必须大于4位 ！")
return false
}
if (document.form1.Pass.value.length>10) {
window.alert ("您的密码数必须小于10位 ！")
return false
}
if (document.form1.Comfpass.value=="") {
window.alert ("请输入您的确认密码 ！")
return false
}
if (document.form1.Pass.value!=document.form1. Comfpass.value) {
window.alert ("您的密码不一致 ！")
return false
}
if (document.form1.Pass_question.value=="") {
window.alert ("请输入您取回密码的问题 ！")
return false
}
if (document.form1. Pass_answer.value=="") {
window.alert ("请输入您取回密码的答案！")
return false
}
if (document.form1.Name.value=="") {
window.alert ("请输入您的真实姓名 ！")
return false
}
if (document.form1.City.value=="") {
window.alert ("请输入所在城市 ！")
return false
}
if (document.form1.Address.value=="") {
window.alert ("请输入您的详细地址 ！")
return false
}
if (document.form1.Zip.value=="") {
window.alert ("请输入您的邮编 ！")
return false
}
if (document.form1.Phone.value=="") {
window.alert ("请输入您的电话 ！")
return false
}
return true
}
//-->
</script>
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
    <td bgcolor="#FF9900" height="22" valign="middle" align="center"> <!-- #BeginLibraryItem "/Library/nav.lbi" --><table width="80%" border="0" cellspacing="2" cellpadding="2">
          <tr align="center" valign="middle"> 
            <td><a href="newproduct.asp" class="white">新品快递</a></td>
            
    <td><a href="commend.asp" class="white">重点推荐</a></td>
            
    <td><a href="bestsell.asp" class="white">销售排行</a></td>
            
    <td><a href="bestprice.asp" class="white">特价商品</a></td>
          </tr>
        </table><!-- #EndLibraryItem --></td>
  </tr>
  <tr> 
    <td bgcolor="#FFCC66" height="22"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>　<a href="default.asp" class="red">首页</a> &gt; 新用户注册</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
  <tr> 
    <td bgcolor="#FFFFFF"> 
      <form name="form1" method="POST" action="">
        　　　<img src="images/newregister.gif" width="190" height="30"> <br>
        <span class="productName">　　　　　如果您已经注册， 需要更改注册信息，<a href="cinfoupdate.jsp">请点击这里</a></span> 
        <br>
        <br>
        <table width="80%" border="0" cellspacing="2" cellpadding="2" align="center" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">　以下内容将作为你登录时的凭证，请认真填写！</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">电子邮件：</td>
            <td width="66%"> 
              <input type="text" name="Email" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">密码：</td>
            <td width="66%"> 
              <input type="password" name="Pass" maxlength="10">
              密码需大于4位小于10位</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">确认密码：</td>
            <td width="66%"> 
              <input type="password" name="Comfpass" maxlength="10">
            </td>
          </tr>
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">　以下内容将用于你取回忘记的密码，请牢记～</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">取回密码问题：</td>
            <td width="66%"> 
              <input type="text" name="Pass_question" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">取回密码答案：</td>
            <td width="66%"> 
              <input type="password" name="Pass_answer" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">　请准确填写自己真实的相关信息，以便我们正确的为你提供服务。</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">真实姓名：</td>
            <td width="66%"> 
              <input type="text" name="Name" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">城市：</td>
            <td width="66%"> 
              <input type="text" name="City" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right" height="17">详细地址：</td>
            <td height="17" width="66%"> 
              <textarea name="Address" rows="3" cols="30"></textarea>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">邮编：</td>
            <td width="66%"> 
              <input type="text" name="Zip" maxlength="10">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">电话：</td>
            <td width="66%"> 
              <input type="text" name="Phone" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF" valign="middle"> 
            <td colspan="2" align="center"> 
              <input type="submit" name="Submit" value="注册">
              　　　 
              <input type="reset" name="Submit2" value="重填">
            </td>
          </tr>
        </table>
        <p>&nbsp;</p>
        <input type="hidden" name="MM_insert" value="true">
      </form>
    </td>
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
