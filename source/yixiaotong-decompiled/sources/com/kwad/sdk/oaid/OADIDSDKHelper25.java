package com.kwad.sdk.oaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    public interface a {
        void OnOAIDValid(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Log.d(TAG, "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListener25(jCurrentTimeMillis, aVar)));
        } catch (Throwable unused) {
            Log.d(TAG, "OADIDSDKHelper25:oaid sdk not find ");
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper25.1
                public void OnSupport(boolean z, IdSupplier idSupplier) {
                }
            }.OnSupport(true, (IdSupplier) null);
            try {
                Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
                return true;
            } catch (Throwable unused) {
                Log.d(TAG, "OADIDSDKHelper25:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                return false;
            }
        } catch (Throwable unused2) {
            Log.d(TAG, "OADIDSDKHelper25:isSupport oaid sdk not find ");
            return false;
        }
    }

    static class IIdentifierListener25 implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        public void OnSupport(boolean z, IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d(OADIDSDKHelper25.TAG, "OADIDSDKHelper25:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.OnOAIDValid(oaid);
                } else {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }
}
