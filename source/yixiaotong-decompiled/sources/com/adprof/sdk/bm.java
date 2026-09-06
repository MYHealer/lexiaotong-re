package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adprof.sdk.base.view.gif.GifImageView2;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bm extends zl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GifImageView2 f1094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f146a;

    public bm(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.f146a = false;
        setGravity(17);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        GifImageView2 gifImageView2 = new GifImageView2(context);
        this.f1094a = gifImageView2;
        gifImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(gifImageView2, layoutParams);
    }

    @Override // com.adprof.sdk.zl
    public void a() {
        if (((zl) this).f921a != null) {
            ((zl) this).f921a = null;
        }
        GifImageView2 gifImageView2 = this.f1094a;
        if (gifImageView2 != null) {
            gifImageView2.c();
        }
    }

    @Override // com.adprof.sdk.zl
    public void a(d dVar, Bitmap bitmap) {
        if (this.f146a || bitmap == null) {
            return;
        }
        this.f146a = true;
        ViewGroup viewGroup = ((zl) this).f921a;
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new am(this, bitmap, dVar));
    }

    @Override // com.adprof.sdk.zl
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo586a() {
        return this.f1094a.getDrawable() == null;
    }

    @Override // com.adprof.sdk.zl
    public void b() {
        GifImageView2 gifImageView2 = this.f1094a;
        if (gifImageView2 != null) {
            gifImageView2.c();
        }
    }

    @Override // com.adprof.sdk.zl
    public void c() {
        GifImageView2 gifImageView2 = this.f1094a;
        if (gifImageView2 != null) {
            gifImageView2.f144a = true;
            gifImageView2.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:56:0x010d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0128 A[Catch: all -> 0x0137, LOOP:0: B:58:0x0122->B:60:0x0128, LOOP_END, TryCatch #2 {all -> 0x0137, blocks: (B:57:0x010f, B:58:0x0122, B:60:0x0128, B:61:0x012c), top: B:78:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0151  */
    /* JADX WARN: Code duplicated, block: B:88:0x012c A[EDGE_INSN: B:88:0x012c->B:61:0x012c BREAK  A[LOOP:0: B:58:0x0122->B:60:0x0128], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // com.adprof.sdk.zl
    public void a(d dVar) {
        String str;
        int i;
        int i2;
        int i3;
        RelativeLayout.LayoutParams layoutParams;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i4;
        Throwable th;
        FileInputStream fileInputStream2;
        String strA;
        if (dVar == null || dVar.m594a() == null) {
            pk.b("adUnit or splashFilePath is null");
            return;
        }
        String strM594a = dVar.m594a();
        List listAsList = Arrays.asList("git", "jpeg", "jpg", "png", "bmp", "webp", "tif");
        HashMap map = yb.f1536a;
        byte[] byteArray = null;
        if (strM594a == null || strM594a.isEmpty()) {
            str = null;
        } else {
            File file = new File(strM594a);
            if (file.exists() && file.isFile()) {
                HashMap map2 = yb.f1536a;
                try {
                    fileInputStream2 = new FileInputStream(strM594a);
                    try {
                        byte[] bArr2 = new byte[2];
                        fileInputStream2.read(bArr2, 0, 2);
                        strA = yb.a(bArr2);
                        try {
                            if (strA.equals("5249")) {
                                fileInputStream2.skip(6L);
                                fileInputStream2.read(bArr2, 0, 2);
                                strA = yb.a(bArr2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                pk.b("ImageType getFileHeader error: ", th);
                                if (fileInputStream2 != null) {
                                }
                                str = (String) map2.get(strA);
                                if (TextUtils.isEmpty(str)) {
                                    return;
                                }
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(strM594a, options);
                                i = options.outWidth;
                                i2 = options.outHeight;
                                i3 = getResources().getDisplayMetrics().widthPixels;
                                if (i != 0) {
                                    i2 = (i2 * i3) / i;
                                }
                                pk.a("-------handleLandSize filePath: " + i3 + PPSLabelView.Code + i2 + PPSLabelView.Code + i);
                                if (i3 > i2) {
                                    layoutParams = new RelativeLayout.LayoutParams(i3, i2);
                                } else {
                                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                }
                                this.f1094a.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                this.f1094a.setLayoutParams(layoutParams);
                                if (str.equals("gif")) {
                                    if (listAsList.contains(str)) {
                                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                                        options2.inJustDecodeBounds = false;
                                        a(dVar, BitmapFactory.decodeFile(strM594a, options2));
                                        return;
                                    }
                                    return;
                                }
                                GifImageView2 gifImageView2 = this.f1094a;
                                try {
                                    fileInputStream = new FileInputStream(new File(strM594a));
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    bArr = new byte[1024];
                                    while (true) {
                                        i4 = fileInputStream.read(bArr);
                                        if (i4 != -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, i4);
                                        }
                                    }
                                    fileInputStream.close();
                                    byteArrayOutputStream.close();
                                    byteArray = byteArrayOutputStream.toByteArray();
                                } catch (Throwable th3) {
                                    pk.b("readBytes error: ", th3);
                                }
                                gifImageView2.setBytes(byteArray);
                                GifImageView2 gifImageView3 = this.f1094a;
                                gifImageView3.f144a = true;
                                gifImageView3.b();
                                a(dVar, this);
                            } catch (Throwable th4) {
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        strA = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = null;
                    strA = null;
                }
                try {
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                }
                str = (String) map2.get(strA);
            } else {
                if (pk.f594a) {
                    pk.a("ImageTypeUtil: File does not exist: " + strM594a);
                }
                str = null;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strM594a, options3);
        i = options3.outWidth;
        i2 = options3.outHeight;
        i3 = getResources().getDisplayMetrics().widthPixels;
        if (i != 0 && i2 != 0) {
            i2 = (i2 * i3) / i;
        }
        pk.a("-------handleLandSize filePath: " + i3 + PPSLabelView.Code + i2 + PPSLabelView.Code + i);
        if (i3 > i2) {
            layoutParams = new RelativeLayout.LayoutParams(i3, i2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.f1094a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f1094a.setLayoutParams(layoutParams);
        if (str.equals("gif")) {
            if (listAsList.contains(str)) {
                BitmapFactory.Options options4 = new BitmapFactory.Options();
                options4.inJustDecodeBounds = false;
                a(dVar, BitmapFactory.decodeFile(strM594a, options4));
                return;
            }
            return;
        }
        GifImageView2 gifImageView4 = this.f1094a;
        fileInputStream = new FileInputStream(new File(strM594a));
        byteArrayOutputStream = new ByteArrayOutputStream();
        bArr = new byte[1024];
        while (true) {
            i4 = fileInputStream.read(bArr);
            if (i4 != -1) {
                break;
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i4);
        }
        fileInputStream.close();
        byteArrayOutputStream.close();
        byteArray = byteArrayOutputStream.toByteArray();
        gifImageView4.setBytes(byteArray);
        GifImageView2 gifImageView5 = this.f1094a;
        gifImageView5.f144a = true;
        gifImageView5.b();
        a(dVar, this);
    }
}
