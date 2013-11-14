<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>登录系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css" type="text/css"></link>
<link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.min.css" type="text/css"></link>
<link rel="stylesheet" href="static/css/login.css" type="text/css"></link>
</head>

<body>
	<div class="container">

		<form class="form-signin" action="<%=basePath%>login" method="post">
			<h2 class="form-signin-heading">系统登录</h2>

			<input type="text" name="username" class="form-control" value="${username}" placeholder="帐号" required autofocus> 
			<input type="password" name="password" class="form-control" placeholder="密码" required>
			<label class="checkbox"><input type="checkbox" value="remember-me"> 记住我 </label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

		<%
			String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if (error != null) {
		%>
		<div class="alert alert-error controls">
			<button class="close" data-dismiss="alert">×</button>
			<%
				if (error.contains("DisabledAccountException")) {
						out.print("用户已被屏蔽,请登录其他用户.");
					} else if (error.contains("IncorrectCredentialsException")) {
						out.print("密码错误.");
					} else {
						out.print("登录失败，请重试.");
					}
			%>
		</div>
		<%
			}
		%>
	</div>

	<script type="text/javascript" src="static/jquery.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
