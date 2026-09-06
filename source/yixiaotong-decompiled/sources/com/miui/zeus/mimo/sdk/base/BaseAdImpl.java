package com.miui.zeus.mimo.sdk.base;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.g9;
import com.miui.zeus.mimo.sdk.p4;
import com.miui.zeus.mimo.sdk.p5;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.y4;
import ijiami_1011.NCall;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class BaseAdImpl implements Application.ActivityLifecycleCallbacks {
    public static final String l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MimoAdInfo f5377a;
    public List<MimoAdInfo> b;
    public String c;
    public boolean d;
    public r3 e;
    public final y4 f = new y4();
    public ADParams g;
    public long h;
    public String i;
    public Bitmap j;
    public p5 k;

    public class a implements p4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f5378a;

        public a(long j) {
            this.f5378a = j;
        }

        public void a(a7 a7Var) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN), this, a7Var});
        }

        public void a(List<MimoAdInfo> list) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE), this, list});
        }
    }

    public class b extends g9 {
        public b() {
        }

        @Override // com.miui.zeus.mimo.sdk.g9
        public void a() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE), this});
        }
    }

    public class c extends g9 {
        public final /* synthetic */ a7 c;

        public c(a7 a7Var) {
            this.c = a7Var;
        }

        @Override // com.miui.zeus.mimo.sdk.g9
        public void a() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD), this});
        }
    }

    static {
        NCall.IV(new Object[]{510});
    }

    public BaseAdImpl() {
        this.k = null;
        this.k = new p5();
    }

    public void a() {
        NCall.IV(new Object[]{511, this});
    }

    public void a(long j) {
        NCall.IV(new Object[]{512, this, Long.valueOf(j)});
    }

    public void a(Activity activity) {
        NCall.IV(new Object[]{513, this, activity});
    }

    public void a(ADParams aDParams, int i) {
        NCall.IV(new Object[]{514, this, aDParams, Integer.valueOf(i)});
    }

    public final void a(a7 a7Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT), this, a7Var});
    }

    public abstract void a(MimoAdInfo mimoAdInfo);

    public void a(Map<String, Object> map) {
        NCall.IV(new Object[]{516, this, map});
    }

    public void a(boolean z) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE), this, Boolean.valueOf(z)});
    }

    public int b(MimoAdInfo mimoAdInfo) {
        return NCall.II(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS), this, mimoAdInfo});
    }

    public void b() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX), this});
    }

    public abstract void b(a7 a7Var);

    public boolean c() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX), this});
    }

    public boolean d() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS), this});
    }

    public void e() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE), this});
    }

    public abstract void f();

    public void g() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE), this});
    }

    public void h() {
        NCall.IV(new Object[]{524, this});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        NCall.IV(new Object[]{525, this, activity, bundle});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        NCall.IV(new Object[]{526, this, activity});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        NCall.IV(new Object[]{527, this, activity});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        NCall.IV(new Object[]{528, this, activity});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        NCall.IV(new Object[]{529, this, activity, bundle});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE), this, activity});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE), this, activity});
    }
}
