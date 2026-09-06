package com.adprof.sdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.adprof.sdk.base.activity.AdActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sc implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vc f1419a;

    public sc(vc vcVar) {
        this.f1419a = vcVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Context context = AdprofSdk.getInstance().getContext();
        d dVar = ((x0) this.f1419a).f821a;
        j5.a(context, AdActivity.class, dVar, dVar.f189a.e);
        return true;
    }
}
