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
import java.sql.Time;
import java.time.LocalDateTime;
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
public class StopManager {

    private ArrayList<Stop> stops = null;
    private static StopManager controller = null;

    public static StopManager getInstance() {
        if (controller == null) {
            controller = new StopManager();
        }
        return controller;
    }

    //route is the unique route Id selected from the routes list based on user input,
    //direction is determined by the DirectionManager based on user input for direction
    public void getStops(String route, int direction) throws MalformedURLException, IOException {

        String getStopsUrl = "http://svc.metrotransit.org/NexTrip/Stops/";
        getStopsUrl = getStopsUrl.concat(route + "/" + String.valueOf(direction) + "?format=json"); //"http://svc.metrotransit.org/NexTrip/Stops/{ROUTE}/{DIRECTION}?format=json"
        URL url = new URL(getStopsUrl);
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
            Stop stop = gson.fromJson(array.get(i), Stop.class);
            addStop(stop);
        }
        bufferedReader.close();
        con.disconnect();
    }

    public void addStop(Stop stop) {
        stops.add(stop);
    }

    public ArrayList<Stop> getStops() {
        return stops;
    }

    public String getStopId(String stopDescription) {
        String stopId = "";
        ArrayList<Stop> stopsList = this.stops;
        Iterator<Stop> stopsIterator = stopsList.iterator();
        boolean found = false;
        while (stopsIterator.hasNext() && !found) {
            Stop stop = stopsIterator.next();
            if (stop.getText().toLowerCase().contains(stopDescription.toLowerCase())) {
                stopId = stop.getValue();
                found = true;
            }
        }
        return stopId;
    }

    public String getNextBus(String route, String stopDescription, int direction) throws MalformedURLException, IOException {
        getStops(route,direction);
        String nextBusTime = "";
        String getStopsUrl = "http://svc.metrotransit.org/NexTrip/";
        getStopsUrl = getStopsUrl.concat(route + "/" + String.valueOf(direction) + "/" + getStopId(stopDescription) + "?format=json"); //"http://svc.metrotransit.org/NexTrip/{ROUTE}/{DIRECTION}/{STOP}?format=json"
        
        URL url = new URL(getStopsUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(bufferedReader).getAsJsonArray();
        Departure departure = gson.fromJson(array.get(0), Departure.class);

        //if actual is true, simply return departure text which is already in minutes
        if (departure.getActual().equalsIgnoreCase("true")) {
            if (!departure.getDepartureText().equalsIgnoreCase("due"))
            nextBusTime = (departure.getDepartureText().concat("utes"));//turn Min into Minutes
        } else {
            //calculate minutes from current time to departure time
            String departureDateTime = departure.getDepartureTime();
            departureDateTime = departureDateTime.replaceAll("-0500|Date|[()]|/", "");//extract milliseconds
            
            long systemTime = System.currentTimeMillis();
            long departureTime = Long.parseLong(departureDateTime);
            long difference = departureTime - systemTime;
            long minutes = (difference / 60 / 1000); //convert milliseconds to minutes
            //System.out.println(minutes + " minutes");
            nextBusTime = (minutes + " Minutes");
        }
        return nextBusTime;
    }

    private StopManager() {
        stops = new ArrayList<Stop>();
    }
}
