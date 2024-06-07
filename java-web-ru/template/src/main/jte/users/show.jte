@import exercise.dto.users.UserPage
@param UserPage page


<html lang="en">
<head>
    <title>User</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <h2>${page.getUser().getFirstName()}</h2>
        <p>${page.getUser().getLastName()}</p>
        <p>${page.getUser().getEmail()}</p>
        <p>${page.getUser().getId()}</p>
    </main>
</div>
</body>
</html>