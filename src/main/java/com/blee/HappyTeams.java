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

  public static class User
  {
    public static int pref[];
    public static int id;
    public static String name;

    User(String n, int[] p, int c, int h)
    {
      name = n;
      id = h;
      pref = new int[10000];

      for(int i = 1; i <= c; i++)
      {
        pref[i] = p[i];
      }

    }
  }

  public static User l[];
  public static int count;

  public static User processLine(String x, int h)
    {
      int length = x.length();

      String[] temp = x.split(",");

      int[] choices = new int[10000];

      String n = temp[0];

      System.out.println(temp[0]);

      int count = 0;

      for (String t : temp)
      {

        if(count == 0){}
        else
        {
          choices[count] = Integer.parseInt(t);
        }
        count ++;
      }
      System.out.println(h);

      User y = new User(n,choices,count,h);

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
        l[count] = processLine(scanner.nextLine(), count);
        count ++;
      }
   
      while(scanner.hasNextLine())
      {
        l[count] = processLine(scanner.nextLine(), count);
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

      for(int i=0; i < timesRan; i++)
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
            for(int k = 0; k < count; k++)
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
