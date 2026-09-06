package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.nr.m;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        String str_getURL = _getURL();
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                this.mNetClient.startTask(str_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.1
                    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                    public void onCompletion(JSONObject jSONObject, Error error) {
                        HTTPDNS.this._handleResponse(jSONObject, error);
                    }
                });
                return;
            }
        }
        this.mNetClient.startTask(str_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.2
            @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNS.this._handleResponse(jSONObject, error);
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i == 3) {
            sb.append("https://" + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i2 = this.mHttpDNSType;
        if (i2 == 2 || i2 == 1) {
            sb.append("&source=vod");
        }
        return sb.toString();
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        long jCurrentTimeMillis;
        String string;
        String str;
        int i = this.mHttpDNSType;
        String str2 = "";
        int iOptInt = 60;
        if (i == 2 || i == 1) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            iOptInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
            String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
            if (AVMDLDNSParser.mGlobalForceExpiredTime > 0) {
                iOptInt = AVMDLDNSParser.mGlobalForceExpiredTime;
            }
            int i2 = iOptInt;
            jCurrentTimeMillis = System.currentTimeMillis() + ((long) (iOptInt * 1000));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            string = null;
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                try {
                    string = jSONArrayOptJSONArray.getString(i3);
                } catch (Exception e) {
                    m.c(e);
                    string = null;
                }
                if (!TextUtils.isEmpty(string)) {
                    if (TextUtils.isEmpty(str2)) {
                        str = str2 + string;
                    } else {
                        str = str2 + "," + string;
                    }
                    str2 = str;
                }
            }
            iOptInt = i2;
        } else {
            jCurrentTimeMillis = 0;
            string = null;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    if (jSONObject2.has("type") && jSONObject2.getInt("type") == 1) {
                        if (jSONObject2.has("TTL")) {
                            iOptInt = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            string = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str2)) {
                                str2 = str2 + string;
                            } else {
                                str2 = str2 + "," + string;
                            }
                        }
                    }
                }
                String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                if (AVMDLDNSParser.mGlobalForceExpiredTime > 0) {
                    iOptInt = AVMDLDNSParser.mGlobalForceExpiredTime;
                }
                jCurrentTimeMillis = System.currentTimeMillis() + ((long) (iOptInt * 1000));
            } catch (Exception e2) {
                m.c(e2);
                return null;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str2, jCurrentTimeMillis, this.mId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        String.format("****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname);
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            aVMDLDNSInfo2.mErrorStr = error.errStr;
            String.format("handle response receive err:%s", error.errStr);
        } else if (jSONObject == null || jSONObject.length() == 0) {
            new Error(this.mHttpDNSType, this.mHostname, this.mId, String.format("HTTP dns empty, type:%d", Integer.valueOf(this.mHttpDNSType)));
            String.format("json null err", new Object[0]);
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                String.format("handle response exception:%s", th.toString());
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo == null) {
                String.format("info null err", new Object[0]);
            } else {
                String.format("****parse suc for host:%s iplist:%s", this.mHostname, aVMDLDNSInfo.mIpList);
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
        }
        String.format("****parse failed for host:%s", this.mHostname);
        notifyError(aVMDLDNSInfo2);
    }
}
