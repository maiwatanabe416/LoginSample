<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- セッション管理 -->
<c:choose>
    <c:when test="${not empty sessionScope.login}">
        ようこそ、<c:out value="${sessionScope.login.userid}" />さん
    </c:when>
    <c:otherwise>
    	<!-- ログイン情報がセッションに無い場合はリダイレクトをする -->
        <c:redirect url="/jsp/login.jsp" />
    </c:otherwise>
</c:choose>

</body>
</html>