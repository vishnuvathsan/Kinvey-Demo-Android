package com.vishnuvathsan.kinveydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {

    private EditText etNAME, etID, etLMT, etECT, etACL;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        etNAME = (EditText) findViewById(R.id.etNAME);
        etNAME.setText(MainActivity.EVENT_ENTITY.getName());

        etID = (EditText) findViewById(R.id.etID);
        etID.setText(MainActivity.EVENT_ENTITY.getId());

        etLMT = (EditText) findViewById(R.id.etLMT);
        etLMT.setText(MainActivity.EVENT_ENTITY.getMeta().getLastModifiedTime());

        etECT = (EditText) findViewById(R.id.etECT);
        etECT.setText(MainActivity.EVENT_ENTITY.getMeta().getEntityCreationTime());

        etACL = (EditText) findViewById(R.id.etACL);
        etACL.setText(MainActivity.EVENT_ENTITY.getAcl().toString());

    }
}
