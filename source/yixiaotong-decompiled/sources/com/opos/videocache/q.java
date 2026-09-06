package com.opos.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8444a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    /* JADX INFO: renamed from: com.opos.videocache.q$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements Callable<Boolean> {
        private a() {
        }

        /* synthetic */ a(q qVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(q.this.b());
        }
    }

    q(String str, int i) {
        this.b = (String) f.a(str);
        this.c = i;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        d dVar = new d(c());
        try {
            byte[] bytes = "ping ok".getBytes();
            dVar.a(0L);
            byte[] bArr = new byte[bytes.length];
            dVar.a(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            com.opos.cmn.an.f.a.a("Pinger", "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (g e) {
            com.opos.cmn.an.f.a.d("Pinger", "Error reading ping response", e);
            return false;
        } finally {
            dVar.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), "ping");
    }

    void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    boolean a(int i, int i2) {
        f.a(i >= 1);
        f.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f8444a.submit(new a(this, null)).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                com.opos.cmn.an.f.a.c("Pinger", "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
        }
        String str = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        com.opos.cmn.an.f.a.d("Pinger", str, new g(str));
        return false;
    }

    boolean a(String str) {
        return "ping".equals(str);
    }
}
