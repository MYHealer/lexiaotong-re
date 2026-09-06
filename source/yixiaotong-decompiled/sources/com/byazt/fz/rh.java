package com.byazt.fz;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1022, 115})
public class rh {
    public static Object c(com.byazt.il.c cVar) {
        sl slVarC;
        if (cVar == null || (slVarC = c(cVar.c())) == null) {
            return null;
        }
        return slVarC.c(null, cVar.tt());
    }

    public static sl c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "toNumber":
                return new z();
            case "toString":
                return new m();
            case "formatDecimal":
                return new sp();
            case "modArray":
                return new t();
            case "find":
                return new a();
            case "join":
                return new da();
            case "size":
                return new u();
            case "includes":
                return new x();
            case "chunk":
                return new c();
            case "exist":
                return new n();
            case "split":
                return new yp();
            case "decodeUrl":
                return new tt();
            case "translate":
                return new nu();
            case "encodeUrl":
                return new uj();
            case "isDigit":
                return new i();
            default:
                return null;
        }
    }
}
