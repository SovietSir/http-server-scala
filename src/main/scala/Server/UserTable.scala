package Server

import slick.jdbc.H2Profile.api._

class UserTable(tag: Tag) extends Table[String](tag, "users") {
  def user = column[String]("user", O.PrimaryKey)

  def * = user
}
