package com.jd.ad.sdk.jad_na;

import android.text.TextUtils;
import com.jd.ad.sdk.jad_yl.jad_dq;
import com.jd.ad.sdk.jad_yl.jad_er;
import com.jd.ad.sdk.jad_yl.jad_fs;
import com.jd.ad.sdk.jad_yl.jad_hu;
import com.jd.ad.sdk.jad_yl.jad_jt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: JADAdDataHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {

    /* JADX INFO: compiled from: JADAdDataHelper.java */
    public static class jad_an {
        public static final jad_bo jad_an = new jad_bo();
    }

    public com.jd.ad.sdk.jad_yl.jad_cp jad_an(String str) {
        jad_hu jad_huVar;
        List<jad_dq> list;
        jad_dq jad_dqVar;
        jad_jt jad_jtVarJad_jt = jad_jt(str);
        if (jad_jtVarJad_jt == null || (jad_huVar = jad_jtVarJad_jt.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) {
            return null;
        }
        return jad_dqVar.jad_bo;
    }

    public String jad_bo(String str) {
        jad_fs jad_fsVarJad_dq = jad_dq(str);
        return (jad_fsVarJad_dq == null || TextUtils.isEmpty(jad_fsVarJad_dq.jad_cp)) ? "" : jad_fsVarJad_dq.jad_cp;
    }

    public String jad_cp(String str) {
        jad_er jad_erVar;
        List list;
        List<jad_er> list2;
        ArrayList arrayList;
        List<jad_fs> listJad_er = jad_er(str);
        ArrayList arrayList2 = new ArrayList();
        if (listJad_er != null && !listJad_er.isEmpty()) {
            for (int i = 0; i < listJad_er.size(); i++) {
                jad_fs jad_fsVar = listJad_er.get(i);
                int size = arrayList2.size();
                if (jad_fsVar != null) {
                    String str2 = jad_fsVar.jad_er;
                    if (TextUtils.isEmpty(str2)) {
                        list2 = jad_fsVar.jad_fs;
                    } else {
                        arrayList = new ArrayList();
                        jad_er jad_erVar2 = new jad_er();
                        jad_erVar2.jad_an = str2;
                        String.valueOf(size);
                        arrayList.add(jad_erVar2);
                    }
                } else {
                    list = null;
                }
                if (list != null) {
                    list = list2;
                    if (list.isEmpty()) {
                        list = arrayList;
                    } else {
                        list = arrayList;
                        arrayList2.addAll(list);
                    }
                } else {
                    list = list2;
                    list = arrayList;
                }
            }
        }
        return (arrayList2.isEmpty() || (jad_erVar = (jad_er) arrayList2.get(0)) == null || TextUtils.isEmpty(jad_erVar.jad_an)) ? "" : jad_erVar.jad_an;
    }

    public final jad_fs jad_dq(String str) {
        List<jad_fs> listJad_er;
        if (jad_jt(str) == null || (listJad_er = jad_er(str)) == null || listJad_er.isEmpty()) {
            return null;
        }
        return listJad_er.get(0);
    }

    public List<jad_fs> jad_er(String str) {
        jad_hu jad_huVar;
        jad_jt jad_jtVarJad_jt = jad_jt(str);
        if (jad_jtVarJad_jt == null) {
            return null;
        }
        jad_jt jad_jtVarJad_jt2 = jad_jt(str);
        List<jad_dq> list = (jad_jtVarJad_jt2 == null || (jad_huVar = jad_jtVarJad_jt2.jad_cp) == null) ? null : jad_huVar.jad_an;
        if (list == null || list.isEmpty() || jad_jtVarJad_jt.jad_cp.jad_an.get(0).jad_bo == null || jad_jtVarJad_jt.jad_cp.jad_an.get(0).jad_bo.jad_an == null || jad_jtVarJad_jt.jad_cp.jad_an.get(0).jad_bo.jad_an.isEmpty()) {
            return null;
        }
        return jad_jtVarJad_jt.jad_cp.jad_an.get(0).jad_bo.jad_an;
    }

    public String jad_fs(String str) {
        jad_fs jad_fsVarJad_dq = jad_dq(str);
        return (jad_fsVarJad_dq == null || TextUtils.isEmpty(jad_fsVarJad_dq.jad_ly)) ? "" : jad_fsVarJad_dq.jad_ly;
    }

    public jad_jt jad_jt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return jad_jt.jad_an(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
