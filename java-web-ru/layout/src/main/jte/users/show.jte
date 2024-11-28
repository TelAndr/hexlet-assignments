@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    header = @`
        <a href="/">Главная<a>
        <a href="/users">All Users</a>`,
    footer = @`
        <p>Find a special user</p>`,
    content = @`
        <p>${page.getUser().getFirstName()}.</p>
        <p>${page.getUser().getLastName()}.</p>
        <p>${page.getUser().getEmail()}.</p>
    `
)