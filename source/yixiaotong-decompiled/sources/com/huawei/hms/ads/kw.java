package com.huawei.hms.ads;

import android.content.ComponentName;
import android.content.Intent;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kw {
    private String B;
    private String C;
    private String Code;
    private String D;
    private int F;
    private String I;
    private int S;
    private String V;
    private String Z;

    public static class a {
        private static final String Code = "RedirectionMatchParam.Builder";
        private String B;
        private String C;
        private int D;
        private int F;
        private String I;
        private String L;
        private String S;
        private String V;
        private String Z;

        public a B(String str) {
            this.S = str;
            return this;
        }

        public a Code(int i) {
            this.F = i;
            return this;
        }

        public a Code(Intent intent) {
            if (intent == null) {
                return this;
            }
            if (com.huawei.openalliance.ad.utils.bc.Code(this.C)) {
                this.C = intent.getPackage();
            }
            ComponentName component = intent.getComponent();
            if (component != null && com.huawei.openalliance.ad.utils.bc.Code(this.S)) {
                this.S = component.getClassName();
            }
            return this;
        }

        public a Code(ApkInfo apkInfo) {
            if (apkInfo == null) {
                return this;
            }
            String strCode = apkInfo.Code();
            String strV = apkInfo.v();
            if (!com.huawei.openalliance.ad.utils.bc.Code(strCode)) {
                this.C = strCode;
            }
            if (!com.huawei.openalliance.ad.utils.bc.Code(strV)) {
                this.S = strV;
            }
            return this;
        }

        public a Code(AdContentData adContentData) {
            if (adContentData == null) {
                fh.I(Code, "send param by content record,record is null.");
                return this;
            }
            this.V = adContentData.a();
            this.B = adContentData.b();
            this.F = adContentData.Z();
            this.D = adContentData.aF();
            this.I = adContentData.L();
            this.Z = adContentData.M();
            return this;
        }

        public a Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            if (appInfo == null) {
                return this;
            }
            String strCode = appInfo.Code();
            String strA = appInfo.A();
            if (!com.huawei.openalliance.ad.utils.bc.Code(strCode)) {
                this.C = strCode;
            }
            if (!com.huawei.openalliance.ad.utils.bc.Code(strA)) {
                this.S = strA;
            }
            return this;
        }

        public a Code(Integer num) {
            this.D = 3 != num.intValue() ? 2 : num.intValue();
            return this;
        }

        public a Code(String str) {
            this.V = str;
            return this;
        }

        public kw Code() {
            return new kw(this);
        }

        public a I(String str) {
            this.C = str;
            return this;
        }

        public a V(String str) {
            this.B = str;
            return this;
        }

        public a Z(String str) {
            this.L = str;
            return this;
        }
    }

    public kw(a aVar) {
        this.B = aVar.C;
        this.C = aVar.S;
        this.Code = aVar.V;
        this.V = aVar.B;
        this.I = aVar.I;
        this.Z = aVar.Z;
        this.S = aVar.F;
        this.F = aVar.D;
    }

    public String B() {
        return this.Code;
    }

    public void B(String str) {
        this.V = str;
    }

    public String C() {
        return this.V;
    }

    public void C(String str) {
        this.B = str;
    }

    public String Code() {
        return this.I;
    }

    public void Code(int i) {
        this.S = i;
    }

    public void Code(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.B == null) {
            this.B = intent.getPackage();
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            S(component.getClassName());
        }
    }

    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.V = adContentData.b();
        this.Code = adContentData.a();
    }

    public void Code(String str) {
        this.I = str;
    }

    public int D() {
        if (3 != this.F) {
            this.F = 2;
        }
        return this.F;
    }

    public String F() {
        return this.C;
    }

    public String I() {
        return this.D;
    }

    public void I(String str) {
        this.D = str;
    }

    public String S() {
        return this.B;
    }

    public void S(String str) {
        this.C = str;
    }

    public String V() {
        return this.Z;
    }

    public void V(int i) {
        this.F = i;
    }

    public void V(String str) {
        this.Z = str;
    }

    public int Z() {
        return this.S;
    }

    public void Z(String str) {
        this.Code = str;
    }
}
