<!DOCTYPE html>
<html>
<head>
    <title>Tourfirm</title>
</head>
<body>
<h1>Traveagency admin</h1> <hr>
<h4>Добрый день администратор</h4>
<form action="/TraveagencyTravels/" method="get">
    Поиск по названию тура: <input type="text" name = "title"><br>
    <input type="submit" value="Поиск">
</form>

<#list Tours as tour>
    <div>
        <p><b>${tour.title}</b> ${tour.price} руб. | <a href="TraveagencyTravels/tour/${tour.id}"> Подробнее...</a>
            <a href = "/TraveagencyTravels/edit/${tour.id}"> Изменить! </a></p>
    </div>
<#else>
    <h3> Нету ни одной доступной путёвки( </h3>
</#list>
<form action="TraveagencyTravels/tour/create" method="post" enctype="multipart/form-data">
    Название путёвки: <input type="text" name="title"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Страна: <input type="text" name="country"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    <input type="submit" value="Добавить тур"/>
</form>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</body>
</html>