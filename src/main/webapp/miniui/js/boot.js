﻿var bootPATH = '../miniui/';

mini_debugger = true;                                           //

var skin = getCookie("miniuiSkin") || 'cupertino';             //skin cookie   cupertino
var mode = getCookie("miniuiMode") || 'medium';                 //mode cookie     medium     

//miniui
document.write('<script src="' + bootPATH + '/js/jquery.min.js" type="text/javascript"></sc' + 'ript>');
document.write('<script src="' + bootPATH + '/js/miniui.js" type="text/javascript" ></sc' + 'ript>');
document.write('<link href="' + bootPATH + '/css/font-awesome.min.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + '/css/miniui.css" rel="stylesheet" type="text/css" />');

//common
document.write('<link href="' + bootPATH + '/css/common.css" rel="stylesheet" type="text/css" />');
document.write('<script src="' + bootPATH + '/js/common.js" type="text/javascript" ></sc' + 'ript>');

//skin
if (skin && skin != "default") document.write('<link href="' + bootPATH + '/css/skin.css" rel="stylesheet" type="text/css" />');

//mode
if (mode && mode != "default") document.write('<link href="' + bootPATH + '/css/medium-mode.css" rel="stylesheet" type="text/css" />');

//icon
document.write('<link href="' + bootPATH + '/css/icons.css" rel="stylesheet" type="text/css" />');

////////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}

function __CreateJSPath(js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}

