package com.yfanads.android.qapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DummyActivity extends Activity {
    static {
        StubApp.interface11(57376);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
    }
}
