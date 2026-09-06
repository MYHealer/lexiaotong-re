package com.opos.mobad.model.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7151a = ab.f.APP_INSTALLED.getValue();
    private static final int b = ab.f.APP_UNINSTALLED.getValue();

    private static com.opos.mobad.model.c.e a(Context context, aa aaVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(context, aaVar.d), aaVar.e)) {
            return null;
        }
        com.opos.mobad.model.c.e eVar = new com.opos.mobad.model.c.e();
        eVar.a(aaVar.d);
        eVar.b(aaVar.e);
        eVar.c(com.opos.cmn.d.c.a(context, aaVar.d));
        return eVar;
    }

    private static MaterialFileData a(aa aaVar) {
        if (aaVar == null) {
            return null;
        }
        MaterialFileData materialFileData = new MaterialFileData();
        materialFileData.a(aaVar.d);
        materialFileData.b(aaVar.e);
        return materialFileData;
    }

    static MaterialFileData a(com.opos.mobad.b bVar, aa aaVar, Set<com.opos.mobad.model.c.e> set, boolean z, com.opos.mobad.model.e.m mVar) {
        if (z) {
            set = null;
        }
        return a(bVar, aaVar, true, set, mVar);
    }

    private static MaterialFileData a(com.opos.mobad.b bVar, aa aaVar, boolean z, Set<com.opos.mobad.model.c.e> set, com.opos.mobad.model.e.m mVar) {
        if (aaVar == null || com.opos.cmn.an.d.a.a(aaVar.d)) {
            return null;
        }
        if (set == null) {
            return a(aaVar);
        }
        com.opos.mobad.model.c.e eVarA = a(bVar.b(), aaVar);
        if (eVarA != null) {
            set.add(eVarA);
            if (!z) {
                bVar.q().b(false);
            }
        } else {
            if (!z) {
                bVar.q().b(true);
            }
            if (mVar != null) {
                mVar.a(aaVar.d, 2);
            }
            com.opos.cmn.an.f.a.b("AdLoader", "material File " + aaVar.toString() + " exists,don't need download again!!!");
        }
        return a(aaVar);
    }

    static MaterialFileData a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, Set<com.opos.mobad.model.c.e> set, boolean z, com.opos.mobad.model.e.m mVar) {
        aa aaVar = bVar2.G;
        if (z) {
            set = null;
        }
        return a(bVar, aaVar, true, set, mVar);
    }

    static List<MaterialData> a(com.opos.mobad.b bVar, ab abVar, Set<com.opos.mobad.model.c.e> set, Set<com.opos.mobad.model.c.e> set2, boolean z, com.opos.mobad.model.e.m mVar) {
        List<MaterialFileData> listA;
        List<MaterialFileData> listA2;
        List<MaterialFileData> listA3;
        FloatLayerData floatLayerData = null;
        if (z) {
            listA = a(bVar, abVar.W, null, mVar);
            listA2 = a(bVar, abVar.bb, null, mVar);
            listA3 = abVar.R == ab.c.RAW_VIDEO ? a(bVar, abVar.T, set2, mVar) : a(bVar, abVar.T, null, mVar);
        } else {
            listA = a(bVar, abVar.W, set, mVar);
            listA2 = a(bVar, abVar.bb, set2, mVar);
            listA3 = a(bVar, abVar.T, set, mVar);
        }
        List<MaterialFileData> list = listA;
        List<MaterialFileData> list2 = listA2;
        List<MaterialFileData> list3 = listA3;
        List<MaterialFileData> listA4 = a(bVar, abVar.ar, null, mVar);
        if (abVar.aI != null) {
            floatLayerData = new FloatLayerData(abVar.aI, a(bVar, abVar.aI.d, false, set, mVar), a(bVar, abVar.aI.g, set2, mVar), a(bVar, abVar.aI.h, set2, mVar));
        }
        MaterialData materialData = new MaterialData(abVar, list3, list, listA4, list2, floatLayerData);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private static List<MaterialFileData> a(com.opos.mobad.b bVar, List<aa> list, Set<com.opos.mobad.model.c.e> set, com.opos.mobad.model.e.m mVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<aa> it = list.iterator();
            while (it.hasNext()) {
                MaterialFileData materialFileDataA = a(bVar, it.next(), false, set, mVar);
                if (materialFileDataA != null) {
                    arrayList.add(materialFileDataA);
                }
            }
        }
        return arrayList;
    }

    static boolean a(Context context, ab abVar, i iVar) {
        boolean zB = abVar != null ? true ^ b(context, abVar, iVar) : true;
        com.opos.cmn.an.f.a.b("AdLoader", "isValidMaterialEntity materialEntity=", abVar, "result=", Boolean.valueOf(zB));
        return zB;
    }

    static boolean a(ab abVar) {
        return abVar.R == ab.c.VIDEO || abVar.R == ab.c.FULL_VIDEO || abVar.R == ab.c.POP_WINDOW_VIDEO || abVar.R == ab.c.RAW_VIDEO || abVar.R == ab.c.VIDEO_HTML || abVar.R == ab.c.VIDEO_TIP_BAR;
    }

    static boolean a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, List<aa> list) {
        if (bVar2.P == com.opos.mobad.b.a.b.d.PLAY_CACHE) {
            aa aaVar = list.get(0);
            boolean zIsEmpty = TextUtils.isEmpty(com.opos.cmn.d.d.a(bVar.b(), aaVar.d, aaVar.e));
            v vVarQ = bVar.q();
            if (zIsEmpty) {
                vVarQ.a(false);
                com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial but not cache video");
                return false;
            }
            vVarQ.a(true);
        }
        com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial");
        return true;
    }

    static boolean b(Context context, ab abVar, i iVar) {
        if (abVar.aM == null) {
            return false;
        }
        int iIntValue = abVar.aM.intValue();
        int i = f7151a;
        if (i == (i & iIntValue) && !TextUtils.isEmpty(abVar.Y) && com.opos.cmn.an.h.d.a.d(context, abVar.Y)) {
            com.opos.cmn.an.f.a.b("AdLoader", "filter install");
            if (iVar != null) {
                iVar.a(abVar);
            }
            return true;
        }
        int i2 = b;
        if (i2 != (iIntValue & i2) || TextUtils.isEmpty(abVar.Y) || com.opos.cmn.an.h.d.a.d(context, abVar.Y)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("AdLoader", "filter uninstall");
        if (iVar != null) {
            iVar.g(abVar);
        }
        return true;
    }

    public static boolean b(ab abVar) {
        if (abVar == null) {
            return false;
        }
        return abVar.S == ab.i.OPEN_MINI_PROGRAM || abVar.aJ == ab.i.OPEN_MINI_PROGRAM || abVar.aK == ab.i.OPEN_MINI_PROGRAM || abVar.av == ab.i.OPEN_MINI_PROGRAM || abVar.aw == ab.i.OPEN_MINI_PROGRAM;
    }
}
