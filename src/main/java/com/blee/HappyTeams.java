package com.blee;
 
import java.util.*;
import java.io.*;

/******************************************************************************
 *  Author : Team D.A.P.
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do something for the project
 *  Date   : 2/14/2020
 *
 *  Compile: javac HappyTeams.java
 *  Execute: java HappyTeams
 *
 *
 ******************************************************************************/
public class HappyTeams 
{

  private static String l[];
  private static int count;

  public static void main( String[] args )
  {
    System.out.println(args[0]);
  }

    private static void prefs(String f)  throws FileNotFoundException
    {
      String currentDirectory;
      currentDirectory = System.getProperty("user.dir");

      f = "test.csv";
      count = 0;

      FileInputStream fis = new FileInputStream("/"+ currentDirectory + "/src/" + f);
      Scanner scanner = new Scanner(fis);
          l = new String[10000];

        if (scanner.hasNextLine())
        {
          l[0] = scanner.nextLine();
          count ++;
        }
     
        while(scanner.hasNextLine())
        {
          l[count] = scanner.nextLine();
          count ++;
        }
     
        scanner.close();

    }

    public static void random(int size, int verbose, int numberOfSwaps, int timesRan, int optimal, String fileName) throws FileNotFoundException
    {
      
      HappyTeams.prefs(fileName);
      
      String temp;
      int swap1;
      int swap2;

      for(int i=0; i<=timesRan; i++)
      {
        Random rnd = new Random(i);

        for(int j=0; j<=numberOfSwaps; j++)
        {
          swap1 = rnd.nextInt(count);
          swap2 = rnd.nextInt(count);

          temp = l[swap1];
          l[swap1] = l[swap2];
          l[swap2] = temp;

          temp = "";

          if(verbose == 1)
          {
            for(int k = 0; k<count; k++)
            {
              temp = temp + l[k] + " ";
            }

          System.out.println(temp);
          }

        }
      }

    }
}
