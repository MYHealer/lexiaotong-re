package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.e;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.core.e.a.m;
import com.kwad.sdk.core.e.a.n;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.t;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    static /* synthetic */ void Il() {
    }

    public static String getAppOAID(Context context) {
        if (be.useOaidDisable() && !TextUtils.isEmpty(be.getDevOaid())) {
            return be.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (be.useOaidDisable() || !t.UI()) {
            String strMN = MN();
            sOAID = strMN;
            return strMN;
        }
        initAsync(context);
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                String unused = a.sOAID = a.MN();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.ff(str);
                                a.Il();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.ff(str);
                                a.Il();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String MN() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String strI = ai.i("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = strI;
        return strI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ff(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ai.h("ksadsdk_pref", "kasd_oaid_key", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:61:0x00d7  */
    public static void getOAIDNormal(Context context) {
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase) {
                case "HUAWEI":
                    sOAID = new d(origApplicationContext).getOAID();
                    break;
                case "HONOR":
                    sOAID = new b(origApplicationContext).getOAID();
                    break;
                case "XIAOMI":
                case "BLACKSHARK":
                    sOAID = new m(origApplicationContext).getOAID();
                    break;
                case "OPPO":
                case "ONEPLUS":
                    sOAID = new j(origApplicationContext).getOAID();
                    break;
                case "VIVO":
                    sOAID = new l(origApplicationContext).getOAID();
                    break;
                case "LENOVO":
                case "MOTOLORA":
                    sOAID = new e(origApplicationContext).getOAID();
                    break;
                case "MEIZU":
                    sOAID = new f(origApplicationContext).getOAID();
                    break;
                case "NUBIA":
                    sOAID = new g(origApplicationContext).getOAID();
                    break;
                case "SAMSUNG":
                    sOAID = new k(origApplicationContext).getOAID();
                    break;
                case "ASUS":
                    sOAID = new com.kwad.sdk.core.e.a.a(origApplicationContext).getOAID();
                    break;
                case "ZTE":
                case "FERRMEOS":
                case "SSUI":
                    sOAID = new n(origApplicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
            ff(sOAID);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }
}
