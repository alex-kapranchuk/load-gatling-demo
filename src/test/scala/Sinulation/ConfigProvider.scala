package scala.Sinulation

import com.typesafe.config.{Config, ConfigFactory}

object ConfigProvider {
  private lazy val config: Config = ConfigFactory.load("application.conf")

  def getConfig: Config = config


  def getUsername: String = config.getString("conf.username")

  def getPassword: String = config.getString("conf.password")

  def getToken: String = config.getString("conf.token")

  def getBaseUrl: String = config.getString("conf.baseUrl")
}
