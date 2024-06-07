@import exercise.dto.users.UsersPage
@param UsersPage page


@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>

    @if(page.getUsers().isEmpty())
        <p>No users added yet</p>
    @else
        @for(var user: page.getUsers())
            <div>
                <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
                <p>${user.getLastName()}</p>
                <p>${user.getEmail()}</p>
                <p>${user.getId()}</p>
            </div>
        @endfor
    @endif
`
)