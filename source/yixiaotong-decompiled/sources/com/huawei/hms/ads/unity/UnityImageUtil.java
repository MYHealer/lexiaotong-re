package com.huawei.hms.ads.unity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.common.video.g.a;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.aq;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class UnityImageUtil {
    private static UnityImageUtil I;
    private static final byte[] V = new byte[0];

    /* JADX INFO: renamed from: com.huawei.hms.ads.unity.UnityImageUtil$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[UnityImageType.values().length];
            Code = iArr;
            try {
                iArr[UnityImageType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[UnityImageType.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[UnityImageType.CHOICESINFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private UnityImageUtil() {
    }

    private ImageInfo Code(g gVar, String str, UnityImageType unityImageType) {
        int i = AnonymousClass2.Code[unityImageType.ordinal()];
        if (i == 1) {
            ImageInfo imageInfoZ = gVar.Z();
            if (TextUtils.equals(str, imageInfoZ.Z())) {
                return imageInfoZ;
            }
            return null;
        }
        if (i != 2) {
            return null;
        }
        for (ImageInfo imageInfo : gVar.B()) {
            if (TextUtils.equals(str, imageInfo.Z())) {
                return imageInfo;
            }
        }
        return null;
    }

    public static UnityImageUtil getInstance() {
        UnityImageUtil unityImageUtil;
        synchronized (V) {
            if (I == null) {
                I = new UnityImageUtil();
            }
            unityImageUtil = I;
        }
        return unityImageUtil;
    }

    public void unityLoadImage(final UnityImageDelegate unityImageDelegate, Context context, NativeAd nativeAd, UnityImageType unityImageType) {
        if (unityImageDelegate == null || unityImageDelegate.getUri() == null) {
            return;
        }
        Uri uri = unityImageDelegate.getUri();
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(uri.toString());
        sourceParam.Code(a.hnadsb);
        sourceParam.I(true);
        if (nativeAd == null || !(nativeAd instanceof cd)) {
            return;
        }
        l lVarCode = ((cd) nativeAd).Code();
        final ImageInfo imageInfoCode = Code(lVarCode, uri.toString(), unityImageType);
        if (imageInfoCode == null) {
            fh.Code("UnityImageUtil", "illegal image");
            return;
        }
        sourceParam.V(imageInfoCode.I());
        sourceParam.V(imageInfoCode.S());
        if (lVarCode != null) {
            ac.Code(context, sourceParam, lVarCode.d(), lVarCode.r(), new aq() { // from class: com.huawei.hms.ads.unity.UnityImageUtil.1
                @Override // com.huawei.openalliance.ad.utils.aq
                public void Code() {
                    fh.I("UnityImageUtil", "unity load image fail");
                }

                @Override // com.huawei.openalliance.ad.utils.aq
                public void Code(String str, Drawable drawable) {
                    ImageInfo imageInfo = imageInfoCode;
                    if (imageInfo == null || !TextUtils.equals(str, imageInfo.Z())) {
                        return;
                    }
                    fh.Code("UnityImageUtil", "unity load image success");
                    unityImageDelegate.setDrawable(drawable);
                }
            });
        }
    }
}
