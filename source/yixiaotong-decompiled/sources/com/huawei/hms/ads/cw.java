package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.hihonor.android.app.ActivityManagerEx;
import com.hihonor.android.app.HwMultiWindowEx;
import com.hihonor.android.content.pm.ApplicationInfoEx;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cw extends ct {
    private static final String Code = "HnSysApiImpl";
    private static final byte[] I = new byte[0];
    private static db V;

    private cw(Context context) {
    }

    public static db Code(Context context) {
        return V(context);
    }

    private static db V(Context context) {
        db dbVar;
        synchronized (I) {
            if (V == null) {
                V = new cw(context);
            }
            dbVar = V;
        }
        return dbVar;
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public String B() {
        return "com.hihonor.android.os.Build";
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public String C() {
        return "com.hihonor.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public Rect Code(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public void Code(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public boolean Code() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            fh.I(Code, "isFreedomWindowMode error");
            return false;
        }
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public String I() {
        return "com.hihonor.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public boolean V() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    @Override // com.huawei.hms.ads.ct, com.huawei.hms.ads.db
    public String Z() {
        return "com.hihonor.android.os.Build$VERSION";
    }
}
