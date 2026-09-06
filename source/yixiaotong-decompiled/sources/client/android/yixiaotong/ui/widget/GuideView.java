package client.android.yixiaotong.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import client.android.yixiaotong.R;
import com.huawei.openalliance.ad.constant.br;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String SHOW_GUIDE_PREFIX = "show_guide";
    private final String TAG;
    private int backgroundColor;
    private Bitmap bitmap;
    private int[] center;
    private View customGuideView;
    private Direction direction;
    private boolean first;
    private boolean isContain;
    private boolean isMeasured;
    private int[] location;
    private Paint mBackgroundPaint;
    private Paint mCirclePaint;
    private Context mContent;
    private MyShape myShape;
    private boolean needDraw;
    private int offsetX;
    private int offsetY;
    private boolean onClickExit;
    private OnClickCallback onclickListener;
    private PorterDuffXfermode porterDuffXfermode;
    private int radius;
    private View targetView;
    private int targetViewHeight;
    private int targetViewWidth;
    private Canvas temp;
    private View textGuideView;

    public enum Direction {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public enum MyShape {
        CIRCULAR,
        RECTANGULAR
    }

    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public int[] getCenter() {
        return this.center;
    }

    public int[] getLocation() {
        return this.location;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setBgColor(int i) {
        this.backgroundColor = i;
    }

    public void setCenter(int[] iArr) {
        this.center = iArr;
    }

    public void setContain(boolean z) {
        this.isContain = z;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setLocation(int[] iArr) {
        this.location = iArr;
    }

    public void setOffsetX(int i) {
        this.offsetX = i;
    }

    public void setOffsetY(int i) {
        this.offsetY = i;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.onclickListener = onClickCallback;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public void setShape(MyShape myShape) {
        this.myShape = myShape;
    }

    public void setTargetView(View view) {
        this.targetView = view;
    }

    public GuideView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
        this.first = true;
        this.isContain = false;
        this.needDraw = true;
        this.mContent = context;
    }

    public void setCustomGuideView(View view) {
        this.customGuideView = view;
        if (this.first) {
            return;
        }
        restoreState();
    }

    public void setTextGuideView(View view) {
        this.textGuideView = view;
        if (this.first) {
            return;
        }
        restoreState();
    }

    private boolean hasShown() {
        if (this.targetView == null) {
            return true;
        }
        return this.mContent.getSharedPreferences(this.TAG, 0).getBoolean(generateUniqId(this.targetView), false);
    }

    private String generateUniqId(View view) {
        return SHOW_GUIDE_PREFIX + view.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickInfo() {
        final boolean z = this.onClickExit;
        setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.widget.GuideView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuideView.this.onclickListener != null) {
                    GuideView.this.onclickListener.onClickedGuideView();
                }
                if (z) {
                    GuideView.this.hide();
                }
            }
        });
    }

    public void show() {
        Log.v(this.TAG, br.b.V);
        if (hasShown()) {
            return;
        }
        View view = this.targetView;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        setBackgroundResource(R.color.transparent);
        bringToFront();
        ((FrameLayout) ((Activity) this.mContent).getWindow().getDecorView()).addView(this);
        this.first = false;
    }

    public void hide() {
        Log.v(this.TAG, "hide");
        if (this.customGuideView == null && this.textGuideView == null) {
            return;
        }
        this.targetView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        removeAllViews();
        ((FrameLayout) ((Activity) this.mContent).getWindow().getDecorView()).removeView(this);
        restoreState();
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.isMeasured) {
            iArr[0] = this.targetView.getWidth();
            iArr[1] = this.targetView.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.isMeasured) {
            return -1;
        }
        int[] targetViewSize = getTargetViewSize();
        int i = targetViewSize[0];
        int i2 = targetViewSize[1];
        return (int) (Math.sqrt((i * i) + (i2 * i2)) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v(this.TAG, "onDraw");
        if (this.isMeasured && this.targetView != null) {
            drawBackground(canvas);
        }
    }

    private void drawBackground(Canvas canvas) {
        Log.v(this.TAG, "drawBackground");
        this.needDraw = false;
        this.bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.temp = new Canvas(this.bitmap);
        Paint paint = new Paint();
        int i = this.backgroundColor;
        if (i != 0) {
            paint.setColor(i);
        } else {
            paint.setColor(getResources().getColor(R.color.bg_shadow));
        }
        Canvas canvas2 = this.temp;
        canvas2.drawRect(0.0f, 0.0f, canvas2.getWidth(), this.temp.getHeight(), paint);
        if (this.mCirclePaint == null) {
            this.mCirclePaint = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.porterDuffXfermode = porterDuffXfermode;
        this.mCirclePaint.setXfermode(porterDuffXfermode);
        this.mCirclePaint.setAntiAlias(true);
        if (this.myShape != null) {
            RectF rectF = new RectF();
            int iOrdinal = this.myShape.ordinal();
            if (iOrdinal == 0) {
                Canvas canvas3 = this.temp;
                int[] iArr = this.center;
                canvas3.drawCircle(iArr[0], iArr[1], this.radius, this.mCirclePaint);
            } else if (iOrdinal == 1) {
                if (this.isContain) {
                    rectF.left = this.location[0] - 8;
                    rectF.top = (this.center[1] - (this.targetViewHeight / 2)) - 8;
                    rectF.right = this.location[0] + this.targetViewWidth + 8;
                    rectF.bottom = this.center[1] + (this.targetViewHeight / 2) + 8;
                } else {
                    rectF.left = this.location[0] + 5;
                    rectF.top = (this.center[1] - (this.targetViewHeight / 2)) + 1;
                    rectF.right = (this.location[0] + this.targetViewWidth) - 5;
                    rectF.bottom = (this.center[1] + (this.targetViewHeight / 2)) - 1;
                }
                Canvas canvas4 = this.temp;
                int i2 = this.radius;
                canvas4.drawRoundRect(rectF, i2, i2, this.mCirclePaint);
            }
        } else {
            Canvas canvas5 = this.temp;
            int[] iArr2 = this.center;
            canvas5.drawCircle(iArr2[0], iArr2[1], this.radius, this.mCirclePaint);
        }
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, paint);
        this.bitmap.recycle();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.isMeasured) {
            return;
        }
        if (this.targetView.getHeight() > 0 && this.targetView.getWidth() > 0) {
            this.isMeasured = true;
            this.targetViewWidth = this.targetView.getWidth();
            this.targetViewHeight = this.targetView.getHeight();
        }
        if (this.center == null) {
            int[] iArr = new int[2];
            this.location = iArr;
            this.targetView.getLocationInWindow(iArr);
            this.center = new int[]{this.location[0] + (this.targetView.getWidth() / 2), 0};
            this.center[1] = this.location[1] + (this.targetView.getHeight() / 2);
        }
        if (this.radius == 0) {
            this.radius = getTargetViewRadius();
        }
        createView();
    }

    private void createView() {
        Log.v(this.TAG, "createView");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.center[1] + this.radius + 10, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.center[1] + this.radius + 10, 0, 0);
        if (this.textGuideView == null || this.customGuideView == null || this.direction == null) {
            return;
        }
        int[] iArr = this.center;
        int i = iArr[0];
        int i2 = this.targetViewWidth;
        int i3 = i + (i2 / 2);
        int i4 = i2 / 2;
        int i5 = iArr[1];
        int i6 = this.targetViewHeight;
        int i7 = i5 - (i6 / 2);
        int i8 = i5 + (i6 / 2);
        Log.e(this.TAG, this.direction + "  " + this.offsetX + "  " + i7 + "  " + this.offsetY + "  " + i8 + "  " + i3 + "  " + this.center[0] + "  " + this.center[1] + "  " + this.targetViewWidth + "  " + this.targetViewHeight);
        if (this.direction.ordinal() == 5) {
            setGravity(3);
            int i9 = this.offsetX;
            int i10 = this.offsetY;
            int i11 = -i8;
            layoutParams.setMargins(i9, i8 + i10, -i9, i11 - i10);
            int i12 = this.offsetX;
            int i13 = this.offsetY;
            layoutParams2.setMargins(i12, i8 + (i13 * 3), -i12, i11 - (i13 * 3));
        }
        removeAllViews();
        addView(this.textGuideView, layoutParams);
        addView(this.customGuideView, layoutParams2);
    }

    public static class Builder {
        static GuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new GuideView(context);
            return instance;
        }

        public Builder setTargetView(View view) {
            guiderView.setTargetView(view);
            return instance;
        }

        public Builder setBgColor(int i) {
            guiderView.setBgColor(i);
            return instance;
        }

        public Builder setDirction(Direction direction) {
            guiderView.setDirection(direction);
            return instance;
        }

        public Builder setShape(MyShape myShape) {
            guiderView.setShape(myShape);
            return instance;
        }

        public Builder setRadius(int i) {
            guiderView.setRadius(i);
            return instance;
        }

        public Builder setTextGuideView(View view) {
            guiderView.setTextGuideView(view);
            return instance;
        }

        public Builder setCustomGuideView(View view) {
            guiderView.setCustomGuideView(view);
            return instance;
        }

        public Builder setOffset(int i, int i2) {
            guiderView.setOffsetX(i);
            guiderView.setOffsetY(i2);
            return instance;
        }

        public Builder setContain(boolean z) {
            guiderView.setContain(z);
            return instance;
        }

        public Builder setOnclickListener(OnClickCallback onClickCallback) {
            guiderView.setOnclickListener(onClickCallback);
            return instance;
        }

        public GuideView build() {
            guiderView.setClickInfo();
            return guiderView;
        }
    }

    public void restoreState() {
        Log.v(this.TAG, "restoreState");
        this.offsetY = 0;
        this.offsetX = 0;
        this.radius = 0;
        this.mCirclePaint = null;
        this.mBackgroundPaint = null;
        this.isMeasured = false;
        this.center = null;
        this.porterDuffXfermode = null;
        this.bitmap = null;
        this.needDraw = true;
        this.temp = null;
    }
}
