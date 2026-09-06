package com.byazt.iym;

import android.content.Context;
import android.view.MotionEvent;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 1570})
public class RewardDrawRecyclerView extends RecyclerView {
    @Override // com.byazt.kt.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.byazt.kt.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        m.uj("lfz", motionEvent.toString());
        return false;
    }
}
