package com.opos.mobad.j.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7043a = new byte[0];
    private static volatile com.opos.videocache.c b;

    public interface a {
        void a(String str);
    }

    private static final class b implements com.opos.videocache.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f7046a;

        public b() {
            HashMap map = new HashMap(1);
            this.f7046a = map;
            map.put("Accept-Encoding", HTTP.IDENTITY_CODING);
        }

        @Override // com.opos.videocache.b.b
        public Map<String, String> a(String str) {
            return this.f7046a;
        }
    }

    public static com.opos.videocache.c a(final Context context) {
        com.opos.videocache.c cVar = b;
        if (cVar == null) {
            synchronized (f7043a) {
                cVar = b;
                if (cVar == null) {
                    com.opos.videocache.c cVarA = new com.opos.videocache.c.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(new com.opos.videocache.a.c() { // from class: com.opos.mobad.j.a.d.1
                        @Override // com.opos.videocache.a.c
                        public String a(String str) {
                            return d.b(context, str);
                        }
                    }).a(FileUtils.ONE_GB).a(50).a(new b()).a();
                    b = cVarA;
                    cVar = cVarA;
                }
            }
        }
        return cVar;
    }

    public static String a(Context context, String str, int i) {
        if (i == 3) {
            return str;
        }
        String strA = (context == null || com.opos.cmn.an.d.a.a(str)) ? "" : a(context).a(str);
        com.opos.cmn.an.f.a.b("VideoProxyUtils", "getProxyUrl=" + strA);
        return strA;
    }

    public static void a(final Context context, final String str, final int i, final a aVar) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.j.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                String strA = d.a(context, str, i);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(strA);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str) {
        String strA = com.opos.cmn.d.d.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
        return TextUtils.isEmpty(strA) ? com.opos.cmn.d.d.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), str) : strA;
    }
}
