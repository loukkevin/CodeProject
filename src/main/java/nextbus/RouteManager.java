package nextbus;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class RouteManager {
    private static RouteManager controller = null;
    private ArrayList<Route> routes = null;
    
    public static RouteManager getInstance () {
        if (controller == null){
            controller = new RouteManager();
        }
        return controller;
    }

    private RouteManager() {
        this.routes = new ArrayList<Route>();
    }
    
    public ArrayList<Route> getRoutes(){
        return routes;
    }
    
    public void addRoute(Route route){
        routes.add(route);
    }

    public void getRoutesFromApi() throws MalformedURLException, IOException {
        URL url = new URL("http://svc.metrotransit.org/NexTrip/Routes?format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        Gson gson = new GsonBuilder().create();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(bufferedReader).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            Route route = gson.fromJson(array.get(i), Route.class);
            addRoute(route);

        }
        con.disconnect();
    }
    
        public String getRouteId(String routeDescription) {
        String routeId = "";
        ArrayList<Route> routesList = this.routes;
        Iterator<Route> routesIterator = routesList.iterator();
        boolean found = false;
        while (routesIterator.hasNext() && !found) {
            Route route = routesIterator.next();
            route.setDescription(route.getDescription() + " - " + route.getRoute());
            if (route.getDescription().toLowerCase().contains(routeDescription.toLowerCase())) {
                routeId = route.getRoute();
                found = true;
            }
        }
        return routeId;
    }
}
