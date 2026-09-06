package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, DetailedCreativeType.SINGLE_IMG, 13})
public class tt extends sp {
    public com.byazt.ts.uj da;
    public float i;
    public final Runnable m;
    public com.byazt.fk.sp.c sl;
    public volatile boolean t;
    public c u;
    public float x;
    public LottieAnimationView yp;
    public final Handler z;

    /* JADX WARN: Code duplicated, block: B:17:0x0068  */
    public tt(com.byazt.ga.x xVar, x xVar2, final Context context) {
        JSONObject jSONObject;
        super(xVar, xVar2);
        this.x = -1.0f;
        this.i = -1.0f;
        this.z = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.byazt.zk.tt.4
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.yp != null) {
                    tt.this.yp.invalidate();
                }
                tt.this.z.postDelayed(tt.this.m, 40L);
            }
        };
        if (this.sp == null || xVar == null || context == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewTt = xVar.tt();
        this.yp = lottieAnimationViewTt;
        if (lottieAnimationViewTt == null) {
            return;
        }
        float fC = com.byazt.kk.da.c();
        this.x = (int) (this.sp.c() * fC);
        this.i = (int) (this.sp.tt() * fC);
        gt gtVarZm = xVar.zm();
        if (gtVarZm != null) {
            String strC = gtVarZm.c(this.sp.u());
            if (TextUtils.isEmpty(strC)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(strC);
                } catch (JSONException e) {
                    m.c(e);
                    jSONObject = null;
                }
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            final String strOptString = jSONObject.optString("file_hash");
            final String strOptString2 = jSONObject.optString("video_url");
            jSONObject.optString("video_duration");
            jSONObject.optString("resolution");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            c cVar = new c(context);
            this.u = cVar;
            cVar.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.byazt.zk.tt.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    tt.this.c(strOptString2, strOptString, context, surfaceTexture);
                    tt.this.rh();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    tt.this.z();
                    surfaceTexture.release();
                    tt.this.nu();
                    return true;
                }
            });
            this.yp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.zk.tt.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (tt.this.yp == view) {
                        if (tt.this.tt()) {
                            tt.this.yp.removeOnAttachStateChangeListener(this);
                        } else {
                            tt.this.c(new Runnable() { // from class: com.byazt.zk.tt.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    tt.this.m();
                                }
                            });
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (tt.this.yp == view) {
                        tt.this.c(new Runnable() { // from class: com.byazt.zk.tt.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent parent = tt.this.u.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(tt.this.u);
                                }
                            }
                        });
                    }
                }
            });
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        z();
        LottieAnimationView lottieAnimationView = this.yp;
        com.byazt.ts.uj ujVar = new com.byazt.ts.uj("uttie", lottieAnimationView != null ? lottieAnimationView.getVideoStats() : null);
        this.da = ujVar;
        ujVar.setSurface(surfaceTexture);
        com.byazt.fk.sp.c cVar = new com.byazt.fk.sp.c() { // from class: com.byazt.zk.tt.3
            @Override // com.byazt.fk.sp.c
            public void onBufferEnd(com.byazt.fk.sp spVar, int i) {
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferStart(com.byazt.fk.sp spVar, int i, int i2, int i3) {
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferingUpdate(com.byazt.fk.sp spVar, int i) {
            }

            @Override // com.byazt.fk.sp.c
            public void onCompletion(com.byazt.fk.sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onMonitorLog(com.byazt.fk.sp spVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPause(com.byazt.fk.sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPlayPositionUpdate(com.byazt.fk.sp spVar, long j, long j2) {
            }

            @Override // com.byazt.fk.sp.c
            public void onRelease(com.byazt.fk.sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onRenderStart(com.byazt.fk.sp spVar, long j) {
            }

            @Override // com.byazt.fk.sp.c
            public void onResume(com.byazt.fk.sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onSeekCompletion(com.byazt.fk.sp spVar, boolean z) {
            }

            @Override // com.byazt.fk.sp.c
            public void onStart(com.byazt.fk.sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onVideoSizeChanged(com.byazt.fk.sp spVar, int i, int i2) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPrepared(com.byazt.fk.sp spVar) {
                tt.this.t = true;
                spVar.setLoop(true);
            }

            @Override // com.byazt.fk.sp.c
            public void onError(com.byazt.fk.sp spVar, com.byazt.fk.ve veVar) {
                m.uj("uttie-video", veVar.getCode() + com.huawei.openalliance.ad.constant.x.bQ + veVar.getExtraCode() + com.huawei.openalliance.ad.constant.x.bQ + veVar.getMsg());
            }
        };
        this.sl = cVar;
        this.da.addIVideoPlayerCallback(cVar);
        com.byazt.jzl.uj ujVar2 = new com.byazt.jzl.uj();
        ujVar2.setVideo_url(str);
        ujVar2.setFileHash(str2);
        this.da.setDataSource(new com.byazt.jzl.a(com.byazt.kk.ve.tt(context), ujVar2, null, 0, 0));
        this.da.setQuietPlay(true);
        this.da.start(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.da != null) {
            if (this.t) {
                this.da.stop();
            }
            this.da.release();
            this.da = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ViewParent parent = this.u.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.u);
        }
        ViewParent parent2 = this.yp.getParent();
        if (parent2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent2;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof c) {
                    viewGroup.removeView(childAt);
                    i--;
                }
                i++;
            }
            this.u.setTranslationX(2.14748365E9f);
            viewGroup.addView(this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        this.z.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        nu();
        if (this.yp != null) {
            this.z.postDelayed(this.m, 40L);
        }
    }

    @Override // com.byazt.zk.sp, com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        if (this.x <= 0.0f || this.u == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        c(i);
        float fX = x();
        c(this.u, (int) this.x, (int) this.i);
        this.u.setAlpha(fX);
        this.u.draw(canvas);
        canvas.restore();
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @com.byazt.zqa.c(c = {0, 1, DetailedCreativeType.SINGLE_IMG, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c extends TextureView {
        public c(Context context) {
            super(context);
        }
    }
}
