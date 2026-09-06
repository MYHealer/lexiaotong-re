package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.multi.R;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class VideoRenderView extends FrameLayout implements Handler.Callback {
    public static final /* synthetic */ int jad_hq = 0;
    public MediaPlayer.OnPreparedListener jad_al;
    public MediaPlayer jad_an;
    public MediaPlayer.OnVideoSizeChangedListener jad_bm;
    public int jad_bo;
    public int jad_cn;
    public int jad_cp;
    public boolean jad_do;
    public Context jad_dq;
    public MediaPlayer.OnCompletionListener jad_en;
    public boolean jad_ep;
    public com.jd.ad.sdk.bl.video.jad_an jad_er;
    public MediaPlayer.OnErrorListener jad_fo;
    public ImageView jad_fq;
    public int jad_fs;
    public MediaPlayer.OnBufferingUpdateListener jad_gp;
    public ImageView jad_gr;
    public boolean jad_hs;
    public ShakeListener jad_hu;
    public long jad_it;
    public int jad_iv;
    public com.jd.ad.sdk.bl.video.jad_an.jad_bo jad_jt;
    public VideoSkipView jad_ju;
    public float jad_jw;
    public FrameLayout jad_kv;
    public float jad_kx;
    public TextView jad_lw;
    public float jad_ly;
    public String jad_mx;
    public float jad_mz;
    public float jad_na;
    public int jad_ny;
    public boolean jad_ob;
    public SplashRenderVideoHelper jad_oz;
    public String jad_pa;
    public int jad_pc;
    public int jad_qb;
    public VideoInteractionListener jad_qd;
    public String jad_rc;
    public boolean jad_re;
    public int jad_sd;
    public jad_iv jad_sf;
    public boolean jad_te;
    public LottieAnimationView jad_tg;
    public String jad_uf;
    public OnVideoRenderListener jad_uh;
    public VideoLoadListener jad_vg;
    public double jad_vi;
    public int jad_wh;
    public double jad_wj;
    public boolean jad_xi;
    public String jad_xk;
    public String jad_yj;
    public int jad_yl;
    public boolean jad_zk;
    public int jad_zm;

    public class jad_an implements MediaPlayer.OnPreparedListener {
        public jad_an() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoRenderView.this.jad_zk = true;
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_cp = 2;
            OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(2, videoRenderView.getDuration());
            }
            int i = VideoRenderView.this.jad_fs;
            if (i > 0 && mediaPlayer.getDuration() > 0) {
                VideoRenderView.this.jad_an.seekTo(i);
                VideoRenderView.this.jad_fs = 0;
            }
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            int i2 = videoRenderView2.jad_bo;
            if (i2 == 3) {
                videoRenderView2.jad_bo = 3;
                try {
                    if (videoRenderView2.jad_an() && (videoRenderView2.getState() == 2 || videoRenderView2.getState() == 4 || videoRenderView2.getState() == 6)) {
                        if (videoRenderView2.jad_an != null && videoRenderView2.jad_bo() && videoRenderView2.jad_zk) {
                            videoRenderView2.jad_an.start();
                        }
                        videoRenderView2.jad_cp = 3;
                    }
                } catch (Exception e) {
                    videoRenderView2.jad_an(e);
                }
            } else if (i2 == 4) {
                try {
                    if (videoRenderView2.jad_an()) {
                        int state = videoRenderView2.getState();
                        if (videoRenderView2.jad_an() && state != -2 && state != -1 && state != 0 && state != 1 && state != 4 && state != 5) {
                            videoRenderView2.jad_an.pause();
                            videoRenderView2.jad_cp = 4;
                        }
                    }
                } catch (Exception e2) {
                    videoRenderView2.jad_an(e2);
                }
                videoRenderView2.jad_bo = 4;
            } else if (i2 == 5 || i2 == 0) {
                if (videoRenderView2.jad_an()) {
                    videoRenderView2.jad_an.reset();
                    videoRenderView2.jad_cp = 0;
                }
                videoRenderView2.jad_bo = 0;
            }
            VideoRenderView videoRenderView3 = VideoRenderView.this;
            OnVideoRenderListener onVideoRenderListener2 = videoRenderView3.jad_uh;
            if (onVideoRenderListener2 != null) {
                videoRenderView3.jad_wh = 1;
                onVideoRenderListener2.onVideoRenderSuccess(videoRenderView3);
            }
        }
    }

    public class jad_bo implements MediaPlayer.OnVideoSizeChangedListener {
        public jad_bo() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = videoRenderView.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an((int) videoRenderView.jad_vi, (int) videoRenderView.jad_wj);
            }
        }
    }

    public class jad_cp implements MediaPlayer.OnCompletionListener {
        public jad_cp() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoRenderView.jad_an(VideoRenderView.this, mediaPlayer);
        }
    }

    public class jad_dq implements MediaPlayer.OnErrorListener {
        public jad_dq() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String strJad_an;
            Logger.d("VideoRenderView Error: " + i + "," + i2);
            VideoRenderView.this.jad_re = true;
            VideoRenderView.this.jad_an(false);
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_cp = -1;
            videoRenderView.jad_bo = -1;
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
            int i3 = jad_anVar.jad_an;
            jad_anVar.jad_an(new String[0]);
            if (i == -1010) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNSUPPORTED_ERROR;
                i3 = jad_anVar2.jad_an;
                strJad_an = jad_anVar2.jad_an(new String[0]);
            } else if (i == -1007) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_MALFORMED_ERROR;
                i3 = jad_anVar3.jad_an;
                strJad_an = jad_anVar3.jad_an(new String[0]);
            } else if (i == -1004) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_IO_ERROR;
                i3 = jad_anVar4.jad_an;
                strJad_an = jad_anVar4.jad_an(new String[0]);
            } else if (i == -110) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_TIMED_OUT_ERROR;
                i3 = jad_anVar5.jad_an;
                strJad_an = jad_anVar5.jad_an(new String[0]);
            } else if (i == 1) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNKNOWN_ERROR;
                i3 = jad_anVar6.jad_an;
                strJad_an = jad_anVar6.jad_an(new String[0]);
            } else if (i == 100) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_SERVER_DIED_ERROR;
                i3 = jad_anVar7.jad_an;
                strJad_an = jad_anVar7.jad_an(new String[0]);
            } else if (i != 200) {
                strJad_an = jad_anVar.jad_an(new String[0]) + PPSLabelView.Code + i;
            } else {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PROGRESSIVE_PLAYBACK_ERROR;
                i3 = jad_anVar8.jad_an;
                strJad_an = jad_anVar8.jad_an(new String[0]);
            }
            String str = strJad_an;
            int i4 = i3;
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            OnVideoRenderListener onVideoRenderListener = videoRenderView2.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(7, videoRenderView2.getDuration());
                VideoRenderView videoRenderView3 = VideoRenderView.this;
                videoRenderView3.jad_uh.videoPlayerError(i4, i, i2, videoRenderView3.getDuration(), str);
            }
            return true;
        }
    }

    public class jad_er implements MediaPlayer.OnBufferingUpdateListener {
        public jad_er() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            int i2 = VideoRenderView.jad_hq;
            videoRenderView.getClass();
        }
    }

    public class jad_fs implements View.OnTouchListener {
        public jad_fs(VideoRenderView videoRenderView) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class jad_hu implements OnImageLoadListener {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, String str, Drawable drawable) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_qb = i;
            videoRenderView.jad_rc = str;
            videoRenderView.jad_hs = false;
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            videoRenderView2.jad_an(videoRenderView2.jad_xi);
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(Drawable drawable) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            if (videoRenderView.jad_fq != null) {
                videoRenderView.jad_hs = true;
                VideoRenderView.this.jad_fq.setImageDrawable(drawable);
                if (TextUtils.isEmpty(VideoRenderView.this.jad_mx)) {
                    VideoRenderView.this.jad_an(true);
                } else {
                    VideoRenderView videoRenderView2 = VideoRenderView.this;
                    videoRenderView2.jad_an(videoRenderView2.jad_xi);
                }
            }
        }
    }

    public class jad_iv implements ActLifecycle.jad_an {
        public jad_iv() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            ShakeListener shakeListener = VideoRenderView.this.jad_hu;
            if (shakeListener != null) {
                shakeListener.unregister();
            }
        }
    }

    public class jad_jt implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View jad_an;

        public jad_jt(View view) {
            this.jad_an = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jad_an.getLayoutParams();
            if (layoutParams != null) {
                int measuredWidth = this.jad_an.getMeasuredWidth();
                int measuredHeight = this.jad_an.getMeasuredHeight();
                double d = measuredWidth;
                VideoRenderView videoRenderView = VideoRenderView.this;
                double d2 = videoRenderView.jad_vi;
                if (d > d2) {
                    layoutParams.leftMargin = (-((int) (d - d2))) / 2;
                }
                double d3 = measuredHeight;
                double d4 = videoRenderView.jad_wj;
                if (d3 > d4) {
                    layoutParams.topMargin = (-((int) (d3 - d4))) / 2;
                }
            }
        }
    }

    public static class jad_jw {
        public float jad_an;
        public float jad_bo;
        public OnVideoRenderListener jad_cp;
        public int jad_dq;
        public int jad_er;
        public String jad_fs;
        public boolean jad_hu;
        public boolean jad_iv;
        public int jad_jt;
        public String jad_jw;
        public String jad_kx;
        public String jad_ly;
        public VideoLoadListener jad_mz;
        public long jad_na;
        public int jad_ob;
        public int jad_pc;
    }

    public VideoRenderView(Context context, jad_jw jad_jwVar) throws Throwable {
        super(context);
        this.jad_an = null;
        this.jad_bo = Integer.MAX_VALUE;
        this.jad_cp = 0;
        this.jad_iv = 100;
        this.jad_jw = 0.0f;
        this.jad_kx = 1.0f;
        this.jad_ly = 0.0f;
        this.jad_mz = 0.0f;
        this.jad_na = 45.0f;
        this.jad_re = false;
        this.jad_sd = 2;
        this.jad_wh = 0;
        this.jad_zk = false;
        this.jad_al = new jad_an();
        this.jad_bm = new jad_bo();
        this.jad_en = new jad_cp();
        this.jad_fo = new jad_dq();
        this.jad_gp = new jad_er();
        this.jad_dq = context;
        jad_iv();
        jad_cp();
        jad_an(jad_jwVar);
        jad_dq();
        if (!this.jad_xi) {
            JADMediator.getInstance().getAdVideoService().registerAd(this.jad_uf);
        }
        jad_an(context);
        jad_jt();
        if (this.jad_xi) {
            return;
        }
        jad_er();
    }

    public static void jad_an(VideoRenderView videoRenderView, MediaPlayer mediaPlayer) {
        int i;
        videoRenderView.getClass();
        try {
            if (videoRenderView.jad_cp == 6 || (i = videoRenderView.jad_ny) <= 0 || i != videoRenderView.getDuration()) {
                return;
            }
            videoRenderView.jad_cp = 6;
            videoRenderView.jad_bo = 6;
            OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(4, videoRenderView.getDuration());
            }
            if (mediaPlayer == null || mediaPlayer.isLooping()) {
                return;
            }
            try {
                if (videoRenderView.jad_an() && (videoRenderView.getState() == 2 || videoRenderView.getState() == 3 || videoRenderView.getState() == 4 || videoRenderView.getState() == 6)) {
                    videoRenderView.jad_an.stop();
                    videoRenderView.jad_cp = 5;
                }
            } catch (Exception unused) {
            }
            videoRenderView.jad_bo = 5;
        } catch (Exception unused2) {
        }
    }

    public void destroy() {
        AudioManager audioManager;
        try {
            if (jad_an()) {
                this.jad_cp = -2;
                MediaPlayer mediaPlayer = this.jad_an;
                if (mediaPlayer != null) {
                    mediaPlayer.setOnPreparedListener(null);
                    this.jad_an.setOnVideoSizeChangedListener(null);
                    this.jad_an.setOnCompletionListener(null);
                    this.jad_an.setOnErrorListener(null);
                    this.jad_an.setOnInfoListener(null);
                    this.jad_an.setOnBufferingUpdateListener(null);
                }
                this.jad_an.release();
            }
            Context context = this.jad_dq;
            if (context != null && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.jad_jt = null;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an();
                this.jad_er = null;
            }
            jad_iv jad_ivVar = this.jad_sf;
            CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
            if (jad_ivVar != null) {
                copyOnWriteArrayList.remove(jad_ivVar);
            }
            this.jad_sf = null;
            JADMediator.getInstance().getAdVideoService().unregisterAd(this.jad_uf);
            com.jd.ad.sdk.jad_ly.jad_dq jad_dqVarJad_an = com.jd.ad.sdk.jad_ly.jad_dq.jad_an();
            WeakHashMap<String, Bitmap> weakHashMap = jad_dqVarJad_an.jad_an;
            if (weakHashMap != null) {
                weakHashMap.clear();
                jad_dqVarJad_an.jad_an = null;
            }
            com.jd.ad.sdk.jad_ly.jad_dq.jad_bo = null;
        } catch (Exception unused) {
        }
    }

    public int getAdAnimationType() {
        return this.jad_pc;
    }

    public int getAdClickAreaValue() {
        return this.jad_iv;
    }

    public int getDuration() {
        try {
            if (this.jad_re || !jad_an() || getState() == -1 || getState() == 1 || getState() == 0) {
                return 0;
            }
            return this.jad_an.getDuration();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getState() {
        return this.jad_cp;
    }

    public Exception getVideoRenderException() {
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 10001) {
            return false;
        }
        jad_an(true);
        return false;
    }

    public final boolean jad_an() {
        return (this.jad_an == null || this.jad_xi) ? false : true;
    }

    public final void jad_cp() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return;
        }
        this.jad_jw = jad_anVarJad_an.jad_cp;
        this.jad_kx = jad_anVarJad_an.jad_dq;
        this.jad_na = jad_anVarJad_an.jad_jw;
        this.jad_ly = jad_anVarJad_an.jad_er;
        this.jad_mz = jad_anVarJad_an.jad_fs;
        this.jad_yj = jad_anVarJad_an.jad_sf;
        this.jad_xi = "1".equals(jad_anVarJad_an.jad_tg);
        if (this.jad_kx <= 0.0f) {
            this.jad_kx = 1.0f;
        }
        if (this.jad_na <= 0.0f) {
            this.jad_na = 45.0f;
        }
    }

    public final void jad_dq() {
        if (this.jad_zm == CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_cn == CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_pc = 1;
                return;
            } else {
                this.jad_pc = 0;
                return;
            }
        }
        if (this.jad_zm == CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_pc = 2;
        } else if (this.jad_zm == CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_pc = 3;
        }
    }

    public final void jad_er() {
        new Handler(Looper.getMainLooper(), this).sendEmptyMessageDelayed(10001, Math.max(this.jad_it - 100, 5L));
    }

    public void jad_hu() {
        try {
            if (TextUtils.isEmpty(this.jad_xk)) {
                this.jad_hs = false;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_EMPTY_IMAGES_ERROR;
                this.jad_qb = jad_anVar.jad_an;
                this.jad_rc = jad_anVar.jad_an(new String[0]);
                if (this.jad_xi || TextUtils.isEmpty(this.jad_mx) || this.jad_re) {
                    jad_an(true);
                }
            } else {
                JADMediator.getInstance().getFoundationService().loadImage(this.jad_dq, this.jad_xk, new jad_hu());
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_LOAD_IMAGES_ERROR;
            this.jad_qb = jad_anVar2.jad_an;
            this.jad_rc = jad_anVar2.jad_an(new String[0]) + e.getMessage();
            this.jad_hs = false;
            jad_an(this.jad_xi);
        }
    }

    public final void jad_iv() {
        jad_iv jad_ivVar = new jad_iv();
        this.jad_sf = jad_ivVar;
        ActLifecycle.jad_an(jad_ivVar);
    }

    public final void jad_jt() {
        setOnTouchListener(new jad_fs(this));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_ob = z;
        if (z) {
            ShakeListener shakeListener = this.jad_hu;
            if (shakeListener != null) {
                shakeListener.register();
            }
        } else {
            ShakeListener shakeListener2 = this.jad_hu;
            if (shakeListener2 != null) {
                shakeListener2.unregister();
            }
        }
        try {
            if (this.jad_an == null || !jad_bo() || this.jad_re || this.jad_xi) {
                return;
            }
            if (this.jad_ob) {
                if (!this.jad_an.isPlaying() && this.jad_an != null && jad_bo() && this.jad_zk) {
                    this.jad_an.start();
                }
            } else if (this.jad_an.isPlaying()) {
                this.jad_an.pause();
            }
            OnVideoRenderListener onVideoRenderListener = this.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(this.jad_ob ? 6 : 5, getDuration());
            }
        } catch (Exception unused) {
        }
    }

    public void play() {
        MediaPlayer mediaPlayer;
        OnVideoRenderListener onVideoRenderListener;
        OnVideoRenderListener onVideoRenderListener2;
        try {
            if (this.jad_an != null && !jad_bo() && !this.jad_re && this.jad_zk) {
                this.jad_an.seekTo(0);
                this.jad_an.start();
                this.jad_an.pause();
                VideoSkipView videoSkipView = this.jad_ju;
                if (videoSkipView != null) {
                    videoSkipView.setTotalCount(this.jad_yl);
                    return;
                }
                return;
            }
            if (this.jad_kv != null) {
                if (!this.jad_re && jad_an() && this.jad_zk) {
                    this.jad_kv.setVisibility(0);
                    this.jad_an.start();
                } else {
                    this.jad_kv.setVisibility(8);
                }
            }
            LottieAnimationView lottieAnimationView = this.jad_tg;
            if (lottieAnimationView != null && this.jad_pc != 1) {
                lottieAnimationView.setVisibility(0);
                this.jad_tg.jad_dq();
            }
            if (!this.jad_xi && (onVideoRenderListener2 = this.jad_uh) != null) {
                onVideoRenderListener2.videoPlayerStatusChanged(1, getDuration());
            }
            if (!this.jad_xi && !this.jad_re && (mediaPlayer = this.jad_an) != null && mediaPlayer.isPlaying() && (onVideoRenderListener = this.jad_uh) != null) {
                onVideoRenderListener.videoPlayerStatusChanged(3, getDuration());
            }
            if (this.jad_ju != null) {
                HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_ly.jad_er(this));
            }
        } catch (Exception unused) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
        }
    }

    public void setVideoInteractionListener(VideoInteractionListener videoInteractionListener) {
        this.jad_qd = videoInteractionListener;
    }

    public final boolean jad_bo() {
        int iHeight;
        int iWidth;
        try {
            Rect rect = new Rect();
            if (getGlobalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            return com.jd.ad.sdk.jad_jt.jad_iv.jad_an(iHeight * iWidth, JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) * JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) >= 50;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setDataSource(String str) {
        try {
            if (this.jad_an == null) {
                this.jad_an = new MediaPlayer();
            }
            this.jad_bo = Integer.MAX_VALUE;
            this.jad_an.setOnPreparedListener(this.jad_al);
            this.jad_an.setOnVideoSizeChangedListener(this.jad_bm);
            this.jad_an.setOnErrorListener(this.jad_fo);
            this.jad_an.setOnBufferingUpdateListener(this.jad_gp);
            if (this.jad_sd == 1) {
                if (jad_an()) {
                    this.jad_an.setVolume(1.0f, 1.0f);
                }
            } else if (jad_an()) {
                this.jad_an.setVolume(0.0f, 0.0f);
            }
            this.jad_cp = 1;
            this.jad_an.setDataSource(this.jad_dq, Uri.parse(str));
            this.jad_an.setOnCompletionListener(this.jad_en);
            this.jad_an.setAudioStreamType(3);
            this.jad_an.setScreenOnWhilePlaying(true);
            this.jad_an.setLooping(false);
            this.jad_an.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
            this.jad_cp = -1;
            this.jad_bo = -1;
        }
    }

    private String getStoreVideoPath() {
        if ("1".equals(this.jad_yj)) {
            return "";
        }
        if (this.jad_oz == null) {
            this.jad_oz = new SplashRenderVideoHelper(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), this.jad_pa);
        }
        com.jd.ad.sdk.jad_ly.jad_cp storageVideoByUrl = this.jad_oz.getStorageVideoByUrl(this.jad_mx);
        return storageVideoByUrl != null ? storageVideoByUrl.jad_dq : "";
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[Catch: Exception -> 0x008f, TRY_LEAVE, TryCatch #0 {Exception -> 0x008f, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0015, B:17:0x0058, B:24:0x0071, B:26:0x0078, B:23:0x006e, B:12:0x002b, B:15:0x0044, B:20:0x0064), top: B:31:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public final void jad_fs() throws Throwable {
        double d;
        double d2;
        double d3;
        String str;
        LottieAnimationView lottieAnimationView;
        try {
            String str2 = "";
            int i = this.jad_pc;
            boolean z = true;
            if (i == 1) {
                this.jad_tg.setVisibility(8);
                return;
            }
            double d4 = 0.0d;
            if (i != 0) {
                if (i == 2) {
                    double dMin = Math.min(this.jad_wj, this.jad_vi) / 2.0d;
                    d2 = dMin;
                    d4 = (dMin / 5.0d) * 2.0d;
                    str2 = "jad_shake.json";
                    d = d2;
                } else if (i == 3) {
                    d3 = (this.jad_vi / 4.0d) * 3.0d;
                    d = this.jad_wj / 2.0d;
                    d4 = d / 4.0d;
                    str = "jad_slideup.json";
                } else {
                    z = false;
                    d = 0.0d;
                    d2 = 0.0d;
                }
                this.jad_tg.setImageAssetsFolder("images/");
                lottieAnimationView = this.jad_tg;
                if (lottieAnimationView != null) {
                    try {
                        lottieAnimationView.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.jad_tg.setAnimation(str2);
                if (z) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jad_tg.getLayoutParams();
                    layoutParams.width = (int) d2;
                    layoutParams.height = (int) d;
                    layoutParams.bottomMargin = (int) d4;
                    this.jad_tg.setLayoutParams(layoutParams);
                }
            }
            d3 = this.jad_vi;
            d = (104.0d * d3) / 750.0d;
            str = "jad_click.json";
            double d5 = d3;
            str2 = str;
            d2 = d5;
            this.jad_tg.setImageAssetsFolder("images/");
            lottieAnimationView = this.jad_tg;
            if (lottieAnimationView != null) {
                lottieAnimationView.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
            }
            this.jad_tg.setAnimation(str2);
            if (z) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jad_tg.getLayoutParams();
                layoutParams2.width = (int) d2;
                layoutParams2.height = (int) d;
                layoutParams2.bottomMargin = (int) d4;
                this.jad_tg.setLayoutParams(layoutParams2);
            }
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR;
            throw new Throwable(sb.append(jad_anVar.jad_an).append(x.A).append(jad_anVar.jad_an(new String[0])).toString(), e2);
        }
    }

    public static boolean jad_an(VideoRenderView videoRenderView, View view) {
        videoRenderView.getClass();
        return view != null && view.getGlobalVisibleRect(new Rect()) && view.isShown();
    }

    public final void jad_an(Context context) throws Throwable {
        View viewInflate;
        LottieAnimationView lottieAnimationView;
        try {
            if (this.jad_xi) {
                viewInflate = LayoutInflater.from(context).inflate(R.layout.jad_video_img_render_layout, (ViewGroup) null);
            } else {
                viewInflate = LayoutInflater.from(context).inflate(R.layout.jad_video_render_layout, (ViewGroup) null);
                this.jad_lw = (TextView) viewInflate.findViewById(R.id.jad_text_video_preloaded);
                this.jad_kv = (FrameLayout) viewInflate.findViewById(R.id.fl_splash_video);
                this.jad_er = (com.jd.ad.sdk.bl.video.jad_an) viewInflate.findViewById(R.id.jad_video_texture_view);
                View viewFindViewById = viewInflate.findViewById(R.id.jad_video_texture_view);
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new jad_jt(viewFindViewById));
                this.jad_gr = (ImageView) viewInflate.findViewById(R.id.jad_splash_video_thumbnail);
                com.jd.ad.sdk.jad_ly.jad_dq jad_dqVarJad_an = com.jd.ad.sdk.jad_ly.jad_dq.jad_an();
                String str = this.jad_uf;
                WeakHashMap<String, Bitmap> weakHashMap = jad_dqVarJad_an.jad_an;
                Bitmap bitmap = weakHashMap != null ? weakHashMap.get(str) : null;
                if (bitmap != null) {
                    this.jad_gr.setVisibility(0);
                    this.jad_gr.setImageBitmap(bitmap);
                }
                this.jad_an = new MediaPlayer();
                com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
                if (jad_anVar != null) {
                    jad_anVar.setRenderCallback(new com.jd.ad.sdk.bl.video.jad_bo(this));
                }
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) viewInflate.findViewById(R.id.jad_video_lottie);
            this.jad_tg = lottieAnimationView2;
            int i = 8;
            lottieAnimationView2.setVisibility(8);
            this.jad_tg.setCacheComposition(false);
            this.jad_fq = (ImageView) viewInflate.findViewById(R.id.jad_splash_video_image);
            this.jad_ju = (VideoSkipView) viewInflate.findViewById(R.id.jad_video_skip_btn);
            addView(viewInflate);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i2 = (int) this.jad_vi;
            int i3 = (int) this.jad_wj;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, i3);
            } else {
                layoutParams.height = i3;
                layoutParams.width = i2;
            }
            setLayoutParams(layoutParams);
            if (this.jad_yl > 5) {
                this.jad_yl = 5;
            }
            VideoSkipView videoSkipView = this.jad_ju;
            if (videoSkipView != null) {
                videoSkipView.setVisibility(this.jad_do ? 8 : 0);
                if (!this.jad_do) {
                    VideoSkipView videoSkipView2 = this.jad_ju;
                    int i4 = this.jad_yl;
                    com.jd.ad.sdk.bl.video.jad_cp jad_cpVar = new com.jd.ad.sdk.bl.video.jad_cp(this);
                    videoSkipView2.jad_an = i4;
                    videoSkipView2.jad_bo = jad_cpVar;
                    videoSkipView2.setOnClickListener(new com.jd.ad.sdk.bl.video.jad_dq(videoSkipView2));
                }
            }
            LottieAnimationView lottieAnimationView3 = this.jad_tg;
            if (lottieAnimationView3 != null && context != null) {
                lottieAnimationView3.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.jad_ly.jad_hu(this, context));
            }
            if (this.jad_xi || TextUtils.isEmpty(this.jad_mx)) {
                this.jad_re = true;
            } else {
                String str2 = this.jad_mx;
                this.jad_te = false;
                String storeVideoPath = getStoreVideoPath();
                if (!TextUtils.isEmpty(storeVideoPath)) {
                    this.jad_te = true;
                    str2 = storeVideoPath;
                }
                OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.updateMaterialMetaPreload(this.jad_te);
                }
                TextView textView = this.jad_lw;
                if (this.jad_te && !this.jad_ep) {
                    i = 0;
                }
                textView.setVisibility(i);
                setDataSource(str2);
            }
            if (this.jad_tg != null) {
                jad_fs();
            }
            jad_hu();
            int i5 = this.jad_pc;
            if (i5 == 3) {
                Context context2 = this.jad_dq;
                FrameLayout frameLayout = this.jad_kv;
                if (frameLayout != null) {
                    frameLayout.setOnTouchListener(new com.jd.ad.sdk.jad_ly.jad_jt(this, context2));
                }
            } else if (i5 == 1) {
                View view = this.jad_xi ? this.jad_fq : this.jad_kv;
                if (view != null) {
                    view.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_fs(this));
                    jad_an(view.getWidth(), view.getHeight());
                }
            } else if (i5 == 0 && (lottieAnimationView = this.jad_tg) != null) {
                lottieAnimationView.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_fs(this));
                jad_an(lottieAnimationView.getWidth(), lottieAnimationView.getHeight());
            }
            if (this.jad_xi || this.jad_te || "1".equals(this.jad_yj) || TextUtils.isEmpty(this.jad_mx)) {
                return;
            }
            JADMediator.getInstance().getAdVideoService().loadAdVideo(context, this.jad_uf, this.jad_mx, this.jad_pa, this.jad_vg);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR;
            throw new Throwable(sb.append(jad_anVar2.jad_an).append(x.A).append(jad_anVar2.jad_an(new String[0])).toString(), e);
        }
    }

    public final void jad_an(int i, int i2) {
        int i3 = (int) (this.jad_vi * this.jad_wj);
        if (i3 > 0) {
            this.jad_iv = ((i * i2) * 100) / i3;
        }
    }

    public final void jad_an(Exception exc) {
        try {
            if (this.jad_uh != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
                int i = jad_anVar.jad_an;
                this.jad_uh.videoPlayerError(i, i, i, getDuration(), jad_anVar.jad_an(new String[0]) + exc.getMessage());
            }
            if (jad_an()) {
                this.jad_an.reset();
                this.jad_cp = 0;
            }
            this.jad_bo = 0;
        } catch (Exception unused) {
        }
    }

    public final void jad_an(boolean z) {
        if ((z || this.jad_re) && this.jad_wh == 0) {
            if (!this.jad_hs) {
                OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.onVideoRenderFailed(this.jad_qb, this.jad_rc);
                    return;
                }
                return;
            }
            ImageView imageView = this.jad_fq;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            OnVideoRenderListener onVideoRenderListener2 = this.jad_uh;
            if (onVideoRenderListener2 != null) {
                onVideoRenderListener2.onVideoRenderSuccess(this);
                this.jad_wh = 2;
            }
        }
    }

    public final void jad_an(jad_jw jad_jwVar) {
        this.jad_vi = jad_jwVar.jad_an;
        this.jad_wj = jad_jwVar.jad_bo;
        this.jad_xk = jad_jwVar.jad_fs;
        this.jad_yl = jad_jwVar.jad_jt;
        this.jad_uh = jad_jwVar.jad_cp;
        this.jad_zm = jad_jwVar.jad_dq;
        this.jad_cn = jad_jwVar.jad_er;
        this.jad_do = jad_jwVar.jad_hu;
        this.jad_ep = jad_jwVar.jad_iv;
        this.jad_mx = jad_jwVar.jad_jw;
        this.jad_pa = jad_jwVar.jad_kx;
        this.jad_uf = jad_jwVar.jad_ly;
        this.jad_vg = jad_jwVar.jad_mz;
        this.jad_it = jad_jwVar.jad_na;
        this.jad_sd = jad_jwVar.jad_ob;
        this.jad_ny = jad_jwVar.jad_pc;
    }
}
