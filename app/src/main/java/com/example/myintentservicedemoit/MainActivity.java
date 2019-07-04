package com.example.myintentservicedemoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
    }

    public void onButtonPressed(View view){
        Intent intent = new Intent(this,MyIntentService.class);
//        intent.putExtra("sleepTime",2000);
        Bundle b = new Bundle();
        b.putInt("sleepTime",2000);
        intent.putExtra("bundle",b);
        startService(intent);
    }

    @Subscribe
    public void onMsgReceived(Pojo pojo){
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
