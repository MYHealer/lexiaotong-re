package com.yfanads.android.adx.newplayer.videocache;

import android.util.Log;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class Pinger {
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private final String host;
    private final ExecutorService pingExecutor = Executors.newSingleThreadExecutor();
    private final int port;

    /* JADX INFO: renamed from: com.yfanads.android.adx.newplayer.videocache.Pinger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class PingCallable implements Callable<Boolean> {
        private PingCallable() {
        }

        public /* synthetic */ PingCallable(Pinger pinger, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(Pinger.this.pingServer());
        }
    }

    public Pinger(String str, int i) {
        this.host = (String) Preconditions.checkNotNull(str);
        this.port = i;
    }

    private List<Proxy> getDefaultProxies() {
        try {
            return ProxySelector.getDefault().select(new URI(getPingUrl()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    private String getPingUrl() {
        return String.format(Locale.US, "http://%s:%d/%s", this.host, Integer.valueOf(this.port), PING_REQUEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pingServer() {
        HttpUrlSource httpUrlSource = new HttpUrlSource(getPingUrl());
        try {
            byte[] bytes = PING_RESPONSE.getBytes();
            httpUrlSource.open(0L);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.read(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            Log.i("Pinger", "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (ProxyCacheException e) {
            Log.e("Pinger", "Error reading ping response", e);
            return false;
        } finally {
            httpUrlSource.close();
        }
    }

    public boolean isPingRequest(String str) {
        return PING_REQUEST.equals(str);
    }

    public boolean ping(int i, int i2) {
        Preconditions.checkArgument(i >= 1);
        Preconditions.checkArgument(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.pingExecutor.submit(new PingCallable(this, null)).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                Log.e("Pinger", "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                Log.e("Pinger", "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                Log.w("Pinger", "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
        }
        String str = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), getDefaultProxies());
        Log.e("Pinger", str, new ProxyCacheException(str));
        return false;
    }

    public void responseToPing(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(PING_RESPONSE.getBytes());
    }
}
