import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {


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