package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: RewardWebUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BaseAdSlot f4898a;

    public static boolean a(Context context, BaseAdSlot baseAdSlot) {
        BaseAdSlot baseAdSlot2;
        if (!b(context) || TextUtils.isEmpty(baseAdSlot.getReward_tmp_url()) || baseAdSlot.getRewardTmpId() <= 0 || baseAdSlot.getReward_tmp_type() <= 0 || !com.meishu.sdk.core.webview.o.a(baseAdSlot.getReward_tmp_url())) {
            return false;
        }
        f4898a = baseAdSlot;
        try {
            if (!TextUtils.isEmpty(((com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot).title) || !TextUtils.isEmpty(f4898a.getDesc()) || !TextUtils.isEmpty(f4898a.getIcon())) {
                if (c(context)) {
                    return true;
                }
                if (a(context) && (baseAdSlot2 = f4898a) != null && !TextUtils.isEmpty(baseAdSlot2.getDeep_link())) {
                    return true;
                }
                try {
                    if (f4898a.getInteractionType() == 1 && f4898a.getDirect_market() == 1 && !TextUtils.isEmpty(f4898a.getPackageName())) {
                        return true;
                    }
                } catch (Exception unused) {
                }
                if (f4898a.getInteractionType() != 1 && f4898a.getdUrl() != null) {
                    return true;
                }
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static boolean b(Context context) {
        try {
            return ((context.getResources().getConfiguration().orientation == 2) || Boolean.TRUE.equals(com.meishu.sdk.platform.ms.splash.k.a(context))) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean c(Context context) {
        if (TextUtils.isEmpty(f4898a.getWx_username()) || TextUtils.isEmpty(f4898a.getWx_appid())) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.tencent.mm", 256) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        BaseAdSlot baseAdSlot = f4898a;
        boolean z = false;
        if (baseAdSlot == null) {
            return false;
        }
        String packageName = baseAdSlot.getPackageName();
        try {
            if (!TextUtils.isEmpty(packageName) && !packageName.contains("://")) {
                if (context.getPackageManager().getPackageInfo(packageName, 256) != null) {
                    z = true;
                }
            } else {
                Intent uri = Intent.parseUri(f4898a.getDeep_link(), 0);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                if (uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }
}
