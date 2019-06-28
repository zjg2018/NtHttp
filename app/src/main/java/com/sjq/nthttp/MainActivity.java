package com.sjq.nthttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1=findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> obj = new HashMap<String, String>();
                HttpUtils.getData("login/test", obj, new CallBack() {
                    @Override
                    public void onSuccess(Object o) {
                        try {
                            Log.e("zjg", o.toString());
                            JSONObject obj = new JSONObject(o.toString());
                            Toast.makeText(MainActivity.this, obj.toString(), Toast.LENGTH_SHORT).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "JSON ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "SERVER ERROR", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
