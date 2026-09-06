package com.fancy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.mpsdk.component.widgets.PtgConfirmBtn;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cp extends _ao {
    public ImageView _c;
    public TextView _d;
    public PtgConfirmBtn _e;
    public String _f;
    public _a _g;

    public interface _a {
    }

    public _cp(Activity activity) {
        super(activity, R.style.fancy_style_alert_dialog);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fancy_dialog_download);
        setCanceledOnTouchOutside(true);
        this._b = getWindow().getDecorView().findViewById(android.R.id.content);
        this._c = (ImageView) findViewById(R.id.ptg_close_iv);
        this._d = (TextView) findViewById(R.id.ptg_title_tv);
        this._e = (PtgConfirmBtn) findViewById(R.id.ptg_continue_btn);
        this._c.setOnClickListener(new _cn(this));
        this._e.setOnClickListener(new _co(this));
        TextView textView = this._d;
        if (textView != null) {
            textView.setText(this._f);
        }
    }
}
