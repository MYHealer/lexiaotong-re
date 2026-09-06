package com.jd.ad.sdk.jad_ob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: NetworkConnectChangedReceiver.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (ContextCompat.checkSelfPermission(context, g.b) == -1) {
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                Logger.d("net is unavailable");
            } else {
                Logger.d("net is available");
                if (!jad_bo.jad_bo) {
                    jad_er.jad_an(JADYunSdk.getAppId());
                }
            }
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while network receiver onReceive：").append(e.getMessage()).toString());
        }
    }
}
