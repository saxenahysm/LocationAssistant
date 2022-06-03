package com.shyam.locationassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationAssistant.Listener {
    private static final String ACTION_MOCK_LOCATION_SETTINGS = "android.settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onNeedLocationPermission() {

    }

    @Override
    public void onExplainLocationPermission() {

    }

    @Override
    public void onLocationPermissionPermanentlyDeclined(View.OnClickListener fromView, DialogInterface.OnClickListener fromDialog) {

    }

    @Override
    public void onNeedLocationSettingsChange() {

    }

    @Override
    public void onFallBackToSystemSettings(View.OnClickListener fromView, DialogInterface.OnClickListener fromDialog) {

    }

    @Override
    public void onNewLocationAvailable(Location location) {
        Log.e("TAG111", "onNewLocationAvailable: "+location.getLatitude()+","+location.getLongitude() );
    }

    @Override
    public void onMockLocationsDetected(View.OnClickListener fromView, DialogInterface.OnClickListener fromDialog) {
        Toast.makeText(getApplicationContext(), "MockLocationDetected", Toast.LENGTH_SHORT).show();

        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(this, R.style.MyDatePickerDialogTheme);
        alertDialogBuilder.setTitle("Fake Location Alert!");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Looks like you are using  mock location permission,to continue using this app" +
                "please disable the permission from " +
                "\n Settings-> Developer Options->select mock location->none");
        alertDialogBuilder.setPositiveButton("OK",
                (dialog, id) -> startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)));
        alertDialogBuilder.create();
        alertDialogBuilder.show();
    }

    @Override
    public void onError(LocationAssistant.ErrorType type, String message) {

    }

}