package com.yfanads.android.db.imp;

import android.text.TextUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFTimeUtils;

/* JADX INFO: compiled from: HourFrequency.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c extends com.yfanads.android.db.inf.b {
    public c(String str, long j) {
        super(str, j, "hourT");
    }

    public final boolean a() {
        String[] strArr;
        try {
            if (this.f9648a != 0 && (strArr = this.b) != null && strArr.length >= 2) {
                if (YFTimeUtils.isEqualsHour(this.b[0])) {
                    boolean z = true;
                    int i = TextUtils.isEmpty(this.b[1]) ? 0 : Integer.parseInt(this.b[1]);
                    if (i < this.f9648a) {
                        z = false;
                    }
                    YFLog.debug("HourFrequency lastAdsTime = " + this.b[0] + ", frequency = " + this.f9648a + ", showNumbers = " + i + " , isHit " + z);
                    return z;
                }
                return false;
            }
            YFLog.debug("HourFrequency has no limit " + this.f9648a);
            return false;
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("HourFrequency isHit exception "));
        }
    }
}
