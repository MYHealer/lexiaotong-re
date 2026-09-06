package com.ubixnow.ooooo;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO000O0 implements Handler.Callback {
    private static final int OooO00o = 115;
    private static final int OooO0O0 = 116;
    private static final int OooO0OO = 137;
    private static final int OooO0Oo = 103;
    private static final int OooO0o = 101;
    private static final int OooO0o0 = 104;
    private static final int OooO0oO = 102;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        int i = message.what;
        if (i == 115) {
            str = "SERVICE_ARGS";
        } else if (i == 116) {
            str = "STOP_SERVICE";
        } else if (i != 137) {
            switch (i) {
                case 101:
                    str = "PAUSE_ACTIVITY";
                    break;
                case 102:
                    str = "PAUSE_ACTIVITY_FINISHING";
                    break;
                case 103:
                    str = "STOP_ACTIVITY_SHOW";
                    break;
                case 104:
                    str = "STOP_ACTIVITY_HIDE";
                    break;
                default:
                    return false;
            }
        } else {
            str = "SLEEPING";
        }
        oO000O0O.OooO00o(str);
        return false;
    }
}
