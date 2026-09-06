package com.opos.mobad.s;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static void a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ClipboardUtils", "clip copy fail", e);
        }
    }
}
