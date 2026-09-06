package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4941a = 0;

    /* JADX INFO: compiled from: FileUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f4942a;

        /* JADX INFO: renamed from: com.meishu.sdk.core.utils.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileUtil.java */
        public class C0817a implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f4943a;
            public final /* synthetic */ File b;
            public final /* synthetic */ File c;

            public C0817a(a aVar, CountDownLatch countDownLatch, File file, File file2) {
                this.f4943a = countDownLatch;
                this.b = file;
                this.c = file2;
            }

            @Override // com.meishu.sdk.core.utils.x
            public void onFailure(IOException iOException) {
                this.f4943a.countDown();
            }

            @Override // com.meishu.sdk.core.utils.x
            public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                File file;
                try {
                    if (httpResponse.isSuccessful() && (file = this.b) != null && file.exists() && !this.c.exists()) {
                        this.b.renameTo(this.c);
                    }
                    File file2 = this.b;
                    if (file2 != null && file2.exists()) {
                        this.b.delete();
                    }
                } catch (Throwable unused) {
                }
                this.f4943a.countDown();
            }
        }

        public a(String[] strArr) {
            this.f4942a = strArr;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            for (String str : this.f4942a) {
                if (TextUtils.isEmpty(str)) {
                    int i = s.f4941a;
                    LogUtil.dev("s", "url is null");
                } else {
                    File fileA = com.meishu.sdk.core.bquery.g.a(str, (String) null);
                    if (fileA == null || !fileA.exists()) {
                        File fileA2 = com.meishu.sdk.core.bquery.g.a(str, "fTemp");
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        C0817a c0817a = new C0817a(this, countDownLatch, fileA2, fileA);
                        OkHttpClient okHttpClient = z.f4956a;
                        try {
                            Request requestBuild = new Request.Builder().url(str).build();
                            if (z.b == null) {
                                z.b();
                            }
                            z.b.newCall(requestBuild).enqueue(new a0(c0817a, fileA2));
                        } catch (Throwable th) {
                            try {
                                c0817a.onFailure(new IOException("get file error"));
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            th.printStackTrace();
                        }
                        try {
                            if (countDownLatch.getCount() > 0) {
                                countDownLatch.await(50L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void a(final String[] strArr, com.meishu.sdk.core.loader.d dVar) {
        if (!(dVar instanceof com.meishu.sdk.platform.ms.splash.a)) {
            a(strArr);
            return;
        }
        try {
            b resLoadSuccess = ((com.meishu.sdk.meishu_ad.splash.d) ((com.meishu.sdk.platform.ms.splash.a) dVar).f5177a).getAppendInfo().getResLoadSuccess();
            if (resLoadSuccess.b) {
                a(strArr);
            } else {
                resLoadSuccess.a(new b.a() { // from class: com.meishu.sdk.core.utils.s$$ExternalSyntheticLambda0
                    @Override // com.meishu.sdk.core.utils.b.a
                    public final void a(Object obj, Object obj2) {
                        s.a(strArr, (Boolean) obj, (Boolean) obj2);
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void a(String[] strArr, Boolean bool, Boolean bool2) {
        if (Boolean.TRUE.equals(bool2)) {
            a(strArr);
        }
    }

    public static void a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new a(strArr));
    }
}
