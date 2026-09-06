package com.ubix.ssp.ad.e.a0.e0;

import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.g;
import com.ubix.ssp.ad.e.x.d;
import com.ubix.ssp.open.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f8685a;
    private String c;
    private c b = null;
    private final AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.e0.a$a, reason: collision with other inner class name */
    class C1086a implements g.b {
        C1086a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            if (a.this.d.getAndSet(true) || a.this.b == null) {
                return;
            }
            a.this.b.a(com.ubix.ssp.ad.e.a0.a0.a.a(1, "奖励下发超时"), "timeout", "");
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    class b extends com.ubix.ssp.ad.e.x.a.c {
        b() {
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void b(d dVar) {
            String string;
            StringBuilder sbAppend;
            StringBuilder sbAppend2;
            String strA;
            if (!a.this.d.getAndSet(true) && a.this.b != null) {
                if (dVar != null) {
                    try {
                        if (dVar.e != null) {
                            sbAppend2 = new StringBuilder().append("exception:");
                            strA = dVar.e.toString();
                        } else {
                            if (dVar.b != null) {
                                sbAppend2 = new StringBuilder().append("error:");
                                strA = com.ubix.ssp.ad.e.x.a.a(dVar.b);
                            } else {
                                sbAppend = new StringBuilder().append("responseCode:").append(dVar.c);
                            }
                            string = sbAppend.toString();
                        }
                        sbAppend = sbAppend2.append(strA);
                        string = sbAppend.toString();
                    } catch (Throwable unused) {
                        string = "unknown";
                    }
                } else {
                    string = "response is null";
                }
                a.this.b.a(com.ubix.ssp.ad.e.a0.a0.a.a(2, "奖励返回异常"), string, "");
            }
            g gVar = a.this.f8685a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(d dVar) {
            g gVar;
            try {
                JSONObject jSONObject = new JSONObject(new String(dVar.f));
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("extra");
                if (iOptInt == 200) {
                    if (!a.this.d.getAndSet(true) && a.this.b != null) {
                        a.this.b.a(strOptString);
                    }
                } else if (!a.this.d.getAndSet(true) && a.this.b != null) {
                    a.this.b.a(com.ubix.ssp.ad.e.a0.a0.a.a(3, "奖励无效"), iOptInt + "", strOptString);
                }
                gVar = a.this.f8685a;
                if (gVar == null) {
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    if (!a.this.d.getAndSet(true) && a.this.b != null) {
                        a.this.b.a(com.ubix.ssp.ad.e.a0.a0.a.a(2, "奖励返回异常"), th.getMessage(), "");
                    }
                    gVar = a.this.f8685a;
                    if (gVar == null) {
                        return;
                    }
                } catch (Throwable th2) {
                    g gVar2 = a.this.f8685a;
                    if (gVar2 != null) {
                        gVar2.a();
                    }
                    throw th2;
                }
            }
            gVar.a();
        }
    }

    public interface c {
        void a(AdError adError, String str, String str2);

        void a(String str);
    }

    public a(String str, int i) {
        this.f8685a = null;
        this.c = "";
        this.f8685a = new g(i);
        this.c = str;
    }

    public void a() {
        if (!TextUtils.isEmpty(this.c)) {
            this.f8685a.a(new C1086a());
            this.f8685a.e();
            com.ubix.ssp.ad.e.x.g.b().b(this.c, new b());
        } else {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(com.ubix.ssp.ad.e.a0.a0.a.a(2, "奖励返回异常"), "url is null", "");
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }
}
