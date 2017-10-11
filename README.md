# "Jeffstrap"

This is the skeleton I use to start postgres-based Google App Engine projects. The stack is:

 * Guice
 * JAXRS/Resteasy
 * Typescript, React, Webpack
 * Circle CI for deployment
 * Junit5 and AssertJ
 * Hibernate, Guice-Persist, Postgres
 * Flyway
 * Some custom utility libraries, gstrap and postguice

You can use this skeleton for Objectify/Cloud Datastore projects by deleting all the hibernate and flyway stuff. The Objectify setup is super easy by comparison.

## Testing

The test harness treats JAXRS methods as Java API calls to test. It takes some effort to set up a request environment that mirrors what would happen in an acutual appserver (eg, running PersistFilter). This is handled by the junit5 extensions enabled on `TestBase`, but it also requires all requests to the server to be executed as a closure. See `ThingsResourceTest` as an example.  
 
The libraries depended on are:

 * https://github.com/stickfigure/postguice
 * https://github.com/stickfigure/gstrap
 * https://github.com/stickfigure/gstrap-gae (optional)