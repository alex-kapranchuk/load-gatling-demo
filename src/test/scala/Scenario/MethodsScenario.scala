package scala.Scenario

import Feeders.Feeders.jsonFeed
import io.gatling.core.Predef._

import scala.Requests.MethodsRequests

class MethodsScenario(requests: MethodsRequests) {
  val scn = scenario("Methods Scenario")
    .feed(jsonFeed("JsonFeeders/feeders-data.json"))
    .exec(requests.getRequest)
    .pause(1)
    .exec(requests.postRequest)
    .pause(1)
    .exec(requests.putRequest)
    .pause(1)
    .exec(requests.deleteRequest)
}
