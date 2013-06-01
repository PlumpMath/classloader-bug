package config

import test._
import play.api._
import play.api.mvc._
import play.api.Play.current

import views._

object Global extends GlobalSettings {
  private var _test: Test3 = _
  def test = _test

  override def onStart(app: Application) {
    super.onStart(app)
    _test = new Test3(new Test1)
  }
}

