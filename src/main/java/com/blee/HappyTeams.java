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

  public class User
  {
    public int pref[];
    public String name;

    public void main()
    {
      pref = new int[10000];
    }
  }

  public static User l[];
  public static int count;

  public static User processLine(String x, User y)
    {
      int length = x.length();

      String[] temp = x.split(",");

      System.out.println(temp[0]);

      int count = 0;

      for (String t : temp)
      {
        System.out.println(t);

        if(count == 0)
        {
          //y.name = t;
        }
        else
        {
          //y.pref[count] = Integer.parseInt(t);
        }
        count ++;
      }

      return y;
    }

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
      l = new User[10000];

      if (scanner.hasNextLine())
      {
        l[count] = processLine(scanner.nextLine(),l[0]);
        count ++;
      }
   
      while(scanner.hasNextLine())
      {
        l[count] = processLine(scanner.nextLine(),l[count]);
        count ++;
      }
   
      scanner.close();

    }

    public static int random(int size, int verbose, int numberOfSwaps, int timesRan, int optimal, String fileName) throws FileNotFoundException
    {
      
      HappyTeams.prefs(fileName);
      int counter = 0;
      User temp;
      int swap1;
      int swap2;

      for(int i=0; i<timesRan; i++)
      {
        Random rnd = new Random(i);

        for(int j=0; j<numberOfSwaps; j++)
        {
          counter++;
          swap1 = rnd.nextInt(count);
          swap2 = rnd.nextInt(count);

          temp = l[swap1];
          l[swap1] = l[swap2];
          l[swap2] = temp;


          if(verbose == 1)
          {
            for(int k = 0; k<count; k++)
            {
              //temp = temp + l[k] + " ";
            }

          //System.out.println(temp);
          }

        }
      }
      return counter;
    }
}
