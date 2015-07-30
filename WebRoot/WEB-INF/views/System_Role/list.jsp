<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript"
	src="${pageContext.request.contextPath }/script/jquery.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/script/PageUtils.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/script/DemoData.js"
	charset="utf-8"></script>
<%-- <script language="javascript"
	src="${pageContext.request.contextPath }/script/DataShowManager.js"
	charset="utf-8"></script> --%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/blue/pageCommon.css" />
<script type="text/javascript">
	function delConfirm(id) {
		var r = confirm("是否确定要删除此条记录?");
		if (r) {
			window.location.href = "${pageContext.request.contextPath}/role_delete_action.action?id="+id;
		}
	}
</script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/style/images/title_arrow.gif" />
				岗位管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="200px">岗位名称</td>
					<td width="300px">岗位说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<s:iterator value="#roleList" >
					<tr class="TableDetail1 template">
						<td><s:property value="name"/>&nbsp;</td>
						<td><s:property value="description"/>&nbsp;</td>
						<td><a onClick="return delConfirm(${id})"
							href="javascript:void(0)">删除</a> <a
							href="${pageContext.request.contextPath }/role_updateUI_action.action?type=update&id=${id}">修改</a>
							<a href="setPrivilegeUI.html">设置权限</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a
					href="${pageContext.request.contextPath }/role_addUI_action.action?type=add"><img
					src="${pageContext.request.contextPath }/style/images/createNew.png" />
				</a>
			</div>
		</div>
	</div>
</body>
</html>
