package com.jd.ad.sdk.jad_n_an;

import android.view.View;

/* JADX INFO: compiled from: JADNativeViewController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_kx implements View.OnClickListener {
    public final /* synthetic */ jad_n_an jad_n_an;
    public final /* synthetic */ jad_n_er jad_n_bo;

    public jad_n_kx(jad_n_er jad_n_erVar, jad_n_an jad_n_anVar) {
        this.jad_n_bo = jad_n_erVar;
        this.jad_n_an = jad_n_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        jad_n_er.jad_n_an(this.jad_n_bo, view, true);
        this.jad_n_an.jad_n_bo();
    }
}
