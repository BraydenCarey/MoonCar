This program was developed using java 1.8 using IntelliJ IDEA and tested using JUnit 4.

//Functionality Issues Q/A
Question: Program will allow multiple Moon Cars but will not check where they are placed. A moon car can
          be initiated on another car or drive through the same location as another Moon Car. Should this
          occur or should this report an error like " Critical error: Moon Cars 1 and 2 have been destroyed"?
Solution: Since only one car is moving at a time, the moving car will be given a map of all the other parked
          cars at that time. It will ignore moving commands that would cause a collision. For the case
          when a car is initialised on another car, that is out of the cars control and will destroy both cars.

Question: Do I assume the input file will be of correct format or should the input file be checked for correctness?
Answer:   I will assume the input will be of correct format. A control interface should parse the data in the
          correct format.

Question: Currently doesn't check for going out of bounds. Should the moon car ignore commands that would drive it
          off the plateau or report an error when the car drives off the edge.

Answer:   Commands that send a car out of bounds will be ignored. Additionally cars being initialized out of bounds
          will be destroyed.


//Further Development
* This program is very procedural in the way that one moon car is initialized and moves at a time.
  Running the moon cars as different threads will allow multiple moon cars to move at any one time.

* I've spent some time looking into building a physical model and hardware for this using
  the following materials:
    - Raspberry Pi 4
    - 2 x small DC Motors
    - L298 Dual H-Bridge Motor Driver
    - 3D printed Gear Box from  https://www.thingiverse.com/thing:3609059
    - 3D printed mars rover wheels from https://www.thingiverse.com/thing:2542822
    - 3D printed chassis to mount everything together (still under development using Autodesk Fusion 360)
   The Raspberry Pi's Operating system comes pre-installed with Node Red which can easily interface programs
   with hardware in addition to a heap of APIs. Instead of an input file I could interface it with text, email,
   tweet or even alexa.