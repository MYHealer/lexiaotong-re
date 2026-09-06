package com.byazt.xv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2493, 2494})
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    public WeakReference<c> c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<c> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().b_(intExtra);
    }

    public void c(c cVar) {
        this.c = new WeakReference<>(cVar);
    }
}
