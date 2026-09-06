package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class AbstractAD<T> {
    private static final AtomicBoolean g = new AtomicBoolean(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f8457a;
    private volatile boolean e;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private volatile long f = -1;
    private final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f > 0) {
            try {
                GlobalSetting.getSettings().putOpt("gdtwict", Long.valueOf(SystemClock.elapsedRealtime() - this.f));
            } catch (Throwable unused) {
            }
        }
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    protected abstract void a(T t);

    protected final boolean a() {
        return this.e && this.d;
    }

    protected abstract void b(int i);

    private void b(Context context, String str, String str2) {
        this.e = true;
        if (a.b().d()) {
            a(context, a.b().a(), str, str2);
        } else {
            a(2003);
        }
    }

    protected final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    protected final boolean b() {
        if (!this.c && g.compareAndSet(true, false)) {
            this.f = SystemClock.elapsedRealtime();
        }
        return this.c;
    }

    protected final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    private final void a(final Context context, final String str, final String str2, final String str3) {
        if (com.qq.e.comm.a.a(context)) {
            this.d = true;
            a.g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        AbstractAD.this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD abstractAD = AbstractAD.this;
                                        abstractAD.f8457a = (T) abstractAD.a(context, pOFactory2, str, str2, str3);
                                        AbstractAD.this.c = true;
                                        AbstractAD abstractAD2 = AbstractAD.this;
                                        if (abstractAD2.f8457a == null) {
                                            abstractAD2.a(200103);
                                        } else {
                                            abstractAD2.c();
                                            AbstractAD abstractAD3 = AbstractAD.this;
                                            abstractAD3.a(abstractAD3.f8457a);
                                        }
                                    } else {
                                        AbstractAD.this.c = true;
                                        AbstractAD.this.a(200102);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.c = true;
                                    AbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.c = true;
                        AbstractAD.this.a(200102);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    protected final void a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i);
        } else {
            this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i);
                }
            });
        }
    }

    protected final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }
}
