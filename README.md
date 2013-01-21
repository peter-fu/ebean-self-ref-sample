ebean-self-ref-sample
=====================

A sample app demonstrating the problem about query against a self-referenced model using ebean based on Play-2.1-RC2.

Usage
=====================

Simply run the app then access [http://localhost:9000](http://localhost:9000), the following json string will show up indicating that the third customer information is not fully loaded (it's only a reference).

```
[{"id":3,"name":"baz","referredBy":{"id":1}},{"id":2,"name":"Bar","referredBy":{"id":1}},{"id":1}]
```

### Persistence Context ###

Access [http://localhost:9000/persistence-context](http://localhost:9000/persistence-context), the following json string will show up indicating that the information of Customer(1) is not fully loaded (it's only a reference).

```
[{"id":3,"name":"baz","referredBy":{"id":1}},{"id":1}]
```

Console output

```
[debug] application - Application.persistenceConext
[debug] application - Begin transaction
[debug] application - Get Customer(3)
[debug] c.j.b.PreparedStatementHandle - select t0.id c0, t0.name c1, t0.referred_by_id c2 
from customer t0
where t0.id = 3  
[debug] application - Get Customer(1)
[debug] application - End transaction
[debug] application - Before converting to JSON
```

There is even no SQL executed for Customer.find.byId(1L).

### Additional SQL ###

Access [http://localhost:9000/additional-sql](http://localhost:9000/additional-sql) and watch the output from console, there is an additional SQL executed when trying to access Customer(2)'s name.

```
[debug] application - Application.additionalSql
[debug] c.j.b.PreparedStatementHandle - select t0.id c0, t0.name c1, t0.referred_by_id c2 
from customer t0 
order by t0.id desc
[debug] application - Accessing customer(2)'s name
[debug] c.j.b.PreparedStatementHandle - select t0.id c0, t0.name c1, t0.referred_by_id c2 
from customer t0
where t0.id = 2  
[debug] application - Before converting to JSON
```
