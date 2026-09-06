package com.hihonor.hianalytics.hnha;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.ExoPlayer;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f3634a;
    private final String b;
    private z c;
    private long d = 0;
    private s3 e = null;

    public interface a {
        z a();
    }

    public e0(a aVar) {
        this.f3634a = aVar;
        this.c = aVar.a();
        this.b = this.c.a() + "-AutoClose";
    }

    private void a() {
        s3 s3Var = this.e;
        if (s3Var != null) {
            t3.a(s3Var);
            this.e = null;
            this.d = 0L;
        }
    }

    private synchronized void a(long j) {
        if (j != this.d) {
            j2.g(this.b, "handleAutoCloseTask changeTaskId=" + j + ",nowId=" + this.d);
            return;
        }
        long jA = com.hihonor.hianalytics.util.r.a(true) - j;
        final z zVar = this.c;
        try {
            zVar.close();
            j2.c(this.b, "handleAutoCloseTask taskId=" + j + ",interval=" + jA + " close success");
        } catch (Throwable th) {
            this.c = this.f3634a.a();
            j2.c(this.b, "handleAutoCloseTask taskId=" + j + ",interval=" + jA + " close failE=" + SystemUtils.getDesensitizedException(th));
            Objects.requireNonNull(zVar);
            t3.a(new s3(new Runnable() { // from class: com.hihonor.hianalytics.hnha.e0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    zVar.close();
                }
            }), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(this.d);
    }

    public synchronized SQLiteDatabase a(boolean z) {
        a();
        return z ? this.c.getWritableDatabase() : this.c.getReadableDatabase();
    }

    public synchronized void b() {
        a();
        long jI = g.i();
        if (jI > 0) {
            this.d = com.hihonor.hianalytics.util.r.a(true);
            s3 s3Var = new s3(new Runnable() { // from class: com.hihonor.hianalytics.hnha.e0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            this.e = s3Var;
            t3.a(s3Var, jI);
        }
    }
}
