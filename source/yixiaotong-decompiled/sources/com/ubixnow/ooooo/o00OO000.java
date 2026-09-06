package com.ubixnow.ooooo;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00OO000 extends o00OO0O0 {
    public long biddingLossWinPrice;
    public long biddingWinSecondPrice;
    public o00OOO00 feedBackEventListener;
    public String feedBackFailRequestId;
    public boolean isReportFail;
    public boolean isReportSucc;
    public int platformId;

    public class OooO00o implements o00OOO00 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o00OOO00
        public void OooO00o(String str) {
            if (Objects.equals(o00OO000.this.feedBackFailRequestId, str)) {
                o00OO000.this.notifyShow();
            }
        }

        @Override // com.ubixnow.ooooo.o00OOO00
        public void OooO0O0(String str) {
            if (Objects.equals(o00OO000.this.feedBackFailRequestId, str)) {
                o00OO000.this.notifyClick();
            }
        }
    }

    private void initKsFeedbackListener(o00OO0OO o00oo0oo, String str) {
        if (o00oo0oo.OooO00o || this.platformId != 3) {
            return;
        }
        this.feedBackFailRequestId = str;
        this.feedBackEventListener = new OooO00o();
    }

    public void biddingLoss(o00OO0OO o00oo0oo, String str) {
        if (this.isReportFail) {
            return;
        }
        this.isReportFail = true;
        this.biddingLossWinPrice = o00oo0oo.OooO0Oo.OooO00o;
        ooooO000.OooO00o(oo0O.OooO00o, "广告源失败上报：一价：" + o00oo0oo.OooO0Oo.OooO00o);
        o00oo0oo.OooO0OO = str;
        initKsFeedbackListener(o00oo0oo, str);
        notifyLoss(o00oo0oo);
    }

    public void biddingWin(o00OO0OO o00oo0oo) {
        if (this.isReportSucc) {
            return;
        }
        this.isReportSucc = true;
        long j = o00oo0oo.OooO0o0.OooO00o;
        if (j == 0) {
            j = o00oo0oo.OooO0Oo.OooO00o;
        }
        this.biddingWinSecondPrice = j;
        ooooO000.OooO00o(oo0O.OooO00o, "广告源成功上报信息：一价：" + o00oo0oo.OooO0Oo.OooO00o + " 二价：" + o00oo0oo.OooO0o0.OooO00o + " 广告源：" + o00oo0oo.OooO0Oo.OooO0O0);
        notifyWin(o00oo0oo);
    }

    public void notifyClick() {
    }

    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    public void notifyShow() {
    }

    public void notifyWin(o00OO0OO o00oo0oo) {
    }
}
