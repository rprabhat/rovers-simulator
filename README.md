# rovers-simulator

Simulates movement of  multiple rovers.

## Implementation

Direction, instruction and rover details are represented as type classes. 
Rover movement is based on its orientation with plataeu as boundary.

Expedition instructions is parsed using scala parser-combinator. 
Rover movement is simulated as fold over rovers position using parsed instruction.

   -- sbt compile
   -- sbt test 
   -- sbt "run-main Simulator src/main/resource/input.txt"
