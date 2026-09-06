package com.jd.ad.sdk.bl.adinteraction.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.jad_er.jad_bo;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADTransparentActivity extends Activity {
    public static Intent jad_dq;
    public static String jad_er;
    public static OnUserCancelJdJumpCallback jad_fs;
    public static OnOpenAppCallback jad_jt;
    public Handler jad_an = null;
    public boolean jad_bo = false;
    public final AtomicInteger jad_cp = new AtomicInteger(0);

    static {
        StubApp.interface11(36866);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        AtomicInteger atomicInteger;
        super.onActivityResult(i, i2, intent);
        if (i != 9991 || i2 != 0 || (atomicInteger = this.jad_cp) == null || atomicInteger.get() >= 1) {
            return;
        }
        this.jad_cp.incrementAndGet();
        if (JADMediator.getInstance().getInitService().isForbidModelToH5()) {
            return;
        }
        if (JADMediator.getInstance().getInitService().getNeedCheckMediaClickH5() != 1) {
            if (this.jad_an == null) {
                this.jad_an = new Handler(Looper.getMainLooper());
            }
            this.jad_an.postDelayed(new jad_bo(this), JADMediator.getInstance().getInitService().getJumpToH5DelayTime());
        } else {
            int iOnUserCancelJdJump = JADMediator.getInstance().getTouchService().onUserCancelJdJump(this, jad_er);
            OnUserCancelJdJumpCallback onUserCancelJdJumpCallback = jad_fs;
            if (onUserCancelJdJumpCallback != null) {
                onUserCancelJdJumpCallback.callback(iOnUserCancelJdJump);
            }
        }
    }

    public void onBackgroundClick(View view) {
        finish();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.jad_bo = true;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.jad_bo = false;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.jad_bo = true;
        finish();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return false;
    }
}
