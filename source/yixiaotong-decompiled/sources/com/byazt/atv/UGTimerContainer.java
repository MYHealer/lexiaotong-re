package com.byazt.atv;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 1541})
public class UGTimerContainer extends FrameLayout {
    public com.byazt.qmz.c c;
    public final com.byazt.xyr.sp tt;

    public void setTimerHolder(com.byazt.qmz.c cVar) {
        this.c = cVar;
    }

    public UGTimerContainer(Context context, com.byazt.xyr.sp spVar) {
        super(context);
        this.tt = spVar;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.byazt.qmz.c cVar = this.c;
        if (cVar != null) {
            if (i == 0) {
                cVar.c();
            } else {
                cVar.tt();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.byazt.xyr.sp spVar = this.tt;
        if (spVar != null) {
            spVar.c(this, motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }
}
