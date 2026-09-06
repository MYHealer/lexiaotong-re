package com.ubixnow.network.ubix2;

import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.UBiXWinPlatform;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o00OOO0;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Ubix2BiddingUtils {
    private static void OooO00o(o00OO0OO o00oo0oo, UBiXAdLossInfo uBiXAdLossInfo) {
        try {
            HashSet hashSet = new HashSet();
            o00OOO0 o00ooo0 = o00oo0oo.OooO0Oo.OooO0OO;
            if (o00ooo0 != null && !o00ooo0.OooO0OO.isEmpty()) {
                hashSet.addAll(o00ooo0.OooO0OO);
            }
            uBiXAdLossInfo.adMeta = (String[]) hashSet.toArray(uBiXAdLossInfo.adMeta);
        } catch (Throwable unused) {
        }
    }

    public static UBiXAdLossInfo getFailInfo(o00OO0OO o00oo0oo) {
        String str;
        UBiXAdLossInfo uBiXAdLossInfo = new UBiXAdLossInfo();
        try {
            OooO00o(o00oo0oo, uBiXAdLossInfo);
            if (o00oo0oo.OooO00o) {
                uBiXAdLossInfo.winPrice = (int) o00oo0oo.OooO0O0;
                uBiXAdLossInfo.lossReason = "103";
            } else {
                uBiXAdLossInfo.winPrice = (int) o00oo0oo.OooO0Oo.OooO00o;
                uBiXAdLossInfo.lossReason = "104";
                int i = o00oo0oo.OooO0Oo.OooO0O0;
                if (i == 17) {
                    str = UBiXWinPlatform.PLATFORM_GM;
                } else if (i != 23) {
                    switch (i) {
                        case 1:
                            str = "chuanshanjia";
                            break;
                        case 2:
                            str = UBiXWinPlatform.PLATFORM_GDT;
                            break;
                        case 3:
                            str = UBiXWinPlatform.PLATFORM_KS;
                            break;
                        case 4:
                            str = "jingdong";
                            break;
                        case 5:
                            str = UBiXWinPlatform.PLATFORM_UBIX;
                            break;
                        case 6:
                            str = UBiXWinPlatform.PLATFORM_BD;
                            break;
                        default:
                            str = "other";
                            break;
                    }
                } else {
                    str = UBiXWinPlatform.PLATFORM_QM;
                }
                uBiXAdLossInfo.winPlatform = str;
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return uBiXAdLossInfo;
    }

    public static long getSecondPrice(o00OO0OO o00oo0oo) {
        if (o00oo0oo != null) {
            long j = o00oo0oo.OooO0o0.OooO00o;
            if (j > 0) {
                ooooO000.OooO00o(oo0O.OooO00o, "Merak成功价格回传价格：" + j);
                return j;
            }
        }
        long j2 = o00oo0oo != null ? o00oo0oo.OooO0Oo.OooO00o : 0L;
        ooooO000.OooO00o(oo0O.OooO00o, "Merak成功价格回传价格：" + j2);
        return j2;
    }
}
