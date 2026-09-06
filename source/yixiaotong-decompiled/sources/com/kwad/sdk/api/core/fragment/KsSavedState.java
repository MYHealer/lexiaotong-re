package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsSavedState {
    final Fragment.SavedState mSaveState;

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }
}
