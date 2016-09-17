package com.example.generalassembly.bridge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BridgeActivity extends AppCompatActivity {

    String bridgeInfo;
    String twitterUrl;
    String linkedInUrl;
    String instagramUrl;
    String facebookUrl;
    String snapchatUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);

        Intent intent = getIntent();
        bridgeInfo = intent.getStringExtra("result");

        twitterUrl = bridgeInfo.substring(0, bridgeInfo.indexOf(" "));
        bridgeInfo = bridgeInfo.substring(bridgeInfo.indexOf(" ") + 1);
        linkedInUrl = bridgeInfo.substring(0, bridgeInfo.indexOf(" "));
        bridgeInfo = bridgeInfo.substring(bridgeInfo.indexOf(" ") + 1);
        instagramUrl = bridgeInfo.substring(0, bridgeInfo.indexOf(" "));
        bridgeInfo = bridgeInfo.substring(bridgeInfo.indexOf(" ") + 1);
        snapchatUrl = bridgeInfo.substring(0, bridgeInfo.indexOf(" "));
        facebookUrl = bridgeInfo.substring(bridgeInfo.indexOf(" ") + 1);

    }

    public void twitterClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
        startActivity(browserIntent);
    }

    public void linkedInClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
        startActivity(browserIntent);
    }

    public void instagramClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
        startActivity(browserIntent);
    }

    public void snapchatClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapchatUrl));
        startActivity(browserIntent);
    }

    public void facebookClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
        startActivity(browserIntent);
    }
}
