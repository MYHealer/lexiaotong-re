package com.fancy.mpsdk.activity;

import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgInteractionLandscapeActivity extends PtgInteractionPortraitActivity {
    @Override // com.fancy.mpsdk.activity.PtgInteractionPortraitActivity
    public final void _a() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(0);
        }
    }
}
