package Simulation

import Requests.AuthRequests
import io.gatling.core.Predef._

class AuthScenario(requests: AuthRequests) {
  val scn = scenario("Authentication Scenario")
    .exec(requests.basicAuthRequest)
    .pause(1)
    .exec(requests.bearerAuthRequest)
    .pause(1)
    .exec(requests.digestAuthRequest)
    .pause(1)
    .exec(requests.hiddenBasicAuthRequest)
}
