package com.yfanads.android.db.imp;

import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: IntervalFrequency.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d extends com.yfanads.android.db.inf.b {
    public d(String str, long j) {
        super(str, j, "timeT");
    }

    public final boolean a() {
        String[] strArr;
        try {
            if (this.f9648a != 0 && (strArr = this.b) != null && strArr.length >= 2) {
                boolean z = System.currentTimeMillis() - Long.parseLong(this.b[0]) < this.f9648a;
                YFLog.debug("IntervalFrequency lastAdsTime = " + this.b[0] + ", frequency = " + this.f9648a + " , isHit " + z);
                return z;
            }
            YFLog.debug("IntervalFrequency has no limit " + this.f9648a);
            return false;
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("IntervalFrequency isHit exception "));
            return false;
        }
    }
}
