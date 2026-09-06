package com.meishu.sdk.core.utils;

import android.content.Intent;
import com.meishu.sdk.core.domain.ar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ah extends ar {
    public Object c(Intent intent, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            return cls.getDeclaredMethod(this.d, cls, CharSequence.class).invoke(null, intent, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
