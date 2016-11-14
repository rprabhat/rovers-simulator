package domain

import domain.Instruction._

object Direction {

  sealed trait  Direction {
    def turn(instruction: SpinInstruction) : Direction
    def checkBoundary(plateau: Plateau, position:Location) : Boolean
    def moveOneStep(position:Location) : Location
  }

  object NORTH extends Direction{

    def turn(instruction: SpinInstruction) =
      instruction match {
        case SPIN_LEFT => WEST
        case SPIN_RIGHT => EAST
      }

    def checkBoundary(plateau: Plateau, position:Location) = position.y < plateau.upperRight.y

    def moveOneStep(position:Location) = position.copy(y = position.y + 1)

    override def toString = "N"
  }

  object SOUTH extends Direction{

    def turn(instruction: SpinInstruction) =
      instruction match {
        case SPIN_LEFT => EAST
        case SPIN_RIGHT => WEST
      }

    def checkBoundary(plateau: Plateau, position:Location) = position.y > plateau.lowerLeft.y

    def moveOneStep(position:Location) = position.copy(y = position.y - 1)

    override def toString = "S"
  }

  object EAST extends Direction{

    def turn(instruction: SpinInstruction) =
      instruction match {
        case SPIN_LEFT => NORTH
        case SPIN_RIGHT => SOUTH
      }

    def checkBoundary(plateau: Plateau, position:Location) = position.x < plateau.upperRight.x

    def moveOneStep(position:Location) = position.copy(x = position.x + 1)

    override def toString = "E"
  }

  object WEST extends Direction{

    def turn(instruction: SpinInstruction) =
      instruction match {
        case SPIN_LEFT => SOUTH
        case SPIN_RIGHT => NORTH
      }

    def checkBoundary(plateau: Plateau, position:Location) = position.x > plateau.lowerLeft.x

    def moveOneStep(position:Location) = position.copy(x = position.x - 1)

    override def toString = "W"
  }

  def withCode(dir : String) = dir match {
    case "N" => NORTH
    case "S" => SOUTH
    case "E" => EAST
    case "W" => WEST
  }

}



