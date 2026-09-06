package com.meishu.sdk.meishu_ad.view.player.media.datasouce;

import com.kuaishou.weapon.p0.t;
import com.meishu.sdk.core.bquery.g;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: LocalFileMediaDataSource.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f5140a;
    public RandomAccessFile b;
    public File c;
    public File d;
    public File e;
    public volatile long f;

    public b(String str) {
        this.f = -2147483648L;
        try {
            this.c = g.a(str, (String) null);
            this.d = g.a(str, "temp");
            this.e = g.a(str, "last_meta_temp");
            if (a()) {
                this.f5140a = new RandomAccessFile(this.c, t.k);
                this.f = this.c.length();
            } else {
                this.f5140a = new RandomAccessFile(this.d, t.k);
                this.b = new RandomAccessFile(this.e, t.k);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a() {
        File file = this.c;
        return file != null && file.exists();
    }
}
