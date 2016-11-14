package parser

import domain.Direction._
import domain.Instruction._
import domain._
import org.scalatest.{ShouldMatchers, FlatSpec}
import parser.InputParser._

/**
  * Created by prabhat on 14/11/16.
  */
class InputParserSpec  extends FlatSpec with ShouldMatchers {

  "ExpeditionParser" should " extract expedition" in {

    val input = """5 5
                  |1 2 N
                  |LMLMLMLMM
                  |3 3 E
                  |MMRMMRMRRM""".stripMargin

    val expedition = InputParser.parseAll(InputParser.expeditionParser, input ) match {
      case Success(expd, _) => expd
      case Failure(msg, _) => msg
      case Error(msg, _) => msg
    }

    expedition shouldEqual Expedition(Plateau(Location(0,0),Location(5,5)),
                                     List(Rover(RoverPosition(Location(1, 2),NORTH ),
                                                List(SPIN_LEFT, MOVE, SPIN_LEFT, MOVE, SPIN_LEFT, MOVE,SPIN_LEFT, MOVE, MOVE)),
                                          Rover(RoverPosition(Location(3 ,3), EAST),
                                                List(MOVE, MOVE, SPIN_RIGHT, MOVE, MOVE, SPIN_RIGHT, MOVE, SPIN_RIGHT, SPIN_RIGHT, MOVE))))

  }

}
