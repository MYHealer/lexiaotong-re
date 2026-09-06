package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.d7;
import com.huawei.hms.scankit.p.e0;
import com.huawei.hms.scankit.p.f1;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.g3;
import com.huawei.hms.scankit.p.h0;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.q3;
import com.huawei.hms.scankit.p.w5;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.x5;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class c extends Handler {
    private static a j;
    private static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4192a;
    private final g0 b;
    private final com.huawei.hms.scankit.a c;
    private boolean d = true;
    private int e = 50;
    private Rect f;
    private int g;
    private IRemoteFrameDecoderDelegate h;
    private boolean i;

    /* JADX INFO: compiled from: DecodeHandler.java */
    private static class a extends AsyncTask<Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<c> f4193a;
        private List<h0.a> e;
        private List<h0.a> f;
        private boolean b = true;
        private boolean c = false;
        private int d = 0;
        private int g = 0;
        private int h = 0;

        public a(c cVar) {
            this.f4193a = new WeakReference<>(cVar);
        }

        private void a() {
            this.d = 0;
            this.g = 0;
        }

        public void a(int i) {
            this.d += i;
            this.g++;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            Log.i("ScankitDecode", "doInBackground: ");
            if (c.j.isCancelled()) {
                return null;
            }
            while (!this.c) {
                if (this.b) {
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        x3.c("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.b = false;
                } else {
                    c cVar = this.f4193a.get();
                    int i = this.g;
                    if (i == 0) {
                        this.b = true;
                    } else if (cVar != null) {
                        try {
                            cVar.a(this.d / i, this.e);
                            x3.c("DecodeHandler", "ScanCode handle auto value" + (this.d / this.g));
                            a();
                            this.b = true;
                        } catch (RuntimeException e) {
                            x3.b("DecodeHandler", "RuntimeException: " + e.getMessage());
                        } catch (Exception unused2) {
                            x3.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public void b(int i) {
            this.h = i;
            c cVar = this.f4193a.get();
            if (cVar != null) {
                try {
                    cVar.a(this.h, this.f);
                    x3.c("DecodeHandler", "ScanCode handle global value" + this.h);
                } catch (RuntimeException e) {
                    x3.b("DecodeHandler", "RuntimeException: " + e.getMessage());
                } catch (Exception unused) {
                    x3.b("DecodeHandler", "Exception");
                }
            }
        }

        public void a(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                x3.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f = Collections.singletonList(new h0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f = new ArrayList();
            for (Rect rect : list) {
                int iCenterX = ((rect.centerX() * 2000) / i) - 1000;
                int iCenterY = ((rect.centerY() * 2000) / i2) - 1000;
                int iWidth = ((rect.width() * 2000) / i) / 2;
                int iHeight = ((rect.height() * 2000) / i2) / 2;
                this.f.add(new h0.a(new Rect(iCenterX - (iWidth / 2), iCenterY - (iHeight / 2), iCenterX + iWidth, iCenterY + iHeight), 1000 / list.size()));
            }
            list.clear();
        }

        public void b(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                x3.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.e = Collections.singletonList(new h0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.e = new ArrayList();
            if (z) {
                int i3 = (i2 > i ? i2 - i : i - i2) >> 1;
                for (Rect rect : list) {
                    int iCenterY = (((rect.centerY() + i3) * 2000) / i) - 1000;
                    int iCenterX = ((rect.centerX() * 2000) / i2) - 1000;
                    int iHeight = ((rect.height() * 2000) / i) / 2;
                    int iWidth = ((rect.width() * 2000) / i2) / 2;
                    this.e.add(new h0.a(new Rect(iCenterY - (iHeight / 2), iCenterX - (iWidth / 2), iCenterY + iHeight, iCenterX + iWidth), 1000 / list.size()));
                }
                return;
            }
            for (Rect rect2 : list) {
                int iCenterX2 = ((rect2.centerX() * 2000) / i) - 1000;
                int iCenterY2 = ((rect2.centerY() * 2000) / i2) - 1000;
                int iWidth2 = ((rect2.width() * 2000) / i) / 2;
                int iHeight2 = ((rect2.height() * 2000) / i2) / 2;
                this.e.add(new h0.a(new Rect(iCenterX2 - (iWidth2 / 2), iCenterY2 - (iHeight2 / 2), iCenterX2 + iWidth2, iCenterY2 + iHeight2), 1000 / list.size()));
            }
            list.clear();
        }
    }

    c(Context context, g0 g0Var, com.huawei.hms.scankit.a aVar, Map<f1, Object> map, Rect rect, boolean z) {
        this.i = false;
        this.f4192a = context;
        this.b = g0Var;
        this.c = aVar;
        this.f = rect;
        if (j == null) {
            a aVar2 = new a(this);
            j = aVar2;
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.g = 0;
        this.i = z;
        a(context);
    }

    public boolean b(float f) {
        boolean z;
        com.huawei.hms.scankit.a aVar = this.c;
        if (aVar != null && aVar.a()) {
            return false;
        }
        try {
            j0 j0VarG = this.b.g();
            if (j0VarG == null) {
                x3.c("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int iC = j0VarG.c();
            int iB = j0VarG.b();
            List<Integer> listA = j0VarG.a();
            float fIntValue = ((listA.get(iB).intValue() * 1.0f) / 100.0f) * f;
            if (((int) (fIntValue * 100.0f)) > listA.get(iC).intValue()) {
                fIntValue = (iC * 1.0f) / 100.0f;
            }
            if (!this.b.j()) {
                x3.c("ScankitDecode", "Zoom not supported");
                return false;
            }
            int iA = a(fIntValue);
            if (iA > iB) {
                this.b.d(iA);
                z = true;
            } else {
                this.b.d(iB);
                z = false;
            }
            this.b.a(Collections.singletonList(new h0.a(new Rect(-150, -150, 150, 150), 1000)));
            return z;
        } catch (RuntimeException unused) {
            x3.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            x3.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    public float c() {
        List<Integer> listB = b();
        if (listB == null) {
            return 1.0f;
        }
        return Math.round(listB.get(listB.size() - 1).intValue() / 100.0f);
    }

    private void a(Context context) {
        Object objNewInstance;
        try {
            if (this.i) {
                Log.d("ScankitDecode", "use local decoder");
                objNewInstance = DecoderCreator.class.newInstance();
            } else {
                Log.d("ScankitDecode", "use remote decoder");
                try {
                    context = com.huawei.hms.hmsscankit.f.e(context);
                } catch (NoSuchMethodException | InvocationTargetException unused) {
                }
                Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.hms.scankit.DecoderCreator");
                context.getClassLoader().loadClass("com.huawei.hms.scankit.aiscan.common.BarcodeFormat");
                objNewInstance = clsLoadClass.newInstance();
            }
        } catch (ClassNotFoundException unused2) {
            x3.a("ScankitDecode", "ClassNotFoundException");
            objNewInstance = null;
        } catch (IllegalAccessException unused3) {
            x3.a("ScankitDecode", "IllegalAccessException");
            objNewInstance = null;
        } catch (InstantiationException unused4) {
            x3.a("ScankitDecode", "InstantiationException");
            objNewInstance = null;
        }
        try {
            if (objNewInstance instanceof IBinder) {
                this.h = IRemoteDecoderCreator.Stub.asInterface((IBinder) objNewInstance).newRemoteFrameDecoderDelegate();
            } else if (this.h == null) {
                this.h = q3.a();
            }
        } catch (RemoteException unused5) {
            x3.a("ScankitDecode", "RemoteException");
        }
    }

    private boolean d() {
        Context context = this.f4192a;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.x < point.y;
        }
        x3.c("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
        return true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException {
        if (message == null || !this.d) {
            return;
        }
        int i = message.what;
        if (i == R.id.scankit_decode) {
            int i2 = this.g;
            if (i2 <= 1) {
                this.g = i2 + 1;
                this.c.sendEmptyMessage(R.id.scankit_decode_failed);
                return;
            } else {
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, d());
                    return;
                }
                return;
            }
        }
        if (i == R.id.scankit_quit) {
            this.d = false;
            a aVar = j;
            if (aVar != null) {
                aVar.c = true;
                j.cancel(true);
            }
            Looper.myLooper().quit();
            return;
        }
        x3.c("ScankitDecode", "handleMessage  message.what:" + message.what);
    }

    public List<Integer> b() {
        return this.b.g().a();
    }

    private void a(byte[] bArr, boolean z) throws RemoteException {
        w5[] w5VarArrDecode;
        int i = this.b.e().x;
        int i2 = this.b.e().y;
        Context context = this.f4192a;
        int rotation = (context == null || !(context instanceof Activity)) ? 0 : ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        if (this.c != null) {
            g3.c cVarA = b.I != null ? b.I.a(false, i * i2) : null;
            Bundle bundle = new Bundle();
            bundle.putParcelable("Rect", this.f);
            Point pointB = d7.b(this.f4192a);
            if (pointB != null) {
                bundle.putParcelable("Screen", pointB);
            }
            try {
                if (b.H != null) {
                    b.H.a(System.currentTimeMillis());
                }
                w5VarArrDecode = this.h.decode(bArr, i, i2, rotation, this.c.b(), ObjectWrapper.wrap(bundle));
            } catch (RemoteException unused) {
                Log.e("ScankitDecode", "RemoteException");
                w5VarArrDecode = null;
            }
            if (w5VarArrDecode != null && w5VarArrDecode.length > 0 && w5VarArrDecode[0] != null) {
                if (this.c.d() && w5VarArrDecode[0].l() != 1.0f && System.currentTimeMillis() - k > 1000) {
                    x3.c("ScankitDecode", "need to zoom" + w5VarArrDecode[0].l());
                    if (a(w5VarArrDecode[0].l(), w5VarArrDecode, cVarA)) {
                        k = System.currentTimeMillis();
                        return;
                    }
                }
                if (w5VarArrDecode[0].k() == null) {
                    if (w5VarArrDecode[0].n()) {
                        x3.c("ScankitDecode", "ScanCode need to globalexposure" + w5VarArrDecode[0].h());
                        j.a(w5VarArrDecode[0].g(), i, i2, false);
                        j.b(w5VarArrDecode[0].h());
                    } else {
                        x3.c("ScankitDecode", "ScanCode need to exposure" + w5VarArrDecode[0].f());
                        j.a(w5VarArrDecode[0].f());
                        j.b(w5VarArrDecode[0].d(), i, i2, z);
                    }
                }
                a(w5VarArrDecode, bArr, i, i2, cVarA);
                return;
            }
            this.c.sendEmptyMessage(R.id.scankit_decode_failed);
            if (b.I != null) {
                b.I.a((HmsScan[]) null, cVarA);
            }
        }
    }

    private boolean a(float f, w5[] w5VarArr, g3.c cVar) {
        if (!b(f)) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] hmsScanArrA = x5.a(w5VarArr);
        messageObtain.obj = hmsScanArrA;
        if (b.I != null) {
            b.I.a(hmsScanArrA, cVar);
        }
        this.c.sendMessage(messageObtain);
        return true;
    }

    private void a(w5[] w5VarArr, byte[] bArr, int i, int i2, g3.c cVar) {
        if (this.c != null) {
            Message messageObtain = Message.obtain(this.c, R.id.scankit_decode_succeeded, x5.a(w5VarArr));
            Log.d("ScankitDecode", "scankit decode succeed msg SCAN_MODE: FULLSDK VERSION_CODE: 20900300 VERSION_NAME: 2.9.0.300");
            if (b.H != null) {
                b.H.a(w5VarArr[0].e(), w5VarArr[0].b(), w5VarArr[0].m());
            }
            if (this.c.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i, i2, bundle);
                messageObtain.setData(bundle);
            }
            messageObtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i, int i2, Bundle bundle) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        bundle.putByteArray(DecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", 1.0f);
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
            Log.e("ScankitDecode", "RemoteException");
        }
    }

    public void a(int i, List<h0.a> list) {
        e0 e0VarB = this.b.b();
        int iB = e0VarB.b();
        int iC = e0VarB.c();
        int iA = e0VarB.a();
        if (i == 0) {
            return;
        }
        int i2 = iA + i;
        if (i2 <= iB) {
            iB = i2 < iC ? iC : i2;
        }
        this.b.c(iB);
        h0 h0VarC = this.b.c();
        Rect rectB = h0VarC.b();
        if (h0VarC.a() > 0) {
            if (h0VarC.a() == 1) {
                int iCenterX = rectB.centerX();
                int iCenterY = rectB.centerY();
                if (Math.sqrt(((iCenterX - list.get(0).f4266a.centerX()) * (iCenterX - list.get(0).f4266a.centerX())) + (iCenterY - list.get(0).f4266a.centerY()) + (iCenterY - list.get(0).f4266a.centerY())) > this.e) {
                    list.set(0, new h0.a(list.get(0).f4266a, 1000));
                    this.b.a(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.b.a(list);
        }
    }

    public int a(float f) {
        List<Integer> listB = b();
        if (listB == null) {
            return -3;
        }
        if (listB.size() <= 0) {
            return -4;
        }
        if (Math.abs(f - 1.0f) < 1.0E-6f) {
            return 0;
        }
        if (f == c()) {
            return listB.size() - 1;
        }
        for (int i = 1; i < listB.size(); i++) {
            float f2 = 100.0f * f;
            if (listB.get(i).intValue() >= f2 && listB.get(i - 1).intValue() <= f2) {
                return i;
            }
        }
        return -1;
    }
}
