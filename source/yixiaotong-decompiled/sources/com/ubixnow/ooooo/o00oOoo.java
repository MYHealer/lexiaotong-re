package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00oOoo {
    public abstract void destroy();

    public int getIntegerValue(String str) {
        try {
            return (int) Double.parseDouble(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void notifyClick() {
    }

    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    public void notifyShow() {
    }

    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    public void showLog(String str, String str2) {
        ooooO000.OooO0O0(str, str2);
    }
}
