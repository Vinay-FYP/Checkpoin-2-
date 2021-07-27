package com.example.google_maps_api;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class mapActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Toast.makeText(this, "map ready", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onMapready: Map is ready ");
        mMap = googleMap;
    }
    private static final String TAG = "mapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION =  Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    //Variables
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getLocationPermission();
    }


    private void initmap(){ //can implement by implementing the onMapReady Callback class as a listener
        Log.d(TAG, "initMap: initialising map");
        SupportMapFragment mapfrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapfrag.getMapAsync(mapActivity.this);

        /*mapfrag.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                mMap = googleMap;

            }
        }); */
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG,"onRequestpermissionsResult: called");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionGranted = false;

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionGranted = false;
                            Log.d(TAG,"onRequestpermissionResult: Permission Failed");
                            return;
                        }
                    }
                    mLocationPermissionGranted = true;
                    Log.d(TAG,"onRequestPermissionsResult: permission granted ");
                    //initialise the map
                    initmap();
                }
        }
    }

    //Check permissions
    private void getLocationPermission(){
        Log.d(TAG,"getLocatpermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionGranted = true;
            }else{
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }
        }

    }


}
