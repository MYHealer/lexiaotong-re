package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.g3;
import com.huawei.hms.scankit.p.m4;
import com.huawei.hms.scankit.p.v5;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import java.util.Iterator;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: compiled from: IRemoteCustomedViewDelegateImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e extends IRemoteViewDelegate.Stub implements m4, SensorEventListener {
    private static final String x = "e";
    protected static boolean y;
    protected int b;
    protected Context c;
    protected ProviderRemoteView d;
    protected TextureView e;
    protected com.huawei.hms.scankit.b f;
    protected IOnResultCallback g;
    protected SensorManager h;
    protected View.OnClickListener i;
    protected Boolean l;
    protected AlertDialog m;
    protected Rect n;
    private IObjectWrapper o;
    protected boolean p;
    private OrientationEventListener q;
    private boolean r;
    protected boolean s;
    protected IOnLightCallback u;
    protected LinearLayout v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile g3 f4199a = null;
    protected boolean j = false;
    protected final Float k = Float.valueOf(40.0f);
    protected boolean t = true;
    boolean w = false;

    /* JADX INFO: compiled from: IRemoteCustomedViewDelegateImpl.java */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            e.this.f.b(motionEvent);
            return true;
        }
    }

    /* JADX INFO: compiled from: IRemoteCustomedViewDelegateImpl.java */
    class b extends OrientationEventListener {
        b(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int rotation = ((Activity) e.this.c).getWindowManager().getDefaultDisplay().getRotation();
            boolean zB = y6.b();
            boolean zD = y6.d();
            if (y6.d(e.this.c) && !zB) {
                e.this.a(90);
                return;
            }
            if (y6.b((Activity) e.this.c) && !zD) {
                e.this.a(90);
                return;
            }
            if (rotation == 0) {
                e.this.a(90);
                return;
            }
            if (rotation == 1) {
                e.this.a(0);
            } else if (rotation == 2) {
                e.this.a(270);
            } else {
                if (rotation != 3) {
                    return;
                }
                e.this.a(180);
            }
        }
    }

    /* JADX INFO: compiled from: IRemoteCustomedViewDelegateImpl.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.m.dismiss();
        }
    }

    public e(Context context, int i, Object obj, IObjectWrapper iObjectWrapper, boolean z, boolean z2, boolean z3) {
        this.b = 0;
        this.p = false;
        this.c = context;
        this.b = i;
        this.o = iObjectWrapper;
        if (obj instanceof Rect) {
            this.n = (Rect) obj;
        } else {
            this.n = null;
        }
        this.p = z;
        this.r = z2;
        this.s = z3;
    }

    @Override // com.huawei.hms.scankit.p.m4
    public boolean a() {
        return this.w;
    }

    protected boolean b() {
        try {
            return this.f.a().h().equals(CameraConfig.CAMERA_TORCH_ON);
        } catch (RuntimeException unused) {
            x3.b(x, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            x3.b(x, "getFlashStatusException");
            return false;
        }
    }

    protected void c() {
        Object systemService = this.c.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.h = sensorManager;
            Iterator<Sensor> it = sensorManager.getSensorList(-1).iterator();
            while (it.hasNext()) {
                if (5 == it.next().getType()) {
                    this.j = true;
                    return;
                }
            }
        }
    }

    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext(), true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle = (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        if (this.f4199a == null) {
            try {
                this.f4199a = new g3(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                x3.b(x, "RuntimeException");
            } catch (Exception unused2) {
                x3.b(x, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    protected void e() {
        ProviderRemoteView providerRemoteViewD = d();
        this.d = providerRemoteViewD;
        this.e = (TextureView) providerRemoteViewD.findViewById(R.id.surfaceView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.c, this.e, null, this.n, this.b, this.o, this.p, "CustomizedView", true);
        this.f = bVar;
        bVar.b(this.s);
        c();
        a(true);
    }

    protected void f() {
        try {
            com.huawei.hms.scankit.b bVar = this.f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f.a().a("off");
        } catch (RuntimeException unused) {
            x3.b(x, "offFlashRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "offFlashException");
        }
    }

    public void g() {
        try {
            com.huawei.hms.scankit.b bVar = this.f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f.a().a(CameraConfig.CAMERA_TORCH_ON);
        } catch (RuntimeException unused) {
            x3.b(x, "openFlashRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "openFlashException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.d);
    }

    protected void h() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.c).create();
        this.m = alertDialogCreate;
        alertDialogCreate.show();
        View viewInflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.m.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(viewInflate);
        window.setGravity(80);
        viewInflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new c());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        Context context = this.c;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.c).getWindow().setFlags(16777216, 16777216);
        }
        Context context2 = this.c;
        if (context2 != null && context2.getPackageManager() != null) {
            this.t = this.c.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        }
        e();
        this.f.a(this);
        this.d.setOnTouchListener(new a());
        IOnResultCallback iOnResultCallback = this.g;
        if (iOnResultCallback != null) {
            this.f.a(iOnResultCallback);
        }
        this.f.a(this.r);
        this.f.c();
        b bVar = new b(this.c);
        this.q = bVar;
        if (bVar.canDetectOrientation()) {
            this.q.enable();
        } else {
            this.q.disable();
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onDestroy() {
        try {
            this.f.d();
            OrientationEventListener orientationEventListener = this.q;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.q.disable();
            }
            if (this.c != null) {
                this.c = null;
            }
            AlertDialog alertDialog = this.m;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.m.dismiss();
            this.m = null;
        } catch (RuntimeException unused) {
            x3.b(x, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "onDestroyException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onPause() {
        try {
            this.f.e();
            this.h.unregisterListener(this);
        } catch (RuntimeException unused) {
            x3.b(x, "onPauseRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "onPauseException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        try {
            this.f.f();
            SensorManager sensorManager = this.h;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException unused) {
            x3.b(x, "onResumeRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "onResumeException");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.j && sensorEvent.sensor.getType() == 5 && this.t) {
            Boolean boolValueOf = Boolean.valueOf(sensorEvent.values[0] > this.k.floatValue());
            this.l = boolValueOf;
            if (!boolValueOf.booleanValue()) {
                LinearLayout linearLayout = this.v;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback = this.u;
                if (iOnLightCallback != null) {
                    try {
                        iOnLightCallback.onVisibleChanged(true);
                        return;
                    } catch (RemoteException unused) {
                        x3.d(x, "onSensorChanged RemoteException");
                        return;
                    }
                }
                return;
            }
            if (sensorEvent.values[0] > 600.0f) {
                if (this.v != null && !b()) {
                    this.v.setVisibility(8);
                }
                IOnLightCallback iOnLightCallback2 = this.u;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(false);
                    } catch (RemoteException unused2) {
                        x3.d(x, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        try {
            this.f.g();
        } catch (RuntimeException unused) {
            x3.b(x, "onStartRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "onStartException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        try {
            this.f.h();
        } catch (RuntimeException unused) {
            x3.b(x, "onStopRuntimeException");
        } catch (Exception unused2) {
            x3.b(x, "onStopException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void resumeContinuouslyScan() throws RemoteException {
        this.w = false;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.u = iOnLightCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
        f();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.huawei.hms.scankit.b bVar = this.f;
        if (bVar == null || bVar.a() == null || i == this.f.a().d()) {
            return;
        }
        this.f.a().b(i);
        if (this.f.a().i()) {
            a(false);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void pauseContinuouslyScan() throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f;
        if (bVar != null) {
            bVar.i();
        }
        this.w = true;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f;
        if (bVar != null) {
            bVar.a(iOnErrorCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.g = iOnResultCallback;
        com.huawei.hms.scankit.b bVar = this.f;
        if (bVar != null) {
            bVar.a(iOnResultCallback);
        }
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (!y6.e(context) && !y6.d(context)) {
            defaultDisplay.getRealSize(point);
        } else {
            Log.i(x, "initSurfaceView: is in MultiWindowMode");
            defaultDisplay.getSize(point);
        }
        return point;
    }

    protected void a(Point point, boolean z) {
        int i;
        int i2;
        float f;
        float f2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        float f3 = point.x;
        float f4 = point.y;
        boolean zB = y6.b();
        x3.c(x, "initSurfaceViewSize: isPortraitScreen: " + y6.c((Activity) this.c) + " inMultiWindow: " + y6.e(this.c) + " isInMultiWindowFreeform: " + y6.b((Activity) this.c) + " isPadOrFold: " + y6.i(this.c) + " isFoldStateExpand: " + y6.g(this.c) + " isPad: " + y6.h(this.c) + " inMagicWindow: " + y6.d(this.c) + " ignore: " + zB + " screen: " + point.toString() + " width: " + layoutParams.width + " height: " + layoutParams.height + " inMagicWindow " + y6.d(this.c) + " ignore " + zB + " isInit " + z + " isSpecialExpectSize " + this.f.b());
        if (!y6.c((Activity) this.c) && (!y6.d(this.c) || (y6.d(this.c) && zB))) {
            y = true;
            float f5 = 1280.0f;
            if (z && (y6.e(this.c) || y6.b((Activity) this.c) || y6.d(this.c))) {
                f = 1280.0f;
                f2 = 1280.0f;
            } else {
                f = 1920.0f;
                f2 = 1080.0f;
            }
            if (this.f.b()) {
                f2 = 1280.0f;
            } else {
                f5 = f;
            }
            float f6 = f3 / f5;
            float f7 = f4 / f2;
            if (f6 > f7) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f2 * f6);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f5 * f7);
                layoutParams.gravity = 17;
            }
        } else {
            y = false;
            boolean zEquals = "ceres-c3".equals(Build.DEVICE);
            int i3 = MediaDiscoverer.Event.Started;
            if (zEquals) {
                i = 1280;
                i2 = 1280;
            } else {
                i = 1080;
                i2 = 1920;
            }
            if (z && (y6.e(this.c) || y6.b((Activity) this.c) || y6.d(this.c))) {
                i = 1280;
                i2 = 1280;
            }
            if (this.f.b()) {
                i2 = 1280;
            } else {
                i3 = i;
            }
            float f8 = i3;
            float f9 = f3 / f8;
            float f10 = i2;
            float f11 = f4 / f10;
            if (f9 > f11) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f10 * f9);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f8 * f11);
                layoutParams.gravity = 17;
            }
        }
        this.e.setLayoutParams(layoutParams);
    }

    protected void a(boolean z) {
        try {
            if (this.c.getSystemService("window") != null) {
                a(a(this.c), z);
            }
        } catch (NullPointerException unused) {
            x3.d(x, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            x3.d(x, "initSurfaceView: Exception");
        }
    }

    @Override // com.huawei.hms.scankit.p.m4
    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.m) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.m.dismiss();
        return false;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        int iB;
        if (iObjectWrapper == null) {
            x3.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            iB = 0;
        } else {
            iB = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i;
            z = i >= 2;
            if (z) {
                iB = y6.b(iB);
            }
        }
        HmsScan[] hmsScanArrB = v5.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), iB, true, this.f4199a);
        if (!z) {
            hmsScanArrB = y6.a(hmsScanArrB);
        }
        if (hmsScanArrB.length == 0) {
            h();
        } else {
            HmsScan hmsScan = hmsScanArrB[0];
            if (hmsScan != null && TextUtils.isEmpty(hmsScan.originalValue)) {
                h();
            }
        }
        return hmsScanArrB;
    }
}
