package com.hihonor.adsdk.base.net.p;

import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.f.t;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static String hnadsa = "BaseUrlHelper";
    private static String hnadsb = "drcn";

    public static String hnadsa() {
        hnadsb();
        hnadsc();
        return HnAds.get().getContext().getResources().getString(R.string.ads_base_url);
    }

    private static String hnadsb() {
        return t.hnadsc().hnadsa(b.a.hnadsa, "");
    }

    private static String hnadsc() {
        return t.hnadsc().hnadsa(b.a.hnadsb, "");
    }

    private static boolean hnadsd() {
        return (TextUtils.isEmpty(hnadsb()) || TextUtils.isEmpty(hnadsc())) ? false : true;
    }

    private static String hnadsa(String str, String str2) {
        str2.hashCode();
        str2.hashCode();
        switch (str2) {
            case "dra":
                return str.replace(hnadsb, b.c.hnadsc);
            case "dre":
                return str.replace(hnadsb, b.c.hnadsd);
            case "drru":
                return str.replace(hnadsb, b.c.hnadsb);
            default:
                return str.replace(hnadsb, b.c.hnadsa);
        }
    }

    private static String hnadsa(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "env_pref":
                return HnAds.get().getContext().getString(R.string.env_pref);
            case "env_prod":
                return HnAds.get().getContext().getString(R.string.env_prod);
            case "env_test":
                return HnAds.get().getContext().getString(R.string.env_test);
            case "env_uat":
                return HnAds.get().getContext().getString(R.string.env_uat);
            case "env_prod_union":
                return HnAds.get().getContext().getString(R.string.env_prod_union);
            case "env_test_union":
                return HnAds.get().getContext().getString(R.string.env_test_union);
            case "env_devp_union":
                return HnAds.get().getContext().getString(R.string.env_dev_union);
            case "env_pref_union":
                return HnAds.get().getContext().getString(R.string.env_pref_union);
            case "env_uat_union":
                return HnAds.get().getContext().getString(R.string.env_uat_union);
            default:
                return HnAds.get().getContext().getString(R.string.env_dev);
        }
    }
}
