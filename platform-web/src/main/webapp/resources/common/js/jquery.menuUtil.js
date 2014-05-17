/**
 *base on JQuery
 *menusList 一级菜单
 *menusTop 顶级横向菜单
 *menusMap 子菜单
 *@author Rudy Zou
 */
(function ($){
	var pageList=new Array();
	// 在我们插件容器内，创造一个公共变量来构建一个私有方法
    var creatMenuAll = function(settings) {
        var appStr =recursionMenuAll(settings.menus,1,"","left");	
		return appStr;
    }
    var creatMenuLevel1 = function(settings) {
    	var appStr =recursionMenuLevel1(settings.menus,1,"","left");	
    	return appStr;
    }
    var creatMenuChildren = function(settings,$m) {
    	var oldsub = $m.siblings(".submenu");
    	if(oldsub.length<=0){
    		var $id = $m.parent().attr("id");
    		var $level = $m.attr("level");
        	var data = settings.menus.menusMap[$id];
        	var appStr="";
        	if(data){
        		appStr =recursionMenuChildren(data,$level,$id,"left");	
            	appStr = '<ul class="submenu">'+appStr+'</ul>';
        	}else{
        		$.ajax({
        			url:'',
        			cache:false,
        			async:true,
        			dataType:'json',
        			success:function(mlist){
        				data=mlist;
        				settings.menus.menusMap[uparentid]=data;
        			}
        		});
        		appStr =recursionMenuChildren(data,$level,$id,"left");	
            	appStr = '<ul class="submenu">'+appStr+'</ul>';
        	}
        	$m.siblings(".submenu").remove();
        	$m.after(appStr);
    	}
    }
	//递归菜单
	//type=left | top
	var recursionMenuAll=function(data,level,parentid,type){
		var mstr="";
		if(data){
			var mdata=null;
			if(level==1 && type == 'left'){
				mdata=data.menusFirst;
			}else if(level==1 && type == 'top' ){
				mdata=data.menusTop;
			}else{
				mdata=data;
			}
			if(type == 'left'){
				if(level==1){
					for(var i in mdata){
						 var nextmenu=data.menusMap[mdata[i].id];
						mstr += '<li parentid="'+parentid+'" id="'+mdata[i].id+'">';
								if(mdata[i].leaf==1){
									mstr += '<a href="javascript:;" target="'+mdata[i].target+'" url="'+mdata[i].url+'" level="'+mdata[i].level+'"  isleaf="1">';
										mstr += '<i class="'+mdata[i].icon+'"></i>';
										mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
									mstr += '</a>';
								}else{
									mstr += '<a href="javascript:;" class="dropdown-toggle getChildren" level="'+mdata[i].level+'" >';
										mstr += '<i class="'+mdata[i].icon+'"></i>';
										mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
										mstr += '<b class="arrow icon-angle-down"></b>';
									mstr += '</a>';
									mstr +='<ul class="submenu">';
										mstr +=recursionMenu(nextmenu,level+1,mdata[i].id,type);
									mstr +='</ul>';
								}
							+'</li>';
					}
					
				}else{
					for(var i in mdata){
						var nextmenu=mdata[i].children;
						mstr += '<li parentid="'+parentid+'" id="'+mdata[i].id+'">';
								if(mdata[i].leaf==1){
									mstr += '<a href="javascript:;" target="'+mdata[i].target+'" url="'+mdata[i].url+'" level="'+mdata[i].level+'"  isleaf="1">';
										mstr += '<i class="'+mdata[i].icon+'"></i>';
										mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
									mstr += '</a>';
								}else{
									mstr += '<a href="javascript:;" class="dropdown-toggle" level="'+mdata[i].level+'" >';
										mstr += '<i class="'+mdata[i].icon+'"></i>';
										mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
										mstr += '<b class="arrow icon-angle-down"></b>';
									mstr += '</a>';
									mstr +='<ul class="submenu">';
										mstr +=recursionMenu(nextmenu,level+1,mdata[i].id,type);
									mstr +='</ul>';
								}
							+'</li>';
					}
				}
				
			}
		}
		return mstr;
	}
	var recursionMenuLevel1=function(data,level,parentid,type){
		var mstr="";
		if(data){
			var mdata=null;
			if(level==1 && type == 'left'){
				mdata=data.menusFirst;
			}else if(level==1 && type == 'top' ){
				mdata=data.menusTop;
			}
			if(type == 'left'){
				if(level==1){
					for(var i in mdata){
						mstr += '<li parentid="'+parentid+'" id="'+mdata[i].id+'">';
						if(mdata[i].leaf==1){
							mstr += '<a href="javascript:;" target="'+mdata[i].target+'" url="'+mdata[i].url+'" level="'+mdata[i].level+'" isleaf="1">';
							mstr += '<i class="'+mdata[i].icon+'"></i>';
							mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
							mstr += '</a>';
						}else{
							mstr += '<a href="javascript:;" class="dropdown-toggle getChildren" level="'+mdata[i].level+'">';
							mstr += '<i class="'+mdata[i].icon+'"></i>';
							mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
							mstr += '<b class="arrow icon-angle-down"></b>';
							mstr += '</a>';
							/*mstr +='<ul class="submenu">';
										mstr +=recursionMenu(nextmenu,level+1,mdata[i].uid,type);
									mstr +='</ul>';*/
						}
						+'</li>';
					}
					
				}
				
			}
		}
		return mstr;
	}
	var recursionMenuChildren=function(data,level,parentid,type){
		var mstr="";
		if(data){
			var mdata=data;
			if(type == 'left'){
				for(var i in mdata){
					var nextmenu=mdata[i].children;
					mstr += '<li parentid="'+parentid+'" id="'+mdata[i].id+'">';
					if(mdata[i].leaf==1){
						mstr += '<a href="javascript:;" target="'+mdata[i].target+'" url="'+mdata[i].url+'" level="'+mdata[i].level+'"  isleaf="1">';
						mstr += '<i class="'+mdata[i].icon+'"></i>';
						mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
						mstr += '</a>';
					}else{
						mstr += '<a href="javascript:;" class="dropdown-toggle" level="'+mdata[i].level+'" >';
						mstr += '<i class="'+mdata[i].icon+'"></i>';
						mstr += '<span class="menu-text"> '+mdata[i].name+' </span>';
						mstr += '<b class="arrow icon-angle-down"></b>';
						mstr += '</a>';
						mstr +='<ul class="submenu">';
						mstr +=recursionMenuChildren(nextmenu,level+1,mdata[i].id,type);
						mstr +='</ul>';
					}
					+'</li>';
				}
				
			}
		}
		return mstr;
	}
	
	var recursionActive = function($p){
		if(($p.attr("class")&&$p.attr("class").indexOf("nav-list")!=1)||!$p.attr("class")){
			if($p.is("li")){
				$p.addClass("active");
			}
			recursionActive($p.parent());
		}
	}
	
	$.fn.menuUtil=function(options){
		
		// 获取我们的方法，遗憾的是，如果我们用function(method){}来实现，这样会毁掉一切的
        var method = arguments[0];
 
        // 检验方法是否存在
        if(methods[method]) {
 
            // 如果方法存在，存储起来以便使用
            // 注意：我这样做是为了等下更方便地使用each（）
            method = methods[method];
			// 我们的方法是作为参数传入的，把它从参数列表中删除，因为调用方法时并不需要它
            arguments = Array.prototype.slice.call(arguments, 1);
			
        // 如果方法不存在，检验对象是否为一个对象（JSON对象）或者method方法没有被传入
        } else if( typeof(method) == 'object' || !method ) {
 
            // 如果我们传入的是一个对象参数，或者根本没有参数，init方法会被调用
            method = methods.init;
        } else {
 
            // 如果方法不存在或者参数没传入，则报出错误。需要调用的方法没有被正确调用
            $.error( 'Method ' +  method + ' does not exist on jQuery.pluginName' );
            return this;
        }
 
        // 调用我们选中的方法
         // 用apply方法来调用我们的方法并传入参数
        return method.apply(this, arguments);
	}
	var methods={
		init:function(options){
			// 为了更好的灵活性，对来自主函数，并进入每个方法中的选择器其中的每个单独的元素都执行代码
            return this.each(function() {
                 var $this = $(this);
				 
                // 尝试去获取settings，如果不存在，则返回“undefined”
                 var settings = $this.data('pluginName');
 
                // 如果获取settings失败，则根据options和default创建它
                if(typeof(settings) == 'undefined') {
 
                    var defaults = {
							menus:{},
							contextPath:"",
							initLoadDeep:2
						}
					settings=$.extend(true,{},defaults,options);
 
                    // 保存我们新创建的settings
                    $this.data('menuUtil', settings);
					//界面创建
					var mstr = creatMenuLevel1(settings);
					$this.html(mstr);
					//界面效果处理
					var whei=$(window).height();
					$("#sidebar-collapse").width($this.width());
					$("#sidebar-collapse").offset({top:whei-27});
					
					$this.each(function () {
						var $this1 = $(this);
						$this1.slimScroll({
							height:$(window).height()-87-27,
							railVisible:true
						});
					});
					// 执行代码
					$(window).resize(function(){
						var areaHeight=$(window).height();
						$("#sidebar-collapse").offset({top:areaHeight-27});
						$this.each(function () {
							var $this1 = $(this);
							$this1.slimScroll({
								height:$(window).height()-87-27,
								railVisible:true
							});
						});
					});
					$("#sidebar-collapse").bind("click",function(){
						$(".esy-main-frame").css({"margin-left":"-"+$this.width()+"px","padding-left":$this.width()+"px"});
						$("#asy-sidebar-bar").hide();
						$("#sidebar-collapse").width($this.width());
					});
					
					$this.on('click', function(event) {//叶子节点点击
					  var $target =$(event.target || event.srcElement); 
					  var isleaf=$target.attr("isleaf");
					  var isleafp=$target.parent().attr("isleaf");
					  if(isleafp){
						isleaf=isleafp;
						$target=$target.parent();
					  }
					  if(isleaf){
						$(".active").removeClass("active");
						var frameTarget=$target.attr("target");
						var url = $target.attr("url");
						if(url){
							if(frameTarget!='_blank'){
								var htmlframe='<iframe class="esy-main-frame" src="'+settings.contextPath+url+'"></iframe>';
								$("#esy-main-content").html(htmlframe);
							}else{
								
							}
						}
						recursionActive($target);
					  }
					 
					});
					$(".getChildren").on('click',function(event){//获得子节菜单
						var $m = $(this);
						creatMenuChildren(settings,$m);
					});
                } else {
                    //如果我们获取了settings，则将它和options进行合并（这不是必须的，你可以选择不这样做）
                    settings = $.extend({}, settings, options);
 
                    // 如果你想每次都保存options，可以添加下面代码：
                    // $this.data('menuUtil', settings);
                }
				
            });
		},
		destroy: function(options) {
            // 在每个元素中执行代码
            return $(this).each(function() {
                var $this = $(this);
 
                // 执行代码
 
                // 删除元素对应的数据
                $this.removeData('menuUtil');
            });
        },
		loadSubMenu:function(deep){
		
		},
		setMessage:function(title,msg){
		
		},
		reloadPage:function(title){
		
		},
		loadPage:function(title){
		
		},
		closePage:function(title){
		},
		hidePage:function(title){
		}
	
	}

})(jQuery)