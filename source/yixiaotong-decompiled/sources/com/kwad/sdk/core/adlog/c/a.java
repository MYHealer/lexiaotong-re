package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String QY;
    public com.kwad.sdk.core.adlog.a.C0733a QZ;
    public long RD;
    public int aKI;
    public int aMA;
    public String aMB;
    public String aMC;
    public int aMD;
    public int aME;
    public long aMF;
    public long aMG;
    public int aMJ;
    public int aMK;
    public String aMM;
    public int aMO;
    public int aMP;
    public int aMQ;
    public int aMR;
    public String aMT;
    public JSONObject aMe;
    public int aMf;
    public int aMg;
    public int aMh;
    public int aMi;
    public String aMj;
    public String aMn;
    public String aMo;
    public String aMp;
    public int aMq;
    public int aMr;
    public int aMt;
    public String aMu;
    public int aMv;
    public int aMw;
    public String aMy;
    public int aMz;
    public AdTemplate adTemplate;
    public int adnMaterialType;
    public String adnMaterialUrl;
    public String adnName;
    public int adnType;
    public int ads;
    public int downloadSource;
    public int nm;
    public al.a no;
    public double np;
    public long zV;
    public long aMk = -1;
    public int aMl = -1;
    public long aMm = -1;
    public int aMs = -1;
    public int Ra = 0;
    public String aMx = "";
    public int aMH = -1;
    public int aMI = -1;
    public int downloadStatus = 0;
    public int aML = -1;
    public int QX = -1;
    public int aMN = -1;
    public int adxResult = -1;
    public int Rb = -1;
    public int aMS = 0;

    public final com.kwad.sdk.core.adlog.a.C0733a Jg() {
        return this.QZ;
    }

    public final a a(com.kwad.sdk.core.adlog.a.C0733a c0733a) {
        this.QZ = c0733a;
        return this;
    }

    public final a aA(long j) {
        this.zV = j;
        return this;
    }

    public final a aB(long j) {
        this.RD = j;
        return this;
    }

    public final void dV(int i) {
        if (i == 0) {
            this.aMP = 1;
        } else if (i == 1) {
            this.aMP = 2;
        } else {
            if (i != 2) {
                return;
            }
            this.aMP = 3;
        }
    }

    public final a dW(int i) {
        this.nm = i;
        return this;
    }

    public final a dX(int i) {
        this.Ra = i;
        return this;
    }

    public final a dY(int i) {
        this.Rb = i;
        return this;
    }

    public final a dZ(int i) {
        this.QX = i;
        return this;
    }

    public final a e(al.a aVar) {
        this.no = aVar;
        return this;
    }

    public final a ea(int i) {
        this.ads = i;
        return this;
    }

    public final a eb(int i) {
        this.aMz = i;
        return this;
    }

    public final a eb(String str) {
        this.QY = str;
        return this;
    }

    public static a Jf() {
        return new a();
    }

    public final void a(h hVar) {
        if (hVar != null) {
            this.aMT = hVar.Nb();
        }
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.core.adlog.a.C0733a c0733a = this.QZ;
        if (c0733a == null) {
            com.kwad.sdk.core.adlog.a.C0733a c0733a2 = new com.kwad.sdk.core.adlog.a.C0733a();
            this.QZ = c0733a2;
            c0733a2.a(adTemplate, null, null, null);
        } else if (c0733a.aLF == null) {
            this.QZ.a(adTemplate, null, null, null);
        }
    }

    public final void cF(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateBB;
        if (com.kwad.sdk.core.h.a.Oy() && (matrixTemplateBB = e.bB(adTemplate)) != null) {
            String str = matrixTemplateBB.templateId;
            String strValueOf = String.valueOf(matrixTemplateBB.templateVersionCode);
            int i = matrixTemplateBB.publishType;
            if (this.QZ == null) {
                this.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
            }
            this.QZ.tkPublishType = i;
            this.QZ.aLi = str;
            this.QZ.aLj = strValueOf;
        }
    }
}
