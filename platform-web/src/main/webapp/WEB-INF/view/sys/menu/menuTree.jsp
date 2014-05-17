<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>机构树菜单树 - ESY进销存管理系统</title>
		<meta name="keywords" content="esy,ESY进销存管理系统,进销存管理系统" />
		<meta name="description" content="esy,ESY进销存管理系统,进销存管理系统" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="/resources/common/lib/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/resources/common/lib/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="/resources/common/lib/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- page specific plugin styles -->
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<!-- ace styles -->
		<link rel="stylesheet" href="/resources/common/lib/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/resources/common/lib/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="/resources/common/lib/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="/resources/common/css/esy-subPage.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="/resources/common/lib/assets/css/ace-ie.min.css" />
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="/resources/common/lib/assets/js/ace-extra.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="/resources/common/lib/assets/js/html5shiv.js"></script>
		<script src="/resources/common/lib/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		
		<div class="row margin-0 padding-left-right-5">					
			<div class="col-sm-3 padding-0">
				<div class="widget-box">
					<div class="widget-header header-color-green2">
						<h4 class="lighter smaller">菜单列表</h4>
					</div>										
					<div class="widget-body">
						<p style='padding:5px;margin:0px;'>
							<button class="btn btn-info btn-xs">
								<i class="icon-plus bigger-160"></i>
								新增
							</button>
							<!--<button class="btn btn-primary btn-xs" >
								<i class="icon-edit bigger-160"></i>
								编辑
							</button>-->
							<button class="btn btn-success btn-xs" >
								<i class="icon-refresh bigger-160"></i>
								加载
							</button>
							<button class="btn btn-danger btn-xs">
								<i class="icon-trash bigger-160"></i>
								删除
							</button>
						</p>
						<div class="widget-main padding-8">
							<div id="tree2" class="tree"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9 padding-0">
				<div class="widget-box">
					<div class="widget-header header-color-blue2">
						<h4 class="lighter smaller">菜单详情</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
						<form class="form-horizontal" role="form" name="menuform" id="menuform" action="/sys/menu/menuSaveOrUpdate">
						<input type="hidden" name="uid" id="uid">
						<input type="hidden" name="ctype" id="ctype" value="1">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="cname">名称：</label>
								<div class="col-sm-9">
									<input type="text" id="cname" name="cname" placeholder="菜单名称" class="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="curl">url：</label>
									<div class="col-sm-9">
										<input type="text" id="curl" name="curl" placeholder="点击后跳转的页面" class="col-xs-10 col-sm-5" />
									</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="ctarget">target：</label>
									<div class="col-sm-9">
										<input  type="text" name="ctarget" class="col-xs-10 col-sm-5" id="ctarget" placeholder="页面跳转方式" />
									</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="ilevel">菜单级别：</label>

								<div class="col-sm-9">
									<div class="clearfix">
										<input class="input-sm" type="text" id="ilevel" name="ilevel" placeholder="root菜单请填写  0" />
										<label class="middle">
												<input class="ace" type="checkbox" name="ileaf" id="ileaf" value="1"/>
												<span class="lbl">是否为末节点</span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="nordernum">排序号：</label>

								<div class="col-sm-9">
									<input class="input-sm" type="text" id="nordernum" name="nordernum" placeholder="在当前一组菜单中的排序号" />
									<div class="space-2"></div>
									<div class="help-block" id="input-size-slider"></div>
								</div>
							</div>

						<!-- 	<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Grid Sizing</label>

								<div class="col-sm-9">
									<div class="clearfix">
										<input class="col-xs-1" type="text" id="form-field-5" placeholder=".col-xs-1" />
									</div>

									<div class="space-2"></div>

									<div class="help-block" id="input-span-slider"></div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Input with Icon</label>

								<div class="col-sm-9">
									<span class="input-icon">
										<input type="text" id="form-field-icon-1" />
										<i class="icon-leaf blue"></i>
									</span>

									<span class="input-icon input-icon-right">
										<input type="text" id="form-field-icon-2" />
										<i class="icon-leaf green"></i>
									</span>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-6">Tooltip and help button</label>

								<div class="col-sm-9">
									<input data-rel="tooltip" type="text" id="form-field-6" placeholder="Tooltip on hover" title="Hello Tooltip!" data-placement="bottom" />
									<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="More details." title="Popover on hover">?</span>
								</div>
							</div>

							<div class="space-4"></div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-tags">Tag input</label>

								<div class="col-sm-9">
									<input type="text" name="tags" id="form-field-tags" value="Tag Input Control" placeholder="Enter tags ..." />
								</div>
							</div> -->

							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="submit">
										<i class="icon-ok bigger-110"></i>
										提交
									</button>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="icon-undo bigger-110"></i>
										重置
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		<script type="text/javascript">
			var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
		</script>
		<!-- PAGE CONTENT ENDS -->
		<!-- basic scripts -->
		<!--[if !IE]> -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
		<!-- <![endif]-->
		<!--[if IE]>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<![endif]-->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/resources/common/lib/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->
		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='/resources/common/lib/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='/resources/common/lib/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="/resources/common/lib/assets/js/bootstrap.min.js"></script>
		<script src="/resources/common/lib/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="/resources/common/lib/assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="/resources/common/lib/assets/js/fuelux/fuelux.tree.min.js"></script>
		<!-- ace scripts -->
		<script src="/resources/common/lib/assets/js/ace-elements.min.js"></script>
		<script src="/resources/common/lib/assets/js/ace.min.js"></script>
		<script src="/resources/common/lib/jquery.form.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($){

				/* $('#tree1').ace_tree({
					dataSource: treeDataSource ,
					multiSelect:true,
					loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
					'open-icon' : 'icon-minus',
					'close-icon' : 'icon-plus',
					'selectable' : true,
					'selected-icon' : 'icon-ok',
					'unselected-icon' : 'icon-remove'
				});
				 */
				$('#tree2').ace_tree({
					dataSource: treeDataSource2 ,
					loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
					multiSelect:false,
					'open-icon' : 'icon-folder-open',
					'close-icon' : 'icon-folder-close',
					'selectable' : true,
					'selected-icon' : 'icon-ok',
					'unselected-icon' :'icon-remove'
				});



				/***/
				$('#tree2').on('loaded', function (evt, data) {
					//alert(1);
				});
		
				$('#tree2').on('opened', function (evt, data) {
				});
		
				$('#tree2').on('closed', function (evt, data) {
				});
				
				$('#tree2').on('selected', function (evt, data) {
					//alert("1");
				});
				
				//表单提交
				$('#menuform').on('submit', function(e) {
				    e.preventDefault(); // prevent native submit
				    $(this).ajaxSubmit({
				    	type:'POST',
				        success:function(data){
				        	alert(data.message);
				        	if(data.result){
				        		window.location.reload();
				        	}
				        }
				    });
				});
				
			});
		</script>
</body>
</html>
