<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglibs.jsp"%>

<style type="text/css">
/* body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      } */
.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>

<form class="form-signin" role="form" action='/j_spring_security_check'
	method='POST'>
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" name="j_username" class="form-control"
		placeholder="Email address" required="required" autofocus="autofocus">
	<input type="password" name="j_password" class="form-control"
		placeholder="Password" required="required">
	<button class="btn btn-large btn-primary btn-block" type="submit">Sign
		in</button>
</form>

</div>
<!-- /container -->
