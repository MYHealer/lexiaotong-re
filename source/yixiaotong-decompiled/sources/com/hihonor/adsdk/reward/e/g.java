package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.reward.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends com.hihonor.adsdk.reward.e.a<b> {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3570a;

        static {
            com.hihonor.adsdk.reward.e.a.EnumC0470a.values();
            int[] iArr = new int[4];
            f3570a = iArr;
            try {
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3570a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a2 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL_DOWNLOAD;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3570a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a3 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_LARGE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(BaseAd baseAd) {
        super(baseAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.reward.e.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(View view, Context context) {
        return new p(view, context);
    }

    @Override // com.hihonor.adsdk.reward.e.a
    public int a() {
        int iOrdinal = b().ordinal();
        if (iOrdinal == 0) {
            return R.layout.honor_ads_reward_horizontal_720_1280_02;
        }
        if (iOrdinal != 1) {
            return iOrdinal != 2 ? R.layout.honor_ads_reward_portrait_style1_download : R.layout.honor_ads_reward_portrait_style1;
        }
        return R.layout.honor_ads_reward_horizontal_720_1280_02_download;
    }
}
