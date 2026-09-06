package com.opos.mobad.service.g;

import android.content.Context;
import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.a.a.d;
import java.io.IOException;
import java.util.HashMap;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    public interface a<T> {
        T b(BufferedSource bufferedSource) throws IOException;
    }

    /* JADX INFO: renamed from: com.opos.mobad.service.g.b$b, reason: collision with other inner class name */
    public static final class C0996b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7380a;
        public final String b;
        public final T c;

        public C0996b(int i, T t) {
            this.f7380a = i;
            this.b = null;
            this.c = t;
        }

        public C0996b(int i, String str) {
            this.f7380a = i;
            this.b = str;
            this.c = null;
        }
    }

    public static final <T> C0996b a(Context context, String str, byte[] bArr, a<T> aVar) {
        String strA;
        T tB = (T) null;
        if (context == null || TextUtils.isEmpty(str)) {
            return new C0996b(-1, (String) null);
        }
        try {
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            map.put("Accept", "application/x-protobuf");
            map.put("Route-Data", e.a(context));
            if (bArr != null && bArr.length >= 1024) {
                com.opos.cmn.an.f.a.b("data", "data.length >= 1024 ,need gzip compress.");
                bArr = com.opos.cmn.b.c.a.a(bArr);
                map.put("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
            d.a aVarA = new d.a().a("POST").b(str).a(map);
            if (bArr != null) {
                aVarA.a(bArr);
            }
            com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(context, aVarA.a());
            if (eVarA == null) {
                if (eVarA != null) {
                    eVarA.a();
                }
                return new C0996b(-1, "unknown error.");
            }
            try {
                boolean zEqualsIgnoreCase = false;
                com.opos.cmn.an.f.a.b("data", "fetchAd netResponse=", eVarA);
                if (200 != eVarA.f6077a) {
                    C0996b c0996b = new C0996b(eVarA.f6077a, eVarA.b);
                    if (eVarA != null) {
                        eVarA.a();
                    }
                    return c0996b;
                }
                if (aVar != null) {
                    com.opos.cmn.func.a.a.a aVar2 = eVarA.f;
                    if (aVar2 != null && (strA = aVar2.a("Content-Encoding")) != null) {
                        zEqualsIgnoreCase = AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(strA);
                    }
                    Source source = Okio.source(eVarA.c);
                    if (zEqualsIgnoreCase) {
                        source = new GzipSource(source);
                    }
                    BufferedSource bufferedSourceBuffer = Okio.buffer(source);
                    tB = aVar.b(bufferedSourceBuffer);
                    source.close();
                    bufferedSourceBuffer.close();
                }
                C0996b c0996b2 = new C0996b(eVarA.f6077a, tB);
                if (eVarA != null) {
                    eVarA.a();
                }
                return c0996b2;
            } catch (Throwable th) {
                tB = (T) eVarA;
                th = th;
                try {
                    com.opos.cmn.an.f.a.a("data", "", th);
                    return new C0996b(-1, "unknown error.");
                } finally {
                    if (tB != null) {
                        tB.a();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
