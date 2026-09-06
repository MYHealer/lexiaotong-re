package com.yfanads.android.adx.core.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.heytap.nearx.tapplugin.pluginapi.BuildConfig;
import com.loopj.android.http.AsyncHttpClient;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxReqNew;
import com.yfanads.android.adx.core.model.NativeSourceNew;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: LoadMgrImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e implements LoadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f9590a = new GsonBuilder().create();

    /* JADX INFO: compiled from: LoadMgrImpl.java */
    public class a extends NetCallBack.NetCallBackString {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9591a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(false);
            this.f9591a = str;
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: onFailure */
        public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
            com.yfanads.android.adx.utils.a.b("failure code = " + i + " , msg = " + str + "|" + this.f9591a.hashCode());
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: onResponse */
        public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
            com.yfanads.android.adx.utils.a.a("success response= " + str + "|" + this.f9591a.hashCode());
        }
    }

    /* JADX INFO: compiled from: LoadMgrImpl.java */
    public class b extends NetCallBack.NetCallBackString {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadManager.NativeAdListener f9592a;
        public final /* synthetic */ AdxScene b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LoadManager.NativeAdListener nativeAdListener, AdxScene adxScene) {
            super(false);
            this.f9592a = nativeAdListener;
            this.b = adxScene;
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: onFailure */
        public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(final int i, final String str) {
            com.yfanads.android.adx.utils.a.a("code = " + i + " , msg = " + str);
            Handler handler = com.yfanads.android.adx.utils.b.b;
            final LoadManager.NativeAdListener nativeAdListener = this.f9592a;
            handler.post(new Runnable() { // from class: com.yfanads.android.adx.core.impl.e$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    nativeAdListener.onError(i, str);
                }
            });
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
            com.yfanads.android.adx.utils.a.a("success ");
            NativeSourceNew nativeSource = NativeSourceNew.getNativeSource(str);
            if (nativeSource == null || !nativeSource.isSuccess()) {
                final int i = nativeSource != null ? nativeSource.code : -1;
                final String str2 = nativeSource != null ? nativeSource.msg : "has no data";
                Handler handler = com.yfanads.android.adx.utils.b.b;
                final LoadManager.NativeAdListener nativeAdListener = this.f9592a;
                handler.post(new Runnable() { // from class: com.yfanads.android.adx.core.impl.e$b$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        nativeAdListener.onError(i, str2);
                    }
                });
                return;
            }
            AdxScene adxScene = this.b;
            nativeSource.rid = adxScene != null ? adxScene.getReqId() : "";
            e eVar = e.this;
            LoadManager.NativeAdListener nativeAdListener2 = this.f9592a;
            eVar.getClass();
            e.a(nativeSource, nativeAdListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdxScene adxScene, LoadManager.NativeAdListener nativeAdListener) {
        a("asy", adxScene, nativeAdListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AdxScene adxScene, final LoadManager.NativeAdListener nativeAdListener) {
        com.yfanads.android.adx.service.c.a.f9618a.getClass();
        if (TextUtils.isEmpty(DeviceUtils.getUA())) {
            DeviceUtils.initWua(com.yfanads.android.adx.service.d.b, new DeviceUtils.OnUAResult() { // from class: com.yfanads.android.adx.core.impl.e$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.libs.utils.DeviceUtils.OnUAResult
                public final void hasUAResult() {
                    this.f$0.a(adxScene, nativeAdListener);
                }
            });
        } else {
            a("syn", adxScene, nativeAdListener);
        }
    }

    public final void c(final AdxScene adxScene, final LoadManager.NativeAdListener nativeAdListener) {
        com.yfanads.android.adx.utils.b.f9622a.submit(new Runnable() { // from class: com.yfanads.android.adx.core.impl.e$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(adxScene, nativeAdListener);
            }
        });
    }

    @Override // com.yfanads.android.adx.api.LoadManager
    public final void loadNativeAd(AdxScene adxScene, LoadManager.NativeAdListener nativeAdListener) {
        c(adxScene, nativeAdListener);
    }

    @Override // com.yfanads.android.adx.api.LoadManager
    public final void reportAdInfo(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) {
        String string;
        HashMap map;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str)) {
                    string = str;
                } else {
                    com.yfanads.android.adx.utils.a.a(Arrays.toString(strArr3) + "|" + Arrays.toString(strArr5));
                    StringBuilder sb = new StringBuilder(str);
                    a(strArr2, strArr3, sb);
                    a(strArr4, strArr5, sb);
                    string = sb.toString();
                }
                com.yfanads.android.adx.utils.a.a("reportAdInfo = " + str.hashCode());
                try {
                    map = new HashMap();
                    map.put("User-Agent", com.yfanads.android.adx.service.d.d.deviceUA());
                } catch (Exception e) {
                    e.printStackTrace();
                    map = null;
                }
                UrlHttpUtil.get(string, null, map, new a(str));
            }
        }
    }

    public final void a(String str, AdxScene adxScene, LoadManager.NativeAdListener nativeAdListener) {
        com.yfanads.android.adx.utils.a.a("requestRealData start ".concat(str));
        g gVar = com.yfanads.android.adx.service.d.d;
        AdxSdkConfig adxSdkConfig = com.yfanads.android.adx.service.d.c;
        AdxReqNew adxReqNewCreate = AdxReqNew.create(adxSdkConfig, gVar, adxScene);
        String adxReq = UrlConst.getAdxReq(adxSdkConfig != null ? adxSdkConfig.appId : "", adxScene != null ? adxScene.getPosId() : "");
        String strDeviceUA = gVar != null ? gVar.deviceUA() : "";
        String reqId = adxScene != null ? adxScene.getReqId() : "";
        HashMap map = new HashMap();
        map.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        map.put("User-Agent", strDeviceUA);
        map.put("X-Request-Id", reqId);
        map.put("api-version", BuildConfig.VERSION_NAME);
        UrlHttpUtil.postJson(adxReq, this.f9590a.toJson(adxReqNewCreate), map, new b(nativeAdListener, adxScene));
    }

    public static void a(NativeSourceNew nativeSourceNew, final LoadManager.NativeAdListener nativeAdListener) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeAdImpl(nativeSourceNew));
        com.yfanads.android.adx.utils.b.b.post(new Runnable() { // from class: com.yfanads.android.adx.core.impl.e$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                nativeAdListener.onNativeAdLoad(arrayList);
            }
        });
    }

    public static void a(String[] strArr, String[] strArr2, StringBuilder sb) {
        if (strArr == null || strArr.length <= 0 || strArr2 == null || strArr2.length <= 0) {
            return;
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i < strArr2.length && !TextUtils.isEmpty(strArr2[i])) {
                String str = strArr[i];
                String str2 = strArr2[i];
                int iIndexOf = sb.indexOf(str);
                while (iIndexOf != -1) {
                    sb.replace(iIndexOf, str.length() + iIndexOf, str2);
                    iIndexOf = sb.indexOf(str, str2.length() + iIndexOf);
                }
            }
        }
    }
}
