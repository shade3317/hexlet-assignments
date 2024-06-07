@import exercise.dto.users.UsersPage
@param UsersPage page


<html lang="en">
<head>
    <title>Users list</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
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
    </main>
</div>
</body>
</html>