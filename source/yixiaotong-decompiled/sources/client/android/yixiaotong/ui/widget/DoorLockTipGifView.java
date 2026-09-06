package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockTipGifView extends View {
    private Movie movie;
    private long movieStart;

    public DoorLockTipGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.movieStart == 0) {
            this.movieStart = jUptimeMillis;
        }
        Movie movie = this.movie;
        if (movie != null) {
            this.movie.setTime((int) ((jUptimeMillis - this.movieStart) % ((long) movie.duration())));
            this.movie.draw(canvas, 0.0f, 0.0f);
            invalidate();
        }
        super.onDraw(canvas);
    }
}
