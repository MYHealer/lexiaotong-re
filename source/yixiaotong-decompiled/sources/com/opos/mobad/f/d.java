package com.opos.mobad.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements com.opos.mobad.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f6900a;
    private LruCache<String, Buffer> b;
    private LruCache<String, WeakReference<Buffer>> c;
    private Context d;

    d(Context context) {
        this(context, new i(context));
    }

    public d(Context context, g gVar) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6900a = gVar;
        this.c = new LruCache<>(50);
        this.b = new com.opos.cmn.i.d(20, new com.opos.cmn.i.d.a<String, Buffer>() { // from class: com.opos.mobad.f.d.1
            @Override // com.opos.cmn.i.d.a
            public void a(String str, Buffer buffer) {
                d.this.c.put(str, new WeakReference(buffer));
            }
        });
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (options != null) {
            try {
                int i4 = options.outHeight;
                int i5 = options.outWidth;
                com.opos.cmn.an.f.a.b("fCache", "options.outHeight=" + i4 + ",options.outWidth=" + i5);
                if (i4 > i2 || i5 > i) {
                    int i6 = i4 / 2;
                    int i7 = i5 / 2;
                    while (i6 / i3 > i2 && i7 / i3 > i) {
                        i3 *= 2;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("fCache", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "calculateInSampleSize reqWidth=" + i + ",reqHeight=" + i2 + ",inSampleSize=" + i3);
        return i3;
    }

    public static Bitmap a(InputStream inputStream) {
        Bitmap bitmapDecodeStream = null;
        if (inputStream != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("fCache", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "decodeSampledBitmapFromStream res=" + inputStream + ",dst:" + bitmapDecodeStream);
        return bitmapDecodeStream;
    }

    public static Bitmap a(Buffer buffer, int i, int i2) {
        Bitmap bitmapA = null;
        if (buffer != null) {
            try {
                Buffer bufferClone = buffer.clone();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(buffer.inputStream(), null, options);
                options.inSampleSize = a(options, i, i2);
                options.inJustDecodeBounds = false;
                bitmapA = com.opos.cmn.an.e.c.a.a(BitmapFactory.decodeStream(bufferClone.inputStream(), null, options), i, i2, options.inSampleSize);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            }
        }
        StringBuilder sb = new StringBuilder("decodeSampledBitmapFromStream res=");
        Object obj = buffer;
        if (buffer == null) {
            obj = "null";
        }
        com.opos.cmn.an.f.a.b("BitmapTool", sb.append(obj).append(",reqWidth=").append(i).append(",reqHeight=").append(i2).append(",dst=").append(bitmapA != null ? bitmapA : "null").toString());
        return bitmapA;
    }

    private final File a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? this.f6900a.a(str) : this.f6900a.a(str, str2);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "close", e);
            }
        }
    }

    private void a(final File file, final String str, final int i, final int i2, final com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.d.3
            @Override // java.lang.Runnable
            public void run() {
                WeakReference weakReference;
                try {
                    Buffer buffer = (Buffer) d.this.b.remove(file.getAbsolutePath());
                    if (buffer == null && (weakReference = (WeakReference) d.this.c.get(file.getAbsolutePath())) != null) {
                        buffer = (Buffer) weakReference.get();
                    }
                    Buffer buffer2 = buffer;
                    if (buffer2 != null) {
                        com.opos.cmn.an.f.a.b("fCache", "decode cache");
                        if (d.this.a(buffer2, str, i, i2, interfaceC0955a)) {
                            return;
                        } else {
                            com.opos.cmn.an.f.a.c("fCache", "decode cache fail");
                        }
                    }
                    com.opos.cmn.an.f.a.b("fCache", "decode file");
                    if (d.this.b(file, str, i, i2, interfaceC0955a)) {
                        return;
                    }
                } catch (Throwable th) {
                    Log.d("fCache", "decode fail", th);
                }
                com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a2 = interfaceC0955a;
                if (interfaceC0955a2 != null) {
                    interfaceC0955a2.a(2, null);
                }
            }
        });
    }

    private void a(final Buffer buffer, final File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.d.2
            @Override // java.lang.Runnable
            public void run() {
                BufferedSink bufferedSinkBuffer = null;
                try {
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            File fileB = d.this.b(file);
                            if (fileB.exists()) {
                                fileB.delete();
                            }
                            bufferedSinkBuffer = Okio.buffer(Okio.sink(fileB));
                            bufferedSinkBuffer.writeAll(buffer);
                            fileB.renameTo(file);
                            if (bufferedSinkBuffer != null) {
                                bufferedSinkBuffer.flush();
                                bufferedSinkBuffer.close();
                            }
                            buffer.close();
                        } catch (Throwable th) {
                            if (bufferedSinkBuffer != null) {
                                try {
                                    bufferedSinkBuffer.flush();
                                    bufferedSinkBuffer.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("fCache", "", e);
                                    throw th;
                                }
                            }
                            buffer.close();
                            throw th;
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("fCache", "write fail", e2);
                        if (bufferedSinkBuffer != null) {
                            bufferedSinkBuffer.flush();
                            bufferedSinkBuffer.close();
                        }
                        buffer.close();
                    }
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.b("fCache", "", e3);
                }
            }
        });
    }

    private boolean a(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Buffer bufferA = null;
        try {
            bufferA = a(file);
            boolean zA = a(bufferA, str);
            if (zA) {
                this.b.put(file.getAbsolutePath(), bufferA);
            }
            return zA;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("fCache", "check fail", e);
            return false;
        } finally {
            if (bufferA != null) {
                bufferA.close();
            }
        }
    }

    private boolean a(Buffer buffer, String str) {
        return buffer.md5().hex().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Buffer buffer, String str, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        boolean z;
        Bitmap bitmapA;
        boolean zEquals;
        Buffer bufferClone = null;
        try {
            if (TextUtils.isEmpty(str)) {
                z = 1;
            } else {
                bufferClone = buffer.clone();
                zEquals = bufferClone.md5().hex().equals(str);
            }
            if (i <= 0 || i2 <= 0) {
                z = zEquals;
                bitmapA = a(buffer.inputStream());
            } else {
                bitmapA = a(buffer, i, i2);
            }
            if (bitmapA == null) {
                if (bufferClone != null) {
                    bufferClone.close();
                }
                buffer.close();
                return false;
            }
            if (interfaceC0955a != null) {
                interfaceC0955a.a(!z, bitmapA);
            }
            if (bufferClone != null) {
                bufferClone.close();
            }
            buffer.close();
            return true;
        } catch (Throwable th) {
            try {
                com.opos.cmn.an.f.a.b("fCache", "decode cache fail", th);
                return false;
            } finally {
                if (bufferClone != null) {
                    bufferClone.close();
                }
                buffer.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file) {
        return new File(file.getParent(), file.getName() + ".tmp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file, String str, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        Bitmap bitmapA;
        com.opos.cmn.an.f.a.b("fCache", "decodeWidthFile:" + file.getAbsolutePath());
        for (int i3 = 0; i3 < 3 && !file.exists(); i3++) {
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "sleep fail", e);
            }
        }
        if (!file.exists()) {
            com.opos.cmn.an.f.a.b("fCache", "cache file no exits");
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("fCache", "decode bf");
            Buffer buffer = new Buffer();
            BufferedSource bufferedSourceBuffer = null;
            try {
                bufferedSourceBuffer = Okio.buffer(Okio.source(file));
                bufferedSourceBuffer.readAll(buffer);
                return a(buffer, str, i, i2, interfaceC0955a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("fCache", "read file fail", e2);
                return false;
            } finally {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Exception e3) {
                        Log.d("fCache", "", e3);
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "decode is");
        try {
            if (i <= 0 || i2 <= 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        Bitmap bitmapA2 = a((InputStream) bufferedInputStream);
                        bufferedInputStream.close();
                        fileInputStream.close();
                        bitmapA = bitmapA2;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } else {
                bitmapA = com.opos.cmn.an.e.c.a.a(file.getAbsolutePath(), i, i2);
            }
            if (bitmapA != null) {
                if (interfaceC0955a == null) {
                    return true;
                }
                interfaceC0955a.a(0, bitmapA);
                return true;
            }
        } catch (Throwable th7) {
            com.opos.cmn.an.f.a.b("fCache", "decode file fail:", th7);
        }
        return false;
    }

    public int a(String str, BufferedSource bufferedSource, String str2, String str3) {
        return a(str, bufferedSource, new Buffer(), str2, str3);
    }

    public int a(String str, BufferedSource bufferedSource, Buffer buffer, String str2, String str3) {
        long j;
        File fileA = a(str, str3);
        if (fileA == null) {
            return 2;
        }
        if (fileA.exists()) {
            fileA.delete();
        }
        BufferedSink bufferedSink = null;
        try {
            try {
                File fileB = b(fileA);
                if (fileB.exists()) {
                    fileB.delete();
                }
                BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(fileB));
                do {
                    j = bufferedSource.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                    if (j >= 0) {
                        bufferedSinkBuffer.write(buffer, j);
                    }
                } while (j >= 0);
                if (TextUtils.isEmpty(str2) || str2.equals(com.opos.cmn.an.b.c.a(fileB))) {
                    fileB.renameTo(fileA);
                    a(bufferedSource);
                    a(buffer);
                    if (bufferedSinkBuffer == null) {
                        return 0;
                    }
                    try {
                        bufferedSinkBuffer.flush();
                        bufferedSinkBuffer.close();
                        return 0;
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e);
                        return 0;
                    }
                }
                com.opos.cmn.an.f.a.b("fCache", "write but md5 fail");
                fileB.delete();
                a(bufferedSource);
                a(buffer);
                if (bufferedSinkBuffer == null) {
                    return 1;
                }
                try {
                    bufferedSinkBuffer.flush();
                    bufferedSinkBuffer.close();
                    return 1;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("fCache", "close", e2);
                    return 1;
                }
            } catch (Throwable th) {
                a(bufferedSource);
                a(buffer);
                if (0 != 0) {
                    try {
                        bufferedSink.flush();
                        bufferedSink.close();
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            com.opos.cmn.an.f.a.b("fCache", am.ae, e4);
            a(bufferedSource);
            a(buffer);
            if (0 != 0) {
                try {
                    bufferedSink.flush();
                    bufferedSink.close();
                } catch (Exception e5) {
                    com.opos.cmn.an.f.a.b("fCache", "close", e5);
                }
            }
            return 2;
        }
    }

    public Buffer a(File file) throws Exception {
        Buffer buffer = new Buffer();
        Okio.buffer(Okio.source(file)).readAll(buffer);
        return buffer;
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        a(new File(str), str2, i, i2, interfaceC0955a);
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        a(str, str2, -1, -1, interfaceC0955a);
    }

    public void a(String str, Buffer buffer, String str2) throws Exception {
        File fileA = a(str, str2);
        if (fileA == null) {
            return;
        }
        this.b.put(fileA.getAbsolutePath(), buffer.clone());
        a(buffer, fileA);
    }

    public boolean a(String str) {
        File fileA = this.f6900a.a(str);
        return fileA != null && fileA.exists();
    }

    public boolean a(String str, String str2, String str3) {
        return a(a(str, str3), str2);
    }

    public void b(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        File fileA = this.f6900a.a(str);
        if (fileA != null) {
            a(fileA, str2, i, i2, interfaceC0955a);
        } else if (interfaceC0955a != null) {
            interfaceC0955a.a(2, null);
        }
    }

    public void b(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        b(str, str2, -1, -1, interfaceC0955a);
    }
}
