package domain

import domain.Direction.{SOUTH, EAST, NORTH, WEST}
import domain.Instruction.{SPIN_RIGHT, MOVE, SPIN_LEFT}
import org.scalatest._

/**
  * Created by prabhat on 14/11/16.
  */
class InstructionSpec extends FlatSpec with ShouldMatchers {

  "short code " should "should create appropriate instruction" in {
    Instruction.withCode("L") shouldEqual SPIN_LEFT
    Instruction.withCode("R") shouldEqual SPIN_RIGHT
    Instruction.withCode("M") shouldEqual MOVE
  }

}