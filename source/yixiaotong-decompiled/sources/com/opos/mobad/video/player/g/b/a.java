package com.opos.mobad.video.player.g.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.f.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.h.o;
import com.opos.mobad.template.h.r;
import com.opos.mobad.video.player.g.a.c;
import com.opos.mobad.video.player.g.a.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8411a;
    private com.opos.mobad.d.a b = new com.opos.mobad.d.a() { // from class: com.opos.mobad.video.player.g.b.a.1
        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
            e.a().a(str, str2, i, i2, interfaceC0955a);
        }

        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
            e.a().a(str, str2, interfaceC0955a);
        }
    };

    private a() {
    }

    public static int a(Context context, AdItemData adItemData) {
        MaterialData materialData;
        FloatLayerData floatLayerDataR;
        if (context == null || adItemData == null || adItemData.i() == null || (materialData = adItemData.i().get(0)) == null || (floatLayerDataR = materialData.R()) == null) {
            return 0;
        }
        int iAa = materialData.aa();
        if (!a(floatLayerDataR, iAa) && !b(floatLayerDataR, iAa)) {
            return materialData.aa();
        }
        return a(context, adItemData, iAa);
    }

    private static int a(Context context, AdItemData adItemData, int i) {
        boolean zA;
        int iK = adItemData.K();
        if (iK != 0) {
            zA = iK != 1;
        } else {
            zA = a(context);
        }
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "check float endPage but material unused " + i);
        return zA ? 1 : 2;
    }

    public static final a a() {
        a aVar;
        a aVar2 = f8411a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = f8411a;
            if (aVar == null) {
                aVar = new a();
                f8411a = aVar;
            }
        }
        return aVar;
    }

    public static boolean a(Context context) {
        int i;
        return context == null || (i = com.opos.cmn.an.h.f.a.i(context)) == 0 || i == 180;
    }

    public static final boolean a(FloatLayerData floatLayerData) {
        if (floatLayerData.e() != null && floatLayerData.e().size() > 0 && floatLayerData.e().get(0) != null && !TextUtils.isEmpty(floatLayerData.e().get(0).a())) {
            try {
                return !e.a().a(floatLayerData.e().get(0).a());
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static boolean a(FloatLayerData floatLayerData, int i) {
        return (i == 4 || i == 3) && b(floatLayerData);
    }

    private static final boolean b(FloatLayerData floatLayerData) {
        if (floatLayerData.d() != null && floatLayerData.d().size() > 0 && floatLayerData.d().get(0) != null && !TextUtils.isEmpty(floatLayerData.d().get(0).a())) {
            try {
                return !e.a().a(floatLayerData.d().get(0).a());
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static boolean b(FloatLayerData floatLayerData, int i) {
        return i == 5 && a(floatLayerData);
    }

    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.template.a dVar;
        com.opos.mobad.template.a aVarA;
        switch (i) {
            case 3:
                dVar = new d(context, i, interfaceC1003a, this.b);
                return dVar;
            case 4:
                dVar = new c(context, i, interfaceC1003a, this.b);
                return dVar;
            case 5:
                return null;
            case 6:
                aVarA = r.a(context, this.b, i);
                aVarA.a(interfaceC1003a);
                return aVarA;
            case 7:
                aVarA = o.a(context, this.b, i);
                aVarA.a(interfaceC1003a);
                return aVarA;
            case 8:
                aVarA = o.b(context, this.b, i);
                aVarA.a(interfaceC1003a);
                return aVarA;
            default:
                dVar = new com.opos.mobad.video.player.g.a.b(context, i, interfaceC1003a, this.b);
                return dVar;
        }
    }

    public com.opos.mobad.template.a a(Context context, AdItemData adItemData, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        return a(context, a(context, adItemData), interfaceC1003a);
    }
}
