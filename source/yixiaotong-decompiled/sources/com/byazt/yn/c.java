package com.byazt.yn;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.cd.x;
import com.byazt.sa.n;
import com.byazt.sz.sp;
import com.byazt.xj.ve;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1357, 20})
public class c extends ve<BrokenImage> {
    public String c;
    public volatile boolean vp;
    public float yo;

    public c(Context context) {
        super(context);
        this.vp = false;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        x();
    }

    private void x() {
        if (this.nt != null) {
            this.nt.c();
        }
        n.c().tt().c(this.i, this.c, new com.byazt.sa.c.InterfaceC0263c() { // from class: com.byazt.yn.c.1
            @Override // com.byazt.sa.c.InterfaceC0263c
            public void c(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (c.this.nt != null) {
                        sp spVar = c.this.nt;
                        c cVar = c.this;
                        spVar.tt(cVar, cVar.c);
                        return;
                    }
                    return;
                }
                final Bitmap[] bitmapArr = new Bitmap[1];
                if (c.this.yo > 0.0f) {
                    bitmapArr[0] = x.c(c.this.tt, bitmap, (int) c.this.yo);
                }
                x.c(new Runnable() { // from class: com.byazt.yn.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrokenImage brokenImage = (BrokenImage) c.this.n;
                        Bitmap bitmap2 = bitmapArr[0];
                        if (bitmap2 == null) {
                            bitmap2 = bitmap;
                        }
                        brokenImage.setBitmap(bitmap2);
                    }
                });
                if (c.this.nt != null) {
                    sp spVar2 = c.this.nt;
                    c cVar2 = c.this;
                    spVar2.c(cVar2, cVar2.c);
                }
            }
        });
    }

    public void c(final int i, final int i2, final int i3) {
        if (this.vp) {
            return;
        }
        this.vp = true;
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.yn.c.2
            @Override // java.lang.Runnable
            public void run() {
                ((BrokenImage) c.this.n).c(i, i2);
                ((BrokenImage) c.this.n).c(i3);
            }
        });
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public BrokenImage c() {
        BrokenImage brokenImage = new BrokenImage(this.tt);
        brokenImage.c(this);
        return brokenImage;
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        if (str.equals("imageBlur")) {
            this.yo = com.byazt.cd.ve.c(str2, -1.0f);
        } else if (str.equals(OapsKey.KEY_SRC)) {
            this.c = str2;
        }
    }

    @Override // com.byazt.xj.ve, com.byazt.sa.uj
    public void n() {
        super.n();
    }

    @Override // com.byazt.xj.ve, com.byazt.sa.uj
    public void a() {
        super.a();
    }
}
