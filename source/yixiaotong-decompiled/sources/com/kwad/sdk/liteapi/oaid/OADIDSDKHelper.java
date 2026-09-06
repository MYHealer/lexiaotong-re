package com.kwad.sdk.liteapi.oaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
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
            Log.d(TAG, "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListenerImpl(jCurrentTimeMillis, aVar)));
        } catch (Throwable unused) {
            Log.d(TAG, "OADIDSDKHelper:oaid sdk not find ");
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.liteapi.oaid.OADIDSDKHelper.1
                public void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            try {
                Log.d(TAG, "OADIDSDKHelper:oaidVersion" + e.a());
                try {
                    Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
                    return true;
                } catch (Throwable unused) {
                    Log.d(TAG, "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                    return false;
                }
            } catch (Throwable unused2) {
                Log.d(TAG, "OADIDSDKHelper:oaidVersion fail");
                return false;
            }
        } catch (Throwable unused3) {
            Log.d(TAG, "OADIDSDKHelper:isSupport oaid sdk not find ");
            return false;
        }
    }

    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d(OADIDSDKHelper.TAG, "OADIDSDKHelper:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.OnOAIDValid(oaid);
                } else {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }
}
