package com.opos.mobad.k;

import android.view.View;
import android.view.ViewGroup;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {

    /* JADX INFO: renamed from: com.opos.mobad.k.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7113a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.func.b.a.values().length];
            f7113a = iArr;
            try {
                iArr[com.opos.mobad.cmn.func.b.a.NON_CLICK_BT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7113a[com.opos.mobad.cmn.func.b.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7113a[com.opos.mobad.cmn.func.b.a.CLICK_BT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7113a[com.opos.mobad.cmn.func.b.a.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7113a[com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7113a[com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static boolean a(View view, View view2) {
        if (view != null && view2 != null) {
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                if (viewGroup.indexOfChild(view2) >= 0) {
                    return true;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i) != null && (viewGroup.getChildAt(i) instanceof ViewGroup) && a(viewGroup.getChildAt(i), view2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    public static boolean a(AdItemData adItemData, com.opos.mobad.cmn.func.b.a aVar) {
        MaterialData materialData;
        boolean z = false;
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
            switch (AnonymousClass1.f7113a[aVar.ordinal()]) {
                case 1:
                    if (materialData.G() != 0) {
                        z = true;
                    }
                    break;
                case 2:
                case 3:
                    if (materialData.d() != 0) {
                        z = true;
                    }
                    break;
                case 4:
                    if (materialData.H() != 0) {
                        z = true;
                    }
                    break;
                case 5:
                    if (materialData.S() != 0) {
                        z = true;
                    }
                    break;
                case 6:
                    if (materialData.T() != 0) {
                        z = true;
                    }
                    break;
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isValidClickWithInteraction result =" + z);
        return z;
    }
}
