package com.jd.ad.sdk.jad_f_an;

import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_er implements View.OnTouchListener {
    public final /* synthetic */ View jad_f_an;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_bo jad_f_bo;

    public jad_f_er(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar, View view) {
        this.jad_f_bo = jad_f_boVar;
        this.jad_f_an = view;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADMediator.getInstance().getTouchService().onViewTouch(this.jad_f_an, motionEvent, this.jad_f_bo.jad_f_dq);
        return false;
    }
}
