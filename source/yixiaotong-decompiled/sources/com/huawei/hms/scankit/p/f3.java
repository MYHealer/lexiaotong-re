package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.scan.HmsScan;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: compiled from: HaLog60000.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f3 extends e3 {
    private static String o = "AiDetect";
    private static String p = "defaultDetect";
    private int h;
    protected String i;
    protected String j;
    protected long k;
    protected long l;
    protected long m;
    protected boolean n;

    /* JADX INFO: compiled from: HaLog60000.java */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* JADX INFO: compiled from: HaLog60000.java */
    class b extends LinkedHashMap<String, String> {
        b() {
            f3.this.g();
            putAll(f3.this.b);
        }
    }

    public f3(Bundle bundle, String str) {
        super(bundle, StubApp.getOrigApplicationContext(DynamicModuleInitializer.getContext().getApplicationContext()));
        this.h = -1001;
        this.i = e3.d;
        this.j = e3.e;
        this.b.put("callTime", new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(System.currentTimeMillis())));
        this.b.put("transId", UUID.randomUUID().toString());
        this.b.put("apiName", str);
    }

    public void a(long j) {
        this.k = j;
    }

    public void a(long j, long j2, boolean z) {
        this.l = j;
        this.m = j2;
        this.n = z;
    }

    public void c(int i) {
        this.h = i;
    }

    public void h() {
        this.c = System.currentTimeMillis();
    }

    public void i() {
        try {
            if (a()) {
                b bVar = new b();
                bVar.put("result", String.valueOf(this.h));
                bVar.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - this.c));
                bVar.put("scanType", this.i);
                bVar.put("sceneType", this.j);
                if (this.l != 0 && this.m != 0) {
                    if (this.n) {
                        bVar.put("recognizeMode", o);
                        bVar.put("defaultDetectTime", String.valueOf(this.l - this.k));
                        bVar.put("aiDetectTime", String.valueOf(this.m - this.l));
                    } else {
                        bVar.put("recognizeMode", p);
                        bVar.put("defaultDetectTime", String.valueOf(this.l - this.k));
                    }
                    bVar.put("recognizeSuccessTime", String.valueOf(this.m - this.k));
                }
                j3.b().b("60000", bVar);
                j();
            }
        } catch (NullPointerException unused) {
            x3.b("HaLog60000", "nullPoint");
        } catch (Exception unused2) {
            x3.b("HaLog60000", "logEnd Exception");
        }
    }

    private void j() {
        this.h = -1001;
        this.i = e3.d;
        this.j = e3.e;
    }

    public void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null) {
            this.h = hmsScanArr.length;
            for (HmsScan hmsScan : hmsScanArr) {
                this.i = e3.a(hmsScan.scanType);
                this.j = e3.b(hmsScan.scanTypeForm);
            }
        }
    }
}
