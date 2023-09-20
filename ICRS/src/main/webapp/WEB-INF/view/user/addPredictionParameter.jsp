<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>WiseAdmit Add Details</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/vendors/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<%--   <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
 --%>
<script
	src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
</head>

<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->

		<!-- header part -->
		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_settings-panel.html -->

			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->
			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Add Prediction Parameter</h3>
					</div>


					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<f:form action="savePredictionParameters" method="post"
										modelAttribute="predictionVO" id="">
										<fieldset>

											<div class="row">
												<div class="col">
													
													<%-- <div class="form-group">
														<label for="cname">College:</label>
														<f:select path="collegeVO.collegeId"
															cssClass="form-control">
															<option value="" disabled="disabled" selected="true">-- Select College --</option>
															<c:forEach items="${collegeList}" var="i">
																<f:option value="${i.collegeId}">${i.collegeName}</f:option>
															</c:forEach>
														</f:select>
													</div> --%>
													
													<div class="form-group">
														<label for="">Merit Rank</label>
														<f:input path="meritRank" cssClass="form-control" id="" />
													</div>
													
												</div>
												<div class="col">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">College Type:</label>
															<div class="col-sm-4">
																<div class="form-check">
																	<label class="form-check-label">

																		<input type="radio" name="collegeType"
																		value="Private" id="" class="form-check-input">
																		Private
																	</label>
																</div>
															</div>
															<div class="col-sm-5">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="scholarships" value="Public" id=""
																		class="form-check-input"> Public Funded
																	</label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="cname">Course:</label>
														<f:select path="courseName" cssClass="form-control">
															<option value="" disabled="disabled" selected="true">-- Select Course --</option>
															<f:option value="Automoblie">Automoblie</f:option>
															<f:option value="Bio-Medical">Bio-Medical</f:option>
															<f:option value="Chemical">Chemical</f:option>
															<f:option value="Civil">Civil</f:option>
															<f:option value="Computer">Computer</f:option>
															<f:option value="ComputerScience">ComputerScience</f:option>
															<f:option value="EC">EC</f:option>
															<f:option value="Electrical">Electrical</f:option>
															<f:option value="Environmental">Environmental</f:option>
															<f:option value="IC">IC</f:option>
															<f:option value="ICT">ICT</f:option>
															<f:option value="Info&Comm"></f:option>
															<f:option value="IT">IT</f:option>
															<f:option value="Mechanical">Mechanical</f:option>
															<f:option value="Metallurgical&Material">Metallurgical&Material</f:option>
															<f:option value="Petroleum">Petroleum</f:option>
															<f:option value="Plastic">Plastic</f:option>
															<f:option value="PowerElectronics">PowerElectronics</f:option>
															<f:option value="Production">Production</f:option>
															<f:option value="Rubber">Rubber</f:option>
															
														</f:select>
													</div>
												</div>
												<div class="col">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Scholarships:</label>
															<div class="col-sm-4">
																<div class="form-check">
																	<label class="form-check-label"> <%-- <f:radiobuttons path="scholarships"  cssClass="" id=""  itemValue=""/> --%>

																		<input type="radio" name="scholarships"
																		value="Available" id="" class="form-check-input">
																		Available
																	</label>
																</div>
															</div>
															<div class="col-sm-5">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="scholarships" value="N/A" id=""
																		class="form-check-input"> N/A
																	</label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
				
											<div class="row">
												
												<div class="col">
													<div class="form-group">
														<label for="cname">Degree:</label>
														<f:select path="degreeName" cssClass="form-control">
															<option value="" disabled="disabled" selected="true">-- Select Degree --</option>
															<f:option value="B.E.">B.E.</f:option>
															<f:option value="B.Tech">B.Tech</f:option>
															<f:option value="Diploma">Diploma</f:option>
															<f:option value="M.E.">M.E.</f:option>
															<f:option value="M.Tech">M.Tech</f:option>
															
															
														</f:select>
													</div>
												</div>
												
												<div class="col">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Entrance
																Exam:</label>
															<div class="col-sm-4">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="entranceExam" value="Mandatory"
																		id="" class="form-check-input">Required
																	</label>
																</div>
															</div>
															<div class="col-sm-5">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="entranceExam" value="NotMandatory"
																		id="" class="form-check-input"> Not Required
																	</label>
																</div>
															</div>
														</div>
													</div>
												
												</div>
											</div>
											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="cname">Fees:</label>
														<f:select path="tutionFeesRange" cssClass="form-control">
															<option value="" disabled="disabled" selected="true">-- Select Tution fees --</option>
															<f:option value="1500">1,500</f:option>
															<f:option value="100000">1,00,000</f:option>
															<f:option value="150000">1,50,000</f:option>
															<f:option value="200000">2,00,000</f:option>
															<f:option value="250000">2,50,000</f:option>
															<f:option value="300000">3,00,000</f:option>

														</f:select>
													</div>
													
												</div>
												<div class="col">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Library:</label>
															<div class="col-sm-4">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="library" value="Available" id=""
																		class="form-check-input"> Available
																	</label>
																</div>
															</div>
															<div class="col-sm-5">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="library" value="N/A" id=""
																		class="form-check-input"> N/A
																	</label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col">
												
													<div class="form-group">
														<label for="">Placement Ratio:</label>
														<f:input path="placementPercentage" cssClass="form-control" id="" placeholder="Ratio out of 100"/>
													</div>
												
													
												</div>
												<div class="col">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Sport: Complex</label>
															<div class="col-sm-4">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="sportComplex" value="Available"
																		id="" class="form-check-input"> Available
																	</label>
																</div>
															</div>
															<div class="col-sm-5">
																<div class="form-check">
																	<label class="form-check-label"> <input
																		type="radio" name="sportComplex" value="N/A" id=""
																		class="form-check-input"> N/A
																	</label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="">State</label>
														<f:select path="stateVO.stateId" cssClass="form-control" id="selectState" onchange="getCitiesByStateId()">
															<option value="" disabled="disabled" selected="true">-- Select State --</option>
															<c:forEach items="${stateList}" var="i">
																<f:option value="${i.stateId}">${i.stateName}</f:option>
															</c:forEach>
														</f:select>
													</div>
												</div>
												<div class="col">
													<div class="form-group">
														<label for="">City</label>
														<f:select path="cityVO.cityId" cssClass="form-control" id="selectCity">
															<option value="" disabled="disabled" selected="true">-- Select City --</option>
															
														</f:select>
													</div>
												</div>
											</div>

											<f:hidden path="predictionId" />

											<input class="btn btn-primary" type="submit" value="Submit">

										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>




				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->

				<!-- footer part -->
				<jsp:include page="footer.jsp"></jsp:include>


				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/misc.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
	<script type="text/javascript">
	function getCitiesByStateId(){
		
		var selectState = document.getElementById("selectState");
		
		var stateId = selectState.options[selectState.selectedIndex].value;
		
		console.log("state id : "+stateId);

		var selectCity = document.getElementById("selectCity");
		
		var htp = new XMLHttpRequest();

		htp.onreadystatechange = function() {

			if (htp.readyState == 4) {

				var jsn = JSON.parse(htp.responseText);

				if (jsn.length > 0) {

					selectCity.innerHTML = "";
					var opn = document.createElement("option");

					opn.text = "select";
					opn.disabled = "disabled";
					opn.selected = "selected";
					selectCity.options.add(opn);

					for (var index = 0; index < jsn.length; index++) {

	 					var opn = document.createElement("option");

						opn.value = jsn[index].cityId;
						opn.text = jsn[index].cityName;

						selectCity.options.add(opn);
					}

				}

			}
		}

		htp.open("get", "getCitiesByStateId?id=" + stateId, true);
		htp.send();
	}
	</script>
</body>

</html>
