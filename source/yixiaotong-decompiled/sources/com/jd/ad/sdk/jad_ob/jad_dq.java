package com.jd.ad.sdk.jad_ob;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DynamicConfigManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public static final int[] jad_an = {2, 3, 4, 5, 6, 7, 8, 9};

    /* JADX INFO: compiled from: DynamicConfigManager.java */
    public static class jad_an {
        public static final jad_dq jad_an = new jad_dq();
    }

    public int jad_an(boolean z, int i) {
        if (i == 1) {
            return z ? 6 : 2;
        }
        if (i == 2) {
            return z ? 9 : 5;
        }
        if (i == 4) {
            return z ? 7 : 3;
        }
        if (i != 5) {
            return -1;
        }
        return z ? 8 : 4;
    }

    public final boolean jad_an(List<com.jd.ad.sdk.jad_pc.jad_hu> list) {
        if (list.size() == 0) {
            return false;
        }
        Iterator<com.jd.ad.sdk.jad_pc.jad_hu> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean jad_an(int i, String str) {
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        ArrayList arrayList = null;
        List<com.jd.ad.sdk.jad_pc.jad_hu> list = jad_cpVarJad_cp == null ? null : jad_cpVarJad_cp.jad_hu;
        if (list != null && list.size() != 0) {
            try {
                boolean zJad_an = jad_an(list);
                if (zJad_an) {
                    return zJad_an;
                }
                for (com.jd.ad.sdk.jad_pc.jad_hu jad_huVar : list) {
                    if (jad_huVar.jad_an == i) {
                        int i2 = 0;
                        while (true) {
                            int[] iArr = jad_an;
                            if (i2 >= iArr.length) {
                                break;
                            }
                            if (i == iArr[i2]) {
                                String str2 = jad_huVar.jad_bo;
                                if (!TextUtils.isEmpty(str2)) {
                                    arrayList = new ArrayList();
                                    arrayList.addAll(Arrays.asList(str2.split(",")));
                                }
                                List<String> listJad_an = jad_an(i, arrayList);
                                if (listJad_an == null || listJad_an.size() <= 0) {
                                    break;
                                    break;
                                }
                                return listJad_an.contains(str);
                            }
                            i2++;
                        }
                        return true;
                    }
                }
                return zJad_an;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<String> jad_an(int i, List<String> list) {
        int i2;
        ArrayList arrayList;
        List<com.jd.ad.sdk.jad_pc.jad_er> list2;
        if (list != null && list.size() > 0) {
            switch (i) {
                case 2:
                case 6:
                    i2 = 1;
                    break;
                case 3:
                case 7:
                    i2 = 4;
                    break;
                case 4:
                case 8:
                    i2 = 5;
                    break;
                case 5:
                case 9:
                    i2 = 2;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            if (jad_cpVarJad_cp == null || (list2 = jad_cpVarJad_cp.jad_jt) == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (com.jd.ad.sdk.jad_pc.jad_er jad_erVar : list2) {
                    if (jad_erVar != null && i2 == jad_erVar.jad_bo) {
                        arrayList.add(jad_erVar.jad_an);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : list) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (str.equals((String) it.next())) {
                            arrayList2.add(str);
                        }
                    }
                }
                return arrayList2;
            }
        }
        return null;
    }
}
