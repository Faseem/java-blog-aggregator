<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglibs.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
		$(".triggerRemove").click(function(e){
			e.preventDefault();
			$("#removeModel .removeBtn").attr("href",$(this).attr("href"));
			$("#removeModel").modal();
		});
		$('.blogEntry').validate({
			rules : {
				name: {
					required : true,
					minlength : 3
				},
				url :{
					required : true,
					url : true
				}
			},
			
			highlight: function(element) {
			    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
			    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		
		});	
	});
</script>



<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add New Blog</button>
<form:form commandName="blog" cssClass="form-horizontal blogEntry">
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
					<h4 class="modal-title" id="myModalLabel">Add New Blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name : </label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">URL : </label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save" />
				</div>
			</div>
		</div>
	</div>

</form:form>

<br />
<br />



<!-- Nav tabs -->
<div>
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li role="presentation"><a href="#blog_${blog.id}"
				aria-controls="settings" role="tab" data-toggle="tab">${blog.name}</a>
			</li>
		</c:forEach>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
				<br />
				<h1><c:out value="${blog.name }" /></h1>
				<br />
				<p><c:out value="${blog.url }"/>
					 <a href='<spring:url value="/blog/remove/${blog.id}.html"></spring:url>' class="btn btn-danger triggerRemove">Remove</a>
				</p>
				<br />

				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Data</th>
							<th>Item</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items}" var="item">
							<tr>
								<td>
									<c:out value="${item.publishedDate}"/>
								</td>
								<td>
									<strong>
										<a href='<c:out value="${item.link}"/>' target="_blank">
											<c:out value="${item.title }"/>
										</a>
									</strong>
								<br/>
								${item.description}
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>

	</div>


</div>

<div class="modal fade" id="removeModel" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Remove Blog</h4>
      </div>
      <div class="modal-body">
        <p>Are You Sure&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <a href=""  class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
