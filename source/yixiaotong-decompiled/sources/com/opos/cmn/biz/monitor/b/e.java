package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5997a;
    private String b;
    private int c;
    private int d = 0;
    private com.opos.cmn.biz.monitor.b.a e;
    private a f;

    public interface a {
        void a();

        void a(byte[] bArr);
    }

    public e(Context context, String str, int i, com.opos.cmn.biz.monitor.b.a aVar, a aVar2) {
        this.f5997a = context;
        this.b = str;
        this.c = i;
        this.e = aVar;
        this.f = aVar2;
    }

    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request success but data empty");
            return false;
        }
        try {
            int i = new JSONObject(new String(bArr)).getInt("code");
            if (i == 0) {
                return true;
            }
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request success but ret:" + i);
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request but parse fail", e);
            return false;
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NetRequestExecutor", "send request:" + this.b);
        a(this.b);
    }

    protected void a(int i, byte[] bArr, Map<String, String> map) {
        a aVar;
        if (200 == i) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(bArr);
                return;
            }
            return;
        }
        if (302 == i) {
            String str = map.get("location");
            if (TextUtils.isEmpty(str)) {
                str = map.get("Location");
            }
            if (this.d < this.c && !TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "retry with url:" + str);
                this.d++;
                a(str);
                return;
            } else {
                aVar = this.f;
                if (aVar == null) {
                    return;
                }
            }
        } else {
            aVar = this.f;
            if (aVar == null) {
                return;
            }
        }
        aVar.a();
    }

    protected void a(final String str) {
        HashMap map = new HashMap();
        map.put("Accept", "application/json");
        this.e.a(this.f5997a, new b.a(str).a(map).a(), new com.opos.cmn.biz.monitor.b.a.InterfaceC0874a() { // from class: com.opos.cmn.biz.monitor.b.e.1
            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0874a
            public void a() {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request fail with url:" + str);
                if (e.this.f != null) {
                    e.this.f.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0874a
            public void a(c cVar) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "result code:" + cVar.a());
                e.this.a(cVar.a(), cVar.c(), cVar.b());
            }
        });
    }
}
