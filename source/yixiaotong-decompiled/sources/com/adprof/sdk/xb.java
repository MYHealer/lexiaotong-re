package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.stub.StubApp;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static xb f1520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExecutorService f834a = jn.b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LruCache f833a = new LruCache(4194304);

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f1521a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f836a;

        public a(String str) {
            this.f836a = str;
        }

        public void a(ImageView imageView) {
            this.f1521a = imageView;
            if (TextUtils.isEmpty(this.f836a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) xb.this.f833a.get(this.f836a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            String str = this.f836a;
            File file = new File(xb.this.a(), be.a(str.substring(str.lastIndexOf("/") + 1)));
            Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bitmapDecodeFile == null) {
                xb.this.f834a.submit(this);
            } else {
                imageView.setImageBitmap(bitmapDecodeFile);
                xb.this.f833a.put(this.f836a, bitmapDecodeFile);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f836a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    fn.a(new vb(this, bitmapDecodeStream), 0L);
                    xb.this.f833a.put(this.f836a, bitmapDecodeStream);
                    String str = this.f836a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(xb.this.a(), be.a(str.substring(str.lastIndexOf("/") + 1)))));
                } else {
                    fn.a(new wb(this), 0L);
                }
            } catch (Throwable th) {
                pk.b("ImageManager RequestCreatorRunnable error: ", th);
                fn.a(new wb(this), 0L);
            }
        }
    }

    public xb(Context context) {
        this.f832a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static xb a(Context context) {
        if (f1520a == null) {
            synchronized (xb.class) {
                if (f1520a == null) {
                    f1520a = new xb(context);
                }
            }
        }
        return f1520a;
    }

    public final File a() {
        File file = Environment.getExternalStorageState().equals("mounted") ? new File(this.f832a.getExternalCacheDir(), "AFImageCache") : new File(this.f832a.getCacheDir(), "AFImageCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void a(String str, ub ubVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.f833a.get(str);
        if (bitmap != null) {
            ubVar.a(bitmap);
            return;
        }
        File file = new File(a(), be.a(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile == null) {
            this.f834a.submit(new tb(this, str, ubVar));
        } else {
            this.f833a.put(str, bitmapDecodeFile);
            ubVar.a(bitmapDecodeFile);
        }
    }
}
