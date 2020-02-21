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
    HappyTeams h;
    
    @Before
    public void initialize() {
    h = new HappyTeams();
    }

    @Test
    public void test() throws FileNotFoundException
    {
        int swaps = 5;
        int times = 5;
        int counter = h.random(3,0,swaps,times,0,"test.csv");
        assertEquals(swaps * times, counter);

    }
}









