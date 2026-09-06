package com.opos.mobad.model.a;

import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l implements com.opos.mobad.model.e.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<MaterialFileData> f7165a;
    private List<MaterialFileData> b;
    private List<MaterialFileData> c;
    private MaterialFileData d;
    private MaterialFileData e;
    private List<MaterialFileData> f;
    private List<MaterialFileData> g;

    public l(ab abVar, aa aaVar) {
        this.f7165a = a(abVar.W);
        this.b = a(abVar.T);
        this.c = a(abVar.bb);
        if (abVar.aI != null) {
            this.e = a(abVar.aI.d);
            this.f = a(abVar.aI.g);
            this.g = a(abVar.aI.h);
        }
        this.d = a(aaVar);
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

    private static List<MaterialFileData> a(List<aa> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<aa> it = list.iterator();
        while (it.hasNext()) {
            MaterialFileData materialFileDataA = a(it.next());
            if (materialFileDataA != null) {
                arrayList.add(materialFileDataA);
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> a() {
        return this.f7165a;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> b() {
        return this.b;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> c() {
        return this.c;
    }

    @Override // com.opos.mobad.model.e.j
    public MaterialFileData d() {
        return this.d;
    }

    @Override // com.opos.mobad.model.e.j
    public MaterialFileData e() {
        return this.e;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> f() {
        return this.f;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> g() {
        return this.g;
    }
}
