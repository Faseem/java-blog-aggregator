<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglibs.jsp" %>

<script type="text/javascript">
 $(document).ready(function(){
	 $(".triggerRemove").click(function(e){
		e.preventDefault();
		$("#modelRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modelRemove").modal();
	 });
 });	
</script>


<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Users</th>
			<th>Operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
				<a href='<spring:url value="/users/${user.id}.html"/>'>
			
				<c:out value="${user.name}"></c:out>
				</a>
				</td>
				<td>
				<a href='<spring:url value="/users/remove/${user.id}.html"/>' class="btn btn-danger triggerRemove">
					Remove
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>




<div class="modal fade" id="modelRemove" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Remove User</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure??&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

