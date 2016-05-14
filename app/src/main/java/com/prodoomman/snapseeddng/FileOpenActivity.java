package com.prodoomman.snapseeddng;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FileOpenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_open);

        Intent intent = getIntent();
        intent.setComponent(new ComponentName("com.niksoftware.snapseed","com.google.android.apps.snapseed.EditActivity"));
        intent.setDataAndType(intent.getData(),"image/x-adobe-dng");
        intent.setAction("android.intent.action.EDIT");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, R.string.snapseed_open_error, Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
