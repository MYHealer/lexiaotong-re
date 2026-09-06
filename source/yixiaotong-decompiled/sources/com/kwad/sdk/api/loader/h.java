package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.utils.bg;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
class h {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ab aIe;
    private int currentNum;
    private String mCurrentUrl;
    private final String mUrl;

    public interface a {
        void a(com.kwad.sdk.api.loader.a.b bVar);
    }

    h(ab abVar) {
        this.aIe = abVar;
        String strHM = abVar.HM();
        this.mUrl = strHM;
        this.mCurrentUrl = strHM;
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> mapBuildHeader = buildHeader();
            String strG = g(mapBuildHeader);
            HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(this.mCurrentUrl);
            setConnectionHeader(httpURLConnectionCreateUrlConnection, mapBuildHeader);
            httpURLConnectionCreateUrlConnection.connect();
            new DataOutputStream(httpURLConnectionCreateUrlConnection.getOutputStream()).write(strG.getBytes());
            int responseCode = httpURLConnectionCreateUrlConnection.getResponseCode();
            if (responseCode == 200) {
                String strInputStream2String = inputStream2String(httpURLConnectionCreateUrlConnection.getInputStream());
                com.kwad.sdk.api.loader.a.b bVar = new com.kwad.sdk.api.loader.a.b();
                JSONObject jSONObject = new JSONObject(strInputStream2String);
                String strOptString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(strOptString) && !"null".equals(strOptString)) {
                    jSONObject.put("data", new JSONObject(this.aIe.HN().getRD(strOptString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else {
                if (responseCode / 100 != 3) {
                    throw new RuntimeException("response code = " + responseCode);
                }
                if (this.currentNum < 21) {
                    this.mCurrentUrl = httpURLConnectionCreateUrlConnection.getHeaderField("Location");
                    this.currentNum++;
                    a(aVar);
                }
            }
            if (httpURLConnectionCreateUrlConnection != null) {
                try {
                    httpURLConnectionCreateUrlConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x004c */
    private static String inputStream2String(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                String string = byteArrayOutputStream.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return string;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
                throw th;
            }
            throw th;
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private String g(Map<String, String> map) {
        String strBo = i.bo(this.aIe.getContext());
        if (TextUtils.isEmpty(strBo)) {
            strBo = this.aIe.HN().getSDKVersion();
        }
        int sDKVersionCode = this.aIe.HN().getSDKVersionCode();
        JSONObject appInfo = this.aIe.HN().getAppInfo();
        JSONObject deviceInfo = this.aIe.HN().getDeviceInfo();
        JSONObject networkInfo = this.aIe.HN().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        n.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        n.putValue(jSONObject, "sdkApiVersionCode", BuildConfig.VERSION_CODE);
        n.putValue(jSONObject, "sdkVersion", strBo);
        n.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        n.putValue(jSONObject, "sdkType", 1);
        n.putValue(jSONObject, "appInfo", appInfo);
        n.putValue(jSONObject, "deviceInfo", deviceInfo);
        n.putValue(jSONObject, "networkInfo", networkInfo);
        n.putValue(jSONObject, "sdkAbi", ac.Ex());
        String string = jSONObject.toString();
        this.aIe.HN().addHp(map);
        JSONObject jSONObject2 = new JSONObject();
        n.putValue(jSONObject2, "version", BuildConfig.VERSION_NAME);
        n.putValue(jSONObject2, "appId", appInfo.optString("appId"));
        n.putValue(jSONObject2, CrashHianalyticsData.MESSAGE, this.aIe.HN().getRM(string));
        this.aIe.HN().sR(this.mUrl, map, jSONObject2.toString());
        return jSONObject2.toString();
    }

    private static Map<String, String> buildHeader() {
        HashMap map = new HashMap();
        map.put("Accept-Language", bg.Code);
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "application/json; charset=UTF-8");
        map.put("User-Agent", RequestParamsUtils.getUserAgent());
        return map;
    }

    private static HttpURLConnection createUrlConnection(String str) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }
}
