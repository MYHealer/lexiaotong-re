package com.ubixnow.network.qumeng;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ubix.ssp.open.UBiXWinPlatform;
import com.ubixnow.ooooo.o00OO;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmBiddingUtils {

    public static class QmBiddingFeedbackBean {
        public int OooO00o;
        public String OooO0O0 = "";
        public String OooO0OO = "";

        public String toString() {
            return "{auctionPrice=" + this.OooO00o + ", lossReason='" + this.OooO0O0 + "', winBidder='" + this.OooO0OO + "'}";
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0028. Please report as an issue. */
    public static QmBiddingFeedbackBean getFailInfo(o00OO0OO o00oo0oo) {
        String str;
        QmBiddingFeedbackBean qmBiddingFeedbackBean = new QmBiddingFeedbackBean();
        try {
            if (!o00oo0oo.OooO00o) {
                o00OO o00oo = o00oo0oo.OooO0Oo;
                qmBiddingFeedbackBean.OooO00o = (int) o00oo.OooO00o;
                qmBiddingFeedbackBean.OooO0O0 = "101";
                int i = o00oo.OooO0O0;
                if (i != 23) {
                    switch (i) {
                        case 1:
                            str = "toutiao";
                            break;
                        case 2:
                            str = MediationConstant.ADN_GDT;
                            break;
                        case 3:
                            str = UBiXWinPlatform.PLATFORM_KS;
                            break;
                        case 4:
                            str = "jingdong";
                            break;
                        case 5:
                            str = "zs";
                            break;
                        case 6:
                            str = "baidu";
                            break;
                        default:
                            break;
                    }
                    ooooO000.OooO00o(oo0O.OooO00o, "趣盟失败信息上报：" + qmBiddingFeedbackBean.toString());
                    return qmBiddingFeedbackBean;
                }
                str = UBiXWinPlatform.PLATFORM_QM;
                qmBiddingFeedbackBean.OooO0OO = str;
                ooooO000.OooO00o(oo0O.OooO00o, "趣盟失败信息上报：" + qmBiddingFeedbackBean.toString());
                return qmBiddingFeedbackBean;
            }
            qmBiddingFeedbackBean.OooO00o = (int) o00oo0oo.OooO0O0;
            qmBiddingFeedbackBean.OooO0O0 = "100";
            qmBiddingFeedbackBean.OooO0OO = "other";
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO00o(oo0O.OooO00o, "趣盟失败信息上报：" + qmBiddingFeedbackBean.toString());
        return qmBiddingFeedbackBean;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:11:0x002a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022 A[DONT_INVERT] */
    public static int getSecondPrice(o00OO0OO o00oo0oo) {
        int i;
        String str;
        StringBuilder sb;
        if (o00oo0oo != null) {
            long j = o00oo0oo.OooO0o0.OooO00o;
            if (j > 0) {
                i = (int) j;
                str = oo0O.OooO00o;
                sb = new StringBuilder("趣盟成功价格回传价格：");
            } else {
                if (o00oo0oo != null) {
                    i = (int) o00oo0oo.OooO0Oo.OooO00o;
                } else {
                    i = 0;
                }
                str = oo0O.OooO00o;
                sb = new StringBuilder("趣盟成功价格回传价格：");
            }
        } else {
            if (o00oo0oo != null) {
                i = (int) o00oo0oo.OooO0Oo.OooO00o;
            } else {
                i = 0;
            }
            str = oo0O.OooO00o;
            sb = new StringBuilder("趣盟成功价格回传价格：");
        }
        ooooO000.OooO00o(str, sb.append(i).toString());
        return i;
    }
}
