package com.yfanads.android.adx.newplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.adx.newplayer.videocache.HttpProxyCacheServer;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.adx.player.yfplayer.IVideoPlayListener;
import com.yfanads.android.utils.YFPlayerLog;
import com.yfanads.android.utils.YFPlayerUtil;
import com.yfanads.android.utils.YFScreenUtil;
import com.yfanads.sdk_player.R;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class VideoPlayerImp extends FrameLayout implements IPlayVideo, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnWindowFocusChangeListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, View.OnAttachStateChangeListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
    public String TAG;
    private final Map<Integer, Boolean> UPD;
    private String checkTag;
    private int currentPosition;
    private boolean isPlaying;
    private boolean isReleased;
    private boolean isViewDetached;
    private boolean mIsPrepared;
    private MediaPlayer mediaPlayer;
    private MediaPlayerState mediaPlayerState;
    private IVideoPlayListener mn;
    private boolean mute;
    private int[] screenWHSize;
    private UpdHandler updHandler;
    private String videoUri;
    private ViewStatus viewStatus;

    /* JADX INFO: renamed from: com.yfanads.android.adx.newplayer.VideoPlayerImp$1, reason: invalid class name */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: renamed from: lambda$onSurfaceTextureAvailable$0$com-yfanads-android-adx-newplayer-VideoPlayerImp$1, reason: not valid java name */
        /* synthetic */ void m1197xc5211cdb() {
            VideoPlayerImp.this.checkVisibilityViewDelay();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Surface surface = new Surface(surfaceTexture);
            if (VideoPlayerImp.this.mediaPlayer == null) {
                VideoPlayerImp.this.prepareMediaPlayer(surface);
                VideoPlayerImp.this.checkVisibilityViewDelay();
                return;
            }
            VideoPlayerImp.this.setMediaPlayerSurface(surface);
            if (VideoPlayerImp.this.mediaPlayerState == MediaPlayerState.STARTED) {
                a.a(new StringBuilder(), VideoPlayerImp.this.TAG, "Surface reattached while STARTED, rendering resumes");
            } else if (VideoPlayerImp.this.mediaPlayerState == MediaPlayerState.PAUSED) {
                a.a(new StringBuilder(), VideoPlayerImp.this.TAG, "Surface reattached while PAUSED, will check visibility");
            } else if (VideoPlayerImp.this.mediaPlayerState == MediaPlayerState.PREPARED) {
                a.a(new StringBuilder(), VideoPlayerImp.this.TAG, "Surface reattached while PREPARED");
            } else {
                VideoPlayerImp.this.prepareMediaPlayer(surface);
            }
            YFPlayerUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.newplayer.VideoPlayerImp$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1197xc5211cdb();
                }
            }, 200L);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (VideoPlayerImp.this.mediaPlayer == null) {
                return true;
            }
            VideoPlayerImp.this.mediaPlayer.setSurface(null);
            if (VideoPlayerImp.this.mediaPlayerState != MediaPlayerState.STARTED) {
                return true;
            }
            VideoPlayerImp.this.pausePlayback();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public enum MediaPlayerState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        ERROR,
        RELEASED
    }

    public static class UpdHandler extends Handler {
        private final SoftReference<VideoPlayerImp> view;

        public UpdHandler(VideoPlayerImp videoPlayerImp) {
            super(Looper.getMainLooper());
            this.view = new SoftReference<>(videoPlayerImp);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (this.view.get() != null) {
                this.view.get().updateProcess();
                this.view.get().startHandler();
            }
        }
    }

    public enum ViewStatus {
        DEFAULT,
        FULLY_VISIBLE,
        COMPLETED
    }

    public VideoPlayerImp(Context context) {
        super(context);
        this.TAG = "";
        this.UPD = new HashMap();
        this.mIsPrepared = false;
        this.currentPosition = 0;
        this.mediaPlayerState = MediaPlayerState.IDLE;
        this.isReleased = false;
        init(context);
    }

    public VideoPlayerImp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "";
        this.UPD = new HashMap();
        this.mIsPrepared = false;
        this.currentPosition = 0;
        this.mediaPlayerState = MediaPlayerState.IDLE;
        this.isReleased = false;
        init(context);
    }

    public VideoPlayerImp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "";
        this.UPD = new HashMap();
        this.mIsPrepared = false;
        this.currentPosition = 0;
        this.mediaPlayerState = MediaPlayerState.IDLE;
        this.isReleased = false;
        init(context);
    }

    public VideoPlayerImp(Context context, String str, boolean z, IVideoPlayListener iVideoPlayListener) {
        this(context, str, z, "", iVideoPlayListener);
    }

    public VideoPlayerImp(Context context, String str, boolean z, String str2, IVideoPlayListener iVideoPlayListener) {
        super(context);
        this.TAG = "";
        this.UPD = new HashMap();
        this.mIsPrepared = false;
        this.currentPosition = 0;
        this.mediaPlayerState = MediaPlayerState.IDLE;
        this.isReleased = false;
        setParams(str, z, str2, iVideoPlayListener);
        init(context);
    }

    private void checkVisibilityView(String str) {
        String str2;
        if (hasVideoCompleted()) {
            return;
        }
        try {
            int width = getWidth();
            int height = getHeight();
            Rect rect = new Rect();
            int[] iArr = this.screenWHSize;
            boolean z = false;
            int i = iArr[0] + (width / 2);
            int i2 = iArr[1] + (height / 2);
            boolean z2 = getGlobalVisibleRect(rect) && rect.bottom - rect.top >= height / 2;
            if (z2) {
                int[] iArr2 = new int[2];
                getLocationOnScreen(iArr2);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                if (i3 >= 0 && i3 + width <= i && i4 >= 0 && i4 + height <= i2) {
                    z = true;
                }
                str2 = this.TAG + " check: " + rect + " half visible , [x" + i3 + "+w" + width + "|" + i + ",y" + i4 + "+h" + height + "|" + i2 + "] result " + z;
            } else {
                str2 = this.TAG + " check: " + rect + " half not visible";
            }
            YFPlayerLog.debug(str2);
            this.viewStatus = (z2 && z) ? ViewStatus.FULLY_VISIBLE : ViewStatus.DEFAULT;
            collectExposureData();
        } catch (Exception e) {
            YFPlayerLog.error("checkVisibilityView error " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVisibilityViewDelay() {
        Handler handler = YFPlayerUtil.MAIN_HANDLER;
        handler.removeCallbacks(this);
        handler.postDelayed(this, 100L);
    }

    private void collectExposureData() {
        MediaPlayer mediaPlayer;
        MediaPlayerState mediaPlayerState;
        if (hasVideoCompleted()) {
            return;
        }
        ViewStatus viewStatus = this.viewStatus;
        if (viewStatus != ViewStatus.FULLY_VISIBLE) {
            if (viewStatus == ViewStatus.DEFAULT) {
                if ((this.mediaPlayerState == MediaPlayerState.STARTED || ((mediaPlayer = this.mediaPlayer) != null && mediaPlayer.isPlaying())) && this.isPlaying) {
                    YFPlayerLog.debug(this.TAG + " not full visible video is playing, start pause.");
                    pause();
                    return;
                }
                return;
            }
            return;
        }
        MediaPlayerState mediaPlayerState2 = this.mediaPlayerState;
        MediaPlayerState mediaPlayerState3 = MediaPlayerState.PREPARED;
        if (mediaPlayerState2 != mediaPlayerState3 && mediaPlayerState2 != MediaPlayerState.PAUSED && (mediaPlayerState2 != (mediaPlayerState = MediaPlayerState.STARTED) || this.isPlaying)) {
            if (mediaPlayerState2 != mediaPlayerState) {
                return;
            }
            TextureView textureView = (TextureView) findViewById(R.id.textureView);
            if (textureView != null && textureView.isAvailable()) {
                return;
            }
            a.a(new StringBuilder(), this.TAG, " Surface not available, need to pause and resume");
            pausePlayback();
        }
        YFPlayerLog.debug(this.TAG + " full visible video need start, state=" + this.mediaPlayerState);
        MediaPlayerState mediaPlayerState4 = this.mediaPlayerState;
        if (mediaPlayerState4 == mediaPlayerState3 || mediaPlayerState4 == MediaPlayerState.PAUSED) {
            reStart();
            startHandler();
        } else if (mediaPlayerState4 == MediaPlayerState.PREPARING) {
            a.a(new StringBuilder(), this.TAG, " Player preparing, will auto-play when ready");
        }
    }

    private void handleFatalError() {
        YFPlayerLog.error(this.TAG + " Handling fatal error - recreating media player");
        releaseMediaPlayer("handleFatalError");
        YFPlayerUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.newplayer.VideoPlayerImp$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1195x7d662e03();
            }
        }, 1000L);
    }

    private void handleIllegalStateError() {
        YFPlayerLog.error(this.TAG + " Handling illegal state error");
        Handler handler = YFPlayerUtil.MAIN_HANDLER;
        handler.removeCallbacks(new Runnable() { // from class: com.yfanads.android.adx.newplayer.VideoPlayerImp$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.rePrepareMediaPlayer();
            }
        });
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.mediaPlayerState = MediaPlayerState.IDLE;
                this.mIsPrepared = false;
                handler.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.newplayer.VideoPlayerImp$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.rePrepareMediaPlayer();
                    }
                }, 500L);
            }
        } catch (Exception e) {
            YFPlayerLog.error(this.TAG + " Failed to handle illegal state: " + e.getMessage());
            handleFatalError();
        }
    }

    private void handleMediaPlayerError(String str, Exception exc) {
        IVideoPlayListener iVideoPlayListener = this.mn;
        if (iVideoPlayListener != null) {
            iVideoPlayListener.onVideoPlayError(-1, -1);
        }
        YFPlayerLog.error(this.TAG + " video render error " + str + PPSLabelView.Code + exc.getMessage());
        resetMediaPlayer();
    }

    private boolean hasUpload() {
        Boolean bool = Boolean.TRUE;
        return bool.equals(this.UPD.get(25)) && bool.equals(this.UPD.get(50)) && bool.equals(this.UPD.get(75));
    }

    private boolean hasVideoCompleted() {
        if (this.viewStatus != ViewStatus.COMPLETED) {
            return false;
        }
        a.a(new StringBuilder(), this.TAG, " video is completed, return.");
        return true;
    }

    private void init(Context context) {
        a.a(new StringBuilder(), this.TAG, "init start");
        try {
            VideoMgr.init(context);
            if (this.mediaPlayer != null) {
                releaseMediaPlayer("init");
            }
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayerState = MediaPlayerState.IDLE;
            this.mIsPrepared = false;
            this.isReleased = false;
            if (this.updHandler == null) {
                this.updHandler = new UpdHandler(this);
            }
            initUPD();
            setupWithTextureView((TextureView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.yf_video_view_layout, (ViewGroup) this, true).findViewById(R.id.textureView));
            addOnAttachStateChangeListener(this);
            getViewTreeObserver().addOnWindowFocusChangeListener(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            getViewTreeObserver().addOnScrollChangedListener(this);
            getScreenVisibleRect();
            YFPlayerUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.newplayer.VideoPlayerImp$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1196lambda$init$0$comyfanadsandroidadxnewplayerVideoPlayerImp();
                }
            }, 80L);
        } catch (Exception e) {
            YFPlayerLog.error(this.TAG + "init error:" + e.getMessage());
        }
        a.a(new StringBuilder(), this.TAG, "init end");
    }

    private void initUPD() {
        Map<Integer, Boolean> map = this.UPD;
        Boolean bool = Boolean.FALSE;
        map.put(25, bool);
        this.UPD.put(50, bool);
        this.UPD.put(75, bool);
    }

    private boolean isMediaPlayerValid() {
        MediaPlayerState mediaPlayerState;
        return (this.isReleased || this.mediaPlayer == null || (mediaPlayerState = this.mediaPlayerState) == MediaPlayerState.RELEASED || mediaPlayerState == MediaPlayerState.ERROR) ? false : true;
    }

    private boolean isNeedProgress(long j, int i, int i2) {
        if (!Boolean.FALSE.equals(this.UPD.get(Integer.valueOf(i))) || j < i || j >= i2) {
            return false;
        }
        this.UPD.put(Integer.valueOf(i), Boolean.TRUE);
        return true;
    }

    private boolean isStateValidFor(String str, MediaPlayerState... mediaPlayerStateArr) {
        for (MediaPlayerState mediaPlayerState : mediaPlayerStateArr) {
            if (this.mediaPlayerState == mediaPlayerState) {
                return true;
            }
        }
        YFPlayerLog.warn(this.TAG + " Invalid state " + this.mediaPlayerState + " for operation " + str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayback() {
        MediaPlayer mediaPlayer;
        if (this.isReleased || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        MediaPlayerState mediaPlayerState = this.mediaPlayerState;
        if (mediaPlayerState != MediaPlayerState.PREPARED && mediaPlayerState != MediaPlayerState.STARTED && mediaPlayerState != MediaPlayerState.PAUSED) {
            YFPlayerLog.debug(this.TAG + " Cannot pause - current state: " + this.mediaPlayerState);
            return;
        }
        MediaPlayerState mediaPlayerState2 = MediaPlayerState.PAUSED;
        if (mediaPlayerState == mediaPlayerState2) {
            try {
                this.currentPosition = mediaPlayer.getCurrentPosition();
                return;
            } catch (IllegalStateException unused) {
                YFPlayerLog.error("getCurrentPosition illegal state in pause");
                return;
            }
        }
        try {
            if (mediaPlayerState == MediaPlayerState.STARTED) {
                this.currentPosition = mediaPlayer.getCurrentPosition();
                this.mediaPlayer.pause();
            }
            this.mediaPlayerState = mediaPlayerState2;
            this.isPlaying = false;
            YFPlayerLog.debug(this.TAG + " pausePlayback " + this.currentPosition);
            stopHandler();
        } catch (IllegalStateException e) {
            YFPlayerLog.error("pausePlayback illegal state error " + e.getMessage());
            handleIllegalStateError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareMediaPlayer(Surface surface) {
        StringBuilder sbAppend;
        String str;
        String str2;
        MediaPlayerState mediaPlayerState = this.mediaPlayerState;
        MediaPlayerState mediaPlayerState2 = MediaPlayerState.PREPARING;
        if (mediaPlayerState == mediaPlayerState2 || mediaPlayerState == MediaPlayerState.PREPARED) {
            sbAppend = new StringBuilder().append(this.TAG);
            str = " Already preparing/prepared, ignore prepare request";
        } else {
            if (!this.isReleased) {
                try {
                    try {
                        YFPlayerLog.debug(this.TAG + "prepareMediaPlayer start");
                        MediaPlayer mediaPlayer = this.mediaPlayer;
                        if (mediaPlayer == null) {
                            this.mediaPlayer = new MediaPlayer();
                            this.mediaPlayerState = MediaPlayerState.IDLE;
                        } else {
                            try {
                                mediaPlayer.reset();
                                this.mediaPlayerState = MediaPlayerState.IDLE;
                            } catch (IllegalStateException e) {
                                YFPlayerLog.error(this.TAG + " Failed to reset player: " + e.getMessage());
                                recreateMediaPlayer();
                                return;
                            }
                        }
                        HttpProxyCacheServer proxy = VideoMgr.getProxy();
                        YFPlayerLog.debug(this.TAG + " video videoUri " + (proxy != null && proxy.isCached(this.videoUri) ? "in cache" : this.videoUri));
                        this.mediaPlayer.setDataSource(proxy != null ? proxy.getProxyUrl(this.videoUri) : this.videoUri);
                        setVolume(this.mute);
                        this.mediaPlayer.setSurface(surface);
                        this.mediaPlayerState = MediaPlayerState.INITIALIZED;
                        this.mediaPlayer.setOnPreparedListener(this);
                        this.mediaPlayer.setOnInfoListener(this);
                        this.mediaPlayer.setOnErrorListener(this);
                        this.mediaPlayer.setOnCompletionListener(this);
                        this.mediaPlayer.prepareAsync();
                        this.mediaPlayerState = mediaPlayerState2;
                        YFPlayerLog.debug(this.TAG + "prepareMediaPlayer end");
                        return;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        YFPlayerLog.error("prepareMediaPlayer illegal state error " + e.getMessage());
                        str2 = "ILLEGAL_STATE";
                        handleMediaPlayerError(str2, e);
                        return;
                    }
                } catch (IOException e3) {
                    e = e3;
                    YFPlayerLog.error("prepareMediaPlayer IO error " + e.getMessage());
                    str2 = "IO_ERROR";
                    handleMediaPlayerError(str2, e);
                    return;
                } catch (Exception e4) {
                    e = e4;
                    YFPlayerLog.error("prepareMediaPlayer unexpected error " + e.getMessage());
                    str2 = "UNEXPECTED_ERROR";
                    handleMediaPlayerError(str2, e);
                    return;
                }
            }
            sbAppend = new StringBuilder().append(this.TAG);
            str = " Player is released, cannot prepare";
        }
        YFPlayerLog.warn(sbAppend.append(str).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rePrepareMediaPlayer() {
        if (this.isReleased || this.videoUri == null) {
            return;
        }
        TextureView textureView = (TextureView) findViewById(R.id.textureView);
        if (textureView == null || !textureView.isAvailable()) {
            YFPlayerLog.warn(this.TAG + " TextureView not available for re-prepare");
            return;
        }
        try {
            prepareMediaPlayer(new Surface(textureView.getSurfaceTexture()));
        } catch (Exception e) {
            YFPlayerLog.error(this.TAG + " Failed to re-prepare: " + e.getMessage());
            handleFatalError();
        }
    }

    private void recreateMediaPlayer() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayerState = MediaPlayerState.IDLE;
            this.mIsPrepared = false;
            this.isPlaying = false;
        } catch (Exception e) {
            YFPlayerLog.error("recreateMediaPlayer error: " + e.getMessage());
        }
    }

    private void releaseMediaPlayer(String str) {
        YFPlayerLog.debug(this.TAG + " releaseMediaPlayer by " + str);
        try {
            this.isReleased = true;
            removeHandler();
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                try {
                    if (this.mediaPlayerState == MediaPlayerState.STARTED) {
                        mediaPlayer.stop();
                    }
                } catch (Exception unused) {
                }
                this.currentPosition = 0;
                this.mediaPlayer.release();
                this.mediaPlayer = null;
                this.mediaPlayerState = MediaPlayerState.RELEASED;
            }
            removeAllViews();
            this.isPlaying = false;
            this.mIsPrepared = false;
        } catch (Exception e) {
            YFPlayerLog.error("releaseMediaPlayer error " + e.getMessage());
        }
    }

    private void removeHandler() {
        stopHandler();
        this.updHandler = null;
    }

    private void removeVisibilityView() {
        YFPlayerUtil.MAIN_HANDLER.removeCallbacks(this);
    }

    private void resetMediaPlayer() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (this.mediaPlayerState == MediaPlayerState.STARTED) {
                    mediaPlayer.stop();
                }
                this.mediaPlayer.reset();
                this.mediaPlayerState = MediaPlayerState.IDLE;
                this.mIsPrepared = false;
                this.isPlaying = false;
            }
            removeHandler();
        } catch (Exception e) {
            YFPlayerLog.error("resetMediaPlayer error: " + e.getMessage());
            recreateMediaPlayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaPlayerSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            MediaPlayerState mediaPlayerState = this.mediaPlayerState;
            if (mediaPlayerState == MediaPlayerState.PREPARED || mediaPlayerState == MediaPlayerState.STARTED || mediaPlayerState == MediaPlayerState.PAUSED) {
                try {
                    mediaPlayer.setSurface(surface);
                } catch (IllegalStateException e) {
                    YFPlayerLog.error(this.TAG + "setSurface illegal state: " + e.getMessage());
                }
            }
        }
    }

    private void setViewDetached() {
        if (this.viewStatus != ViewStatus.COMPLETED) {
            this.viewStatus = ViewStatus.DEFAULT;
        }
    }

    private void setupWithTextureView(TextureView textureView) {
        textureView.setSurfaceTextureListener(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHandler() {
        UpdHandler updHandler = this.updHandler;
        if (updHandler != null) {
            updHandler.removeCallbacksAndMessages(null);
            this.updHandler.sendEmptyMessageDelayed(1, 700L);
        }
    }

    private void startPlayback(String str) {
        startPlayback(str, this.mIsPrepared, this.mediaPlayer);
        startHandler();
    }

    private void startPlayback(String str, boolean z, MediaPlayer mediaPlayer) {
        if (this.isReleased || mediaPlayer == null) {
            YFPlayerLog.warn(this.TAG + " Cannot start playback - player released or null");
            return;
        }
        if (this.mediaPlayerState == MediaPlayerState.PREPARING) {
            a.a(new StringBuilder(), this.TAG, " Player is preparing, will auto-play when ready");
            return;
        }
        if (isStateValidFor(str, MediaPlayerState.PREPARED, MediaPlayerState.PAUSED) && z && !this.isPlaying) {
            try {
                try {
                    YFPlayerLog.debug(this.TAG + " startPlayback " + this.currentPosition);
                    int i = this.currentPosition;
                    if (i > 0) {
                        try {
                            mediaPlayer.seekTo(i, 3);
                        } catch (IllegalStateException e) {
                            YFPlayerLog.error("seekTo error " + e.getMessage());
                            this.currentPosition = 0;
                        }
                    }
                    mediaPlayer.start();
                    this.mediaPlayerState = MediaPlayerState.STARTED;
                    this.isPlaying = true;
                } catch (Exception e2) {
                    YFPlayerLog.error("startPlayback error " + e2.getMessage());
                }
            } catch (IllegalStateException e3) {
                YFPlayerLog.error("startPlayback illegal state error " + e3.getMessage());
                handleIllegalStateError();
            }
        }
    }

    private void stopHandler() {
        UpdHandler updHandler = this.updHandler;
        if (updHandler != null) {
            updHandler.removeMessages(1);
            this.updHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProcess() {
        StringBuilder sbAppend;
        String str;
        if (hasUpload()) {
            a.a(new StringBuilder(), this.TAG, " hasUpload success");
            removeHandler();
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        MediaPlayerState mediaPlayerState = this.mediaPlayerState;
        if (mediaPlayerState != MediaPlayerState.PREPARED && mediaPlayerState != MediaPlayerState.STARTED && mediaPlayerState != MediaPlayerState.PAUSED) {
            return;
        }
        try {
            this.currentPosition = mediaPlayer.getCurrentPosition();
            if (this.mn != null) {
                try {
                    long duration = this.mediaPlayer.getDuration();
                    if (duration <= 0) {
                        return;
                    }
                    long j = (((long) this.currentPosition) * 100) / duration;
                    if (isNeedProgress(j, 25, 35)) {
                        a.a(new StringBuilder(), this.TAG, " video 25% ");
                        IVideoPlayListener iVideoPlayListener = this.mn;
                        if (iVideoPlayListener != null) {
                            iVideoPlayListener.onVideoProgress(25);
                            return;
                        }
                        return;
                    }
                    if (isNeedProgress(j, 50, 60)) {
                        a.a(new StringBuilder(), this.TAG, " video 50% ");
                        IVideoPlayListener iVideoPlayListener2 = this.mn;
                        if (iVideoPlayListener2 != null) {
                            iVideoPlayListener2.onVideoProgress(50);
                            return;
                        }
                        return;
                    }
                    if (isNeedProgress(j, 75, 85)) {
                        a.a(new StringBuilder(), this.TAG, " video 75% ");
                        IVideoPlayListener iVideoPlayListener3 = this.mn;
                        if (iVideoPlayListener3 != null) {
                            iVideoPlayListener3.onVideoProgress(75);
                        }
                    }
                } catch (IllegalStateException unused) {
                    sbAppend = new StringBuilder().append(this.TAG);
                    str = " getDuration illegal state";
                    YFPlayerLog.error(sbAppend.append(str).toString());
                }
            }
        } catch (IllegalStateException unused2) {
            sbAppend = new StringBuilder().append(this.TAG);
            str = " getCurrentPosition illegal state";
        }
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public int getCurrentTime() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        MediaPlayerState mediaPlayerState = this.mediaPlayerState;
        if (mediaPlayerState != MediaPlayerState.PREPARED && mediaPlayerState != MediaPlayerState.STARTED && mediaPlayerState != MediaPlayerState.PAUSED) {
            return 0;
        }
        try {
            return mediaPlayer.getCurrentPosition();
        } catch (IllegalStateException unused) {
            YFPlayerLog.error("getCurrentTime illegal state");
            return 0;
        }
    }

    public void getScreenVisibleRect() {
        Context context = getContext();
        this.screenWHSize = YFScreenUtil.getScreenSize(context, false);
        float statusBarHeight = YFScreenUtil.getStatusBarHeight(context);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom;
        int navigationBarHeight = (int) YFScreenUtil.getNavigationBarHeight(context);
        int[] iArr = this.screenWHSize;
        int i2 = iArr[1] - navigationBarHeight;
        if (i2 >= i) {
            iArr[1] = i2;
        }
        YFPlayerLog.debug(this.TAG + " statueHeight:" + statusBarHeight + " naviHeight:" + navigationBarHeight + " height:" + this.screenWHSize[1] + " availableHeight:" + i);
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public View getView() {
        return this;
    }

    /* JADX INFO: renamed from: lambda$handleFatalError$1$com-yfanads-android-adx-newplayer-VideoPlayerImp, reason: not valid java name */
    /* synthetic */ void m1195x7d662e03() {
        if (this.isReleased || this.videoUri == null) {
            return;
        }
        init(getContext());
    }

    /* JADX INFO: renamed from: lambda$init$0$com-yfanads-android-adx-newplayer-VideoPlayerImp, reason: not valid java name */
    /* synthetic */ void m1196lambda$init$0$comyfanadsandroidadxnewplayerVideoPlayerImp() {
        IVideoPlayListener iVideoPlayListener = this.mn;
        if (iVideoPlayListener != null) {
            iVideoPlayListener.onVideoPlayStart();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        a.a(new StringBuilder(), this.TAG, " video completion ");
        this.mediaPlayerState = MediaPlayerState.STOPPED;
        this.isPlaying = false;
        this.viewStatus = ViewStatus.COMPLETED;
        IVideoPlayListener iVideoPlayListener = this.mn;
        if (iVideoPlayListener != null) {
            iVideoPlayListener.onVideoPlayComplete();
        }
        release();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.a(new StringBuilder(), this.TAG, " onDetachedFromWindow");
        try {
            removeVisibilityView();
            stopHandler();
            pausePlayback();
            if (getViewTreeObserver().isAlive()) {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                getViewTreeObserver().removeOnScrollChangedListener(this);
                getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            }
            removeOnAttachStateChangeListener(this);
        } catch (Exception e) {
            YFPlayerLog.error("onDetachedFromWindow error " + e.getMessage());
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        YFPlayerLog.error(this.TAG + " video render error " + i + ", extra: " + i2);
        this.mediaPlayerState = MediaPlayerState.ERROR;
        if (i == -38) {
            YFPlayerLog.error(this.TAG + " MEDIA_ERROR_ILLEGAL_STATE (-38) received");
            handleIllegalStateError();
            return true;
        }
        if (i == 100) {
            YFPlayerLog.error(this.TAG + " MEDIA_ERROR_SERVER_DIED received, recreating player...");
            handleFatalError();
            return true;
        }
        IVideoPlayListener iVideoPlayListener = this.mn;
        if (iVideoPlayListener == null) {
            return false;
        }
        iVideoPlayListener.onVideoPlayError(i, i2);
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.checkTag = "onGlobalLayout";
        checkVisibilityViewDelay();
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        a.a(new StringBuilder(), this.TAG, " video render start");
        IVideoPlayListener iVideoPlayListener = this.mn;
        if (iVideoPlayListener != null) {
            iVideoPlayListener.onAdShow();
        }
        startHandler();
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        a.a(new StringBuilder(), this.TAG, " video prepared");
        this.mediaPlayerState = MediaPlayerState.PREPARED;
        this.mIsPrepared = true;
        checkVisibilityViewDelay();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        this.checkTag = "onScrollChanged";
        checkVisibilityViewDelay();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        a.a(new StringBuilder(), this.TAG, " onViewAttachedToWindow");
        this.isReleased = false;
        this.isViewDetached = false;
        try {
            if (this.mediaPlayer == null) {
                this.mediaPlayer = new MediaPlayer();
                this.mediaPlayerState = MediaPlayerState.IDLE;
                this.mIsPrepared = false;
            }
            YFPlayerLog.debug(this.TAG + " add GS Listener");
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            getViewTreeObserver().addOnScrollChangedListener(this);
            getViewTreeObserver().addOnWindowFocusChangeListener(this);
        } catch (Exception e) {
            YFPlayerLog.error("onViewAttachedToWindow error " + e.getMessage());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a.a(new StringBuilder(), this.TAG, " onViewDetachedFromWindow and remove GS Listener");
        this.isViewDetached = true;
        try {
            pausePlayback();
            if (getViewTreeObserver().isAlive()) {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this);
            removeVisibilityView();
            setViewDetached();
            collectExposureData();
        } catch (Exception e) {
            YFPlayerLog.error("onViewDetachedFromWindow error " + e.getMessage());
        }
    }

    @Override // android.view.View, android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        YFPlayerLog.debug(this.TAG + " onWindowFocusChanged background:" + (!z));
        this.checkTag = "onWindowFocusChanged " + z;
        try {
            if (z) {
                checkVisibilityViewDelay();
            } else {
                removeVisibilityView();
                setViewDetached();
                collectExposureData();
            }
        } catch (Exception e) {
            YFPlayerLog.error("onWindowFocusChanged error " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void pause() {
        pausePlayback();
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void reStart() {
        startPlayback("reStart");
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void release() {
        releaseMediaPlayer("release");
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAttachedToWindow()) {
            checkVisibilityView(this.checkTag);
        } else {
            a.a(new StringBuilder(), this.TAG, "View not attached, skip visibility check");
        }
    }

    public void setParams(String str, boolean z, String str2, IVideoPlayListener iVideoPlayListener) {
        this.videoUri = str;
        this.mute = z;
        this.mn = iVideoPlayListener;
        StringBuilder sb = new StringBuilder("VideoPlayer|");
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        Object objValueOf = str2;
        if (zIsEmpty) {
            objValueOf = Integer.valueOf(hashCode());
        }
        this.TAG = sb.append(objValueOf).append("|").toString();
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void setVolume(boolean z) {
        if (this.mediaPlayer == null || !isStateValidFor("setVolume", MediaPlayerState.IDLE, MediaPlayerState.INITIALIZED, MediaPlayerState.PREPARING, MediaPlayerState.PREPARED, MediaPlayerState.STARTED, MediaPlayerState.PAUSED)) {
            return;
        }
        try {
            if (z) {
                this.mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mediaPlayer.setVolume(1.0f, 1.0f);
            }
        } catch (IllegalStateException e) {
            YFPlayerLog.error("setVolume illegal state: " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void start() {
        startPlayback("start");
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IPlayVideo
    public void stop() {
        release();
    }
}
