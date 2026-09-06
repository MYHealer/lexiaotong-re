package com.opos.cmn.biz.ststrategy.entity;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class DataEntity {
    public final EncryptEntity encryptEntity;
    public final Map<String, MetaEntity> metaEntityMap;
    public final StrategyEntity strategyEntity;

    /* JADX INFO: renamed from: com.opos.cmn.biz.ststrategy.entity.DataEntity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private EncryptEntity encryptEntity;
        public Map<String, MetaEntity> metaEntityMap;
        public StrategyEntity strategyEntity;

        public DataEntity build() {
            return new DataEntity(this, null);
        }

        public Builder setEncryptEntity(EncryptEntity encryptEntity) {
            this.encryptEntity = encryptEntity;
            return this;
        }

        public Builder setMetaEntityMap(Map<String, MetaEntity> map) {
            this.metaEntityMap = map;
            return this;
        }

        public Builder setStrategyEntity(StrategyEntity strategyEntity) {
            this.strategyEntity = strategyEntity;
            return this;
        }
    }

    private DataEntity(Builder builder) {
        this.strategyEntity = builder.strategyEntity;
        this.metaEntityMap = builder.metaEntityMap;
        this.encryptEntity = builder.encryptEntity;
    }

    /* synthetic */ DataEntity(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "DataEntity{strategyEntity=" + this.strategyEntity + ", metaEntityMap=" + this.metaEntityMap + ", encryptEntity=" + this.encryptEntity + '}';
    }
}
