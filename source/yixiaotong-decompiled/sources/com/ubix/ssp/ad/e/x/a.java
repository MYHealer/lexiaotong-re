package com.ubix.ssp.ad.e.x;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f8921a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.x.a$a, reason: collision with other inner class name */
    class RunnableC1106a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.x.d f8922a;

        RunnableC1106a(com.ubix.ssp.ad.e.x.d dVar) {
            this.f8922a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f8922a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8923a;

        b(Object obj) {
            this.f8923a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f8923a);
        }
    }

    public static abstract class c extends a<com.ubix.ssp.ad.e.x.d> {
        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.ubix.ssp.ad.e.x.d c(com.ubix.ssp.ad.e.x.d dVar) {
            return dVar;
        }
    }

    public static abstract class d extends a<String> {
        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public String c(com.ubix.ssp.ad.e.x.d dVar) {
            try {
                return a.a(dVar.f8926a);
            } catch (Exception unused) {
                throw new RuntimeException("failure");
            }
        }
    }

    public static abstract class e extends a<com.ubix.ssp.ad.e.y.a.e> {
        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.ubix.ssp.ad.e.y.a.e c(com.ubix.ssp.ad.e.x.d dVar) {
            try {
                return com.ubix.ssp.ad.e.y.a.e.a(dVar.f);
            } catch (Exception unused) {
                throw new RuntimeException("failure");
            }
        }
    }

    public static abstract class f extends a<com.ubix.ssp.ad.e.y.a.g> {
        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.ubix.ssp.ad.e.y.a.g c(com.ubix.ssp.ad.e.x.d dVar) {
            try {
                return com.ubix.ssp.ad.e.y.a.g.a(dVar.f);
            } catch (Exception unused) {
                throw new RuntimeException("failure");
            }
        }
    }

    public static String a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    inputStream.close();
                    return sb.toString();
                }
                sb.append(line + IOUtils.LINE_SEPARATOR_UNIX);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    void a(com.ubix.ssp.ad.e.x.d dVar) {
        f8921a.post(new RunnableC1106a(dVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(com.ubix.ssp.ad.e.y.a.e eVar) {
        a(eVar);
    }

    public abstract void a(T t);

    public abstract void b(com.ubix.ssp.ad.e.x.d dVar);

    public abstract T c(com.ubix.ssp.ad.e.x.d dVar);

    void d(com.ubix.ssp.ad.e.x.d dVar) {
        f8921a.post(new b(c(dVar)));
    }
}
