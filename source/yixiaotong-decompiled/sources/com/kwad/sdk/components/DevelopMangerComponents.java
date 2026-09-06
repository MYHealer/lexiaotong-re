package com.kwad.sdk.components;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface DevelopMangerComponents extends b {
    String ID();

    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public <T> T getValue() {
            T t = (T) this.mValue;
            if (t != null) {
                return t;
            }
            return null;
        }

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }
    }
}
