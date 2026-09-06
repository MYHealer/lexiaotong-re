package com.hihonor.adsdk.common.video.g.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    private static final String hnadsg = "HttpProxyCacheServerClients";
    private static final int hnadsh = 16;
    private final AtomicInteger hnadsa = new AtomicInteger(0);
    private final String hnadsb;
    private volatile d hnadsc;
    private final List<b> hnadsd;
    private final b hnadse;
    private final com.hihonor.adsdk.common.video.g.c hnadsf;

    private static final class a extends Handler implements b {
        private final String hnadsa;
        private final List<b> hnadsb;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.hnadsa = str;
            this.hnadsb = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.hnadsb.iterator();
            while (it.hasNext()) {
                it.next().hnadsa((File) message.obj, this.hnadsa, message.arg1);
            }
        }

        @Override // com.hihonor.adsdk.common.video.g.j.b
        public void hnadsa(File file, String str, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }
    }

    public f(String str, com.hihonor.adsdk.common.video.g.c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.hnadsd = copyOnWriteArrayList;
        this.hnadsb = str;
        this.hnadsf = cVar;
        this.hnadse = new a(str, copyOnWriteArrayList);
    }

    private d hnadsc() throws com.hihonor.adsdk.common.video.g.f {
        d dVar = new d(new com.hihonor.adsdk.common.video.g.k.a(this.hnadsb, new HashMap(16)), new com.hihonor.adsdk.common.video.g.i.b(this.hnadsf.hnadsa(this.hnadsb), this.hnadsf.hnadsc));
        dVar.hnadsa(this.hnadse);
        return dVar;
    }

    private synchronized void hnadsf() throws com.hihonor.adsdk.common.video.g.f {
        this.hnadsc = this.hnadsc == null ? hnadsc() : this.hnadsc;
    }

    public void hnadsa(c cVar, Socket socket) throws com.hihonor.adsdk.common.video.g.f {
        hnadsf();
        try {
            this.hnadsa.incrementAndGet();
            if (this.hnadsc == null) {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsb, "processRequest proxyCache is null");
            }
            this.hnadsc.hnadsa(cVar, socket);
            hnadsa();
        } catch (Throwable th) {
            hnadsa();
            throw th;
        }
    }

    public int hnadsb() {
        return this.hnadsa.get();
    }

    public void hnadsd() {
        this.hnadsd.clear();
        if (this.hnadsc != null) {
            this.hnadsc.hnadsa((b) null);
            this.hnadsc.hnadsg();
            this.hnadsc = null;
        }
        this.hnadsa.set(0);
    }

    public void hnadse() throws com.hihonor.adsdk.common.video.g.f {
        try {
            hnadsf();
            this.hnadsa.incrementAndGet();
            if (this.hnadsc == null) {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsb, "startPreCache proxyCache is null");
            }
            this.hnadsc.hnadsa(0L);
            hnadsa();
        } catch (Throwable th) {
            hnadsa();
            throw th;
        }
    }

    public void hnadsb(b bVar) {
        this.hnadsd.remove(bVar);
    }

    private synchronized void hnadsa() {
        if (this.hnadsa.decrementAndGet() <= 0 && this.hnadsc != null) {
            this.hnadsc.hnadsg();
            this.hnadsc = null;
        }
    }

    public void hnadsa(b bVar) {
        this.hnadsd.add(bVar);
    }
}
