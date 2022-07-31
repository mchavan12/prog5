package com.example.prog5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sms = findViewById(R.id.sms);
        Button mail = findViewById(R.id.email);
        Button phn = findViewById(R.id.phone);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentSMS();
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentMail();
            }
        });

        phn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentPhn();
            }
        });
    }

    protected void sentSMS(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String phnno = "80809780809";
        intent.setData(Uri.parse("sms: "+phnno));
        intent.putExtra(Intent.EXTRA_TEXT, "HELLO");
        startActivity(intent);
    }

    protected void sentMail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setDataAndType(Uri.parse("email: "), "plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "abc@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "HELLO");
        startActivity(intent);
    }
    protected void sentPhn(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}