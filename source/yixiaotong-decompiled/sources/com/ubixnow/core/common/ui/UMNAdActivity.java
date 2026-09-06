package com.ubixnow.core.common.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import com.ubixnow.ooooo.o0OO0o;
import com.ubixnow.ooooo.o0OO0oO0;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdActivity extends Activity {
    private static final String OooO00o = "UbixAdActivity";

    public class OooO00o implements o0OO0o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o0OO0o
        public void OooO00o() {
            UMNAdActivity.this.finish();
        }

        @Override // com.ubixnow.ooooo.o0OO0o
        public void OooO00o(int i, String str) {
            UMNAdActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(52740);
    }

    private void OooO00o() {
        o0OO0oO0 o0oo0oo0 = new o0OO0oO0(this);
        o0oo0oo0.setTrackingInfo((HashMap) getIntent().getSerializableExtra("trackInfo"));
        o0oo0oo0.setDislikeCallback(new OooO00o());
        setContentView(o0oo0oo0);
    }

    private void OooO0O0() {
        View decorView;
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        if (i2 >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            getWindow().getInsetsController().setSystemBarsBehavior(2);
            decorView = getWindow().getDecorView();
            i = AVMDLDataLoader.KeyIsLoaderCacheSize;
        } else {
            decorView = getWindow().getDecorView();
            i = 3846;
        }
        decorView.setSystemUiVisibility(i);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);
}
