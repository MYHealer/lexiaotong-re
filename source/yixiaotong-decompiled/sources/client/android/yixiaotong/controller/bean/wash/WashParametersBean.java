package client.android.yixiaotong.controller.bean.wash;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class WashParametersBean {
    public String installlocation;
    public String machineid;
    public List<WashParameterBean> pminfo;
    public String rand;
    public String serial;

    public List<WashParameterBean> getList() {
        if (this.pminfo == null) {
            this.pminfo = new ArrayList();
        }
        return this.pminfo;
    }
}
