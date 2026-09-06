package com.hihonor.adsdk.common.video.g.j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.f.a0;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    private static final String hnadsi = "HttpProxyCacheServer";
    private final Object hnadsa;
    private final ExecutorService hnadsb;
    private final Map<String, f> hnadsc;
    private final ServerSocket hnadsd;
    private final int hnadse;
    private final Thread hnadsf;
    private final com.hihonor.adsdk.common.video.g.c hnadsg;
    private final h hnadsh;

    static /* synthetic */ class a {
    }

    private final class c implements Runnable {
        private final Socket hnadsd;

        public c(Socket socket) {
            this.hnadsd = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.hnadsd(this.hnadsd);
        }
    }

    private final class d implements Runnable {
        private final CountDownLatch hnadsd;

        public d(CountDownLatch countDownLatch) {
            this.hnadsd = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.hnadsd.countDown();
            e.this.hnadse();
        }
    }

    /* synthetic */ e(com.hihonor.adsdk.common.video.g.c cVar, a aVar) throws com.hihonor.adsdk.common.video.g.f {
        this(cVar);
    }

    private void hnadsb(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException e) {
            hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "Releasing input stream… Socket is closed by client.:" + e.getMessage()));
        } catch (IOException e2) {
            hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "closeSocketInput Error closing socket input stream:" + e2.getMessage()));
        }
    }

    private f hnadsc(String str) {
        f fVar;
        synchronized (this.hnadsa) {
            fVar = this.hnadsc.get(str);
            if (fVar == null) {
                fVar = new f(str, this.hnadsg);
                this.hnadsc.put(str, fVar);
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsd(Socket socket) {
        try {
            com.hihonor.adsdk.common.video.g.j.c cVarHnadsa = com.hihonor.adsdk.common.video.g.j.c.hnadsa(socket.getInputStream());
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, (Object) ("processSocket--->Request to cache proxy:" + cVarHnadsa));
            String strHnadsb = com.hihonor.adsdk.common.video.g.l.a.hnadsb(cVarHnadsa.hnadsa);
            if (this.hnadsh.hnadsa(strHnadsb)) {
                this.hnadsh.hnadsa(socket);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, (Object) "processSocket--->processRequest");
                String strHnadsa = com.hihonor.adsdk.common.video.g.l.c.hnadsa(strHnadsb);
                if (TextUtils.isEmpty(strHnadsa)) {
                    com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, (Object) "url is invalid");
                    return;
                }
                hnadsc(strHnadsa).hnadsa(cVarHnadsa, socket);
            }
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            hnadsa(e);
        } catch (IOException e2) {
            hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "processSocket io exception:" + e2.getMessage()));
        } finally {
            hnadse(socket);
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, (Object) ("processSocket--->Opened connections: " + hnadsa()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadse() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.hnadsd.accept();
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, (Object) ("Accept new socket====================================" + socketAccept));
                this.hnadsb.submit(new c(socketAccept));
            } catch (IOException e) {
                hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "waitForRequest Error during waiting connection," + e.getMessage()));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsf(String str) {
        try {
            hnadsc(str).hnadse();
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            hnadsa(e);
        }
    }

    public void hnadsg(final String str) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "#preCache#Video preCache fail! Cause by invalid url", new Object[0]);
        } else {
            a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.common.video.g.j.e$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsf(str);
                }
            });
        }
    }

    public static final class b {
        private static final long hnadse = 536870912;
        private File hnadsa;
        private String hnadsd;
        private com.hihonor.adsdk.common.video.g.i.a hnadsc = new com.hihonor.adsdk.common.video.g.i.i(hnadse);
        private com.hihonor.adsdk.common.video.g.i.c hnadsb = new com.hihonor.adsdk.common.video.g.i.f();

        public b(Context context) {
            this.hnadsd = context.getResources().getString(R.string.proxy_host);
            this.hnadsa = com.hihonor.adsdk.common.video.g.l.b.hnadsb(context);
        }

        private com.hihonor.adsdk.common.video.g.c hnadsb() {
            return new com.hihonor.adsdk.common.video.g.c(this.hnadsa, this.hnadsb, this.hnadsc, this.hnadsd);
        }

        public b hnadsa(com.hihonor.adsdk.common.video.g.i.a aVar) {
            this.hnadsc = aVar;
            return this;
        }

        public b hnadsa(com.hihonor.adsdk.common.video.g.i.c cVar) {
            this.hnadsb = cVar;
            return this;
        }

        public b hnadsa(File file) {
            this.hnadsa = file;
            return this;
        }

        public b hnadsa(long j) {
            this.hnadsc = new com.hihonor.adsdk.common.video.g.i.i(j);
            return this;
        }

        public b hnadsa(int i) {
            this.hnadsc = new com.hihonor.adsdk.common.video.g.i.h(i);
            return this;
        }

        public b hnadsa(int i, long j) {
            this.hnadsc = new com.hihonor.adsdk.common.video.g.i.g(i, j);
            return this;
        }

        public e hnadsa() {
            try {
                return new e(hnadsb(), null);
            } catch (com.hihonor.adsdk.common.video.g.f e) {
                com.hihonor.adsdk.common.b.b.hnadsb(e.hnadsi, "build, ProxyCacheException: " + e.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    private e(com.hihonor.adsdk.common.video.g.c cVar) throws com.hihonor.adsdk.common.video.g.f {
        this.hnadsa = new Object();
        this.hnadsb = Executors.newFixedThreadPool(8);
        this.hnadsc = new ConcurrentHashMap();
        this.hnadsg = cVar;
        try {
            InetAddress byName = InetAddress.getByName(cVar.hnadsd);
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsi, "proxy host url=%s", cVar.hnadsd);
            try {
                ServerSocket serverSocket = new ServerSocket(0, 8, byName);
                this.hnadsd = serverSocket;
                int localPort = serverSocket.getLocalPort();
                this.hnadse = localPort;
                g.hnadsa(cVar.hnadsd, localPort);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                Thread thread = new Thread(new d(countDownLatch));
                this.hnadsf = thread;
                thread.start();
                try {
                    countDownLatch.await();
                    this.hnadsh = new h(cVar.hnadsd, localPort);
                    try {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "Proxy cache server started. Is it alive? " + hnadsb(), new Object[0]);
                    } catch (com.hihonor.adsdk.common.video.g.f e) {
                        this.hnadsb.shutdown();
                        hnadsa(e);
                        throw e;
                    }
                } catch (InterruptedException e2) {
                    this.hnadsb.shutdown();
                    com.hihonor.adsdk.common.video.g.f fVar = new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsc, "count down wait interruptedException," + e2.getMessage());
                    hnadsa(fVar);
                    throw fVar;
                }
            } catch (IOException e3) {
                this.hnadsb.shutdown();
                com.hihonor.adsdk.common.video.g.f fVar2 = new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "new socket io exception," + e3.getMessage());
                hnadsa(fVar2);
                throw fVar2;
            }
        } catch (UnknownHostException e4) {
            this.hnadsb.shutdown();
            com.hihonor.adsdk.common.video.g.f fVar3 = new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "InetAddress get by name unKnown host," + e4.getMessage());
            hnadsa(fVar3);
            throw fVar3;
        }
    }

    private void hnadsa(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            com.hihonor.adsdk.common.video.g.f fVar = new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "closeSocket Error closing socket:" + e.getMessage());
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "closeSocket Error closing socket: " + fVar.hnadsa() + "message: " + fVar.getMessage(), new Object[0]);
        }
    }

    private int hnadsa() {
        int iHnadsb;
        synchronized (this.hnadsa) {
            Iterator<f> it = this.hnadsc.values().iterator();
            iHnadsb = 0;
            while (it.hasNext()) {
                iHnadsb += it.next().hnadsb();
            }
        }
        return iHnadsb;
    }

    private void hnadsc(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "Failed to close socket on proxy side: {}. It seems client have already closed connection:" + e.getMessage()));
        }
    }

    private File hnadsb(String str) {
        com.hihonor.adsdk.common.video.g.c cVar = this.hnadsg;
        File file = new File(cVar.hnadsa, cVar.hnadsb.hnadsa(str));
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "HttpProxyCacheServer-getCacheFile,cacheFileUrl: " + Uri.fromFile(file).toString(), new Object[0]);
        return file;
    }

    private void hnadse(Socket socket) {
        hnadsb(socket);
        hnadsc(socket);
        hnadsa(socket);
    }

    private String hnadsa(String str, boolean z) throws com.hihonor.adsdk.common.video.g.f {
        if (z && hnadse(str)) {
            File fileHnadsb = hnadsb(str);
            hnadsa(fileHnadsb);
            return Uri.fromFile(fileHnadsb).toString();
        }
        boolean zHnadsb = hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "getProxyUrl,socketAlive: " + zHnadsb, new Object[0]);
        return zHnadsb ? hnadsa(str) : str;
    }

    public void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "Shutdown proxy server", new Object[0]);
        hnadsd();
        this.hnadsf.interrupt();
        try {
            if (this.hnadsd.isClosed()) {
                return;
            }
            this.hnadsd.close();
        } catch (IOException e) {
            hnadsa(new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "shutdown Error shutting down proxy server:" + e.getMessage()));
        }
    }

    public boolean hnadse(String str) {
        return hnadsb(str).exists();
    }

    private boolean hnadsb() throws com.hihonor.adsdk.common.video.g.f {
        return this.hnadsh.hnadsa(3, 70);
    }

    public void hnadsb(com.hihonor.adsdk.common.video.g.j.b bVar, String str) {
        synchronized (this.hnadsa) {
            hnadsc(str).hnadsb(bVar);
        }
    }

    private void hnadsa(File file) {
        try {
            this.hnadsg.hnadsc.hnadsa(file);
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            hnadsa(e);
        }
    }

    private String hnadsa(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", this.hnadsg.hnadsd, Integer.valueOf(this.hnadse), com.hihonor.adsdk.common.video.g.l.a.hnadsc(str));
    }

    public void hnadsa(com.hihonor.adsdk.common.video.g.j.b bVar, String str) {
        synchronized (this.hnadsa) {
            hnadsc(str).hnadsa(bVar);
        }
    }

    public void hnadsa(com.hihonor.adsdk.common.video.g.j.b bVar) {
        synchronized (this.hnadsa) {
            Iterator<f> it = this.hnadsc.values().iterator();
            while (it.hasNext()) {
                it.next().hnadsb(bVar);
            }
        }
    }

    public void hnadsa(com.hihonor.adsdk.common.video.g.f fVar) {
        if (fVar != null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "exception,code: " + fVar.hnadsa() + "message: " + fVar.getMessage(), new Object[0]);
        }
    }

    public String hnadsd(String str) {
        try {
            return hnadsa(str, true);
        } catch (com.hihonor.adsdk.common.video.g.f e) {
            hnadsa(e);
            return str;
        }
    }

    private void hnadsd() {
        synchronized (this.hnadsa) {
            Iterator<f> it = this.hnadsc.values().iterator();
            while (it.hasNext()) {
                it.next().hnadsd();
            }
            this.hnadsc.clear();
        }
    }
}
