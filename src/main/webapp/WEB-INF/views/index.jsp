<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
    <style>
        <%@include file="/WEB-INF/views/css/index.css" %>
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
                        <h2>Автонарушители</h2>
                    </div>
                    <div class="col-sm-7">
                        <a href="<c:url value='/create'/>" class="btn btn-secondary"><i
                                class="material-icons">&#xE147;</i>
                            <span>Добавить нарушение</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th class="col">Описание нарушения</th>
                    <th class="col">Адрес нарушения</th>
                    <th class="col">Номер автомобиля</th>
                    <th class="col">Фото нарушения</th>
                    <th class="col">Статус нарушения</th>
                    <th class="col">Действие</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${accidents}" var="accident">
                    <tr>
                        <td><c:out value="${accident.description}"/></td>
                        <td><c:out value="${accident.address}"/></td>
                        <td><c:out value="${accident.carNumber}"/></td>
                        <td>
                            <a href="<c:url value='/image?filename=${accident.photoPath}'/>">
                                <img src="<c:url value='/image?filename=${accident.photoPath}'/>"
                                     style="width:100px;height:100px">
                            </a>
                        </td>
                        <td>
                            <c:if test="${accident.status == 'Принята'}">
                            <span class="badge badge-success"> <c:out value="${accident.status}"/>
                                </c:if></span>
                                <c:if test="${accident.status == 'Завершена'}">
                                <span class="badge badge-secondary"> <c:out value="${accident.status}"/>
                                    </c:if></span>
                        </td>
                        <td>
                            <a href="<c:url value='/edit?id=${accident.id}'/>" class="settings" title=""
                               data-toggle="tooltip" data-original-title="Редактировать"><i class="material-icons"></i></a>
                            <a href="<c:url value='/delete?id=${accident.id}'/>" class="delete" title=""
                               data-toggle="tooltip" data-original-title="Удалить"><i
                                    class="material-icons"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>