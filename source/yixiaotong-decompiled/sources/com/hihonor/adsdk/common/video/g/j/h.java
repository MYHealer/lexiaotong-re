package com.hihonor.adsdk.common.video.g.j;

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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsd = "Pinger";
    private static final String hnadse = "ping";
    private static final String hnadsf = "ping ok";
    private final ExecutorService hnadsa = Executors.newSingleThreadExecutor();
    private final String hnadsb;
    private final int hnadsc;

    static /* synthetic */ class a {
    }

    private class b implements Callable<Boolean> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(h.this.hnadsc());
        }

        /* synthetic */ b(h hVar, a aVar) {
            this();
        }
    }

    h(String str, int i) {
        this.hnadsb = str;
        this.hnadsc = i;
    }

    private String hnadsb() {
        return String.format(Locale.US, "http://%s:%d/%s", this.hnadsb, Integer.valueOf(this.hnadsc), hnadse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hnadsc() throws com.hihonor.adsdk.common.video.g.f {
        com.hihonor.adsdk.common.video.g.k.a aVar = new com.hihonor.adsdk.common.video.g.k.a(hnadsb());
        try {
            byte[] bytes = hnadsf.getBytes();
            aVar.hnadsa(0L);
            byte[] bArr = new byte[bytes.length];
            aVar.hnadsa(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals, new Object[0]);
            return zEquals;
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "Error reading ping response", e);
            return false;
        } finally {
            aVar.hnadsa();
        }
    }

    boolean hnadsa(int i, int i2) throws com.hihonor.adsdk.common.video.g.f {
        if (i < 1) {
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "ping maxAttempts is inLegal");
        }
        if (i2 <= 0) {
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "ping startTimeout is inLegal");
        }
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.hnadsa.submit(new b(this, null)).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ", new Object[0]);
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at report at issues 134.Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), hnadsa()), new Object[0]);
        return false;
    }

    private List<Proxy> hnadsa() {
        try {
            return ProxySelector.getDefault().select(new URI(hnadsb()));
        } catch (URISyntaxException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "getDefaultProxies, URISyntaxException: " + e.getMessage(), new Object[0]);
            throw new IllegalStateException(e);
        }
    }

    boolean hnadsa(String str) {
        return hnadse.equals(str);
    }

    void hnadsa(Socket socket) throws com.hihonor.adsdk.common.video.g.f {
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
            outputStream.write(hnadsf.getBytes());
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "responseToPing, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "responseToPing: " + e.getMessage());
        }
    }
}
