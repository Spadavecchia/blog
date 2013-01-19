<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="main"/>
    <title>Create Post</title>
</head>
<body>
    <content tag="main">
        <g:if test="${message}">
            <bootstrap:alert class="alert-info">${message}</bootstrap:alert>
        </g:if>
        <g:hasErrors bean="${postInstance}">
            <bootstrap:alert class="alert-error">
                <ul>
                    <g:eachError bean="${postInstance}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                        <g:message error="${error}"/>
                    </li>
                    </g:eachError>
                </ul>
            </bootstrap:alert>
        </g:hasErrors>
        <h1>Create Post</h1>
        <hr/>
        <g:form action="create">
            <f:all bean="postInstance"/>
            <g:submitButton class="btn btn-primary" name="create">Crear</g:submitButton>
        </g:form>
    </content>
</body>
</html>
