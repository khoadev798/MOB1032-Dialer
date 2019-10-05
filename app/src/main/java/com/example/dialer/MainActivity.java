package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText number = null;
    private Button call = null;
    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapComp();
        SetOnClickListener();
    }

    private void mapComp() {
        if (number == null)
            number = findViewById(R.id.number);
        if (call == null)
            call = findViewById(R.id.call);
    }

    private void SetOnClickListener() {
        if (number == null)
            mapComp();
        if (call == null)
            mapComp();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ntc = number.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + ntc));
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                }
                startActivity(intent);
            }
        });
    }
}
