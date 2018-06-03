package Server

import slick.jdbc.H2Profile.api._

object DBActions {

  lazy val userTable = TableQuery[UserTable]

  //-----------------Create table-----------------
  val createUserTableAction = userTable.schema.create

  //-----------------Try to put user-----------------
  def insertUser(user: String): DBIO[Int] = userTable += user

  //-----------------Get count of users-----------------
  val getUsers = userTable.length.result

}
