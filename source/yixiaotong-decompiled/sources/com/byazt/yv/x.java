package com.byazt.yv;

import android.os.SystemProperties;
import com.byazt.nr.m;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.y, 71})
public class x {
    public static volatile Object c;

    private Object c() {
        if (c == null) {
            synchronized (x.class) {
                if (c == null) {
                    try {
                        c = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).newInstance();
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            }
        }
        return c;
    }

    public String c(String str) throws IllegalArgumentException {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            da.c(th);
            try {
                Object objC = c();
                return (String) objC.getClass().getMethod("get", String.class).invoke(objC, str);
            } catch (Throwable th2) {
                da.c(th2);
                return "";
            }
        }
    }
}
