<!DOCTYPE html>
<html>
<head>
    <title>Tourfirm</title>
</head>
<body>
<h1>Traveagency</h1><hr>
<h4>Подробная информация о туре: </h4>
<b>Название тура: </b> ${Tour.title}<br>
<b>Страна посещения: </b> ${Tour.country}<br>
<b>Описание: </b> ${Tour.description}<br>
<b>Цена тура: </b> ${Tour.price}<br>
<hr>
<form action="/TraveagencyTravels/edit/{id}${Tour.id}" method="post">
    <input type="submit" value="Изменить тур"/>
</form>

<form action="/tour/delete/${Tour.id}" method="post">
    <input type="submit" value="Удалить"/>
</form>


<a href="/TraveagencyTravels"> Назад </a>
</body>
</html>

