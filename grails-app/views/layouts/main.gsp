<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Great Blog"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <r:require modules="scaffolding"/>
        <g:javascript library="jquery"/>
		<g:layoutHead/>
		<r:layoutResources />
        <style type="text/css">
            body{
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
	</head>
	<body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand"><i class="icon-home icon-white"></i>&nbsp;Blog</a>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <aside class="span3">
                    <g:link controller="post" action="create">Crear Post</g:link>
                    <g:pageProperty name="page.navigation"/>
                </aside>
                <section class="span9">
                    <g:pageProperty name="page.main"/>
                </section>
                <g:layoutBody/>
            </div>
        </div>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
