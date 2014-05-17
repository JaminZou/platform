(function($){
	var methods={
		init:function(){//初始化方法
			var $m = this;
			//页面渐变显示
			$m["loadDeskItem"].apply($m,[]);
			//alert("------------loadDeskItem:"+_frame_deskicon.length);
			$(".zbt-dtp-show").hide();
			$(".zbt-dtp-show").fadeIn(1000);
			$m["loadIcon"].apply($m,[_frame_deskicon]);
			$(document).on("click", ".zbt-dtp-topbar-item> li> a", function() {//点击任务栏标签
				$m["switchdesk"].apply($m,[this]);
			});
			$(document).on("click", ".zbt-dtp-deskIcon", function() {//点击桌面图标
				$m["showdesk"].apply($m,[$(this)]);
			});
			$(".zbt-dtp-maindeskitem").click(function(){//返回主桌面
				$m["showmaindesk"].apply($m,[this]);
			});
			$('#wrap').on('hide.bs.collapse','.zbt-dtp-menubody', function (e) {
					var id=$(e.target).attr("id");
					var aToggle=$(".zbt-dtp-menubody").find("a[href=#"+id+"]").find(".zbt-dtp-arrow");
					var li_parent=$(".zbt-dtp-menubody").find("a[href=#"+id+"]").parent();
					aToggle.removeClass("zbt-dtp-arrow-open");
					li_parent.removeClass("zbt-dtp-active");
			}).on('show.bs.collapse','.zbt-dtp-menubody', function (e) {
					var id=$(e.target).attr("id");
					var aToggle=$(".zbt-dtp-menubody").find("a[href=#"+id+"]").find(".zbt-dtp-arrow");
					var li_parent=$(".zbt-dtp-menubody").find("a[href=#"+id+"]").parent();
					aToggle.addClass("zbt-dtp-arrow-open");
					var liSis = li_parent.siblings();
					liSis.removeClass("zbt-dtp-active");
					liSis.each(function(){
						$(this).children(".in").collapse("hide");
					});
					li_parent.addClass("zbt-dtp-active");
			});
			$('#wrap').on('click','.zbt-dtp-appleftmenu',function(e){
				var etarget=e.target;
				var $et=$(etarget);
				var classez=$et.attr("class");
				if(classez&&classez.indexOf("zbt-dtp-sidebar-toggler ")!=-1){//点击隐藏菜单
					var w = $(window.document).width();				
					var data_c=$et.attr("data-c");
					var row_p=$et.parent().parent().parent().parent();
					if(data_c=="l"){
						$et.html("&gt;");
						$et.attr("data-c","g");
						row_p.addClass("zbt-dtp-appleftmenu-close");
						var ifmw=w-40;
						$(".zbt-dtp-appmain").find("iframe").width(ifmw);
					}else{
						$et.html("&lt;");
						$et.attr("data-c","l");
						row_p.removeClass("zbt-dtp-appleftmenu-close");
						var ifmw=w-225;
						$(".zbt-dtp-appmain").find("iframe").width(ifmw);
					}
				}
				
				
			});
			$('#wrap').on('click','.zbt-dpt-menulink',function(e){//点击叶子节点菜单时，更改菜单定位
				var etarget=e.target;
				var $et=$(etarget);
				if($et.is("span")){
					$et=$et.parent();
				}
				var menuroot=$.trim($et.attr("menu-root"));//menu-root 不为空，说明是叶子节点
				var isleaf=$.trim($et.attr("isleaf"));
				if(isleaf==1&&menuroot){
					var deskid=$et.attr("deskid");
					var slidermenu=$("#zbt-dtp-sm"+deskid);
					var url=$et.attr("url");
					var ifmapp=$("#zbt-dtp-appmain-iframe-"+deskid);
					slidermenu.find(".zbt-dtp-loaded").removeClass("zbt-dtp-loaded");
					$(menuroot).addClass("zbt-dtp-loaded");
					slidermenu.find(".zbt-dtp-menubody").find("a[isleaf=1]").parent().removeClass("zbt-dtp-leaf-active");
					$et.parent().addClass("zbt-dtp-leaf-active");
					if(url){
						ifmapp.attr("src",url);
					}
				}
			});
		},
		loadIcon:function(data){//加载桌面图标
			var icondiv="";
			for(var i in data){
				icondiv +='<div class="col-xs-3 col-sm-2 col-md-1';
				if(data[i].classz){
				icondiv +=" "+data[i].classz;
				}
				icondiv +='"><a  href="javascript:void(0)" deskid="'
							+data[i].id+'" title="'+data[i].name+'" class="thumbnail zbt-dtp-deskIcon" itemIcon="'
							+data[i].itemIcon+'" data="'
							+data[i].url+'"><img data-src="holder.js/50x50" alt="80%x100" src="'+data[i].icon+'" /></a><div class="zbt-dtp-icontext">'+data[i].name+'</div></div>';
			}
			$(".zbt-dtp-iconContainer").html(icondiv);
		},
		showdesk:function($this){//点击图片时新建桌面
			var name=$this.attr("title");
			var classez=$this.attr("itemIcon");
			var deskid=$this.attr("deskid");
			var tagmenu=$("a[href=#"+deskid+"]");
			var url=$this.attr("data");
			if(tagmenu.length>0){//已经打开
				tagmenu.click();//显示
			}else{
				this["newapptab"].apply(this,[deskid,name,url,classez]);
			}
		},
		switchdesk:function(that){//切换桌面
			var bar=$(that);
			var deskid=bar.attr("href");
			var parent=bar.parent();
			$(".zbt-dtp-topbar-item").find(".active").removeClass("active");
			parent.addClass("active");
			$(".zbt-dtp-show").addClass("zbt-dtp-hide").removeClass("zbt-dtp-show").hide();
			$("[deskid="+deskid+"]").removeClass("zbt-dtp-hide").addClass("zbt-dtp-show").fadeIn(1000);
		},
		showmaindesk:function(that){//显示主桌面
			var bar=$(that);
			var deskid=bar.attr("href");
			var parentli=bar.parent();
			parentli.parent().find(".active").removeClass("active");
			parentli.addClass("active");
			$(".zbt-dtp-show").addClass("zbt-dtp-hide").removeClass("zbt-dtp-show").hide();
			$("[deskid="+deskid+"]").removeClass("zbt-dtp-hide").addClass("zbt-dtp-show").fadeIn(1000);
		},
		newapptab:function(deskid,name,url,classez){//创建新的应用tab
				var menuli=$('<li title="'+name+'" ><a href="#'+deskid+'"><span class="'+classez+'"></span></a></li>');
				var appStr1="";
				//加载菜单
				if(_frame_leftmenus[deskid]){
					//创建菜单
					appStr1 = this["createLeftMenu"].apply(this,[_frame_leftmenus[deskid],deskid,url]);
				}else{
					//通过deskid ajax加载左边菜单数据；
					this["loadLeftMenus"].apply(this,[deskid]);
					if(_frame_leftmenus[deskid]){
						//创建菜单
						appStr1 = this["createLeftMenu"].apply(this,[_frame_leftmenus[deskid],deskid,url]);
					}
				}
				var deskdiv=$('<div class="zbt-dtp-desk zbt-dtp-app" deskid="#'+deskid+'">'+appStr1+'</div>');
				$(".zbt-dtp-topbar-item").append(menuli);
				$("#wrap").append(deskdiv);
				//ajax加载html片段
				//@todo
				menuli.find("a").click();//显示
		},
		createLeftMenu:function(data,deskid,url){//创建菜单和main
				var appStr ="<div class='row' id='zbt-dtp-sm"+deskid+"'>";
				appStr+="	<div class='zbt-dtp-appleftmenu'>";
				appStr+="		<div class='zbt-dtp-menupanel' >";
				appStr+="			<div class='zbt-dtp-menuheading nav navbar-inverse'>";
				appStr+="				<div>";
				appStr+="					<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#zbt-dtp-sm"+deskid+"'>";
				appStr+="						<span class='icon-bar'></span>";
				appStr+="						<span class='icon-bar'></span>";
				appStr+="						<span class='icon-bar'></span>";
				appStr+="					</button>";
				appStr+="				</div>";
				appStr+="				<div data-c='l' class='zbt-dtp-sidebar-toggler visible-md visible-lg'>&lt;</div>";
				appStr+="			</div>";
				appStr+="			<div class='collapse in zbt-dtp-menubody'>";
				appStr+=this["recursionMenu"].apply(this,[data,1,deskid,deskid]);
				appStr+="			</div>";
				appStr+="		</div>";
				appStr+="	</div>";
				appStr+="	<div class='col-md-12 zbt-dtp-appmain'><iframe src='"+url+"' id='zbt-dtp-appmain-iframe-"+deskid+"' class='zbt-dtp-appmain-frame'></iframe>";
				appStr+="	</div>";
				appStr+="</div>";
				return appStr;
		},
		recursionMenu:function(data,level,parentid,deskid){//递归菜单
				var appStrrec ="";
				if(level==1){
					appStrrec +="				<ul id='cm_"+level+"_"+parentid+"' class='collapse in zbt-dtp-menu zbt-dtp-menu"+level+"'>";
				}else{
					appStrrec +="				<ul id='cm_"+level+"_"+parentid+"' class='collapse zbt-dtp-menu zbt-dtp-menu"+level+"'>";
				}
				
				var nextLevel=eval(level+1);
				for(var i in data){//一级菜单循环
					var menu_first=data[i];
					var children=menu_first.children;
				appStrrec+="					<li id='mid_"+level+"_"+menu_first.id+"'>";
				
					if(children&&children.length>0){//是否有子菜单
				appStrrec+="						<a href='#cm_"+nextLevel+"_"+menu_first.id+"' data-toggle='collapse'>";
					}else{
				appStrrec+="						<a href='javascript:;' deskid='"+deskid+"' class='zbt-dpt-menulink' url='"+menu_first.url+"' menu-root='#mid_1_"+menu_first.menuroot+"' isleaf="+menu_first.isleaf+">";	
				
					}
				appStrrec+="							<span class='"+menu_first.icon+"'></span> <span class='zbt-dpt-menutitle'>"+menu_first.name+"</span>";
					if(children&&children.length>0){//是否有子菜单
				appStrrec+="							<span class='zbt-dtp-arrow'></span> ";
					}
				appStrrec+="						</a>";
					if(children&&children.length>0){//是否有子菜单
						appStrrec+=this["recursionMenu"].apply(this,[children,nextLevel,menu_first.id,deskid]);
					}
				
				appStrrec+="					</li>";
				}
				appStrrec+="				</ul>";
				return appStrrec;
		},
		loadDeskItem:function(){
			$.ajax({
				url:'deskItems',
				type:'get',
				dataType:'json',
				cache:false,
				async:false,
				success:function(data){
					if(data){
						_frame_deskicon = data;
					}
				}
			});
		},
		loadLeftMenus:function(itemid){
			$.ajax({
				url:'leftMenus',
				type:'get',
				dataType:'json',
				cache:false,
				async:false,
				data:{"itemid":itemid},
				success:function(data){
					if(data){
						_frame_leftmenus[itemid]=data;
					}
				}
			});
		}
	};
	$(function(){
		methods["init"].apply(methods,[]);
	});
})(jQuery);