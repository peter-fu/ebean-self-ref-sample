package controllers;

import java.util.List;

import models.Customer;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;

public class Application extends Controller {

    public static Result index() {
        Logger.debug("Application.index");
        List<Customer> customers = Customer.find.orderBy("id desc").findList();
        Logger.debug("Before converting to JSON");
        return ok(Ebean.createJsonContext().toJsonString(customers));
    }

    public static Result additionalSql() {
        Logger.debug("Application.additionalSql");
        List<Customer> customers = Customer.find.orderBy("id desc").findList();
        Logger.debug("Accessing customer(2)'s name");
        String name = customers.get(2).name;
        Logger.debug("Before converting to JSON");
        return ok(Ebean.createJsonContext().toJsonString(customers));
    }

}
