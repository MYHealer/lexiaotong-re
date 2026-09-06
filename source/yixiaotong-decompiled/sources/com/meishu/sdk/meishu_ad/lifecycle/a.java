package com.meishu.sdk.meishu_ad.lifecycle;

import android.app.Fragment;

/* JADX INFO: compiled from: LifecycleFragment.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends Fragment {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f5035a;

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f5035a;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        d dVar = this.f5035a;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.f5035a;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d dVar = this.f5035a;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.f5035a;
        if (dVar != null) {
            dVar.onStop();
        }
    }
}
