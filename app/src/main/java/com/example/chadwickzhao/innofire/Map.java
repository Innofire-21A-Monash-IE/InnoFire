package com.example.chadwickzhao.innofire;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


/**
 * Created by chadwickzhao on 19/08/16.
 */


@SuppressWarnings("MissingPermission")
public class Map extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    double latitude;
    double longitude;
    private GoogleMap mMap;
    LocationRequest mLocationResquest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    user u;
    private int PROXIMITY_RADIUS = 10000;
    private int totaltoday;
    int SleepHoursinToday;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_f);

        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        bt4 = (Button) findViewById(R.id.ttt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gobacktomain();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }else {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }



        bt2 = (Button) findViewById(R.id.ttt2);
        bt3 = (Button) findViewById(R.id.ttt3);


        bt2.setOnClickListener(new View.OnClickListener() {
            String Gym = "gym";
            @Override
            public void onClick(View view) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                addMarkerofGym();
                String url = getUrl(latitude, longitude, Gym);
                Object[] DataTransfer = new Object[2];
                DataTransfer [0] = mMap;
                DataTransfer [1] = url;
                GetNearByPlacesData getNearbyPlacesData = new GetNearByPlacesData();
                getNearbyPlacesData.execute(DataTransfer);
                Toast.makeText(Map.this, "Nearby Gym", Toast.LENGTH_LONG).show();
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            String Spa = "spa";
            @Override
            public void onClick(View view) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                addMarkerofSpa();
                String url = getUrl(latitude, longitude, Spa);
                Object[] DataTransfer = new Object[2];
                DataTransfer [0] = mMap;
                DataTransfer [1] = url;
                GetNearByPlacesData getNearbyPlacesData = new GetNearByPlacesData();
                getNearbyPlacesData.execute(DataTransfer);
                Toast.makeText(Map.this, "Nearby Spa", Toast.LENGTH_LONG).show();
            }
        });

        bt1 = (Button) findViewById(R.id.ttt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            String Park = "park";
            @Override
            public void onClick(View view) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                addMarkerofPark();
                String url = getUrl(latitude, longitude, Park);
                Object[] DataTransfer = new Object[2];
                DataTransfer [0] = mMap;
                DataTransfer [1] = url;
                GetNearByPlacesData getNearbyPlacesData = new GetNearByPlacesData();
                getNearbyPlacesData.execute(DataTransfer);
               // Toast.makeText(Map.this, "Nearby Park", Toast.LENGTH_LONG).show();
            }
        });

    }



    public void addMarkerofPark(){

        new AsyncTask<String, Void, List<Park1>>() {
            @Override
            protected List<Park1> doInBackground(String... strings) {
                return Connection.findallpark();
            }

            @Override
            protected void onPostExecute(final List<Park1> park1s) {
               // mMap.addMarker(new MarkerOptions().position().title());
                if (park1s == null) {
                    Toast.makeText(Map.this, "DataBase Error", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < park1s.size(); i++) {
                        Double lon = park1s.get(i).getLongtitude();
                        Double lat = park1s.get(i).getLatitude();
                        String nameofGym = park1s.get(i).getParkname();
                        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).title(nameofGym));
                    }
                }
            }
        }.execute();
    }

    public void addMarkerofGym(){

        new AsyncTask<String, Void, List<Gym>>() {
            @Override
            protected List<Gym> doInBackground(String... strings) {
                return Connection.findallgym();
            }
            @Override
            protected void onPostExecute(final List<Gym> gyms) {
                if(gyms == null){
                    Toast.makeText(Map.this, "DataBase Error", Toast.LENGTH_LONG).show();
                }else{
                for(int i = 0; i< gyms.size(); i++){
                    Double lon = gyms.get(i).getLongitutde();
                    Double lat = gyms.get(i).getLatitude();
                    String nameofGym = gyms.get(i).getGymname();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lon)).title(nameofGym));
                }

            }
            }
        }.execute();
    }

    public void addMarkerofSpa(){

        new AsyncTask<String, Void, List<Spa>>() {
            @Override
            protected List<Spa> doInBackground(String... strings) {
                return Connection.findallspa();
            }

            @Override
            protected void onPostExecute(final List<Spa> spas) {
                if (spas == null) {
                    Toast.makeText(Map.this, "DataBase Error", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < spas.size(); i++) {
                        Double lon = spas.get(i).getLongitude();
                        Double lat = spas.get(i).getLatitude();
                        String nameofGym = spas.get(i).getSpaname();
                        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).title(nameofGym));
                    }
                }
            }
        }.execute();
    }


    private String getUrl(double latitude, double longitude, String nearByPlace){
        latitude = mLastLocation.getLatitude();
        longitude = mLastLocation.getLongitude();
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
        googlePlacesUrl.append("&type=" + nearByPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyASOoXOqRflkyzF9rSn16lSEoNiSgCscMg");
        Log.d("getUrl",googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());

    }

    private synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationResquest = new LocationRequest();
        mLocationResquest.setInterval(1000);
        mLocationResquest.setFastestInterval(1000);
        mLocationResquest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationResquest,this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if(mCurrLocationMarker != null){
            mCurrLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("current position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        if(mGoogleApiClient != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void gobacktomain(){
        Intent intent = new Intent(Map.this, MainActivity.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }



}