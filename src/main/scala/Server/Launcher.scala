package Server

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import slick.jdbc.H2Profile.api.Database

import scala.concurrent.duration._
import scala.io.StdIn

object Launcher {

  //noinspection TypeAnnotation
  def main(args: Array[String]) {

    implicit val system = ActorSystem("Http-Server")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    implicit val db = Database.forConfig("h2emb")

    DBTools.init(5.seconds)

    val routes = new Routes(new ServicesImpl).routes

    val bindingFuture = Http().bindAndHandle(routes, "localhost", args(0).toInt)

    println(s"Server online at http://localhost:${args(0).toInt}/\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
