<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css/style.css"  var="styleCss"></spring:url>
<link href="${styleCss }" rel="stylesheet" />
<div class="container mt-3">
  <div class="row">
    <div class="col">
      <c:url value="/actionPasswordReset" var="reset" />
      <form:form action="${reset}" method="POST"
        modelAttribute="resetForm" class="form-horizontal">
        <div class="row g-3">

          <div class="col-12">
            <label for="email" class="form-label">Email <span
              class="red">*</span></label> <br><br>
            <form:input type="text" path="email" name="email"
              value="${resetForm.email }" placeholder="you@gmail.com"
              class="form-control" />
            <form:errors path="email" class="fadeIn fourth text-danger" />
            <c:if test="${not empty errorMsg }">
              <div class="fadeIn fourth text-danger">${errorMsg }</div>
            </c:if>
          </div>

          <div class="col-12 d-grid text-center my-4">
            <button class="btn btn-primary" type="submit">Reset</button>
          </div>
          <div class="col-12 text-center">
            <a href="<c:url value='/' />" class="text-center">Back
              to Home?</a>
          </div>
        </div>

      </form:form>
    </div>
  </div>
</div>