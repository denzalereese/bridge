package com.example.generalassembly.bridge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    //public void onClick(View view){

    //}

    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    public void handleResult(Result result) {
        Log.v("handleResult", result.getText());
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        builder.setMessage(result.getText());
        AlertDialog alertDialog= builder.create();
        alertDialog.show();*/
        String resultUrl = result.getText();
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(resultUrl));
        //startActivity(browserIntent);

        //resume scanning
        //mScannerView.resumeCameraPreview(this);
        //mScannerView.startCamera();

        Intent intent = new Intent(this, BridgeActivity.class);
        intent.putExtra("result", resultUrl);
        startActivity(intent);
    }




}
