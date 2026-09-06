package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.az;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class g {
    private final c bad;
    private final AtomicInteger bah = new AtomicInteger(0);
    private volatile e bai;
    private final List<b> baj;
    private final b bak;
    private final String url;

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.baj = copyOnWriteArrayList;
        this.url = az.hY(str);
        this.bad = (c) az.checkNotNull(cVar);
        this.bak = new a(str, copyOnWriteArrayList);
    }

    public final void a(d dVar, Socket socket) {
        Pa();
        try {
            this.bah.incrementAndGet();
            this.bai.a(dVar, socket);
        } finally {
            Pb();
        }
    }

    private synchronized void Pa() {
        if (this.bad.aZP == 1 && isOkHttpSupported()) {
            this.bai = this.bai == null ? Pd() : this.bai;
        } else {
            this.bai = this.bai == null ? Pc() : this.bai;
        }
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void Pb() {
        if (this.bah.decrementAndGet() <= 0) {
            this.bai.shutdown();
            this.bai = null;
        }
    }

    public final void shutdown() {
        this.baj.clear();
        e eVar = this.bai;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.bai = null;
        this.bah.set(0);
    }

    public final int OX() {
        return this.bah.get();
    }

    private e Pc() {
        e eVar = new e(new h(this.url, this.bad.aZN, this.bad.aZO), new com.kwad.sdk.core.videocache.a.b(this.bad.fu(this.url), this.bad.aZM));
        eVar.a(this.bak);
        return eVar;
    }

    private e Pd() {
        e eVar = new e(new j(this.url, this.bad.aZN, this.bad.aZO), new com.kwad.sdk.core.videocache.a.b(this.bad.fu(this.url), this.bad.aZM));
        eVar.a(this.bak);
        return eVar;
    }

    static final class a extends Handler implements b {
        private final List<b> baj;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.baj = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.baj.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }
}
