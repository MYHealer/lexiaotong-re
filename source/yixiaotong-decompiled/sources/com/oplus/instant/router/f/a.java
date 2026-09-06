package com.oplus.instant.router.f;

import com.huawei.openalliance.ad.constant.x;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.g.d;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f5776a = new a();
    private Instant.IStatisticsProvider b = null;
    private Instant.IStatisticsProvider c = new C0863a(this);

    /* JADX INFO: renamed from: com.oplus.instant.router.f.a$a, reason: collision with other inner class name */
    class C0863a implements Instant.IStatisticsProvider {
        C0863a(a aVar) {
        }

        @Override // com.oplus.instant.router.Instant.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[").append(str).append(x.bQ).append(map.get(str)).append("]");
            }
            d.c("router_stat", "fail to stat:" + sb.toString());
        }
    }

    private a() {
    }

    public static a a() {
        return f5776a;
    }

    public void a(Instant.IStatisticsProvider iStatisticsProvider) {
        this.b = iStatisticsProvider;
    }

    public Instant.IStatisticsProvider b() {
        Instant.IStatisticsProvider iStatisticsProvider = this.b;
        return iStatisticsProvider != null ? iStatisticsProvider : this.c;
    }
}
