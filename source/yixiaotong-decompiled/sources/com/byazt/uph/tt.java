package com.byazt.uph;

import android.graphics.Bitmap;
import com.byazt.nr.m;
import com.byazt.nr.uj;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 446, 13})
public class tt {
    public int c;
    public Map<String, String> n;
    public byte[] tt;
    public List<Object> uj;
    public Bitmap ve;

    public Bitmap c() {
        return this.ve;
    }

    public int tt() {
        return this.c;
    }

    public tt(byte[] bArr, int i) {
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.tt = bArr;
        this.c = i;
    }

    public tt(Bitmap bitmap, int i) {
        this.tt = null;
        this.uj = null;
        this.n = null;
        this.ve = bitmap;
        this.c = i;
    }

    public byte[] ve() {
        try {
            if (this.tt == null) {
                this.tt = uj.tt(this.ve);
            }
        } catch (OutOfMemoryError e) {
            m.c(e);
        }
        return this.tt;
    }

    public boolean uj() {
        if (this.ve != null) {
            return true;
        }
        byte[] bArr = this.tt;
        return bArr != null && bArr.length > 0;
    }

    public boolean n() {
        byte[] bArr = this.tt;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
