package com.kwad.sdk.liteapi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.liteapi.oaid.OADIDSDKHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ASUSDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HWDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.LenovoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.MeizuDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.NubiaDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.OppoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.SamsungDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.VivoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.XiaomiDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ZTEDeviceIDHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LiteOAIDHelper {
    private static final String KEY_OAID = "kasd_oaid_key";
    private static final String TAG = "OAIDHelper";
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    public static String obtainCurrent() {
        return sOAID;
    }

    public static String getAppOAID(Context context) {
        if (LiteSDKDeviceController.useOaidDisable() && !TextUtils.isEmpty(LiteSDKDeviceController.getDevOaid())) {
            return LiteSDKDeviceController.getDevOaid();
        }
        if (TextUtils.isEmpty(sOAID) && !LiteSDKDeviceController.useOaidDisable()) {
            initAsync(context);
            return sOAID;
        }
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                if (TextUtils.isEmpty(LiteOAIDHelper.sOAID)) {
                    LiteOAIDHelper.getOAIDNormal(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.1
                            @Override // com.kwad.sdk.liteapi.oaid.OADIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    } else if (LiteOADIDSDKHelper25.isSupport()) {
                        LiteOADIDSDKHelper25.getOAId(context, new LiteOADIDSDKHelper25.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.2
                            @Override // com.kwad.sdk.liteapi.LiteOADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    }
                    LiteOAIDHelper.sInitIng.set(false);
                }
            }
        });
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
                    sOAID = new HWDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "HONOR":
                    sOAID = new HONORDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "XIAOMI":
                case "BLACKSHARK":
                    sOAID = new XiaomiDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "OPPO":
                case "ONEPLUS":
                    sOAID = new OppoDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "VIVO":
                    sOAID = new VivoDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "LENOVO":
                case "MOTOLORA":
                    sOAID = new LenovoDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "MEIZU":
                    sOAID = new MeizuDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "NUBIA":
                    sOAID = new NubiaDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "SAMSUNG":
                    sOAID = new SamsungDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "ASUS":
                    sOAID = new ASUSDeviceIDHelper(origApplicationContext).getOAID();
                    break;
                case "ZTE":
                case "FERRMEOS":
                case "SSUI":
                    sOAID = new ZTEDeviceIDHelper(origApplicationContext).getOAID();
                    break;
            }
            LiteApiLogger.i(TAG, "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
    }
}
