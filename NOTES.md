# Notes

The last time I used Java was almost 10 years ago so please accept my apologies for the
non-idiomatic code, I spent most of the time re-learning the language. In order to complete the
project in the given time I took a few shortcuts, most notably not doing any "smart" parsing of the
routes, and instead doing a HashSet based lookup. The only external dependencies are Spark for the
HTTP and Gson for JSON formatting.


Some things I would've liked to fix given more time:

* Use some sort of in-memory repository for the routes instead of passing args around.
* There's no reason not to parallelize the parsing of the routes.
* I'm not sure of what I'm doing with Maven so there will probably be dragons there.
* I would've liked to add tests to Spark but I could not get these to work.
