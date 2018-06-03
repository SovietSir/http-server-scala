package Server

import akka.http.scaladsl.marshalling.{Marshaller, ToEntityMarshaller}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.{HttpEntity, HttpResponse}
import akka.http.scaladsl.model.ContentTypes.`text/plain(UTF-8)`


class Routes(actions: Services) {

  implicit val intMarshaller: ToEntityMarshaller[Int] = {
    Marshaller.withFixedContentType(`text/plain(UTF-8)`) { i => HttpEntity(i.toString) }
  }

  def routes: Route = {

    path("stat") {
      get {
        complete(actions.get())
      }
    } ~
      path("user") {
        (post & entity(as[String])) { user =>
          actions.post(user)
          complete(HttpResponse(entity = HttpEntity.Empty))
        }
      }
  }
}
