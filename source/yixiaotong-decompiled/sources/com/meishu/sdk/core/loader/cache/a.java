package com.meishu.sdk.core.loader.cache;

import android.os.SystemClock;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: compiled from: CacheEntity.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4807a;
    public SdkAdInfo b;
    public int c;
    public Object d;
    public boolean e;
    public long f;
    public long g;
    public MeishuAdInfo h;

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        return aVar.c - this.c;
    }

    public String toString() {
        return com.meishu.sdk.activity.a.a("CacheEntity{key =").append(this.f4807a).append(",ad =").append(this.d).append(",sdkAdInfo=").append(this.b.getSdk()).append(", cacheScore=").append(this.c).append('}').toString();
    }

    /* JADX WARN: switch over string: strings are not added: [[HW], [JD], [SGM], [BAIDU]] */
    public boolean a() {
        long expire_timestamp;
        long j = 1740000;
        if (!this.e) {
            expire_timestamp = this.b.getExpire_timestamp();
            String sdk = this.b.getSdk();
            sdk.getClass();
            sdk.hashCode();
            switch (sdk) {
                case "KS":
                case "CSJ":
                    j = 3540000;
                    break;
            }
        } else {
            expire_timestamp = this.g;
        }
        if (expire_timestamp > 0) {
            j = 1000 * expire_timestamp;
        }
        return SystemClock.uptimeMillis() - (this.e ? this.f : this.b.getLoadedTime()) < j;
    }
}
