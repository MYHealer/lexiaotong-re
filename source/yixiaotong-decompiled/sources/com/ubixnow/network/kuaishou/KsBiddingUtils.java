package com.ubixnow.network.kuaishou;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.br;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdnName;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o00OOO0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsBiddingUtils {
    private static String OooO00o = "----KsBiddingUtils";

    private static void OooO00o(o00OO0OO o00oo0oo, AdExposureFailedReason adExposureFailedReason) {
        try {
            if (!TextUtils.isEmpty(o00oo0oo.OooO0OO)) {
                adExposureFailedReason.setAdRequestId(o00oo0oo.OooO0OO);
            }
            o00OOO0 o00ooo0 = o00oo0oo.OooO0Oo.OooO0OO;
            if (o00ooo0 != null) {
                if (!TextUtils.isEmpty(o00ooo0.OooO00o)) {
                    adExposureFailedReason.setAdTitle(o00ooo0.OooO00o);
                }
                if (TextUtils.isEmpty(o00ooo0.OooO0O0)) {
                    return;
                }
                adExposureFailedReason.setAdUserName(o00ooo0.OooO0O0);
            }
        } catch (Throwable unused) {
        }
    }

    private static void OooO00o(String str, int i, String str2, AdExposureFailedReason adExposureFailedReason) {
        if (!ooooO000.OooO00o || adExposureFailedReason == null) {
            return;
        }
        try {
            ooooO000.OooO0OO(OooO00o, "竞价回传_notify: ads_slot_id='" + str + "', event='" + str2 + "', FailureCode='" + i + "', adnName='" + adExposureFailedReason.adnName + "', adnType='" + adExposureFailedReason.adnType + "', winEcpm=" + adExposureFailedReason.winEcpm + ", adTitle='" + adExposureFailedReason.adTitle + "', adUserName='" + adExposureFailedReason.adUserName + "', adRequestId='" + adExposureFailedReason.adRequestId + "', isShow=" + adExposureFailedReason.isShow + ", isClick=" + adExposureFailedReason.isClick);
        } catch (Throwable th) {
            ooooO000.OooO0OO(OooO00o, "竞价回传_notify: ads_slot_id='" + str + "', event='" + str2 + "', FailureCode='" + i + "', adnName='" + adExposureFailedReason.adnName + "', adnType='" + adExposureFailedReason.adnType + "', winEcpm=" + adExposureFailedReason.winEcpm + "', Throwable=" + th);
        }
    }

    public static AdExposureFailedReason getFailInfo(o00OO0OO o00oo0oo) {
        String str;
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        try {
            OooO00o(o00oo0oo, adExposureFailedReason);
            if (!o00oo0oo.OooO00o) {
                adExposureFailedReason.winEcpm = (int) o00oo0oo.OooO0Oo.OooO00o;
                int i = o00oo0oo.OooO0Oo.OooO0O0;
                if (i == 1) {
                    adExposureFailedReason.adnType = 2;
                    str = "chuanshanjia";
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            adExposureFailedReason.adnType = 1;
                        } else if (i == 5) {
                            adExposureFailedReason.adnType = 3;
                        } else if (i == 6) {
                            adExposureFailedReason.adnType = 2;
                            str = "baidu";
                        }
                        return adExposureFailedReason;
                    }
                    adExposureFailedReason.adnType = 2;
                    str = AdnName.GUANGDIANTONG;
                }
                adExposureFailedReason.adnName = str;
                return adExposureFailedReason;
            }
            adExposureFailedReason.winEcpm = (int) o00oo0oo.OooO0O0;
            adExposureFailedReason.adnType = 2;
            str = "other";
            adExposureFailedReason.adnName = str;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return adExposureFailedReason;
    }

    public static long getFirstPrice(o00OO0OO o00oo0oo) {
        if (o00oo0oo != null) {
            long j = o00oo0oo.OooO0Oo.OooO00o;
            if (j > 0) {
                return j;
            }
        }
        return 0L;
    }

    public static void notifyClick(String str, AdExposureFailedReason adExposureFailedReason, Object obj) {
        if (adExposureFailedReason == null || obj == null) {
            return;
        }
        try {
            if (adExposureFailedReason.isClick == 0) {
                adExposureFailedReason.setIsClick(1);
                if (obj instanceof KsSplashScreenAd) {
                    ((KsSplashScreenAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsInterstitialAd) {
                    ((KsInterstitialAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsRewardVideoAd) {
                    ((KsRewardVideoAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof com.kwad.sdk.api.KsNativeAd) {
                    ((com.kwad.sdk.api.KsNativeAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsFeedAd) {
                    ((KsFeedAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsBannerAd) {
                    ((KsBannerAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                }
                OooO00o(str, 2, "click", adExposureFailedReason);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public static AdExposureFailedReason notifyLoss(String str, o00OO0OO o00oo0oo, Object obj) {
        if (obj == null || o00oo0oo == null) {
            return null;
        }
        try {
            int i = o00oo0oo.OooO00o ? 1 : 2;
            AdExposureFailedReason failInfo = getFailInfo(o00oo0oo);
            if (obj instanceof KsSplashScreenAd) {
                ((KsSplashScreenAd) obj).reportAdExposureFailed(i, failInfo);
            } else if (obj instanceof KsInterstitialAd) {
                ((KsInterstitialAd) obj).reportAdExposureFailed(i, failInfo);
            } else if (obj instanceof KsRewardVideoAd) {
                ((KsRewardVideoAd) obj).reportAdExposureFailed(i, failInfo);
            } else if (obj instanceof com.kwad.sdk.api.KsNativeAd) {
                ((com.kwad.sdk.api.KsNativeAd) obj).reportAdExposureFailed(i, failInfo);
            } else if (obj instanceof KsFeedAd) {
                ((KsFeedAd) obj).reportAdExposureFailed(i, failInfo);
            } else if (obj instanceof KsBannerAd) {
                ((KsBannerAd) obj).reportAdExposureFailed(i, failInfo);
            }
            OooO00o(str, i, "loss", failInfo);
            return failInfo;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return null;
        }
    }

    public static void notifyShow(String str, AdExposureFailedReason adExposureFailedReason, Object obj) {
        if (adExposureFailedReason == null || obj == null) {
            return;
        }
        try {
            if (adExposureFailedReason.isShow == 0) {
                adExposureFailedReason.setIsShow(1);
                if (obj instanceof KsSplashScreenAd) {
                    ((KsSplashScreenAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsInterstitialAd) {
                    ((KsInterstitialAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsRewardVideoAd) {
                    ((KsRewardVideoAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof com.kwad.sdk.api.KsNativeAd) {
                    ((com.kwad.sdk.api.KsNativeAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsFeedAd) {
                    ((KsFeedAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                } else if (obj instanceof KsBannerAd) {
                    ((KsBannerAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
                }
                OooO00o(str, 2, br.b.V, adExposureFailedReason);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public static void notifyWin(o00OO0OO o00oo0oo, Object obj) {
        try {
            long firstPrice = getFirstPrice(o00oo0oo);
            ooooO000.OooO0OO(OooO00o, "快手成功价格回传价格：" + firstPrice);
            if (obj instanceof KsSplashScreenAd) {
                ((KsSplashScreenAd) obj).setBidEcpm(firstPrice, firstPrice);
            } else if (obj instanceof KsInterstitialAd) {
                ((KsInterstitialAd) obj).setBidEcpm(firstPrice, firstPrice);
            } else if (obj instanceof KsRewardVideoAd) {
                ((KsRewardVideoAd) obj).setBidEcpm(firstPrice, firstPrice);
            } else if (obj instanceof com.kwad.sdk.api.KsNativeAd) {
                ((com.kwad.sdk.api.KsNativeAd) obj).setBidEcpm(firstPrice, firstPrice);
            } else if (obj instanceof KsFeedAd) {
                ((KsFeedAd) obj).setBidEcpm(firstPrice, firstPrice);
            } else if (obj instanceof KsBannerAd) {
                ((KsBannerAd) obj).setBidEcpm(firstPrice, firstPrice);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
