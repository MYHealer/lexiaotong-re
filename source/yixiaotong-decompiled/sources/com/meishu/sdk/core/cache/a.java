package com.meishu.sdk.core.cache;

import android.graphics.Bitmap;
import android.os.Looper;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.x;
import java.io.IOException;

/* JADX INFO: compiled from: ImageDownloadApiAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static void a(String str, x xVar, boolean z) {
        c.a(str, new C0791a(z, xVar));
    }

    /* JADX INFO: renamed from: com.meishu.sdk.core.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageDownloadApiAdapter.java */
    public class C0791a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4774a;
        public final /* synthetic */ x b;

        /* JADX INFO: renamed from: com.meishu.sdk.core.cache.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageDownloadApiAdapter.java */
        public class C0792a extends l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f4775a;

            public C0792a(byte[] bArr) {
                this.f4775a = bArr;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                C0791a.this.a(this.f4775a);
            }
        }

        /* JADX INFO: renamed from: com.meishu.sdk.core.cache.a$a$b */
        /* JADX INFO: compiled from: ImageDownloadApiAdapter.java */
        public class b extends l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f4776a;

            public b(int i) {
                this.f4776a = i;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                x xVar = C0791a.this.b;
                if (xVar != null) {
                    xVar.onFailure(new IOException(com.meishu.sdk.activity.a.a("download image error2:").append(this.f4776a).toString()));
                }
            }
        }

        public C0791a(boolean z, x xVar) {
            this.f4774a = z;
            this.b = xVar;
        }

        @Override // com.meishu.sdk.core.cache.d
        public void a() {
        }

        @Override // com.meishu.sdk.core.cache.d
        public void a(Bitmap bitmap, byte[] bArr, boolean z) {
            if (Looper.getMainLooper() == Looper.myLooper() || !this.f4774a) {
                a(bArr);
            } else {
                SdkHandler.runOnMainThread(new C0792a(bArr));
            }
        }

        @Override // com.meishu.sdk.core.cache.d
        public void a(int i) {
            try {
                if (Looper.getMainLooper() == Looper.myLooper() || !this.f4774a) {
                    x xVar = this.b;
                    if (xVar != null) {
                        xVar.onFailure(new IOException("download image error2:" + i));
                    }
                } else {
                    SdkHandler.runOnMainThread(new b(i));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void a(byte[] bArr) {
            try {
                if (this.b != null) {
                    HttpResponse<byte[]> httpResponse = new HttpResponse<>();
                    httpResponse.setSuccessful(true);
                    httpResponse.setResponseBody(bArr);
                    this.b.onResponse(httpResponse);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
