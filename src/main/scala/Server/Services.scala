package Server

import scala.concurrent.Future

trait Services {

  def get(): Future[Int]

  def post(user: String): Unit

}
