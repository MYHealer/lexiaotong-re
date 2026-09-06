package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _h1 extends FrameLayout implements View.OnTouchListener {
    public Timer _a;
    public _a _b;
    public _eo _c;
    public float _d;
    public float _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public long _i;
    public float _j;
    public long _k;

    public class _a extends TimerTask {

        /* JADX INFO: renamed from: com.fancy._h1$_a$_a, reason: collision with other inner class name */
        public class RunnableC0367_a implements Runnable {
            public RunnableC0367_a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                _h1.this._e();
            }
        }

        public _a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            _fv._a.post(new RunnableC0367_a());
        }
    }

    public _h1(Context context) {
        super(context);
        this._f = false;
        this._g = false;
        this._h = false;
        setOnTouchListener(this);
    }

    public final void _a() {
        Timer timer = this._a;
        if (timer != null) {
            timer.cancel();
            this._a = null;
        }
        _a _aVar = this._b;
        if (_aVar != null) {
            _aVar.cancel();
            this._b = null;
        }
    }

    public abstract void _a(int i);

    public abstract void _b();

    public abstract void _c();

    public final void _d() {
        _a();
        if (this._a == null) {
            this._a = new Timer();
        }
        if (this._b == null) {
            this._b = new _a();
        }
        this._a.schedule(this._b, 0L, 1000L);
    }

    public abstract void _e();

    public abstract ImageView getImageView();

    /* JADX WARN: Code duplicated, block: B:51:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:53:0x0100  */
    /* JADX WARN: Code duplicated, block: B:55:0x0115  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._c;
        if (niceVideoPlayer._m != 11 || niceVideoPlayer._l == 0 || (i = niceVideoPlayer._l) == -1 || i == 1 || i == 2 || i == 7) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this._d = x;
            this._e = y;
            this._f = false;
            this._h = false;
            this._g = false;
        } else if (action == 1) {
            if (this._f) {
                _eo _eoVar = this._c;
                long j = this._k;
                NiceVideoPlayer niceVideoPlayer2 = (NiceVideoPlayer) _eoVar;
                niceVideoPlayer2.getClass();
                NiceVideoPlayer._a(new _h4(niceVideoPlayer2, j));
                _d();
                return true;
            }
            if (!this._g || this._h) {
                return true;
            }
        } else if (action == 2) {
            float f = x - this._d;
            float f2 = y - this._e;
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            if (!this._f && !this._g && !this._h) {
                if (fAbs >= 80.0f) {
                    _a();
                    this._f = true;
                    this._i = this._c.getCurrentPosition();
                } else if (fAbs2 >= 80.0f) {
                    if (this._d < getWidth() * 0.5f) {
                        this._h = true;
                        if (_h0._b(getContext()) != null) {
                            this._j = _h0._b(getContext()).getWindow().getAttributes().screenBrightness;
                        }
                    } else {
                        this._g = true;
                        this._c.getVolume();
                    }
                }
            }
            if (this._f) {
                long duration = this._c.getDuration();
                this._k = Math.max(0L, Math.min(duration, (long) (((duration * f) / getWidth()) + this._i)));
            }
            if (this._h) {
                float fMax = Math.max(0.0f, Math.min(this._j + (((-f2) * 3.0f) / getHeight()), 1.0f));
                Activity activity_b = _h0._b(getContext());
                if (activity_b != null) {
                    WindowManager.LayoutParams attributes = activity_b.getWindow().getAttributes();
                    attributes.screenBrightness = fMax;
                    activity_b.getWindow().setAttributes(attributes);
                }
            }
        } else if (action == 3) {
            if (this._f) {
                _eo _eoVar2 = this._c;
                long j2 = this._k;
                NiceVideoPlayer niceVideoPlayer3 = (NiceVideoPlayer) _eoVar2;
                niceVideoPlayer3.getClass();
                NiceVideoPlayer._a(new _h4(niceVideoPlayer3, j2));
                _d();
                return true;
            }
            if (!this._g) {
                return true;
            }
        }
        return false;
    }

    public abstract void setImage(int i);

    public void setNiceVideoPlayer(_eo _eoVar) {
        this._c = _eoVar;
    }
}
