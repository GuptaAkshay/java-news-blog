<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<form:form commandName="user" cssClass="form-horizontal">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			Registration Successful! Click here to <a href='<spring:url value="/login.html"></spring:url>' class="alert-link">Login</a>
		</div>
	</c:if>
	
	<div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <form:input path="name" cssClass="form-control" autofocus="autofocus"/>
      <form:errors path="name" />
    </div>
  </div>
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <form:input path="email" cssClass="form-control"/>
      <form:errors path="email" />
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <form:password path="password" cssClass="form-control"/>
      <form:errors path="password" />
    </div>
  </div>
  <div class="form-group">    
    <div class="col-sm-2">
      <input type="submit" value="Submit" class="btn btn-primary"/>
    </div>
  </div>
  
</form:form>