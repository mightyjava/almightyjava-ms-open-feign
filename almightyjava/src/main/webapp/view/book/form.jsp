<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="container col-lg-10">
	<div class="card">
		<div class="card-header">
			<strong>
				<c:choose>
					<c:when test="${isNew}"><i class="fa fa-plus-circle fa-lg"></i></c:when>
					<c:otherwise><i class="fa fa-edit fa-lg"></i></c:otherwise>
				</c:choose> <spring:message code="label.book"/>
			</strong>
		</div>
		<form:form method="post" class="form-horizontal" action="${path}/book/add" modelAttribute="bookForm" id="submitBookForm">
			<form:hidden path="id"/>
			<div class="card-body">
				<div class="row">
					<label class="col-md-2 control-label"><spring:message code="label.book.title"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.title" var="bookTitlePlaceholder"/>
						<form:input class="form-control" path="title" placeholder="${bookTitlePlaceholder}" required="true" autocomplete="off"/>
					</div>
					
					<label class="col-md-2 control-label"><spring:message code="label.book.author"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.author" var="bookAuthorPlaceholder"/>
						<form:input class="form-control" path="author" placeholder="${bookAuthorPlaceholder}" required="true" autocomplete="off"/>
					</div>
				</div>
				<div class="row">
					<label class="col-md-2 control-label"><spring:message code="label.book.isbnNumber"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.isbnNumber" var="bookIsbnNumberPlaceholder"/>
						<form:input class="form-control" path="isbnNumber" placeholder="${bookIsbnNumberPlaceholder}" required="true" autocomplete="off"/>
					</div>
					
					<label class="col-md-2 control-label"><spring:message code="label.book.price"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.price" var="bookPricePlaceholder"/>
						<form:input class="form-control" path="price" placeholder="${bookPricePlaceholder}" required="true" autocomplete="off"/>
					</div>
				</div>
				<div class="row">
					<label class="col-md-2 control-label"><spring:message code="label.book.language"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.language" var="bookLanguagePlaceholder"/>
						<form:input class="form-control" path="language" placeholder="${bookLanguagePlaceholder}" required="true" autocomplete="off"/>
					</div>
					
					<label class="col-md-2 control-label"><spring:message code="label.book.coverPhotoURL"/> : </label>
					<div class="col-md-4 mb-3">
						<spring:message code="placeholder.book.coverPhotoURL" var="bookCoverPhotoURLPlaceholder"/>
						<form:input class="form-control" path="coverPhotoURL" placeholder="${bookCoverPhotoURLPlaceholder}" required="true" autocomplete="off"/>
					</div>
				</div>
			</div>
			<div class="card-footer text-right">
				<form:button value="Save" class="btn btn-sm btn-primary">
					<i class="fa fa-save"></i>
					<c:choose>
						<c:when test="${isNew}"> <spring:message code="label.save"/></c:when>
						<c:otherwise> <spring:message code="label.update"/></c:otherwise>
					</c:choose>
				</form:button>
			</div>
		</form:form>
	</div>
</div>