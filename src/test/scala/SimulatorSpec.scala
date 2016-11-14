import domain.Direction.{EAST, NORTH}
import domain.{Location, RoverPosition}
import org.scalatest._
import parser.InputParser._

/**
  * Created by prabhat on 14/11/16.
  */
class SimulatorSpec extends FlatSpec with ShouldMatchers {

  val input =
    """5 5
      |1 2 N
      |LMLMLMLMM
      |3 3 E
      |MMRMMRMRRM""".stripMargin


  val result = parseAll(expeditionParser, input) match {
    case Success(expedition, _) =>
      Simulator.processExpedition(expedition)
    case Failure(msg, _) => println(msg)
    case Error(msg, _) => println(msg)
  }

  result shouldEqual List(RoverPosition(Location(1,3), NORTH),RoverPosition(Location(5,1), EAST) )
}
