package com.opos.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8431a;
    private final ExecutorService b;
    private final Map<String, o> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final l g;
    private final q h;

    /* JADX INFO: renamed from: com.opos.videocache.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f8432a;
        private com.opos.videocache.c.b d;
        private com.opos.videocache.a.a c = new com.opos.videocache.a.g(536870912);
        private com.opos.videocache.a.c b = new com.opos.videocache.a.e();
        private com.opos.videocache.b.b e = new com.opos.videocache.b.a();

        public a(Context context) {
            this.d = com.opos.videocache.c.c.a(context);
        }

        private l b() {
            return this.f8432a == null ? new k(this.b, this.c, this.d, this.e) : new l(this.f8432a, this.b, this.c, this.d, this.e);
        }

        public a a(int i) {
            this.c = new com.opos.videocache.a.f(i);
            return this;
        }

        public a a(long j) {
            this.c = new com.opos.videocache.a.g(j);
            return this;
        }

        public a a(com.opos.videocache.a.c cVar) {
            this.b = (com.opos.videocache.a.c) f.a(cVar);
            return this;
        }

        public a a(com.opos.videocache.b.b bVar) {
            this.e = (com.opos.videocache.b.b) f.a(bVar);
            return this;
        }

        public c a() {
            return new c(b(), null);
        }
    }

    private final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.b);
        }
    }

    /* JADX INFO: renamed from: com.opos.videocache.c$c, reason: collision with other inner class name */
    private final class RunnableC1046c implements Runnable {
        private final CountDownLatch b;

        public RunnableC1046c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.countDown();
            c.this.b();
        }
    }

    private c(l lVar) {
        this.f8431a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (l) f.a(lVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            p.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC1046c(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new q("127.0.0.1", localPort);
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* synthetic */ c(l lVar, AnonymousClass1 anonymousClass1) {
        this(lVar);
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException e) {
            com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "Error touching file " + file, e);
        }
    }

    private void a(Throwable th) {
        com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        StringBuilder sb;
        try {
            try {
                m mVarA = m.a(socket.getInputStream());
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Request to cache proxy:" + mVarA);
                String strC = h.c(mVarA.f8439a);
                if (this.h.a(strC)) {
                    this.h.a(socket);
                } else {
                    e(strC).a(mVarA, socket);
                }
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (g e) {
                e = e;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException unused) {
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e2) {
                e = e2;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", sb.append(c()).toString());
        } catch (Throwable th) {
            b(socket);
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Opened connections: " + c());
            throw th;
        }
    }

    private boolean a() {
        return this.h.a(3, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.d.accept();
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Accept new socket " + socketAccept);
                this.b.submit(new b(socketAccept));
            } catch (IOException e) {
                a(new g("Error during waiting connection", e));
                return;
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private int c() {
        int iA;
        synchronized (this.f8431a) {
            Iterator<o> it = this.c.values().iterator();
            iA = 0;
            while (it.hasNext()) {
                iA += it.next().a();
            }
        }
        return iA;
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), h.b(str));
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            a(new g("Error closing socket input stream", e));
        }
    }

    private File d(String str) {
        return this.g.a(str);
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.", (Throwable) e);
        }
    }

    private o e(String str) {
        o oVar;
        synchronized (this.f8431a) {
            oVar = this.c.get(str);
            if (oVar == null) {
                oVar = new o(str, this.g);
                this.c.put(str, oVar);
            }
        }
        return oVar;
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new g("Error closing socket", e));
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (!z || !b(str)) {
            return a() ? c(str) : str;
        }
        File fileD = d(str);
        a(fileD);
        return Uri.fromFile(fileD).toString();
    }

    public boolean b(String str) {
        f.a(str, "Url can't be null!");
        return d(str).exists();
    }
}
