package com.ubixnow.core.common;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class BaseDevConfig {
    public Map<String, Object> map;
    public String slotId;
    public int timeout;

    public static abstract class Builder {
        public Map<String, Object> map;
        public String slotId;
        public int timeout;

        public abstract BaseDevConfig build();

        public abstract Builder fetchAdTimeOut(int i);

        public abstract Builder setExtra(Map<String, Object> map);

        public abstract Builder setSlotId(String str);
    }
}
