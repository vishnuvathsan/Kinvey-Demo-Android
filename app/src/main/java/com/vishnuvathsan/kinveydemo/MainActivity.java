package com.vishnuvathsan.kinveydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.java.core.KinveyClientCallback;

public class MainActivity extends AppCompatActivity {

    public static EventEntity EVENT_ENTITY;
    private String collection, id;
    private EditText etCollection, etID;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LoginActivity.KINVEY_CLIENT.user().logout().execute();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCollection = (EditText) findViewById(R.id.etCollection);
        etID = (EditText) findViewById(R.id.etID);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collection = etCollection.getText().toString().trim();
                id = etID.getText().toString().trim();

                //The EventEntity class is defined above
                EventEntity event = new EventEntity();
                AsyncAppData<EventEntity> myCollection = LoginActivity.KINVEY_CLIENT.appData(collection, EventEntity.class);
                if (id == "") {
                    myCollection.get(new KinveyListCallback<EventEntity>() {
                        @Override
                        public void onSuccess(EventEntity[] result) {
                            Log.v("TAG", "received " + result.length + " " + collection);
                        }

                        @Override
                        public void onFailure(Throwable error) {
                            Log.e("TAG", "failed to fetch all", error);
                        }
                    });
                } else {
                    myCollection.getEntity(id, new KinveyClientCallback<EventEntity>() {
                        @Override
                        public void onSuccess(EventEntity result) {
                            Log.v("TAG", "received " + result.toString());
                            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
                            EVENT_ENTITY = result;
                            Intent intent = new Intent(MainActivity.this, DataActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Throwable error) {
                            Log.e("TAG", "failed to fetchByFilterCriteria", error);
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
