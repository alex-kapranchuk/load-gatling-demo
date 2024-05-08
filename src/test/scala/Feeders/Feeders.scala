package Feeders

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilderBase

object Feeders {

  def jsonFeed(path: String): FeederBuilderBase[Any] = {
    val feeders = jsonFile(path).random
    return feeders
  }
}
