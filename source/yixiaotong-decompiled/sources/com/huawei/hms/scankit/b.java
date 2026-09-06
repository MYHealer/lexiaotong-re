package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.c0;
import com.huawei.hms.scankit.p.f1;
import com.huawei.hms.scankit.p.f3;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.g3;
import com.huawei.hms.scankit.p.h0;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.m4;
import com.huawei.hms.scankit.p.n4;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: CaptureHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    public static final String G = "b";
    public static volatile f3 H;
    public static volatile g3 I;
    private IOnErrorCallback D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f4187a;
    private final int b;
    private final boolean c;
    private Context d;
    private com.huawei.hms.scankit.a e;
    private n4 f;
    private g0 g;
    private ViewfinderView h;
    public TextureView i;
    private TextureView.SurfaceTextureListener j;
    private Collection<BarcodeFormat> k;
    private Map<f1, ?> l;
    private String m;
    private String o;
    private float q;
    private boolean u;
    private boolean v;
    private boolean w;
    private IObjectWrapper x;
    private m4 y;
    private IOnResultCallback z;
    private boolean p = true;
    private boolean r = true;
    private boolean s = false;
    private boolean t = true;
    private boolean A = false;
    private boolean B = false;
    private boolean E = true;
    private boolean F = false;
    private boolean n = false;
    private boolean C = false;

    /* JADX INFO: compiled from: CaptureHelper.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g.m();
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.scankit.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CaptureHelper.java */
    class C0529b implements g0.d {
        C0529b() {
        }

        @Override // com.huawei.hms.scankit.p.g0.d
        public void a() {
        }

        @Override // com.huawei.hms.scankit.p.g0.d
        public void b() {
            if (b.this.D != null) {
                try {
                    b.this.D.onError(-1000);
                } catch (RemoteException unused) {
                    x3.b(b.G, "RemoteException");
                }
            }
        }

        @Override // com.huawei.hms.scankit.p.g0.d
        public void c() {
        }
    }

    /* JADX INFO: compiled from: CaptureHelper.java */
    class c implements TextureView.SurfaceTextureListener {
        c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.B = false;
            if (surfaceTexture == null) {
                x3.b(b.G, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (b.this.n) {
                return;
            }
            b.this.n = true;
            if (b.this.d.checkPermission(PermissionUtil.PERSSION_CAMERA, Process.myPid(), Process.myUid()) == 0) {
                b bVar = b.this;
                bVar.a(bVar.i);
            } else if (b.this.d instanceof Activity) {
                b.this.B = true;
                ((Activity) b.this.d).requestPermissions(new String[]{PermissionUtil.PERSSION_CAMERA}, 1);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.n = false;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: CaptureHelper.java */
    class d implements n4 {
        d() {
        }

        @Override // com.huawei.hms.scankit.p.n4
        public void a(HmsScan[] hmsScanArr, Bitmap bitmap, float f) {
            b.this.a(hmsScanArr, bitmap);
        }
    }

    public b(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i, IObjectWrapper iObjectWrapper, boolean z, String str, boolean z2) {
        this.d = context;
        this.h = viewfinderView;
        this.x = iObjectWrapper;
        this.i = textureView;
        this.f4187a = rect;
        this.b = i;
        this.c = z;
        this.o = str;
        this.v = z2;
    }

    public b a(m4 m4Var) {
        this.y = m4Var;
        return this;
    }

    public g0 a() {
        return this.g;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.D = iOnErrorCallback;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.z = iOnResultCallback;
    }

    public void b(boolean z) {
        this.E = z;
    }

    public boolean b() {
        return this.F;
    }

    private void j() {
        com.huawei.hms.scankit.a aVar = this.e;
        if (aVar != null) {
            aVar.e();
            this.e = null;
        }
        this.i.setSurfaceTextureListener(null);
        this.g.l();
    }

    public void i() {
        try {
            g0 g0Var = this.g;
            if (g0Var != null) {
                g0Var.d(1);
            }
        } catch (RuntimeException unused) {
            x3.b(G, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            x3.b(G, "Exception in reset zoomValue");
        }
    }

    public void d() {
        this.C = true;
        this.g.k();
        I.l.b();
        I = null;
    }

    public void e() {
        this.C = true;
        if (this.A) {
            return;
        }
        j();
    }

    public void g() {
        this.C = false;
        TextureView textureView = this.i;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.j);
            this.A = true;
            if (this.n) {
                a(this.i);
            } else {
                this.i.setSurfaceTextureListener(this.j);
            }
        }
    }

    public void h() {
        this.C = true;
        if (H != null) {
            H.i();
        }
        H = null;
        if (this.A) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView != null && textureView.getSurfaceTexture() != null) {
            try {
                this.g.a(textureView);
                this.g.a(Collections.singletonList(new h0.a(new Rect(-150, -150, 150, 150), 1000)));
                try {
                    this.g.n();
                } catch (Exception unused) {
                    x3.b(G, "initCamera() get exception");
                }
                if (this.e == null) {
                    com.huawei.hms.scankit.a aVar = new com.huawei.hms.scankit.a(this.d, this.h, this.f, this.k, this.l, this.m, this.g, this.f4187a, this.b, this.v, this.E);
                    this.e = aVar;
                    aVar.c(this.u);
                    this.e.a(this.w);
                    this.e.b(this.r);
                    this.e.a(this.y);
                    return;
                }
                return;
            } catch (Exception e) {
                if (H != null) {
                    H.c(AVMDLDataLoader.AVMDLErrorIsTooManyTask);
                }
                x3.a(G, "initCamera IOException", e);
                return;
            }
        }
        x3.d(G, "initCamera() no surface view");
    }

    public void f() {
        TextureView textureView;
        TextureView textureView2;
        this.C = false;
        try {
            H = new f3((Bundle) ObjectWrapper.unwrap(this.x), this.o);
            H.h();
        } catch (RuntimeException unused) {
            x3.b(G, "RuntimeException");
        } catch (Exception unused2) {
            x3.b(G, "Exception");
        }
        if (!this.A && !this.n && (textureView2 = this.i) != null) {
            textureView2.setSurfaceTextureListener(this.j);
            if (this.n) {
                a(this.i);
            } else {
                this.i.setSurfaceTextureListener(this.j);
            }
        }
        if (this.B && this.d.checkPermission(PermissionUtil.PERSSION_CAMERA, Process.myPid(), Process.myUid()) == 0 && (textureView = this.i) != null) {
            this.B = false;
            a(textureView);
        }
    }

    public void c() {
        this.C = false;
        try {
            I = new g3((Bundle) ObjectWrapper.unwrap(this.x), this.o);
            I.a("single");
        } catch (RuntimeException unused) {
            x3.b(G, "RuntimeException");
        } catch (Exception unused2) {
            x3.b(G, "Exception");
        }
        if (this.d.getPackageManager() != null && !this.d.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            Log.e("scankit", "has no camera");
            return;
        }
        c0 c0VarA = a(this.d);
        Log.i(G, "onCreate: CameraManageOncreate");
        this.g = new g0(this.d, c0VarA);
        new Thread(new a()).start();
        this.g.a(new C0529b());
        this.j = new c();
        this.f = new d();
    }

    public boolean b(MotionEvent motionEvent) {
        g0 g0Var = this.g;
        if (g0Var == null || !this.p || g0Var.f().a() < g0.c.CAMERA_OPENED.a() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float fA = a(motionEvent);
            float f = this.q;
            if (fA > f + 6.0f) {
                a(true, this.g);
            } else if (fA < f - 6.0f) {
                a(false, this.g);
            } else {
                x3.c("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.q = fA;
        } else if (action == 5) {
            this.q = a(motionEvent);
        }
        return true;
    }

    private void a(boolean z, g0 g0Var) {
        try {
            j0 j0VarG = g0Var.g();
            if (g0Var.j()) {
                int iC = j0VarG.c();
                int iB = j0VarG.b();
                if (z && iB < iC) {
                    iB++;
                } else if (iB > 0) {
                    iB--;
                } else {
                    x3.c(G, "handleZoom  zoom not change");
                }
                g0Var.d(iB);
                return;
            }
            x3.c(G, "zoom not supported");
        } catch (RuntimeException unused) {
            Log.e(G, "handleZoom: RuntimeException");
        }
    }

    private float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        double dSqrt = Math.sqrt((x * x) + (y * y));
        if (Double.isInfinite(dSqrt) || Double.isNaN(dSqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(dSqrt).floatValue();
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        x3.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = G;
            x3.c(str, "result onResult");
            if (this.y.a()) {
                x3.c(str, "result intercepted");
                return;
            }
            if (H != null) {
                H.a(hmsScanArr);
            }
            if (!this.c) {
                hmsScanArr = y6.a(hmsScanArr);
            }
            if (this.y != null) {
                if (this.h != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                    x3.c(str, "result draw result point");
                    if (this.d instanceof Activity) {
                        this.h.a(hmsScanArr[0].getBorderRect(), y6.c((Activity) this.d), this.g.e());
                    }
                    this.C = false;
                }
                this.y.a(hmsScanArr);
            }
            if (this.z != null) {
                try {
                    x3.c(str, "result callback end: pauseStatus" + this.C);
                    if (this.C) {
                        return;
                    }
                    if (this.w && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                        Context context = this.d;
                        if (context instanceof Activity) {
                            hmsScanArr[0].originalBitmap = y6.a(bitmap, ((Activity) context).getWindowManager().getDefaultDisplay().getRotation());
                        }
                    }
                    this.z.onResult(hmsScanArr);
                } catch (RemoteException e) {
                    if (H != null) {
                        H.c(-1003);
                    }
                    x3.d("CaptureHelper", "onResult  RemoteException  e:" + e);
                }
            }
        } catch (RuntimeException e2) {
            Log.e(G, "onResult:RuntimeException " + e2);
        } catch (Exception e3) {
            Log.e(G, "onResult:Exception: " + e3);
        }
    }

    public b a(boolean z) {
        this.w = z;
        com.huawei.hms.scankit.a aVar = this.e;
        if (aVar != null) {
            aVar.a(z);
        }
        return this;
    }

    private c0 a(Context context) {
        c0 c0VarA;
        Activity activity = (Activity) context;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        Log.i(G, "initCameraConfig:false");
        if (rotation == 0) {
            c0VarA = new c0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else if (rotation == 1) {
            c0VarA = new c0.b().a(new Point(1920, 1080)).a(1).b(0).b(false).a(true).a();
        } else if (rotation == 2) {
            c0VarA = new c0.b().a(new Point(1920, 1080)).a(1).b(270).b(false).a(true).a();
        } else if (rotation != 3) {
            c0VarA = new c0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else {
            c0VarA = new c0.b().a(new Point(1920, 1080)).a(1).b(180).b(false).a(true).a();
        }
        if (y6.e(context) || y6.b(activity) || y6.d(context)) {
            c0VarA.a(new Point(1080, 1080));
            this.F = true;
        }
        if ("ceres-c3".equals(Build.DEVICE)) {
            c0VarA = new c0.b().a(new Point(1080, 1920)).a(1).b(false).a(true).a();
        }
        boolean zB = y6.b();
        boolean zD = y6.d();
        if ((!y6.d(context) || zB) && (!y6.b(activity) || zD)) {
            return c0VarA;
        }
        c0 c0VarA2 = new c0.b().a(new Point(1080, 1080)).a(1).b(90).b(false).a(true).a();
        this.F = true;
        return c0VarA2;
    }
}
