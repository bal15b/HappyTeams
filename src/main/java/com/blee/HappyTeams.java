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
    public int id;
    public String name;

    User(String n, int[] p, int c, int h)
    {
      name = n;
      id = h;
      pref = new int[10000];

      int counter = 0;
      int[] values = {10,8,6,3,2,1};

      //puts user's rewards for getting their prefs in an array
      for(int i = 0; i <= 5; i++)
      {
        pref[p[i+1]] = values[counter];

        if(p[i+1] == id + 1)
        {
          pref[p[i+1]] = 0;
        }
        counter = counter + 1;
      }

    }
  }

  public User l[];
  public int count;
  public int team_size;
  public int overall_highest;
  public int local_highest;
  public int verbosity;
  public String local_team;
  public String overall_team;
  public boolean maxhappinessdif;
  public int currentmaxhappdif;
  public int newmaxhappdif;
  public int overallhappdif;
  public int localhappdif;
  public int picks[];


  public int getUserHappiness(int n, int s)//gets happiness for a user
  {
    int c = 0;
    for (int i = 0; i < team_size; i++)
    {
      c = c + l[n-1].pref[l[s+i-1].id+1];
    }
    return c;
  }
  public int getTeamHappiness(int n)//gets happiness for each team by adding up happiness of all the people on the team
  {
    int c = 0;
    int g;

    for(int i = 0; i < team_size; i++)
    {
      g = getUserHappiness(i + n, n);
      c = c + g;

    }
    return c;
  }
  public int getHappiness(int t)//gets overall happiness by adding up the happiness of all the teams
  {
    int c = 0;
    int people = count;
    int g;
    int max = 0;
    int min = people * 10;
    
    for (int i = 0; i < count; i++)
    {
      if (i%team_size - 1 == 0 && count >= i)
      {
        g = getTeamHappiness(i);
        c = c + g;

        if (g > max)
        {
          max = g;
        }
        if (g < min)
        {
          min = g;
        }
      }

    }

    maxhappinessdif = false;
    newmaxhappdif = max - min;
    if (max - min > max * 0.50 && t == 1)
    {
      maxhappinessdif = true;
    }


    return c;
  }

  public User processLine(String x, int h, int[] picks) 
    {
      int length = x.length();

      String[] temp = x.split(",");

      int[] choices = new int[10000];
      
      String n = temp[0];


      int count = 0;

      for (String t : temp)
      {

        if(count == 0){}
        else
        {
          choices[count] = Integer.parseInt(t);
        }
        picks[choices[count] + (count * 1000)] ++;
        if (h == choices[count])
        {
          //picks[choices[count]+count*1000] --;
        }
        count ++;
      }

      User y = new User(n,choices,count,h);

      return y;
    }

    private void prefs(String f, int[] picks)  
    {
      count = 0;
      Scanner scanner = new Scanner(System.in); 

      l = new User[10000];



      if (scanner.hasNextLine())
      {
        l[count] = processLine(scanner.nextLine(), count, picks);
        count ++;
      }
   
      while(scanner.hasNextLine())
      {
        l[count] = processLine(scanner.nextLine(), count, picks);
        count ++;
      }

      int temp_n = count;

      while (count % team_size != 0)
      {
        l[count] = processLine("", count, picks);
        count++;
      }
   
      scanner.close();
    }

    public void getnewlist(Random rnd)
    {
      User temp;
      int swap1;
      int swap2;

      for(int k=0; k < count; k++)
        {
          swap1 = rnd.nextInt(count);
          swap2 = rnd.nextInt(count);

          temp = l[swap1];
          l[swap1] = l[swap2];
          l[swap2] = temp;
        }
    }

    public void iternation(Random rnd, int numberOfSwaps, int optimal, int proposal)
    {
      User temp;
      int swap1;
      int swap2;

      //randomizes the initial list
      if(proposal != -1)
      {
        getnewlist(rnd);
      }

      //resets local maximums
      local_highest = 0;
      local_team = "";

       getHappiness(proposal);
       currentmaxhappdif = newmaxhappdif;

      for(int j=0; j < numberOfSwaps; j++)
        {
          swap1 = rnd.nextInt(count);
          swap2 = rnd.nextInt(count);

          if(proposal != -1)
          {
            temp = l[swap1];
            l[swap1] = l[swap2];
            l[swap2] = temp;
          }

          double per = 100 - (optimal/100);
          int value = getHappiness(proposal);
          if (value > local_highest || (value >= local_highest && newmaxhappdif < currentmaxhappdif))
          {
            local_highest = value;
            String temps = "";
            int teamcounter = 1;
            localhappdif = newmaxhappdif;
            
            if (verbosity == 4)
            {
              temps = temps + l[0].name;
              for (int k = 1; k < count; k++)
              {
                temps = temps + ", "  + l[k].name;
              }
              System.out.println(temps);
            }
            temps = "";
            teamcounter = 1;
            for (int k = 0; k < count; k++)
            {
              if(k % team_size == 0)
              {
                temps = temps + "\nTeam " + teamcounter + " ";
                temps = temps + "(" + this.getTeamHappiness(k+1) + "): ";
                teamcounter++;
              }

              if(l[k].name != "" && k % team_size != team_size-1)
              {
                temps = temps + " " + l[k].name + " (" + this.getUserHappiness(k+1, ((k)/team_size) * team_size + 1) + ")" ;
                if (l[k+1].name != "")
                {
                  temps = temps + ",";
                }
              }

              if(l[k].name != "" && k % team_size == team_size-1)
              {
                temps = temps + " " + l[k].name + " (" + this.getUserHappiness(k+1, ((k)/team_size) * team_size + 1) + ")" ;
              }
            }
            local_team = temps;
          }
          else if (value < local_highest * per && proposal != -1)
          {
            temp = l[swap1];
            l[swap1] = l[swap2];
            l[swap2] = temp;
          }

        }

    }


    public void random(int size, int verbose, int numberOfSwaps, int timesRan, int optimal, String fileName, int proposal)
    {

      //puts teams in array of users
      team_size = size;
      int[] picks = new int[100000];
      this.prefs(fileName, picks);
      verbosity = verbose;

      //creates things for the loop
      overall_highest = 0;
      overall_team = "";
      getHappiness(proposal);

      overallhappdif = newmaxhappdif;

      int counter = 0;

      if (verbosity == 3)
      {
        for (int i = 0; i < count; i++)
        {
          System.out.println("How many times " + l[i].name + " was requested sorted by pick order");
          for (int j = 1; j <= 6; j++)
          {
            System.out.println((j) + ": " + picks[l[i].id + 1 + (j * 1000)]);
            
          }
        }
      }

      //number of times ran
      for(int i=0; i < timesRan; i++)
      {
        //sets up random number generator with seed
        Random rnd = new Random(i);

        //runs each interation
        iternation(rnd, numberOfSwaps, optimal, proposal);

        counter = 0;
        while (proposal == 1 && counter < 5 && maxhappinessdif)
        {
          if (verbosity == 2)
          {
            System.out.println("Re-ran Iteration " + (i+1) +" (" + local_highest + ") Due to high of a variation in individual team's happiness" + local_team + "\n");
          }
          Random rnd2 = new Random(i * 1000 + counter);
          iternation(rnd2, numberOfSwaps, optimal, proposal);
          counter++;
        }
        
        if(verbosity == 1)
        {
          System.out.println("Iteration " + (i + 1) +" (" + local_highest + ")" + local_team + "\n");
        }

        if (local_highest > overall_highest || (local_highest >= overall_highest && localhappdif < overallhappdif))
        {
          overall_highest = local_highest;
          overall_team = local_team;
          overallhappdif = localhappdif;
        }

      }
      if (proposal != -1)
      {
        System.out.println("Happy Team (" + overall_highest + ")" + overall_team + "\n\n\n");
      }

    }

    public int checkhappiness(int size, int verbose, int numberOfSwaps, int timesRan, int optimal, String fileName, int proposal) 
    {
      if (count == 0)
      {
        this.random(size,0,1,1,optimal,fileName,-1);
      }
      return this.getHappiness(proposal);
    }

    public void main( String[] args )
    {
      

      this.random(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5], Integer.parseInt(args[6]));
    }
}
