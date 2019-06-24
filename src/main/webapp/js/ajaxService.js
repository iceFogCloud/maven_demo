//ajaxService.js
//处理ajax业务

var basePath = '/'+window.location.pathname.split("/")[1];

function _ajaxRedirect(interfaceUrl){
	var urlPath = '';
	if(interfaceUrl.indexOf("http")!=-1){
		urlPath = interfaceUrl;
	}else{
		urlPath = basePath+interfaceUrl;
	}
	var htmlObj = $.ajax({url:urlPath,async:false,cache:false});
	
	console.log(htmlObj);
	//$("#pageContent").empty();
	$("#conItem").attr("src",urlPath);
}


