package com.huawei.hms.ads;

import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bz {
    private static final String Code = "H5DslUtils";

    private static List<Integer> Code(List<Integer> list, List<Integer> list2) {
        if (com.huawei.openalliance.ad.utils.ag.Code(list) || com.huawei.openalliance.ad.utils.ag.Code(list2)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            Iterator<Integer> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() == num.intValue()) {
                    arrayList.add(num);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void Code(String str, AdContentData adContentData) {
        String strOptString;
        if (adContentData == null) {
            return;
        }
        try {
            strOptString = new JSONObject(str).optString("type");
        } catch (Throwable unused) {
            fh.I(Code, "get action type error");
            strOptString = "";
        }
        if (com.huawei.openalliance.ad.utils.bc.Code(strOptString)) {
            return;
        }
        List<Integer> listQ = adContentData.q();
        strOptString.hashCode();
        byte b = -1;
        switch (strOptString.hashCode()) {
            case 2086:
                if (strOptString.equals(com.huawei.openalliance.ad.constant.ay.I)) {
                    b = 0;
                }
                break;
            case OggPageHeader.MAX_PAGE_PAYLOAD /* 65025 */:
                if (strOptString.equals("APP")) {
                    b = 1;
                }
                break;
            case 85812:
                if (strOptString.equals(com.huawei.openalliance.ad.constant.ay.V)) {
                    b = 2;
                }
                break;
        }
        int i = 3;
        switch (b) {
            case 0:
                fh.V(Code, "open ag");
                listQ = Code(listQ, (List<Integer>) Arrays.asList(2, 8, 9));
                break;
            case 1:
                fh.V(Code, "open app");
                listQ = Collections.singletonList(Integer.valueOf(i));
                break;
            case 2:
                fh.V(Code, "open web");
                i = 4;
                listQ = Collections.singletonList(Integer.valueOf(i));
                break;
            default:
                fh.V(Code, "illegal type, do nothing");
                break;
        }
        adContentData.B(listQ);
    }
}
