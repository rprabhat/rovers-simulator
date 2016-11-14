package domain

import domain.Direction.{SOUTH, WEST, NORTH}
import domain.Instruction.{SPIN_RIGHT, SPIN_LEFT, MOVE}
import org.scalatest._

/**
  * Created by prabhat on 14/11/16.
  */
class RoverSpec extends FlatSpec with ShouldMatchers {

  val plateau = Plateau(Location(0,0), Location(10,10))

  "Move instruction" should "should move rover" in {
    val nextPosition = RoverPosition(Location(1,3), NORTH).next(plateau, MOVE)
    nextPosition shouldEqual RoverPosition(Location(1,4), NORTH)
  }

  "Move instruction" should "should not move rover out of plateau " in {
    val nextPosition = RoverPosition(Location(10,10), NORTH).next(plateau, MOVE)
    nextPosition shouldEqual RoverPosition(Location(10,10), NORTH)

  }

  "Spin instruction" should "should turn rover" in {
    val initialPosition = RoverPosition(Location(1,3), NORTH)

    //90 degree turn
    initialPosition.next(plateau, SPIN_LEFT) shouldEqual RoverPosition(Location(1,3), WEST)
    initialPosition.next(plateau, SPIN_LEFT).next(plateau, SPIN_RIGHT) shouldEqual RoverPosition(Location(1,3), NORTH)

    //180 degree turn
    initialPosition.next(plateau, SPIN_LEFT).next(plateau, SPIN_LEFT) shouldEqual RoverPosition(Location(1,3), SOUTH)
    initialPosition.next(plateau, SPIN_RIGHT).next(plateau, SPIN_RIGHT) shouldEqual RoverPosition(Location(1,3), SOUTH)

    // 360 degree turn
    initialPosition.next(plateau, SPIN_LEFT).next(plateau, SPIN_LEFT).next(plateau, SPIN_LEFT).next(plateau, SPIN_LEFT) shouldEqual RoverPosition(Location(1,3), NORTH)
    initialPosition.next(plateau, SPIN_RIGHT).next(plateau, SPIN_RIGHT).next(plateau, SPIN_RIGHT).next(plateau, SPIN_RIGHT) shouldEqual RoverPosition(Location(1,3), NORTH)

  }

}
