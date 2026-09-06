package com.byazt.dk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 66})
public class t {
    public static void c(Activity activity, final String[] strArr, final a aVar) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str)) {
                    com.byazt.dj.uj ujVarMy = com.byazt.omf.x.m().my();
                    if (ujVarMy != null && aVar != null && !ujVarMy.isCanUseWriteExternal()) {
                        aVar.c("android.permission.WRITE_EXTERNAL_STORAGE");
                        return;
                    } else {
                        break;
                        break;
                        break;
                    }
                }
            }
        }
        if (com.byazt.fh.c.c(activity) < 23) {
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        long jHashCode = activity.hashCode();
        for (String str2 : strArr) {
            jHashCode += (long) str2.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str3 = strArr[0];
            if (TextUtils.equals(str3, "android.permission.READ_EXTERNAL_STORAGE") || TextUtils.equals(str3, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (aVar != null) {
                    aVar.c(str3);
                }
                com.byazt.ukr.yp.c().c(false, new String[]{str3});
                return;
            }
        }
        com.byazt.aas.a.c(String.valueOf(jHashCode), strArr, new com.byazt.aas.a.c() { // from class: com.byazt.dk.t.1
            @Override // com.byazt.aas.a.c
            public void c() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.c();
                }
                com.byazt.ukr.yp.c().c(true, strArr);
            }

            @Override // com.byazt.aas.a.c
            public void c(String str4) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.c(str4);
                }
                com.byazt.ukr.yp.c().c(false, new String[]{str4});
            }
        });
    }

    public static boolean c(Context context, String str) {
        com.byazt.dj.uj ujVarNu;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) && (ujVarNu = com.byazt.omf.x.m().nu()) != null && !ujVarNu.isCanUseWriteExternal()) {
            return false;
        }
        if (context == null) {
            context = gt.getContext();
        }
        return com.byazt.xgx.n.c().c(context, str);
    }
}
