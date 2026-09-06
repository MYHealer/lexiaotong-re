package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public enum l {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);

    String j;
    int k;

    public String b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }

    l(String str, int i) {
        this.j = str;
        this.k = i;
    }

    public static l b(String str) {
        for (l lVar : values()) {
            if (lVar != null && TextUtils.isEmpty(lVar.j) && lVar.j.equals(str)) {
                return lVar;
            }
        }
        return null;
    }
}
