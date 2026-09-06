package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.openalliance.ad.utils.d;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cp {
    private static final byte[] B = new byte[0];
    private static final String Code = "DeviceManager";
    private static final String I = "02";
    private static final String V = "ro.build.2b2c.partner.ext_channel";
    private static volatile da Z;

    public static boolean B(Context context) {
        return V(context) || Code();
    }

    private static boolean C(Context context) {
        StringBuilder sb;
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        String strZ = atVarCode.Z();
        if (!TextUtils.isEmpty(strZ)) {
            return TextUtils.equals(String.valueOf(true), strZ);
        }
        boolean z = false;
        try {
            boolean z2 = Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR") || Build.MANUFACTURER.equalsIgnoreCase("HONOR");
            if (!z2) {
                try {
                    z2 = ((Integer) Class.forName(d.I() ? "com.hihonor.android.os.Build$VERSION" : EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get(null)).intValue() > 0;
                } catch (RuntimeException e) {
                    z = z2;
                    e = e;
                    sb = new StringBuilder("isHuaweiPhone RuntimeException:");
                    fh.Z(Code, sb.append(e.getClass().getSimpleName()).toString());
                } catch (Throwable th) {
                    z = z2;
                    e = th;
                    sb = new StringBuilder("isHuaweiPhone Error:");
                    fh.Z(Code, sb.append(e.getClass().getSimpleName()).toString());
                }
            }
            z = z2;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (Throwable th2) {
            e = th2;
        }
        atVarCode.V(z);
        return z;
    }

    public static da Code(Context context) {
        da daVarV;
        if (Z == null) {
            synchronized (B) {
                if (Z == null) {
                    if (I(context)) {
                        daVarV = cx.V(context);
                    } else if (Z(context)) {
                        daVarV = cv.V(context);
                    } else {
                        daVarV = Code() ? cu.V(context) : cz.V(context);
                    }
                    Z = daVarV;
                }
            }
        }
        return Z;
    }

    private static boolean Code() {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code("ro.build.2b2c.partner.ext_channel");
        return !TextUtils.isEmpty(strCode) && strCode.startsWith("02");
    }

    public static boolean I(Context context) {
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(context);
        String strL = atVarCode.L();
        if (!TextUtils.isEmpty(strL)) {
            return TextUtils.equals(String.valueOf(true), strL);
        }
        boolean z = V(context) && !Z(context);
        atVarCode.Z(z);
        return z;
    }

    public static boolean V(Context context) {
        return C(context);
    }

    public static boolean Z(Context context) {
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(context);
        String strA = atVarCode.a();
        if (!TextUtils.isEmpty(strA)) {
            return TextUtils.equals(String.valueOf(true), strA);
        }
        boolean z = false;
        try {
            z = Build.MANUFACTURER.equalsIgnoreCase("HONOR") && Build.VERSION.SDK_INT >= 31 && com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            fh.Z(Code, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
        }
        atVarCode.B(z);
        return z;
    }
}
