package com.adprof.sdk;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v6 f754a;

    public u6(View view, d dVar, v6 v6Var) {
        this.f1454a = view;
        this.f753a = dVar;
        this.f754a = v6Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View view = this.f1454a;
            if (view == null) {
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            pk.d("------adCtaText: " + iArr[0] + "  " + iArr[1] + PPSLabelView.Code + h8.m641a() + PPSLabelView.Code + h8.a(90.0f));
            int measuredWidth = this.f1454a.getMeasuredWidth();
            int measuredHeight = this.f1454a.getMeasuredHeight();
            int iNextInt = new Random().nextInt(Math.max(1, measuredWidth - 80)) + 40 + iArr[0];
            int iNextInt2 = new Random().nextInt(Math.max(1, measuredHeight - 60)) + 30 + iArr[1];
            long jCurrentTimeMillis = System.currentTimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, iNextInt, iNextInt2, 0);
            pk.d("------adCtaText: w " + measuredWidth + " h " + measuredHeight + " radomI: ");
            this.f753a.m591a().a(motionEventObtain);
            this.f1454a.postDelayed(new t6(this, iNextInt, iNextInt2), new Random().nextInt(400) + 50);
        } catch (Throwable th) {
            pk.a(th);
        }
    }
}
