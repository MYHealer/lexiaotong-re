package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import com.loopj.android.http.AsyncHttpClient;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.a.a.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.a$a, reason: collision with other inner class name */
    static class RunnableC0877a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6007a;
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        RunnableC0877a(Context context, String str, b bVar) {
            this.f6007a = context;
            this.b = str;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f6007a, this.b, this.c);
        }
    }

    public interface b {
        void onFail();

        void onSuccess();
    }

    private static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        map.put("Content-type", "application/json");
        map.put("Accept-Charset", "UTF-8");
        map.put("Connection", "Keep-Alive");
        map.put("Route-Data", e.a(context));
        return map;
    }

    public static final void a(Context context, String str, b bVar) {
        com.opos.cmn.func.a.a.e eVarA = null;
        try {
            Map<String, String> mapA = a(context);
            mapA.put("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            byte[] bArrA = a(str);
            eVarA = com.opos.cmn.func.a.a.b.a().a(context, new d.a().a(mapA).a(bArrA).a("POST").b(com.opos.cmn.biz.requeststatistic.b.a(context)).a());
            if (eVarA == null || 200 != eVarA.f6077a) {
                if (bVar != null) {
                    bVar.onFail();
                }
            } else if (bVar != null) {
                bVar.onSuccess();
            }
        } catch (Exception unused) {
            if (bVar != null) {
                bVar.onFail();
            }
        } finally {
            if (0 != 0) {
                eVarA.a();
            }
        }
    }

    public static final byte[] a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static final void b(Context context, String str, b bVar) {
        com.opos.cmn.an.j.b.a().execute(new RunnableC0877a(context, str, bVar));
    }
}
