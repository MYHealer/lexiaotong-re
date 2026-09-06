package com.jd.ad.sdk.jad_fs;

import android.text.TextUtils;
import android.util.Base64;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JADTouchListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public jad_an jad_an;

    public jad_bo() {
        this.jad_an = null;
        this.jad_an = new jad_an();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public String jad_an(String str) {
        String strEncodeToString;
        String strReplaceAll;
        jad_dq jad_dqVar;
        String string;
        jad_dq jad_dqVar2;
        jad_dq jad_dqVar3;
        jad_dq jad_dqVar4;
        jad_an jad_anVar = this.jad_an;
        if (jad_anVar == null) {
            return str;
        }
        try {
            int size = jad_anVar.jad_an.size();
            jad_dq jad_dqVar5 = jad_anVar.jad_bo;
            long j = 0;
            long j2 = (jad_dqVar5 == null || (jad_dqVar4 = jad_anVar.jad_cp) == null) ? 0L : jad_dqVar4.jad_an - jad_dqVar5.jad_an;
            if (jad_anVar.jad_an.size() > 0 && (jad_dqVar2 = jad_anVar.jad_an.get(0)) != null && (jad_dqVar3 = jad_anVar.jad_cp) != null) {
                j = jad_dqVar3.jad_an - jad_dqVar2.jad_an;
            }
            String str2 = "|" + size + "," + j2 + "," + j + "," + JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) + "," + JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
            ArrayList arrayList = new ArrayList();
            if (jad_anVar.jad_an.size() > 400) {
                int size2 = jad_anVar.jad_an.size();
                arrayList.add(jad_anVar.jad_an.get(0));
                arrayList.addAll(jad_anVar.jad_an.subList(size2 - 399, size2));
            } else {
                arrayList.addAll(jad_anVar.jad_an);
            }
            String strJad_an = jad_anVar.jad_an(arrayList, jad_anVar.jad_an.size() > 10 ? (int) Math.floor(jad_anVar.jad_an.size() / 10) : 1);
            if (jad_anVar.jad_bo != null && jad_anVar.jad_an.isEmpty()) {
                List<jad_dq> list = jad_anVar.jad_an;
                jad_dq jad_dqVar6 = jad_anVar.jad_bo;
                list.add(new jad_dq(jad_dqVar6.jad_bo, jad_dqVar6.jad_cp, jad_dqVar6.jad_an));
            }
            List<jad_dq> list2 = jad_anVar.jad_an;
            if (list2 == null || list2.size() <= 0) {
                jad_dqVar = null;
            } else {
                List<jad_dq> list3 = jad_anVar.jad_an;
                jad_dqVar = list3.get(list3.size() - 1);
            }
            String str3 = str2 + strJad_an + ((jad_anVar.jad_cp == null || jad_dqVar == null) ? "" : "|" + jad_anVar.jad_cp.jad_bo + "," + jad_anVar.jad_cp.jad_cp + "," + (jad_anVar.jad_cp.jad_an - jad_dqVar.jad_an)) + ("|" + jad_anVar.jad_an());
            Logger.d("[cheat] path resultString: " + str3);
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                string = "";
            } else {
                int iFloor = (int) Math.floor(str.length() / 12);
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < 12; i++) {
                    sb2.append(Integer.toHexString(Integer.valueOf(str.charAt(i * iFloor)).intValue() % 12));
                }
                string = sb2.toString();
            }
            String string2 = sb.append(string).append(str3).toString();
            if (TextUtils.isEmpty(string2)) {
                strEncodeToString = "";
            } else {
                Logger.d("[cheat] Path all is: " + string2);
                strEncodeToString = Base64.encodeToString(string2.getBytes(Charset.defaultCharset()), 10);
                Logger.d("[cheat] Path all encode is: " + strEncodeToString);
            }
        } catch (Exception e) {
            Logger.d("getPathList Exception: " + e);
        }
        if (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.length() > 2048) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.URL_AC_LENGTH_EXCEEDS_2KB;
            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
            strReplaceAll = str;
        } else {
            strReplaceAll = str.replaceAll("__SDKAC__", strEncodeToString);
        }
        if (!TextUtils.isEmpty(strReplaceAll) && strReplaceAll.length() > 4096) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
        }
        return strReplaceAll;
    }
}
