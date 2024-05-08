package Requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.Sinulation.ConfigProvider

class AuthRequests() {

  val baseUrl: String = ConfigProvider.getBaseUrl

  val user: String = ConfigProvider.getUsername
  val password: String = ConfigProvider.getPassword
  val token: String = ConfigProvider.getToken


  val basicAuthRequest = http("Basic Auth Request")
    .get(baseUrl + "/basic-auth/" + user + "/" + password)
    .check(status.is(200))
    .check(bodyString.saveAs("responseBody"))

  val bearerAuthRequest = http("Failed Bearer Auth Request")
    .get(baseUrl + "/bearer")
    .header("Authorization", s"Bearer" + token)
    .check(status.is(400))

  val digestAuthRequest = http("Digest Auth Request")
    .get(baseUrl + "/basic-auth/" + user + "/" + password)
    .check(status.is(200))

  val hiddenBasicAuthRequest = http("Hidden Basic Auth Request")
    .get(baseUrl + "/basic-auth/" + user + "/" + password)
    .check(status.is(200))
}

