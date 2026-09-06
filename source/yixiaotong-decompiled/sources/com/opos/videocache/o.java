package com.opos.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8441a = new AtomicInteger(0);
    private final String b;
    private volatile n c;
    private final List<b> d;
    private final b e;
    private final l f;

    private static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8442a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f8442a = str;
            this.b = list;
        }

        @Override // com.opos.videocache.b
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
                it.next().a((File) message.obj, this.f8442a, message.arg1);
            }
        }
    }

    public o(String str, l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) f.a(str);
        this.f = (l) f.a(lVar);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void b() {
        this.c = this.c == null ? d() : this.c;
    }

    private synchronized void c() {
        if (this.f8441a.decrementAndGet() <= 0) {
            this.c.a();
            this.c = null;
        }
    }

    private n d() {
        n nVar = new n(new d(this.b, this.f.d, this.f.e), new com.opos.videocache.a.b(this.f.a(this.b), this.f.c));
        nVar.a(this.e);
        return nVar;
    }

    public int a() {
        return this.f8441a.get();
    }

    public void a(m mVar, Socket socket) {
        b();
        try {
            this.f8441a.incrementAndGet();
            this.c.a(mVar, socket);
        } finally {
            c();
        }
    }
}
