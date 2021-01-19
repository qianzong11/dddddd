<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2021/1/13
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息维护</title>
</head>
<body>
<div align="center">
    <table width="500" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <th>员工编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>入职日期</th>
            <th>税前月薪</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${emplist}" var="emp">
            <tr>
                <td>${emp.empid}</td>
                <td>${emp.empname}</td>
                <td>${emp.age}</td>

                <c:if test="${emp.sex==0}">
                    <td>男</td>
                </c:if>
                <c:if test="${emp.sex==1}">
                    <td>女</td>
                </c:if>
                <td>${emp.addtime}</td>
                <td>${emp.wage}</td>
                <td>${emp.department.depname}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employee/updt?id=${emp.empid}">修改</a>
                    <a href="javascript:void(0)" onclick="del(this,${emp.empid})">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    function del(dom,empId){
        /*alert("123:"+empId);*/
        let res=confirm("确认要删除吗?");
        if (res==true){
            $.post("../employee/delEmp","empId="+empId,function(data){
                /* alert(data.result);*/
                if(data.result==true){
                    alert("删除成功");
                    $(dom).parent().parent().remove();
                }else{
                    alert("删除失败");
                }
            },"json");
        }
    }
</script>
</body>
</html>
