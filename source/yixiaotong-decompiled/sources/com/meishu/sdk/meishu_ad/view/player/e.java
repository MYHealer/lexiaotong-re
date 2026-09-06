package com.meishu.sdk.meishu_ad.view.player;

import android.media.MediaDataSource;
import com.meishu.sdk.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: MSMediaDataSource.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.meishu.sdk.meishu_ad.view.player.media.datasouce.a f5137a;

    public e(String str, com.meishu.sdk.meishu_ad.view.player.media.datasouce.c cVar) {
        this.f5137a = new com.meishu.sdk.meishu_ad.view.player.media.datasouce.a(str, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.a aVar = this.f5137a;
        aVar.getClass();
        try {
            LogUtil.d("a", "close");
            aVar.i = true;
            RandomAccessFile randomAccessFile = aVar.c;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            RandomAccessFile randomAccessFile2 = aVar.d;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b bVar = aVar.j;
                if (bVar != null) {
                    bVar.a(aVar.l);
                    aVar.j.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.a aVar = this.f5137a;
        aVar.getClass();
        try {
            File file = aVar.e;
            if (file != null && file.exists()) {
                aVar.h = aVar.e.length();
                return aVar.h;
            }
            synchronized (aVar.b) {
                int i = 0;
                while (aVar.h == -2147483648L) {
                    i += 15;
                    try {
                        aVar.b.wait(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i > 20000) {
                        return -1L;
                    }
                }
                if (aVar.h == -2147483648L) {
                    return -1L;
                }
                return aVar.h;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.a aVar = this.f5137a;
        aVar.getClass();
        try {
            if (j != aVar.h) {
                com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b bVar = aVar.j;
                if (bVar != null) {
                    bVar.a(aVar.k, j, i2, null);
                }
                int i3 = 0;
                int i4 = 0;
                while (!aVar.i) {
                    synchronized (aVar.b) {
                        if (j < aVar.c.length()) {
                            aVar.c.seek(j);
                            i3 = aVar.c.read(bArr, i, i2);
                        } else {
                            com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b bVar2 = aVar.j;
                            if (bVar2 == null || !bVar2.a(aVar.d, j)) {
                                i4 += 33;
                                aVar.b.wait(33L);
                            } else {
                                aVar.d.seek(j);
                                i3 = aVar.d.read(bArr, i, i2);
                            }
                        }
                    }
                    if (i3 > 0) {
                        return i3;
                    }
                    if (i4 >= 20000) {
                        LogUtil.e("a", "readAt timeout");
                        throw new SocketTimeoutException();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1;
    }
}
