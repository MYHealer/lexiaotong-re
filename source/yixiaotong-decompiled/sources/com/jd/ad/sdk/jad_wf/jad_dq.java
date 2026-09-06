package com.jd.ad.sdk.jad_wf;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final /* synthetic */ class jad_dq {
    public static /* synthetic */ String jad_an(int i) {
        if (i == 1) {
            return "BEGIN_ARRAY";
        }
        if (i == 2) {
            return "END_ARRAY";
        }
        if (i == 3) {
            return "BEGIN_OBJECT";
        }
        if (i == 4) {
            return "END_OBJECT";
        }
        if (i == 5) {
            return "NAME";
        }
        if (i == 6) {
            return "STRING";
        }
        if (i == 7) {
            return "NUMBER";
        }
        if (i == 8) {
            return "BOOLEAN";
        }
        if (i == 9) {
            return "NULL";
        }
        return i == 10 ? "END_DOCUMENT" : "null";
    }
}
