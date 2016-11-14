package domain

import domain.Direction.{EAST, SOUTH, WEST, NORTH}
import domain.Instruction.{SPIN_RIGHT, SPIN_LEFT, MOVE}
import org.scalatest.{ShouldMatchers, FlatSpec}


/**
  * Created by prabhat on 14/11/16.
  */
class DirectionSpec extends FlatSpec with ShouldMatchers {

  val plateau = Plateau(Location(0,0), Location(10,10))

  "spin " should "turn rover direction" in {
    NORTH.turn(SPIN_LEFT) shouldEqual WEST
    NORTH.turn(SPIN_RIGHT) shouldEqual EAST
  }

  "spin 360 degree " should "turn camera back to orignal direction" in {
    NORTH.turn(SPIN_LEFT).turn(SPIN_LEFT).turn(SPIN_LEFT).turn(SPIN_LEFT) shouldEqual NORTH
    NORTH.turn(SPIN_RIGHT).turn(SPIN_RIGHT).turn(SPIN_RIGHT).turn(SPIN_RIGHT) shouldEqual NORTH
  }

}