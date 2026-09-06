package com.opos.mobad.j.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.br;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.d.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7054a;
    private List<com.opos.mobad.d.d.b> b;
    private MediaPlayer c;
    private RelativeLayout d;
    private View e;
    private com.opos.libs.a.a f;
    private com.opos.exoplayer.a.a g;
    private float h;
    private SurfaceView i;
    private TextureView j;
    private Surface k;
    private ImageView l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Handler r;

    public b(Context context, com.opos.mobad.d.d.b bVar) {
        this(context, bVar, true);
    }

    public b(Context context, com.opos.mobad.d.d.b bVar, boolean z) {
        this.b = new ArrayList();
        this.h = 1.0f;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.j.c.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                int i2 = 0;
                if (i == 1) {
                    b.this.m = true;
                    b.this.f.a(1);
                    while (i2 < b.this.b.size()) {
                        ((com.opos.mobad.d.d.b) b.this.b.get(i2)).c();
                        i2++;
                    }
                } else if (i != 2) {
                    if (i == 3) {
                        while (i2 < b.this.b.size()) {
                            ((com.opos.mobad.d.d.b) b.this.b.get(i2)).h();
                            i2++;
                        }
                        return;
                    } else if (i == 4) {
                        while (i2 < b.this.b.size()) {
                            ((com.opos.mobad.d.d.b) b.this.b.get(i2)).i();
                            i2++;
                        }
                        return;
                    } else {
                        if (i != 5) {
                            return;
                        }
                        while (i2 < b.this.b.size()) {
                            ((com.opos.mobad.d.d.b) b.this.b.get(i2)).j();
                            i2++;
                        }
                        return;
                    }
                }
                b.this.q();
            }
        };
        this.f7054a = context;
        b(bVar);
        this.n = z;
        a();
        this.f = new com.opos.libs.a.a.C0933a(0).a(0, 7, 6).a(7, 1, 3, 2, 0, 6).a(1, 3, 2, 5, 0, 6).a(2, 3, 5, 0, 6).a(3, 2, 0, 6).a(5, 2, 0, 6).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(int i, String str) {
        HashMap map = new HashMap();
        map.put(br.f.m, String.valueOf(i));
        map.put(FileDownloadModel.ERR_MSG, str);
        map.put("playerType", "1");
        return map;
    }

    private void a() {
        this.d = new RelativeLayout(this.f7054a);
        View view = new View(this.f7054a);
        this.e = view;
        view.setBackgroundColor(-16777216);
        this.d.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        this.g = new com.opos.exoplayer.a.a(this.f7054a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.d.addView(this.g, layoutParams);
        this.g.setId(View.generateViewId());
        this.l = new ImageView(this.f7054a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, this.g.getId());
        layoutParams2.addRule(8, this.g.getId());
        layoutParams2.addRule(7, this.g.getId());
        layoutParams2.addRule(5, this.g.getId());
        this.d.addView(this.l, layoutParams2);
        this.l.setVisibility(8);
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f7054a);
        this.d.addView(aVar, new ViewGroup.LayoutParams(0, 0));
        aVar.a(new com.opos.mobad.d.e.a.b() { // from class: com.opos.mobad.j.c.b.11
            @Override // com.opos.mobad.d.e.a.b
            public void a() {
            }

            @Override // com.opos.mobad.d.e.a.b
            public void b() {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "view attach to window");
                if (b.this.f.a() == 6 || b.this.d.isHardwareAccelerated()) {
                    return;
                }
                b.this.k();
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.g.a(i / i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface) {
        if (this.f.a() == 6) {
            return;
        }
        this.k = surface;
        this.r.obtainMessage(2).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) throws Exception {
        this.m = false;
        MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        } else {
            this.c = new MediaPlayer();
        }
        this.c.setDataSource(this.f7054a, Uri.parse(str), (Map<String, String>) null);
        this.c.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.opos.mobad.j.c.b.6
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                b.this.a(i, i2);
            }
        });
        this.c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.opos.mobad.j.c.b.7
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                b.this.f.a(5);
                b.this.m();
                for (int i = 0; i < b.this.b.size(); i++) {
                    ((com.opos.mobad.d.d.b) b.this.b.get(i)).e();
                }
            }
        });
        this.c.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.opos.mobad.j.c.b.8
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play fail:" + i + "," + i2 + ",state:" + b.this.f.a());
                if (-38 == i) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "ignore error");
                    return true;
                }
                if (b.this.f.a() != 0 && 6 != b.this.f.a()) {
                    b.this.f.a(0);
                    for (int i3 = 0; i3 < b.this.b.size(); i3++) {
                        ((com.opos.mobad.d.d.b) b.this.b.get(i3)).a(b.this.a(2, "code:" + i + ",extra:" + i2));
                    }
                }
                return true;
            }
        });
        this.c.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.opos.mobad.j.c.b.9
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                Handler handler;
                int i3;
                Message messageObtainMessage;
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play info:" + i + "," + i2);
                if (i != 3) {
                    if (i == 701) {
                        messageObtainMessage = b.this.r.obtainMessage(3);
                    } else {
                        if (i != 702) {
                            return false;
                        }
                        handler = b.this.r;
                        i3 = 4;
                    }
                    messageObtainMessage.sendToTarget();
                    return false;
                }
                handler = b.this.r;
                i3 = 5;
                messageObtainMessage = handler.obtainMessage(i3);
                messageObtainMessage.sendToTarget();
                return false;
            }
        });
        this.c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.opos.mobad.j.c.b.10
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "player prepared duration:" + mediaPlayer2.getDuration() + "," + b.this.k);
                b.this.a(mediaPlayer2.getVideoWidth(), mediaPlayer2.getVideoHeight());
                b.this.r.obtainMessage(1).sendToTarget();
            }
        });
        MediaPlayer mediaPlayer2 = this.c;
        float f = this.h;
        mediaPlayer2.setVolume(f, f);
        if (this.o) {
            this.c.setLooping(true);
        }
        this.c.prepareAsync();
    }

    private void j() {
        TextureView textureView = new TextureView(this.f7054a);
        this.j = textureView;
        this.g.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        this.j.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.opos.mobad.j.c.b.12
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureAvailable");
                b.this.a(new Surface(surfaceTexture));
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureDestroyed");
                b.this.o();
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "reset surface");
        this.g.removeAllViews();
        if (this.k != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            this.k.release();
        }
        n();
        SurfaceView surfaceView = new SurfaceView(this.f7054a);
        this.i = surfaceView;
        this.g.addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        this.i.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.opos.mobad.j.c.b.13
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceCreated");
                b.this.a(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceDestroyed");
                b.this.o();
            }
        });
    }

    private void l() {
        this.l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l.setVisibility(0);
        this.l.setImageBitmap(null);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover");
            TextureView textureView = this.j;
            if (textureView != null) {
                this.l.setImageBitmap(textureView.getBitmap());
            } else if (this.i != null) {
                final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.i.getWidth(), this.i.getHeight(), Bitmap.Config.ARGB_8888);
                PixelCopy.request(this.i, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.j.c.b.16
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public void onPixelCopyFinished(int i) {
                        b.this.l.setImageBitmap(bitmapCreateBitmap);
                    }
                }, this.i.getHandler());
            }
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover end:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            TextureView textureView = this.j;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
                this.j = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("MiniVideoPlayer", "releaseTextureView", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Surface surface = this.k;
        if (surface != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            surface.release();
        }
        this.k = null;
    }

    private void p() {
        this.f.a(0, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                if (b.this.c != null) {
                    b.this.c.reset();
                    b.this.c = null;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!this.q) {
            com.opos.cmn.an.f.a.a("MiniVideoPlayer", "do not need to auto start");
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start :" + this.f.a());
        if (this.f.a() == 2) {
            if (r()) {
                this.r.post(new Runnable() { // from class: com.opos.mobad.j.c.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.p = true;
                        for (int i = 0; i < b.this.b.size(); i++) {
                            ((com.opos.mobad.d.d.b) b.this.b.get(i)).d();
                        }
                    }
                });
            }
        } else if (this.f.a() == 1 && this.n) {
            this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() throws Exception {
                    boolean z;
                    if (b.this.r()) {
                        b.this.r.post(new Runnable() { // from class: com.opos.mobad.j.c.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.p = true;
                                for (int i = 0; i < b.this.b.size(); i++) {
                                    ((com.opos.mobad.d.d.b) b.this.b.get(i)).d();
                                }
                            }
                        });
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (this.k == null || !this.m) {
            return false;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "check to start");
        this.c.setSurface(this.k);
        this.c.start();
        this.e.setVisibility(8);
        l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.k == null || !this.m) {
            return;
        }
        this.c.pause();
    }

    @Override // com.opos.mobad.d.d.a
    public void a(float f) {
        this.h = f;
        MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "seekTo");
        int iA = this.f.a();
        if (2 == iA || 4 == iA || 3 == iA || 5 == iA) {
            this.c.seekTo((int) j);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(com.opos.mobad.d.d.b bVar) {
        b(bVar);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str) {
        a(str, false);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(final String str, boolean z) {
        this.o = z;
        p();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start video path:" + str);
        this.f.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                try {
                    b.this.c(str);
                    return true;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "init fail", e);
                    for (int i = 0; i < b.this.b.size(); i++) {
                        ((com.opos.mobad.d.d.b) b.this.b.get(i)).a(b.this.a(-1, ""));
                    }
                    return false;
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public Bitmap b(String str) {
        Object obj = this.j;
        if (obj == null) {
            obj = this.i;
        }
        return com.opos.mobad.j.a.b.a(obj, str);
    }

    @Override // com.opos.mobad.d.d.a
    public View b() {
        return this.d;
    }

    public void b(com.opos.mobad.d.d.b bVar) {
        if (bVar != null) {
            this.b.add(bVar);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public long c() {
        MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.opos.mobad.d.d.a
    public void c(int i) {
        this.g.a(i);
    }

    @Override // com.opos.mobad.d.d.a
    public long d() {
        if (this.c != null) {
            return this.f.a() == 5 ? this.c.getDuration() : this.c.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.opos.mobad.d.d.a
    public void d(int i) {
        this.e.setBackgroundColor(i);
    }

    @Override // com.opos.mobad.d.d.a
    public void e() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start");
        this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.14
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                b.this.r();
                return true;
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public void f() {
        this.f.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.15
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                b.this.s();
                b.this.m();
                b.this.r.post(new Runnable() { // from class: com.opos.mobad.j.c.b.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i = 0; i < b.this.b.size(); i++) {
                            ((com.opos.mobad.d.d.b) b.this.b.get(i)).g();
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public void g() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", ba.ag);
        this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.17
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                b.this.r();
                b.this.r.post(new Runnable() { // from class: com.opos.mobad.j.c.b.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i = 0; i < b.this.b.size(); i++) {
                            if (!b.this.p) {
                                b.this.p = true;
                                ((com.opos.mobad.d.d.b) b.this.b.get(i)).d();
                            }
                            ((com.opos.mobad.d.d.b) b.this.b.get(i)).f();
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public void h() {
        this.f.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.j.c.b.18
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                if (b.this.c != null) {
                    b.this.c.release();
                    b.this.c = null;
                }
                b.this.n();
                b.this.o();
                return true;
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public int i() {
        return this.f.a();
    }
}
