package controllers;

import java.util.ArrayList;
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
        Logger.debug("Accessing Customer(2)'s name");
        String name = customers.get(2).name;
        Logger.debug("Before converting to JSON");
        return ok(Ebean.createJsonContext().toJsonString(customers));
    }

    public static Result persistenceConext() {
        Logger.debug("Application.persistenceConext");

        List<Customer> customers = new ArrayList<Customer>();

        Ebean.beginTransaction();
        Logger.debug("Begin transaction");

        try {
            Logger.debug("Get Customer(3)");
            Customer c3 = Customer.find.byId(3L);
            Logger.debug("Get Customer(1)");
            Customer c1 = Customer.find.byId(1L);

            customers.add(c3);
            customers.add(c1);
        } finally {
            Ebean.endTransaction();
            Logger.debug("End transaction");
        }

        Logger.debug("Before converting to JSON");
        return ok(Ebean.createJsonContext().toJsonString(customers));
    }

}
