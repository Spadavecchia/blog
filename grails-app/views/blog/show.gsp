<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="main">
    <title>First Blog</title>
</head>
<body>
    <content tag="main">
        <g:if test="${flash.message}">
            <bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
        </g:if>
        <h1>${blogInstance.title}</h1>
        <h5>${blogInstance.subtitle}</h5>
        <g:render template="entry" collection="${blogInstance.entries}"/>
    </content>
</body>
</html>
