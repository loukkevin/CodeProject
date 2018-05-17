/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nextbus.Route;
import nextbus.RouteManager;
import java.io.IOException;
import java.util.HashMap;
import nextbus.DirectionManager;
import nextbus.StopManager;
import org.junit.*;

/**
 *
 * @author Kevin
 */
public class RouteTest {
    
        RouteManager routeManager = RouteManager.getInstance();
        StopManager stopManager = StopManager.getInstance();
        DirectionManager directionManager = DirectionManager.getInstance();

    @Test
    public void testRoute901NorthboundMallofAmerica() throws IOException{

        
        routeManager.getRoutesFromApi();
        System.out.println("Testing METRO Blue Line(901) from Mall of America heading north\n");
        System.out.println("Enter a route: 901");
        System.out.println("Enter a stop: Mall of America");
        System.out.println("Enter a direction: north");
        int direction = directionManager.getDirection("north");
        String stopDescription = "Mall of America";
        stopManager.getStops("901", direction);
        String nextBus = stopManager.getNextBus("901", stopDescription, direction);
        System.out.println(nextBus);
        System.out.println("---------------\n");
    }
    
    @Test
    public void testRoute901SouthboundMallofAmerica() throws IOException{
        
        routeManager.getRoutesFromApi();
        //Mocking user input
        System.out.println("Testing METRO Blue Line(901) from Mall of America heading south\n");
        System.out.println("Enter a route: 901");
        System.out.println("Enter a stop: Mall of America");
        System.out.println("Enter a direction: south");
        int direction = directionManager.getDirection("south");
        String stopDescription = "Mall of America";
        stopManager.getStops("901", direction);
        String nextBus = stopManager.getNextBus("901", stopDescription, direction);
        System.out.println(nextBus);  
        System.out.println("---------------\n");
    }
    
    @Test
    public void testRoute901EastboundMallofAmerica() throws IOException{ //this test should cause an error since there is no eastbound train
        
        routeManager.getRoutesFromApi();
        //Mocking user input
        System.out.println("Testing METRO Blue Line(901) from Mall of America heading east\n");
        System.out.println("Enter a route: 901");
        System.out.println("Enter a stop: Mall of America");
        System.out.println("Enter a direction: east");
        int direction = directionManager.getDirection("east");
        String stopDescription = "Mall of America";
        stopManager.getStops("901", direction);
        String nextBus = stopManager.getNextBus("901", stopDescription, direction);
        System.out.println(nextBus);  
        System.out.println("---------------\n");
    }
    @Test
    public void testRoute2EastboundFranklinAndHennepin() throws IOException{
        
        routeManager.getRoutesFromApi();
        //Mocking user input
        System.out.println("Testing Route 2 from Franklin Ave and Hennepin Ave heading east\n");
        System.out.println("Enter a route: 2");
        System.out.println("Enter a stop: Franklin Ave and Hennepin Ave");
        System.out.println("Enter a direction: east");
        int direction = directionManager.getDirection("east");
        String stopDescription = "Franklin Ave and Hennepin Ave";
        stopManager.getStops("2", direction);
        String nextBus = stopManager.getNextBus("2", stopDescription, direction);
        System.out.println(nextBus);  
        System.out.println("---------------\n");
    }
    
    
    
}
