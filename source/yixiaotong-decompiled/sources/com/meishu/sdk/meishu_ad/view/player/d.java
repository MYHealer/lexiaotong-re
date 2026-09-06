package com.meishu.sdk.meishu_ad.view.player;

import android.media.MediaDataSource;
import com.kuaishou.weapon.p0.t;
import com.meishu.sdk.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: MSLocalFileMediaDataSource.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.meishu.sdk.meishu_ad.view.player.media.datasouce.b f5136a;

    public d(String str) {
        this.f5136a = new com.meishu.sdk.meishu_ad.view.player.media.datasouce.b(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.b bVar = this.f5136a;
        bVar.getClass();
        try {
            LogUtil.d(t.l, "close");
            RandomAccessFile randomAccessFile = bVar.f5140a;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            RandomAccessFile randomAccessFile2 = bVar.b;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.meishu.sdk.meishu_ad.view.player.media.datasouce.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x005f -> B:30:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0062 -> B:30:0x0064). Please report as a decompilation issue!!! */
    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.b bVar;
        long length = this.f5136a;
        length.getClass();
        try {
            File file = length.c;
            if (file == null || !file.exists()) {
                File file2 = length.e;
                if (file2 == null || !file2.exists() || length.e.length() <= 0) {
                    File file3 = length.d;
                    bVar = length;
                    if (file3 == null || !file3.exists() || length.d.length() <= 0) {
                        bVar = length;
                        bVar = length;
                        bVar = length;
                        length = bVar.f == -2147483648L ? -1 : bVar.f;
                    } else {
                        bVar = length;
                        bVar = length;
                        length = length.d.length();
                    }
                } else {
                    length = length.e.length();
                }
            } else {
                length.f = length.c.length();
                length = length.f;
            }
        } catch (Exception e) {
            e.printStackTrace();
            bVar = length;
        }
        return length;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.b bVar = this.f5136a;
        bVar.getClass();
        try {
            if (j != bVar.f) {
                if (j < bVar.f5140a.length()) {
                    LogUtil.d(t.l, "readAt from randomAccessFile");
                    bVar.f5140a.seek(j);
                    i3 = bVar.f5140a.read(bArr, i, i2);
                } else if (j < bVar.b.length()) {
                    LogUtil.d(t.l, "readAt from randomAccessLastMetaFile");
                    bVar.b.seek(j);
                    i3 = bVar.b.read(bArr, i, i2);
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    return i3;
                }
            }
        } catch (Throwable unused) {
        }
        return -1;
    }
}
