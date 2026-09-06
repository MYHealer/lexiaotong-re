package com.meishu.sdk.meishu_ad.splash;

import android.content.Context;
import android.view.View;
import com.meishu.sdk.R;
import com.meishu.sdk.core.utils.m;

/* JADX INFO: compiled from: SplashPaddingUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5085a;

    public static int b(Context context) {
        if (context == null) {
            return 12;
        }
        try {
            return ((int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 3.6d)) / 100;
        } catch (Exception unused) {
            return (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 12;
        }
        try {
            return (context.getResources().getDisplayMetrics().widthPixels * 10) / 100;
        } catch (Exception unused) {
            return (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        }
    }

    public static int a(Context context) {
        if (context == null) {
            return 12;
        }
        try {
            if (f5085a <= 0) {
                f5085a = m.a(context);
            }
            return (int) ((((double) f5085a) * 1.8d) / 100.0d);
        } catch (Exception unused) {
            return (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        }
    }

    public static int a(MeishuSplashRootView meishuSplashRootView) {
        View viewFindViewById;
        if (meishuSplashRootView != null) {
            try {
                viewFindViewById = meishuSplashRootView.findViewById(R.id.ms_skipView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            viewFindViewById = null;
        }
        int iB = (viewFindViewById == null || viewFindViewById.getMeasuredWidth() <= 0) ? 0 : (int) m.b(meishuSplashRootView.getContext(), viewFindViewById.getMeasuredWidth());
        if (iB <= 0) {
            return 36;
        }
        return iB;
    }
}
