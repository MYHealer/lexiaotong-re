package com.meishu.sdk.platform.ms.recycler;

import android.view.MotionEvent;
import android.view.View;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.s1;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SlideClickTouchEventWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r implements View.OnTouchListener {
    public static final String m = "r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5229a;
    public final List<View> b;
    public boolean c;
    public boolean d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public long j;
    public final int k;
    public volatile boolean l;

    public r(View view, int i) {
        this(view, i, null);
    }

    public void a(float f, float f2, long j, float f3, float f4, int i) {
    }

    public void a(MotionEvent motionEvent) {
    }

    public r(View view, int i, List<View> list) {
        this.c = true;
        this.d = false;
        this.l = false;
        this.f5229a = view;
        this.k = i;
        this.b = list;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        if (this.f5229a != null && this.k > 0) {
            try {
                if (motionEvent.getAction() == 0) {
                    a(motionEvent);
                    b(motionEvent);
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    float f = this.f5229a.getContext().getResources().getDisplayMetrics().density;
                    int iMax = (int) Math.max(Math.abs(this.g - motionEvent.getRawX()), Math.abs(this.h - motionEvent.getRawY()));
                    this.i = iMax;
                    if (iMax / f > this.k && this.e > 0.0f && this.f > 0.0f && !this.l) {
                        this.l = true;
                        a(this.e, this.f, this.j, motionEvent.getX(), motionEvent.getY(), this.i);
                        return this.c;
                    }
                }
            } catch (Throwable th) {
                LogUtil.dev(m, th);
            }
            try {
                if (!this.d || (view2 = this.f5229a) == null || view2.isShown()) {
                    View view3 = this.f5229a;
                    this.f5229a.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - view3.getLeft(), motionEvent.getY() - view3.getTop(), motionEvent.getMetaState()));
                }
                return this.c;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void b(MotionEvent motionEvent) {
        View view;
        this.l = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0;
        if (motionEvent == null) {
            return;
        }
        if (!this.d || (view = this.f5229a) == null || view.isShown()) {
            List<View> list = this.b;
            if (list != null && !list.isEmpty()) {
                List<View> list2 = this.b;
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (list2 != null) {
                    try {
                        if (list2.isEmpty()) {
                            return;
                        }
                        Iterator<View> it = list2.iterator();
                        while (it.hasNext()) {
                            if (s1.a(it.next(), rawX, rawY)) {
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                return;
            }
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
            this.g = motionEvent.getRawX();
            this.h = motionEvent.getRawY();
            this.i = 0;
            this.j = System.currentTimeMillis();
        }
    }
}
