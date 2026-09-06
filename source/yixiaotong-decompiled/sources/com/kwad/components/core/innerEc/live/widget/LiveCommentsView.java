package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class LiveCommentsView extends e {
    private float MQ;
    private Paint ZF;
    private Matrix ZG;
    private Shader ZH;
    private int ZI;
    private int ZJ;
    private boolean ZK;
    private boolean ZL;
    private int mTouchSlop;

    private static boolean td() {
        return true;
    }

    public int getCustomFadingEdgeTop() {
        return this.ZI;
    }

    public void setCustomFadingEdgeLength(int i) {
        this.ZJ = i;
    }

    static /* synthetic */ boolean a(LiveCommentsView liveCommentsView, boolean z) {
        liveCommentsView.ZK = false;
        return false;
    }

    public LiveCommentsView(Context context) {
        this(context, null);
    }

    public LiveCommentsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveCommentsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MQ = 0.0f;
        this.ZK = false;
        this.ZL = false;
        init();
    }

    private void init() {
        this.ZF = new Paint();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -16777216, 0, Shader.TileMode.CLAMP);
        this.ZH = linearGradient;
        this.ZF.setShader(linearGradient);
        this.ZF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ZG = new Matrix();
        this.ZJ = com.kwad.sdk.c.a.a.a(getContext(), 30.0f);
        tc();
        this.ZL = true;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        tb();
    }

    private void tb() {
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kwad.components.core.innerEc.live.widget.LiveCommentsView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if ((layoutManager instanceof LinearLayoutManager) && LiveCommentsView.this.getAdapter() != null && ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == LiveCommentsView.this.getAdapter().getItemCount() - 1) {
                    LiveCommentsView.a(LiveCommentsView.this, false);
                }
            }
        });
    }

    private void tc() {
        if (td()) {
            setLayerType(2, null);
        }
    }

    public void setCustomFadingEdgeTop(int i) {
        if (this.ZI == i || this.ZJ <= 0) {
            return;
        }
        this.ZI = i;
        postInvalidate();
    }

    private void c(Canvas canvas) {
        int i = this.ZI;
        int width = getWidth();
        int i2 = this.ZJ;
        this.ZG.setScale(1.0f, i2);
        this.ZG.postTranslate(0.0f, i);
        this.ZH.setLocalMatrix(this.ZG);
        this.ZF.setShader(this.ZH);
        canvas.drawRect(0.0f, 0.0f, width, i + i2, this.ZF);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (!this.ZL) {
            return bj(i);
        }
        if (this.ZK) {
            return bj(i);
        }
        if (i < 0) {
            return bj(i);
        }
        return false;
    }

    private boolean bj(int i) {
        return super.canScrollVertically(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ZJ <= 0 || !td()) {
            return;
        }
        c(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.ZL) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.MQ = motionEvent.getY();
        } else if (action == 2 && motionEvent.getY() - this.MQ >= this.mTouchSlop) {
            this.ZK = true;
        }
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.ZK) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return zOnTouchEvent;
    }
}
