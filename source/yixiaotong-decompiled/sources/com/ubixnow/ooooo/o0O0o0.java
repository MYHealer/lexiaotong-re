package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.bean.UMNAdsMaterialInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0o0 {
    public o0O0o000 OooO00o;
    public o0O0o000 OooO0O0;
    public UMNAdsMaterialInfo OooO0OO;
    public o0O0o00O OooO0Oo;
    public o0oOo0O0 OooO0o0;

    public o0O0o0() {
    }

    public o0O0o0(o0O0o000 o0o0o000) {
        this.OooO0O0 = o0o0o000;
    }

    public static oO00Oo0 OooO00o(oo00o oo00oVar) {
        o0O0o000 o0o0o000;
        o0O0o0 o0o0o0 = oo00oVar.material;
        if (o0o0o0 == null || (o0o0o000 = o0o0o0.OooO0O0) == null) {
            return null;
        }
        if (!OooO00o(o0o0o000) && !OooO00o(oo00oVar.material.OooO0O0.OooO0OO)) {
            return null;
        }
        oO00Oo0 oo00oo0 = new oO00Oo0();
        oo00oo0.OooO0Oo = oo00oVar.material.OooO0O0.OooOO0();
        oo00oo0.OooO0o0 = oo00oVar.material.OooO0O0.OooO0o0();
        oo00oo0.OooO0o = oo00oVar.material.OooO0O0.OooO();
        oo00oo0.OooO0oO = oo00oVar.material.OooO0O0.OooO0o();
        oo00oo0.OooO0oo = oo00oVar.material.OooO0O0.OooO0Oo();
        oo00oo0.OooO = oo00oVar.material.OooO0O0.OooO0O0();
        if (oo00oVar.material.OooO0O0.OooO0OO == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (oo0OOoo oo0oooo : oo00oVar.material.OooO0O0.OooO0OO) {
            oO00Oo0.OooO00o oooO00o = new oO00Oo0.OooO00o();
            oooO00o.OooO0OO = oo0oooo.OooO00o;
            oooO00o.OooO0Oo = oo0oooo.OooO0OO;
            oooO00o.OooO0o0 = oo0oooo.OooO0o0();
            oooO00o.OooO0o = oo0oooo.OooO0Oo;
            oooO00o.OooO0oO = oo0oooo.OooO0o0;
            oooO00o.OooO0oo = oo0oooo.OooO0oO();
            oooO00o.OooO = oo0oooo.OooO0oO;
            arrayList.add(oooO00o);
        }
        oo00oo0.OooO0OO = (oO00Oo0.OooO00o[]) arrayList.toArray(oo00oo0.OooO0OO);
        return oo00oo0;
    }

    private static boolean OooO00o(o0O0o000 o0o0o000) {
        return (TextUtils.isEmpty(o0o0o000.OooO()) && TextUtils.isEmpty(o0o0o000.OooO0o()) && TextUtils.isEmpty(o0o0o000.OooO0Oo()) && TextUtils.isEmpty(o0o0o000.OooO0O0()) && TextUtils.isEmpty(o0o0o000.OooOO0()) && TextUtils.isEmpty(o0o0o000.OooO0o0())) ? false : true;
    }

    private static boolean OooO00o(List<oo0OOoo> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<oo0OOoo> it = list.iterator();
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next().OooO0o0())) {
                return true;
            }
        }
        return false;
    }

    public void OooO00o() {
        o0O0o000 o0o0o000 = this.OooO0O0;
        if (o0o0o000 != null) {
            this.OooO0OO = new UMNAdsMaterialInfo(o0o0o000.OooOO0(), o0o0o000.OooO0o0(), o0o0o000.OooO0OO(), o0o0o000.OooO0Oo(), o0o0o000.OooO0o(), o0o0o000.OooO(), o0o0o000.OooO0O0());
            if (o0o0o000.OooO0OO != null) {
                ArrayList arrayList = new ArrayList();
                this.OooO0OO.setMaterialDetailInfo(arrayList);
                for (oo0OOoo oo0oooo : o0o0o000.OooO0OO) {
                    UMNAdsMaterialInfo.MaterialDetailInfo materialDetailInfo = new UMNAdsMaterialInfo.MaterialDetailInfo();
                    materialDetailInfo.setMaterialUrl(oo0oooo.OooO0o0());
                    materialDetailInfo.setMaterialType(oo0oooo.OooO0Oo() + "");
                    materialDetailInfo.setVideoCoverUrl(oo0oooo.OooO0oO());
                    arrayList.add(materialDetailInfo);
                }
            }
        }
    }

    public o0O0o00O OooO0O0() {
        o0O0o000 o0o0o000 = this.OooO0O0;
        if (o0o0o000 == null || o0o0o000.OooO0OO.isEmpty()) {
            return null;
        }
        this.OooO0Oo = new o0O0o00O();
        if (!this.OooO0O0.OooO0OO.isEmpty()) {
            for (oo0OOoo oo0oooo : this.OooO0O0.OooO0OO) {
                if (oo0oooo.OooO0Oo() == 1) {
                    this.OooO0Oo.OooO0O0 = oo0oooo.OooO0o0();
                    this.OooO0Oo.OooO0OO = oo0oooo.OooO0oO();
                } else if (oo0oooo.OooO0Oo() == 2 && !TextUtils.isEmpty(oo0oooo.OooO0o0())) {
                    o0O0o00O o0o0o00o = this.OooO0Oo;
                    o0o0o00o.OooO00o = String.format("%s%s|x|", o0o0o00o.OooO00o, oo0oooo.OooO0o0());
                }
            }
            if (!TextUtils.isEmpty(this.OooO0Oo.OooO00o) && this.OooO0Oo.OooO00o.endsWith("|x|")) {
                o0O0o00O o0o0o00o2 = this.OooO0Oo;
                String str = o0o0o00o2.OooO00o;
                o0o0o00o2.OooO00o = str.substring(0, str.length() - 3);
            }
        }
        return this.OooO0Oo;
    }

    public void OooO0OO() {
        oO0O000o[] oo0o000oArr;
        o0O0o000 o0o0o000 = this.OooO0O0;
        if (o0o0o000 == null || (oo0o000oArr = o0O.OooO00o) == null || oo0o000oArr.length == 0) {
            return;
        }
        if (OooO00o(o0o0o000) || OooO00o(this.OooO0O0.OooO0OO)) {
            o0oOo0O0 o0ooo0o0 = new o0oOo0O0();
            this.OooO0o0 = o0ooo0o0;
            o0ooo0o0.OooO0O0 = this.OooO0O0.OooOO0();
            this.OooO0o0.OooO0OO = this.OooO0O0.OooO0o0();
            if (!TextUtils.isEmpty(this.OooO0O0.OooO())) {
                this.OooO0o0.OooO00o.add(this.OooO0O0.OooO());
            }
            if (!TextUtils.isEmpty(this.OooO0O0.OooO0o())) {
                this.OooO0o0.OooO00o.add(this.OooO0O0.OooO0o());
            }
            if (!TextUtils.isEmpty(this.OooO0O0.OooO0Oo())) {
                this.OooO0o0.OooO00o.add(this.OooO0O0.OooO0Oo());
            }
            this.OooO0o0.OooO0Oo = this.OooO0O0.OooO0O0();
            this.OooO0o0.OooO0o0 = this.OooO0O0.OooO00o();
            this.OooO0o0.OooO0o = this.OooO0O0.OooO0OO;
        }
    }
}
