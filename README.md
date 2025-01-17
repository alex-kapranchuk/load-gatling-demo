# Project load-gatling-scala-example

## Project Overview
This is an example test using [Gatling](https://gatling.io/). A minimal HTTP server is used as an example system under
test.


### Technology Stack
- Scala - Programming language
- Gatling - Load testing tool and reporting tool
- Maven - Build automation tool
- TypeSafe - Configuration and performance/scalability
- Jasypt - Java Simplified Encryption
- JsonFeeders - Test data generation

## Setup
I prefer manual configuration, so you need to add to your 
```bash 
pom.xml:
```
Dependancy and plugin followin this link [documentation and installation](https://docs.gatling.io/reference/integrations/build-tools/maven-plugin/).

## Running Tests Using Gatling Maven Plugin
```bash
mvn test -Pperf-test
```
The plugin is set up to execute a simulation class, which can be selected interactively via the console.
```bash
mvn gatling:test
```
Alternatively, if you want to run a specific simulation class, you can specify it using the gatling.simulationClass parameter.
```bash
mvn gatling:test -Dgatling.simulationClass=simulations.MySimulation
```
Remember to replace simulations.MySimulation with the fully qualified name of your simulation class.

## The Test Results
Test results are automatically generated upon test execution.
Documentation and examples of the reports are available [here](https://docs.gatling.io/reference/stats/reports/oss/).


#### Logger Configuration:

Loggers are used to control logging behavior for specific parts of the application.
Logback supports different log levels, including TRACE, DEBUG, INFO, WARN, ERROR, and OFF.
The INFO level indicates that only informational messages and higher will be logged for this logger.
