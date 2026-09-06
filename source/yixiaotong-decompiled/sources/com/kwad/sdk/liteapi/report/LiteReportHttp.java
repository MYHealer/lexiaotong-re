package com.kwad.sdk.liteapi.report;

import android.content.Context;
import com.huawei.hms.ads.ez;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.utils.bg;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptHelper;
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
class LiteReportHttp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CONNECTION_TIME_OUT = 10000;
    private static final int MAX_REDIRECTS = 21;
    private static final int READ_WRITE_TIME_OUT = 30000;
    private static final String TAG = "LiteReportHttp";
    private int currentNum;
    private String mCurrentUrl;
    private final String mUrl;

    public interface a {
        void a(LiteApiReportResponse liteApiReportResponse);

        void b(Exception exc);
    }

    private boolean disableEncrypt() {
        return false;
    }

    LiteReportHttp(String str) {
        this.mUrl = str;
        this.mCurrentUrl = str;
    }

    public void request(Context context, LiteApiReportRequest liteApiReportRequest, a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                LiteApiLogger.w(TAG, "request start ");
                Map<String, String> mapBuildHeader = buildHeader();
                String strBuildBody = buildBody(context, liteApiReportRequest, mapBuildHeader);
                LiteApiLogger.w(TAG, "request start bodyParams: " + strBuildBody);
                LiteApiLogger.w(TAG, "request start mCurrentUrl: " + this.mCurrentUrl);
                HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(this.mCurrentUrl);
                setConnectionHeader(httpURLConnectionCreateUrlConnection, mapBuildHeader);
                httpURLConnectionCreateUrlConnection.connect();
                new DataOutputStream(httpURLConnectionCreateUrlConnection.getOutputStream()).write(strBuildBody.getBytes());
                int responseCode = httpURLConnectionCreateUrlConnection.getResponseCode();
                LiteApiLogger.w(TAG, "response responseCode :  " + responseCode);
                if (responseCode == 200) {
                    String strInputStream2String = inputStream2String(httpURLConnectionCreateUrlConnection.getInputStream());
                    LiteApiLogger.w(TAG, "response resultStr :  " + strInputStream2String);
                    LiteApiReportResponse liteApiReportResponse = new LiteApiReportResponse();
                    liteApiReportResponse.parseJson(new JSONObject(strInputStream2String));
                    aVar.a(liteApiReportResponse);
                } else {
                    if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    }
                    if (this.currentNum < 21) {
                        this.mCurrentUrl = httpURLConnectionCreateUrlConnection.getHeaderField("Location");
                        this.currentNum++;
                        request(context, liteApiReportRequest, aVar);
                    }
                }
                if (httpURLConnectionCreateUrlConnection != null) {
                    try {
                        httpURLConnectionCreateUrlConnection.disconnect();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                LiteApiLogger.w(TAG, "request Exception e: " + e.getMessage());
                e.printStackTrace();
                aVar.b(e);
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
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

    private void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private String buildBody(Context context, LiteApiReportRequest liteApiReportRequest, Map<String, String> map) {
        String string = liteApiReportRequest.toJson().toString();
        if (disableEncrypt()) {
            map.put("x-ksad-ignore-decrypt", ez.Code);
            return string;
        }
        LiteEncryptHelper.addHeaderParams(context, map);
        JSONObject jSONObject = new JSONObject();
        LiteJsonUtil.putValue(jSONObject, "version", liteApiReportRequest.sdkApiVersion);
        LiteJsonUtil.putValue(jSONObject, "appId", liteApiReportRequest.getAppId());
        LiteJsonUtil.putValue(jSONObject, CrashHianalyticsData.MESSAGE, LiteEncryptHelper.getRequestMessage(context, string));
        LiteEncryptHelper.sigRequest(context, this.mUrl, map, jSONObject.toString());
        return jSONObject.toString();
    }

    private Map<String, String> buildHeader() {
        HashMap map = new HashMap();
        map.put("Accept-Language", bg.Code);
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "application/json; charset=UTF-8");
        map.put("User-Agent", RequestParamsUtils.getUserAgent());
        return map;
    }

    private HttpURLConnection createUrlConnection(String str) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }
}
