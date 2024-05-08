package scala.Sinulation

import Requests.AuthRequests
import _root_.Simulation.AuthScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class AuthSimulation extends Simulation {

  val baseUrl: String = ConfigProvider.getBaseUrl

  val requests = new AuthRequests()
  val scenario = new AuthScenario(requests)

  val httpProtocol = http
    .basicAuth(ConfigProvider.getUsername, ConfigProvider.getPassword)
    .baseUrl(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  setUp(
    scenario.scn.inject(constantUsersPerSec(1).during(5))
  ).protocols(httpProtocol)
}
