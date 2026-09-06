package com.yfanads.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yfanads.android.libs.thirdpart.gson.annotations.Expose;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TemplateConf implements Parcelable {
    public static final Parcelable.Creator<TemplateConf> CREATOR = new Parcelable.Creator<TemplateConf>() { // from class: com.yfanads.android.model.TemplateConf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplateConf createFromParcel(Parcel parcel) {
            return new TemplateConf(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplateConf[] newArray(int i) {
            return new TemplateConf[i];
        }
    };

    @Expose
    public int ac;

    @Expose
    public int ae;

    @Expose
    public int bs;

    @Expose
    public int cbct;

    @Expose
    public int cbde;

    @Expose
    public int cbm;

    @Expose
    public int cbp;

    @Expose
    public int cbs;

    @Expose
    public int cbst;

    @Expose
    public String cc;

    @Expose
    public long ccst;

    @Expose
    public int cha;

    @Expose
    public int cp;

    @Expose
    public int cte;

    @Expose
    public int dnbcp;

    @Expose
    public int dtsp;

    @Expose
    public int ecbc;

    @Expose
    public int haal;

    @Expose
    public int ip;

    @Expose
    public int is;

    @Expose
    public int isd;

    @Expose
    @Deprecated
    public int istv;

    @Expose
    public float istvp;

    @Expose
    public int jc;

    @Expose
    public int lpaa;

    @Expose
    public String npd;

    @Expose
    public String npdw;

    @Expose
    public int oac;

    @Expose
    public int oat;

    @Expose
    public int pkb;

    @Expose
    public String rc;

    @Expose
    public int rcs;

    @Expose
    public String rt;

    @Expose
    public int sai;

    @Expose
    public int sb;

    @Expose
    public int sbs;

    @Expose
    public int sj;

    @Expose
    public String ss;

    @Expose
    public int sv;

    @Expose
    public int tc;

    @Expose
    public int ts;

    @Expose
    public int vm;

    public TemplateConf() {
        this.vm = 1;
        this.bs = 1;
        this.cte = 1;
        this.rcs = 0;
        this.rt = "";
        this.rc = "";
        this.cc = "";
        this.ccst = 0L;
        this.ip = 4;
        this.sv = 0;
        this.dtsp = 1;
        this.sai = 1;
    }

    public TemplateConf(Parcel parcel) {
        this.vm = 1;
        this.bs = 1;
        this.cte = 1;
        this.rcs = 0;
        this.rt = "";
        this.rc = "";
        this.cc = "";
        this.ccst = 0L;
        this.ip = 4;
        this.sv = 0;
        this.dtsp = 1;
        this.sai = 1;
        this.cbs = parcel.readInt();
        this.cha = parcel.readInt();
        this.vm = parcel.readInt();
        this.jc = parcel.readInt();
        this.ts = parcel.readInt();
        this.cbp = parcel.readInt();
        this.pkb = parcel.readInt();
        this.is = parcel.readInt();
        this.istv = parcel.readInt();
        this.cbst = parcel.readInt();
        this.ac = parcel.readInt();
        this.isd = parcel.readInt();
        this.istvp = parcel.readFloat();
        this.cp = parcel.readInt();
        this.dnbcp = parcel.readInt();
        this.oac = parcel.readInt();
        this.oat = parcel.readInt();
        this.sb = parcel.readInt();
        this.cbm = parcel.readInt();
        this.cbct = parcel.readInt();
        this.cbde = parcel.readInt();
        this.ecbc = parcel.readInt();
        this.ae = parcel.readInt();
        this.tc = parcel.readInt();
        this.sbs = parcel.readInt();
        this.ss = parcel.readString();
        this.haal = parcel.readInt();
        this.bs = parcel.readInt();
        this.sj = parcel.readInt();
        this.cte = parcel.readInt();
        this.rcs = parcel.readInt();
        this.rc = parcel.readString();
        this.rt = parcel.readString();
        this.lpaa = parcel.readInt();
        this.cc = parcel.readString();
        this.ccst = parcel.readLong();
        this.ip = parcel.readInt();
        this.sv = parcel.readInt();
        this.npd = parcel.readString();
        this.npdw = parcel.readString();
        this.dtsp = parcel.readInt();
        this.sai = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TemplateConf{cbs=" + this.cbs + ", cha=" + this.cha + ", vm=" + this.vm + ", jc=" + this.jc + ", ts=" + this.ts + ", cbp=" + this.cbp + ", pkb=" + this.pkb + ", is=" + this.is + ", istv=" + this.istv + ", cbst=" + this.cbst + ", ac=" + this.ac + ", isd=" + this.isd + ", istvp=" + this.istvp + ", cp=" + this.cp + ", sb=" + this.sb + ", oac=" + this.oac + ", oat=" + this.oat + ", dnbcp=" + this.dnbcp + ", cbm=" + this.cbm + ", cbct=" + this.cbct + ", cbde=" + this.cbde + ", ecbc=" + this.ecbc + ", ae=" + this.ae + ", tc=" + this.tc + ", sbs=" + this.sbs + ", ss=" + this.ss + ", haal=" + this.haal + ", bs=" + this.bs + ", sj=" + this.sj + ", cte=" + this.cte + ", rcs=" + this.rcs + ", rt=" + this.rt + ", rc=" + this.rc + ", lpaa=" + this.lpaa + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.cbs);
        parcel.writeInt(this.cha);
        parcel.writeInt(this.vm);
        parcel.writeInt(this.jc);
        parcel.writeInt(this.ts);
        parcel.writeInt(this.cbp);
        parcel.writeInt(this.pkb);
        parcel.writeInt(this.is);
        parcel.writeInt(this.istv);
        parcel.writeInt(this.cbst);
        parcel.writeInt(this.ac);
        parcel.writeInt(this.isd);
        parcel.writeFloat(this.istvp);
        parcel.writeInt(this.cp);
        parcel.writeInt(this.dnbcp);
        parcel.writeInt(this.oac);
        parcel.writeInt(this.oat);
        parcel.writeInt(this.sb);
        parcel.writeInt(this.cbm);
        parcel.writeInt(this.cbct);
        parcel.writeInt(this.cbde);
        parcel.writeInt(this.ecbc);
        parcel.writeInt(this.ae);
        parcel.writeInt(this.tc);
        parcel.writeInt(this.sbs);
        parcel.writeString(this.ss);
        parcel.writeInt(this.haal);
        parcel.writeInt(this.bs);
        parcel.writeInt(this.sj);
        parcel.writeInt(this.cte);
        parcel.writeInt(this.rcs);
        parcel.writeString(this.rt);
        parcel.writeString(this.rc);
        parcel.writeInt(this.lpaa);
        parcel.writeString(this.cc);
        parcel.writeLong(this.ccst);
        parcel.writeInt(this.ip);
        parcel.writeInt(this.sv);
        parcel.writeString(this.npd);
        parcel.writeString(this.npdw);
        parcel.writeInt(this.dtsp);
        parcel.writeInt(this.sai);
    }
}
