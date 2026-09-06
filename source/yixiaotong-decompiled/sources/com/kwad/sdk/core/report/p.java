package com.kwad.sdk.core.report;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class p extends c {
    public static int Pj = 1;
    private static String aWD = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(Context context, int i) {
        super(context, "ksadrep.db", i, aWD);
    }
}
