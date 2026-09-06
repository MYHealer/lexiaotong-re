package com.meishu.sdk.platform.ms.paster;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f5180a;

    public b(d.a aVar) {
        this.f5180a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            d.this.k = System.currentTimeMillis();
            d.this.g = (int) motionEvent.getX();
            d.this.h = (int) motionEvent.getY();
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        d dVar = d.this;
        System.currentTimeMillis();
        dVar.getClass();
        d.this.i = (int) motionEvent.getX();
        d.this.j = (int) motionEvent.getY();
        return false;
    }
}
