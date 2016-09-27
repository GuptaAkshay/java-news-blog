<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<form:form commandName="user" cssClass="form-horizontal registrationForm">

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
    <label for="cnfpassword" class="col-sm-2 control-label">Confirm Password</label>
    <div class="col-sm-10">
      <input type="password" name="cnfpassword" id="cnfpassword" class="form-control" />
    </div>
  </div>
  <div class="form-group">    
    <div class="col-sm-2">
      <input type="submit" value="Submit" class="btn btn-primary"/>
    </div>
  </div>
  
</form:form>

<script type="text/javascript">
$(document).ready(function(){
	
	$(".registrationForm").validate(
		
			{
				rules:{
					name:{
						required :true,
						minlength : 3,
						remote : {
							url : "<spring:url value='/register/available.html' />",
							type : "get",
							data : {
								userName : function(){
									return $("#name").val();
								} 
							}
						}
					},
					email:{
						required :true,
						email : true
					},
					password:{
						required :true,
						minlength : 6
					},
					cnfpassword:{
						required :true,
						minlength : 6,
						equalTo: "#password"
					},
				},
				highlight : function (element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight : function (element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages: {
					name:{
						remote : "UserName already exists! Please try some other name"
					}
				}
			}
	)
})
</script>