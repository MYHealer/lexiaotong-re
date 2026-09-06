package com.fancy.mpsdk.activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c implements PtgInteractionPortraitActivity._d {
    public final /* synthetic */ PtgInteractionPortraitActivity _a;

    public _c(PtgInteractionPortraitActivity ptgInteractionPortraitActivity) {
        this._a = ptgInteractionPortraitActivity;
    }

    @Override // com.fancy.mpsdk.activity.PtgInteractionPortraitActivity._d
    public final void _a() {
        try {
            if (this._a.isFinishing()) {
                return;
            }
            this._a.finish();
        } catch (Exception unused) {
        }
    }
}
