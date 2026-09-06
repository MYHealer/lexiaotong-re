package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.reward.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class l extends com.hihonor.adsdk.reward.e.a<b> {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3575a;

        static {
            com.hihonor.adsdk.reward.e.a.EnumC0470a.values();
            int[] iArr = new int[4];
            f3575a = iArr;
            try {
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3575a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a2 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL_DOWNLOAD;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3575a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a3 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_LARGE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f3575a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a4 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_LARGE_DOWNLOAD;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public l(BaseAd baseAd) {
        super(baseAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.reward.e.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(View view, Context context) {
        int iOrdinal = b().ordinal();
        return (iOrdinal == 0 || iOrdinal == 1) ? new t(view, context) : new q(view, context);
    }

    @Override // com.hihonor.adsdk.reward.e.a
    public int a() {
        int iOrdinal = b().ordinal();
        if (iOrdinal == 0) {
            return R.layout.honor_ads_reward_horizontal_1280_720_07;
        }
        if (iOrdinal != 1) {
            return iOrdinal != 2 ? R.layout.honor_ads_reward_portrait_style2_download : R.layout.honor_ads_reward_portrait_style2;
        }
        return R.layout.honor_ads_reward_horizontal_1280_720_07_download;
    }
}
