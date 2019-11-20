<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('packingListAction_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
   修改部门
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="packingListId" value="${packingListId}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="seller" value="${seller}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="buyer" value="${buyer}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">选择：</td>
	            <td class="tableContent"><input type="text" name="invoiceNo" value="${invoiceNo}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="invoiceDate" value="${invoiceDate}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="marks" value="${marks}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="descriptions" value="${descriptions}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">报运ID集合：</td>
	            <td class="tableContent"><input type="text" name="exportIds" value="${exportIds}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">报运NO集合x,y|z,h：</td>
	            <td class="tableContent"><input type="text" name="exportNos" value="${exportNos}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">0草稿 1已上报：</td>
	            <td class="tableContent"><input type="text" name="state" value="${state}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="createBy" value="${createBy}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="createDept" value="${createDept}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent"><input type="text" name="createTime" value="${createTime}"/></td>
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

