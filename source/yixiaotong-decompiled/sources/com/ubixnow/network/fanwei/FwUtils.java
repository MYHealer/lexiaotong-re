package com.ubixnow.network.fanwei;

import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.ptg.adsdk.lib.interf.NativeAdvertData;
import com.ptg.adsdk.lib.interf.PtgNativeExpressAd;
import com.ptg.adsdk.lib.model.AdBidLossReason;
import com.ptg.adsdk.lib.model.PtgImageInfo;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.o0O0o000;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.oo0OOoo;
import com.ubixnow.ooooo.ooooO000;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwUtils {
    /* JADX WARN: Code duplicated, block: B:24:0x0043  */
    public static AdBidLossReason getFailInfo(o00OO0OO o00oo0oo) {
        String str;
        AdBidLossReason adBidLossReason = new AdBidLossReason();
        try {
            if (o00oo0oo.OooO00o) {
                adBidLossReason.setLossCode("1001");
                adBidLossReason.setWinAdnId("-1");
                adBidLossReason.setWinPrice(o00oo0oo.OooO0O0);
            } else {
                adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
                adBidLossReason.setWinPrice(o00oo0oo.OooO0Oo.OooO00o);
                int i = o00oo0oo.OooO0Oo.OooO0O0;
                if (i == 1) {
                    str = "101";
                    adBidLossReason.setWinAdnId(str);
                } else {
                    if (i == 2) {
                        str = "102";
                    } else if (i == 3) {
                        str = "104";
                    } else if (i == 6) {
                        str = "103";
                    } else if (i == 17) {
                        str = "101";
                    } else if (i != 23) {
                        adBidLossReason.setWinAdnId("-1");
                    } else {
                        str = BiddingConst.ADN_ID.QM;
                    }
                    adBidLossReason.setWinAdnId(str);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO00o(oo0O.OooO00o, "Fancy失败上报信息：" + adBidLossReason.getReason());
        return adBidLossReason;
    }

    public static o0O0o0 getMaterialInfo(NativeAdvertData nativeAdvertData, PtgNativeExpressAd ptgNativeExpressAd) {
        if (nativeAdvertData == null) {
            return null;
        }
        try {
            o0O0o000 o0o0o000 = new o0O0o000();
            o0O0o0 o0o0o0 = new o0O0o0(o0o0o000);
            o0o0o000.OooO(nativeAdvertData.getTitle());
            o0o0o000.OooO0o0(nativeAdvertData.getDesc());
            o0o0o000.OooO0OO(nativeAdvertData.getAid() + "");
            o0o0o000.OooO0oo(nativeAdvertData.getLandUrl());
            o0o0o000.OooOO0((nativeAdvertData.getApp() == null || TextUtils.isEmpty(nativeAdvertData.getApp().getName())) ? nativeAdvertData.getBrand() : nativeAdvertData.getApp().getName());
            ArrayList arrayList = new ArrayList();
            o0o0o000.OooO00o(arrayList);
            if (nativeAdvertData.getType() == 2) {
                o0o0o000.OooO00o("1");
                oo0OOoo oo0oooo = new oo0OOoo(1, nativeAdvertData.getVideoUrl(), nativeAdvertData.getWidth(), nativeAdvertData.getHeight());
                oo0oooo.OooO0O0(nativeAdvertData.getVideoCover());
                oo0oooo.OooO0Oo(((int) nativeAdvertData.getDuration()) * 1000);
                if (ptgNativeExpressAd != null && ptgNativeExpressAd.getCustomizeVideo() != null) {
                    oo0oooo.OooO00o(ptgNativeExpressAd.getCustomizeVideo().getVideoUrl());
                    oo0oooo.OooO0O0(ptgNativeExpressAd.getCustomizeVideo().getCoverUrl());
                }
                arrayList.add(oo0oooo);
            } else if (nativeAdvertData.getType() == 1) {
                o0o0o000.OooO00o("2");
                List<PtgImageInfo> imageList = nativeAdvertData.getImageList();
                if (imageList != null) {
                    for (PtgImageInfo ptgImageInfo : imageList) {
                        arrayList.add(new oo0OOoo(2, ptgImageInfo.getImageUrl(), ptgImageInfo.getWidth(), ptgImageInfo.getHeight()));
                    }
                }
            }
            return o0o0o0;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static double[] getSuccMap(o00OO0OO o00oo0oo) {
        double[] dArr = new double[2];
        if (o00oo0oo != null) {
            try {
                long j = o00oo0oo.OooO0o0.OooO00o;
                if (j > 0) {
                    dArr[1] = (int) j;
                } else {
                    dArr[1] = (int) o00oo0oo.OooO0Oo.OooO00o;
                }
                dArr[0] = (int) o00oo0oo.OooO0Oo.OooO00o;
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        ooooO000.OooO00o(oo0O.OooO00o, "Fancy成功价格回传价格：" + Arrays.toString(dArr));
        return dArr;
    }
}
