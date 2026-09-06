package com.hihonor.dlinstall.data;

import com.hihonor.dlinstall.clone.AppInfo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class UpdateListResult implements Serializable {
    private static final long serialVersionUID = 1;
    public int totalCount;
    public List<AppInfo> updateList;

    public String toString() {
        return "UpdateListResult{totalCount=" + this.totalCount + ", updateList=" + this.updateList + '}';
    }
}
