package com.meishu.sdk.core.webview;

import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.q0;
import java.util.Timer;

/* JADX INFO: compiled from: DisplayTimeOutMonitor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    public InterfaceC0822b b;
    public InterfaceC0822b c;
    public volatile int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4974a = new Object();
    public boolean d = false;
    public volatile Boolean e = null;

    /* JADX INFO: compiled from: DisplayTimeOutMonitor.java */
    public class a extends com.meishu.sdk.core.safe.n {

        /* JADX INFO: renamed from: com.meishu.sdk.core.webview.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DisplayTimeOutMonitor.java */
        public class C0821a extends com.meishu.sdk.core.safe.l {
            public C0821a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                b.a(b.this, false, 3);
            }
        }

        public a() {
        }

        @Override // com.meishu.sdk.core.safe.n
        public void a() {
            cancel();
            SdkHandler.getInstance().runOnUiThread(new C0821a());
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.core.webview.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DisplayTimeOutMonitor.java */
    public interface InterfaceC0822b {
        void a(boolean z, int i);
    }

    public b(InterfaceC0822b interfaceC0822b) {
        this.b = interfaceC0822b;
    }

    public void a(InterfaceC0822b interfaceC0822b) {
        this.c = interfaceC0822b;
        if (this.e != null) {
            if (interfaceC0822b != null) {
                interfaceC0822b.a(this.e.booleanValue(), this.f);
                this.c = null;
                return;
            }
            return;
        }
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            new Timer().schedule(new a(), q0.b() > 0 ? q0.b() : 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(b bVar, boolean z, int i) {
        synchronized (bVar.f4974a) {
            if (bVar.e == null) {
                bVar.e = Boolean.valueOf(z);
                bVar.f = i;
            }
            InterfaceC0822b interfaceC0822b = bVar.b;
            if (interfaceC0822b != null) {
                interfaceC0822b.a(z, i);
                bVar.b = null;
            }
            InterfaceC0822b interfaceC0822b2 = bVar.c;
            if (interfaceC0822b2 != null) {
                interfaceC0822b2.a(z, i);
                bVar.c = null;
            }
        }
    }
}
