package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.by;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static Handler bgW = new Handler(Looper.getMainLooper());
    static int bhg = 80;
    static int port = 80;

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList<C0758b> linkedList = new LinkedList();
            for (int i = 0; i < cVar.Rz(); i++) {
                C0758b c0758b = new C0758b(str);
                c0758b.bhq = j + j2;
                linkedList.add(c0758b);
                try {
                    aVar.a(c0758b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    boolean z = true;
                    float f = 0.0f;
                    for (C0758b c0758b2 : linkedList) {
                        c0758b2.Ry();
                        z &= c0758b2.success;
                        cVar.cb(z);
                        f += c0758b2.bhp;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.r(f / linkedList.size());
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    static class C0758b {
        InetSocketAddress bhm;
        SocketChannel bhn;
        Throwable bho;
        private float bhp;
        long bhq;
        long bhr;
        long bhs = 0;
        boolean bht = false;
        private boolean success;

        C0758b(String str) {
            try {
                this.bhm = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.bho = th;
            }
        }

        final void Ry() {
            String string;
            if (this.bhs != 0) {
                string = Long.toString(this.bhs - this.bhr) + "ms";
                this.bhp = this.bhs - this.bhr;
                this.success = true;
            } else {
                Throwable th = this.bho;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.bhm + " : " + string);
            this.bht = true;
        }
    }

    static class a extends Thread {
        LinkedList bhi = new LinkedList();
        volatile boolean bhj = false;
        Selector bhh = Selector.open();

        a() {
            setName("Connector");
        }

        final void a(C0758b c0758b) {
            final SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
                try {
                    socketChannelOpen.configureBlocking(false);
                    boolean zConnect = socketChannelOpen.connect(c0758b.bhm);
                    c0758b.bhn = socketChannelOpen;
                    c0758b.bhr = SystemClock.elapsedRealtime();
                    if (zConnect) {
                        c0758b.bhs = c0758b.bhr;
                        by.c(socketChannelOpen);
                    } else {
                        synchronized (this.bhi) {
                            this.bhi.add(c0758b);
                        }
                        Selector selector = this.bhh;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    try {
                        b.bgW.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                by.c(socketChannelOpen);
                            }
                        }, c0758b.bhq);
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        by.c(socketChannelOpen);
                        c0758b.bho = th;
                    } finally {
                        try {
                            b.bgW.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    by.c(socketChannelOpen);
                                }
                            }, c0758b.bhq);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannelOpen = null;
            }
        }

        private void Rw() {
            synchronized (this.bhi) {
                while (this.bhi.size() > 0) {
                    C0758b c0758b = (C0758b) this.bhi.removeFirst();
                    try {
                        c0758b.bhn.register(this.bhh, 8, c0758b);
                    } catch (Throwable th) {
                        c0758b.bhn.close();
                        c0758b.bho = th;
                    }
                }
            }
        }

        private void Rx() {
            Iterator<SelectionKey> it = this.bhh.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0758b c0758b = (C0758b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0758b.bhs = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    by.c(socketChannel);
                    c0758b.bho = th;
                }
            }
        }

        final void shutdown() {
            this.bhj = true;
            Selector selector = this.bhh;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.bhh.select() > 0) {
                        Rx();
                    }
                    Rw();
                    if (this.bhj) {
                        Selector selector = this.bhh;
                        if (selector != null) {
                            try {
                                selector.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    continue;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
