import java.io.{FileNotFoundException, IOException}

import domain.{Expedition, RoverPosition}
import parser.InputParser._

import scala.io.Source

/**
  * Created by prabhat on 14/11/16.
  */
object Simulator {

  def main(args: Array[String]) {

    if (args.length != 1)
      println("Usage: sbt \"run-main Simulator filename\"")
    else {

      val source = scala.io.Source.fromFile(args.head)
      try {
        val input = source.mkString
        //println(input)
        parseAll(expeditionParser, input) match {
          case Success(expedition, _) =>
            //println(expedition)
            processExpedition(expedition).foreach(println(_))
          case Failure(msg, _) => println("Invalid Input " + msg)
          case Error(msg, _) => println("Parsing Error " + msg)
        }

      } catch {
        case e: FileNotFoundException => println("Couldn't find input file.")
        case e: IOException => println("IOException.  Please provide valid input file.")
      } finally {
        source.close
      }

    }
  }

  def processExpedition(expedition: Expedition): List[RoverPosition] = {
    expedition.squad.map(rover =>
      rover.instructions.foldLeft[RoverPosition](rover.initialPosition) {
        (position, instruction) =>
          //println(position, instruction)
          position.next(expedition.plateau, instruction)
    })
  }
}
