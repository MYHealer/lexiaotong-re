package com.byazt.bdw;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 907, 13})
public class tt {
    public static void c(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
