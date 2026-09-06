package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class dy extends Drawable implements Animatable, Drawable.Callback {
    private static final int B = 2;
    private static final int C = 119;
    private static final String Code = "GifDrawable";
    private static final int D = 2;
    private static final int F = 5;
    private static final int I = 640;
    private static final int L = 4;
    private static final String S = "render_frame";
    private static final int V = 0;
    private static final int Z = 960;
    private Paint f;
    private String i;
    private int l;
    private int m;
    private dx o;
    private Context p;
    private dz r;
    private boolean s;
    private com.huawei.openalliance.ad.utils.w t;
    private ea v;
    private a w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3822a = S + hashCode();
    private Canvas b = new Canvas();
    private Rect c = new Rect();
    private Rect d = new Rect();
    private Rect e = new Rect();
    private boolean g = false;
    private int h = 0;
    private Queue<dz> j = new ConcurrentLinkedQueue();
    private Queue<Bitmap> k = new ConcurrentLinkedQueue();
    private boolean n = false;
    private long q = 0;
    private final WeakHashMap<Drawable.Callback, Void> u = new WeakHashMap<>();

    public interface a {
        void Code(Bitmap bitmap);
    }

    public dy(Context context, String str) {
        this.p = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.i = str;
        com.huawei.openalliance.ad.utils.w wVar = new com.huawei.openalliance.ad.utils.w("gif-thread");
        this.t = wVar;
        wVar.Code();
        setCallback(this);
    }

    private InputStream B(String str) {
        String strE;
        StringBuilder sb;
        try {
            return this.p.getResources().openRawResource(Integer.parseInt(str.substring(com.huawei.openalliance.ad.constant.cf.RES.toString().length())));
        } catch (Resources.NotFoundException e) {
            e = e;
            strE = e();
            sb = new StringBuilder("loadFile ");
            fh.I(strE, sb.append(e.getClass().getSimpleName()).toString());
            return null;
        } catch (NumberFormatException e2) {
            e = e2;
            strE = e();
            sb = new StringBuilder("loadFile ");
            fh.I(strE, sb.append(e.getClass().getSimpleName()).toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        fh.V(e(), "replay " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        Code(this.i);
    }

    private InputStream C(String str) {
        try {
            return this.p.getAssets().open(str.substring(com.huawei.openalliance.ad.constant.cf.ASSET.toString().length()));
        } catch (IOException e) {
            fh.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void C() {
        Code(false);
        this.l = 0;
        this.j.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    public Bitmap Code(Bitmap bitmap, boolean z) {
        int i;
        if (fh.Code()) {
            fh.Code(e(), "image pool size: %d", Integer.valueOf(this.k.size()));
        }
        Bitmap bitmapPoll = this.k.poll();
        if (bitmapPoll == null) {
            fh.V(e(), "cache bitmap null");
            if (!z) {
                return bitmap.copy(bitmap.getConfig(), true);
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < height) {
                i = 640;
                if (width <= 640) {
                    i = width;
                }
            } else {
                i = Z;
                if (width <= Z) {
                    i = width;
                }
            }
            int i2 = (int) (((i * height) * 1.0f) / width);
            fh.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(width), Integer.valueOf(height));
            bitmapPoll = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        }
        Code(bitmap, bitmapPoll);
        return bitmapPoll;
    }

    private void Code(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.b.setBitmap(bitmap2);
            this.b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.b.drawBitmap(bitmap, this.d, this.e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(dz dzVar) {
        if (dzVar == null) {
            fh.V(e(), "invalid frame.");
            return;
        }
        fh.V(e(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(dzVar.Code), Boolean.valueOf(F()));
        if (F()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.q;
        if (fh.Code()) {
            fh.Code(e(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(jCurrentTimeMillis), Integer.valueOf(this.m));
        }
        if (dzVar.Code == 1) {
            b();
        } else {
            int i = this.m;
            if (jCurrentTimeMillis < i) {
                try {
                    Thread.sleep(((long) i) - jCurrentTimeMillis);
                } catch (InterruptedException unused) {
                    fh.Code(e(), "sleep InterruptedException");
                }
            }
        }
        V(dzVar);
    }

    private void Code(final String str) {
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.2
            @Override // java.lang.Runnable
            public void run() {
                dy.this.V(str);
            }
        });
    }

    private synchronized void Code(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(dz dzVar, long j) {
        int iCeil;
        long width = ((long) dzVar.V.getWidth()) * ((long) dzVar.V.getHeight()) * ((long) (dzVar.V.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4));
        if (j > dzVar.I) {
            iCeil = (int) Math.ceil((j * 1.0d) / ((double) dzVar.I));
            if (iCeil > 5) {
                iCeil = 5;
            }
        } else {
            iCeil = 1;
        }
        long jMax = width * ((long) Math.max(iCeil, this.j.size()));
        long jV = com.huawei.openalliance.ad.utils.z.V();
        if (fh.Code()) {
            fh.Code(e(), "max frame mem: %d unused memory: %d", Long.valueOf(jMax), Long.valueOf(jV));
        }
        return jMax >= jV;
    }

    static /* synthetic */ int D(dy dyVar) {
        int i = dyVar.l;
        dyVar.l = i + 1;
        return i;
    }

    private void D() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.3
            @Override // java.lang.Runnable
            public void run() {
                if (dy.this.v != null) {
                    dy.this.v.V();
                }
                dy.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean F() {
        return this.n;
    }

    private InputStream I(String str) {
        try {
            return this.p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e) {
            fh.I(e(), "oPIs " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void I(dz dzVar) {
        if (dzVar == null || this.k.size() >= 2) {
            fh.V(e(), "drop frame");
        } else {
            if (this.k.contains(dzVar.V) || this.k.offer(dzVar.V)) {
                return;
            }
            fh.I(e(), "fail to release frame to pool");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        final dx dxVar;
        if (F() || (dxVar = this.o) == null || dxVar.I()) {
            return;
        }
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.4
            @Override // java.lang.Runnable
            public void run() {
                fh.V(dy.this.e(), "fetch next");
                long jCurrentTimeMillis = System.currentTimeMillis();
                dz dzVarCode = dxVar.Code();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                fh.Code(dy.this.e(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(jCurrentTimeMillis2), dzVarCode);
                dy dyVar = dy.this;
                if (dzVarCode == null) {
                    dz dzVar = (dz) dyVar.j.poll();
                    if (dzVar != null) {
                        dy.this.Code(dzVar);
                        return;
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - dy.this.q;
                    if (jCurrentTimeMillis3 < dy.this.m) {
                        try {
                            Thread.sleep(((long) dy.this.m) - jCurrentTimeMillis3);
                        } catch (InterruptedException unused) {
                            fh.Code(dy.this.e(), "InterruptedException");
                        }
                    }
                    dy.this.a();
                    return;
                }
                boolean zCode = dyVar.Code(dzVarCode, jCurrentTimeMillis2);
                fh.Code(dy.this.e(), "need reduce size: %s", Boolean.valueOf(zCode));
                dz dzVarCode2 = dzVarCode.Code();
                dzVarCode2.V = dy.this.Code(dzVarCode.V, zCode);
                if (!dy.this.j.offer(dzVarCode2)) {
                    fh.I(dy.this.e(), "fail to add frame to cache");
                }
                if (jCurrentTimeMillis2 <= dzVarCode2.I) {
                    fh.V(dy.this.e(), "send to render directly");
                } else {
                    int i = (int) ((jCurrentTimeMillis2 * 1.0d) / ((double) dzVarCode2.I));
                    if (i > 5) {
                        i = 5;
                    }
                    fh.Code(dy.this.e(), "preferred cached frame num: %d", Integer.valueOf(i));
                    if (dy.this.j.size() < i) {
                        dy.this.L();
                        return;
                    }
                }
                dy dyVar2 = dy.this;
                dyVar2.Code((dz) dyVar2.j.poll());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        dx dxVar = this.o;
        if (dxVar != null) {
            dxVar.V();
            this.o = null;
        }
    }

    private void V(dz dzVar) {
        a aVar;
        I(this.r);
        this.r = dzVar;
        if (dzVar != null && (aVar = this.w) != null) {
            aVar.Code(dzVar.V);
        }
        this.m = dzVar.I;
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.7
            @Override // java.lang.Runnable
            public void run() {
                if (dy.this.F()) {
                    dy.this.r = null;
                } else {
                    dy.this.invalidateSelf();
                    dy.this.L();
                }
            }
        }, this.f3822a, 0L);
        this.q = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        InputStream inputStreamI;
        S();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(com.huawei.openalliance.ad.constant.cf.ASSET.toString())) {
            inputStreamI = C(str);
        } else if (str.startsWith(com.huawei.openalliance.ad.constant.cf.RES.toString())) {
            inputStreamI = B(str);
        } else {
            inputStreamI = str.startsWith(com.huawei.openalliance.ad.constant.cf.CONTENT.toString()) ? I(str) : Z(str);
        }
        if (inputStreamI != null) {
            try {
                this.o = new dx(inputStreamI, 100);
                L();
            } catch (Exception unused) {
                fh.I(e(), "exception in creating gif decoder");
                D();
            }
        }
    }

    private Paint Z() {
        if (this.f == null) {
            this.f = new Paint(2);
        }
        return this.f;
    }

    private InputStream Z(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            fh.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.5
            @Override // java.lang.Runnable
            public void run() {
                dy.D(dy.this);
                if (dy.this.h == 0 || dy.this.l < dy.this.h) {
                    dy.this.B();
                } else {
                    dy.this.V();
                    dy.this.d();
                }
            }
        });
    }

    private void b() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.6
            @Override // java.lang.Runnable
            public void run() {
                if (dy.this.v != null) {
                    dy.this.v.Code();
                }
            }
        });
    }

    private void c() {
        this.k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        fh.V(e(), "on play end");
        c();
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.8
            @Override // java.lang.Runnable
            public void run() {
                if (dy.this.v != null) {
                    dy.this.v.I();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "GifDrawable_" + hashCode();
    }

    public void Code() {
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        fh.V(e(), "play " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        V();
        C();
        Code(this.i);
    }

    public void Code(int i) {
        this.h = i;
    }

    public void Code(Drawable.Callback callback) {
        this.u.put(callback, null);
        setCallback(this);
    }

    public void Code(a aVar) {
        this.w = aVar;
    }

    public void Code(ea eaVar) {
        this.v = eaVar;
    }

    public int I() {
        int size = (this.k.size() + this.j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    public void V() {
        fh.V(e(), "stop play " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        com.huawei.openalliance.ad.utils.bj.Code(this.f3822a);
        Code(true);
        this.j.clear();
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dy.1
            @Override // java.lang.Runnable
            public void run() {
                dy.this.S();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dz dzVar = this.r;
        if (dzVar == null || dzVar.V == null) {
            return;
        }
        if (fh.Code()) {
            fh.Code(e(), "draw frame: %d", Integer.valueOf(this.r.Code));
        }
        if (this.s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.c);
            this.s = false;
        }
        canvas.drawBitmap(this.r.V, (Rect) null, this.c, Z());
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.t.V();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        dz dzVar = this.r;
        return dzVar != null ? dzVar.V.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        dz dzVar = this.r;
        return dzVar != null ? dzVar.V.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Z().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Z().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        fh.V(e(), "setVisible " + z);
        if (!z) {
            stop();
        } else if (!this.g) {
            start();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        fh.V(e(), "start");
        this.g = true;
        Code();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        fh.V(e(), "stop");
        this.g = false;
        V();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }
}
