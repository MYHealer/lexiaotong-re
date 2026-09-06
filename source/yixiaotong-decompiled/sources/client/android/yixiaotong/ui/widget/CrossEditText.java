package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CrossEditText extends EditText implements View.OnFocusChangeListener {
    private Drawable dLeft;
    private Drawable dRight;
    private boolean mIsPasEditText;
    private Rect rBounds;
    private TextWatcher watcher;

    public void setPasword(boolean z) {
        this.mIsPasEditText = z;
    }

    public CrossEditText(Context context) {
        super(context);
        this.watcher = new TextWatcher() { // from class: client.android.yixiaotong.ui.widget.CrossEditText.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CrossEditText.this.handleClearButton();
            }
        };
        this.mIsPasEditText = false;
        init();
    }

    public CrossEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.watcher = new TextWatcher() { // from class: client.android.yixiaotong.ui.widget.CrossEditText.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CrossEditText.this.handleClearButton();
            }
        };
        this.mIsPasEditText = false;
        init();
    }

    public CrossEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.watcher = new TextWatcher() { // from class: client.android.yixiaotong.ui.widget.CrossEditText.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CrossEditText.this.handleClearButton();
            }
        };
        this.mIsPasEditText = false;
        init();
    }

    private void init() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        addTextChangedListener(this.watcher);
        setOnFocusChangeListener(this);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() == 1 && (drawable = this.dRight) != null) {
            this.rBounds = drawable.getBounds();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x >= (getWidth() - (this.rBounds.width() * 2)) - (this.rBounds.width() / 2) && x <= getWidth() && y >= getPaddingTop() && y <= getHeight() - getPaddingBottom()) {
                setText("");
                handleClearButton();
                motionEvent.setAction(3);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable3 != null) {
            int iApplyDimension = (int) TypedValue.applyDimension(1, 22.0f, getResources().getDisplayMetrics());
            drawable3.setBounds(0, 0, iApplyDimension, iApplyDimension);
            this.dRight = drawable3;
        }
        if (drawable != null) {
            this.dLeft = drawable;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    protected void finalize() throws Throwable {
        this.dRight = null;
        this.rBounds = null;
        super.finalize();
    }

    public void handleClearButton() {
        if (getText().toString().trim().length() > 0) {
            if (!this.mIsPasEditText) {
                this.dRight = getResources().getDrawable(R.drawable.selector_delete_word_button);
            }
            setCompoundDrawables(null, getCompoundDrawables()[1], this.dRight, getCompoundDrawables()[3]);
        } else {
            Drawable drawable = this.dLeft;
            if (drawable != null) {
                setCompoundDrawables(drawable, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            }
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            setClearIconVisible(false);
        } else if (this.mIsPasEditText) {
            setClearIconVisible(false);
        } else {
            setClearIconVisible(getText().length() > 0);
        }
    }

    public void setClearIconVisible(boolean z) {
        setCompoundDrawables(null, null, z ? getResources().getDrawable(R.drawable.selector_delete_word_button) : null, null);
    }
}
