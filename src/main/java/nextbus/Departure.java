/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbus;

/**
 *
 * @author Kevin
 */
public class Departure {
    private String VehicleHeading;
    private String VehicleLongitude;
    private String Description;
    private String DepartureText;
    private String Actual;
    private String Terminal;
    private String DepartureTime;
    private String RouteDirection;
    private String VehicleLatitude;
    private String Route;
    private String BlockNumber;
    private String Gate;

    public String getVehicleHeading ()
    {
        return VehicleHeading;
    }

    public void setVehicleHeading (String VehicleHeading)
    {
        this.VehicleHeading = VehicleHeading;
    }

    public String getVehicleLongitude ()
    {
        return VehicleLongitude;
    }

    public void setVehicleLongitude (String VehicleLongitude)
    {
        this.VehicleLongitude = VehicleLongitude;
    }

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getDepartureText ()
    {
        return DepartureText;
    }

    public void setDepartureText (String DepartureText)
    {
        this.DepartureText = DepartureText;
    }

    public String getActual ()
    {
        return Actual;
    }

    public void setActual (String Actual)
    {
        this.Actual = Actual;
    }

    public String getTerminal ()
    {
        return Terminal;
    }

    public void setTerminal (String Terminal)
    {
        this.Terminal = Terminal;
    }

    public String getDepartureTime ()
    {
        return DepartureTime;
    }

    public void setDepartureTime (String DepartureTime)
    {
        this.DepartureTime = DepartureTime;
    }

    public String getRouteDirection ()
    {
        return RouteDirection;
    }

    public void setRouteDirection (String RouteDirection)
    {
        this.RouteDirection = RouteDirection;
    }

    public String getVehicleLatitude ()
    {
        return VehicleLatitude;
    }

    public void setVehicleLatitude (String VehicleLatitude)
    {
        this.VehicleLatitude = VehicleLatitude;
    }

    public String getRoute ()
    {
        return Route;
    }

    public void setRoute (String Route)
    {
        this.Route = Route;
    }

    public String getBlockNumber ()
    {
        return BlockNumber;
    }

    public void setBlockNumber (String BlockNumber)
    {
        this.BlockNumber = BlockNumber;
    }

    public String getGate ()
    {
        return Gate;
    }

    public void setGate (String Gate)
    {
        this.Gate = Gate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [VehicleHeading = "+VehicleHeading+", VehicleLongitude = "+VehicleLongitude+", Description = "+Description+", DepartureText = "+DepartureText+", Actual = "+Actual+", Terminal = "+Terminal+", DepartureTime = "+DepartureTime+", RouteDirection = "+RouteDirection+", VehicleLatitude = "+VehicleLatitude+", Route = "+Route+", BlockNumber = "+BlockNumber+", Gate = "+Gate+"]";
    }
}

