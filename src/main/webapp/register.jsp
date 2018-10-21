<%@page import="com.cier.dao.UserDao"%>
<jsp:useBean id="obj" class="com.cier.pojo.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj" />

<%
    int i = UserDao.save(obj);
    if (i > 0) {
        out.print("You are successfully registered");
    }
%>