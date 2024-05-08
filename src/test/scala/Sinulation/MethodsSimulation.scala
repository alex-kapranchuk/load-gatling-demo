package scala.Sinulation

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.Requests.MethodsRequests
import scala.Scenario.MethodsScenario


class MethodsSimulation extends Simulation {

  val config: Config = ConfigFactory.load("application.conf")
  val baseUrl: String = config.getString("conf.baseUrl")
  
  val requests = new MethodsRequests
  val scenario = new MethodsScenario(requests)

  val httpProtocol = http
    .baseUrl(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  setUp(
    scenario.scn.inject(atOnceUsers(5))
  ).protocols(httpProtocol)
}
