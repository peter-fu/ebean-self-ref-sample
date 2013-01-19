ebean-self-ref-sample
=====================

A sample app demonstrating the problem a query against a self-referenced model using ebean based on play-2.1-rc2

Usage
=====================

Simply run the app then access http://localhost:9000, the following json string will show up indicating that the third customer information is not fully loaded (it's only a reference).

[{"id":3,"name":"baz","referredBy":{"id":1}},{"id":2,"name":"Bar","referredBy":{"id":1}},{"id":1}]

### Additional SQL ###

Access http://localhost:9000/additional-sql and watch the output from console, there is an additional SQL executed when trying to access Customer(2)'s name.

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
