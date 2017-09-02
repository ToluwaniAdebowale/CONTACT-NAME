package com.example.android.mycontact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mailIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "glonimi0@gmail.com");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void callIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "08025428339"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void messengerIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + "08025428339"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        intent.putExtra(Intent.EXTRA_STREAM, "08025428339");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void linkedinIntent(View view) {
        Uri webpage = Uri.parse("https://www.linkedin.com/in/glory-adebowale-82926113a");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
