@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
	<title>User</title>
</head>
<body>
<h1>${page.getUser().getId()}</h1>
	<div>
		<h2><a href="/users/${page.getUser().getId()}"> ${page.getUser().getEmail()}</a></h2> 
		<p>${page.getUser().toString()}</p>
	</div>
</body>
</html>