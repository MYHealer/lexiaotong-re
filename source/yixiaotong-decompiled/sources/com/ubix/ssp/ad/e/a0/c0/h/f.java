package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import com.ubix.ssp.ad.e.a0.u;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class f implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8646a;
    private final Handler b = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.a0.c0.c f8647a;

        a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
            this.f8647a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.f8647a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.a0.c0.c f8648a;
        final /* synthetic */ String b;

        b(com.ubix.ssp.ad.e.a0.c0.c cVar, String str) {
            this.f8648a = cVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8648a.a(this.b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.a0.c0.c f8649a;
        final /* synthetic */ com.ubix.ssp.ad.e.a0.c0.e b;

        c(com.ubix.ssp.ad.e.a0.c0.c cVar, com.ubix.ssp.ad.e.a0.c0.e eVar) {
            this.f8649a = cVar;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8649a.a(this.b);
        }
    }

    public f(Context context) {
        this.f8646a = context;
    }

    private void a(com.ubix.ssp.ad.e.a0.c0.c cVar, com.ubix.ssp.ad.e.a0.c0.e eVar) {
        this.b.post(new c(cVar, eVar));
    }

    private void a(com.ubix.ssp.ad.e.a0.c0.c cVar, String str) {
        this.b.post(new b(cVar, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        try {
            Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient");
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f8646a);
                if (advertisingIdInfo == null) {
                    a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("Advertising identifier info is null"));
                } else if (advertisingIdInfo.isLimit) {
                    a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("User has disabled advertising identifier"));
                } else {
                    a(cVar, advertisingIdInfo.id);
                }
            } catch (Throwable th) {
                com.ubix.ssp.ad.e.a0.c0.f.a(th);
                try {
                    com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.C1066a c1066aA = com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.a(this.f8646a);
                    if (c1066aA == null) {
                        a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("Advertising identifier info is null"));
                    } else if (c1066aA.b) {
                        a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("User has disabled advertising identifier"));
                    } else {
                        a(cVar, c1066aA.f8666a);
                        a(cVar, new com.ubix.ssp.ad.e.a0.c0.e(th));
                    }
                } catch (Throwable th2) {
                    com.ubix.ssp.ad.e.a0.c0.f.a(th2);
                    a(cVar, new com.ubix.ssp.ad.e.a0.c0.e(th2));
                }
            }
        } catch (Throwable th3) {
            com.ubix.ssp.ad.e.a0.c0.f.a(th3);
            try {
                com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.C1066a c1066aA2 = com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.a(this.f8646a);
                if (c1066aA2 == null) {
                    a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("Advertising identifier info is null"));
                } else if (c1066aA2.b) {
                    a(cVar, new com.ubix.ssp.ad.e.a0.c0.e("User has disabled advertising identifier"));
                } else {
                    a(cVar, c1066aA2.f8666a);
                }
            } catch (Throwable th4) {
                com.ubix.ssp.ad.e.a0.c0.f.a(th4);
                a(cVar, new com.ubix.ssp.ad.e.a0.c0.e(th4));
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8646a == null || cVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new a(cVar));
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        if (this.f8646a == null) {
            return false;
        }
        try {
            u.e("AdvertisingIdPlatform", "supported in");
            Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient");
            u.e("AdvertisingIdPlatform", "supported in system");
            return AdvertisingIdClient.isAdvertisingIdAvailable(this.f8646a);
        } catch (Throwable th) {
            try {
                u.e("AdvertisingIdPlatform", "supported in custom");
                return com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.b(this.f8646a);
            } catch (Throwable th2) {
                u.e("AdvertisingIdPlatform", "supported " + th2.getMessage());
                th.printStackTrace();
                return false;
            }
        }
    }
}
