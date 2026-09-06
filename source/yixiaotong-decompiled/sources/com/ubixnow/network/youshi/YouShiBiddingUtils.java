package com.ubixnow.network.youshi;

import com.alipay.sdk.util.i;
import com.insightvision.openadsdk.api.FanTiBidLossCode;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class YouShiBiddingUtils {

    public static class YouShiBiddingFeedbackBean {
        public int OooO00o;
        public FanTiBidLossCode OooO0O0;

        public String toString() {
            return "{auctionPrice=" + this.OooO00o + ", lossReason='" + this.OooO0O0 + i.d;
        }
    }

    public static YouShiBiddingFeedbackBean getFailInfo(o00OO0OO o00oo0oo) {
        FanTiBidLossCode fanTiBidLossCode;
        YouShiBiddingFeedbackBean youShiBiddingFeedbackBean = new YouShiBiddingFeedbackBean();
        try {
            if (o00oo0oo.OooO00o) {
                youShiBiddingFeedbackBean.OooO00o = (int) o00oo0oo.OooO0O0;
                fanTiBidLossCode = FanTiBidLossCode.FloorPrice;
            } else {
                youShiBiddingFeedbackBean.OooO00o = (int) o00oo0oo.OooO0Oo.OooO00o;
                fanTiBidLossCode = FanTiBidLossCode.LowPrice;
            }
            youShiBiddingFeedbackBean.OooO0O0 = fanTiBidLossCode;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO00o(oo0O.OooO00o, "优视失败信息上报：" + youShiBiddingFeedbackBean.toString());
        return youShiBiddingFeedbackBean;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    /* JADX WARN: Code duplicated, block: B:9:0x0023 A[DONT_INVERT] */
    public static double getSecondPrice(o00OO0OO o00oo0oo) {
        int i;
        String str;
        StringBuilder sb;
        if (o00oo0oo != null) {
            long j = o00oo0oo.OooO0o0.OooO00o;
            if (j > 0) {
                i = (int) j;
                str = oo0O.OooO00o;
                sb = new StringBuilder("优视成功价格回传价格：");
            } else {
                if (o00oo0oo != null) {
                    i = (int) o00oo0oo.OooO0Oo.OooO00o;
                } else {
                    i = 0;
                }
                str = oo0O.OooO00o;
                sb = new StringBuilder("优视成功价格回传价格：");
            }
        } else {
            if (o00oo0oo != null) {
                i = (int) o00oo0oo.OooO0Oo.OooO00o;
            } else {
                i = 0;
            }
            str = oo0O.OooO00o;
            sb = new StringBuilder("优视成功价格回传价格：");
        }
        ooooO000.OooO00o(str, sb.append(i).toString());
        return i;
    }
}
