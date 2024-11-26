@import exercise.dto.users.UserPage
@param UserPage findUser

<html>
<head>
	<title>User</title>
</head>
<body>
	<div>
		<h2><a href="/users/${findUser.getUser().getId()}"> ${findUser.getUser().getEmail()}</a></h2> 
		<p>${findUser.getUser().toString()}</p>
	<div>
</body>
</html>