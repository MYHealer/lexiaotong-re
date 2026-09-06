package client.android.yixiaotong.v4.util;

import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4Util {
    public static List<V4AreaBean> getSearchAddressResult(List<V4AreaBean> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            if (StringUtils.isEmpty(str)) {
                return list;
            }
            for (V4AreaBean v4AreaBean : list) {
                if (StringUtils.isNotEmpty(v4AreaBean.name) && v4AreaBean.name.contains(str)) {
                    arrayList.add(v4AreaBean);
                }
            }
        }
        return arrayList;
    }
}
