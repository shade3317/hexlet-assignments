package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Collections;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName  = ctx.formParamAsClass("lastName",  String.class).get();
        var email     = ctx.formParamAsClass("email",     String.class).get();
        var password  = ctx.formParamAsClass("password",  String.class).get();

        var token = Security.generateToken();
        ctx.cookie("token", token);

        var user = new User(firstName, lastName, email, Security.encrypt(password), token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var token = ctx.cookie("token");
        var id    = ctx.pathParamAsClass("id", Long.class).get();
        var user  = UserRepository.find(id);

        user.ifPresentOrElse(u -> {
            if (u.getToken().equals(token)) {
                var page = new UserPage(user.get());
                ctx.render("users/show.jte", model("page", page));
            } else {
                ctx.redirect(NamedRoutes.buildUserPath());
            }
        }, () -> {throw new NotFoundResponse("Пользовотель с id: " + id + " не найден");});
    }
    // END
}
