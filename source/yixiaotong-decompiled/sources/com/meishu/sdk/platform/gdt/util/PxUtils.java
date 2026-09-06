package com.meishu.sdk.platform.gdt.util;

import android.content.Context;
import android.util.TypedValue;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PxUtils {
    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics());
    }

    public static int getDeviceHeightInPixel(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceWidthInPixel(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int pxToDp(Context context, int i) {
        return (int) ((i / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }
}
