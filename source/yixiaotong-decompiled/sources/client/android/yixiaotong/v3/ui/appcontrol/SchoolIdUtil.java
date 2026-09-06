package client.android.yixiaotong.v3.ui.appcontrol;

import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SchoolIdUtil {
    public static final String[] schoolIds = {"80273"};

    public static boolean isUnNeedUpdateDeviceInfo(String str) {
        if (StringUtils.isNotEmpty(str)) {
            int i = 0;
            while (true) {
                String[] strArr = schoolIds;
                if (i >= strArr.length) {
                    break;
                }
                LogUtil.e("SchoolIdUtil", strArr[i]);
                if (str.equals(strArr[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
