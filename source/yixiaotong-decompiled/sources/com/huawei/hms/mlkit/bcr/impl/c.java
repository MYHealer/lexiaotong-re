package com.huawei.hms.mlkit.bcr.impl;

/* JADX INFO: compiled from: LanguageCode.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x007f  */
    public static int a(String str) {
        switch (str) {
            case "en":
            case "rm":
            case "es":
            case "pt":
            case "it":
            case "de":
            case "fr":
            case "ru":
                return 3;
            case "ja":
            case "ko":
                return 5;
            case "zh":
            default:
                return 1;
        }
    }
}
