package nextbus;


import java.io.IOException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class TargetCaseStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         //TODO code application logic here
        Scanner input = new Scanner(System.in);
        String routeInput;
        String stopInput;
        String directionInput;
        
        System.out.print("Enter a route: ");
        routeInput = input.nextLine();
        
        System.out.print("Enter a stop: ");
        stopInput = input.nextLine();
        
        System.out.print("Enter a direction: ");
        directionInput = input.nextLine();
        
//        System.out.println(routeInput);
//        System.out.println(stopInput);
//        System.out.println(directionInput);
        
        RouteManager routeManager = RouteManager.getInstance();
        StopManager stopManager = StopManager.getInstance();
        DirectionManager directionManager = DirectionManager.getInstance();
        
        //get routes
        routeManager.getRoutesFromApi();
        int directionId = directionManager.getDirection(directionInput);

        //print output
        System.out.println(stopManager.getNextBus(routeManager.getRouteId(routeInput), stopInput, directionId));
        
        
    }
    
}
