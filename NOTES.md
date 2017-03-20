# Notes

** Important**: I don't know Java! The last time I used it Java 1.4 was the new hot thing. Please accept my apologies for the
non-idiomatic code dear reviewer, I spent most of the time re-learning the language. 

In order to complete the project in the given time I took a few shortcuts, most notably not doing any "smart" parsing of the
routes, and instead doing a HashSet based lookup. The only external dependencies are Spark for the
HTTP and Gson for JSON formatting.

Some things I would've liked to fix given more time:

* Use some sort of in-memory repo for the routes instead of passing args around.
* Parallelize!
* I would've liked to add tests to Spark but I could not get these to work.
* I would not consider this "production-ready" code, but given the time constraints plus my limited Java knowledge I'm happy to have arrived at a solution.
* Adding logging and more robust parameter validation.
