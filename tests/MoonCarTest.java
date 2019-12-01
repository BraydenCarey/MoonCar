import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MoonCarTest {
    private static int MAX_X = 6;
    private static int MAX_Y = 6;
    private static int carCount=0;
    private static MoonCar moonLanding[][]= new MoonCar[MAX_X][MAX_Y];
    private static MoonCar moonManuever[][]= new MoonCar[MAX_X][MAX_Y];
    //parameter inputs
    private String orientation;
    private int position_x;
    private int position_y;
    private String instructions;

    //expected results
    private String expected_orientation;
    private int expected_x;
    private int expected_y;

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MoonCarTest.class);
        for (Failure failure :result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
    public MoonCarTest(int position_x, int position_y, String orientation, String instructions, int expected_x, int expected_y, String expected_orientation){
        //Input Parameters
        this.orientation = orientation;
        this.position_x = position_x;
        this.position_y = position_y;
        this.instructions = instructions;
        //Expected Output Parameters
        this.expected_x = expected_x;
        this.expected_y = expected_y;
        this.expected_orientation = expected_orientation;


    }


    @Parameterized.Parameters
    public static Collection parameters(){
        return Arrays.asList(new Object[][]{
                //Tests for stopping going out of bound
                {1,2,"N","LMLMLMLMMMMMMMMMMMMMMMMMMMMM",1,5,"N"},
                //Tests for collision avoidance
                {1,2,"N","LMLMLMLMM",1,3,"N"},
                {1,2,"N","M",1,2,"N"},
                //General tests
                {2,2,"N","LLLLLLLL",2,2,"N"},
                {3,3,"E","MMRMMRMRRM",5,1,"E"}
        });
    }

    //Tests are sorted in alphanumerical order
    //Tests for landing off the grid. Also stops index out of bounds exception.
    @Test
    public void testAcheckForLandingOffGrid() {

        //Check location is within bounds
        Assert.assertTrue(position_x  > 0 );
        Assert.assertTrue(position_y > 0);
        Assert.assertTrue(position_x  < MAX_X );
        Assert.assertTrue(position_y < MAX_Y);
    }

    @Test
    public void testBcheckForLandingOnAnotherCar() {

        //Check Location is not already recorded on the grid
        Assert.assertNull(moonLanding[position_x][position_y]);
        //Location is recorded on the grid, Note the Car will be stored with the initial coordinates
        // while being placed in the grid location of its final destination.
        moonLanding[expected_x][expected_y] = new MoonCar(carCount, orientation, position_x, position_y);
    }


    @Test
    public void testCcheckForCorrectCoordinates() {
        MoonCar testMoonCar = new MoonCar(carCount, orientation, position_x, position_y);
        testMoonCar.manuever(instructions,moonManuever);
        int position_x = testMoonCar.getPosition_x();
        int position_y = testMoonCar.getPosition_y();
        String orientation = testMoonCar.getOrientation();

        Assert.assertEquals(expected_orientation, orientation);
        Assert.assertEquals(expected_x, position_x);
        Assert.assertEquals(expected_y, position_y);
        carCount++;
        //Location is recorded on the grid
        moonManuever[testMoonCar.getPosition_x()][testMoonCar.getPosition_y()] = testMoonCar;

    }


}