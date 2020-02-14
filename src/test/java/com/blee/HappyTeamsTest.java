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
    	HappyTeams.random(2,0,1000,5,0,"test.csv");
    }
}









