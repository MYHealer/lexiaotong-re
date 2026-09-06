package com.jd.ad.sdk.dl.baseinfo;

import android.content.Context;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_qd.jad_fs;
import com.jd.ad.sdk.jad_uh.jad_an;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADScreenInfoUtils {
    public static int getScreenHeight(Context context) {
        try {
            if (jad_fs.jad_an.jad_an.jad_an("screenHeight")) {
                return jad_an(context)[1];
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            if (jad_fs.jad_an.jad_an.jad_an("screenWidth")) {
                return jad_an(context)[0];
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int[] jad_an(Context context) {
        String strJad_dq;
        int[] screenSize = new int[2];
        try {
            jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("screenSize", true)) {
                strJad_dq = jad_anVar.jad_dq("screenSize");
            } else {
                if (context == null) {
                    return screenSize;
                }
                screenSize = ScreenUtils.getScreenSize(context);
                strJad_dq = screenSize[0] + "," + screenSize[1];
                jad_anVar.jad_bo("screenSize", strJad_dq);
            }
            if (!TextUtils.isEmpty(strJad_dq)) {
                String[] strArrSplit = strJad_dq.split(",");
                if (strArrSplit.length == 2) {
                    screenSize[0] = Integer.parseInt(strArrSplit[0]);
                    screenSize[1] = Integer.parseInt(strArrSplit[1]);
                }
            }
        } catch (Exception unused) {
        }
        return screenSize;
    }
}
