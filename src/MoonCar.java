

public class MoonCar {
    private int carId = 0;
    private String orientation;
    private int position_x;
    private int position_y;

    MoonCar(int regoNumber, String startOrientation, int start_x , int start_y){
        //Assign the rego number to this car.
        carId = regoNumber;
        //Assign the starting orientation to the moon car.
        orientation = startOrientation;
        //Assign the starting coordinates to the moon car.
        position_x = start_x;
        position_y = start_y;

    }

    public void manuever(String instructions, MoonCar moon[][]){

        char instruction;

        for(int i=0; i<instructions.length(); i++){
            instruction = instructions.charAt(i);
            if(instruction == 'L'){
                this.left();
            }
            else if(instruction == 'R'){
                this.right();
            }
            else if(instruction == 'M'){
                int posx = this.position_x;
                int posy = this.position_y;
                this.move();
                //Check for out of bounds
                if(this.position_x < 0 || this.position_y <0 || this.position_x >= moon.length || this.position_y >= moon.length){
                    //Stops the car advancing to coordinates because its out of bounds
                    this.position_x = posx;
                    this.position_y = posy;
                }


                //Check for potential collisions

                if(moon[this.position_x][this.position_y]!=null){
                    //Stops the car advancing to coordinates because there's another car there
                    this.position_x = posx;
                    this.position_y = posy;
                }


            }
            else{
                System.out.println("Error: Invalid character" + instruction);
            }
        }

    }

    public void left(){
        if(this.orientation.equals("N")){
            this.orientation = "W";
        }
        else if(this.orientation.equals("W")){
            this.orientation = "S";
        }
        else if(this.orientation.equals("S")){
            this.orientation = "E";
        }
        else if(this.orientation.equals("E")){
            this.orientation = "N";
        }
    }

    public void right(){
        if(this.orientation.equals("N")){
            this.orientation = "E";
        }
        else if(this.orientation.equals("E")){
            this.orientation = "S";
        }
        else if(this.orientation.equals("S")){
            this.orientation = "W";
        }
        else if(this.orientation.equals("W")){
            this.orientation = "N";
        }
    }

    public void move(){
        if(this.orientation.equals("N")){
            //position_x = position_x;
            this.position_y = this.position_y + 1;
        }
        if(this.orientation.equals("E")){
            this.position_x = this.position_x + 1;
            //position_y = position_y;
        }
        if(this.orientation.equals("S")){
            //position_x = position_x;
            this.position_y = this.position_y - 1;
        }
        if(this.orientation.equals("W")){
            this.position_x = this.position_x - 1;
            //position_y = position_y;
        }
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPosition_x(){
        return this.position_x;
    }

    public int getPosition_y(){
        return this.position_y;
    }

    public String getOrientation(){
        return this.orientation;
    }
}
