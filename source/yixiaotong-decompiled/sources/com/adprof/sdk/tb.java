package com.adprof.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ub f1437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xb f740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f741a;

    public tb(xb xbVar, String str, ub ubVar) {
        this.f740a = xbVar;
        this.f741a = str;
        this.f1437a = ubVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f741a).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2000);
            if (httpURLConnection.getResponseCode() == 200) {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                fn.a(new rb(this, bitmapDecodeStream), 0L);
                this.f740a.f833a.put(this.f741a, bitmapDecodeStream);
                String str = this.f741a;
                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(this.f740a.a(), be.a(str.substring(str.lastIndexOf("/") + 1)))));
            }
        } catch (Exception e) {
            fn.a(new sb(this, e), 0L);
        }
    }
}
