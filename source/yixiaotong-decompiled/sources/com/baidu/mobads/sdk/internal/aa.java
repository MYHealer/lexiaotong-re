package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1709a = "LoadRemoteDex";
    private static aa i;
    private IXAdContainerFactory b;
    private bp c;
    private Runnable f;
    private Context g;
    private boolean k;
    private int d = 5000;
    private Handler e = new Handler(Looper.getMainLooper());
    private bv h = bv.a();
    private AtomicBoolean j = new AtomicBoolean(false);

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1710a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    public Context b() {
        return this.g;
    }

    public boolean e() {
        return this.k;
    }

    public static aa a() {
        if (i == null) {
            synchronized (aa.class) {
                if (i == null) {
                    i = new aa();
                }
            }
        }
        return i;
    }

    private aa() {
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.h.c(f1709a, "init Context is null,error");
            return;
        }
        this.g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        s.a().a(aVar);
        if (this.b != null) {
            k();
        } else {
            if (this.j.get()) {
                return;
            }
            f();
        }
    }

    public IXAdContainerFactory c() {
        if (this.g == null) {
            return null;
        }
        if (this.b == null && !this.j.get()) {
            f();
        }
        return this.b;
    }

    private void f() {
        this.j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bp bpVar = new bp(Class.forName(z.aQ, true, getClass().getClassLoader()), this.g);
                this.c = bpVar;
                this.b = bpVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f = new ab(this);
        j();
        if (h.f1813a == null) {
            synchronized (cb.class) {
                if (h.f1813a == null) {
                    h.f1813a = new cb(this.g);
                }
            }
        }
        if (this.b != null) {
            k();
            return;
        }
        if (h.f1813a != null) {
            this.h.a(f1709a, "start load apk");
            try {
                h.f1813a.a(new ac(this));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.h.a(f1709a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
    }

    private void i() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        this.f = null;
    }

    private void j() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.set(false);
        bn.a(this.g);
        i();
        s.a().a(1);
        cp.a(this.g).b();
        cp.a(this.g).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h.a(f1709a, "加载dex失败原因=" + str);
        this.j.set(false);
        i();
        s.a().a(2);
    }

    public String d() {
        return this.b != null ? "_" + this.b.getRemoteVersion() : "";
    }
}
