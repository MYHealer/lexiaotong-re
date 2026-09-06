package com.bytedance.msdk.adapter.baidu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoftReference<ImageView> f3039a;

    public DownloadImageTask(ImageView imageView) {
        this.f3039a = new SoftReference<>(imageView);
    }

    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {
            MediationApiLog.i("download Image", "Error download Image fail...");
        } else if (this.f3039a.get() != null) {
            this.f3039a.get().setImageBitmap(bitmap);
        }
    }
}
