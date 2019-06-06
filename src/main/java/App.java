import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Site;


public class App {

//    static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder =new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt((processBuilder.environment().get("PORT")));
//        }
//        return 4567; //return default port if heroku if heroku-port isn't set (i.e. on localhost)
//    }
//
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


    // ------Page routing (referring to handle bars ------- //
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sites", (request, response) -> {
            return new ModelAndView(new HashMap(), "sites.hbs");
        }, new HandlebarsTemplateEngine());

        get("/engineers", (request, response) -> {
            return new ModelAndView(new HashMap(), "engineers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/faqs", (request, response) -> {
            return new ModelAndView(new HashMap(), "faqs.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (request, response) -> {
            return new ModelAndView(new HashMap(), "success.hbs");
        }, new HandlebarsTemplateEngine());



    }
}