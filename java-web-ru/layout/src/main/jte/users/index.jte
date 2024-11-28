@import exercise.hexlet.dto.UsersPage
@param UsersPage page

@template.layout.page(
    header = @`
        <a href="/">Главная</a>
        <a href="/users">All Users</a>`,
    footer = @`
        <p>Look all the users</p>`
    content = @`
        @for(var user : page.getUsers()) {
            <div>
                <p>${user.getFirstName()}</p>
                <p>${user.getLastName()}</p>
                <p>${user.getEmail()}</p>
            </div>
        }
        @endfor
    `
)