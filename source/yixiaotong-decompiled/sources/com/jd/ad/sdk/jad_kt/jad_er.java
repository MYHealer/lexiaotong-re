package com.jd.ad.sdk.jad_kt;

import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements com.jd.ad.sdk.jad_kt.jad_an {
    public final int jad_an;
    public final int jad_bo;
    public final boolean jad_cp;
    public final boolean jad_dq;
    public final jad_cp jad_er;
    public final String jad_fs;

    public static class jad_an {
        public jad_cp jad_er;
        public int jad_an = 2;
        public int jad_bo = 0;
        public boolean jad_cp = true;
        public boolean jad_dq = true;
        public String jad_fs = "PRETTY_LOGGER";

        public jad_an jad_an(int i) {
            this.jad_an = i;
            return this;
        }

        public jad_an jad_an(String str) {
            this.jad_fs = str;
            return this;
        }

        public jad_an jad_an(boolean z) {
            this.jad_dq = z;
            return this;
        }

        public jad_er jad_an() {
            if (this.jad_er == null) {
                this.jad_er = new jad_cp();
            }
            return new jad_er(this);
        }

        public jad_an jad_bo(int i) {
            this.jad_bo = i;
            return this;
        }

        public jad_an jad_bo(boolean z) {
            this.jad_cp = z;
            return this;
        }
    }

    public jad_er(jad_an jad_anVar) {
        jad_jt.jad_an(jad_anVar);
        this.jad_an = jad_anVar.jad_an;
        this.jad_bo = jad_anVar.jad_bo;
        this.jad_cp = jad_anVar.jad_cp;
        this.jad_dq = jad_anVar.jad_dq;
        this.jad_er = jad_anVar.jad_er;
        this.jad_fs = jad_anVar.jad_fs;
    }

    public final void jad_an(int i, String str, String str2) {
        str2.getClass();
        this.jad_er.getClass();
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i, str, str2);
    }

    public final void jad_bo(int i, String str, String str2) {
        String strConcat;
        switch (i) {
            case 2:
                strConcat = " ℹ️ ";
                break;
            case 3:
                strConcat = " ⚒️ ";
                break;
            case 4:
                strConcat = " ✅ ";
                break;
            case 5:
                strConcat = " ⚠️ ";
                break;
            case 6:
                strConcat = " ❌ ";
                break;
            case 7:
                strConcat = " 🆘 ";
                break;
            default:
                strConcat = PPSLabelView.Code;
                break;
        }
        if (this.jad_dq) {
            strConcat = "│".concat(strConcat);
        }
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            jad_an(i, str, strConcat + str3);
        }
    }

    public static jad_an jad_an() {
        return new jad_an();
    }
}
