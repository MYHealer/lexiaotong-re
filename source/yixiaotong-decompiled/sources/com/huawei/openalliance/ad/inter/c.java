package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.dd;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jl;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.w;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bl;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c extends BroadcastReceiver {
    private ej F;
    private Context S;

    public c(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.S = origApplicationContext;
        this.F = ej.Code(origApplicationContext);
    }

    private AdContentData Code(JSONObject jSONObject) {
        AdContentData adContentData = null;
        try {
            String strOptString = jSONObject.optString("contentRecord");
            AdContentData adContentData2 = (AdContentData) ad.V(strOptString, AdContentData.class, new Class[0]);
            try {
                if (fh.Code()) {
                    fh.Code("ExLinkedSplashReceiver", " adContent content=%s", bl.Code(strOptString));
                }
                if (adContentData2 == null) {
                    return adContentData2;
                }
                V(jSONObject);
                return adContentData2;
            } catch (Throwable th) {
                th = th;
                adContentData = adContentData2;
                fh.I("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
                return adContentData;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void Code() {
        com.huawei.openalliance.ad.ipc.d.Code(this.S).Code("showSplash", null, null, null);
    }

    private void Code(Context context, SafeIntent safeIntent) throws JSONException {
        fh.V("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
        Long lValueOf = Long.valueOf(safeIntent.getLongExtra(w.ab, 0L));
        int intExtra = safeIntent.getIntExtra(w.ac, 0);
        String stringExtra = safeIntent.getStringExtra(w.ad);
        String stringExtra2 = safeIntent.getStringExtra("linked_content_slotId");
        String stringExtra3 = safeIntent.getStringExtra("unique_id");
        int intExtra2 = safeIntent.getIntExtra(w.ae, 0);
        fh.Code("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", lValueOf, Integer.valueOf(intExtra), stringExtra);
        context.removeStickyBroadcast(safeIntent);
        ej ejVar = this.F;
        if (ejVar != null) {
            ejVar.V(lValueOf.longValue());
            this.F.Z(intExtra);
            this.F.V(stringExtra);
            this.F.B(intExtra2);
        }
        Code(context, stringExtra, stringExtra2, stringExtra3);
    }

    private void Code(Context context, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content_id", str);
        jSONObject.put("package_name", this.S.getPackageName());
        jSONObject.put(bf.H, false);
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("slotid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("unique_id", str3);
        }
        com.huawei.openalliance.ad.ipc.d.Code(context).Code("reqLinkedVideo", jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.c.1
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str4, CallResult<String> callResult) {
                c.this.Code(callResult);
            }
        }, String.class);
    }

    private void Code(final k kVar, final AdContentData adContentData) {
        final com.huawei.openalliance.ad.inter.listeners.f fVarC = g.Code(this.S).C();
        if (fVarC != null) {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.c.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean zCode = fVarC.Code(kVar);
                    fh.V("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(zCode));
                    c.this.Code(zCode, kVar, adContentData);
                }
            });
        } else {
            fh.I("ExLinkedSplashReceiver", "exSplashCallback is null");
            Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(CallResult<String> callResult) {
        if (callResult.getCode() == 200) {
            fh.V("ExLinkedSplashReceiver", "reqExLinkedVideo success");
            V(callResult);
        } else {
            fh.I("ExLinkedSplashReceiver", "call reqExLinked failed");
            Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, k kVar, AdContentData adContentData) {
        String strR;
        String strD;
        if (z) {
            return;
        }
        fh.I("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
        Code();
        if (kVar != null) {
            strD = kVar.d();
            strR = kVar.r();
        } else {
            strR = null;
            strD = null;
        }
        dd.Code(this.S, strR, strD, 0L, adContentData, "82");
    }

    private void V(CallResult<String> callResult) {
        try {
            AdContentData adContentDataCode = Code(new JSONObject(callResult.getData()));
            if (adContentDataCode != null) {
                adContentDataCode.C(true);
                k kVarCode = jl.Code(adContentDataCode);
                kVarCode.Code(true);
                Code(kVarCode, adContentDataCode);
            } else {
                fh.I("ExLinkedSplashReceiver", "content is null");
                Code();
            }
        } catch (JSONException unused) {
            fh.I("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
        }
    }

    private void V(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("splash_skip_area");
        String strOptString = jSONObject.optString(bf.J);
        if (fh.Code()) {
            fh.Code("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(iOptInt));
            fh.Code("ExLinkedSplashReceiver", "globalSwitch=%s", bl.Code(strOptString));
        }
        ej ejVar = this.F;
        if (ejVar != null) {
            ejVar.C(iOptInt);
            this.F.I(strOptString);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("ExLinkedSplashReceiver", "onReceive.");
        if (intent == null) {
            return;
        }
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            if (x.bx.equals(safeIntent.getAction())) {
                Code(context, safeIntent);
            }
        } catch (JSONException unused) {
            fh.I("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            Code();
        } catch (Throwable th) {
            fh.I("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th.getClass().getSimpleName());
        }
    }
}
