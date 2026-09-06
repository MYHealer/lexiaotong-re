package com.huawei.hms.ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class AbstractPromptDialog extends AbstractDialog {
    @Override // com.huawei.hms.ui.AbstractDialog
    public String onGetNegativeButtonString(Context context) {
        return null;
    }

    @Override // com.huawei.hms.ui.AbstractDialog
    public String onGetTitleString(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}
