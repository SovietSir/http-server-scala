package Server

import Server.DBActions._
import slick.jdbc.H2Profile.api.Database
import slick.jdbc.meta.MTable

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object DBTools {

  def init(duration: Duration)(implicit ec: ExecutionContext, db: Database): Unit = {
    Await.result(
      for {
        st <- db.run(MTable.getTables)
        _ <- if (!st.exists(t => t.name.name.equals(userTable.baseTableRow.tableName))) db.run(createUserTableAction)
        else Future.successful()
      } yield (),
      duration)
  }
}
