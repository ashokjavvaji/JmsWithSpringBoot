# JmsWithSpringBoot
JMS Producer and Consumer using Spring Boot JMS(ActiveMQ)  template

# Introduction
In this project, I am attempting to establish communication between two different applications via external JMS server.
This is a common behaviour for many applications.

There are two JMS queues that are created, One will handle the messages of type string, other will handle an object.

# Steps to execute
 1. Start ActiveMQ server.
 2. Navigate to jms-models and do mvn clean install to build the shared objects.
 3. Navigate to JmsProducer and do mvn clean install to build the producer application.
 4. Start the producer application as java -jar <path to jms-producer jar file>.
 5. In another terminal, navigate to JmsConsumer and do mvn clean install to the build the consumer application.
 6. Start the consumer application as java -jar <path to jms-consumer jar file>.
 7. Open Rest client like postman and connect to producer application running on port 9090 i.e. http://localhost:9090/
 8. GET request will send text messages, POST request will send object messages.
 9. Request body for POST shall contain 'number' and 'text' as values, where number is of type integer and text is of type String.
10. Launch browser and navigate to http://localhost:8080/ to view the messages received by the consumer.
  

Feel free to make changes and explore the world of possibilities.


Cheers!!! Happy Coding :-)
