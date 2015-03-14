<%--
  Created by IntelliJ IDEA.
  User: Lauri
  Date: 14.03.2015
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>s
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

	/*
	 * set the secure state token in session to be able to track what we sent to google
	 */
        session.setAttribute("state", helper.getStateToken());


    } else if (request.getParameter("code") != null && request.getParameter("state") != null && request.getParameter("state").equals(session.getAttribute("state"))) {

        session.removeAttribute("state");

	/*
	 * Executes after google redirects to the callback url.
	 * Please note that the state request parameter is for convenience to differentiate
	 * between authentication methods (ex. facebook oauth, google oauth, twitter, in-house).
	 *
	 * GoogleAuth()#getUserInfoJson(String) method returns a String containing
	 * the json representation of the authenticated user's information.
	 * At this point you should parse and persist the info.
	 */

        out.println(helper.getUserInfoJson(request.getParameter("code")));
    }
%>
</body>
</html>
