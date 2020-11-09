package controllers

import javax.inject.Inject
import play.api.routing.SimpleRouter
import play.api.routing.Router.Routes
import play.api.routing.sird._

class HomeRouter @Inject() (homeController: HomeController) extends SimpleRouter{
  val prefix = "/v1/recipes"
  def link(id: String): String = {
    import io.lemonlabs.uri.typesafe.dsl._
    val url = prefix / id.toString
    url.toString()
  }
  override def routes: Routes = {
    case GET(p"/") =>
      homeController.index
    case GET(p"/all/$id") =>
      homeController.showAll(id)
  }
}
