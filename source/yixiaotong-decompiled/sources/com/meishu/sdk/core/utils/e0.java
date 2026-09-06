package com.meishu.sdk.core.utils;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Log;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ImageUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RenderScript f4899a;
    public static final List<String> b = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: ImageUtil.java */
    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4900a;
        public final /* synthetic */ b b;
        public final /* synthetic */ File c;
        public final /* synthetic */ File d;

        public a(String str, b bVar, File file, File file2) {
            this.f4900a = str;
            this.b = bVar;
            this.c = file;
            this.d = file2;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            try {
                e0.b.remove(this.f4900a);
            } catch (Exception unused) {
            }
            b bVar = this.b;
            if (bVar != null) {
                ((r0.a) bVar).a(false);
            }
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            b bVar;
            FileOutputStream fileOutputStream = null;
            boolean z = false;
            try {
                if (httpResponse.isSuccessful()) {
                    byte[] responseBody = httpResponse.getResponseBody();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.c);
                    try {
                        fileOutputStream2.write(responseBody);
                        fileOutputStream2.close();
                        if (this.c.renameTo(this.d)) {
                            z = true;
                        } else {
                            LogUtil.e("ImageUtil", "rename error");
                        }
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            th.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            try {
                                e0.b.remove(this.f4900a);
                            } catch (Exception unused2) {
                            }
                            bVar = this.b;
                            if (bVar == null) {
                                return;
                            }
                        } finally {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            try {
                                e0.b.remove(this.f4900a);
                            } catch (Exception unused4) {
                            }
                            b bVar2 = this.b;
                            if (bVar2 != null) {
                                ((r0.a) bVar2).a(false);
                            }
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                try {
                    e0.b.remove(this.f4900a);
                } catch (Exception unused6) {
                }
                bVar = this.b;
                if (bVar == null) {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            r0.a aVar = (r0.a) bVar;
        }
    }

    /* JADX INFO: compiled from: ImageUtil.java */
    public interface b {
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                bitmap = bitmap.copy(config2, true);
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 4, bitmap.getHeight() / 4, false);
            Log.i("ImageUtil", "scale size:" + bitmapCreateScaledBitmap.getWidth() + "*" + bitmapCreateScaledBitmap.getHeight());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(f4899a, bitmapCreateScaledBitmap);
            Allocation allocationCreateTyped = Allocation.createTyped(f4899a, allocationCreateFromBitmap.getType());
            RenderScript renderScript = f4899a;
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(i);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
            f4899a.destroy();
            return bitmapCreateScaledBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Bitmap frameAtTime = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    if (str.trim().toLowerCase().contains("m3u8") || !str.trim().toLowerCase().startsWith("http")) {
                        mediaMetadataRetriever.setDataSource(str);
                    } else {
                        mediaMetadataRetriever.setDataSource(new com.meishu.sdk.meishu_ad.view.player.d(str));
                    }
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                    mediaMetadataRetriever.release();
                } catch (Throwable th) {
                    th = th;
                    try {
                        LogUtil.e("getFramePictures ERROR:", th.toString());
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return frameAtTime;
                    } catch (Throwable th2) {
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
            }
        } catch (Throwable unused2) {
        }
        return frameAtTime;
    }

    public static File b() {
        try {
            File file = new File(AdSdk.getContext().getFilesDir(), "def_images");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(byte[] bArr) {
        return bArr.length >= 4 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static void a(String str, boolean z, b bVar) {
        if (z) {
            try {
                a();
            } catch (Throwable th) {
                th.printStackTrace();
                if (bVar != null) {
                    ((r0.a) bVar).a(false);
                    return;
                }
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                ((r0.a) bVar).a(false);
                return;
            }
            return;
        }
        String strA = a(str, ".jpg");
        File file = new File(b(), strA);
        if (file.exists()) {
            if (bVar != null) {
                ((r0.a) bVar).a(true);
                return;
            }
            return;
        }
        List<String> list = b;
        if (list.contains(str)) {
            if (bVar != null) {
                ((r0.a) bVar).a(false);
            }
        } else {
            list.add(str);
            File file2 = new File(b(), strA + "_temp");
            if (file2.exists()) {
                file2.delete();
            }
            z.a(str, (x) new a(str, bVar, file2, file), false);
        }
    }

    public static byte[] a(String str) {
        byte[] byteArray = null;
        try {
            String strA = a(str, ".jpg");
            File file = new File(b(), strA);
            if (file.exists()) {
                AdSdk.getSharedPreferences().edit().putLong(strA, System.currentTimeMillis()).apply();
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            fileInputStream.close();
                            byteArrayOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return byteArray;
    }

    public static String a(String str, String str2) throws Exception {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString() + str2;
        } catch (Exception unused) {
            return String.valueOf(str.hashCode()) + str2;
        }
    }

    public static void a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            File[] fileArrListFiles = b().listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = AdSdk.getSharedPreferences().edit();
            boolean z = false;
            for (File file : fileArrListFiles) {
                String name = file.getName();
                long jLastModified = AdSdk.getSharedPreferences().getLong(name, 0L);
                if (jLastModified == 0) {
                    jLastModified = file.lastModified();
                }
                if (jCurrentTimeMillis - jLastModified > 2592000000L && file.delete()) {
                    editorEdit.remove(name);
                    System.out.println("删除过期缓存文件: " + name);
                    z = true;
                }
            }
            if (z) {
                editorEdit.apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
