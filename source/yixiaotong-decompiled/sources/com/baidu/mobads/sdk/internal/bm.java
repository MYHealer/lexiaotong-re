package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class bm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f1749a;
    final /* synthetic */ bj.a b;

    bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.f1749a = iOAdEvent;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        Object obj;
        String str2;
        Object obj2;
        IOAdEvent iOAdEvent = this.f1749a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f1749a.getType();
        if (z.J.equals(type)) {
            bj.this.a(this.f1749a);
            return;
        }
        if (z.M.equals(type)) {
            bj.this.p = this.f1749a.getMessage();
            bj.this.q();
            return;
        }
        if (z.N.equals(type)) {
            bj.this.e(this.f1749a);
            return;
        }
        if (z.O.equals(type)) {
            bj.this.f(this.f1749a);
            return;
        }
        if (z.W.equals(type)) {
            bj.this.g(this.f1749a);
            return;
        }
        String str3 = "";
        int iIntValue = 0;
        int iIntValue2 = 0;
        if (z.r.equals(type)) {
            HashMap map = (HashMap) this.f1749a.getData();
            if (map != null) {
                str3 = (String) map.get("error_message");
                Object obj3 = map.get("error_code");
                if (obj3 == null) {
                    obj2 = obj3;
                    obj2 = 0;
                }
                obj2 = obj3;
                iIntValue = ((Integer) obj2).intValue();
                bj.this.j = (String) map.get(bj.e);
                str2 = bj.this.j;
            } else {
                str2 = "";
            }
            bj.this.a(str3, iIntValue, str2);
            return;
        }
        if (z.L.equals(type)) {
            HashMap map2 = (HashMap) this.f1749a.getData();
            if (map2 != null) {
                str3 = (String) map2.get("error_message");
                Object obj4 = map2.get("error_code");
                if (obj4 == null) {
                    obj = obj4;
                    obj = 0;
                }
                obj = obj4;
                iIntValue2 = ((Integer) obj).intValue();
                bj.this.j = (String) map2.get(bj.e);
                str = bj.this.j;
            } else {
                str = "";
            }
            bj.this.a(iIntValue2, str3, str);
            return;
        }
        if (z.H.equals(type)) {
            bj.this.h(this.f1749a);
            return;
        }
        if (z.X.equals(type)) {
            bj.this.d();
            return;
        }
        if (z.Y.equals(type)) {
            bj.this.d(this.f1749a);
            return;
        }
        if (z.aa.equals(type)) {
            bj.this.s();
            return;
        }
        if (z.ab.equals(type)) {
            Map<String, Object> data = this.f1749a.getData();
            bj.this.a(data != null ? "1".equals((String) data.get("serverVerify")) : false, data);
            return;
        }
        if (z.ac.equals(type)) {
            bj.this.b();
            return;
        }
        if (z.ad.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.ae.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.K.equals(type)) {
            bj.this.b(this.f1749a);
            return;
        }
        if (z.af.equals(type)) {
            bj.this.a(this.f1749a.getMessage(), 1 == this.f1749a.getCode());
            return;
        }
        if (z.ag.equals(type)) {
            bj.this.e(this.f1749a.getMessage());
            return;
        }
        if (z.ah.equals(type)) {
            bj.this.f(this.f1749a.getMessage());
            return;
        }
        if (z.ai.equals(type)) {
            bj.this.d(this.f1749a.getMessage());
            return;
        }
        if (z.D.equals(type)) {
            bj.this.g(this.f1749a.getMessage());
            return;
        }
        if (z.Z.equals(type)) {
            bj.this.t();
            return;
        }
        if (z.aj.equals(type)) {
            bj.this.b(this.f1749a.getMessage(), 1 == this.f1749a.getCode());
            return;
        }
        if (z.am.equals(type)) {
            bj.this.c(this.f1749a);
            return;
        }
        if (z.ak.equals(type)) {
            bj.this.u();
            return;
        }
        if (z.al.equals(type)) {
            bj.this.v();
            return;
        }
        if (z.ao.equals(type)) {
            bj.this.i(this.f1749a);
            return;
        }
        if (z.ap.equals(type)) {
            bj.this.j(this.f1749a);
        } else if (z.an.equals(type)) {
            bj.this.k(this.f1749a);
        } else if (z.aq.equals(type)) {
            bj.this.l(this.f1749a);
        }
    }
}
