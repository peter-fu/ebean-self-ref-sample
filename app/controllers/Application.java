package controllers;

import java.util.List;

import models.Customer;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;

public class Application extends Controller {

    public static Result index() {
        List<Customer> customers = Customer.find.orderBy("id desc").findList();
        return ok(Ebean.createJsonContext().toJsonString(customers));
    }

}
