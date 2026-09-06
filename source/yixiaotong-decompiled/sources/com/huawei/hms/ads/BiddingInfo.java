package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BiddingInfo {
    private String cur;
    private String lurl;
    private String nurl;

    @com.huawei.openalliance.ad.annotations.a
    private Float price;

    public static final class a {
        private String Code;
        private String I;

        @com.huawei.openalliance.ad.annotations.a
        private Float V;
        private String Z;

        public a Code(Float f) {
            this.V = f;
            return this;
        }

        public a Code(String str) {
            this.Code = str;
            return this;
        }

        public BiddingInfo Code() {
            return new BiddingInfo(this);
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public String toString() {
            return "BiddingInfo{cur = " + this.Code + ", nurl = '" + this.I + ", lurl = " + this.Z + '}';
        }
    }

    public BiddingInfo() {
    }

    public BiddingInfo(a aVar) {
        if (aVar != null) {
            this.cur = aVar.Code;
            this.price = aVar.V;
            this.nurl = aVar.I;
            this.lurl = aVar.Z;
        }
    }

    public boolean Code() {
        return getPrice() == null && getCur() == null && getNurl() == null && getLurl() == null;
    }

    public String getCur() {
        return this.cur;
    }

    public String getLurl() {
        return this.lurl;
    }

    public String getNurl() {
        return this.nurl;
    }

    public Float getPrice() {
        return this.price;
    }

    public String toString() {
        return "BiddingInfo{cur = " + this.cur + ", nurl = " + this.nurl + ", lurl = " + this.lurl + '}';
    }
}
