package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0oo0o {
    public static boolean OooO00o(MotionEvent motionEvent, FrameLayout frameLayout, oo00o oo00oVar) {
        if (oo00oVar != null && frameLayout != null && motionEvent != null) {
            try {
                oOO00O ooo00o = oo00oVar.getBaseAdConfig().OooOOO0;
                if (o0O0OOOo.OooO00o(ooo00o) && o0O0OOOo.OooO0OO(oo00oVar.getBaseAdConfig().OooO00o, ooo00o)) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    ooooO000.OooO0O0("----dispatchTE outer down x", motionEvent.getX() + " outer down y" + motionEvent.getY());
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, motionEvent.getX(), motionEvent.getY(), 0);
                    frameLayout.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    long j = jUptimeMillis + 5;
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(j, j, 1, motionEvent.getX(), motionEvent.getY(), 0);
                    frameLayout.dispatchTouchEvent(motionEventObtain2);
                    motionEventObtain2.recycle();
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
