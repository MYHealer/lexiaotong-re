package com.yfanads.android.adx.core.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.yfanads.android.adx.core.TransparentActivity;
import com.yfanads.android.adx.core.annotate.AdRouter;
import com.yfanads.android.adx.core.model.ApiBean;
import com.yfanads.android.dp.DpNative;
import com.yfanads.android.libs.utils.RomUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: RouterImp.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class h implements AdRouter {
    public static boolean a(Context context, String str, String str2) {
        boolean zGhr = DpNative.ghr(context, str, str2);
        if (zGhr) {
            b("hit hn");
        }
        return !zGhr;
    }

    public static void b(String str) {
        YFLog.high("Router|" + str);
    }

    @Override // com.yfanads.android.adx.core.annotate.AdRouter
    public final boolean navigation(Activity activity, ApiBean apiBean) {
        if (activity == null || TextUtils.isEmpty(apiBean.dpLink)) {
            b("invalid router params");
            return false;
        }
        try {
            Intent intentA = a(apiBean.dpLink);
            if (RomUtils.isOps()) {
                String str = apiBean.npd;
                if (TextUtils.isEmpty(str) || !str.contains("ops1")) {
                    b("hit ops default");
                    activity.startActivityForResult(intentA, apiBean.code);
                    return false;
                }
                DpNative.gop(intentA);
                b("hit ops");
                activity.startActivityForResult(intentA, apiBean.code);
            } else if (RomUtils.isHn()) {
                String str2 = apiBean.npd;
                if (TextUtils.isEmpty(str2) || !str2.contains("hn1")) {
                    b("hit hn default");
                    activity.startActivityForResult(intentA, apiBean.code);
                    return false;
                }
                if (TextUtils.isEmpty(apiBean.pkgName) || a(activity, apiBean.dpLink, apiBean.pkgName)) {
                    if (a(activity)) {
                        DpNative.ghr2(intentA, apiBean.dpLink);
                        b("hit hn fail to system");
                    } else {
                        b("hit hn last default");
                    }
                    activity.startActivityForResult(intentA, apiBean.code);
                }
            } else if (RomUtils.isXm()) {
                String str3 = apiBean.npd;
                if (TextUtils.isEmpty(str3) || !str3.contains("xm1") || Build.VERSION.SDK_INT > 35) {
                    String str4 = apiBean.npd;
                    if (TextUtils.isEmpty(str4) || !str4.contains("xm2") || Build.VERSION.SDK_INT <= 35) {
                        b("hit xm default");
                        activity.startActivityForResult(intentA, apiBean.code);
                        return false;
                    }
                    DpNative.txm2(intentA, apiBean.dpLink);
                    b("hit xm2");
                    activity.startActivityForResult(intentA, apiBean.code);
                } else if (a(activity, intentA)) {
                    b("hit xm1 fail to default");
                    activity.startActivityForResult(intentA, apiBean.code);
                    return false;
                }
            } else {
                if (!RomUtils.isHw()) {
                    b("hit default ");
                    activity.startActivityForResult(intentA, apiBean.code);
                    return false;
                }
                String str5 = apiBean.npd;
                if (TextUtils.isEmpty(str5) || !str5.contains("hw1")) {
                    b("hit hw default ");
                    activity.startActivityForResult(intentA, apiBean.code);
                    return false;
                }
                DpNative.scl(intentA);
                b("hit hw");
                activity.startActivityForResult(intentA, apiBean.code);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TransparentActivity.TAG, "startActivity error" + e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("hihonor://com.hihonor.sceneservice")), 65536) != null;
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error("hasHN error " + e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        boolean zTxm = DpNative.txm(context, intent);
        if (zTxm) {
            b("hit xm");
        }
        return !zTxm;
    }

    public static Intent a(String str) {
        Intent intent = new Intent();
        try {
            Uri uri = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            if (str.startsWith("tbopen://")) {
                intent.setFlags(1476395009);
            } else {
                intent.setFlags(1342177280);
            }
            intent.setData(uri);
        } catch (Throwable th) {
            b("set intent " + th.getMessage());
        }
        return intent;
    }
}
