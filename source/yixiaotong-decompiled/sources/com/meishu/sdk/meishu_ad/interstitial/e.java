package com.meishu.sdk.meishu_ad.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meishu.sdk.activity.SdkInterstitialActivity;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.view.gif.GifImageView;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: NativeInterstitialAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f5027a;
    public final /* synthetic */ c b;

    public e(c cVar, Activity activity) {
        this.b = cVar;
        this.f5027a = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        try {
            if (!httpResponse.isSuccessful()) {
                a aVar = this.b.b;
                if (aVar != null) {
                    ((com.meishu.sdk.platform.ms.interstitial.a) aVar).onAdRenderFail("load image error", httpResponse.getErrorCode());
                    return;
                }
                return;
            }
            try {
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    a aVar2 = this.b.b;
                    if (aVar2 != null) {
                        ((com.meishu.sdk.platform.ms.interstitial.a) aVar2).onAdRenderFail("load image error", httpResponse.getErrorCode());
                        return;
                    }
                    return;
                }
                this.b.getClass();
                byte[] bArr = new byte[4];
                System.arraycopy(responseBody, 0, bArr, 0, 4);
                if (new BigInteger(1, bArr).toString(16).startsWith(com.huawei.openalliance.ad.constant.x.aw)) {
                    GifImageView gifImageView = new GifImageView(this.f5027a);
                    gifImageView.setBytes(responseBody);
                    this.b.e = gifImageView.getGifHeight();
                    this.b.f = gifImageView.getGifWidth();
                    gifImageView.clear();
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    this.b.f = bitmapDecodeByteArray.getWidth();
                    this.b.e = bitmapDecodeByteArray.getHeight();
                }
                c cVar = this.b;
                if (cVar.e > cVar.f) {
                    cVar.d = 2;
                }
                LogUtil.d("NativeInterstitialAd", "create_type=" + this.b.a().getAdPatternType());
                LogUtil.d("NativeInterstitialAd", "actType=" + this.b.a().getAct_type());
                SdkInterstitialActivity.setSdkAd(this.b);
                SdkInterstitialActivity.setAdWrapper(this.b.f5023a);
                SdkInterstitialActivity.setMsAd(this.b);
                SdkInterstitialActivity.setAdListener(this.b.b);
                Intent intent = new Intent(this.f5027a, (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", ((InterstitialAdLoader) this.b.f5023a.getAdLoader()).getIsVideoAutoPlay());
                intent.putExtra("isClickToClose", ((InterstitialAdLoader) this.b.f5023a.getAdLoader()).getIsClickToClose());
                intent.putExtra("act_type", this.b.a().getAct_type());
                intent.putExtra("layout_type", this.b.d);
                intent.putExtra("layout_width", this.b.f);
                intent.putExtra("layout_height", this.b.e);
                this.f5027a.startActivity(intent);
            } catch (Throwable th) {
                a aVar3 = this.b.b;
                if (aVar3 != null) {
                    ((com.meishu.sdk.platform.ms.interstitial.a) aVar3).onAdRenderFail("load image error", httpResponse.getErrorCode());
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            a aVar4 = this.b.b;
            if (aVar4 != null) {
                ((com.meishu.sdk.platform.ms.interstitial.a) aVar4).onAdRenderFail("load image error", httpResponse.getErrorCode());
            }
            th2.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        a aVar = this.b.b;
        if (aVar != null) {
            ((com.meishu.sdk.platform.ms.interstitial.a) aVar).onAdRenderFail("load image error", -1);
        }
    }
}
