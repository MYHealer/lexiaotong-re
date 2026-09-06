package com.oplus.instant.router.e;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.g.e;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f5775a;
    private static HandlerThread b;
    private static final Object c = new Object();
    private Context d;
    private Map<String, Object> e;
    private Callback f;
    private Uri g;

    public a(Context context, Map<String, Object> map, Callback callback, Uri uri) {
        super(a());
        this.d = context;
        this.e = map;
        this.f = callback;
        this.g = uri;
    }

    protected static Handler a() {
        Handler handler;
        synchronized (c) {
            HandlerThread handlerThread = b;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("instant_callback");
                b = handlerThread2;
                handlerThread2.start();
                Looper looper = b.getLooper();
                f5775a = looper != null ? new Handler(looper) : new Handler();
            }
            handler = f5775a;
        }
        return handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Uri uri = this.g;
        if (uri != null) {
            onChange(z, uri);
            return;
        }
        Context context = this.d;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        Context context;
        Uri uri2 = this.g;
        if (uri2 == null || !uri2.equals(uri) || (context = this.d) == null) {
            return;
        }
        Callback callback = this.f;
        if (callback != null) {
            callback.onResponse(this.e, e.a(context, uri));
        }
        this.d.getContentResolver().unregisterContentObserver(this);
    }
}
