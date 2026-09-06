package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: AderUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static boolean a(String str) {
        if (AdSdk.adConfig() != null && AdSdk.adConfig().userAdvertiserId() != null) {
            for (String str2 : AdSdk.adConfig().userAdvertiserId()) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(AdSlot adSlot) {
        try {
            if ((adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getAppendInfo() != null) {
                return ((BaseAdSlot) adSlot).getAppendInfo().isHasVideoStart();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static ResultBean.AdInfo a(BaseAdSlot baseAdSlot) {
        String str = null;
        if (baseAdSlot == null) {
            return null;
        }
        Integer fieldExport = baseAdSlot.getFieldExport();
        if (fieldExport == null) {
            fieldExport = q0.n;
        }
        if (fieldExport == null || fieldExport.intValue() == 0) {
            return null;
        }
        ResultBean.AdInfo adInfo = new ResultBean.AdInfo();
        try {
            if ((fieldExport.intValue() & 1) == 1) {
                adInfo.setCreative_type(baseAdSlot.getAdPatternType() == 2 ? 2 : 1);
            }
            if ((fieldExport.intValue() & 2) == 2) {
                adInfo.setTitle(baseAdSlot.getTitle());
            }
            if ((fieldExport.intValue() & 4) == 4) {
                adInfo.setDesc(baseAdSlot.getDesc());
            }
            if ((fieldExport.intValue() & 8) == 8 && baseAdSlot.getAdPatternType() != 2) {
                adInfo.setImgUrls(baseAdSlot.getImageUrls());
            }
            if ((fieldExport.intValue() & 16) == 16 && baseAdSlot.getAdPatternType() == 2) {
                adInfo.setVideoUrls(baseAdSlot.getImageUrls());
                adInfo.setImgUrls(new String[]{baseAdSlot.getVideo_cover()});
            }
            if ((fieldExport.intValue() & 32) == 32) {
                adInfo.setIconUrl(baseAdSlot.getIcon());
            }
            if ((fieldExport.intValue() & 64) == 64) {
                adInfo.setCid(baseAdSlot.getCid());
            }
            if ((fieldExport.intValue() & 128) == 128) {
                adInfo.setAct_ext(baseAdSlot.getAct_ext());
            }
            if ((fieldExport.intValue() & 256) == 256) {
                adInfo.setDeepLink(baseAdSlot.getDeep_link());
            }
            if ((fieldExport.intValue() & 512) == 512) {
                if (baseAdSlot.getdUrl() != null && baseAdSlot.getdUrl().length > 0) {
                    str = baseAdSlot.getdUrl()[0];
                }
                adInfo.setLandingPageUrl(str);
            }
            if ((fieldExport.intValue() & 1024) == 1024) {
                adInfo.setPackageName(baseAdSlot.getPackageName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adInfo;
    }

    public static boolean a(AdSlot adSlot) {
        try {
            if ((adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getAppendInfo() != null) {
                return ((BaseAdSlot) adSlot).getAppendInfo().isHasExposed();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
