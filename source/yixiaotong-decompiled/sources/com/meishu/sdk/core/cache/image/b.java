package com.meishu.sdk.core.cache.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.meishu.sdk.core.bquery.g;
import com.meishu.sdk.core.cache.d;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.x;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ImageDownloadTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4779a;

    public b(c cVar) {
        this.f4779a = cVar;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        c.a(this.f4779a, 2);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009d  */
    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        int i;
        try {
            if (httpResponse.isSuccessful()) {
                c cVar = this.f4779a;
                synchronized (cVar.c) {
                    Iterator<SoftReference<d>> it = cVar.f4780a.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().get().a();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    i = 3;
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray != null) {
                        String str = this.f4779a.b;
                        try {
                            File fileA = g.a(str, (String) null);
                            File fileA2 = g.a(str, "temp");
                            if (fileA2.exists()) {
                                fileA2.delete();
                            }
                            g.a(fileA2, responseBody);
                            if (!fileA2.renameTo(fileA)) {
                                Log.d("BQUtility", "storeSyncWithTemp rename error");
                            }
                            if (fileA == null || !fileA.exists() || fileA.length() <= 0) {
                                ConcurrentHashMap<String, a> concurrentHashMap = com.meishu.sdk.core.cache.c.f4778a;
                                LogUtil.w("c", "image file save error");
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            ConcurrentHashMap<String, a> concurrentHashMap2 = com.meishu.sdk.core.cache.c.f4778a;
                            LogUtil.w("c", "image file save error");
                        }
                        c.a(this.f4779a, bitmapDecodeByteArray, responseBody);
                        return;
                    }
                    i = 4;
                }
            } else {
                i = 3;
            }
            c.a(this.f4779a, i);
        } catch (Throwable unused) {
            c.a(this.f4779a, 9);
        }
    }
}
