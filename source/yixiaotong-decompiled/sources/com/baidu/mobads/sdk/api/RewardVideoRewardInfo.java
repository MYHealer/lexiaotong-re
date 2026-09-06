package com.baidu.mobads.sdk.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RewardVideoRewardInfo {
    private final Builder builder;

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.api.RewardVideoRewardInfo$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    public Builder getBuilder() {
        return this.builder;
    }

    /* synthetic */ RewardVideoRewardInfo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private RewardVideoRewardInfo(Builder builder) {
        this.builder = builder;
    }

    public String getTwoStageRewardInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.KEY_REWARD_TYPE, this.builder.rewardType);
            jSONObject.put("basicReward", this.builder.basicReward);
            jSONObject.put("basicUnit", this.builder.basicUnit);
            jSONObject.put("advancedReward", this.builder.advancedReward);
            jSONObject.put("advancedUnit", this.builder.advancedUnit);
            jSONObject.put("multiple", this.builder.multiple);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String advancedReward;
        public String advancedUnit;
        public String basicReward;
        public String basicUnit;
        public String multiple;
        public int rewardType;

        public Builder setAdvancedReward(String str) {
            this.advancedReward = str;
            return this;
        }

        public Builder setAdvancedUnit(String str) {
            this.advancedUnit = str;
            return this;
        }

        public Builder setBasicReward(String str) {
            this.basicReward = str;
            return this;
        }

        public Builder setBasicUnit(String str) {
            this.basicUnit = str;
            return this;
        }

        public Builder setMultiple(String str) {
            this.multiple = str;
            return this;
        }

        public Builder setRewardType(int i) {
            this.rewardType = i;
            return this;
        }

        public RewardVideoRewardInfo create() {
            return new RewardVideoRewardInfo(this, null);
        }
    }
}
