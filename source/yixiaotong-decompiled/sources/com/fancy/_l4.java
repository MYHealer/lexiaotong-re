package com.fancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l4 extends _h1 implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public ImageView _l;
    public ImageView _m;
    public LinearLayout _n;
    public TextView _o;
    public ProgressBar _p;
    public LinearLayout _q;
    public TextView _r;
    public _eo _s;
    public long _t;
    public _b _u;
    public _a _v;

    public interface _a {
        void _a(int i);
    }

    public interface _b {
        void _a(long j, long j2);
    }

    public _l4(Context context) {
        super(context);
        _f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fancy._h1
    public final void _a(int i) {
        if (i == -1) {
            _a();
            this._q.setVisibility(0);
        } else if (i != 1) {
            switch (i) {
                case 3:
                    this._n.setVisibility(8);
                    _d();
                    break;
                case 4:
                    this._n.setVisibility(8);
                    _a();
                    break;
                case 5:
                    this._n.setVisibility(0);
                    this._o.setText("正在缓冲中...");
                    break;
                case 6:
                    this._o.setText("正在缓冲中...");
                    break;
                case 7:
                    _a();
                    this._l.setVisibility(0);
                    _eo _eoVar = this._s;
                    if (_eoVar != null) {
                        long duration = _eoVar.getDuration();
                        _b _bVar = this._u;
                        if (_bVar != null) {
                            _bVar._a(duration, duration);
                        }
                    }
                    break;
                case 8:
                    _d();
                    break;
            }
        } else {
            this._l.setVisibility(8);
            this._n.setVisibility(0);
            this._o.setText("正在准备...");
            this._q.setVisibility(8);
            this._m.setVisibility(8);
        }
        _a _aVar = this._v;
        if (_aVar != null) {
            _aVar._a(i);
        }
    }

    @Override // com.fancy._h1
    public final void _b() {
    }

    @Override // com.fancy._h1
    public final void _c() {
        _a();
        ImageView imageView = this._m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this._l;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        LinearLayout linearLayout = this._n;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this._q;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // com.fancy._h1
    public final void _e() {
        _b _bVar;
        long currentPosition = this._s.getCurrentPosition();
        long duration = this._s.getDuration();
        if (this._t != currentPosition && (_bVar = this._u) != null) {
            _bVar._a(duration, currentPosition);
        }
        this._t = currentPosition;
        ProgressBar progressBar = this._p;
        if (progressBar != null) {
            progressBar.setProgress((int) ((currentPosition * 100.0f) / duration));
        }
    }

    public final void _f() {
        LayoutInflater.from(getContext()).inflate(R.layout.fancy_video_palyer_controller, (ViewGroup) this, true);
        this._m = (ImageView) findViewById(R.id.ptgVideoCenterStart);
        this._l = (ImageView) findViewById(R.id.ptgVideoImage);
        this._n = (LinearLayout) findViewById(R.id.ptgVideoLoading);
        this._o = (TextView) findViewById(R.id.ptgVideoLoadText);
        this._p = (ProgressBar) findViewById(R.id.ptgVideoChangePositionProgress);
        this._q = (LinearLayout) findViewById(R.id.ptgVideoError);
        this._r = (TextView) findViewById(R.id.ptgVideoRetry);
        this._m.setOnClickListener(this);
        this._r.setOnClickListener(this);
    }

    @Override // com.fancy._h1
    public ImageView getImageView() {
        return this._l;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this._m) {
            NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._s;
            if (niceVideoPlayer._l == 0) {
                niceVideoPlayer._d();
                return;
            }
            return;
        }
        if (view == this._r) {
            NiceVideoPlayer niceVideoPlayer2 = (NiceVideoPlayer) this._s;
            niceVideoPlayer2.getClass();
            NiceVideoPlayer._a(new _hf(niceVideoPlayer2));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._s;
        int i = niceVideoPlayer._l;
        if (i == 6 || i == 4) {
            niceVideoPlayer.getClass();
            NiceVideoPlayer._a(new _hf(niceVideoPlayer));
        }
        long duration = (long) ((this._s.getDuration() * ((long) seekBar.getProgress())) / 100.0f);
        NiceVideoPlayer niceVideoPlayer2 = (NiceVideoPlayer) this._s;
        niceVideoPlayer2.getClass();
        NiceVideoPlayer._a(new _h4(niceVideoPlayer2, duration));
    }

    @Override // com.fancy._h1
    public void setImage(int i) {
        this._l.setImageResource(i);
    }

    @Override // com.fancy._h1
    public void setNiceVideoPlayer(_eo _eoVar) {
        super.setNiceVideoPlayer(_eoVar);
        this._s = _eoVar;
    }

    public void setPlayStateChanged(_a _aVar) {
        this._v = _aVar;
    }

    public void setProgressListener(_b _bVar) {
        this._u = _bVar;
    }

    public void setUrl(String str) {
        _eo _eoVar;
        if (str == null || (_eoVar = this._s) == null) {
            return;
        }
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) _eoVar;
        niceVideoPlayer._n = str;
        niceVideoPlayer._o = null;
    }
}
