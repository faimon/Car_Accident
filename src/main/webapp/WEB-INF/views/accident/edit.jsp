<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Автонарушители</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" style="width:60%" action="<c:url value='/edit?id=${accident.id}'/>"
      method="post">
    <fieldset>

        <!-- Form Name -->
        <legend class="text ml-3">Редактировать нарушение</legend>

        <div class="form-group">
            <div class="col-md-4">
                <input id="name" type="text" name="description" value="${accident.description}"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <div class="col-md-4">
                <input id="text" type="text" name="address" value="${accident.address}"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <div class="col-md-4">
                <input id="address" type="text" name="carNumber" value="${accident.carNumber}"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <div class="col-md-4">
                <input id="status" type="text" name="status" value="${accident.status}"
                       class="form-control input-md">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary">Добавить нарушение
                </button>
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>
