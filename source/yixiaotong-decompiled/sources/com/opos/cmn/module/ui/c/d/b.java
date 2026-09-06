package com.opos.cmn.module.ui.c.d;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.openalliance.ad.constant.br;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6220a;
    private com.opos.cmn.module.ui.c.b.a b;
    private Toast c;

    public b(Context context, com.opos.cmn.module.ui.c.b.a aVar) {
        this.f6220a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = aVar;
        this.c = new Toast(this.f6220a);
    }

    private Object a(Object obj, String str) {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            if (com.opos.cmn.an.d.a.a(str) || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e);
            return null;
        }
    }

    public WindowManager.LayoutParams a() {
        Object objA;
        WindowManager.LayoutParams layoutParams = null;
        try {
            Object objA2 = a(this.c, "mTN");
            if (objA2 != null && (objA = a(objA2, "mParams")) != null && (objA instanceof WindowManager.LayoutParams)) {
                layoutParams = (WindowManager.LayoutParams) objA;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("CustomToast", "getWindowLayoutParams=" + (layoutParams != null ? layoutParams : "null"));
        return layoutParams;
    }

    public void a(int i) {
        com.opos.cmn.an.f.a.b("CustomToast", "setDuration duration=" + i);
        this.c.setDuration(i);
    }

    public void a(int i, int i2, int i3) {
        com.opos.cmn.an.f.a.b("CustomToast", "setGravity gravity=" + i + ",xOffset=" + i2 + ",yOffset=" + i3);
        this.c.setGravity(i, i2, i3);
    }

    public void a(View view) {
        com.opos.cmn.an.f.a.b("CustomToast", "setView view=" + (view != null ? view : "null"));
        if (view != null) {
            this.c.setView(view);
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("CustomToast", br.b.V);
        this.c.show();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("CustomToast", Constant.CASH_LOAD_CANCEL);
        this.c.cancel();
    }
}
