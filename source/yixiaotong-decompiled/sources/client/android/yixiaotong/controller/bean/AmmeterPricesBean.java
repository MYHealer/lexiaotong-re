package client.android.yixiaotong.controller.bean;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AmmeterPricesBean {
    public List<AmmeterPriceBean> Records;
    public String rand;

    public List<AmmeterPriceBean> getSortList() {
        if (this.Records == null) {
            this.Records = new ArrayList();
        }
        return this.Records;
    }
}
