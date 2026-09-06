package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cx extends cs {
    private static final String B = "display_notch_status";
    private static final int C = 0;
    private static final byte[] D = new byte[0];
    private static da F = null;
    private static final String I = "HwDeviceImpl";
    private static final String S = "true";
    private static final String Z = "156";

    private cx(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String strV = V("hw_sc.build.platform.version");
        this.V.V(strV);
        return strV;
    }

    private static da I(Context context) {
        da daVar;
        synchronized (D) {
            if (F == null) {
                F = new cx(context);
            }
            daVar = F;
        }
        return daVar;
    }

    public static da V(Context context) {
        return I(context);
    }

    private String V(String str) {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code(str);
        return strCode == null ? com.huawei.openalliance.ad.constant.x.bg : strCode;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean B() {
        return !TextUtils.isEmpty(Z());
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public String C() {
        return com.huawei.openalliance.ad.utils.bg.Code("ro.hw.country");
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public int Code(View view) {
        StringBuilder sb;
        try {
            if (!HwNotchSizeUtil.hasNotchInScreen()) {
                return 0;
            }
            int[] notchSize = HwNotchSizeUtil.getNotchSize();
            if (notchSize.length >= 2) {
                return notchSize[1];
            }
            return 0;
        } catch (Exception e) {
            e = e;
            sb = new StringBuilder("getNotchHeight error:");
            fh.I(I, sb.append(e.getClass().getSimpleName()).toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("getNotchHeight error:");
            fh.I(I, sb.append(e.getClass().getSimpleName()).toString());
            return 0;
        }
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean Code() {
        return Z.equals(com.huawei.openalliance.ad.utils.bg.Code("ro.config.hw_optb"));
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean I() {
        return com.huawei.openalliance.ad.utils.q.Code(this.Code);
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.bg.Code("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public String Z() {
        String strC = this.V.C();
        if (TextUtils.isEmpty(strC)) {
            strC = F();
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.cx.1
                @Override // java.lang.Runnable
                public void run() {
                    cx.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.x.bg, strC)) {
            return null;
        }
        return strC;
    }
}
