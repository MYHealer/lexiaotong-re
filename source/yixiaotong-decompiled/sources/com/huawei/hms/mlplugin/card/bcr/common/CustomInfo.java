package com.huawei.hms.mlplugin.card.bcr.common;

import android.graphics.Rect;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CustomInfo {
    public boolean mIsCustom;
    public int mRecMode;
    public int mRecType;
    public Rect mRect;
    public int mResultType;

    public CustomInfo(boolean z, Rect rect, int i, int i2, int i3) {
        this.mIsCustom = z;
        this.mRect = rect;
        this.mRecType = i;
        this.mRecMode = i2;
        this.mResultType = i3;
    }

    public String toString() {
        return this.mIsCustom + IOUtils.LINE_SEPARATOR_UNIX + this.mRect.toString() + IOUtils.LINE_SEPARATOR_UNIX + this.mRecType + IOUtils.LINE_SEPARATOR_UNIX + this.mRecMode + IOUtils.LINE_SEPARATOR_UNIX + this.mResultType;
    }
}
