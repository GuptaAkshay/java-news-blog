<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add New Blog</button>
	
<form:form commandName="blog" cssClass="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" autofocus="autofocus"/>
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Url</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url" />
						</div>
					</div>										
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" value="Save Blog" class="btn btn-primary" />
				</div>
			</div>
		</div>
	</div>
</form:form>

<br><br>
<script type="text/javascript">

$(document).ready(function(){
	
	$('.nav-tabs a:first').tab('show'); // Select first tab
	$(".triggerRemove").click(function(e){
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href",$(this).attr("href"));
		$("#modalRemove").modal();
	})
})
</script>

<div>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <c:forEach items="${user.getBlogs()}" var="blog">
    <li role="presentation"><a href="#blog_${blog.id}" aria-controls="${blog.name}" role="tab" data-toggle="tab">${blog.name}</a></li>
  </c:forEach>  
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  <c:forEach items="${user.getBlogs()}" var="blog">
    <div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
    	
    	<h1>${blog.name}</h1>
    	
	<p>
		<a href='<spring:url value="/blog/remove/${blog.id}.html"></spring:url>' class="btn btn-danger triggerRemove">Remove Blog</a>
	${blog.url}</p>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.getItems()}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
    </c:forEach>
  </div>

</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Do you really want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div> 

	
