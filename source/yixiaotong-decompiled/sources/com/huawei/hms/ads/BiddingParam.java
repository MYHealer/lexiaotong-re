package com.huawei.hms.ads;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BiddingParam {
    private static final String TAG = "BiddingParam";

    @com.huawei.openalliance.ad.annotations.a
    private Float bidFloor;
    private String bidFloorCur;
    private List<String> bpkgName;

    public static final class Builder {

        @com.huawei.openalliance.ad.annotations.a
        private Float Code;
        private List<String> I;
        private String V;

        public BiddingParam build() {
            return new BiddingParam(this);
        }

        public Builder setBidFloor(Float f) {
            this.Code = f;
            return this;
        }

        public Builder setBidFloorCur(String str) {
            this.V = str;
            return this;
        }

        public Builder setBpkgName(List<String> list) {
            this.I = list;
            return this;
        }

        public String toString() {
            return "BiddingParam{bidFloorCur = " + this.V + ", bpkgName = " + this.I + '}';
        }
    }

    public BiddingParam() {
    }

    public BiddingParam(Builder builder) {
        if (builder != null) {
            this.bidFloor = builder.Code;
            this.bidFloorCur = builder.V;
            this.bpkgName = builder.I;
        }
    }

    public Float Code() {
        return this.bidFloor;
    }

    public List<String> I() {
        return this.bpkgName;
    }

    public String V() {
        return this.bidFloorCur;
    }

    public String toString() {
        return "BiddingParam{bidFloorCur = " + this.bidFloorCur + ", bpkgName = " + this.bpkgName + '}';
    }
}
