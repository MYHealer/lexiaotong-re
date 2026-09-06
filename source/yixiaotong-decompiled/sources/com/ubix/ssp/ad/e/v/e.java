package com.ubix.ssp.ad.e.v;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import com.ubix.ssp.open.AdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static LruCache<String, Bitmap> f8879a;
    protected static LruCache<String, byte[]> b;
    protected static Map<String, Long> c;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f8880a;

        public a(b bVar) {
            super(Looper.getMainLooper());
            this.f8880a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle data = message.getData();
            int i = message.what;
            if (i == 1) {
                removeMessages(2);
                b bVar = this.f8880a;
                if (bVar != null) {
                    bVar.a((e) message.obj, data.getString("url"), data.getString("path"), false);
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            removeMessages(2);
            b bVar2 = this.f8880a;
            if (bVar2 != null) {
                bVar2.a((AdError) data.getSerializable("error"));
            }
        }
    }

    public interface b {
        void a(e eVar, String str, String str2, boolean z);

        void a(AdError adError);
    }

    public e() {
        d();
        a(com.ubix.ssp.ad.d.b.K, com.ubix.ssp.ad.d.b.L);
    }

    public static com.ubix.ssp.ad.e.v.a b() {
        return new com.ubix.ssp.ad.e.v.g.a();
    }

    public static f c() {
        return new com.ubix.ssp.ad.e.v.g.b();
    }

    private void d() {
        if (f8879a == null) {
            f8879a = new LruCache<>(com.ubix.ssp.ad.d.b.K);
        }
        if (b == null) {
            b = new LruCache<>(com.ubix.ssp.ad.d.b.L);
        }
        if (c == null) {
            c = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message a(AdError adError) {
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable("error", adError);
        message.setData(bundle);
        return message;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message a(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("path", str2);
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    protected void a(int i, int i2) {
        LruCache<String, Bitmap> lruCache = f8879a;
        if (lruCache != null && lruCache.maxSize() != i) {
            f8879a.resize(i);
        }
        LruCache<String, byte[]> lruCache2 = b;
        if (lruCache2 == null || lruCache2.maxSize() == i2) {
            return;
        }
        b.resize(i2);
    }

    public Bitmap b(String str) {
        return null;
    }
}
