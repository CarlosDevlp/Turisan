package Model;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import java.util.Locale;

import Controller.Control;


/**
 * Entity GPS
 * Created by carlos on 28/07/15.
 */
public class GPS {
    private LocationManager _locationManager;
    private LocationListener _locationListener;
    private int _interval, _meters;
    public static Function _fnc;

    //constructor
    public GPS(Object SystemService) {
        this._locationManager = (LocationManager) SystemService;
        this._interval = 0;
        this._meters = 0;
    }

    //setters
    public void setLocationManager(LocationManager _locationManager) {
        this._locationManager = _locationManager;
    }

    public void setLocationListener(LocationListener _locationListener) {
        this._locationListener = _locationListener;
    }

    public void setInterval(int _interval) {
        this._interval = _interval;
    }

    public void setMeters(int _meters) {
        this._meters = _meters;
    }

    //execute a function whenever a new place is loaded
    /*
    public void executeWhenUpdatesPlace(Function fnc) {
        GPS._fnc = fnc;
        this._locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                //String myLocation = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();
                //get information of the coords' place

                Geocoder info = new Geocoder(Control.Android.getSelf(), Locale.getDefault());
                Address address;
                try {
                    address = (info.getFromLocation(location.getLatitude(), location.getLongitude(), 1)).get(0);
                    //distrito
                    //getLocality getSubLocality  getAdminArea getCountryName  getPremises  getFeatureName getPhone
                    GPS._fnc.Execute(new String[]{address.getLocality(), address.getSubLocality(), address.getAdminArea(), address.getSubAdminArea(), address.getCountryName()});
                } catch (Exception err) {
                }


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this._locationManager.requestLocationUpdates(this._locationManager.GPS_PROVIDER, this._interval, this._meters, this._locationListener);
    }
*/
}