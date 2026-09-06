package com.yfanads.android.core.reward;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFRewardServerCallBackInf {
    public RewardInf rewardInf;

    public static class BDRewardInf extends RewardInf {
        public boolean bdRewardVerify;

        public BDRewardInf(boolean z) {
            super(Type.BD);
            this.bdRewardVerify = z;
        }
    }

    public static class BXRewardInf extends RewardInf {
        public double amount;
        public String extraInfo;
        public boolean isRewardValid;
        public String transId;
        public String type;
        public String userId;

        public BXRewardInf() {
            super(Type.NC);
        }
    }

    public static class CsjRewardInf extends RewardInf {
        public int code;
        public String message;
        public int rewardAmount;
        public String rewardName;
        public float rewardPropose;
        public int rewardType;
        public boolean rewardVerify;

        public CsjRewardInf(boolean z, int i, int i2, String str, float f, int i3, String str2) {
            super(Type.CSJ);
            this.rewardVerify = z;
            this.rewardType = i;
            this.rewardAmount = i2;
            this.rewardName = str;
            this.rewardPropose = f;
            this.code = i3;
            this.message = str2;
        }
    }

    public static class GERewardInf extends RewardInf {
        public boolean verify;

        public GERewardInf(boolean z) {
            super(Type.GE);
            this.verify = z;
        }
    }

    public static class JCRewardInf extends RewardInf {
        public int errorCode;
        public String errorMsg;
        public boolean isValid;
        public String rewardAmount;
        public String rewardName;
        public String transId;
        public String userId;

        public JCRewardInf() {
            super(Type.JC);
        }

        public JCRewardInf(boolean z, String str, String str2, String str3, String str4, int i, String str5) {
            super(Type.JC);
            this.isValid = z;
            this.userId = str;
            this.transId = str2;
            this.rewardName = str3;
            this.rewardAmount = str4;
            this.errorCode = i;
            this.errorMsg = str5;
        }
    }

    public static class KsRewardInf extends RewardInf {
        public KsRewardInf() {
            super(Type.KS);
        }
    }

    public static class RewardInf {
        public Map<String, Object> appExtra;
        public Type type;

        public RewardInf(Type type) {
            this.type = type;
        }

        public void setAppExtra(Map<String, Object> map) {
            this.appExtra = map;
        }
    }

    public static class RyRewardInf extends RewardInf {
        public double amount;
        public String type;

        public RyRewardInf(String str, double d) {
            super(Type.RY);
            this.amount = d;
            this.type = str;
        }
    }

    @Deprecated
    public static class TanxRewardInf extends RewardInf {
        public boolean rewardVerify;

        public TanxRewardInf(boolean z) {
            super(Type.TANX);
            this.rewardVerify = z;
        }
    }

    public enum Type {
        KS,
        YLH,
        BD,
        CSJ,
        ADX,
        XM,
        OPPO,
        HW,
        VIVO,
        RY,
        CJ,
        XU,
        NAL,
        GE,
        IN,
        JC,
        TANX,
        NC,
        UW,
        KY,
        KF,
        ZD
    }

    public static class XURewardInf extends RewardInf {
        public int amount;
        public String type;

        public XURewardInf() {
            super(Type.XU);
        }
    }

    public static class YFRewardInf extends RewardInf {
        public boolean rewardVerify;

        public YFRewardInf(boolean z) {
            super(Type.ADX);
            this.rewardVerify = z;
        }
    }

    public static class YlhRewardInf extends RewardInf {
        public String ylhTransId;

        public YlhRewardInf(String str) {
            super(Type.YLH);
            this.ylhTransId = str;
        }
    }
}
