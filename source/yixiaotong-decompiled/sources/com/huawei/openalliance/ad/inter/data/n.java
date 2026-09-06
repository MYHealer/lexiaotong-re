package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bj;
import com.huawei.openalliance.ad.utils.ag;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class n extends c implements h, Comparable {
    private p B;
    private boolean F;
    private boolean S;
    private boolean V;

    public n(AdContentData adContentData) {
        super(adContentData);
        this.V = false;
        this.S = false;
        this.F = false;
    }

    public boolean B() {
        return this.S;
    }

    public int C() {
        if (this.I != null) {
            return this.I.K();
        }
        return 0;
    }

    public String Code() {
        MetaData metaDataJ_ = j_();
        if (metaDataJ_ != null) {
            return metaDataJ_.a();
        }
        return null;
    }

    public void Code(boolean z) {
        this.V = z;
    }

    public List<AdvertiserInfo> D() {
        if (this.I == null || !F()) {
            return null;
        }
        return this.I.aL();
    }

    public boolean F() {
        if (this.I != null) {
            return !ag.Code(this.I.aL());
        }
        return false;
    }

    public void I(boolean z) {
        this.F = z;
    }

    public boolean I() {
        p pVar = this.B;
        return pVar != null && ("image/jpeg".equals(pVar.b()) || bj.B.equals(this.B.b()) || bj.I.equals(this.B.b()) || bj.Z.equals(this.B.b()));
    }

    public boolean L() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.h
    public p S() {
        MetaData metaDataJ_;
        MediaFile mediaFileH;
        if (this.B == null && (metaDataJ_ = j_()) != null && (mediaFileH = metaDataJ_.h()) != null) {
            this.B = new p(mediaFileH, metaDataJ_.k());
        }
        return this.B;
    }

    public boolean V() {
        p pVar = this.B;
        return pVar != null && "video/mp4".equals(pVar.b());
    }

    public boolean Z() {
        return this.V;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof n) && ((n) obj).C() <= C()) ? 1 : -1;
    }
}
