package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class uf implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vf f1459a;

    public uf(vf vfVar) {
        this.f1459a = vfVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            s3 s3Var = ((pf) this.f1459a).f584a;
            if (s3Var != null) {
                s3Var.performClick();
            } else if (s3Var != null && s3Var.getSixDownloadView() != null) {
                ((pf) this.f1459a).f584a.getSixDownloadView().performClick();
            }
        } catch (Throwable unused) {
        }
    }
}
