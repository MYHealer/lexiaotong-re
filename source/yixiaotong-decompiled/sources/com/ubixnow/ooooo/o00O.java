package com.ubixnow.ooooo;

import android.content.Context;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O extends o00OO000 {
    public int adFlowStatus;
    public String adsSlotid = "";
    public o00O00o0 loadListener;
    public o00O000 mBaseAdConfig;
    public int originType;
    public boolean showStart;

    public abstract void destory();

    public long getAdId(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void getBidToken(Context context, o00O000 o00o000, Object... objArr) {
        this.mBaseAdConfig = o00o000;
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof o00O00o0) {
                this.loadListener = (o00O00o0) obj;
            }
        }
        this.adsSlotid = o00o000.OooO00o.OooO0o0;
        getServerBiddingToken(context, o00o000, objArr);
    }

    public int getIntegerValue(String str) {
        try {
            return (int) Double.parseDouble(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void getServerBiddingToken(Context context, o00O000 o00o000, Object... objArr) {
        this.loadListener.getTokenFail(new ErrorInfo(o0OO000o.o00OO000, o0OO000o.o00OO00O));
    }

    public abstract oo00o getUbixInfo();

    public void innerLoad(Context context, o00O000 o00o000, Object... objArr) {
        this.mBaseAdConfig = o00o000;
        oO0O0OoO oo0o0ooo = o00o000.OooO00o;
        this.platformId = oo0o0ooo.OooO0OO;
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof o00O00o0) {
                this.loadListener = (o00O00o0) obj;
            }
        }
        this.adsSlotid = oo0o0ooo.OooO0o0;
        loadCustomAd(context, o00o000, objArr);
    }

    public boolean isValid() {
        return true;
    }

    public abstract void loadCustomAd(Context context, o00O000 o00o000, Object... objArr);
}
