package com.meishu.sdk.core.exception;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.icbc.paysdk.webview.ICBCWebChromeClient;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.x0;
import com.meishu.sdk.core.utils.z;
import com.umeng.analytics.pro.am;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: UncaughtExceptionProcessor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f4794a;
    public static boolean b;

    /* JADX INFO: renamed from: com.meishu.sdk.core.exception.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UncaughtExceptionProcessor.java */
    public class C0795a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4795a;
        public final /* synthetic */ CountDownLatch b;

        public C0795a(boolean z, CountDownLatch countDownLatch) {
            this.f4795a = z;
            this.b = countDownLatch;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            LogUtil.dev("UncaughtExceptionProcessor", iOException);
            if (this.f4795a) {
                this.b.countDown();
            }
            LogUtil.e("UncaughtExceptionProcessor", "uploadException error ");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (this.f4795a) {
                this.b.countDown();
            }
        }
    }

    /* JADX INFO: compiled from: UncaughtExceptionProcessor.java */
    public static class b implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f4796a;
        public boolean b;
        public Thread.UncaughtExceptionHandler c;

        public b(Context context, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f4796a = context;
            this.b = z;
            this.c = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                a.a(this.f4796a, this.b, thread, th, true);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f4794a = arrayList;
        b = true;
        arrayList.add("pid");
        arrayList.add(com.hihonor.adsdk.base.g.j.e.a.hnadsn);
        arrayList.add("device_os");
        arrayList.add("app_id");
        arrayList.add("app_name");
        arrayList.add("app_ver");
        arrayList.add("device_ppi");
        arrayList.add("device_width");
        arrayList.add("device_height");
        arrayList.add("device_density");
        arrayList.add("device_type_os");
        arrayList.add("device_api_level");
        arrayList.add(am.H);
        arrayList.add(am.F);
        arrayList.add("device_model");
        arrayList.add("device_network");
        arrayList.add("sdk_version");
        arrayList.add(com.hihonor.adsdk.base.g.j.e.a.hnadsy);
        arrayList.add("accept_ad_type");
        arrayList.add("device_rom_version");
        arrayList.add("device_performance");
        arrayList.add("device_disk_total");
        arrayList.add("device_disk_free");
        arrayList.add("device_font_size");
        arrayList.add("device_cpu_model");
        arrayList.add("accept_act_type");
    }

    public static void a(Throwable th) {
        try {
            a(AdSdk.getContext(), AdSdk.adConfig() != null ? AdSdk.adConfig().isTest() : false, Thread.currentThread(), th, false);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, boolean z, Thread thread, Throwable th, boolean z2) {
        try {
            Map<String, String> mapA = x0.a(context, null, null, 0L, 0L);
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry entry : ((HashMap) mapA).entrySet()) {
                if (f4794a.contains(entry.getKey())) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
            }
            builder.add("thread", thread.getName());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            builder.add(CrashHianalyticsData.MESSAGE, new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8")));
            builder.add("env", z ? "test" : IAdInterListener.AdReqParam.PROD);
            builder.add(ICBCWebChromeClient.JAVASCRIPT_COMMON_VALUE_FUNCTION, z2 ? "0" : "1");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Request requestBuild = new Request.Builder().url("https://sdk-report.1rtb.com/reports").post(builder.build()).build();
            C0795a c0795a = new C0795a(z2, countDownLatch);
            if (z.b == null) {
                z.b();
            }
            z.b.newCall(requestBuild).enqueue(c0795a);
            if (z2) {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            }
        } catch (Throwable unused) {
        }
    }
}
