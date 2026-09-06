package com.ubix.ssp.ad.e.b0.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ubix.ssp.ad.e.a0.u;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8787a = new AtomicInteger(0);
    private final String b;
    private volatile e c;
    private final List<b> d;
    private final b e;
    private final c f;

    private static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8788a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f8788a = str;
            this.b = list;
        }

        @Override // com.ubix.ssp.ad.e.b0.h.b
        public void a(File file, String str, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f8788a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) l.a(str);
        this.f = (c) l.a(cVar);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void a() {
        if (this.f8787a.decrementAndGet() <= 0) {
            this.c.g();
            this.c = null;
        }
    }

    private e b() {
        String str = this.b;
        c cVar = this.f;
        e eVar = new e(new h(str, cVar.d, cVar.e), new com.ubix.ssp.ad.e.b0.h.s.b(this.f.a(this.b), this.f.c));
        eVar.a(this.e);
        return eVar;
    }

    private synchronized void c() {
        this.c = this.c == null ? b() : this.c;
    }

    public void a(b bVar) {
        this.d.add(bVar);
        u.b("add onCacheAvailable" + this.d);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f8787a.incrementAndGet();
            this.c.a(dVar, socket);
        } finally {
            a();
        }
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }
}
