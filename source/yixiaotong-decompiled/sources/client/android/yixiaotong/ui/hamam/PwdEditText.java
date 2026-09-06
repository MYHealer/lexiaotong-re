package client.android.yixiaotong.ui.hamam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PwdEditText extends AppCompatEditText {
    private final int PWD_LENGTH;
    private final int PWD_SIZE;
    private final int PWD_SPACING;
    private Context mContext;
    private int mHeight;
    private int mInputLength;
    private boolean mPswInsviable;
    private Paint mPwdPaint;
    private RectF mRect;
    private Paint mRectPaint;
    private List<String> mText;
    private int mWidth;

    public PwdEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PWD_SPACING = 10;
        this.PWD_SIZE = 12;
        this.PWD_LENGTH = 10;
        this.mPswInsviable = false;
        this.mText = new ArrayList();
        Paint paint = new Paint();
        this.mPwdPaint = paint;
        paint.setColor(-16777216);
        this.mPwdPaint.setStyle(Paint.Style.FILL);
        this.mPwdPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mRectPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setColor(getResources().getColor(R.color.hamam_psw1));
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStrokeWidth(4.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        int i = (this.mWidth - 110) / 10;
        int i2 = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            if (i3 > 3) {
                this.mRectPaint.setColor(getResources().getColor(R.color.hamam_psw2));
            } else {
                this.mRectPaint.setColor(getResources().getColor(R.color.hamam_psw1));
            }
            int i4 = ((i + 10) * i3) + 10;
            RectF rectF = new RectF(i4, 2, i4 + i, this.mHeight - 2);
            this.mRect = rectF;
            canvas.drawRoundRect(rectF, 8.0f, 8.0f, this.mRectPaint);
        }
        if (!this.mPswInsviable) {
            while (i2 < this.mInputLength) {
                canvas.drawCircle((i / 2) + ((i + 10) * i2) + 10, this.mHeight / 2, 12.0f, this.mPwdPaint);
                i2++;
            }
            return;
        }
        while (i2 < this.mInputLength) {
            float f = getResources().getDisplayMetrics().density;
            int i5 = (this.mHeight * 2) / 3;
            this.mPwdPaint.setTextSize(45.0f);
            this.mPwdPaint.setFakeBoldText(true);
            Paint.FontMetrics fontMetrics = this.mPwdPaint.getFontMetrics();
            float fCenterY = (this.mRect.centerY() - ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.top;
            this.mPwdPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mText.get(i2), (i / 2) + ((i + 10) * i2) + 10, fCenterY, this.mPwdPaint);
            i2++;
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.mInputLength = charSequence.toString().length();
        invalidate();
    }

    public void setmPswInsviable(boolean z, String str) {
        if (StringUtils.isNotEmpty(str)) {
            this.mText.clear();
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 1;
                this.mText.add(str.substring(i, i2));
                i = i2;
            }
            this.mPswInsviable = z;
        }
    }
}
