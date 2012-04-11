package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
	  // Comment from Yutong
    return ok(index.render("Your new application is ready."));
  }
  
}