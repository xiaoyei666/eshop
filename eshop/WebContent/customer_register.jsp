<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<html>
<head>
<title>�����̳�</title>
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
// ���´����ж��Ƿ��п��ַ�
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
//�ж�Email�Ƿ�Ϊ��
if (isEmpty(s))
{
window.alert("�����E-mail��ַ����Ϊ�գ������룡");
return false;
}
//�ж�Email���Ƿ�����ո�
if (isWhitespace(s))
{
window.alert("�����E-mail��ַ�в��ܰ����ո�������������룡");
return false;
}
//�ж�Email��ַ����
var i = 1;
var len = s.length;
if (len > 100)
{
window.alert("Email��ַ���Ȳ��ܳ���100λ!");
return false;
}
pos1 = s.indexOf("@");
pos2 = s.indexOf(".");
pos3 = s.lastIndexOf("@");
pos4 = s.lastIndexOf(".");
//�ж�Email��ַ���Ƿ�������� "@" 
if ((pos1 <= 0)||(pos1 == len)||(pos2 <= 0)||(pos2 == len))
{
window.alert("��������Ч��E-mail��ַ��");
return false;
}
else
{
if( (pos1 == pos2 - 1) || (pos1 == pos2 + 1)
|| ( pos1 != pos3 ) //find two @
|| ( pos4 < pos3 ) ) //. should behind the "@"
{
window.alert("��������Ч��E-mail��ַ��");
return false;
}
}
if ( !isCharsInBag( s, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@"))
{
window.alert("email��ַ��ֻ�ܰ����ַ�ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@\n" + "����������" );
return false;
}
//�ж��Ƿ������Ч���ַ�
/*
var badChar = "><,[]{}?/+=|\\"\":;!#$%^&()`";
if ( isCharsInBag( s, badChar))
{
alert("�벻Ҫ��email��ַ�������ַ� " + badChar + "\n" );
alert("����������" );
return false;
}
*/
return true;
}
function checkdata() {
if (document.form1.Email.value=="") {
window.alert ("����������E-mail��ַ ��")
return false
}
if ( !isEmail(document.form1.Email.value) )
return false
if (document.form1.Pass.value=="") {
window.alert ("�������������� ��")
return false
}
if (document.form1.Pass.value.length<5) {
window.alert ("�����������������4λ ��")
return false
}
if (document.form1.Pass.value.length>10) {
window.alert ("��������������С��10λ ��")
return false
}
if (document.form1.Comfpass.value=="") {
window.alert ("����������ȷ������ ��")
return false
}
if (document.form1.Pass.value!=document.form1. Comfpass.value) {
window.alert ("�������벻һ�� ��")
return false
}
if (document.form1.Pass_question.value=="") {
window.alert ("��������ȡ����������� ��")
return false
}
if (document.form1. Pass_answer.value=="") {
window.alert ("��������ȡ������Ĵ𰸣�")
return false
}
if (document.form1.Name.value=="") {
window.alert ("������������ʵ���� ��")
return false
}
if (document.form1.City.value=="") {
window.alert ("���������ڳ��� ��")
return false
}
if (document.form1.Address.value=="") {
window.alert ("������������ϸ��ַ ��")
return false
}
if (document.form1.Zip.value=="") {
window.alert ("�����������ʱ� ��")
return false
}
if (document.form1.Phone.value=="") {
window.alert ("���������ĵ绰 ��")
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
            <td><a href="newproduct.asp" class="white">��Ʒ���</a></td>
            
    <td><a href="commend.asp" class="white">�ص��Ƽ�</a></td>
            
    <td><a href="bestsell.asp" class="white">��������</a></td>
            
    <td><a href="bestprice.asp" class="white">�ؼ���Ʒ</a></td>
          </tr>
        </table><!-- #EndLibraryItem --></td>
  </tr>
  <tr> 
    <td bgcolor="#FFCC66" height="22"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>��<a href="default.asp" class="red">��ҳ</a> &gt; ���û�ע��</td>
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
        ������<img src="images/newregister.gif" width="190" height="30"> <br>
        <span class="productName">����������������Ѿ�ע�ᣬ ��Ҫ����ע����Ϣ��<a href="cinfoupdate.jsp">��������</a></span> 
        <br>
        <br>
        <table width="80%" border="0" cellspacing="2" cellpadding="2" align="center" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">���������ݽ���Ϊ���¼ʱ��ƾ֤����������д��</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">�����ʼ���</td>
            <td width="66%"> 
              <input type="text" name="Email" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">���룺</td>
            <td width="66%"> 
              <input type="password" name="Pass" maxlength="10">
              ���������4λС��10λ</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">ȷ�����룺</td>
            <td width="66%"> 
              <input type="password" name="Comfpass" maxlength="10">
            </td>
          </tr>
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">���������ݽ�������ȡ�����ǵ����룬���μǡ�</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">ȡ���������⣺</td>
            <td width="66%"> 
              <input type="text" name="Pass_question" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">ȡ������𰸣�</td>
            <td width="66%"> 
              <input type="password" name="Pass_answer" maxlength="100">
            </td>
          </tr>
          <tr bgcolor="#FFFFCC"> 
            <td colspan="2" height="24">����׼ȷ��д�Լ���ʵ�������Ϣ���Ա�������ȷ��Ϊ���ṩ����</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">��ʵ������</td>
            <td width="66%"> 
              <input type="text" name="Name" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">���У�</td>
            <td width="66%"> 
              <input type="text" name="City" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right" height="17">��ϸ��ַ��</td>
            <td height="17" width="66%"> 
              <textarea name="Address" rows="3" cols="30"></textarea>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">�ʱࣺ</td>
            <td width="66%"> 
              <input type="text" name="Zip" maxlength="10">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td width="34%" align="right">�绰��</td>
            <td width="66%"> 
              <input type="text" name="Phone" maxlength="50">
            </td>
          </tr>
          <tr bgcolor="#FFFFFF" valign="middle"> 
            <td colspan="2" align="center"> 
              <input type="submit" name="Submit" value="ע��">
              ������ 
              <input type="reset" name="Submit2" value="����">
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
