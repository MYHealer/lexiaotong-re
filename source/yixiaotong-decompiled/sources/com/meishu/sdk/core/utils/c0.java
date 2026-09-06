package com.meishu.sdk.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c0 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoftReference f4889a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    /* JADX INFO: compiled from: HttpUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f4890a;
        public final /* synthetic */ Bitmap b;

        public a(c0 c0Var, ImageView imageView, Bitmap bitmap) {
            this.f4890a = imageView;
            this.b = bitmap;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            this.f4890a.setImageBitmap(this.b);
        }
    }

    public c0(SoftReference softReference, String str, boolean z) {
        this.f4889a = softReference;
        this.b = str;
        this.c = z;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        byte[] responseBody;
        Bitmap bitmapDecodeByteArray;
        ImageView imageView;
        try {
            if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0 || (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length)) == null || (imageView = (ImageView) this.f4889a.get()) == null || imageView.getTag() == null || !imageView.getTag().equals(this.b)) {
                return;
            }
            if (this.c) {
                AdSdk.getContext();
                bitmapDecodeByteArray = e0.a(bitmapDecodeByteArray, 25);
            }
            z.c.post(new a(this, imageView, bitmapDecodeByteArray));
        } catch (Throwable unused) {
        }
    }
}
