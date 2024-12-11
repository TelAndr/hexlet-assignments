@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
@if(page.getErrors() != null)
  <ul>
	  @for(var validator : page.getErrors().values())
		  @for(var error : validator)
			  <li>${error.getMessage()}</li>
		  @endfor
	  @endfor
  </ul>
@endif

<form action="/articles" method="post">
<div>
  <label>
	Название статьи
	<input type="text" name="title" value="${page.getTitle()}" />
  </label>
</div>
<div>
  <label>
	Содержимое статьи
	<textarea name="content" rows="4" cols="50" value="${page.getContent()}"></textarea><br>
  </label>
</div>
<input type="submit" value="Создать статью" />
</form>
</body>
</html>