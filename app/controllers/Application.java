package controllers;

import models.User;
import org.reactivecouchbase.play.java.Couchbase;
import org.reactivecouchbase.play.java.CouchbaseBucket;
import play.*;
import play.libs.F;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static CouchbaseBucket bucket = Couchbase.bucket("default");

    public static F.Promise<Result> getUser(final String key) {
        return bucket.get(key, User.class).map(new F.Function<User, Result>() {
            @Override
            public Result apply(User user) throws Throwable {
                if (user == null) {
                    return badRequest("Unable to find user with key: " + key);
                }
                return ok(Json.toJson(user));
            }
        });
    }
}
