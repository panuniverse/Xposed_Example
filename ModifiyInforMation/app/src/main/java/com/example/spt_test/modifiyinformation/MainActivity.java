package com.example.spt_test.modifiyinformation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
        String imie = telephonyManager.getDeviceId();
        Toast.makeText(MainActivity.this, "imei:"+imie, Toast.LENGTH_SHORT).show();

    }

}
