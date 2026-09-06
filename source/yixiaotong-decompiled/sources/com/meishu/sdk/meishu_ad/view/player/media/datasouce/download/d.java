package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import android.text.TextUtils;
import com.meishu.sdk.core.utils.LogUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: compiled from: MediaDataSourceDownloader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b.a f5144a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ RandomAccessFile e;
    public final /* synthetic */ c.b f;

    public d(c.b bVar, c.b.a aVar, long j, String str, Object obj, RandomAccessFile randomAccessFile) {
        this.f = bVar;
        this.f5144a = aVar;
        this.b = j;
        this.c = str;
        this.d = obj;
        this.e = randomAccessFile;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0066  */
    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        boolean z;
        long j;
        try {
            int i = c.k;
            LogUtil.d("c", "onResponse code:" + response.code());
            if (response.code() != 404 && response.code() < 500) {
                this.f.f5143a = response.body().byteStream();
                Headers headers = response.headers();
                if (headers == null || headers.size() == 0) {
                    z = false;
                } else {
                    String str = headers.get("Accept-Ranges");
                    String str2 = headers.get("Content-Range");
                    if ("bytes".equalsIgnoreCase(str) || !TextUtils.isEmpty(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                long contentLength = response.body().getContentLength();
                if (z) {
                    j = this.b;
                    contentLength += j;
                } else {
                    LogUtil.e("c", "service don`t support range. " + this.c);
                    j = 0;
                }
                c.b.a aVar = this.f5144a;
                if (aVar != null) {
                    c.a aVar2 = (c.a) aVar;
                    c.this.h = z;
                    c.this.g = contentLength;
                    f fVar = c.this.j;
                    if (fVar != null) {
                        fVar.a(contentLength);
                    }
                }
                byte[] bArr = new byte[8192];
                int i2 = 0;
                while (true) {
                    int i3 = this.f.f5143a.read(bArr, 0, 8192);
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (this.d) {
                        this.e.seek(j);
                        this.e.write(bArr, 0, i3);
                    }
                    j += (long) i3;
                    c.b.a aVar3 = this.f5144a;
                    if (aVar3 != null && j >= ((long) i2) * 16384) {
                        i2++;
                        int iFloor = (int) Math.floor((j / contentLength) * 100.0d);
                        f fVar2 = c.this.j;
                        if (fVar2 != null) {
                            fVar2.a(j, iFloor);
                        }
                    }
                }
                int i4 = c.k;
                LogUtil.d("c", "download finish. isSupportRange:" + z + "  rangeStart:" + this.b + " location:" + j);
                c.b.a aVar4 = this.f5144a;
                if (aVar4 != null) {
                    f fVar3 = c.this.j;
                    if (fVar3 != null) {
                        fVar3.a(j, 100);
                    }
                    c.a aVar5 = (c.a) this.f5144a;
                    c.this.close();
                    f fVar4 = c.this.j;
                    if (fVar4 != null) {
                        fVar4.b();
                    }
                }
                return;
            }
            LogUtil.e("c", "onResponse error code:" + response.code());
            c.b.a aVar6 = this.f5144a;
            if (aVar6 != null) {
                ((c.a) aVar6).a();
            }
            this.f.a();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                c.b.a aVar7 = this.f5144a;
                if (aVar7 != null) {
                    ((c.a) aVar7).a();
                }
            } finally {
                this.f.a();
            }
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        c.b.a aVar = this.f5144a;
        if (aVar != null) {
            ((c.a) aVar).a();
        }
    }
}
