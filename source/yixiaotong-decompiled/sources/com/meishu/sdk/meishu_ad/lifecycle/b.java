package com.meishu.sdk.meishu_ad.lifecycle;

import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: LifecycleFragmentV4.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends Fragment {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f5036a;

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f5036a;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d dVar = this.f5036a;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.f5036a;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        d dVar = this.f5036a;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.f5036a;
        if (dVar != null) {
            dVar.onStop();
        }
    }
}
