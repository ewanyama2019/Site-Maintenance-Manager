import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;
import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {


    // ------Page routing (referring to handle bars ------- //
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/engineer", (request, response) -> {
            return new ModelAndView(new HashMap(), "engineer.hbs");
        }, new HandlebarsTemplateEngine());


        get("/site", (request, response) -> {
            return new ModelAndView(new HashMap(), "site.hbs");
        }, new HandlebarsTemplateEngine());

        get("/faqs", (request, response) -> {
            return new ModelAndView(new HashMap(), "faqs.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (request, response) -> {
            return new ModelAndView(new HashMap(), "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}