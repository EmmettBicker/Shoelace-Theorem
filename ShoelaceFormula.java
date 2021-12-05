import java.util.Scanner;

public class ShoelaceFormula {

    public static void main(String[] args) {
        //Yes or no input String
        String yOrNo;
        //Yes or no boolean
        boolean isY = false;

        //Getting total # of points
        Scanner sc = new Scanner(System.in);

        int totalPoints = get_int("How many points does your polygon have?",sc);
        if (totalPoints < 3)
        {
            System.out.println("Not enough points to create a polygon!");
            System.exit(1);
        }

        //Create arrays for points
        float[] xArray = new float[totalPoints];
        float[] yArray = new float[totalPoints];


        for (int i = 0; i < totalPoints; i++) {
            xArray[i] = get_int("x" + (i+1) + ": ", sc);
            yArray[i] = get_int("y" + (i+1) + ": ", sc);

        }

        System.out.println(compute_shoelace(xArray,yArray));


    }

    public static int get_int(String s, Scanner sc)
    {
        System.out.println(s);
        try {
            return Integer.valueOf(sc.nextLine());
        }
        catch(Exception e)
        {
            System.out.println("That's not an integer! Try again:");
            return get_int(s,sc);
        }
    }

    public static float compute_shoelace(float[] xArray, float[] yArray)
    {
        //Area variable
        float A = 0;

        //Variable for each side of the shoelace multiplying
        float xStartSum = 0;
        float yStartSum = 0;

        //integer for final moment of
        int j;
        //Iterate over points to calculate area
        for (int i = 0; i < xArray.length; i++)
        {
            if (i + 1 == xArray.length)
            {
                j = 0;
            }
            else
            {
                j = i + 1;
            }
            //Simultaneously compute both sides of the shoelace formula
            xStartSum += xArray[i] * yArray[j];
            yStartSum += yArray[i] * xArray[j];

        }
        //Subtract one sum from the other
        A = xStartSum - yStartSum;

        //Find the absolute value
        if (A < 0) { A *= -1; }

        //Halve A
        A *= .5;

        return A;
    }

}
