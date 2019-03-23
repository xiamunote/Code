package com.xiamunote.activitylifecycletest;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("TAG","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","onRestarrt");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","onCreat");
        setContentView(R.layout.activity_main);
        Button startNarmalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNarmalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });



    }
}
