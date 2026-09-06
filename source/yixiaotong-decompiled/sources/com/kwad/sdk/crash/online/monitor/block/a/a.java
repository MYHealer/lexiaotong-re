package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import com.kwad.sdk.core.report.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends c {
    private static String aWD = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(Context context, int i) {
        super(context, "ksadBlock.db", i, aWD);
    }
}
