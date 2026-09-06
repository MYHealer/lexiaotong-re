package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.android.util.HwNotchSizeUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cv extends cs {
    private static final String B = "true";
    private static final String C = "156";
    private static final String I = "HnDeviceImpl";
    private static final byte[] S = new byte[0];
    private static da Z;

    private cv(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String strV = V("msc.build.platform.version");
        this.V.V(strV);
        return strV;
    }

    private static da I(Context context) {
        da daVar;
        synchronized (S) {
            if (Z == null) {
                Z = new cv(context);
            }
            daVar = Z;
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
        return com.huawei.openalliance.ad.utils.bg.Code("msc.sys.country");
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
        return C.equals(com.huawei.openalliance.ad.utils.bg.Code("msc.config.optb"));
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.bg.Code("msc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public String Z() {
        String strC = this.V.C();
        if (TextUtils.isEmpty(strC)) {
            strC = F();
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.cv.1
                @Override // java.lang.Runnable
                public void run() {
                    cv.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.x.bg, strC)) {
            return null;
        }
        return strC;
    }
}
