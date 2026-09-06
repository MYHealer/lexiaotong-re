package com.byazt.za;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.lu.uj;
import com.byazt.yv.da;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 76, 1534})
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            uj.c(stringArrayExtra);
        } else {
            da.tt((Throwable) null);
        }
    }
}
