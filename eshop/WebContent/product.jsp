<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<html>
<head>
<title>�����̳�</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style/subcategory1.css" type="text/css">
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
<form name="search_form" method="get" action="quick_search.asp">
  <table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
    <tr> 
      <td bgcolor="#FF9900" height="22" valign="middle" align="center"><table width="80%" border="0" cellspacing="2" cellpadding="2">
          <tr align="center" valign="middle"> 
            <td><a href="newproduct.asp" class="white">��Ʒ���</a></td>
            
    <td><a href="commend.asp" class="white">�ص��Ƽ�</a></td>
            
    <td><a href="bestsell.asp" class="white">��������</a></td>
            
    <td><a href="bestprice.asp" class="white">�ؼ���Ʒ</a></td>
          </tr>
        </table>
        </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCC66" height="22"> 
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td width="50%">��
<<<<<<< HEAD
=======
            <a href="index.jsp" class="red">��ҳ</a> &gt; <a href="category.jsp?" class="red" >${CategoryName}</a> &gt; <a href="subcategory.jsp?" class="red">${SubCategoryName}</a>
            </td>
            <td width="50%" valign="middle" align="center"> 
              <select name="mnuCategory">
                <option value="${CategoryID}" selected>�ڱ����̳���</option>
                
                <!-- ѡ�����ʼ  -->
                
                <option value="${CategoryID}" >��${CategoryName}��</option>
                
                <!-- ѡ��������  -->
                
              </select>
              <input type="text" name="textPname" size="20" maxlength="50">
              <input type="submit" name="Submit2" value="����">
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td width="75%" valign="top" align="left"> 
      <table width="98%" border="0" cellspacing="2" cellpadding="2">
        <tr> 
          <td rowspan="4" align="left" valign="top" width="18%">
          <img src="images/product/${product.bigImg}"></td>
          <td width="82%" class="productName"> 
            <form name="cartform" method="post" action="cart.jsp">
              ${cart.productName} 
              <!-- �ж��Ƿ���ʾ������ʶ:price not eq 0 -->            
              <img src="images/hotprice.gif" width="24" height="24"> 
              <!-- �ж��Ƿ���ʾ������ʶ:price not eq 0 -->
              <input type="image" border="0" name="imageField" src="images/addtocart.gif" width="30" height="18" alt="���빺�ﳵ">
              <input type="hidden" name="productId" value="${cart.productId}">
            </form>
          </td>
        </tr>
        <tr> 
          <td width="82%">${Supplier}��${author}</td>
        </tr>
        <tr> 
          <td width="82%">�������ڣ�${pubDate}��${ProductID}</td>
        </tr>
        <tr> 
          <td width="82%"> 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            ԭ�ۣ�<span class="hotPrice">${Price}</span>Ԫ���ּۣ� 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            �۸� 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            ${ListPrice}Ԫ
            </td>
        </tr>
        <tr> 
          <td colspan="2">${Description}</td>
        </tr>
      </table>
      <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="31%" valign="middle" align="center" height="22" class="bestselltitle">��������</td>
          <td width="69%">&nbsp;</td>
        </tr>
        <tr align="center" valign="top"> 
          <td colspan="2" class="bestsellbox"> 
            <table width="98%" border="0" cellspacing="2" cellpadding="2">
              <tr> 
                <td width="34%" height="17">&nbsp;</td>
                <td width="40%" height="17">&nbsp;</td>
                <td width="26%" height="17">&gt;&gt; <a href="#" onClick="MM_openBrWindow('review.asp','','scrollbars=yes,width=500,height=300')">��Ҫ����</a> 
                  &lt;&lt;</td>
              </tr>
              
              <tr> 
                <td bgcolor="#E4E4E4"><a href="mailto:${ReviewEmail}">${ReviewName}</a>
                </td>
                <td colspan="2" align="center" bgcolor="#E4E4E4">${ReviewTime}</td>
              </tr>
              <tr> 
                <td colspan="3">${ReviewContent}</td>
              </tr>
              <tr> 
                <td colspan="3" height="1" bgcolor="#E1E1E1"></td>
              </tr>
              
              <tr align="center"> 
                <td colspan="3"> 
                  <table border="0" width="50%">
                    <tr> 
                      <td width="23%" align="center"> 
                        
                        <a href="" class="navi">��һҳ</a> 
                      </td>
                      <td width="31%" align="center"> 
                        <a href="" class="navi">ǰһҳ</a> 
                      </td>
                      <td width="23%" align="center"> 
                        <a href="" class="navi">��һҳ</a> 
                      </td>
                      <td width="23%" align="center"> 
                        <a href="" class="navi">��ĩҳ</a> 
                      </td>
                    </tr>
                  </table>
                  <!-- ��������� -->
                  ��${review_first} ��${review_last}�����ۣ���${review_total}�� 
                  <!-- ��������� -->
                  <!-- ���û������ -->
                  ����ƷĿǰû���κ����ۡ� 
                  <!-- ���û������ -->
                </td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&gt;&gt; <a href="#" onClick="MM_openBrWindow('review.asp','','scrollbars=yes,width=500,height=300')">��Ҫ����</a> 
                  &lt;&lt;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="25%" align="right" valign="top"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="4" class="commendbox">
        <tr> 
          <td height="22" align="center" class="commendtitle" colspan="2">��Ʒ����</td>
        </tr>
        <!-- ���NUM_RATES������0 -->
        <tr> 
          <td colspan="2">�����Ǳ���Ʒ�÷������</td>
        </tr>
        <tr> 
          <td width="65%"> 
            <table width="70" border="0" cellspacing="0" cellpadding="0" background="images/rating/rate_back.gif" height="15">
              <tr> 
                <td> 
                  <table width="${GRAGHWIDTH}" border="0" cellspacing="0" cellpadding="0" height="15" background="images/rating/5.gif">
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td width="35%"> 
            ${AVERAGE_RATES}��
          </td>
        </tr>
        <tr> 
          <td colspan="2">����${NUM_RATES}λ�˿�Ϊ����Ʒ����</td>
        </tr>
        <tr> 
          <td colspan="2">��߷֣�${HIGH_RATE}��</td>
        </tr>
        <tr> 
          <td colspan="2">��ͷ֣�${LOW_RATE}��</td>
        </tr>
        <!-- ���NUM_RATES������0 -->

        <tr> 
        <!-- ���NUM_RATES����0 -->
          <td colspan="2">Ŀǰ��û�й˿ͶԴ���Ʒ����</td>
        <!-- ���NUM_RATES����0 -->
        </tr>
        <tr align="center" bgcolor="#CCCCFF"> 
          <td colspan="2">&gt;&gt;&gt; �������� &lt;&lt;&lt;</td>
        </tr>
        <tr align="center"> 
          <td colspan="2"> 
            <form name="rating_form" method="POST" action="">
              <table width="90%" border="0" cellspacing="2" cellpadding="2">
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="5" checked>
                  </td>
                  <td width="76%"><img src="images/rating/5.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="4">
                  </td>
                  <td width="76%"><img src="images/rating/4.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="3">
                  </td>
                  <td width="76%"><img src="images/rating/3.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="2">
                  </td>
                  <td width="76%"><img src="images/rating/2.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="1">
                  </td>
                  <td width="76%"><img src="images/rating/1.gif" width="70" height="15"></td>
                </tr>
                <tr align="center"> 
                  <td colspan="2"> 
                    <input type="submit" name="Submit" value="�� ��">
                    <input type="hidden" name="hiddenField" value="${ProductID}">
                  </td>
                </tr>
              </table>
              <input type="hidden" name="MM_insert" value="true">
            </form>
          </td>
        </tr>
      </table>
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
<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<html>
<head>
<title>�����̳�</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style/subcategory1.css" type="text/css">
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
<form name="search_form" method="get" action="quick_search.asp">
  <table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
    <tr> 
      <td bgcolor="#FF9900" height="22" valign="middle" align="center"><table width="80%" border="0" cellspacing="2" cellpadding="2">
          <tr align="center" valign="middle"> 
            <td><a href="newproduct.asp" class="white">��Ʒ���</a></td>
            
    <td><a href="commend.asp" class="white">�ص��Ƽ�</a></td>
            
    <td><a href="bestsell.asp" class="white">��������</a></td>
            
    <td><a href="bestprice.asp" class="white">�ؼ���Ʒ</a></td>
          </tr>
        </table>
        </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCC66" height="22"> 
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td width="50%">��
>>>>>>> branch 'master' of https://github.com/xiaoyei666/eshop.git
            <a href="default.asp" class="red">��ҳ</a> &gt; <a href="category.jsp?" class="red" >${CategoryName}</a> &gt; <a href="subcategory.jsp?" class="red">${SubCategoryName}</a>
            </td>
            <td width="50%" valign="middle" align="center"> 
              <select name="mnuCategory">
                <option value="${CategoryID}" selected>�ڱ����̳���</option>
                
                <!-- ѡ�����ʼ  -->
                
                <option value="${CategoryID}" >��${CategoryName}��</option>
                
                <!-- ѡ��������  -->
                
              </select>
              <input type="text" name="textPname" size="20" maxlength="50">
              <input type="submit" name="Submit2" value="����">
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td width="75%" valign="top" align="left"> 
      <table width="98%" border="0" cellspacing="2" cellpadding="2">
        <tr> 
          <td rowspan="4" align="left" valign="top" width="18%">
          <img src="images/product/${product.bigImg}"></td>
          <td width="82%" class="productName"> 
            <form name="cartform" method="post" action="cart.jsp">
              ${cart.productName} 
              <!-- �ж��Ƿ���ʾ������ʶ:price not eq 0 -->            
              <img src="images/hotprice.gif" width="24" height="24"> 
              <!-- �ж��Ƿ���ʾ������ʶ:price not eq 0 -->
              <input type="image" border="0" name="imageField" src="images/addtocart.gif" width="30" height="18" alt="���빺�ﳵ">
              <input type="hidden" name="productId" value="${cart.productId}">
            </form>
          </td>
        </tr>
        <tr> 
          <td width="82%">${Supplier}��${author}</td>
        </tr>
        <tr> 
          <td width="82%">�������ڣ�${pubDate}��${ProductID}</td>
        </tr>
        <tr> 
          <td width="82%"> 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            ԭ�ۣ�<span class="hotPrice">${Price}</span>Ԫ���ּۣ� 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            �۸� 
            <!-- �ж��Ƿ���ʾԭ��[price not eq 0] -->
            ${ListPrice}Ԫ
            </td>
        </tr>
        <tr> 
          <td colspan="2">${Description}</td>
        </tr>
      </table>
      <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="31%" valign="middle" align="center" height="22" class="bestselltitle">��������</td>
          <td width="69%">&nbsp;</td>
        </tr>
        <tr align="center" valign="top"> 
          <td colspan="2" class="bestsellbox"> 
            <table width="98%" border="0" cellspacing="2" cellpadding="2">
              <tr> 
                <td width="34%" height="17">&nbsp;</td>
                <td width="40%" height="17">&nbsp;</td>
                <td width="26%" height="17">&gt;&gt; <a href="#" onClick="MM_openBrWindow('review.asp','','scrollbars=yes,width=500,height=300')">��Ҫ����</a> 
                  &lt;&lt;</td>
              </tr>
              
              <tr> 
                <td bgcolor="#E4E4E4"><a href="mailto:${ReviewEmail}">${ReviewName}</a>
                </td>
                <td colspan="2" align="center" bgcolor="#E4E4E4">${ReviewTime}</td>
              </tr>
              <tr> 
                <td colspan="3">${ReviewContent}</td>
              </tr>
              <tr> 
                <td colspan="3" height="1" bgcolor="#E1E1E1"></td>
              </tr>
              
              <tr align="center"> 
                <td colspan="3"> 
                  <table border="0" width="50%">
                    <tr> 
                      <td width="23%" align="center"> 
                        
                        <a href="" class="navi">��һҳ</a> 
                      </td>
                      <td width="31%" align="center"> 
                        <a href="" class="navi">ǰһҳ</a> 
                      </td>
                      <td width="23%" align="center"> 
                        <a href="" class="navi">��һҳ</a> 
                      </td>
                      <td width="23%" align="center"> 
                        <a href="" class="navi">��ĩҳ</a> 
                      </td>
                    </tr>
                  </table>
                  <!-- ��������� -->
                  ��${review_first} ��${review_last}�����ۣ���${review_total}�� 
                  <!-- ��������� -->
                  <!-- ���û������ -->
                  ����ƷĿǰû���κ����ۡ� 
                  <!-- ���û������ -->
                </td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&gt;&gt; <a href="#" onClick="MM_openBrWindow('review.asp','','scrollbars=yes,width=500,height=300')">��Ҫ����</a> 
                  &lt;&lt;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="25%" align="right" valign="top"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="4" class="commendbox">
        <tr> 
          <td height="22" align="center" class="commendtitle" colspan="2">��Ʒ����</td>
        </tr>
        <!-- ���NUM_RATES������0 -->
        <tr> 
          <td colspan="2">�����Ǳ���Ʒ�÷������</td>
        </tr>
        <tr> 
          <td width="65%"> 
            <table width="70" border="0" cellspacing="0" cellpadding="0" background="images/rating/rate_back.gif" height="15">
              <tr> 
                <td> 
                  <table width="${GRAGHWIDTH}" border="0" cellspacing="0" cellpadding="0" height="15" background="images/rating/5.gif">
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td width="35%"> 
            ${AVERAGE_RATES}��
          </td>
        </tr>
        <tr> 
          <td colspan="2">����${NUM_RATES}λ�˿�Ϊ����Ʒ����</td>
        </tr>
        <tr> 
          <td colspan="2">��߷֣�${HIGH_RATE}��</td>
        </tr>
        <tr> 
          <td colspan="2">��ͷ֣�${LOW_RATE}��</td>
        </tr>
        <!-- ���NUM_RATES������0 -->

        <tr> 
        <!-- ���NUM_RATES����0 -->
          <td colspan="2">Ŀǰ��û�й˿ͶԴ���Ʒ����</td>
        <!-- ���NUM_RATES����0 -->
        </tr>
        <tr align="center" bgcolor="#CCCCFF"> 
          <td colspan="2">&gt;&gt;&gt; �������� &lt;&lt;&lt;</td>
        </tr>
        <tr align="center"> 
          <td colspan="2"> 
            <form name="rating_form" method="POST" action="">
              <table width="90%" border="0" cellspacing="2" cellpadding="2">
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="5" checked>
                  </td>
                  <td width="76%"><img src="images/rating/5.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="4">
                  </td>
                  <td width="76%"><img src="images/rating/4.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="3">
                  </td>
                  <td width="76%"><img src="images/rating/3.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="2">
                  </td>
                  <td width="76%"><img src="images/rating/2.gif" width="70" height="15"></td>
                </tr>
                <tr> 
                  <td width="24%"> 
                    <input type="radio" name="radiobutton" value="1">
                  </td>
                  <td width="76%"><img src="images/rating/1.gif" width="70" height="15"></td>
                </tr>
                <tr align="center"> 
                  <td colspan="2"> 
                    <input type="submit" name="Submit" value="�� ��">
                    <input type="hidden" name="hiddenField" value="${ProductID}">
                  </td>
                </tr>
              </table>
              <input type="hidden" name="MM_insert" value="true">
            </form>
          </td>
        </tr>
      </table>
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