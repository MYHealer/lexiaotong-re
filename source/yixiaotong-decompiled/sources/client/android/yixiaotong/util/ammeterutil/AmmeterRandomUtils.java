package client.android.yixiaotong.util.ammeterutil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterRandomUtils {
    public static String getRandNumMaxString(int i) {
        char[] cArr = new char[16];
        Integer num = 65;
        int iIntValue = num.intValue();
        for (int i2 = 0; i2 < 6; i2++) {
            cArr[i2] = (char) (iIntValue + i2);
        }
        Integer num2 = 48;
        int iIntValue2 = num2.intValue();
        for (int i3 = 0; i3 < 10; i3++) {
            cArr[i3 + 6] = (char) (iIntValue2 + i3);
        }
        Iterator<Integer> it = getRandSet(15, i).iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + String.valueOf(cArr[it.next().intValue()]);
        }
        return str;
    }

    public static Set<Integer> getRandSet(int i, int i2) {
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(Integer.valueOf((int) ((Math.random() * ((double) i)) + 1.0d)));
        } while (hashSet.size() < i2);
        return hashSet;
    }
}
