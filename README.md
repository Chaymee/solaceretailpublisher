# solaceretailpublisher
 Publisher to create sample retail data and publish to solace broker

# To Run
Update the destination broker configuration in the `src/main/resources/application.properties` file co match the
connection parameters for your Solace PubSub+ Broker.  

Note you need to use java 18 or newer.
use `gradlew bootRun`
to build and run the publisher.