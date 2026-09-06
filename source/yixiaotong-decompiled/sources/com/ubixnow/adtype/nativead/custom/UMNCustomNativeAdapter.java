package com.ubixnow.adtype.nativead.custom;

import com.ubixnow.ooooo.o00O;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class UMNCustomNativeAdapter extends o00O {
    public UMNCustomNativeAd customNativeAd;
    public String customTag = "----ubixnative_lm_";
    public oo000o<UMNCustomNativeAdapter> nativeInfo = new oo000o<>();

    public void createNativeInfo(o00O000 o00o000) {
        this.nativeInfo.setAbsBaseAdapter(this);
        oo000o<UMNCustomNativeAdapter> oo000oVar = this.nativeInfo;
        oo000oVar.adType = "3";
        oo000oVar.setBaseAdConfig(o00o000);
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
    }

    @Override // com.ubixnow.ooooo.o00O
    public oo00o getUbixInfo() {
        return this.nativeInfo;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        UMNCustomNativeAd uMNCustomNativeAd = this.customNativeAd;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.isValid();
        }
        return true;
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyClick() {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.customNativeAd;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyClick();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.customNativeAd;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyShow() {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.customNativeAd;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyShow();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.customNativeAd;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyWin(o00oo0oo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
