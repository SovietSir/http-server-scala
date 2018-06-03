package Server

import scala.concurrent.Future

trait DBActions {

  def get(): Future[Long]

  def post(user: String): Unit

}

object DBActions extends DBActions {

  override def get(): Future[Long] = Future.successful(1)

  override def post(user: String): Unit = {}
}
