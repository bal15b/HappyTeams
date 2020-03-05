package com.blee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import java.util.*;
import java.io.*;



/******************************************************************************
 *  Author : bal15b Ben Lamont
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do Somehting test
 *  Date   : 2/14/2020
 ******************************************************************************/

public class HappyTeamsTest
{
    HappyTeams h1;
    HappyTeams h2;
    HappyTeams h3;
    HappyTeams h4;
    HappyTeams h5;
    HappyTeams h6;
    HappyTeams h7;
    HappyTeams h8;
    HappyTeams h9;

    
    @Before
    public void initialize() {
    h1 = new HappyTeams();
    h2 = new HappyTeams();
    h3 = new HappyTeams();
    h4 = new HappyTeams();
    h5 = new HappyTeams();
    h6 = new HappyTeams();
    h7 = new HappyTeams();
    h8 = new HappyTeams();
    h9 = new HappyTeams();

    }

    //order to give items into main function (team_size, verbocity, number of swaps, number of iterations, percent error, filename, proposal)

    @Test
    public void test1()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "10";
        String times = "10";
        String team_size = "2";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "person1,2,3,4\nperson2,1,3,4\nperson3,1,2,4\nperson4,1,2,3";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);


        //get initial happiness and check to make sure happiness is calculated correctly
        int i = h1.checkhappiness(2,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,32);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }

        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h1.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h1.checkhappiness(2,0,1,1,0,"test.csv",0);
        assertTrue(f >= i);
    }

    @Test
    public void test2()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "250";
        String times = "10";
        String team_size = "4";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "1";
        String prefs = "Set1,4,12,7,6\nSet2,9,13,8,11\nSet3,13,8,6,7\nSet4,12,7,6,13\nSet5,9,13,5,14\nSet6,3,9,7,11\nSet7,7,12,9,10\nSet8,13,7,9,3\nSet9,1,6,12,3\nSet10,10,4,11,13\nSet11,10,14,8,9\nSet12,9,8,12,7\nSet13,9,10,4,1\nSet14,9,6,10,8";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h1.checkhappiness(4,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,59);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h2.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h1.checkhappiness(4,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
        
    }

    @Test
    public void test3()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "50";
        String times = "10";
        String team_size = "6";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "1";
        String prefs = "Set1,4,11,9\nSet2,6,11,2\nSet3,2,5,1\nSet4,7,8,4\nSet5,8,7,10\nSet6,2,7,1\nSet7,10,6,7\nSet8,3,9,12\nSet9,7,6,8\nSet10,2,7,8\nSet11,2,3,6\nSet12,10,6,3";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h3.checkhappiness(6,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,124);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h3.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h3.checkhappiness(6,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test4()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "750";
        String times = "10";
        String team_size = "3";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,6,4,13,1,9\nSet2,5,6,11,2,13\nSet3,4,3,8,7,12\nSet4,8,3,10,2,12\nSet5,4,2,10,7,8\nSet6,1,13,8,9,6\nSet7,4,11,2,13,12\nSet8,6,10,4,7,9\nSet9,13,4,9,3,1\nSet10,11,6,9,3,8\nSet11,12,13,6,3,10\nSet12,9,4,12,10,11\nSet13,10,12,8,3,9";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h4.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,42);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }
        assertEquals(i,42);


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h4.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h4.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test5()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "1000";
        String times = "10";
        String team_size = "2";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,6,12,10,11,8,7\nSet2,7,6,5,10,2,12\nSet3,12,4,11,1,9,2\nSet4,12,1,7,6,3,9\nSet5,11,3,5,6,2,4\nSet6,8,5,2,10,6,3\nSet7,8,2,5,6,12,10\nSet8,2,4,3,12,5,6\nSet9,8,1,3,12,6,2\nSet10,10,12,7,9,1,5\nSet11,6,8,9,12,2,3\nSet12,1,8,9,2,11,3";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h5.checkhappiness(2,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,39);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h5.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h5.checkhappiness(2,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test6()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "100";
        String times = "10";
        String team_size = "3";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,6,2,3,7\nSet2,3,6,7,1\nSet3,6,3,7,5\nSet4,6,4,2,3\nSet5,1,2,5,6\nSet6,3,5,4,6\nSet7,6,5,3,1";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h6.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,54);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }
        assertEquals(i,54);


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h6.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h6.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test7()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "5";
        String times = "10";
        String team_size = "3";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,3,5\nSet2,5,4\nSet3,1,6\nSet4,5,6\nSet5,4,3\nSet6,2,4";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h7.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertEquals(i,56);
        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h7.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h7.checkhappiness(3,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test8()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "15";
        String times = "10";
        String team_size = "4";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,4,5,1,2\nSet2,8,3,4,1\nSet3,5,4,8,7\nSet4,4,1,8,3\nSet5,4,7,3,1\nSet6,2,5,8,7\nSet7,8,1,5,6\nSet8,4,1,5,7";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h8.checkhappiness(4,0,1,1,0,"test.csv",0);
        try{
         assertEquals(i,102);

        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h8.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h8.checkhappiness(4,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

    @Test
    public void test9()
    {
        /* verbosity
        0 = basic output
        1 = also output happiness of each iteration
        2 = tell you when an iteration has been rerun
        3 = how many times each person was picked
        4 = shows every swap
        */
        String verbosity = "0";
        String swaps = "500";
        String times = "10";
        String team_size = "5";
        String filename = "test.csv";
        String percent_err = "5";

        //set proposal to potentially rerun iterations that have too high of a variation in team happiness
        String proposal = "0";
        String prefs = "Set1,7,11,2,3,4\nSet2,6,10,4,5,3\nSet3,10,9,3,4,7\nSet4,10,6,1,3,4\nSet5,5,1,10,2,4\nSet6,8,3,10,4,1\nSet7,6,4,8,11,7\nSet8,10,7,4,5,9\nSet9,11,2,3,8,10\nSet10,10,6,1,8,3\nSet11,8,2,11,7,10";

        ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        //get initial happiness
        int i = h9.checkhappiness(5,0,1,1,0,"test.csv",0);
        try{
         assertEquals(i,115);

        } catch (Exception e) {
            System.out.println("intial happiness calcluated incorrectly");
        }


        //finds most optimal team arrangement with time alloted
        ByteArrayInputStream in2 = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in2);
        h9.main( new String[] {team_size, verbosity, swaps, times, percent_err, filename, proposal} );

        //check happiness at the end to see if it has imporved or at least stayed the same
        int f = h9.checkhappiness(5,0,1,1,0,"test.csv",0);
        try{
            assertTrue(f >= i);
        } catch (Exception e) {
            System.out.println("The overall happiness decreased");
        }
    }

}
