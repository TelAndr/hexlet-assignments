@import exercise.dto.users.UsersPage
@param UsersPage users

<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <h1>List Of Users</h1>
        @if(users.getUsers().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var user : users.getUsers())
               <div>
                   <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                   <p>${user.toString()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>