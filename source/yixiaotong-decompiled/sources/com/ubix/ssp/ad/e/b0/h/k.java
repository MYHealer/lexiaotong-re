package com.ubix.ssp.ad.e.b0.h;

import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.u;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8791a;
    private final String b;
    private final int c;
    private final String d;

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.PingThread");
        }
    }

    private class b implements Callable<Boolean> {
        private b() {
        }

        /* synthetic */ b(k kVar, a aVar) {
            this();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(k.this.c());
        }
    }

    k(String str) {
        this.f8791a = Executors.newSingleThreadExecutor(new a());
        this.d = str;
        this.b = null;
        this.c = 0;
    }

    k(String str, int i) {
        this.f8791a = Executors.newSingleThreadExecutor(new a());
        this.b = (String) l.a(str);
        this.c = i;
        this.d = null;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(b()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    private String b() {
        return !TextUtils.isEmpty(this.b) ? String.format(Locale.US, new String(com.ubix.ssp.ad.e.a0.n.a().a("aHR0cDovLyVzOiVkLyVz")), this.b, Integer.valueOf(this.c), "ping") : this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        h hVar = new h(b());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                hVar.a(0L);
                if (!TextUtils.isEmpty(this.b) && this.c != 0) {
                    byte[] bArr = new byte[bytes.length];
                    hVar.a(bArr);
                    boolean zEquals = Arrays.equals(bytes, bArr);
                    u.b("Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
                    return zEquals;
                }
                if (hVar.a() == -2147483648L || hVar.a() <= 0) {
                    return false;
                }
                hVar.close();
                return true;
            } catch (n e) {
                u.d("Error reading ping response", e.getMessage());
                return false;
            }
        } finally {
            hVar.close();
        }
    }

    void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    boolean a(int i, int i2) {
        l.a(i >= 1);
        l.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f8791a.submit(new b(this, null)).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                u.d("Error pinging server due to unexpected error", e.getMessage());
            } catch (ExecutionException e2) {
                e = e2;
                u.d("Error pinging server due to unexpected error", e.getMessage());
            } catch (TimeoutException unused) {
                u.d("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
        }
        String str = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). ", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        u.b(str, new n(str).getMessage());
        return false;
    }

    boolean a(String str) {
        return "ping".equals(str);
    }
}
