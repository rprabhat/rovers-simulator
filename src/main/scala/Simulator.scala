import domain.{Expedition, RoverPosition}
import parser.InputParser._

/**
  * Created by prabhat on 14/11/16.
  */
object Simulator {

  def main(args: Array[String]) {

    val input =
      """5 5
        |1 2 N
        |LMLMLMLMM
        |3 3 E
        |MMRMMRMRRM""".stripMargin



    parseAll(expeditionParser, input) match {
      case Success(expedition, _) =>
        println(expedition)
        processExpedition(expedition).foreach( println(_))
      case Failure(msg, _) => println(msg)
      case Error(msg, _) => println(msg)
    }
  }

  def processExpedition(expedition: Expedition): List[RoverPosition] = {
    expedition.squad.map(rover => rover.instructions.foldLeft[RoverPosition](rover.initialPosition)
      {
       (position, instruction) =>
         //println(position, instruction)
         position.next(expedition.plateau, instruction)
      })
  }
}
