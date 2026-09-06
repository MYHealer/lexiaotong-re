package com.jd.ad.sdk.jad_kn;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.jd.android.sdk.coreinfo.CoreInfo;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public static List<String> jad_bo = Arrays.asList("Lenovo TB-J606F", "Xiaomi Pad 5 Pro", "Xiaomi Pad 5", "Lenovo TB-9707F", "AGS3-AL09HN", "AGR-AL09HN", "AGS3K-AL20", "SM-T735C", "SM-X205C", "AGM3-AL09HN", "BAH2-AL10", "CMR-AL19", "AGS2-AL00", "AGS3-AL00", "BAH2-AL10", "JDN2-AL50HN", "JDN2-AL50", "AGS2-AL00HN", "JDN2-AL00HN", "JDN2-AL00", "SM-T505C", "HDL-AL09", "CPN-AL00", "MI PAD 4 PLUS", "MI PAD 4", "SM-T725C", "BTV-DL09", "BAH-AL00", "SHT-AL09", "DBY-W09", "BAH3-W59", "MRX-W09", "MRR-W29", "SCM-W09", "MRX-W29", "SCM-W09", "MRX-W29", "SCM-W09", "MRX-W29", "SCMR-W09", "TAS-AN00", "BRT-W09", "KJR-W09", "WGR-W09", "BAH3-W09", "AGM3-W09HN", "VRD-W09", "VRD-W10", "KRJ-W09", "BTV-W09", "PA2170", "GOT-W09", "OPD2101", "AGS2-W09HN", "JDN2-W09HN", "JDN2-W09", "BAH2-W09", "CMR-W09", "BAH2-W09", "KRJ2-W09", "AGS3-W00E", "AGS2-W09", "BAH4-W29", "M2012K11AC", "BAH4-W29", "SHT-W09", "LSA-AN00", "GOT-W29", "MRX-W19", "MRX-W39", "SHT-W09", "GOT-W29", "MRX-W19", "MRX-W39", "HEY-W09");
    public Context jad_an;

    public jad_dq(Context context) {
        this.jad_an = context;
    }

    public final boolean jad_an() {
        try {
            String bluetoothName = CoreInfo.Device.getBluetoothName(this.jad_an);
            return bluetoothName.contains("平板") || bluetoothName.contains("Pad") || bluetoothName.contains("Tab");
        } catch (Exception e) {
            Log.e("IPadChecker", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("bluetoothNameCheck异常").append(e.getMessage()).toString());
            return false;
        }
    }

    public final boolean jad_bo() {
        try {
            return jad_bo.contains(Build.MODEL);
        } catch (Exception e) {
            Log.e("IPadChecker", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("modelListCheck异常").append(e.getMessage()).toString());
            return false;
        }
    }

    public boolean jad_cp() {
        try {
            boolean z = (this.jad_an.getResources().getConfiguration().screenLayout & 15) >= 3;
            Display defaultDisplay = ((WindowManager) this.jad_an.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return z || Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
        } catch (Exception unused) {
            return false;
        }
    }
}
