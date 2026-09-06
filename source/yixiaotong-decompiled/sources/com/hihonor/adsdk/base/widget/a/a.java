package com.hihonor.adsdk.base.widget.a;

import android.database.Observable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends Observable<b> {
    public void hnadsa() {
        if (((Observable) this).mObservers == null) {
            return;
        }
        for (int i = 0; i < ((Observable) this).mObservers.size(); i++) {
            ((b) ((Observable) this).mObservers.get(i)).hnadsa();
        }
    }

    public boolean hnadsa(b bVar) {
        return ((Observable) this).mObservers.contains(bVar);
    }
}
