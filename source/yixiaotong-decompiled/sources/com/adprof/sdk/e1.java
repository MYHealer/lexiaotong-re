package com.adprof.sdk;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class e1 implements uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f1139a;

    public e1(f1 f1Var) {
        this.f1139a = f1Var;
    }

    @Override // com.adprof.sdk.uk
    public void a(int i, long j) {
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d5 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:6:0x001e, B:8:0x0023, B:11:0x002f, B:14:0x0037, B:16:0x0049, B:18:0x0051, B:20:0x0063, B:31:0x00de, B:21:0x0075, B:23:0x009c, B:25:0x00a8, B:26:0x00b4, B:28:0x00ba, B:29:0x00c5, B:30:0x00d5), top: B:68:0x001e }] */
    @Override // com.adprof.sdk.uk
    public void a(al alVar) {
        int i;
        String str;
        int i2;
        f1 f1Var = this.f1139a;
        f1Var.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - f1Var.f285a;
        if (!alVar.a() || TextUtils.isEmpty(alVar.f20a)) {
            f1Var.a(alVar.f19a);
            int i3 = f1Var.f1161a;
            if (i3 >= 3) {
                f1Var.a(-5, "配置获取失败");
                return;
            } else {
                f1Var.f1161a = i3 + 1;
                f1Var.a();
                return;
            }
        }
        try {
            String str2 = alVar.f20a;
            String string = str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null;
            if (string == null || string.length() == 0) {
                f1Var.a(410011);
                str = "配置返回格式非法";
                i2 = -6;
            } else {
                String string2 = StringsKt.trim((CharSequence) string).toString();
                if (StringsKt.startsWith$default(string2, "{", false, 2, (Object) null) && StringsKt.endsWith$default(string2, com.alipay.sdk.util.i.d, false, 2, (Object) null)) {
                    JSONObject jSONObject = new JSONObject(string);
                    int iOptInt = jSONObject.optInt("code");
                    jSONObject.optString(CrashHianalyticsData.MESSAGE);
                    if (iOptInt != 0) {
                        f1Var.a(iOptInt);
                        str = "code  = " + iOptInt;
                        i2 = -2;
                    } else {
                        jSONObject.optInt("ct");
                        String strOptString = jSONObject.optString("data");
                        boolean zOptBoolean = jSONObject.optBoolean("encrypted");
                        pk.d(" encrypted =  " + zOptBoolean);
                        if (TextUtils.isEmpty(strOptString)) {
                            f1Var.a(410010);
                            str = "CODE_DATA_EMPTY";
                            i2 = -3;
                        } else {
                            if (zOptBoolean) {
                                strOptString = g1.a(strOptString, AdprofSdk.getInstance().getAppSecret(), false);
                            }
                            if (!TextUtils.isEmpty(strOptString)) {
                                f1Var.a(jCurrentTimeMillis);
                                f1Var.b(strOptString);
                                pk.d("使用服务端配置文件");
                                f1Var.a(strOptString);
                                return;
                            }
                            oh.a("sdk_parse_fail", "", null, null, null);
                            str = "配置解析异常";
                            i2 = -4;
                        }
                    }
                } else {
                    f1Var.a(410011);
                    str = "配置返回格式非法";
                    i2 = -6;
                }
            }
            f1Var.a(i2, str);
        } catch (Throwable th) {
            pk.a(th);
            if (th instanceof UnknownHostException) {
                i = 410001;
            } else if (th instanceof ConnectException) {
                i = 410002;
            } else if (th instanceof SocketTimeoutException) {
                i = 410003;
            } else if (th instanceof SSLException) {
                i = 410004;
            } else if (th instanceof MalformedURLException) {
                i = 410005;
            } else if (th instanceof NoRouteToHostException) {
                i = 410006;
            } else if (th instanceof ProtocolException) {
                i = 410007;
            } else if (th instanceof HttpRetryException) {
                i = 410008;
            } else {
                i = th instanceof SocketException ? 410009 : 410000;
            }
            f1Var.a(i);
            oh.b(th);
        }
    }
}
