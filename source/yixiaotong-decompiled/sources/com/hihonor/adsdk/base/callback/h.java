package com.hihonor.adsdk.base.callback;

import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.callback.filter.ResFilterBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private final List<com.hihonor.adsdk.base.callback.a> hnadsa;

    static /* synthetic */ class a {
    }

    public static final class b {
        final List<com.hihonor.adsdk.base.callback.a> hnadsa = new ArrayList();

        public b hnadsa(com.hihonor.adsdk.base.callback.a aVar) {
            this.hnadsa.add(aVar);
            return this;
        }

        public h hnadsa() {
            return new h(this.hnadsa, null);
        }
    }

    /* synthetic */ h(List list, a aVar) {
        this(list);
    }

    public ResFilterBean hnadsa(ResFilterBean resFilterBean) {
        List<BaseAdInfo> listSourceData = resFilterBean.getListSourceData();
        for (int i = 0; i < this.hnadsa.size(); i++) {
            if (!listSourceData.isEmpty()) {
                this.hnadsa.get(i).hnadsa(resFilterBean);
            }
        }
        return resFilterBean;
    }

    private h(List<com.hihonor.adsdk.base.callback.a> list) {
        this.hnadsa = list;
    }
}
