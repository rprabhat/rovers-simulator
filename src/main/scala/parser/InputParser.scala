package parser

import domain._
import scala.util.parsing.combinator.JavaTokenParsers


/*
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
 */

object InputParser extends JavaTokenParsers {

  override val whiteSpace = """[ \t]+""".r
  val endOfLine = """[\r?\n]+""".r

  def coordinate = decimalNumber ^^ { case x => x.toInt}

  def location = coordinate ~ coordinate ^^ { case x ~ y => Location(x, y)}

  def plateau = location ^^ { case loc => Plateau(Location(0,0), loc)}

  def orientation = ("N" | "S" | "W" | "E") ^^ { case f => Direction.withCode(f)}

  def roverPosition = location ~ orientation ^^ { case loc ~ direction => RoverPosition(loc, direction) }

  def instruction = ("L" | "R" | "M") ^^ { case a => Instruction.withCode(a)}

  def rover = roverPosition ~ endOfLine ~ rep(instruction) <~ opt(endOfLine) ^^ {
    case roverPosition ~ e ~ instructions => Rover(roverPosition, instructions)
  }

  def expeditionParser: InputParser.Parser[Expedition] = plateau ~ endOfLine ~ rep(rover) ^^ {
    case plateau ~ e ~ rovers => Expedition(plateau, rovers)
  }

  def parse[T](parser: Parser[T], input: String) = {
    parseAll(parser, input)
  }
}
