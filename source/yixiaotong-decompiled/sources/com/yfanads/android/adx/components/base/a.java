package com.yfanads.android.adx.components.base;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import com.stub.StubApp;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: ActionHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9565a = new LinkedHashMap();
    public final LinkedList b = new LinkedList();

    /* JADX INFO: renamed from: com.yfanads.android.adx.components.base.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionHelper.java */
    public static class C1170a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9566a = new a();
    }

    public a() {
        com.yfanads.android.adx.interact.a.a().a(new com.yfanads.android.adx.interact.a.InterfaceC1172a() { // from class: com.yfanads.android.adx.components.base.a$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.adx.interact.a.InterfaceC1172a
            public final void a(int i, String[] strArr) {
                this.f$0.b(i, strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, String[] strArr) {
        if (com.yfanads.android.adx.utils.b.b()) {
            com.yfanads.android.adx.utils.a.c("ActionHelper action done");
            a(i, strArr);
        }
    }

    public final void a(int i, String[] strArr) {
        if (this.b.isEmpty()) {
            YFLog.warn("ActionHelper action but has no show views, return.");
            return;
        }
        double d = 0.0d;
        int iHashCode = 0;
        for (View view : this.b) {
            ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = view.getWidth();
            int height = (view.getHeight() / 2) + i3;
            int[] iArr2 = com.yfanads.android.adx.service.c.a.f9618a.y;
            int i4 = ((width / 2) + i2) - iArr2[0];
            int i5 = height - iArr2[1];
            double dSqrt = Math.sqrt((i5 * i5) + (i4 * i4));
            YFLog.debug("ActionHelper viewDistance " + dSqrt);
            if (dSqrt < d || d == 0.0d) {
                iHashCode = view.hashCode();
                d = dSqrt;
            }
        }
        if (iHashCode <= 0) {
            com.yfanads.android.adx.utils.a.d("ActionHelper action minHashCode is 0");
            return;
        }
        com.yfanads.android.adx.components.model.a aVar = (com.yfanads.android.adx.components.model.a) this.f9565a.get(Integer.valueOf(iHashCode));
        com.yfanads.android.adx.utils.a.a("ActionHelper action findCenter view start is " + aVar);
        if (aVar != null && aVar.g != null) {
            try {
                if (aVar.f) {
                    com.yfanads.android.adx.components.model.a aVar2 = (com.yfanads.android.adx.components.model.a) this.f9565a.remove(Integer.valueOf(iHashCode));
                    boolean zRemove = this.b.remove(aVar.f9576a);
                    com.yfanads.android.adx.utils.a.a("ActionHelper action remove register " + (aVar2 != null) + " , showView " + zRemove);
                    if (zRemove) {
                        a("removeView");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a("findCenterAds");
            aVar.g.a(i, strArr);
        }
        com.yfanads.android.adx.utils.a.a("ActionHelper action findCenter view end");
    }

    public static void b() {
        com.yfanads.android.adx.interact.a aVar = com.yfanads.android.adx.interact.a.b.f9603a;
        if (aVar.k) {
            com.yfanads.android.adx.utils.a.a("ActionHelper stopAction ");
            try {
                com.yfanads.android.adx.interact.b bVar = aVar.e;
                if (bVar != null) {
                    bVar.a();
                    aVar.e = null;
                    aVar.b = null;
                }
                com.yfanads.android.adx.interact.d dVar = aVar.f;
                if (dVar != null) {
                    dVar.a();
                    aVar.f = null;
                    aVar.b = null;
                }
                aVar.k = false;
                com.yfanads.android.adx.utils.a.a("action stop success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(boolean z) {
        Iterator it = this.f9565a.values().iterator();
        while (it.hasNext()) {
            b bVar = ((com.yfanads.android.adx.components.model.a) it.next()).h;
            if (bVar != null) {
                bVar.b(z);
            }
        }
    }

    public final void a() {
        com.yfanads.android.adx.interact.a aVar = com.yfanads.android.adx.interact.a.b.f9603a;
        if (aVar.k) {
            com.yfanads.android.adx.utils.a.a("ActionHelper action is working");
            return;
        }
        if (YFListUtils.isEmpty(this.b)) {
            com.yfanads.android.adx.utils.a.d("ActionHelper startAction but showView is empty");
            b();
            return;
        }
        com.yfanads.android.adx.components.model.a aVar2 = (com.yfanads.android.adx.components.model.a) this.f9565a.get(Integer.valueOf(((View) this.b.get(0)).hashCode()));
        com.yfanads.android.adx.utils.a.a("ActionHelper startAction " + aVar2);
        if (aVar2 != null) {
            boolean z = !aVar2.d;
            aVar.j = z;
            int i = aVar2.b;
            aVar.c = i;
            if (i == 1) {
                float fFloatValue = 10.0f;
                try {
                    BigDecimal bigDecimal = new BigDecimal(aVar2.e);
                    BigDecimal bigDecimal2 = new BigDecimal(14.0f);
                    BigDecimal bigDecimal3 = new BigDecimal(10.0f);
                    fFloatValue = bigDecimal3.add(bigDecimal2.subtract(bigDecimal3).multiply(bigDecimal).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP).floatValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aVar.d = fFloatValue;
            } else if (i == 2) {
                float f = aVar2.e;
                float f2 = z ? 0.5f : 1.0f;
                float fFloatValue2 = 0.1f;
                try {
                    BigDecimal bigDecimal4 = new BigDecimal(f);
                    BigDecimal bigDecimal5 = new BigDecimal(f2);
                    BigDecimal bigDecimal6 = new BigDecimal(0.1f);
                    fFloatValue2 = bigDecimal6.add(bigDecimal5.subtract(bigDecimal6).multiply(bigDecimal4).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP).floatValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                aVar.d = fFloatValue2;
            }
            com.yfanads.android.adx.utils.a.a("action start registerAction");
            try {
                int i2 = aVar.c;
                if (i2 == 1) {
                    Context context = com.yfanads.android.adx.service.d.b;
                    if (aVar.b == null) {
                        aVar.b = (Vibrator) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("vibrator");
                    }
                    if (aVar.f9602a == null) {
                        aVar.f9602a = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
                    }
                    if (aVar.e == null) {
                        com.yfanads.android.adx.interact.b bVar = new com.yfanads.android.adx.interact.b(aVar);
                        aVar.e = bVar;
                        bVar.f9604a = aVar.d;
                    }
                    aVar.e.a(aVar.f9602a);
                    aVar.k = true;
                    com.yfanads.android.adx.utils.a.a("action start shake success");
                    return;
                }
                if (i2 == 2) {
                    Context context2 = com.yfanads.android.adx.service.d.b;
                    if (aVar.b == null) {
                        aVar.b = (Vibrator) StubApp.getOrigApplicationContext(context2.getApplicationContext()).getSystemService("vibrator");
                    }
                    if (aVar.f9602a == null) {
                        aVar.f9602a = (SensorManager) StubApp.getOrigApplicationContext(context2.getApplicationContext()).getSystemService("sensor");
                    }
                    if (aVar.f == null) {
                        com.yfanads.android.adx.interact.d dVar = new com.yfanads.android.adx.interact.d(aVar);
                        aVar.f = dVar;
                        float f3 = aVar.d;
                        dVar.f9609a = f3;
                        YFLog.debug("twistDetector threshold:" + f3);
                    }
                    boolean zA = aVar.f.a(aVar.f9602a);
                    aVar.k = true;
                    com.yfanads.android.adx.utils.a.a("action start twist :".concat(zA ? "Success" : "Fail"));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void a(String str) {
        com.yfanads.android.adx.utils.a.a("ActionHelper checkStartAction from " + str + " , show " + this.b.size());
        if (YFListUtils.isEmpty(this.b)) {
            b();
        } else {
            a();
        }
    }

    public final synchronized void a(View view) {
        if (this.b.contains(view)) {
            com.yfanads.android.adx.components.model.a aVar = (com.yfanads.android.adx.components.model.a) this.f9565a.get(Integer.valueOf(view.hashCode()));
            if (aVar != null) {
                this.b.remove(aVar.f9576a);
            }
            com.yfanads.android.adx.utils.a.a("ActionHelper removeShowView " + view.hashCode() + " , " + this.b.size());
            a("removeShowView");
        }
    }

    public final void a(com.yfanads.android.adx.components.model.a aVar) {
        try {
            if (aVar == null) {
                YFLog.high("ActionHelper unRegisterViewAction actionModel is null");
                return;
            }
            YFLog.debug("unRegisterViewAction showViews size" + this.b.size() + "|" + aVar.f9576a);
            ViewGroup viewGroup = aVar.f9576a;
            if (viewGroup != null) {
                this.f9565a.remove(Integer.valueOf(viewGroup.hashCode()));
                this.b.remove(aVar.f9576a);
                b bVar = aVar.h;
                if (bVar != null) {
                    bVar.b(aVar.f9576a);
                    aVar.h = null;
                }
                aVar.f9576a = null;
                aVar.g = null;
                YFLog.debug("unRegisterViewAction showViews size" + this.b.size());
            } else {
                YFLog.high("ActionHelper unRegisterViewAction action view is null");
            }
            aVar.g = null;
            a("unRegisterViewAction");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
