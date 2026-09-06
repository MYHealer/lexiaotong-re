package com.jd.ad.sdk.jad_er;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.adinteraction.deeplink.JADTransparentActivity;
import com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnOpenAppCallback;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_qd.jad_hu;
import com.jd.ad.sdk.jad_xk.jad_fs;

/* JADX INFO: compiled from: DeepLinkUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static boolean jad_an(Context context, String str, String str2, OnUserCancelJdJumpCallback onUserCancelJdJumpCallback, OnOpenAppCallback onOpenAppCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zJad_an = jad_dq.jad_an.jad_an.jad_an(13, (String) null);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (!(context instanceof Activity) || !zJad_an) {
            intent.addFlags(268435456);
        }
        if (jad_hu.jad_an(true) != 1) {
            return false;
        }
        try {
            if (zJad_an) {
                context.startActivity(intent);
            } else {
                try {
                    JADTransparentActivity.jad_dq = intent;
                    JADTransparentActivity.jad_er = str2;
                    JADTransparentActivity.jad_fs = onUserCancelJdJumpCallback;
                    JADTransparentActivity.jad_jt = onOpenAppCallback;
                    Intent intent2 = new Intent(context, (Class<?>) JADTransparentActivity.class);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    context.startActivity(intent2);
                } catch (Exception unused) {
                    context.startActivity(intent);
                }
            }
            return true;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.INTERACTION_CLICK_OPEN_JD_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return false;
        }
    }

    public static boolean jad_an(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                JADWebViewActivity.startActivity(context, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
