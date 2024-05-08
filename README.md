# load-gatling-scala-example

This is an example test using [Gatling](https://gatling.io/). A minimal HTTP server is used as an example system under
test.

## Running Tests Using Gatling Maven Plugin

The gatling-test-maven plugin in your pom.xml is configured within a Maven profile named perf-test. To execute the tests, ensure that you enable the profile by including it when running the mvn test command.

mvn test -Pperf-test
The plugin is set up to execute a simulation class, which can be selected interactively via the console.

mvn gatling:test
Alternatively, if you want to run a specific simulation class, you can specify it using the gatling.simulationClass parameter.

mvn gatling:test -Dgatling.simulationClass=simulations.MySimulation
Remember to replace simulations.MySimulation with the fully qualified name of your simulation class.

The Test Results
This is an example test run result from the IDE.

Simulation gatling.test.example.simulation.ExampleSimulation completed in 20 seconds
Parsing log file(s)...
Parsing log file(s) done
Generating reports...

================================================================================
---- Global Information --------------------------------------------------------
> request count                                         20 (OK=20     KO=0     )
> min response time                                    120 (OK=120    KO=-     )
> max response time                                   1084 (OK=1084   KO=-     )
> mean response time                                   365 (OK=365    KO=-     )
> std deviation                                        264 (OK=264    KO=-     )
> response time 50th percentile                        364 (OK=364    KO=-     )
> response time 75th percentile                        505 (OK=505    KO=-     )
> response time 95th percentile                        847 (OK=847    KO=-     )
> response time 99th percentile                       1036 (OK=1036   KO=-     )
> mean requests/sec                                   2.22 (OK=2.22   KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                            18 (    90%)
> 800 ms <= t < 1200 ms                                  2 (    10%)
> t >= 1200 ms                                           0 (     0%)
> failed                                                 0 (     0%)
================================================================================

Reports generated in 0s.
Global: max of response time is less than 500.0 : true
Global: mean of response time is less than 1000.0 : true
Global: percentage of successful requests is greater than 95.0 : true

A more detailed test result in HTML can be found in target/results.

## Logback Configuration

This repository contains a sample Logback configuration file (logback.xml) for configuring logging in Java applications. Logback is a logging framework for Java, providing flexible and powerful features for logging.

### Configuration Details

The **logback.xml** file included in this repository configures logging for a Java application. Here's a breakdown of its key components:

#### Appender Configuration (STDOUT):

This configuration sets up a console appender named **STDOUT**, which logs messages to the standard output (console). The log messages are formatted using the specified pattern.

#### Pattern Layout Encoder:

Logback uses encoders to format log messages. In this configuration, the **PatternLayoutEncoder** is used to specify the pattern for formatting log messages. The pattern **%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n** formats log messages to include the timestamp, thread name, log level, logger name, and the actual log message.

#### Logger Configuration:

Loggers are used to control logging behavior for specific parts of the application. In this configuration, the logger named **io.gatling.http.engine.response** is specified. Logback supports different log levels, including TRACE, DEBUG, INFO, WARN, ERROR, and OFF. The INFO level indicates that only informational messages and higher will be logged for this logger.

### Types of Log Levels

Logback supports several log levels, each serving a different purpose:

**TRACE:** Provides the most detailed logging level, typically used for very fine-grained logging.
**DEBUG:** Used for debugging purposes, providing detailed information that can help in diagnosing issues.
**INFO:** Provides informational messages that highlight the progress or state of the application.
**WARN:** Indicates potential issues or situations that may require attention but do not necessarily indicate a critical problem.
**ERROR:** Indicates errors that require attention, potentially affecting the functionality or stability of the application.
**OFF:** Disables logging completely for the specified logger.

### Root Logger Configuration

The root logger configuration specifies the default log level for the entire application. In this configuration, the root logger's log level is set to **WARN**, which means that log messages with a level of **WARN** or higher will be logged to the console.


## Gatling Feeders

This repository explores the usage of feeders in Gatling simulations. Feeders in Gatling are a powerful feature that allows you to inject dynamic data into your simulations, enabling more realistic scenarios and diverse test data.

### What are Feeders?

Feeders in Gatling are mechanisms used to provide dynamic data to virtual users during simulation runs. They can read data from various sources such as CSV files, databases, or generate data dynamically. Gatling supports different types of feeders, including:

**CSV Feeders:** Read data from CSV (Comma-Separated Values) files and feed it into simulations.
**JSON Feeders:** Extract data from JSON (JavaScript Object Notation) files and use it in simulations.
**Custom Feeders:** Generate data dynamically using custom logic or external sources.

#### Usage

To use feeders in your Gatling simulations:

- Prepare your data: Ensure that your data is in a format supported by Gatling feeders, such as CSV or JSON.
- Configure the feeder: Define the feeder in your simulation script and specify how the data should be read or generated.
- Inject data into scenarios: Use the feeder to inject data into your simulation scenarios, allowing virtual users to interact with dynamic data during the test run.

#### Benefits

**Dynamic Data:** Feeders enable the injection of dynamic data into simulations, allowing for more realistic test scenarios.
**Data Diversity:** By using feeders, you can simulate various user behaviors and scenarios by feeding different data sets into your simulations.
**Scalability:** Feeders support large data sets and can handle high loads, making them suitable for performance testing scenarios.


`import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MySimulation extends Simulation {

val userFeeder: FeederBuilder = csv("users.csv").random

val scn: ScenarioBuilder = scenario("My Scenario")
.feed(userFeeder)
.exec(http("My Request")
.get("/api/resource/${userId}")
)

setUp(
scn.inject(
rampUsers(100) during (10 seconds)
)
).protocols(http.baseUrl("http://example.com"))
}
`


## Links

* Gatling: http://gatling.io
* Scala: http://scala-lang.org