import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/compactdisks/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/CD_Form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/compactdisks", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("compactdisks", CompactDisk.all());
      model.put("template", "templates/compactdisks.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/compactdisks", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String title = request.queryParams("title");
      String artist = request.queryParams("artist");
      CompactDisk newCompactDisk = new CompactDisk(title, artist);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
