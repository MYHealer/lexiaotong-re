package com.ubixnow.ooooo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class t implements j {
    private final Context OooO00o;
    private final Handler OooO0O0 = new Handler(Looper.getMainLooper());

    public class OooO00o implements Runnable {
        public final /* synthetic */ i OooO00o;

        public OooO00o(i iVar) {
            this.OooO00o = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.OooO0O0(this.OooO00o);
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ i OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO0O0(i iVar, String str) {
            this.OooO00o = iVar;
            this.OooO0O0 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.OooO00o.OooO00o(this.OooO0O0);
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ i OooO00o;
        public final /* synthetic */ k OooO0O0;

        public OooO0OO(i iVar, k kVar) {
            this.OooO00o = iVar;
            this.OooO0O0 = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.OooO00o.OooO00o(this.OooO0O0);
        }
    }

    public t(Context context) {
        this.OooO00o = context;
    }

    private void OooO00o(i iVar, k kVar) {
        this.OooO0O0.post(new OooO0OO(iVar, kVar));
    }

    private void OooO00o(i iVar, String str) {
        this.OooO0O0.post(new OooO0O0(iVar, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(i iVar) {
        try {
            Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient");
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.OooO00o);
                if (advertisingIdInfo == null) {
                    OooO00o(iVar, new k("Advertising identifier info is null"));
                } else if (advertisingIdInfo.isLimit) {
                    OooO00o(iVar, new k("User has disabled advertising identifier"));
                } else {
                    OooO00o(iVar, advertisingIdInfo.id);
                }
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
                try {
                    f0.OooO00o OooO00o2 = f0.OooO00o(this.OooO00o);
                    if (OooO00o2 == null) {
                        OooO00o(iVar, new k("Advertising identifier info is null"));
                    } else if (OooO00o2.OooO0O0) {
                        OooO00o(iVar, new k("User has disabled advertising identifier"));
                    } else {
                        OooO00o(iVar, OooO00o2.OooO00o);
                        OooO00o(iVar, new k(th));
                    }
                } catch (Throwable th2) {
                    ooooO000.OooO00o(th2);
                    OooO00o(iVar, new k(th2));
                }
            }
        } catch (Throwable th3) {
            ooooO000.OooO00o(th3);
            try {
                f0.OooO00o OooO00o3 = f0.OooO00o(this.OooO00o);
                if (OooO00o3 == null) {
                    OooO00o(iVar, new k("Advertising identifier info is null"));
                } else if (OooO00o3.OooO0O0) {
                    OooO00o(iVar, new k("User has disabled advertising identifier"));
                } else {
                    OooO00o(iVar, OooO00o3.OooO00o);
                }
            } catch (Throwable th4) {
                ooooO000.OooO00o(th4);
                OooO00o(iVar, new k(th4));
            }
        }
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new OooO00o(iVar));
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        if (this.OooO00o == null) {
            return false;
        }
        try {
            Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient");
            return AdvertisingIdClient.isAdvertisingIdAvailable(this.OooO00o);
        } catch (Throwable th) {
            try {
                return f0.OooO0O0(this.OooO00o);
            } catch (Throwable unused) {
                th.printStackTrace();
                return false;
            }
        }
    }
}
