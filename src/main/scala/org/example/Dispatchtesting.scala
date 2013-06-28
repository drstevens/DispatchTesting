package org.example

import dispatch._, Defaults._
import com.typesafe.scalalogging.slf4j.Logging
import scala.util.{Failure, Success}
import scala.concurrent._
import scala.concurrent.duration._
import spray.json._
import spray.json.DefaultJsonProtocol._

case class Elevation(location: Location, elevation: Double)
case class Location(lat: Double, lng: Double)
case class GoogleApiResult[T](status: String, results: List[T])

object ElevationJsonProtocol extends DefaultJsonProtocol {
  implicit val locationFormat = jsonFormat2(Location)
  implicit val elevationFormat = jsonFormat2(Elevation)
  implicit def googleApiResultFormat[T :JsonFormat] = jsonFormat2(GoogleApiResult.apply[T])
}

object Dispatchtesting extends App with Logging {
  val svc = url("http://maps.googleapis.com/maps/api/elevation/json?locations=27.988056,86.925278&sensor=false")
  val result = Http(svc OK as.String)

  val raw = Await.result(result, 5 seconds)
  logger.info(raw)
  val jsonAST = raw.asJson
  logger.info(jsonAST.prettyPrint)

  import ElevationJsonProtocol._
  val elevation = jsonAST.convertTo[GoogleApiResult[Elevation]]
  logger.info("Status: " + elevation.status)
  logger.info("Elevations: " + elevation.results)
}
