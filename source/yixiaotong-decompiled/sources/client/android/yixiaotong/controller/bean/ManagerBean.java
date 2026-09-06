package client.android.yixiaotong.controller.bean;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ManagerBean {
    public List<ManagerAppBean> result;
    public int success;

    public List<ManagerAppBean> getSortList() {
        if (this.result == null) {
            this.result = new ArrayList();
        }
        return this.result;
    }
}
