package com.opos.mobad.service.d;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.exoplayer2.C;
import com.opos.cmn.ac.AcTools;
import com.opos.cmn.an.j.b;
import com.opos.mobad.ad.e;
import com.opos.mobad.provider.openId.IdModelIdentify;
import com.opos.mobad.provider.openId.OpenIdData;
import com.stub.StubApp;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f7347a;
    private volatile com.opos.mobad.provider.openId.a b;
    private Context c;
    private com.opos.cmn.i.a i;
    private com.opos.cmn.i.a j;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private int h = 0;
    private boolean k = true;
    private boolean l = true;
    private String m = "";
    private volatile String n = "";
    private volatile boolean o = false;
    private volatile C0991a p = null;
    private AtomicReference<OpenIdData> q = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.opos.mobad.service.d.a$a, reason: collision with other inner class name */
    public static class C0991a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7355a;
        public final int b = 1;

        public C0991a(String str) {
            this.f7355a = str;
        }

        public static C0991a a(e eVar) {
            String strB = b(eVar);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            return new C0991a(strB);
        }

        private static final boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "isNum id null");
                return false;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                try {
                    if (!Character.isDigit(charArray[i])) {
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "parse dev id invalid ");
                        return false;
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("IdentityIdManager", "parse dev error", (Throwable) e);
                    return false;
                }
            }
            return true;
        }

        private static String b(e eVar) {
            String str;
            if (eVar == null) {
                return null;
            }
            String strA = eVar.a();
            com.opos.cmn.an.f.a.b("IdentityIdManager", "parse dev id origin:" + strA);
            if (TextUtils.isEmpty(strA)) {
                str = "isNum id null";
            } else {
                String strTrim = strA.trim();
                if (strTrim.length() >= 15 && strTrim.length() <= 17) {
                    if (a(strTrim)) {
                        return strTrim;
                    }
                    return null;
                }
                str = "isNum id over max";
            }
            com.opos.cmn.an.f.a.b("IdentityIdManager", str);
            return null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.provider.openId.a a(Context context) {
        com.opos.mobad.provider.openId.a aVar = this.b;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = this.b;
                if (aVar == null) {
                    aVar = new com.opos.mobad.provider.openId.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new IdModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
                    this.b = aVar;
                }
            }
        }
        return aVar;
    }

    public static a a() {
        a aVar = f7347a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f7347a;
                if (aVar == null) {
                    aVar = new a();
                    f7347a = aVar;
                }
            }
        }
        return aVar;
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OpenIdData openIdData) {
        if (openIdData != null && LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.q, null, openIdData)) {
            this.d = a(openIdData.f7267a);
            this.e = a(openIdData.b);
            this.f = a(openIdData.c);
        }
    }

    private void a(final Callable<OpenIdData> callable, final CountDownLatch countDownLatch) {
        b.c(new Runnable() { // from class: com.opos.mobad.service.d.a.6
            @Override // java.lang.Runnable
            public void run() {
                OpenIdData openIdData;
                OpenIdData openIdData2 = null;
                try {
                    openIdData = (OpenIdData) callable.call();
                    try {
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "real call:" + callable + "," + openIdData);
                    } catch (Exception e) {
                        e = e;
                        openIdData2 = openIdData;
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                        openIdData = openIdData2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (openIdData != null) {
                    a.this.a(openIdData);
                    countDownLatch.countDown();
                }
                countDownLatch.countDown();
            }
        });
    }

    private void a(CountDownLatch countDownLatch) {
        a(new Callable<OpenIdData>() { // from class: com.opos.mobad.service.d.a.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OpenIdData call() {
                try {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "real op call");
                    a aVar = a.this;
                    return aVar.a(aVar.c).a();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                    return null;
                }
            }
        }, countDownLatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0039 A[Catch: all -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:18:0x0039, B:25:0x0046), top: B:36:0x0013 }] */
    public String b(Context context) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://mk_ex");
        if (Build.VERSION.SDK_INT > 26) {
            ContentProviderClient contentProviderClient = null;
            try {
                try {
                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            try {
                                String string = contentProviderClientAcquireUnstableContentProviderClient.call("query_vaid", null, null).getString("vaid_result");
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                    try {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                return string;
                            } catch (Exception e) {
                                try {
                                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                } catch (Exception unused2) {
                                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                                    if (contentProviderClient != null) {
                                        contentProviderClient.close();
                                    }
                                    return "";
                                }
                                return "";
                            }
                        } catch (Throwable th) {
                            th = th;
                            contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            if (contentProviderClient != null) {
                                try {
                                    contentProviderClient.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                } catch (Throwable unused4) {
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    private void b(CountDownLatch countDownLatch) {
        a(new Callable<OpenIdData>() { // from class: com.opos.mobad.service.d.a.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OpenIdData call() {
                try {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "real out call");
                    a aVar = a.this;
                    return aVar.a(aVar.c).c();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "readOuterOpenId fail", e);
                    com.opos.mobad.provider.openId.b.f7268a.a(-30091);
                    return null;
                }
            }
        }, countDownLatch);
    }

    public static boolean o() {
        String str = Build.BRAND;
        try {
            return com.opos.cmn.biz.a.a.c.equalsIgnoreCase(str) || com.opos.cmn.biz.a.a.f5959a.equalsIgnoreCase(str) || com.opos.cmn.biz.a.a.b.equalsIgnoreCase(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "isOwnBrand error", e);
            return false;
        }
    }

    private void p() {
        if (this.c == null) {
            return;
        }
        this.j.a();
    }

    private void q() {
        if (TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && this.c != null) {
            this.i.a();
        }
    }

    private void r() {
        Context context = this.c;
        if (context == null) {
            return;
        }
        if (com.opos.cmn.g.a.b.e(context)) {
            b.c(new Runnable() { // from class: com.opos.mobad.service.d.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar = a.this;
                        aVar.k = aVar.a(aVar.c).b();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "update status error" + e);
                    }
                }
            });
        } else {
            this.k = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OpenIdData s() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (o()) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but own brand");
                if (!a(this.c).d()) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but not support");
                    return null;
                }
                CountDownLatch countDownLatch = new CountDownLatch(2);
                a(countDownLatch);
                try {
                    countDownLatch.await(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                }
            } else {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but other brand");
                if (!a(this.c).e()) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "getOutOpenId but not support");
                    return null;
                }
                CountDownLatch countDownLatch2 = new CountDownLatch(2);
                b(countDownLatch2);
                try {
                    countDownLatch2.await(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    e = e2;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                }
            }
            OpenIdData openIdData = this.q.get();
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId cost time = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",getOpenIdData" + openIdData);
            return openIdData;
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId error", e3);
            com.opos.mobad.provider.openId.b.f7268a.a(-30090);
            return null;
        }
    }

    public void a(Context context, boolean z, e eVar) {
        this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.o = z;
        this.p = C0991a.a(eVar);
        this.i = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.d.a.1
            @Override // com.opos.cmn.i.a.b
            public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "init");
                b.c(new Runnable() { // from class: com.opos.mobad.service.d.a.1.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        try {
                            if (!a.this.a(a.this.c).d() && !a.this.a(a.this.c).e()) {
                                com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                            } else {
                                if (a.this.s() == null) {
                                    com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                    com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a2 = interfaceC0895a;
                                    if (interfaceC0895a2 != null) {
                                        interfaceC0895a2.b();
                                        return;
                                    }
                                    return;
                                }
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                            }
                            String strB = a.this.b(a.this.c);
                            if (!TextUtils.isEmpty(strB)) {
                                a.this.g = strB;
                            }
                            a.this.c();
                            a.this.d();
                            interfaceC0895a.a();
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e);
                            interfaceC0895a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        this.j = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.service.d.a.2
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            }
        }, Integer.MAX_VALUE, 0);
        q();
        p();
    }

    public void a(boolean z) {
        this.l = z;
        com.opos.cmn.an.f.a.b("IdentityIdManager", "app status:" + this.l);
    }

    public int b() {
        return com.opos.mobad.provider.openId.b.f7268a.a();
    }

    public String c() {
        return AcTools.isSoEnabled() ? AcTools.getBootMark() : "";
    }

    public String d() {
        return AcTools.isSoEnabled() ? AcTools.getUpdateMark() : "";
    }

    public boolean e() {
        return this.l;
    }

    public String f() {
        if (this.o) {
            return "";
        }
        String strA = this.n;
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        Context context = this.c;
        if (context == null) {
            return "";
        }
        try {
            strA = com.opos.cmn.an.c.e.a(context);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("IdentityIdManager", "", th);
        }
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        this.n = strA;
        return strA;
    }

    public String g() {
        q();
        return this.d;
    }

    public String h() {
        q();
        return this.e;
    }

    public String i() {
        q();
        return this.f;
    }

    public String j() {
        q();
        return this.g;
    }

    public boolean k() {
        r();
        return this.k;
    }

    public C0991a l() {
        return this.p;
    }

    public String m() {
        this.j.a();
        return this.m;
    }

    public String n() {
        if (!TextUtils.isEmpty(this.d) || !TextUtils.isEmpty(this.e) || this.c == null) {
            return this.d;
        }
        s();
        return this.d;
    }
}
