## JP Morgan

This is a simple exercise which resolves the problem defined.
 

### Prerequisites
It is required JAVA 8 to run this application.

#### Creating the jar

```mvn package and it will generate de jar
```

#### Running tests

```mvn test and it will run all tests this application contains
```

#### Testing the Service

We have made some junit tests to cover all the functionalities defined in this application.

```mvn test and it will run all tests this application contains
```

### Decisions made

We decided to define this project considering the different layers we could have in a real system. That is the reason why we defined DTO's, services, repositories, etc.
In a real system, this kind of definition could let us to reuse these services in other applications for laptops, tablets, smartphones...
With this example, it could be easily migrated to a REST service (the structure is very similar) to start using it.
