package com.byazt.aas;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS})
public class h {
    public static void c(final ic icVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("win") { // from class: com.byazt.aas.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.ve(icVar, d);
                }
            });
        } else {
            ve(icVar, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(ic icVar, Double d) {
        if (icVar == null || icVar.yt() == null) {
            return;
        }
        icVar.bn().ve(1);
        try {
            Object obj = icVar.yt().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) icVar.yt().get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.byazt.omf.gt.c().c(c(icVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final ic icVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("loss") { // from class: com.byazt.aas.h.2
                @Override // java.lang.Runnable
                public void run() {
                    h.ve(icVar, d, str, str2);
                }
            });
        } else {
            ve(icVar, d, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(ic icVar, Double d, String str, String str2) {
        if (icVar == null || icVar.yt() == null) {
            return;
        }
        try {
            icVar.bn().ve(2);
            Object obj = icVar.yt().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) icVar.yt().get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.byazt.omf.gt.c().c(c(icVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039 A[PHI: r0
  0x0039: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:8:0x001c, B:13:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    private static String c(ic icVar, String str, String str2) throws Exception {
        int iIntValue;
        if (icVar == null || str == null || !str.contains(str2)) {
            return str;
        }
        Pair<Integer, JSONObject> pairC = com.byazt.by.a.c().c(icVar.w_(), false);
        String strOptString = "";
        if (pairC == null) {
            iIntValue = 3;
        } else {
            strOptString = pairC.second != null ? ((JSONObject) pairC.second).optString(CrashHianalyticsData.MESSAGE) : "";
            if (pairC.first != null) {
                iIntValue = ((Integer) pairC.first).intValue();
            } else {
                iIntValue = 3;
            }
        }
        if (iIntValue != 3) {
            try {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str = str + "?abort_aes=1";
                } else {
                    str = str + "&abort_aes=1";
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        return str.replace(str2, URLEncoder.encode(strOptString, "UTF-8"));
    }
}
