package client.android.yixiaotong.util.imgutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ImageCachceUitl {
    public static final int FAIL = 1;
    public static final int SUCCSEE = 0;
    private File cacheDir;
    private Context context;
    Handler handler;
    private boolean mIsSaveLocal = true;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory() / 8)) { // from class: client.android.yixiaotong.util.imgutil.ImageCachceUitl.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    public ImageCachceUitl(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
        this.cacheDir = context.getCacheDir();
    }

    public Bitmap getBitmapFromUrl(String str, int i) {
        Bitmap bitmap = this.cache.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapFromFile = getBitmapFromFile(str);
        if (bitmapFromFile != null) {
            return bitmapFromFile;
        }
        getBitmapFromNet(str, i);
        return null;
    }

    public Bitmap uploadBitmap(String str, int i) {
        getBitmapFromNet(str, i);
        return null;
    }

    private void getBitmapFromNet(String str, int i) {
        this.mIsSaveLocal = true;
        this.executorService.execute(new RunnableTask(str, i));
    }

    public void getBitmapFromNet(String str, int i, boolean z) {
        this.mIsSaveLocal = z;
        this.executorService.execute(new RunnableTask(str, i));
    }

    class RunnableTask implements Runnable {
        private HttpURLConnection httpURLConnection;
        String imageUrl;
        int position;

        public RunnableTask(String str, int i) {
            this.position = i;
            this.imageUrl = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x007a A[PHI: r0
  0x007a: PHI (r0v3 java.net.HttpURLConnection) = (r0v1 java.net.HttpURLConnection), (r0v14 java.net.HttpURLConnection) binds: [B:19:0x0078, B:12:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.imageUrl).openConnection();
                    this.httpURLConnection = httpURLConnection2;
                    httpURLConnection2.setRequestMethod("GET");
                    this.httpURLConnection.setConnectTimeout(5000);
                    this.httpURLConnection.setReadTimeout(5000);
                    if (this.httpURLConnection.getResponseCode() == 200) {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.httpURLConnection.getInputStream());
                        Message message = new Message();
                        message.obj = bitmapDecodeStream;
                        message.arg1 = this.position;
                        message.what = 0;
                        ImageCachceUitl.this.handler.sendMessage(message);
                        ImageCachceUitl.this.cache.put(this.imageUrl, bitmapDecodeStream);
                        if (ImageCachceUitl.this.mIsSaveLocal) {
                            ImageCachceUitl.this.writeToLoce(this.imageUrl, bitmapDecodeStream);
                        }
                        HttpURLConnection httpURLConnection3 = this.httpURLConnection;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            return;
                        }
                        return;
                    }
                    httpURLConnection = this.httpURLConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    ImageCachceUitl.this.handler.obtainMessage(1).sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                    httpURLConnection = this.httpURLConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection4 = this.httpURLConnection;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToLoce(String str, Bitmap bitmap) {
        try {
            String strSubstring = str.substring(str.length() - 18, str.length() - 4);
            String[] strArrSplit = str.split("\\/");
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    if (i == strArrSplit.length - 1) {
                        strSubstring = strArrSplit[i];
                    }
                }
            }
            Log.i("bitmapefilename", strSubstring);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream(new File(this.cacheDir, strSubstring)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getBitmapFromFile(String str) {
        try {
            String strSubstring = str.substring(str.length() - 18, str.length() - 4);
            String[] strArrSplit = str.split("\\/");
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    if (i == strArrSplit.length - 1) {
                        strSubstring = strArrSplit[i];
                    }
                }
            }
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(new File(this.cacheDir, strSubstring).getPath());
            this.cache.put(str, bitmapDecodeFile);
            return bitmapDecodeFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
