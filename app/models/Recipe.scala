package models

import play.api.libs.json.{Json, OFormat}

case class Recipe(title: String, href: String, img: String)

object Recipe {
  implicit val recipeWrites: OFormat[Recipe] = Json.format[Recipe]

}
