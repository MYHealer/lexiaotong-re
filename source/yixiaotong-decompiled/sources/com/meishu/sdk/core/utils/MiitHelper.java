package com.meishu.sdk.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.meishu.sdk.core.AdSdk;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MiitHelper implements IIdentifierListener {
    private static final String TAG = "MiitHelper";
    private boolean isCertInit = false;
    private a _listener = null;

    public interface a {
    }

    public static String loadPemFromAssetFile(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (Exception unused) {
            Log.e(TAG, "loadPemFromAssetFile failed");
            return "";
        }
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (!z) {
            LogUtil.d(TAG, "OnSupport: isSupported is false");
            return;
        }
        if (idSupplier == null) {
            LogUtil.d(TAG, "OnSupport: idSupplier is null");
            return;
        }
        a aVar = this._listener;
        if (aVar == null) {
            LogUtil.d(TAG, "OnSupport: listener is null");
        } else {
            ((k) aVar).a(idSupplier.getOAID());
        }
    }

    public void onSupport(IdSupplier idSupplier) {
        if (!idSupplier.isSupported()) {
            LogUtil.d(TAG, "OnSupport: isSupported is false");
            return;
        }
        a aVar = this._listener;
        if (aVar == null) {
            LogUtil.d(TAG, "OnSupport: listener is null");
        } else {
            ((k) aVar).a(idSupplier.getOAID());
        }
    }

    public void prepare(Context context, a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (AdSdk.adConfig() != null && !TextUtils.isEmpty(AdSdk.adConfig().getOaidCertName())) {
                System.loadLibrary("msaoaidsec");
                if (!this.isCertInit) {
                    String strLoadPemFromAssetFile = loadPemFromAssetFile(context, AdSdk.adConfig().getOaidCertName());
                    Method declaredMethod = MdidSdkHelper.class.getDeclaredMethod("InitCert", Context.class, String.class);
                    declaredMethod.setAccessible(true);
                    boolean zBooleanValue = ((Boolean) declaredMethod.invoke(null, context, strLoadPemFromAssetFile)).booleanValue();
                    this.isCertInit = zBooleanValue;
                    if (!zBooleanValue) {
                        Log.w(TAG, "getDeviceIds: cert init failed");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this._listener = aVar;
            int iInitSdk = MdidSdkHelper.InitSdk(context, true, this);
            String str = "";
            switch (iInitSdk) {
                case 1008611:
                    str = "不支持的设备厂商";
                    break;
                case 1008612:
                    str = "不支持的设备";
                    LogUtil.d(TAG, "不支持的设备");
                    break;
                case 1008613:
                    str = "加载配置文件出错";
                    break;
                case 1008614:
                    str = "获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程";
                    break;
                case 1008615:
                    str = "反射调用出错";
                    break;
            }
            LogUtil.d(TAG, str);
            if (TextUtils.isEmpty(str)) {
                AdSdk.setOaid_errno(-1);
            } else {
                AdSdk.setOaid_errno(iInitSdk);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
