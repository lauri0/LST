<%--
  Created by IntelliJ IDEA.
  User: Lauri
  Date: 14.03.2015
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title></title>
</head>
<body>
<%
    final main.java.GoogleAuth helper = new main.java.GoogleAuth();
    if (request.getParameter("code") == null
            || request.getParameter("state") == null) {
	/*
	 * initial visit to the page
	 */
        out.println("<a href='" + helper.buildLoginUrl() + "'>log in with google</a>");
        String location = new String(helper.buildLoginUrl());
        response.sendRedirect(location);

	/*
	 * set the secure state token in session to be able to track what we sent to google
	 */
        session.setAttribute("state", helper.getStateToken());


    } else if (request.getParameter("code") != null && request.getParameter("state") != null && request.getParameter("state").equals(session.getAttribute("state"))) {

        session.removeAttribute("state");

	/*
	 * Executes after google redirects to the callback url.
	 */

        String userInfo = helper.getUserInfoJson(request.getParameter("code"));
        helper.setUserName(helper.getNameFromJson(userInfo));
        String redirectLocation = "http://localhost:8088/index";
        //String redirectLocation = "http://nameless-hollows-9873.herokuapp.com/index"
        response.sendRedirect(redirectLocation);
    }
%>
</body>
</html>
