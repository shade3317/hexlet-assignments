@import exercise.dto.users.UserPage
@param UserPage page


@template.layout.page(
    content = @`
        <div>
            <h2>${page.getUser().getFirstName()}</h2>
            <p>${page.getUser().getLastName()}</p>
            <p>${page.getUser().getEmail()}</p>
            <p>${page.getUser().getId()}</p>
        </div>
    `
)
