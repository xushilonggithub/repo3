<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goSearch(){
	document.getElementById("fm").action="${pageContext.request.contextPath }/emp/queryallemp.action";
	document.getElementById("fm").submit();
}

function toadd(){
	location.href="${pageContext.request.contextPath }/emp/toadd.action";
}

function jump(page){
	// 得到总页数
	var pages = "${page.pages}";
	if(page>=1&&page<=pages){
		document.getElementById("pn").value=page;
		document.getElementById("fm").action="${pageContext.request.contextPath }/emp/queryallemp.action";
		document.getElementById("fm").submit();
	}
}

</script>

</head>
<body>
	
	<form action="" method="post" id="fm">
		姓名：<input type="ename" value="${empVo.emp.ename }">
		年龄：<input type="age" value="${empVo.emp.age }">
		<input type="hidden" id="pn" name="pageNum">
		<input type="button" value="查询"  onclick="goSearch()" />
	</form>
	
	<table width="100%" border="1px">
				<tr>
					<td></td>
					<td>编号</td>
					<td>员工姓名</td>
					<td>年龄</td>
					<td>部门</td>	
					<td>地址</td>	
					<td>操作</td>	
				</tr>
				
		<c:forEach items="${page.list }" var="e">
				<tr>
					<td><input type="checkbox" name="eids" value="${e.eid }" /></td>
					<td>${e.eid }</td>
					<td>${e.emp.ename }</td>
					<td>${e.age }</td>
					<td>${e.dname }</td>
					<td>${e.shengname }-${e.shiname }-${e.quname }</td>	
					<td>
						<a href="${pageContext.request.contextPath }/emp/deleteemp.action?eids=${e.eid }">删除</a>
					</td>
				</tr>
		
		</c:forEach>	
		<button onclick="jump(${page.firstPage})">首页</button>
<button onclick="jump(${page.prePage})">上一页</button>

<c:forEach begin="1" end="${page.lastPage }" var="i">
	<button onclick="jump(${i})">${i }</button>
</c:forEach>

<button onclick="jump(${page.nextPage})">下一页</button>
<button onclick="jump(${page.lastPage})">尾页</button>
<br>	
</table>
	
	
</body>
</html>