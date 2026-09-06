package com.fancy.mpsdk.widget.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy._kz;
import com.fancy._li;
import com.fancy._pa;
import com.fancy.adsdk.lib.R;
import com.fancy.mpsdk.activity.PtgWebActivity;
import com.fancy.mpsdk.widget.web.AdvancedWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgTitleBarWeb extends _kz {
    public _d _t;
    public ImageView _u;
    public ImageView _v;
    public View _w;

    public class _a implements View.OnClickListener {
        public _a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _d _dVar = PtgTitleBarWeb.this._t;
            if (_dVar != null) {
                _li _liVar = (_li) _dVar;
                PtgWebActivity ptgWebActivity = _liVar._a;
                AdvancedWebView advancedWebView = ptgWebActivity._b;
                if (advancedWebView == null) {
                    ptgWebActivity.finish();
                } else if (advancedWebView._b()) {
                    _liVar._a.finish();
                }
            }
        }
    }

    public class _b implements View.OnClickListener {
        public _b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _d _dVar = PtgTitleBarWeb.this._t;
            if (_dVar != null) {
                _li _liVar = (_li) _dVar;
                PtgWebActivity ptgWebActivity = _liVar._a;
                _pa _paVar = ptgWebActivity._f;
                if (_paVar == null) {
                    ptgWebActivity.finish();
                } else if (_paVar._a()) {
                    _liVar._a.finish();
                }
            }
        }
    }

    public class _c implements View.OnClickListener {
        public _c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _d _dVar = PtgTitleBarWeb.this._t;
            if (_dVar != null) {
                _dVar.getClass();
            }
        }
    }

    public interface _d {
    }

    public PtgTitleBarWeb(Context context) {
        super(context);
    }

    public PtgTitleBarWeb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PtgTitleBarWeb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fancy._kz
    public final void _a() {
        super._a();
    }

    @Override // com.fancy._kz
    public final void _b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        View viewInflate = View.inflate(getContext(), R.layout.fancy_layout_web_view_left, null);
        this._u = (ImageView) viewInflate.findViewById(R.id.ptgImgBack);
        this._v = (ImageView) viewInflate.findViewById(R.id.ptgImgClose);
        this._u.setOnClickListener(new _a());
        this._v.setOnClickListener(new _b());
        this._a.setGravity(17);
        this._a.addView(viewInflate);
        addView(this._a, layoutParams);
    }

    @Override // com.fancy._kz
    public final void _c() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        View viewInflate = View.inflate(getContext(), R.layout.fancy_layout_web_view_right, null);
        this._w = viewInflate;
        ((TextView) this._w.findViewById(R.id.ptgWebRightTitle)).setText("分享");
        this._w.setOnClickListener(new _c());
        this._d.addView(this._w);
        addView(this._d, layoutParams);
    }

    public final void _d() {
        View view = this._w;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.fancy._kz, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        int measuredWidth;
        int i5;
        int i6;
        LinearLayout linearLayout2;
        this._m = getResources().getDisplayMetrics().widthPixels;
        LinearLayout linearLayout3 = this._a;
        linearLayout3.layout(0, this._n, linearLayout3.getMeasuredWidth(), this._a.getMeasuredHeight() + this._n);
        LinearLayout linearLayout4 = this._d;
        linearLayout4.layout(this._m - linearLayout4.getMeasuredWidth(), this._n, this._m, this._d.getMeasuredHeight() + this._n);
        if (this._a.getMeasuredWidth() > this._d.getMeasuredWidth()) {
            linearLayout = this._g;
            measuredWidth = this._a.getMeasuredWidth();
            i5 = this._n;
            i6 = this._m;
            linearLayout2 = this._a;
        } else {
            linearLayout = this._g;
            measuredWidth = this._d.getMeasuredWidth();
            i5 = this._n;
            i6 = this._m;
            linearLayout2 = this._d;
        }
        linearLayout.layout(measuredWidth, i5, i6 - linearLayout2.getMeasuredWidth(), getMeasuredHeight());
        this._k.layout(0, getMeasuredHeight() - this._k.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // com.fancy._kz, android.view.View
    public final void onMeasure(int i, int i2) {
        int size;
        LinearLayout linearLayout;
        int i3;
        LinearLayout linearLayout2;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            int i4 = this._o;
            size = this._n + i4;
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            size = View.MeasureSpec.getSize(i2) + this._n;
        }
        measureChild(this._a, i, i2);
        measureChild(this._d, i, i2);
        if (this._a.getMeasuredWidth() > this._d.getMeasuredWidth()) {
            linearLayout = this._g;
            i3 = this._m;
            linearLayout2 = this._a;
        } else {
            linearLayout = this._g;
            i3 = this._m;
            linearLayout2 = this._d;
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i3 - (linearLayout2.getMeasuredWidth() * 2), 1073741824), i2);
        measureChild(this._k, i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
    }

    public void setOnClickListener(_d _dVar) {
        this._t = _dVar;
    }
}
