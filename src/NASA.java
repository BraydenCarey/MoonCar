import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NASA {
    public static void main(String args[]) throws InterruptedException
    {
        //Number of moon cars deployed
        int carCounter = 0;
        //Max size of the plateau
        int max_x;
        int max_y;
        //Holds the file name
        String fileName = args[0];
        //This will reference one line at a time
        String line;

        //Read input file from NASA
        // Always wrap FileReader in BufferedReader.
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //First line indicates size of plateau
            line = bufferedReader.readLine();

            //Split String by spaces to retrieve max x and y coordinates
            String size[] = line.split(" ");
            max_x = Integer.parseInt(size[0]);
            max_y = Integer.parseInt(size[1]);

            //2D Array that holds Moon Car objects
            MoonCar moon[][] = new MoonCar[max_x+1][max_y+1];

            //Start adding moon cars to the moon!
            while((line = bufferedReader.readLine())!=null) {
                //Split the coordinates and orientation up
                String[] stringHolder = line.split(" ");
                //Register vehicle
                carCounter++;
                MoonCar car = new MoonCar(carCounter, stringHolder[2], Integer.parseInt(stringHolder[0]), Integer.parseInt(stringHolder[1]));

                //Manuever instructions
                line = bufferedReader.readLine();

                car.manuever(line);

                moon[car.getPosition_x()][car.getPosition_y()] = car;

                System.out.println(car.getPosition_x() + " " + car.getPosition_y() + " " + car.getOrientation());

            }
            //Always close the buffered reader
            bufferedReader.close();

         } catch (FileNotFoundException ex) {

              System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

}
