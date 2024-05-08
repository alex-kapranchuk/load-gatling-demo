package scala.Requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.Sinulation.ConfigProvider


class MethodsRequests {

  val baseUrl: String = ConfigProvider.getBaseUrl

  val getRequest = http("GET Request")
    .get(baseUrl + "/get")
    .check(status.is(200))

  val postRequest = http("POST Request")
    .post(baseUrl + "/post")
    .body(StringBody(
      """
        |{
        |    "roomType": ${roomType},
        |    "hotelIdHS": ${hotelIdHS}.
        |    "roomNumber": ${roomNumber},
        |    "requestType": "${requestType}",
        |    }
        |"""
        .stripMargin))
    .check(status.is(200))

  val putRequest = http("PUT Request")
    .put(baseUrl + "/put")
    .body(StringBody("""{"key": "value"}""")).asJson
    .check(status.is(200))

  val deleteRequest = http("DELETE Request")
    .delete(baseUrl + "/delete")
    .check(status.is(200))
}
