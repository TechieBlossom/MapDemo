package com.techieblossom.mapdemo.mapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.style1).setOnClickListener(view -> {
            startActivity(0);
        });

        findViewById(R.id.style2).setOnClickListener(view -> {
            startActivity(1);
        });

        findViewById(R.id.style3).setOnClickListener(view -> {
            startActivity(2);
        });

        findViewById(R.id.style4).setOnClickListener(view -> {
            startActivity(3);
        });
    }

    void startActivity(int mapType) {
        startActivity(new Intent(MainActivity.this, MapLandingActivity.class).putExtra(MapLandingActivity.MAP_TYPE, mapType));
    }
}
