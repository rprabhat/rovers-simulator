package domain

import domain.Direction._
import domain.Instruction._


/**
  * Created by prabhat on 13/11/16.
  */

case class Location(x : Int, y : Int)
case class Plateau(lowerLeft: Location, upperRight: Location)

case class RoverPosition(position: Location, orientation : Direction) {

  def next(plateau: Plateau, instruction: Instruction) = {
    instruction match {
      case MOVE => orientation.checkBoundary(plateau, position) match {
        case true => RoverPosition(orientation.moveOneStep(position), orientation)
        case false => RoverPosition(position,orientation)
      }
      case spinInstruction : SpinInstruction =>  RoverPosition(position,orientation.turn(spinInstruction))
    }
  }

  override def toString = s"${position.x} ${position.y} ${orientation.toString}"
}

case class Rover(initialPosition: RoverPosition, instructions: List[Instruction])
case class Expedition(plateau: Plateau, squad: List[Rover])
