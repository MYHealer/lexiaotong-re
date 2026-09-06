package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class as {
    public static boolean dC(Context context) {
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(context);
        boolean z = false;
        if (activityFromContext != null) {
            Window window = activityFromContext.getWindow();
            z = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void dD(Context context) {
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(context);
        if (activityFromContext != null) {
            activityFromContext.getWindow().clearFlags(1024);
        }
    }

    public static void dE(Context context) {
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(context);
        if (activityFromContext != null) {
            activityFromContext.setRequestedOrientation(0);
        }
    }

    public static void dF(Context context) {
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(context);
        if (activityFromContext != null) {
            activityFromContext.setRequestedOrientation(1);
        }
    }

    public static boolean VM() {
        return isOrientationPortrait();
    }

    public static boolean isOrientationPortrait() {
        return StubApp.getOrigApplicationContext(ServiceProvider.Ud().getApplicationContext()).getResources().getConfiguration().orientation == 1;
    }

    public static void i(Context context, boolean z) {
        try {
            Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(context);
            if (activityFromContext == null) {
                return;
            }
            if (z) {
                activityFromContext.getWindow().getDecorView().setSystemUiVisibility(1792);
            } else {
                activityFromContext.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
