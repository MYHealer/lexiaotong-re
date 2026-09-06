package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p3 extends g9 {
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BaseAdImpl e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(BaseAdImpl baseAdImpl, String str, String str2, String str3, boolean z) {
        super(str, str2);
        this.e = baseAdImpl;
        this.c = str3;
        this.d = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() {
        d4 d4Var;
        d4 d4Var2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String str = this.c;
        int i = this.d ? 2 : 1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            d4Var2 = new d4((Exception) new NullPointerException(ijiami_1011.s.s.s.d(new byte[]{93, 80, 77, 5, 48, 89, Ascii.DC4, Ascii.SYN, 5, 7, 17, 12, 74, 17, 87, 17, 15, 90}, "919dc6")), i, jCurrentTimeMillis);
        } else {
            try {
                try {
                    if (i == 1) {
                        mediaMetadataRetriever.setDataSource(str);
                    } else if (i == 2) {
                        mediaMetadataRetriever.setDataSource(str, new HashMap());
                    }
                    d4Var = new d4(mediaMetadataRetriever.getFrameAtTime(0L, 3), i, jCurrentTimeMillis);
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e) {
                d4Var = new d4(e, i, jCurrentTimeMillis);
            }
            d4Var2 = d4Var;
            try {
                mediaMetadataRetriever.release();
            } catch (Exception unused2) {
            }
        }
        String str2 = BaseAdImpl.l;
        m.a(BaseAdImpl.l, ijiami_1011.s.s.s.d(new byte[]{15, 13, 82, 82, 97, 95, 5, 1, 9, 36, 67, 4, 14, 7, 113, 95, 67, 91, 0, Ascii.DC4, 70, 0, 88, 17, 14, 3, 67, 100, 82, 69, Ascii.DC4, 8, Ascii.DC2, 66, 12, 69}, "cb3676") + (d4Var2.f5406a != 0 && d4Var2.b == null));
        T t = d4Var2.f5406a;
        if (t == 0 || d4Var2.b != null) {
            return;
        }
        this.e.j = (Bitmap) t;
    }
}
