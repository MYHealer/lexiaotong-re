package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lp extends FrameLayout {
    public NiceVideoPlayer _a;
    public _l4 _b;
    public AdTemplateWebView _c;
    public ImageView _d;
    public _b _e;
    public _c _f;
    public _3 _g;
    public volatile boolean _h;
    public volatile boolean _i;

    public class _a implements _lr {
        public _a() {
        }

        @Override // com.fancy._lr
        public final void _a(Bitmap bitmap) {
            ImageView imageView;
            if (_lp.this._h || _lp.this._i) {
                return;
            }
            if (bitmap != null && (imageView = _lp.this._d) != null) {
                imageView.setImageBitmap(bitmap);
                _lp.this._d.setVisibility(0);
                Logger.d("RewardVideoWeb", "封面加载成功");
                _c _cVar = _lp.this._f;
                if (_cVar != null) {
                    _mt._b(_mt.this);
                    return;
                }
                return;
            }
            Logger.e("RewardVideoWeb", "封面加载失败: bitmap is null");
            _c _cVar2 = _lp.this._f;
            if (_cVar2 != null) {
                _mt _mtVar = _mt.this;
                _mtVar._A = true;
                ProgressBar progressBar = _mtVar._o;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.SUC_ERR;
                _mtVar._a(serverErr.getCode(), serverErr.getMsg(), false);
                _m8._a()._a(_mtVar._e, PtgErrorCode.SDK_RESOURCE_ERROR, "封面加载失败: bitmap is null");
                PtgBaseVideoActivity ptgBaseVideoActivity = _mtVar._m.get();
                WeakReference<Toast> weakReference = _on._a;
                Context origApplicationContext = StubApp.getOrigApplicationContext(ptgBaseVideoActivity.getApplicationContext());
                Toast toast = _on._a.get();
                if (toast != null) {
                    toast.cancel();
                }
                Toast toastMakeText = Toast.makeText(origApplicationContext, "领取奖励成功", 1);
                toastMakeText.show();
                _on._a = new WeakReference<>(toastMakeText);
                if (_mtVar._m.get() != null) {
                    _mtVar._m.get()._a();
                }
            }
        }
    }

    public static class _b {
        public int _a = 0;
        public int _b = 0;
        public int _c = 0;
        public String _d = "";
        public boolean _e;
    }

    public interface _c {
    }

    public _lp(Context context, _b _bVar) {
        super(context);
        this._g = _3.VIDEO;
        this._h = false;
        this._i = false;
        this._e = _bVar;
        _a(context);
    }

    public final void _a() {
        removeAllViews();
        if (this._g == _3.VIDEO) {
            if (this._a != null) {
                addView(this._a, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this._d != null) {
                addView(this._d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        if (this._c != null) {
            addView(this._c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void _a(Context context) {
        if (this._e._e) {
            NiceVideoPlayer niceVideoPlayer = new NiceVideoPlayer(context);
            this._a = niceVideoPlayer;
            _b _bVar = this._e;
            int i = _bVar._a;
            int i2 = _bVar._b;
            int i3 = _bVar._c;
            niceVideoPlayer._x = i;
            niceVideoPlayer._y = i2;
            niceVideoPlayer._z = i3;
            _l4 _l4Var = new _l4(context);
            this._b = _l4Var;
            this._a.setController(_l4Var);
            String str_a = _i5._a(PtgAdSdk.getContext())._a(this._e._d, true);
            this._b.setVisibility(8);
            this._b.setUrl(str_a);
            this._a.setOnPreparedListener(new _lj(this));
            this._a.setOnCompletionListener(new _lk(this));
            this._a.setOnErrorListener(new _ll(this));
            this._b.setProgressListener(new _lm(this));
            this._b.setPlayStateChanged(new _ln(this));
            ImageView imageView = new ImageView(context);
            this._d = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        AdTemplateWebView adTemplateWebView = new AdTemplateWebView(context);
        this._c = adTemplateWebView;
        adTemplateWebView.setBackgroundColor(0);
        this._c.setWebViewBridgeListener(new _lo(this));
    }

    public _3 getAdType() {
        return this._g;
    }

    public _l4 getController() {
        return this._b;
    }

    public ImageView getCoverImageView() {
        return this._d;
    }

    public long getCurrentPosition() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        if (niceVideoPlayer == null) {
            return 0L;
        }
        return niceVideoPlayer.getCurrentPosition();
    }

    public long getDuration() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        if (niceVideoPlayer == null) {
            return 0L;
        }
        return niceVideoPlayer.getDuration();
    }

    public NiceVideoPlayer getVideoPlayer() {
        return this._a;
    }

    public AdTemplateWebView getWebView() {
        return this._c;
    }

    public void setAdType(_3 _3) {
        NiceVideoPlayer niceVideoPlayer;
        this._g = _3;
        if (_3 != _3.IMAGE || (niceVideoPlayer = this._a) == null) {
            return;
        }
        niceVideoPlayer.setVisibility(8);
    }

    public void setConfig(_b _bVar) {
        this._e = _bVar;
        _a();
    }

    public void setContainerListener(_c _cVar) {
        this._f = _cVar;
    }

    public void setMute(boolean z) {
        setVolume(z ? 0 : 7);
    }

    public void setVideoUrl(String str) {
        this._b.setUrl(str);
    }

    public void setVolume(int i) {
        NiceVideoPlayer niceVideoPlayer;
        if (this._h || (niceVideoPlayer = this._a) == null) {
            return;
        }
        niceVideoPlayer.setMediaVolume(i);
    }

    public final void _b(String str) {
        setAdType(_3.IMAGE);
        _a();
        if (str == null || str.isEmpty()) {
            return;
        }
        this._c.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }

    public void setLoading(boolean z) {
        AdTemplateWebView adTemplateWebView;
        if (z || this._g != _3.IMAGE || this._h || (adTemplateWebView = this._c) == null) {
            return;
        }
        adTemplateWebView.post(new _2(adTemplateWebView, "onAdLoadSuccess", null));
    }

    public final void _a(String str) {
        if (this._d != null && str != null && !str.isEmpty()) {
            _a _aVar = new _a();
            AtomicBoolean atomicBoolean = _ev._a;
            if (TextUtil.isEmpty(str)) {
                return;
            }
            com.fancy.adsdk.lib.utils._d._b(new _ey(_aVar, str));
            return;
        }
        Logger.d("RewardVideoWeb", "封面加载失败: url is empty or coverImageView is null");
    }
}
