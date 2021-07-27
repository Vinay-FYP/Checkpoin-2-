package com.example.google_maps_api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static  final int ERROR_DIALOG_REQUEST =9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isServicesOk()){

        }
    }

    private void init(){
        Button btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mapActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOk:Checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //User can make map requests
            Log.d(TAG, "isServicsok: Google Play services is working");
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //Error occured but resolve issue
            Log.d(TAG, "isServiceOk: an error occured but to resolve issue ");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();

        }
        else{
            Toast.makeText(this, "We can't connect to maps", Toast.LENGTH_LONG).show();
        }
        return false;

    }
}