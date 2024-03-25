# springb-boilerplate-hexagonal
This an boilerplate for SpringBoot using Hexagonal Architecture.

Em Tecnologia da Informação, um boilerplate é uma unidade de escrita que pode ser reutilizada continuamente sem alteração. Por extensão, a ideia às vezes é aplicada à programação reutilizável, como em "código boilerplate".

## How to Run the Application

### As a packaged application

Create an executable jar you can run your application using `java -jar`. For example:

`java -jar target/myproject-0.0.1-SNAPSHOT.jar`

It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

`java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/myproject-0.0.1-SNAPSHOT.jar`

### Using the Maven plugin

`mvn spring-boot:run`