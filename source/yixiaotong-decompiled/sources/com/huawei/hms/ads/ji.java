package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ji {
    Long B;
    Boolean C;
    Long Code;
    String D;
    String F;
    Integer I;
    String L;
    String S;
    Integer V;
    String Z;

    public static final class a {
        Long B;
        Boolean C;
        Long Code;
        String D;
        String F;
        Integer I;
        String L;
        String S;
        Integer V;
        String Z;

        public a B(String str) {
            this.F = str;
            return this;
        }

        public a Code(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a Code(Integer num) {
            this.V = num;
            return this;
        }

        public a Code(Long l) {
            this.Code = l;
            return this;
        }

        public a Code(String str) {
            this.D = str;
            return this;
        }

        public ji Code() {
            ji jiVar = new ji();
            jiVar.Code = this.Code;
            jiVar.V = this.V;
            jiVar.I = this.I;
            jiVar.B = this.B;
            jiVar.Z = this.Z;
            jiVar.C = this.C;
            jiVar.S = this.S;
            jiVar.F = this.F;
            jiVar.D = this.D;
            jiVar.L = this.L;
            return jiVar;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(Integer num) {
            this.I = num;
            return this;
        }

        public a V(Long l) {
            this.B = l;
            return this;
        }

        public a V(String str) {
            this.L = str;
            return this;
        }

        public a Z(String str) {
            this.S = str;
            return this;
        }
    }

    public String B() {
        return this.Z;
    }

    public void B(String str) {
        this.L = str;
    }

    public Long C() {
        return this.B;
    }

    public String Code() {
        return this.D;
    }

    public void Code(Boolean bool) {
        this.C = bool;
    }

    public void Code(Integer num) {
        this.V = num;
    }

    public void Code(Long l) {
        this.Code = l;
    }

    public void Code(String str) {
        this.D = str;
    }

    public String D() {
        return this.F;
    }

    public String F() {
        return this.S;
    }

    public Integer I() {
        return this.V;
    }

    public void I(String str) {
        this.S = str;
    }

    public String L() {
        return this.L;
    }

    public Boolean S() {
        return this.C;
    }

    public Long V() {
        return this.Code;
    }

    public void V(Integer num) {
        this.I = num;
    }

    public void V(Long l) {
        this.B = l;
    }

    public void V(String str) {
        this.Z = str;
    }

    public Integer Z() {
        return this.I;
    }

    public void Z(String str) {
        this.F = str;
    }
}
