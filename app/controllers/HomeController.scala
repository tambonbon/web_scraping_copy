package controllers

import javax.inject._
import models.Recipe
import org.jsoup.Jsoup
import play.api.libs.json.Json
import play.api.mvc._

import scala.jdk.CollectionConverters._
/**
 * Recently I have encountered a very cool site with cooking recipes,
 * which had extremely poor UI, especially when using a mobile.
 * There was no official API, and so I have decided to build a web service
 * that would web scrape the content out of it, and publish it using RESTful API.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val sourceUrl: String = "https://daynauan.vn"
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  def showAll(pageId: String) = Action {implicit request =>
    // we are connecting to our website while passing the URL as a string
    val htmlDocument = Jsoup.connect(s"${sourceUrl}/thu-vien/cong-thuc-nau-an&page=${pageId}").get()
    //  let’s extract some specific elements from the raw HTML
    val recipesDomElements = htmlDocument.select("div.container .row").asScala
    // To extract specific elements from a single recipe, use the following:
    val recipeData = for(recipeElement <- recipesDomElements)
      yield Recipe(
        recipeElement.select(".box_wmid .txt_boxmid a").html(),
        sourceUrl + recipeElement.select(".txt_boxmid a").attr("href"),
        recipeElement.select("img").attr("src")
      )
    val r: Result = Ok(Json.toJson(recipeData))
    r
  }
  def showAllTest(pageId: String) = Action {implicit request =>
    // we are connecting to our website while passing the URL as a string
    val htmlDocument = Jsoup.connect(s"${sourceUrl}/thu-vien/cong-thuc-nau-an&page=${pageId}").get()
    //  let’s extract some specific elements from the raw HTML
    val recipesDomElements = htmlDocument.select("div.container .row").asScala
    // To extract specific elements from a single recipe, use the following:
    val recipeData = for(recipeElement <- recipesDomElements)
      yield Recipe(
        recipeElement.select(".box_wmid .txt_boxmid a").html(),
        sourceUrl + recipeElement.select(".txt_boxmid a").attr("href"),
        recipeElement.select("img").attr("src")
      )
    val r: Result = Ok(Json.toJson(recipeData))
    r
  }
  def showAllAbcdef(pageId: String) = Action {implicit request =>
    // we are connecting to our website while passing the URL as a string
    val htmlDocument = Jsoup.connect(s"${sourceUrl}/thu-vien/cong-thuc-nau-an&page=${pageId}").get()
    //  let’s extract some specific elements from the raw HTML
    val recipesDomElements = htmlDocument.select("div.container .row").asScala
    // To extract specific elements from a single recipe, use the following:
    val recipeData = for(recipeElement <- recipesDomElements)
      yield Recipe(
        recipeElement.select(".box_wmid .txt_boxmid a").html(),
        sourceUrl + recipeElement.select(".txt_boxmid a").attr("href"),
        recipeElement.select("img").attr("src")
      )
    val r: Result = Ok(Json.toJson(recipeData))
    r
  }

}
