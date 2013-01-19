package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Customer extends Model {

    private static final long serialVersionUID = 7354474616581328607L;

    @Id
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "referred_by_id")
    public Customer referredBy;

    /**
     * Generic query helper for entity Customer with id Long
     */
    public static Finder<Long, Customer> find = new Finder<Long, Customer>(
            Long.class, Customer.class);

}
