<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="cn_zh">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="resources/common/lib/favicon.png">
    <title>desktop</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/common/lib/bs3/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="resources/common/css/zorbit-desktop.css" rel="stylesheet">
	<link href="resources/common/css/zorbit-desktop-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="common/lib/bs3/js/html5shiv.js"></script>
      <script src="common/lib/bs3/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!-- Wrap all page content here -->
    <div id="wrap">
		<!-- navbar begin-->
		<div class="nav navbar-inverse navbar-fixed-top zbt-dtp-navbar">
			<div class="navbar-header zbt-dtp-navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				</button>
				<a href="#desk" class="zbt-dtp-maindeskitem"><span class="glyphicon glyphicon-th"></span></a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav zbt-dtp-topbar-item">
					 <li title="首页" ><a href="#home"><span class="glyphicon glyphicon-home"></span></a></li>
				 </ul>
				 <ul class="nav navbar-nav navbar-right">
				  <li class="dropdown" title="设置">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="#">Action</a></li>
					  <li><a href="#">Another action</a></li>
					  <li><a href="#">Something else here</a></li>
					  <li><a href="#">Separated link</a></li>
					</ul>
				  </li>
				</ul>
			</div>
		</div>
		<!-- navbar end -->
		<!-- main begin-->
		<div class="zbt-dtp-desk zbt-dtp-show" style="display:block;" deskid="#desk">
		<div class="row zbt-dtp-iconContainer"></div>
		</div>
		<div class="zbt-dtp-desk zbt-dtp-app" deskid="#home">
			<div class="row zbt-dtp-appleftmenu-close">
				  <div class="zbt-dtp-appleftmenu">
					<div class="zbt-dtp-menupanel" >
					  <div class="zbt-dtp-menuheading nav navbar-inverse">
						  <div>
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#zbt-dtp-slidermenu01">
							  <span class="icon-bar"></span>
							  <span class="icon-bar"></span>
							  <span class="icon-bar"></span>
							</button>
						  </div>
							<div class="zbt-dtp-sidebar-toggler visible-md visible-lg">&gt;</div>
						</div>
					  <div class="collapse in zbt-dtp-menubody" id="zbt-dtp-slidermenu01">
						<ul class="zbt-dtp-menu zbt-dtp-menu1">
							<li class="zbt-dtp-active zbt-dtp-loaded" id="menuroot1">
								<a href="#collapse-menu1" data-toggle="collapse">
									<span class="glyphicon glyphicon-bookmark"></span> <span class='zbt-dpt-menutitle'>系统管理</span>
									<span class="zbt-dtp-arrow"></span>
								</a>
								<ul id="collapse-menu1" class="collapse in zbt-dtp-menu zbt-dtp-menu2">
									<li class="">
										<a href="#collapse-menu12" data-toggle="collapse">
											<span class="glyphicon glyphicon-user"></span> <span class='zbt-dpt-menutitle'>用户管理</span>
											<span class="zbt-dtp-arrow"></span>
										</a>
										<ul id="collapse-menu12" class="collapse in zbt-dtp-menu zbt-dtp-menu3">
											<li><a href="#collapse-menu1231"  data-toggle="collapse">
													<span class=" glyphicon glyphicon-random"></span> <span class='zbt-dpt-menutitle'>用户列表</span>
													<span class="zbt-dtp-arrow"></span>
											    </a>
												<ul id="collapse-menu1231" class="collapse in zbt-dtp-menu zbt-dtp-menu4">
													<li><a href="#" menu-root="#menuroot1" class='zbt-dpt-menulink' isleaf=1>
															<span class=" glyphicon glyphicon-th-list"></span><span class='zbt-dpt-menutitle'> 有效用户</span></a>
														</li>
													<li><a href="#" menu-root="#menuroot1" class='zbt-dpt-menulink' isleaf=1><span class=" glyphicon glyphicon-trash"></span> <span class='zbt-dpt-menutitle'>过期用户</span></a></li>
												</ul>
											</li>
											<li><a href="javascript:;" menu-root="#menuroot1" class='zbt-dpt-menulink' isleaf=1><span class=" glyphicon glyphicon-th"></span> <span class='zbt-dpt-menutitle'>用户组管理</span></a></li>
											<li><a href="javascript:;" menu-root="#menuroot1" class='zbt-dpt-menulink' isleaf=1><span class=" glyphicon glyphicon-align-justify"></span> <span class='zbt-dpt-menutitle'>网站会员管理</span></a></li>
										</ul>
									</li>
									<li><a href="javascript:;"><span class=" glyphicon glyphicon-lock"></span> <span class='zbt-dpt-menutitle'>权限管理</span></a></li>
									<li><a href="javascript:;"><span class=" glyphicon glyphicon-tower"></span> <span class='zbt-dpt-menutitle'>组织机构管理</span></a></li>
									<li><a href="javascript:;" menu-root="#menuroot1" class='zbt-dpt-menulink' isleaf=1><span class="glyphicon glyphicon-book"></span> <span class='zbt-dpt-menutitle'>基础数据管理</span></a></li>
								</ul>
							</li>
							<li id="menuroot2"><a href="#collapse-menu2"  data-toggle="collapse">
									<span class="glyphicon glyphicon-barcode"></span> <span class='zbt-dpt-menutitle'>产品管理</span>
									<span class="zbt-dtp-arrow"></span>
								</a>
								<ul id="collapse-menu2" class="collapse zbt-dtp-menu zbt-dtp-menu2">
									<li>
										<a href="#collapse-menu21"  data-toggle="collapse">
											<span class="glyphicon glyphicon-th"></span>
											<span class='zbt-dpt-menutitle'>产品策划</span>
											<span class="zbt-dtp-arrow"></span>
										</a>
										<ul id="collapse-menu21" class="collapse zbt-dtp-menu zbt-dtp-menu3">
											<li><a menu-root="#menuroot2" class='zbt-dpt-menulink' isleaf=1><span class="glyphicon glyphicon-th-list"></span> <span class='zbt-dpt-menutitle'>产品库</span></a></li>
										</ul>
										
									</li>
									<li>
										<a href="#collapse-menu22" data-toggle="collapse">
											<span class="glyphicon glyphicon-tower"></span>
											产品发布
											<span class="zbt-dtp-arrow"></span>
										</a>
										<ul id="collapse-menu22" class="collapse zbt-dtp-menu zbt-dtp-menu3">
											<li><a menu-root="#menuroot2" class='zbt-dpt-menulink' isleaf=1><span class="glyphicon glyphicon-th-list"></span> 已发布</a></li>
											<li><a menu-root="#menuroot2" class='zbt-dpt-menulink' isleaf=1><span class="glyphicon glyphicon-th-list"></span> 未发布</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					  </div>
					</div>
				  
				  </div>
				   <div class="col-md-12 zbt-dtp-appmain">
					<iframe src='' class='zbt-dtp-appmain-frame'></iframe>
				  </div>
				</div>
			<!--<div class="panel panel-default zbt-dtp-window">
				<div class="panel-heading">
				  <h3 class="panel-title zbt-dtp-panel-title"> 
					<span class="glyphicon glyphicon-home"></span>首页
						<div class="zbt-dtp-panel-tool">	
						  <span class="glyphicon glyphicon-chevron-down"></span>	
						  <span class="glyphicon glyphicon-chevron-up"></span>	
						  <span class="glyphicon glyphicon-fullscreen"></span>
						  <!--<span class="glyphicon glyphicon-resize-small"></span>
						  <span class="glyphicon glyphicon-remove"></span>
						</div>				
				  </h3>			 
				</div>
				<div class="panel-body">
				  首页<br/>
				  首页<br/>
				  首页<br/>
				  首页<br/>
				  首页<br/>
				</div>
			</div>-->
		</div>
		<!-- main end-->
	
  </div>
  <!-- <div class="footer nav navbar-inverse ">
		zorbit copy.
  </div> -->
  <script src="resources/common/lib/jq/jquery.js"></script>
  <script src="resources/common/lib/jq/jquery-ui.js"></script>
  <script src="resources/common/lib/bs3/js/bootstrap.min.js"></script>
  <script src="resources/common/js/data.js"></script>
  <script src="resources/common/js/desktop.js"></script>
  </body>
</html>