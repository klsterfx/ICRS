<%@page import="com.project.utils.*"%>
<nav
	class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
	</div>
	<div class="navbar-menu-wrapper d-flex align-items-center">
		<button class="navbar-toggler navbar-toggler align-self-center"
			type="button" data-toggle="minimize">
			<span class="mdi mdi-menu"></span>
		</button>
		<span class="d-none d-md-inline"></span>
		<ul class="navbar-nav navbar-nav-right">
			
			<li class="nav-item nav-profile dropdown">
				<a class="nav-link count-indicator dropdown-toggle"
					id="messageDropdown" href="#" data-toggle="dropdown"
					aria-expanded="false"> <!-- <i class="mdi mdi-message-text-outline"></i> -->
					<div class="nav-profile-text">
						<p class="mb-0"><%=BaseMethods.getUsername().toUpperCase()%></p>
					</div>
					<div class="nav-profile-img">
						<img
							src="<%=request.getContextPath()%>/adminResources/images/avatar-icon.jpg"
							alt="image">
					</div>
				</a>
				
				<div
					class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
					aria-labelledby="messageDropdown">
					<div class="dropdown-divider"></div>
					<a class="dropdown-item nav-item nav-logout" href="/logout">
						<div class="mr-3">
							<h6><i class="mdi mdi-power"></i></h6>
						</div>
						<div
							class="preview-item-content d-flex align-items-start flex-column justify-content-center">
							<h6 class="preview-subject ellipsis mb-1 font-weight-normal">Logout</h6>
						</div>
					</a>
					<div class="dropdown-divider"></div>
				</div></li>
		</ul>

		<button
			class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
			type="button" data-toggle="offcanvas">
			<span class="mdi mdi-menu"></span>
		</button>


	</div>
</nav>
