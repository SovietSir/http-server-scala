package Server

import Server.DBActions._
import slick.jdbc.H2Profile.api.Database

import scala.concurrent.{ExecutionContext, Future}

class ServicesImpl(implicit db: Database, ec: ExecutionContext) extends Services {

  override def get(): Future[Int] = db.run(getUsers)

  override def post(user: String): Unit = db.run(insertUser(user))

}