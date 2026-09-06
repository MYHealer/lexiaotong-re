package com.meishu.sdk.core.utils;

import android.graphics.Bitmap;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.IOException;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b0 implements com.meishu.sdk.core.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f4883a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* JADX INFO: compiled from: HttpUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4884a;

        public a(int i) {
            this.f4884a = i;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            b0.this.f4883a.onFailure(new IOException(com.meishu.sdk.activity.a.a("download error1:").append(this.f4884a).toString()));
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f4885a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ Bitmap c;

        public b(byte[] bArr, Bitmap bitmap, Bitmap bitmap2) {
            this.f4885a = bArr;
            this.b = bitmap;
            this.c = bitmap2;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                HttpResponse<byte[]> httpResponse = new HttpResponse<>();
                httpResponse.setSuccessful(true);
                httpResponse.setResponseBody(this.f4885a);
                b0.this.f4883a.a(httpResponse, this.b, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public b0(w wVar, int i, int i2, int i3) {
        this.f4883a = wVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a() {
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a(int i) {
        SdkHandler.runOnMainThread(new a(i));
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        Bitmap bitmap2 = null;
        if (bArr != null) {
            try {
                if (!e0.a(bArr)) {
                    Bitmap[] bitmapArrA = com.meishu.sdk.meishu_ad.v.a(this.b, bitmap, this.c, this.d);
                    if (bitmapArrA.length == 2) {
                        bitmap = bitmapArrA[0];
                        bitmap2 = bitmapArrA[1];
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SdkHandler.runOnMainThread(new b(bArr, bitmap, bitmap2));
    }
}
