package com.huawei.hms.ads;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cs extends cr {
    private static final int B = 0;
    private static final String I = "BaseHwnDeviceImpl";
    private static final String Z = "display_notch_status";

    protected cs(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean Code(Context context) {
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), Z);
            fh.Code(I, "isNotchEnable, displayNotch: %s", Integer.valueOf(i));
            return i == 0;
        } catch (Throwable th) {
            fh.V(I, "isNotchEnable err:" + th.getClass().getSimpleName());
            return Code((View) null) > 0;
        }
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean V() {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code(CountryCodeBean.LOCALE_COUNTRYSYSTEMPROP);
        if (!TextUtils.isEmpty(strCode)) {
            return CountryCodeBean.SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(strCode);
        }
        String strCode2 = com.huawei.openalliance.ad.utils.bg.Code("ro.product.locale");
        if (!TextUtils.isEmpty(strCode2)) {
            return strCode2.toLowerCase(Locale.ENGLISH).contains(CountryCodeBean.SPECIAL_COUNTRYCODE_CN);
        }
        String strZ = com.huawei.openalliance.ad.utils.bg.Z();
        if (TextUtils.isEmpty(strZ)) {
            return false;
        }
        return CountryCodeBean.SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(strZ);
    }
}
