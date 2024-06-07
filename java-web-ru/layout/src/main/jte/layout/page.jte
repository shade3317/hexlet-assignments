@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/users">Users</a></li>
        </ul>
    </nav>
</header>
<div class="content">
    ${content}
</div>
<footer>
    <a href="https://github.com/shade3317">My GitHub</a>
</footer>
</body>
</html>