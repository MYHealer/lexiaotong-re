package com.ubixnow.core.utils.error;

import com.ubixnow.ooooo.oOO00OO;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ErrorInfo extends oOO00OO {
    public boolean preCheckPass;

    public ErrorInfo(String str, String str2) {
        super(str, str2);
        this.preCheckPass = true;
    }

    public ErrorInfo(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.preCheckPass = true;
    }

    @Override // com.ubixnow.ooooo.oOO00OO
    public ErrorInfo setInfo(Object obj) {
        this.object = obj;
        return this;
    }

    @Override // com.ubixnow.ooooo.oOO00OO
    public String toString() {
        return super.toString();
    }
}
