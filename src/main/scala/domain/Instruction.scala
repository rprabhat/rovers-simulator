package domain

/**
  * Created by prabhat on 13/11/16.
  */
object Instruction {

  sealed trait Instruction

  sealed  trait SpinInstruction extends Instruction
  object SPIN_LEFT extends SpinInstruction
  object SPIN_RIGHT extends SpinInstruction

  object MOVE extends Instruction

  def withCode(instr : String) = instr match {
    case "L" => SPIN_LEFT
    case "R" => SPIN_RIGHT
    case "M" => MOVE
  }
}



