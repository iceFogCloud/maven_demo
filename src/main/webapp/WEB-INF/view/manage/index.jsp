<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">

    <title>Bootstrap Admin Template </title>
    <link rel="shortcut icon" href="${basePath}/img/favicon.ico">
    
    <!-- global stylesheets -->
    <link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${basePath}/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${basePath}/css/font-icon-style.css">
    <link rel="stylesheet" href="${basePath}/css/style.default.css" id="theme-stylesheet">

    <!-- Core stylesheets -->
    <link rel="stylesheet" href="${basePath}/css/ui-elements/card.css">
    <link rel="stylesheet" href="${basePath}/css/style.css">
</head>

<body> 

<!--====================================================
                         MAIN NAVBAR
======================================================-->        
    <header class="header">
        <nav class="navbar navbar-expand-lg ">
            <div class="search-box">
                <button class="dismiss"><i class="icon-close"></i></button>
                <form id="searchForm" action="#" role="search">
                    <input type="search" placeholder="Search Now" class="form-control">
                </form>
            </div>
            <div class="container-fluid ">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <div class="navbar-header">
                        <a href="index.html" class="navbar-brand">
                            <div class="brand-text brand-big hidden-lg-down"><img src="${basePath}/img/logo-white.png" alt="Logo" class="img-fluid"></div>
                            <div class="brand-text brand-small"><img src="${basePath}/img/logo-icon.png" alt="Logo" class="img-fluid"></div>
                        </a>
                        <a id="toggle-btn" href="#" class="menu-btn active">
                            <span></span>
                            <span></span>
                            <span></span>
                        </a>
                    </div>
                </div>
                <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                    <!-- Expand-->
                    <li class="nav-item d-flex align-items-center full_scr_exp"><a class="nav-link" href="#"><img src="${basePath}/img/expand.png" onclick="toggleFullScreen(document.body)" class="img-fluid" alt=""></a></li>
                    <!-- Search-->
                    <li class="nav-item d-flex align-items-center"><a id="search" class="nav-link" href="#"><i class="icon-search"></i></a></li>
                    <!-- Notifications-->
                    <li class="nav-item dropdown"> 
                        <a id="notifications" class="nav-link" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-bell-o"></i><span class="noti-numb-bg"></span><span class="badge">12</span></a>
                        <ul aria-labelledby="notifications" class="dropdown-menu">
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item nav-link">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-envelope bg-red"></i>You have 6 new messages </div>
                                        <div class="notification-time"><small>4 minutes ago</small></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item nav-link">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-twitter bg-skyblue"></i>You have 2 followers</div>
                                        <div class="notification-time"><small>4 minutes ago</small></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item nav-link">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-upload bg-blue"></i>Server Rebooted</div>
                                        <div class="notification-time"><small>4 minutes ago</small></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item nav-link">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-twitter bg-skyblue"></i>You have 2 followers</div>
                                        <div class="notification-time"><small>10 minutes ago</small></div>
                                    </div>
                                </a>
                            </li>
                            <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications                                            </strong></a></li>
                        </ul>
                    </li>
                    <!-- Messages                        -->
                    <li class="nav-item dropdown"> <a id="messages" class="nav-link logout" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-envelope-o"></i><span class="noti-numb-bg"></span><span class="badge">10</span></a>
                        <ul aria-labelledby="messages" class="dropdown-menu">
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"> <img src="${basePath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5 msg-nav-h3">Jason Doe</h3><span>Sent You Message</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"> <img src="${basePath}/img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5 msg-nav-h3">Frank Williams</h3><span>Sent You Message</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"> <img src="${basePath}/img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5 msg-nav-h3">Ashley Wood</h3><span>Sent You Message</span>
                                    </div>
                                </a>
                            </li>
                            <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>Read all messages    </strong></a></li>
                        </ul>
                    </li> 
                    <li class="nav-item dropdown"><a id="profile" class="nav-link logout" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="${basePath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle" style="height: 30px; width: 30px;"></a>
                        <ul aria-labelledby="profile" class="dropdown-menu profile">
                            <li>
                                <a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"> <img src="${basePath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5">Steena Ben</h3><span>steenaben@Businessbox.com</span>
                                    </div>
                                </a>
                                <hr>
                            </li>
                            <li>
                                <a rel="nofollow" href="profile.html" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-user "></i>My Profile</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="profile.html" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-envelope-o"></i>Inbox</div> 
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a rel="nofollow" href="profile.html" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-cog"></i>Setting</div>
                                    </div>
                                </a>
                                <hr>
                            </li>
                            <li>
                                <a rel="nofollow" href="profile.html" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-power-off"></i>Logout</div>
                                    </div>
                                </a> 
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item d-flex align-items-center"><a id="menu-toggle-right" class="nav-link" href="#"><i class="fa fa-bars"></i></a></li>
                    <nav id="sidebar-wrapper">
                      <div class="sidebar-nav"> 
                        <div class="tab" role="tabpanel"> 
                            <ul class="nav nav-tabs" role="tablist">
                              <li class="nav-item ">
                                <a class="nav-link active" href="#live" role="tab" data-toggle="tab"><i class="fa fa-globe"></i> Live</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="#trend" role="tab" data-toggle="tab"><i class="fa fa-rocket"></i> Trending</a>
                              </li> 
                            </ul> 
                            <div class="tab-content tabs">
                              <div role="tabpanel" class="tab-pane fade show active" id="live">
                                <h3>Connect Live</h3>
                                <div class="content newsf-list">
                                    <ul class="list-unstyled">
                                        <li class="border border-primary">
                                            <a rel="nofollow " href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">New Innovation world</h6>
                                                    <small>Tech soft is great innovation for...</small>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="border border-success">
                                            <a rel="nofollow" href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">Modified hand-cart</h6>
                                                    <small>The idea is to incorporate easy...</small>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="border border-info">
                                            <a rel="nofollow" href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-4.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
                                                    <small>A dot matrix printer modified at...</small>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="border border-primary">
                                            <a rel="nofollow" href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
                                                    <small>A dot matrix printer modified at...</small>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="border border-success">
                                            <a rel="nofollow" href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
                                                    <small>A dot matrix printer modified at...</small>
                                                </div>
                                            </a>
                                        </li> 
                                        <li class="border border-info">
                                            <a rel="nofollow" href="#" class=" d-flex">
                                                <div class="news-f-img"> <img src="${basePath}/img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                                <div class="msg-body">
                                                    <h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
                                                    <small>A dot matrix printer modified at...</small>
                                                </div>
                                            </a>
                                        </li> 
                                    </ul>
                                </div>
                              </div>
                              <div role="tabpanel" class="tab-pane fade" id="trend">
                                <div class="card card-c2" style="box-shadow: 0 0 0;">
                                    <div class="header">
                                        <h3 class="title">Trending Items</h3>
                                        <p class="category">Last Campaign Performance</p>
                                    </div>
                                    <div class="content">
                                        <canvas class="ct-chart" id="myChart4" height="250"></canvas>
                                        <div class="footer">
                                            <div class="legend">
                                                <i class="fa fa-circle text-info"></i> Open
                                                <i class="fa fa-circle text-danger"></i> Bounce
                                                <i class="fa fa-circle text-warning"></i> Unsubscribe
                                            </div>
                                            <hr>
                                            <div class="stats">
                                                <i class="fa fa-clock-o"></i> Campaign sent 2 days ago
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              </div>
                           </div>
                      </div>
                    </nav>
                </ul> 
            </div>
        </nav>
    </header>

<!--====================================================
                        PAGE CONTENT
======================================================-->
    <div class="page-content d-flex align-items-stretch">

        <!--***** SIDE NAVBAR *****-->
        <nav class="side-navbar">
            <div class="sidebar-header d-flex align-items-center">
                <div class="avatar"><img src="${basePath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                <div class="title">
                    <h1 class="h4">Steena Ben</h1>
                </div>
            </div>
            <hr>
            <!-- Sidebar Navidation Menus-->
            <ul class="list-unstyled">
                <li class="active"> <a href="index.html"><i class="icon-home"></i>Home</a></li>
                <li><a href="#apps" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Apps </a>
                    <ul id="apps" class="collapse list-unstyled">
                        <li><a href="calendar.html">Calendar</a></li> 
                        <li><a href="email.html">Email</a></li> 
                        <li><a href="media.html">Media</a></li> 
                        <li><a href="invoice.html">Invoice</a></li> 
                    </ul>
                </li>
                <li> <a href="chart.html"> <i class="fa fa-bar-chart"></i>Chart </a></li>
                <li><a href="#forms" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-building-o"></i>Forms </a>
                    <ul id="forms" class="collapse list-unstyled">
                        <li><a href="basic-form.html">Basic Form</a></li> 
                        <li><a href="form-layouts.html">Form Layouts</a></li> 
                    </ul>
                </li>
                <li> <a href="maps.html"> <i class="fa fa-map-o"></i>Maps </a></li>
                <li><a href="#pages" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-file-o"></i>Pages </a>
                    <ul id="pages" class="collapse list-unstyled">
                        <li><a href="faq.html">FAQ</a></li> 
                        <li><a href="empty.html">Empty</a></li> 
                        <li><a href="gallery.html">Gallery</a></li> 
                        <li><a href="login.html">Log In</a></li> 
                        <li><a href="register.html">Register</a></li> 
                        <li><a href="search-result.html">Search Result</a></li> 
                        <li><a href="404.html">404</a></li> 
                    </ul>
                </li>
                <li> <a href="tables.html"> <i class="icon-grid"></i>Tables </a></li> 
                <li><a href="#elements" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-globe"></i>UI Elements </a>
                    <ul id="elements" class="collapse list-unstyled">
                        <li><a href="ui-buttons.html">Buttons</a></li> 
                        <li><a href="ui-cards.html">Cards</a></li> 
                        <li><a href="ui-progressbars.html">Progress Bar</a></li> 
                        <li><a href="ui-timeline.html">Timeline</a></li>  
                    </ul>
                </li>
            </ul><span class="heading">Extras</span>
            <ul class="list-unstyled"> 
                <li> <a href="#"> <i class="icon-picture"></i>Demo </a></li>
            </ul>
        </nav>

        <div class="content-inner">

            <!--***** REPORT-1 *****-->     
            <div class="row" id="report1">
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-block">
                            <div class="text-left report1-cont">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-success"></i> $9,220</h2>
                                <span class="text-muted">Todays Income</span>
                            </div>
                            <span class="text-success">80%</span>
                            <div class="progress">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 80%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <p><small>Last month 10% Growth</small></p>
                        </div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-block">
                            <div class="text-left report1-cont">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-danger"></i> $5,530</h2>
                                <span class="text-muted">Gross Profit</span>
                            </div>
                            <span class="text-danger">43%</span>
                            <div class="progress">
                                <div class="progress-bar bg-danger" role="progressbar" style="width: 43%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <p><small>Last month 10% Growth</small></p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-block"> 
                            <div class="text-left report1-cont">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-warning"></i> $3,620</h2>
                                <span class="text-muted">Interest Expenses </span>
                            </div>
                            <span class="text-warning">53%</span>
                            <div class="progress">
                                <div class="progress-bar bg-warning" role="progressbar" style="width: 53%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <p><small>Last month 10% Growth</small></p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-block"> 
                            <div class="text-left report1-cont">
                                <h2 class="font-light m-b-0"><i class="ti-arrow-up text-info"></i> $82,600</h2>
                                <span class="text-muted">Net Profit</span>
                            </div>
                            <span class="text-info">70%</span>
                            <div class="progress">
                                <div class="progress-bar bg-info" role="progressbar" style="width: 70%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <p><small>Last month 10% Growth</small></p>
                        </div>
                    </div>
                </div>                
            </div>
 
            <!--***** REPORT-2 *****-->     
            <div class="row" id="report2">
                <div class="col-md-4">
                    <div class="card card-c1">
                        <div class="card-header card-chart" data-background-color="green">
                            <canvas class="ct-chart" id="myChart1" height="250"></canvas>
                        </div>
                        <div class="card-content">
                            <h4 class="title">Daily Sales</h4>
                            <p class="category">
                                <span class="text-success"><i class="fa fa-long-arrow-up"></i> 55% </span> increase in today sales.</p>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="fa fa-clock-o"></i> updated 4 minutes ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-c1">
                        <div class="card-header card-chart" data-background-color="orange">
                            <canvas class="ct-chart" id="myChart2" height="250"></canvas>
                        </div>
                        <div class="card-content">
                            <h4 class="title">Email Subscriptions</h4>
                            <p class="category">Last Campaign Performance</p>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="fa fa-clock-o"></i> campaign sent 2 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-c1">
                        <div class="card-header card-chart" data-background-color="red">
                            <canvas class="ct-chart" id="myChart3" height="250"></canvas>
                        </div>
                        <div class="card-content">
                            <h4 class="title">Completed Tasks</h4>
                            <p class="category">Last Campaign Performance</p>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="fa fa-clock-o"></i> campaign sent 2 days ago
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tlinks">Collect from <a href="http://www.bootstrapmb.com/" >企业网站模板</a></div>

            <!--***** REPORT-3 *****-->     
            <div class="row" id="report3">
                <div class="col-md-8">
                    <div class="card card-c2">
                        <table class="table table-hover">
                          <thead>
                            <div class="dropdown pull-right menu-sett-card"> 
                                <a id="notifications" class="nav-link" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-v men"></i> 
                                </a>
                                <ul aria-labelledby="notifications" class="dropdown-menu">
                                    <li>
                                        <a rel="nofollow" href="#" class="dropdown-item nav-link">Edit</a>
                                    </li>
                                    <li>
                                        <a rel="nofollow" href="#" class="dropdown-item nav-link">FAQ</a>
                                    </li>
                                    <li>
                                        <a rel="nofollow" href="#" class="dropdown-item nav-link">Support</a>
                                    </li> 
                                </ul>
                            </div>
                            <tr>
                              <th>Case Study</th>
                              <th>Target Date</th>
                              <th>Progress <!-- <i class="fa fa-ellipsis-v pull-right" ></i> -->
                              </th> 
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>Tech Wireframes</td>
                              <td>23/03/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 75%; height:10px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Mobile Boz</td>
                              <td>02/06/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 100%; height:10px;" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Reskel Soft</td>
                              <td>11/02/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 95%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Desan Shop</td>
                              <td>05/03/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 75%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr><tr>
                              <td>Effel Soft</td>
                              <td>24/02/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 100%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr><tr>
                              <td>Tech Box</td>
                              <td>01/09/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 55%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr><tr>
                              <td>Lesto Firm</td>
                              <td>15/12/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 85%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Technoborn</td>
                              <td>08/08/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 45%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Redor Books</td>
                              <td>18/08/2018</td>
                              <td>
                                <div class="progress">
                                  <div class="progress-bar bg-info" role="progressbar" style="width: 55%; height:10px;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-c2">
                        <div class="dropdown pull-right menu-sett-card" > 
                            <a id="notifications" class="nav-link" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-ellipsis-v men"></i> 
                            </a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">Edit</a>
                                </li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">FAQ</a>
                                </li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">Support</a>
                                </li> 
                            </ul>
                        </div>
                        <div class="header">
                            <h4 class="title">Email Statistics</h4>
                            <p class="category">Last Campaign Performance</p>
                        </div>
                        <div class="content">
                            <canvas class="ct-chart" id="polar-chart" height="250"></canvas>
                            <!-- <canvas class="ct-chart" id="myChart4" height="250"></canvas> -->
                            <div class="footer">
                                <div class="legend">
                                    <i class="fa fa-circle text-info"></i> Open
                                    <i class="fa fa-circle text-danger"></i> Bounce
                                    <i class="fa fa-circle text-warning"></i> Unsubscribe
                                </div>
                                <hr>
                                <div class="stats">
                                    <i class="fa fa-clock-o"></i> Campaign sent 2 days ago
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>

            <!--***** REPORT-4 *****-->    
            <div class="row" id="report4">
                <div class="col-md-4" id="card-1">
                    <div class="card card-inverse card-info">
                        <img class="card-img-top" src="${basePath}/img/card/c-1.jpg">
                        <div class="card-block"> 
                            <h4 class="card-title">Clean Tech Box </h4>
                            <div class="card-text">
                                Lorem Ipsum has been the industry's standard.
                            </div>
                        </div>
                        <div class="card-footer">
                            <small>Last updated 3 mins ago</small>
                            <button class="btn btn-info float-right btn-sm">Follow</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mt-0" id="card-2">
                    <div class="card hovercard">
                        <div class="cardheader"></div>
                        <div class="avatar">
                            <img alt="" src="${basePath}/img/avatar-1.jpg" class="img-fluid">
                        </div>
                        <div class="info">
                            <div class="title">
                                <a target="_blank" href="#">Steena Ben</a>
                            </div>
                            <div class="desc">Passionate designer</div>
                            <div class="desc">Curious developer</div>
                            <div class="desc">Tech geek</div>
                        </div>
                        <div class="bottom">
                            <a class="btn btn-primary btn-twitter btn-sm" href="https://twitter.com/webmaniac">
                                <i class="fa fa-twitter"></i>
                            </a>
                            <a class="btn btn-danger btn-sm" rel="publisher"
                               href="https://plus.google.com/+ahmshahnuralam">
                                <i class="fa fa-google-plus"></i>
                            </a>
                            <a class="btn btn-primary btn-sm" rel="publisher"
                               href="https://plus.google.com/shahnuralam">
                                <i class="fa fa-facebook"></i>
                            </a>
                            <a class="btn btn-warning btn-sm" rel="publisher" href="https://plus.google.com/shahnuralam">
                                <i class="fa fa-behance"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-c2">
                        <div class="dropdown pull-right menu-sett-card" > 
                            <a id="notifications" class="nav-link" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-ellipsis-v men"></i> 
                            </a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">Edit</a>
                                </li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">FAQ</a>
                                </li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item nav-link">Support</a>
                                </li> 
                            </ul>
                        </div>
                        <div class="header">
                            <h4 class="title">Newsfeed</h4>
                            <p class="category">Latest News Update</p>
                            <hr>
                        </div>
                        <div class="content newsf-list">
                            <ul class="list-unstyled">
                                <li class="border border-primary">
                                    <a rel="nofollow " href="#" class=" d-flex">
                                        <div class="news-f-img"> <img src="${basePath}/img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                        <div class="msg-body">
                                            <h3 class="h5 msg-nav-h3">New Innovation world</h3>
                                            <small>Tech soft is great innovation for...</small>
                                        </div>
                                    </a>
                                </li>
                                <li class="border border-success">
                                    <a rel="nofollow" href="#" class=" d-flex">
                                        <div class="news-f-img"> <img src="${basePath}/img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                        <div class="msg-body">
                                            <h3 class="h5 msg-nav-h3">Modified hand-cart steering</h3>
                                            <small>The idea is to incorporate easy...</small>
                                        </div>
                                    </a>
                                </li>
                                <li class="border border-info">
                                    <a rel="nofollow" href="#" class=" d-flex">
                                        <div class="news-f-img"> <img src="${basePath}/img/avatar-4.jpg" alt="..." class="img-fluid rounded-circle"></div>
                                        <div class="msg-body">
                                            <h3 class="h5 msg-nav-h3">Low cost Modern printer</h3>
                                            <small>A dot matrix printer modified at...</small>
                                        </div>
                                    </a>
                                </li> 

                            </ul> 
                        </div>
                    </div>
                </div> 
            </div> 

            <!--***** FOOTER *****-->    
            <div class="row" id="report4">
                <div class="col-md-3">
                    <div class="card text-center social-bottom sb-fb">
                        <i class="fa fa-facebook"></i>
                        <div>3250 +</div>
                        <p>Likes</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card text-center social-bottom sb-tw">
                        <i class="fa fa-twitter"></i>
                        <div>2345 +</div>
                        <p>Following</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card text-center social-bottom sb-gp">
                        <i class="fa fa-google-plus"></i>
                        <div>1253 +</div>
                        <p>Followers</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card text-center social-bottom sb-in">
                        <i class="fa fa-instagram"></i>
                        <div>4524 +</div>
                        <p>Likes</p>
                    </div>
                </div>
 Collect from <a href="http://www.bootstrapmb.com/" title="网页模板" target="_blank">网页模板</a>
                
            </div>

        </div>
    </div> 

    <!--Global Javascript -->
    <script src="${basePath}/js/jquery.min.js"></script>
    <script src="${basePath}/js/popper/popper.min.js"></script>
    <script src="${basePath}/js/tether.min.js"></script>
    <script src="${basePath}/js/bootstrap.min.js"></script>
    <script src="${basePath}/js/jquery.cookie.js"></script>
    <script src="${basePath}/js/jquery.validate.min.js"></script> 
    <script src="${basePath}/js/chart.min.js"></script> 
    <script src="${basePath}/js/front.js"></script> 
    
    <!--Core Javascript -->
    <script src="${basePath}/js/mychart.js"></script>
</body>

</html>