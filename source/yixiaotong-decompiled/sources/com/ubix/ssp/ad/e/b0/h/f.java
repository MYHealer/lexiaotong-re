package com.ubix.ssp.ad.e.b0.h;

import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import com.ubix.ssp.ad.e.a0.u;
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
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8782a;
    private final ExecutorService b;
    private final Map<String, g> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final com.ubix.ssp.ad.e.b0.h.c g;
    private final k h;

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.ProxyCacheServerThread");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f8784a;
        private com.ubix.ssp.ad.e.b0.h.u.c d;
        private com.ubix.ssp.ad.e.b0.h.s.a c = new com.ubix.ssp.ad.e.b0.h.s.g(536870912);
        private com.ubix.ssp.ad.e.b0.h.s.c b = new com.ubix.ssp.ad.e.b0.h.s.f();
        private com.ubix.ssp.ad.e.b0.h.t.b e = new com.ubix.ssp.ad.e.b0.h.t.a();

        public b(Context context) {
            this.d = com.ubix.ssp.ad.e.b0.h.u.d.a(context);
            this.f8784a = r.a(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.ubix.ssp.ad.e.b0.h.c b() {
            return new com.ubix.ssp.ad.e.b0.h.c(this.f8784a, this.b, this.c, this.d, this.e);
        }

        public b a(com.ubix.ssp.ad.e.b0.h.s.c cVar) {
            this.b = (com.ubix.ssp.ad.e.b0.h.s.c) l.a(cVar);
            return this;
        }

        public b a(File file) {
            this.f8784a = (File) l.a(file);
            return this;
        }

        public f a() {
            return new f(b(), null);
        }
    }

    private final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Socket f8785a;

        public c(Socket socket) {
            this.f8785a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.d(this.f8785a);
        }
    }

    private final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f8786a;

        public d(CountDownLatch countDownLatch) {
            this.f8786a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8786a.countDown();
            f.this.c();
        }
    }

    public f(Context context) {
        this(new b(context).b());
    }

    private f(com.ubix.ssp.ad.e.b0.h.c cVar) {
        this.f8782a = new Object();
        this.b = Executors.newFixedThreadPool(8, new a());
        this.c = new ConcurrentHashMap();
        this.g = (com.ubix.ssp.ad.e.b0.h.c) l.a(cVar);
        try {
            if (TrafficStats.getThreadStatsTag() == -1) {
                TrafficStats.setThreadStatsTag(1);
            }
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new k("127.0.0.1", localPort);
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* synthetic */ f(com.ubix.ssp.ad.e.b0.h.c cVar, a aVar) {
        this(cVar);
    }

    private String a(String str) {
        return String.format(Locale.US, new String(com.ubix.ssp.ad.e.a0.n.a().a("aHR0cDovLyVzOiVkLyVz")), "127.0.0.1", Integer.valueOf(this.e), o.c(str));
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException unused) {
        }
    }

    private void a(Throwable th) {
    }

    private void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new n("Error closing socket", e));
        }
    }

    private File b(String str) {
        com.ubix.ssp.ad.e.b0.h.c cVar = this.g;
        return new File(cVar.f8780a, cVar.b.a(str));
    }

    private void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
        } catch (IOException e) {
            a(new n("Error closing socket input stream", e));
        }
    }

    private boolean b() {
        return this.h.a(3, 70);
    }

    private g c(String str) {
        g gVar;
        synchronized (this.f8782a) {
            gVar = this.c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.g);
                this.c.put(str, gVar);
            }
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (TrafficStats.getThreadStatsTag() == -1) {
                TrafficStats.setThreadStatsTag(1);
            }
            u.b("waitForRequest " + (!Thread.currentThread().isInterrupted()));
            while (!Thread.currentThread().isInterrupted()) {
                this.b.submit(new c(this.d.accept()));
            }
        } catch (IOException e) {
            a(new n("Error during waiting connection", e));
        }
    }

    private void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Socket socket) {
        try {
            try {
                com.ubix.ssp.ad.e.b0.h.d dVarA = com.ubix.ssp.ad.e.b0.h.d.a(socket.getInputStream());
                String strB = o.b(dVarA.c);
                if (this.h.a(strB)) {
                    this.h.a(socket);
                } else {
                    c(strB).a(dVarA, socket);
                }
            } catch (n e) {
                e = e;
                a(new n("Error processing request", e));
            } catch (RuntimeException e2) {
                e = e2;
                a(new n("Error processing request", e));
            } catch (SocketException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e = e4;
                a(new n("Error processing request", e));
            }
            e(socket);
        } catch (Throwable th) {
            e(socket);
            throw th;
        }
    }

    private void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public String a(String str, boolean z) {
        if (!z || !e(str)) {
            return b() ? a(str) : str;
        }
        File fileB = b(str);
        a(fileB);
        return Uri.fromFile(fileB).toString();
    }

    public ExecutorService a() {
        return this.b;
    }

    public void a(com.ubix.ssp.ad.e.b0.h.b bVar) {
        l.a(bVar);
        synchronized (this.f8782a) {
            Iterator<g> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().b(bVar);
            }
        }
    }

    public void a(com.ubix.ssp.ad.e.b0.h.b bVar, String str) {
        l.a(bVar, str);
        synchronized (this.f8782a) {
            try {
                c(str).a(bVar);
            } catch (n unused) {
            }
        }
    }

    public String d(String str) {
        return a(str, true);
    }

    public boolean e(String str) {
        l.a(str, "Url can't be null!");
        return b(str).exists();
    }
}
