package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: compiled from: EventBlackList.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends EventList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f9083a;
    private Object b;

    public a(String str, String str2) {
        super(str, str2);
        this.b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.b) {
            if (this.f9083a == null) {
                this.f9083a = new d(false, this.mEventList);
            }
            zA = this.f9083a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.b) {
            this.f9083a = null;
            this.f9083a = new d(false, this.mEventList);
        }
    }
}
