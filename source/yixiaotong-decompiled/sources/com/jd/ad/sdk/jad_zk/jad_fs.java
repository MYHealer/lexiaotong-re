package com.jd.ad.sdk.jad_zk;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements jad_dq {
    public jad_cp jad_an(Context context, jad_cp.jad_an jad_anVar) {
        boolean z = ContextCompat.checkSelfPermission(context, g.b) == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Object[] objArr = new Object[1];
            objArr[0] = z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Logger.d("ConnectivityMonitor", objArr);
        }
        return z ? new jad_er(context, jad_anVar) : new jad_na();
    }
}
