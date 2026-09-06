package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.reward.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j extends com.hihonor.adsdk.reward.e.a<b> {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3573a;

        static {
            com.hihonor.adsdk.reward.e.a.EnumC0470a.values();
            int[] iArr = new int[4];
            f3573a = iArr;
            try {
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL_DOWNLOAD;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3573a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a2 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_LARGE_DOWNLOAD;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3573a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a3 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_LARGE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f3573a;
                com.hihonor.adsdk.reward.e.a.EnumC0470a enumC0470a4 = com.hihonor.adsdk.reward.e.a.EnumC0470a.LAYOUT_NORMAL;
                iArr4[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public j(BaseAd baseAd) {
        super(baseAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.reward.e.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(View view, Context context) {
        return com.hihonor.adsdk.reward.c.a() ? new s(view, context) : new u(view, context);
    }

    @Override // com.hihonor.adsdk.reward.e.a
    public int a() {
        int iOrdinal = b().ordinal();
        return (iOrdinal == 1 || iOrdinal == 3) ? R.layout.honor_ads_reward_portrait_style2_download : R.layout.honor_ads_reward_portrait_style2;
    }
}
