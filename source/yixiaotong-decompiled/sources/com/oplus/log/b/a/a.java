package com.oplus.log.b.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.oplus.log.f.d f5791a;
    private int b = 0;
    private boolean c = false;
    private Handler d;

    /* JADX INFO: renamed from: com.oplus.log.b.a.a$a, reason: collision with other inner class name */
    static class HandlerC0864a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f5792a;

        public HandlerC0864a(Activity activity) {
            this.f5792a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Activity activity = this.f5792a.get();
            if (activity != null) {
                if (message.what != 123) {
                    if (message.what == 124) {
                        a.f5791a.a(new com.oplus.log.b.b("Network_Info", com.oplus.log.d.c.a(), (byte) 4, null, null));
                        return;
                    }
                    return;
                }
                Bitmap bitmapA = com.oplus.log.d.c.a(activity);
                if (bitmapA != null) {
                    HashMap map = new HashMap();
                    map.put("activity_name", (String) message.obj);
                    a.f5791a.a(new com.oplus.log.b.b("screenshot", bitmapA, (byte) 4, null, map));
                }
            }
        }
    }

    public a(com.oplus.log.f.d dVar) {
        f5791a = dVar;
    }

    private void a(boolean z, boolean z2, Context context) {
        if (f5791a == null) {
            return;
        }
        if (!z) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0 || z2) {
                f5791a.a(new com.oplus.log.b.b(com.umeng.analytics.pro.d.aw, "session end", (byte) 4, null, null));
                return;
            }
            return;
        }
        int i2 = this.b;
        this.b = i2 + 1;
        if (i2 != 0 || z2) {
            return;
        }
        f5791a.a(new com.oplus.log.b.b(com.umeng.analytics.pro.d.aw, "session start", (byte) 4, null, null));
        if (this.d == null) {
            this.d = new HandlerC0864a((Activity) context);
        }
        this.d.sendEmptyMessage(AppTypeIdUtil.NewDevice4GDrinkOTA_1);
    }

    @Override // com.oplus.log.b.a.c
    public final void a(Context context) {
        if (f5791a == null) {
            return;
        }
        String simpleName = ((Activity) context).getClass().getSimpleName();
        a(true, this.c, context);
        this.c = false;
        f5791a.a(new com.oplus.log.b.b("activity_lifecycle", simpleName + " start ", (byte) 4, null, null));
    }

    @Override // com.oplus.log.b.a.c
    public final void b(Context context) {
        if (f5791a == null) {
            return;
        }
        Activity activity = (Activity) context;
        f5791a.a(new com.oplus.log.b.b("activity_lifecycle", activity.getClass().getSimpleName() + " stop ", (byte) 4, null, null));
        boolean z = activity.getChangingConfigurations() != 0;
        this.c = z;
        a(false, z, null);
    }
}
