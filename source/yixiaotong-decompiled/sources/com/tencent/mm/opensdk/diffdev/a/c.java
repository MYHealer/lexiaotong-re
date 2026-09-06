package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class c extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8545a;
    private String b;
    private OAuthListener c;
    private int d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OAuthErrCode f8546a;
        public String b;
        public int c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f8545a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00cd A[Catch: Exception -> 0x00d2, TryCatch #0 {Exception -> 0x00d2, blocks: (B:20:0x0089, B:22:0x0099, B:26:0x00b3, B:28:0x00b7, B:29:0x00c4, B:33:0x00cf, B:30:0x00c7, B:31:0x00ca, B:32:0x00cd), top: B:63:0x0089 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0124  */
    /* JADX WARN: Code duplicated, block: B:68:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0130 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) throws Throwable {
        a aVar;
        OAuthErrCode oAuthErrCode;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        int i;
        String str;
        String str2;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str3 = this.f8545a;
        if (str3 != null && str3.length() != 0) {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (true) {
                if (isCancelled()) {
                    Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
                    aVar = new a();
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
                } else {
                    String str4 = this.b + (this.d == 0 ? "" : "&last=" + this.d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    byte[] bArrA = com.tencent.mm.opensdk.channel.a.a.a(str4, 60000);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    aVar = new a();
                    Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                    if (bArrA == null || bArrA.length == 0) {
                        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                    } else {
                        try {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArrA, "utf-8"));
                                int i2 = jSONObject.getInt("wx_errcode");
                                aVar.c = i2;
                                Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                                int i3 = aVar.c;
                                if (i3 == 408) {
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.f8546a = oAuthErrCode4;
                                } else if (i3 != 500) {
                                    switch (i3) {
                                        case 402:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                            aVar.f8546a = oAuthErrCode4;
                                            break;
                                        case 403:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                            aVar.f8546a = oAuthErrCode4;
                                            break;
                                        case 404:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                                            aVar.f8546a = oAuthErrCode4;
                                            break;
                                        case 405:
                                            aVar.f8546a = OAuthErrCode.WechatAuth_Err_OK;
                                            aVar.b = jSONObject.getString("wx_code");
                                            break;
                                        default:
                                            oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                            aVar.f8546a = oAuthErrCode4;
                                            break;
                                    }
                                } else {
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    aVar.f8546a = oAuthErrCode4;
                                }
                            } catch (Exception e) {
                                str2 = String.format("parse json fail, ex = %s", e.getMessage());
                                Log.e("MicroMsg.SDK.NoopingResult", str2);
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar.f8546a = oAuthErrCode2;
                            }
                        } catch (Exception e2) {
                            str2 = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                        }
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str4, aVar.f8546a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.f8546a;
                        if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                            i = aVar.c;
                            this.d = i;
                            if (i == d.UUID_SCANED.a()) {
                                this.c.onQrcodeScanned();
                            } else if (aVar.c == d.UUID_KEEP_CONNECT.a() && aVar.c == d.UUID_CONFIRM.a()) {
                                str = aVar.b;
                                if (str != null || str.length() == 0) {
                                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                }
                            }
                        } else {
                            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.c)));
                        }
                    }
                    aVar.f8546a = oAuthErrCode2;
                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str4, aVar.f8546a.toString(), Integer.valueOf(aVar.c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                    oAuthErrCode3 = aVar.f8546a;
                    if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                        i = aVar.c;
                        this.d = i;
                        if (i == d.UUID_SCANED.a()) {
                            this.c.onQrcodeScanned();
                        } else if (aVar.c == d.UUID_KEEP_CONNECT.a()) {
                            continue;
                        } else {
                            str = aVar.b;
                            if (str != null) {
                            }
                            Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        }
                    } else {
                        Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.c)));
                    }
                }
                return aVar;
            }
            aVar.f8546a = oAuthErrCode;
            return aVar;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.f8546a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.f8546a, aVar2.b);
    }
}
