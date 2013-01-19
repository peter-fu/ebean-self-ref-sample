ebean-self-ref-sample
=====================

A sample app demonstrating the problem a query against a self-referenced model using ebean based on play-2.1-rc2

Usage
=====================

Simple run the app then access http://localhost:9000, the following json string will show up indicating that the third customer information is not fully loaded (it's only a reference).

[{"id":3,"name":null,"referredBy":{"id":1}},{"id":2,"name":null,"referredBy":{"id":1}},{"id":1}]
