package com.opos.cmn.biz.ststrategy.entity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class STConfigEntity {
    public final int code;
    public final DataEntity dataEntity;
    public final String msg;

    /* JADX INFO: renamed from: com.opos.cmn.biz.ststrategy.entity.STConfigEntity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public int code;
        public DataEntity dataEntity;
        public String msg;

        public STConfigEntity build() {
            return new STConfigEntity(this, null);
        }

        public Builder setCode(int i) {
            this.code = i;
            return this;
        }

        public Builder setDataEntity(DataEntity dataEntity) {
            this.dataEntity = dataEntity;
            return this;
        }

        public Builder setMsg(String str) {
            this.msg = str;
            return this;
        }
    }

    private STConfigEntity(Builder builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.dataEntity = builder.dataEntity;
    }

    /* synthetic */ STConfigEntity(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "STConfigEntity{code=" + this.code + ", msg='" + this.msg + "', dataEntity=" + this.dataEntity + '}';
    }
}
