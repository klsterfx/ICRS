<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>WiseAdmit Register</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="adminResources/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="adminResources/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="adminResources/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="adminResources/css/style.css">
  <!-- endinject -->
  <!-- <link rel="shortcut icon" href="adminResources/images/favicon.png" /> -->
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth">
        <div class="row w-100">
          <div class="col-lg-5 mx-auto">
            <div class="auth-form-light text-left p-5">
              
              <h4>Register</h4>
              <h6 class="font-weight-light"></h6>

              <f:form class="pt-3" modelAttribute="registerVO" action="saveUser" method="POST">

                <div class="form-group">
	                <f:input path="firstName" cssClass="form-control form-control-lg" placeholder="First Name"/>
                </div>

                <div class="form-group">
	                <f:input path="lastName" cssClass="form-control form-control-lg" placeholder="Last Name"/>
                </div>
                
                <div class="form-group">
	                <f:input path="loginVO.userName" cssClass="form-control form-control-lg" placeholder="User Name"/>
                </div>
                
                <div class="form-group">
	                <f:input path="loginVO.password" cssClass="form-control form-control-lg" placeholder="password"/>
                </div>
                <div class="mt-3">
					<input type="submit" class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" value="REGISTER">
                </div>
                <div class="mt-4" style="text-align: center">
                	<span>Already have account?</span>
	                <a href="login" class="font-weight-medium auth-form-btn">login</a>
                </div>

                
              </f:form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="adminResources/js/vendor.bundle.base.js"></script>
  <script src="adminResources/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="adminResources/js/off-canvas.js"></script>
  <script src="adminResources/js/hoverable-collapse.js"></script>
  <script src="adminResources/js/misc.js"></script>
  <script src="adminResources/js/settings.js"></script>
  <script src="adminResources/js/todolist.js"></script>
  <!-- endinject -->
</body>

</html>
    