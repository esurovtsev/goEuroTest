# GoEuroTest

This is a solution for GoEuro development test. The solution is built mostly based on Spring Framework with Spring Boot
as a tool for creating stand-alone, production grade Spring based Application. The author is fully aware of the fact,
that using Spring for such an easy stand-alone App might be a bit of overhead here, but the idea keeping in mind while
working on this test was to demonstrate the ability of author not to do some pure java programming or having core java
knowledge, but to present the way author sees the modern web based apps must be built now-a-days (even that the task
itself doesn not cover such interesting and promissing topics as microservices, non blocking io or reactive programming
as good examples). By modern approach author here mostly means the path when the App is an architectural composite of
different well tested, approved by IT community and production ready components. Which allows to make the solution to
get up and running as quickly as possible.

Restrictions: Having certain time frame for doing the test some restrictions were applied to the final result, namely
* not the whole code was test covered, only critical places where author expected something to go wrong, were covered by tests
* no special solution for config service was provided, all necessary config data were directly injected into specific classes by Spring's @Value annotation
* no separate Spring profiles were created to split development and production environments.
