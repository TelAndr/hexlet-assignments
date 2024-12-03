@import exercise.dto.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
                <input type="search" required name="term" value="${usersPage.getTerm()}" />
                <input type="submit" value="Search" />
        </form>
		@if(!usersPage.getUsers().contains(null) && !usersPage.getUsers().isEmpty())
			@for(var user : page.getUsers())
				<div>
				    <p>${user.getFirstName()}${user.getLastName()}</p>
				</div>
			@endfor
		 @endif
    `
)

