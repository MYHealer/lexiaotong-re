package com.fancy.mpsdk.component.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fancy._ba;
import com.fancy._d0;
import com.fancy._eb;
import com.fancy._ev;
import com.fancy._ex;
import com.fancy._f;
import com.fancy._i5;
import com.fancy._i9;
import com.fancy._iw;
import com.fancy._ix;
import com.fancy._j8;
import com.fancy._j9;
import com.fancy._l2;
import com.fancy._l4;
import com.fancy._l6;
import com.fancy._l7;
import com.fancy._l9;
import com.fancy._la;
import com.fancy._lb;
import com.fancy._ld;
import com.fancy._le;
import com.fancy._lf;
import com.fancy._lh;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils._d;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgVideoView extends _l2 {
    public static final /* synthetic */ int _v = 0;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public AdvertRatioLayout _f;
    public ImageView _g;
    public ImageView _h;
    public ImageView _i;
    public PtgCoreVideo _j;
    public final _lh _k;
    public _f _l;
    public final _l6 _m;
    public boolean _n;
    public int _o;
    public int _p;
    public final AtomicBoolean _q;
    public _l7 _r;
    public MediaPlayer.OnCompletionListener _s;
    public _i9 _t;
    public AdvertRatioLayout._a _u;

    public class _a implements _l4._b {
        public final /* synthetic */ _f _a;
        public final /* synthetic */ _l4._b _b;

        public _a(_f _fVar, _l4._b _bVar) {
            this._a = _fVar;
            this._b = _bVar;
        }

        @Override // com.fancy._l4._b
        public final void _a(long j, long j2) {
            PtgVideoView ptgVideoView = PtgVideoView.this;
            _f _fVar = this._a;
            _l6 _l6Var = ptgVideoView._m;
            if (_l6Var != null) {
                _l6Var._a(_fVar, j2);
            }
            _l4._b _bVar = this._b;
            if (_bVar != null) {
                _bVar._a(j, j2);
            }
        }
    }

    public PtgVideoView(Context context) {
        super(context);
        this._b = 0;
        this._c = 0;
        this._d = true;
        this._e = true;
        this._n = true;
        this._o = 51;
        this._p = 0;
        this._q = new AtomicBoolean();
        this._m = new _l6();
        this._k = new _lh(this);
    }

    public PtgVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._b = 0;
        this._c = 0;
        this._d = true;
        this._e = true;
        this._n = true;
        this._o = 51;
        this._p = 0;
        this._q = new AtomicBoolean();
        this._m = new _l6();
        this._k = new _lh(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSoundMute(boolean z) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            this._n = z;
            ptgCoreVideo.setVolume(z ? 0 : 7);
            ImageView imageView = this._i;
            if (imageView == null || !this._e) {
                return;
            }
            imageView.setImageResource(z ? R.drawable.fancy_ic_player_mute : R.drawable.fancy_ic_player_unmute);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00de  */
    public final void _a(_f _fVar, float f, _l4._b _bVar) {
        String str_a;
        this._l = _fVar;
        if (_fVar == null) {
            return;
        }
        _ba _baVar = _fVar._G;
        if (_baVar != null) {
            this._b = _baVar._a;
            this._c = _baVar._b;
        } else {
            this._c = 0;
        }
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._i = this._b != 0;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.fancy_native_view_video, (ViewGroup) null);
        this._j = (PtgCoreVideo) viewInflate.findViewById(R.id.myvideo);
        this._g = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        this._h = (ImageView) viewInflate.findViewById(R.id.playButton);
        this._i = (ImageView) viewInflate.findViewById(R.id.soundButton);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.advertMaxLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(f);
        this._f.addOnLayoutChangeListener(new _l9(this));
        this._g.setVisibility(4);
        setSoundGravity(this._o);
        setSoundMarginTop(this._p);
        addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        this._h.setOnClickListener(new _la(this));
        this._i.setOnClickListener(new _lb(this));
        setShowSoundButton(this._c == 1);
        setSoundMute(this._c == 0);
        _a _aVar = new _a(_fVar, _bVar);
        _f _fVar2 = this._l;
        if (_fVar2 == null) {
            return;
        }
        String str_o = _fVar2._o();
        Context context = getContext();
        if (str_o == null || str_o.length() == 0) {
            str_a = str_o;
        } else {
            try {
                _eb _ebVar_a = _i5._a(context);
                if (_ebVar_a == null || (str_a = _ebVar_a._a(str_o, true)) == null || str_a.length() == 0) {
                    str_a = str_o;
                }
            } catch (Throwable unused) {
            }
        }
        _j9._a _aVar2 = new _j9._a();
        _aVar2._a = str_a;
        _aVar2._b = str_o;
        _aVar2._c = true;
        _j9 _j9Var = new _j9(_aVar2);
        _j8 _j8Var = new _j8(getContext());
        _j8Var.setPlayerListener(new _ld(this, _aVar));
        _j8Var.setInfo(_j9Var);
        this._j.setHeartVideoContent(_j8Var);
        this._j.setFrameListener(new _le(this));
    }

    public final void _a(boolean z) {
        ImageView imageView = this._h;
        if (imageView != null) {
            int i = 8;
            if (this._d && z) {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public final void _b() {
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._c();
            ViewGroup viewGroup = this._k._b;
            if (viewGroup != null) {
                ConcurrentHashMap concurrentHashMap = _lh._p;
                synchronized (concurrentHashMap) {
                    concurrentHashMap.remove(Integer.valueOf(System.identityHashCode(viewGroup)));
                }
            }
        }
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            PtgCoreVideo._a(new _ix(ptgCoreVideo));
            this._j._a(false);
            this._j = null;
        }
        try {
            ImageView imageView = this._g;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            this._u = null;
        } catch (Exception unused) {
        }
    }

    public final void _c() {
        if (this._j == null || getWindowVisibility() != 0) {
            return;
        }
        if (this._j.getCurrStatus() != 4) {
            this._j._c();
            return;
        }
        PtgCoreVideo ptgCoreVideo = this._j;
        ptgCoreVideo.getClass();
        PtgCoreVideo._a(new _iw(ptgCoreVideo));
    }

    public int getLastState() {
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            return _lhVar._n.get();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._b();
            PtgCoreVideo ptgCoreVideo = this._j;
            if (ptgCoreVideo != null) {
                ptgCoreVideo.setInScrollView(this._k._b != null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._c();
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._a();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._f = z;
            PtgVideoView ptgVideoView = _lhVar._a;
            if (ptgVideoView != null) {
                if (!z) {
                    if (2 != ptgVideoView.getLastState()) {
                        ptgVideoView.setLastState(2);
                        ptgVideoView._a();
                        return;
                    }
                    return;
                }
                ViewGroup viewGroup = _lhVar._b;
                if (viewGroup != null) {
                    _lhVar._a(viewGroup);
                } else if (_lhVar._c) {
                    _lhVar._a(ptgVideoView);
                }
            }
        }
    }

    public void setLastState(int i) {
        _lh _lhVar = this._k;
        if (_lhVar != null) {
            _lhVar._n.set(i);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._s = onCompletionListener;
    }

    public void setOnErrorListener(NiceVideoPlayer._i _iVar) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setOnErrorListener(_iVar);
        }
    }

    public void setShowPlayButton(boolean z) {
        this._d = z;
        _a(z);
    }

    public void setShowSoundButton(boolean z) {
        ImageView imageView;
        this._e = z;
        if (z || (imageView = this._i) == null || imageView.getVisibility() != 0) {
            return;
        }
        this._i.setVisibility(8);
    }

    public void setSizeCallback(AdvertRatioLayout._a _aVar) {
        this._u = _aVar;
    }

    public void setSoundGravity(int i) {
        this._o = i;
        ImageView imageView = this._i;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            this._i.setLayoutParams(layoutParams2);
        }
    }

    public void setSoundMarginTop(int i) {
        this._p = i;
        ImageView imageView = this._i;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = i;
            this._i.setLayoutParams(layoutParams2);
        }
    }

    public void setVideoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setLayoutParams(layoutParams);
        }
    }

    public void setVideoRatio(float f) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setRatio(f);
        }
    }

    public void setVideoStateListener(_l7 _l7Var) {
        this._r = _l7Var;
    }

    public final void _a() {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            PtgCoreVideo._a(new _ix(ptgCoreVideo));
        }
    }

    public final void _a(_d0 _d0Var) {
        this._a = _d0Var;
        _f _fVar = this._l;
        if (_fVar == null) {
            _d0Var._a(new Exception("广告信息异常"));
            return;
        }
        String str_n = _fVar._n();
        if (!TextUtils.isEmpty(str_n)) {
            _lf _lfVar = new _lf(this);
            AtomicBoolean atomicBoolean = _ev._a;
            if (TextUtil.isEmpty(str_n)) {
                return;
            }
            _d._b(new _ex(str_n, _lfVar));
            return;
        }
        String str_o = this._l._o();
        _lf _lfVar2 = new _lf(this);
        AtomicBoolean atomicBoolean2 = _ev._a;
        if (TextUtil.isEmpty(str_o)) {
            return;
        }
        _d._b(new _ex(str_o, _lfVar2));
    }
}
