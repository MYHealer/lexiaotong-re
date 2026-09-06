package com.ubix.ssp.ad.e.v.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.v.e;
import com.ubix.ssp.open.AdError;
import com.ubixnow.ooooo.oOO00O0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends e implements com.ubix.ssp.ad.e.v.a {
    private SoftReference<e.a> d;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.g.a$a, reason: collision with other inner class name */
    class RunnableC1099a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.b f8881a;
        final /* synthetic */ String b;
        final /* synthetic */ ImageView c;
        final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.g.a$a$a, reason: collision with other inner class name */
        class C1100a implements com.ubix.ssp.ad.e.v.b {
            C1100a() {
            }

            @Override // com.ubix.ssp.ad.e.v.b
            public void a(String str, AdError adError, String str2) {
                if (a.this.d == null || a.this.d.get() == null) {
                    return;
                }
                ((e.a) a.this.d.get()).sendMessage(a.this.a(adError));
            }

            @Override // com.ubix.ssp.ad.e.v.b
            public void a(String str, String str2) {
                try {
                    RunnableC1099a runnableC1099a = RunnableC1099a.this;
                    a.this.b(str, runnableC1099a.c);
                    if (a.this.d == null || a.this.d.get() == null) {
                        return;
                    }
                    ((e.a) a.this.d.get()).sendMessage(a.this.a(str, str2));
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (a.this.d == null || a.this.d.get() == null) {
                        return;
                    }
                    ((e.a) a.this.d.get()).sendMessage(a.this.a(com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误")));
                }
            }
        }

        RunnableC1099a(e.b bVar, String str, ImageView imageView, int i) {
            this.f8881a = bVar;
            this.b = str;
            this.c = imageView;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.d = new SoftReference(new e.a(this.f8881a));
                if (!a.this.c(this.b)) {
                    if (this.d * 1000 > 0) {
                        ((e.a) a.this.d.get()).sendMessageDelayed(a.this.a(com.ubix.ssp.ad.e.a0.a0.a.i(3, oOO00O0.ubix_timeout_msg)), ((long) this.d) * 1000);
                    }
                    com.ubix.ssp.ad.e.v.c.b().a(com.ubix.ssp.ad.e.a0.c.e(), this.b, 1, new C1100a());
                    return;
                }
                a.this.b(this.b, this.c);
                if (a.this.d == null || a.this.d.get() == null) {
                    return;
                }
                e.a aVar = (e.a) a.this.d.get();
                a aVar2 = a.this;
                String str = this.b;
                aVar.sendMessage(aVar2.a(str, aVar2.e(str).getAbsolutePath()));
            } catch (Exception e) {
                e.printStackTrace();
                if (a.this.d == null || a.this.d.get() == null) {
                    return;
                }
                ((e.a) a.this.d.get()).sendMessage(a.this.a(com.ubix.ssp.ad.e.a0.a0.a.h(9, "内容加载失败")));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8883a;
        final /* synthetic */ ImageView b;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.g.a$b$a, reason: collision with other inner class name */
        class RunnableC1101a implements Runnable {
            RunnableC1101a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.ubix.ssp.ad.e.t.a.e) b.this.b).setRoundImageBitmap((Bitmap) com.ubix.ssp.ad.e.v.e.f8879a.get(b.this.f8883a));
            }
        }

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.g.a$b$b, reason: collision with other inner class name */
        class RunnableC1102b implements Runnable {
            RunnableC1102b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = b.this.b;
                if (imageView != null) {
                    imageView.setImageBitmap((Bitmap) com.ubix.ssp.ad.e.v.e.f8879a.get(b.this.f8883a));
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = b.this.b;
                ((com.ubix.ssp.ad.e.t.a.e) imageView).a(imageView.getWidth(), b.this.b.getHeight());
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = b.this.b;
                ((com.ubix.ssp.ad.e.t.a.e) imageView).a(imageView.getWidth(), b.this.b.getHeight());
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f8888a;

            e(Bitmap bitmap) {
                this.f8888a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = b.this.b;
                if (imageView != null) {
                    imageView.setImageBitmap(this.f8888a);
                }
            }
        }

        b(String str, ImageView imageView) {
            this.f8883a = str;
            this.b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!a.this.c(this.f8883a)) {
                    throw new Exception("resource not found form cache");
                }
                if (com.ubix.ssp.ad.e.v.e.f8879a.get(this.f8883a) != null) {
                    ImageView imageView = this.b;
                    if (imageView != null) {
                        imageView.post(imageView instanceof com.ubix.ssp.ad.e.t.a.e ? new RunnableC1101a() : new RunnableC1102b());
                        return;
                    }
                    return;
                }
                if (com.ubix.ssp.ad.e.v.e.b.get(this.f8883a) != null) {
                    ImageView imageView2 = this.b;
                    if (imageView2 instanceof com.ubix.ssp.ad.e.t.a.e) {
                        imageView2.post(new c());
                        ((com.ubix.ssp.ad.e.t.a.e) this.b).setGifImage((byte[]) com.ubix.ssp.ad.e.v.e.b.get(this.f8883a));
                        return;
                    }
                    return;
                }
                if (a.this.e(this.f8883a).exists()) {
                    if (a.this.g(this.f8883a)) {
                        synchronized (com.ubix.ssp.ad.e.v.e.b) {
                            if (com.ubix.ssp.ad.e.v.e.b.get(this.f8883a) == null) {
                                LruCache lruCache = com.ubix.ssp.ad.e.v.e.b;
                                String str = this.f8883a;
                                a aVar = a.this;
                                lruCache.put(str, aVar.b(aVar.e(str)));
                            }
                        }
                        ImageView imageView3 = this.b;
                        if (imageView3 instanceof com.ubix.ssp.ad.e.t.a.e) {
                            imageView3.post(new d());
                            ((com.ubix.ssp.ad.e.t.a.e) this.b).setGifImage((byte[]) com.ubix.ssp.ad.e.v.e.b.get(this.f8883a));
                            return;
                        }
                        return;
                    }
                    a aVar2 = a.this;
                    Bitmap bitmapA = aVar2.a(aVar2.e(this.f8883a));
                    u.b("url=" + this.f8883a + "bitmap=" + bitmapA);
                    if (bitmapA != null) {
                        synchronized (com.ubix.ssp.ad.e.v.e.f8879a) {
                            com.ubix.ssp.ad.e.v.e.f8879a.put(this.f8883a, bitmapA);
                        }
                        ImageView imageView4 = this.b;
                        if (imageView4 != null) {
                            imageView4.post(new e(bitmapA));
                            return;
                        }
                        return;
                    }
                    return;
                    th.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class c implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8889a;

        c(String str) {
            this.f8889a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeFile(this.f8889a, options);
                return options.outMimeType;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public a() {
        if (u.a()) {
            u.b("imageCache=" + e.f8879a.size() + ";" + e.f8879a.maxSize());
            u.b("bytesCache=" + e.b.size() + ";" + e.b.maxSize());
        }
    }

    private int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iMin = Math.min(Math.round(i3 / i2), Math.round(i4 / i));
        while ((i4 * i3) / (iMin * iMin) > i * i2 * 2) {
            iMin++;
        }
        return iMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file) throws IOException {
        u.b("file.exists()=" + file.exists());
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Bitmap bitmapA = a(a(fileInputStream), false);
        fileInputStream.close();
        return bitmapA;
    }

    private Bitmap a(byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (z) {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iMin = Math.min(i, i2);
            float f = i / i2;
            if (Math.round(f) > 0) {
                options.inSampleSize = a(options, iMin, iMin / Math.round(f));
            }
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        if (inputStream.available() > Runtime.getRuntime().freeMemory() && inputStream.available() > Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) {
            u.b("Do not load bytes,current length=" + inputStream.available() + ";total length=" + Runtime.getRuntime().totalMemory() + ";free length=" + Runtime.getRuntime().freeMemory() + ";allow length=" + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()));
            return null;
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(File file) throws IOException {
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        fileInputStream.close();
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File e(String str) {
        return new File(k.e(com.ubix.ssp.ad.e.a0.c.e()), str.hashCode() + "");
    }

    public static String f(String str) {
        if (com.ubix.ssp.ad.e.a0.c.f == null) {
            com.ubix.ssp.ad.e.a0.c.f = com.ubix.ssp.ad.e.a0.c.A();
        }
        Future futureSubmit = com.ubix.ssp.ad.e.a0.c.f.submit(new c(str));
        try {
            return (String) futureSubmit.get(1L, TimeUnit.SECONDS);
        } catch (TimeoutException unused) {
            try {
                futureSubmit.cancel(true);
            } catch (Throwable unused2) {
            }
            return null;
        } catch (Throwable unused3) {
            return null;
        }
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public LruCache<String, Bitmap> a() {
        return e.f8879a;
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public void a(String str, int i, e.b bVar) {
        a(str, null, i, bVar);
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public void a(String str, ImageView imageView) throws Exception {
        if (!c(str)) {
            throw new Exception("resource not found form cache");
        }
        if (e.f8879a.get(str) != null) {
            if (imageView != null) {
                if (imageView instanceof com.ubix.ssp.ad.e.t.a.e) {
                    ((com.ubix.ssp.ad.e.t.a.e) imageView).setRoundImageBitmap(e.f8879a.get(str));
                    return;
                } else {
                    imageView.setImageBitmap(e.f8879a.get(str));
                    return;
                }
            }
            return;
        }
        if (e.b.get(str) != null) {
            if (imageView instanceof com.ubix.ssp.ad.e.t.a.e) {
                com.ubix.ssp.ad.e.t.a.e eVar = (com.ubix.ssp.ad.e.t.a.e) imageView;
                eVar.a(imageView.getWidth(), imageView.getHeight());
                eVar.setGifImage(e.b.get(str));
                return;
            }
            return;
        }
        if (e(str).exists()) {
            if (g(str)) {
                synchronized (e.b) {
                    if (e.b.get(str) == null) {
                        e.b.put(str, b(e(str)));
                    }
                }
                if (imageView instanceof com.ubix.ssp.ad.e.t.a.e) {
                    com.ubix.ssp.ad.e.t.a.e eVar2 = (com.ubix.ssp.ad.e.t.a.e) imageView;
                    eVar2.a(imageView.getWidth(), imageView.getHeight());
                    eVar2.setGifImage(e.b.get(str));
                    return;
                }
                return;
            }
            Bitmap bitmapA = a(e(str));
            u.b("url=" + str + "bitmap=" + bitmapA);
            if (bitmapA != null) {
                synchronized (e.f8879a) {
                    e.f8879a.put(str, bitmapA);
                }
                if (imageView != null) {
                    imageView.setImageBitmap(bitmapA);
                }
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public void a(String str, ImageView imageView, int i, e.b bVar) {
        try {
            if (com.ubix.ssp.ad.e.a0.c.f == null) {
                com.ubix.ssp.ad.e.a0.c.f = com.ubix.ssp.ad.e.a0.c.A();
            }
            com.ubix.ssp.ad.e.a0.c.f.execute(new RunnableC1099a(bVar, str, imageView, i));
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(com.ubix.ssp.ad.e.a0.a0.a.h(9, "内容加载失败"));
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public void a(String str, e.b bVar) {
        a(str, null, -1, bVar);
    }

    @Override // com.ubix.ssp.ad.e.v.e, com.ubix.ssp.ad.e.v.a
    public Bitmap b(String str) {
        if (e.f8879a.get(str) != null) {
            return e.f8879a.get(str);
        }
        byte[] bArr = e.b.get(str);
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public void b(String str, ImageView imageView) {
        if (com.ubix.ssp.ad.e.a0.c.f == null) {
            com.ubix.ssp.ad.e.a0.c.f = com.ubix.ssp.ad.e.a0.c.A();
        }
        com.ubix.ssp.ad.e.a0.c.f.execute(new b(str, imageView));
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public boolean c(String str) throws IOException {
        if (e.f8879a.get(str) != null || e.b.get(str) != null) {
            return true;
        }
        File fileE = e(str);
        if (fileE == null || !fileE.exists()) {
            return false;
        }
        if (g(str)) {
            if (e.b.get(str) != null) {
                return false;
            }
            e.b.put(str, b(e(str)));
            return true;
        }
        Bitmap bitmapA = a(fileE);
        if (bitmapA == null) {
            return false;
        }
        synchronized (e.f8879a) {
            e.f8879a.put(str, bitmapA);
        }
        return true;
    }

    @Override // com.ubix.ssp.ad.e.v.a
    public boolean d(String str) {
        try {
            return (e.f8879a.get(str) == null && e.b.get(str) == null) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean g(String str) {
        String strF = f(e(str).getAbsolutePath());
        u.e("new getMimeTyper=" + strF + ";" + Thread.currentThread().getName());
        if (strF == null) {
            return false;
        }
        return strF.toLowerCase().contains("gif");
    }
}
