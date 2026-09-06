package com.fancy;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j8 extends _jb implements View.OnClickListener {
    public PtgCoreVideo _a;
    public _j9 _b;
    public _ke _c;
    public final Handler _d;
    public final _a _e;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int currentPosition = _j8.this._a.getCurrentPosition();
            int duration = _j8.this._a.getDuration();
            _ke _keVar = _j8.this._c;
            if (_keVar != null) {
                long j = duration;
                long j2 = currentPosition;
                _l4._b _bVar = ((_ld) _keVar)._b;
                if (_bVar != null) {
                    _bVar._a(j, j2);
                }
            }
            _j8.this._d.removeCallbacks(this);
            _j8 _j8Var = _j8.this;
            _j8Var._d.postDelayed(_j8Var._e, 1000L);
        }
    }

    public _j8(Context context) {
        super(context);
        this._d = new Handler();
        this._e = new _a();
    }

    @Override // com.fancy._jb
    public final void _a() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    /* JADX WARN: Code duplicated, block: B:17:0x002f  */
    @Override // com.fancy._jb
    public final void _a(int i) {
        if (i == -1 || i == 0) {
            _d();
        } else if (i == 3) {
            _c();
        } else if (i == 4) {
            _d();
        } else if (i == 7) {
            _d();
            int duration = this._a.getDuration();
            _ke _keVar = this._c;
            if (_keVar != null) {
                long j = duration;
                _l4._b _bVar = ((_ld) _keVar)._b;
                if (_bVar != null) {
                    _bVar._a(j, j);
                }
            }
        } else if (i == 10) {
            _c();
        }
        _ke _keVar2 = this._c;
        if (_keVar2 != null) {
            _ld _ldVar = (_ld) _keVar2;
            _ldVar._c.getClass();
            if (4 == i) {
                _lh _lhVar = _ldVar._c._k;
                if (_lhVar != null) {
                    _lhVar._n.set(2);
                }
                _ldVar._c._a(true);
                _l7 _l7Var = _ldVar._c._r;
                if (_l7Var != null) {
                    _l7Var.onVideoPause();
                    return;
                }
                return;
            }
            if (3 == i) {
                _lh _lhVar2 = _ldVar._c._k;
                if (_lhVar2 != null) {
                    _lhVar2._n.set(1);
                }
                _ldVar._c._a(false);
                PtgVideoView ptgVideoView = _ldVar._c;
                ImageView imageView = ptgVideoView._g;
                if (imageView != null) {
                    imageView.postDelayed(new _lg(ptgVideoView), 500L);
                }
                _l7 _l7Var2 = _ldVar._c._r;
                if (_l7Var2 != null) {
                    if (!_ldVar._a) {
                        _l7Var2.onVideoResume();
                        return;
                    } else {
                        _ldVar._a = false;
                        _l7Var2.onVideoStart();
                        return;
                    }
                }
                return;
            }
            if (2 == i) {
                if (!_ldVar._c._q.get()) {
                    PtgVideoView ptgVideoView2 = _ldVar._c;
                    if (ptgVideoView2._a != null) {
                        ptgVideoView2._q.set(true);
                        _ldVar._c._a._a();
                    }
                }
                PtgVideoView ptgVideoView3 = _ldVar._c;
                ptgVideoView3.setSoundMute(ptgVideoView3._c == 0);
                return;
            }
            if (7 != i) {
                if (-1 == i) {
                    _ldVar._c._a(false);
                    return;
                }
                return;
            }
            _ldVar._c._a(false);
            PtgVideoView ptgVideoView4 = _ldVar._c;
            _f _fVar = ptgVideoView4._l;
            _l6 _l6Var = ptgVideoView4._m;
            if (_l6Var != null) {
                _l6Var._a(_fVar, -1L);
            }
            MediaPlayer.OnCompletionListener onCompletionListener = _ldVar._c._s;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(null);
            }
        }
    }

    @Override // com.fancy._jb
    public final void _b() {
        _d();
    }

    public final void _c() {
        this._d.removeCallbacks(this._e);
        this._d.post(this._e);
    }

    public final void _d() {
        this._d.removeCallbacks(this._e);
    }

    @Override // com.fancy._jb
    public _j9 getInfo() {
        return this._b;
    }

    @Override // com.fancy._jb
    public PtgCoreVideo getVideoPlayer() {
        return this._a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        PtgCoreVideo ptgCoreVideo = this._a;
        if (ptgCoreVideo == null) {
            return;
        }
        if (i != 0) {
            PtgCoreVideo._a(new _ix(ptgCoreVideo));
            _d();
        } else {
            if (ptgCoreVideo.getCurrentPosition() == this._a.getDuration() || this._a.getCurrStatus() != 3) {
                return;
            }
            _c();
        }
    }

    @Override // com.fancy._jb
    public void setInfo(_j9 _j9Var) {
        this._b = _j9Var;
    }

    public void setPlayerListener(_ke _keVar) {
        this._c = _keVar;
    }

    @Override // com.fancy._jb
    public void setVideoPlayer(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }
}
