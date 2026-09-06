package com.huawei.hms.mlsdk.common;

import com.alipay.sdk.util.i;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class AppSettingHolder<T> {
    private final String persistenceKey;
    private final T setting;

    public static <T> AppSettingHolder<T> create(String str, T t) {
        return new AppSettingHolder<>(str, t);
    }

    private AppSettingHolder(String str, T t) {
        if (str == null) {
            throw new NullPointerException("Null PersistentKey");
        }
        if (t == null) {
            throw new NullPointerException("Null setting");
        }
        this.persistenceKey = str;
        this.setting = t;
    }

    public final String toString() {
        String str = this.persistenceKey;
        return new StringBuilder(String.valueOf(str).length() + 97 + String.valueOf(String.valueOf(this.setting)).length()).append("MlModelDriverInstanceKey{persistentKey=").append(str).append(", setting=").append(this.setting).append(i.d).toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppSettingHolder)) {
            return false;
        }
        AppSettingHolder appSettingHolder = (AppSettingHolder) obj;
        return this.persistenceKey.equals(appSettingHolder.persistenceKey) && this.setting.equals(appSettingHolder.setting);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.persistenceKey, this.setting});
    }
}
