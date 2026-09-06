package com.meishu.sdk.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.bj;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static OkHttpClient f4956a;
    public static OkHttpClient b;
    public static Handler c;
    public static long d;
    public static long e;

    /* JADX INFO: compiled from: HttpUtil.java */
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f4957a;

        /* JADX INFO: renamed from: com.meishu.sdk.core.utils.z$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUtil.java */
        public class C0818a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f4958a;

            public C0818a(IOException iOException) {
                this.f4958a = iOException;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    a.this.f4957a.onFailure(this.f4958a);
                    String[] strArr = ErrorCodeUtil.ERROR_REPORT_URL;
                    if (strArr == null || strArr.length <= 0) {
                        return;
                    }
                    z.a(strArr[0], ErrorCodeUtil.NETWORK_ERROR, this.f4958a.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public a(y yVar) {
            this.f4957a = yVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            z.c.post(new C0818a(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            p0 p0Var = new p0(response.code(), response.isSuccessful());
            response.headers();
            if (responseBodyBody != null) {
                try {
                    p0Var.c = responseBodyBody.string();
                } catch (Throwable th) {
                    p0Var.c = "";
                    th.printStackTrace();
                }
            }
            try {
                try {
                    this.f4957a.a(p0Var);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                response.close();
            }
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4959a;

        /* JADX INFO: compiled from: HttpUtil.java */
        public class a extends com.meishu.sdk.core.safe.l {
            public a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    i iVar = b.this.f4959a;
                    if (iVar != null) {
                        iVar.a();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: renamed from: com.meishu.sdk.core.utils.z$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUtil.java */
        public class C0819b extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Response f4961a;

            public C0819b(Response response) {
                this.f4961a = response;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    if (this.f4961a.isSuccessful()) {
                        i iVar = b.this.f4959a;
                        if (iVar != null) {
                            iVar.success();
                        }
                    } else {
                        i iVar2 = b.this.f4959a;
                        if (iVar2 != null) {
                            iVar2.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        i iVar3 = b.this.f4959a;
                        if (iVar3 != null) {
                            iVar3.a();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public b(i iVar) {
            this.f4959a = iVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            SdkHandler.runOnMainThread(new a());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            SdkHandler.runOnMainThread(new C0819b(response));
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class c extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4962a;

        public c(i iVar) {
            this.f4962a = iVar;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                i iVar = this.f4962a;
                if (iVar != null) {
                    iVar.a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class d implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f4963a;

        /* JADX INFO: compiled from: HttpUtil.java */
        public class a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f4964a;

            public a(IOException iOException) {
                this.f4964a = iOException;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                d.this.f4963a.onFailure(this.f4964a);
                String[] strArr = ErrorCodeUtil.ERROR_REPORT_URL;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                z.a(strArr[0], ErrorCodeUtil.NETWORK_ERROR, this.f4964a.toString());
            }
        }

        public d(x xVar) {
            this.f4963a = xVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            LogUtil.e("HttpUtil", com.meishu.sdk.activity.a.a("e=").append(iOException.getMessage()).toString());
            z.c.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            HttpResponse<byte[]> httpResponse = new HttpResponse<>();
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    byte[] bArrBytes = responseBodyBody.bytes();
                    httpResponse.setSuccessful(true);
                    httpResponse.setErrorCode(response.code());
                    httpResponse.setHeader(response.headers());
                    httpResponse.setResponseBody(bArrBytes);
                } else {
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    httpResponse.setErrorDescription("bad file");
                }
            } else {
                httpResponse.setSuccessful(false);
                httpResponse.setErrorCode(response.code());
                httpResponse.setErrorDescription(response.message());
            }
            try {
                this.f4963a.onResponse(httpResponse);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class e implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f4965a;

        /* JADX INFO: compiled from: HttpUtil.java */
        public class a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f4966a;

            public a(IOException iOException) {
                this.f4966a = iOException;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                e.this.f4965a.onFailure(this.f4966a);
            }
        }

        /* JADX INFO: compiled from: HttpUtil.java */
        public class b extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p0 f4967a;

            public b(p0 p0Var) {
                this.f4967a = p0Var;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    e.this.f4965a.a(this.f4967a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public e(y yVar) {
            this.f4965a = yVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new a(iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            p0 p0Var = new p0(response.code(), response.isSuccessful());
            response.headers();
            if (responseBodyBody != null) {
                try {
                    p0Var.c = responseBodyBody.string();
                } catch (Throwable th) {
                    p0Var.c = "";
                    th.printStackTrace();
                }
            }
            response.close();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new b(p0Var));
                return;
            }
            try {
                this.f4965a.a(p0Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class f implements y<p0> {
        @Override // com.meishu.sdk.core.utils.y
        public /* bridge */ /* synthetic */ void a(p0 p0Var) throws IOException {
        }

        @Override // com.meishu.sdk.core.utils.y
        public void onFailure(IOException iOException) {
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class g implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4968a;
        public final /* synthetic */ x b;

        /* JADX INFO: compiled from: HttpUtil.java */
        public class a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f4969a;

            public a(IOException iOException) {
                this.f4969a = iOException;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    g.this.b.onFailure(this.f4969a);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* JADX INFO: compiled from: HttpUtil.java */
        public class b extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HttpResponse f4970a;

            public b(HttpResponse httpResponse) {
                this.f4970a = httpResponse;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    g.this.b.onResponse(this.f4970a);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public g(boolean z, x xVar) {
            this.f4968a = z;
            this.b = xVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper() && this.f4968a) {
                z.c.post(new a(iOException));
                return;
            }
            try {
                this.b.onFailure(iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            HttpResponse<byte[]> httpResponse = new HttpResponse<>();
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    try {
                        byte[] bArrBytes = responseBodyBody.bytes();
                        httpResponse.setSuccessful(true);
                        httpResponse.setResponseBody(bArrBytes);
                    } catch (Throwable unused) {
                        httpResponse.setSuccessful(false);
                        httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
                        httpResponse.setErrorDescription("read response error");
                    }
                } else {
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    httpResponse.setErrorDescription("bad file");
                }
            } else {
                httpResponse.setSuccessful(false);
                httpResponse.setErrorCode(response.code());
                httpResponse.setErrorDescription(response.message());
            }
            response.close();
            if (Looper.myLooper() != Looper.getMainLooper() && this.f4968a) {
                z.c.post(new b(httpResponse));
                return;
            }
            try {
                this.b.onResponse(httpResponse);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class h extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f4971a;

        public h(x xVar) {
            this.f4971a = xVar;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            this.f4971a.onFailure(new IOException("get file error"));
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public interface i {
        void a();

        void success();
    }

    static {
        MediaType.parse("text/x-markdown; charset=utf-8");
        MediaType.parse(bj.Z);
        MediaType.parse("audio/mp3");
        MediaType.parse("video/mp4");
        MediaType.parse("application/octet-stream");
        MediaType.parse("application/json; charset=utf-8");
        c = new Handler(Looper.getMainLooper());
        d = System.currentTimeMillis();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f4956a = builder.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).dns(new t("sdk.1rtb.net")).build();
        e = System.currentTimeMillis();
    }

    public static OkHttpClient a() {
        b();
        return b;
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, y<p0> yVar) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request.Builder builderUrl = new Request.Builder().url(httpUrl.newBuilder().build());
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            builderUrl.post(builder.build());
            Request requestBuild = builderUrl.build();
            LogUtil.d("HttpUtil", "url[" + requestBuild.url().url().toString() + "]");
            f4956a.newCall(requestBuild).enqueue(new a(yVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b() {
        if (b != null) {
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build();
    }

    public static void b(Context context, String[] strArr, Map<String, Object> map) {
        if (strArr == null) {
            return;
        }
        try {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String strReplace = strArr[i2];
                if (map != null) {
                    if (map.containsKey("expectCostPrice")) {
                        Object obj = map.get("expectCostPrice");
                        if (a(obj)) {
                            strReplace = strReplace.replace("__MS_WIN_PRICE__", h0.b(obj + ""));
                        }
                    }
                    if (map.containsKey("highestLossPrice") && a(map.get("highestLossPrice"))) {
                        strReplace = strReplace.replace("__MS_LOSS_PRICE__", h0.b(map.get("highestLossPrice") + ""));
                    }
                }
                a(context, strReplace, new com.meishu.sdk.core.utils.i());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Request request, x xVar) {
        if (request == null) {
            return;
        }
        try {
            LogUtil.d("HttpUtil", "url[" + request.url().url().toString() + "]");
            f4956a.newCall(request).enqueue(new d(xVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Map<String, String> map, y<p0> yVar) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request requestBuild = new Request.Builder().url(httpUrl.newBuilder().build()).get().build();
            LogUtil.d("HttpUtil", "url[" + requestBuild.url().url().toString() + "]");
            f4956a.newCall(requestBuild).enqueue(new e(yVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Map<String, String> map, com.meishu.sdk.core.utils.i iVar) {
        try {
            Headers.Builder builder = new Headers.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request requestBuild = new Request.Builder().headers(builder.build()).url(httpUrl.newBuilder().build()).get().build();
            if (b == null) {
                b();
            }
            LogUtil.d("HttpUtil", "url[" + requestBuild.url().url().toString() + "]");
            b.newCall(requestBuild).enqueue(new d0(iVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, com.meishu.sdk.core.utils.i iVar) {
        try {
            HashMap map = new HashMap();
            String strN = x0.n(context);
            map.put(HttpHeaders.X_REQUESTED_WITH, "");
            map.put("User-Agent", strN != null ? strN : "");
            a(str, map, iVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Integer num, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (num == null) {
            num = -1;
        }
        int iIntValue = num.intValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = {"__ERROR_CODE__", "__ERROR_MESSAGE__", "__MS_EVENT_SEC__", "__MS_EVENT_MSEC__"};
        String[] strArr2 = new String[4];
        strArr2[0] = iIntValue != 0 ? String.valueOf(iIntValue) : "__ERROR_CODE__";
        if (TextUtils.isEmpty(str2)) {
            str2 = "__ERROR_MESSAGE__";
        }
        strArr2[1] = str2;
        strArr2[2] = String.valueOf(jCurrentTimeMillis / 1000);
        strArr2[3] = String.valueOf(jCurrentTimeMillis);
        String string = TextUtils.replace(str, strArr, strArr2).toString();
        LogUtil.d("HttpUtil", "错误上报： " + string);
        a(string, (Map<String, String>) null, new f());
    }

    public static void a(String str, x xVar, boolean z) {
        try {
            Request requestBuild = new Request.Builder().url(str).build();
            if (b == null) {
                b();
            }
            b.newCall(requestBuild).enqueue(new g(z, xVar));
        } catch (Throwable th) {
            if (Looper.myLooper() != Looper.getMainLooper() && z) {
                c.post(new h(xVar));
            } else {
                try {
                    xVar.onFailure(new IOException("get file error"));
                } catch (Exception unused) {
                    th.printStackTrace();
                }
            }
            th.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr, Map<String, Object> map) {
        if (strArr == null) {
            return;
        }
        try {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String strReplace = strArr[i2];
                if (map != null) {
                    if (map.containsKey("winPrice") && a(map.get("winPrice"))) {
                        strReplace = strReplace.replace("__MS_WIN_PRICE__", h0.b(map.get("winPrice") + ""));
                    }
                    if (map.containsKey("lossReason")) {
                        String str = map.get("lossReason") + "";
                        if ("1".equals(str) || "101".equals(str) || "10001".equals(str)) {
                            strReplace = strReplace.replace("__MS_LOSS_REASON__", h0.b(str));
                        }
                    }
                    if (map.containsKey("adnId")) {
                        String str2 = map.get("adnId") + "";
                        if ("1".equals(str2) || "2".equals(str2) || "3".equals(str2) || "4".equals(str2)) {
                            strReplace = strReplace.replace("__MS_ADN_ID__", str2);
                        }
                    }
                }
                a(context, strReplace, new com.meishu.sdk.core.utils.i());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float)) {
            return true;
        }
        if (obj instanceof String) {
            try {
                Double.parseDouble((String) obj);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void a(String str, i iVar) {
        try {
            b.newCall(new Request.Builder().url(str).head().build()).enqueue(new b(iVar));
        } catch (Exception e2) {
            e2.printStackTrace();
            SdkHandler.runOnMainThread(new c(iVar));
        }
    }
}
