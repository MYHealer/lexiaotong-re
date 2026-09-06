package com.byazt.pct;

import android.text.TextUtils;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum gu {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        if (this == PRIVATE) {
            return HeaderConstants.PRIVATE;
        }
        return this == PROTECTED ? "protected" : HeaderConstants.PUBLIC;
    }

    public static gu c(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        return TextUtils.equals(HeaderConstants.PRIVATE, lowerCase) ? PRIVATE : PUBLIC;
    }
}
