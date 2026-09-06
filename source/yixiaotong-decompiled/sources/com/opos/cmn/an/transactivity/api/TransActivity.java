package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TransActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.transactivity.a.a f5957a = null;

    static {
        StubApp.interface11(47578);
    }

    private void a() {
        finish();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.opos.cmn.an.f.a.b("TransActivity", "onDestroy");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.f(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onDestroy", e);
        }
        this.f5957a = null;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("TransActivity", "onNewIntent");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.a(this, intent);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onNewIntent", e);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("TransActivity", "onPause");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.d(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onPause", e);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.opos.cmn.an.f.a.b("TransActivity", "onRestart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onRestart", e);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b("TransActivity", "onResume");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onResume", e);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("TransActivity", "onStart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.a(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStart", e);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("TransActivity", "onStop");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f5957a;
            if (aVar != null) {
                aVar.e(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStop", e);
            a();
        }
    }
}
