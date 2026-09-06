package com.hihonor.adsdk.base.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CustomRelativeLayout extends RelativeLayout {
    private static final String LOG_TAG = "CustomRelativeLayout";
    private a mOnConfigurationChangedListener;

    public interface a {
        void onConfigurationChanged(Configuration configuration);
    }

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a aVar = this.mOnConfigurationChangedListener;
        if (aVar != null) {
            aVar.onConfigurationChanged(configuration);
        }
    }

    public void setOnConfigurationChangedListener(a aVar) {
        this.mOnConfigurationChangedListener = aVar;
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
