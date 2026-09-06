package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.StackingBehavior;
import com.afollestad.materialdialogs.util.DialogUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MDRootLayout extends ViewGroup {
    private static final int INDEX_NEGATIVE = 1;
    private static final int INDEX_NEUTRAL = 0;
    private static final int INDEX_POSITIVE = 2;
    private ViewTreeObserver.OnScrollChangedListener mBottomOnScrollChangedListener;
    private int mButtonBarHeight;
    private GravityEnum mButtonGravity;
    private int mButtonHorizontalEdgeMargin;
    private int mButtonPaddingFull;
    private final MDButton[] mButtons;
    private View mContent;
    private Paint mDividerPaint;
    private int mDividerWidth;
    private boolean mDrawBottomDivider;
    private boolean mDrawTopDivider;
    private boolean mIsStacked;
    private boolean mNoTitleNoPadding;
    private int mNoTitlePaddingFull;
    private boolean mReducePaddingNoTitleNoButtons;
    private StackingBehavior mStackBehavior;
    private View mTitleBar;
    private ViewTreeObserver.OnScrollChangedListener mTopOnScrollChangedListener;
    private boolean mUseFullPadding;

    public void noTitleNoPadding() {
        this.mNoTitleNoPadding = true;
    }

    public MDRootLayout(Context context) {
        super(context);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = false;
        this.mButtons = new MDButton[3];
        this.mStackBehavior = StackingBehavior.ADAPTIVE;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, null, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = false;
        this.mButtons = new MDButton[3];
        this.mStackBehavior = StackingBehavior.ADAPTIVE;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = false;
        this.mButtons = new MDButton[3];
        this.mStackBehavior = StackingBehavior.ADAPTIVE;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, i);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = false;
        this.mButtons = new MDButton[3];
        this.mStackBehavior = StackingBehavior.ADAPTIVE;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MDRootLayout, i, 0);
        this.mReducePaddingNoTitleNoButtons = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        typedArrayObtainStyledAttributes.recycle();
        this.mNoTitlePaddingFull = resources.getDimensionPixelSize(R.dimen.md_notitle_vertical_padding);
        this.mButtonPaddingFull = resources.getDimensionPixelSize(R.dimen.md_button_frame_vertical_padding);
        this.mButtonHorizontalEdgeMargin = resources.getDimensionPixelSize(R.dimen.md_button_padding_frame_side);
        this.mButtonBarHeight = resources.getDimensionPixelSize(R.dimen.md_button_height);
        this.mDividerPaint = new Paint();
        this.mDividerWidth = resources.getDimensionPixelSize(R.dimen.md_divider_height);
        this.mDividerPaint.setColor(DialogUtils.resolveColor(context, R.attr.md_divider_color));
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == R.id.md_titleFrame) {
                this.mTitleBar = childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultNeutral) {
                this.mButtons[0] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultNegative) {
                this.mButtons[1] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultPositive) {
                this.mButtons[2] = (MDButton) childAt;
            } else {
                this.mContent = childAt;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00de  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int measuredHeight;
        int i3;
        int measuredHeight2;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mUseFullPadding = true;
        int measuredHeight3 = 0;
        if (this.mStackBehavior == StackingBehavior.ALWAYS) {
            z2 = true;
            z = false;
        } else if (this.mStackBehavior == StackingBehavior.NEVER) {
            z2 = false;
            z = false;
        } else {
            int measuredWidth = 0;
            z = false;
            for (MDButton mDButton : this.mButtons) {
                if (mDButton != null && isVisible(mDButton)) {
                    mDButton.setStacked(false, false);
                    measureChild(mDButton, i, i2);
                    measuredWidth += mDButton.getMeasuredWidth();
                    z = true;
                }
            }
            z2 = measuredWidth > size - (getContext().getResources().getDimensionPixelSize(R.dimen.md_neutral_button_margin) * 2);
        }
        this.mIsStacked = z2;
        if (z2) {
            measuredHeight = 0;
            for (MDButton mDButton2 : this.mButtons) {
                if (mDButton2 != null && isVisible(mDButton2)) {
                    mDButton2.setStacked(true, false);
                    measureChild(mDButton2, i, i2);
                    measuredHeight += mDButton2.getMeasuredHeight();
                    z = true;
                }
            }
        } else {
            measuredHeight = 0;
        }
        if (z) {
            if (this.mIsStacked) {
                measuredHeight2 = size2 - measuredHeight;
                int i5 = this.mButtonPaddingFull;
                i3 = i5 * 2;
                i4 = i5 * 2;
            } else {
                measuredHeight2 = size2 - this.mButtonBarHeight;
                i3 = this.mButtonPaddingFull * 2;
            }
            if (isVisible(this.mTitleBar)) {
                this.mTitleBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), 0);
                measuredHeight2 -= this.mTitleBar.getMeasuredHeight();
            } else if (!this.mNoTitleNoPadding) {
                i3 += this.mNoTitlePaddingFull;
            }
            if (isVisible(this.mContent)) {
                this.mContent.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2 - i4, Integer.MIN_VALUE));
                if (this.mContent.getMeasuredHeight() <= measuredHeight2 - i3) {
                    this.mUseFullPadding = false;
                } else if (this.mReducePaddingNoTitleNoButtons || isVisible(this.mTitleBar) || z) {
                    this.mUseFullPadding = true;
                    measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i3);
                } else {
                    this.mUseFullPadding = false;
                    measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i4);
                }
            } else {
                measuredHeight3 = measuredHeight2;
            }
            setMeasuredDimension(size, size2 - measuredHeight3);
        }
        i3 = this.mButtonPaddingFull * 2;
        measuredHeight2 = size2;
        i4 = 0;
        if (isVisible(this.mTitleBar)) {
            this.mTitleBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), 0);
            measuredHeight2 -= this.mTitleBar.getMeasuredHeight();
        } else if (!this.mNoTitleNoPadding) {
            i3 += this.mNoTitlePaddingFull;
        }
        if (isVisible(this.mContent)) {
            this.mContent.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2 - i4, Integer.MIN_VALUE));
            if (this.mContent.getMeasuredHeight() <= measuredHeight2 - i3) {
                this.mUseFullPadding = false;
            } else if (this.mReducePaddingNoTitleNoButtons) {
                this.mUseFullPadding = true;
                measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i3);
            } else {
                this.mUseFullPadding = true;
                measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i3);
            }
        } else {
            measuredHeight3 = measuredHeight2;
        }
        setMeasuredDimension(size, size2 - measuredHeight3);
    }

    private static boolean isVisible(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        if (z && (view instanceof MDButton)) {
            return ((MDButton) view).getText().toString().trim().length() > 0;
        }
        return z;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.mContent;
        if (view != null) {
            if (this.mDrawTopDivider) {
                int top = view.getTop();
                canvas.drawRect(0.0f, top - this.mDividerWidth, getMeasuredWidth(), top, this.mDividerPaint);
            }
            if (this.mDrawBottomDivider) {
                int bottom = this.mContent.getBottom();
                canvas.drawRect(0.0f, bottom, getMeasuredWidth(), bottom + this.mDividerWidth, this.mDividerPaint);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredWidth;
        int measuredWidth2;
        int measuredWidth3;
        int measuredWidth4;
        int measuredWidth5;
        int measuredWidth6;
        int measuredWidth7;
        int measuredWidth8;
        if (isVisible(this.mTitleBar)) {
            int measuredHeight = this.mTitleBar.getMeasuredHeight() + i2;
            this.mTitleBar.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.mNoTitleNoPadding && this.mUseFullPadding) {
            i2 += this.mNoTitlePaddingFull;
        }
        if (isVisible(this.mContent)) {
            View view = this.mContent;
            view.layout(i, i2, i3, view.getMeasuredHeight() + i2);
        }
        if (this.mIsStacked) {
            int measuredHeight2 = i4 - this.mButtonPaddingFull;
            for (MDButton mDButton : this.mButtons) {
                if (isVisible(mDButton)) {
                    mDButton.layout(i, measuredHeight2 - mDButton.getMeasuredHeight(), i3, measuredHeight2);
                    measuredHeight2 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.mUseFullPadding) {
                i4 -= this.mButtonPaddingFull;
            }
            int i6 = i4 - this.mButtonBarHeight;
            int measuredWidth9 = this.mButtonHorizontalEdgeMargin;
            if (isVisible(this.mButtons[2])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    measuredWidth7 = i + measuredWidth9;
                    measuredWidth8 = this.mButtons[2].getMeasuredWidth() + measuredWidth7;
                    i5 = -1;
                } else {
                    int i7 = i3 - measuredWidth9;
                    measuredWidth7 = i7 - this.mButtons[2].getMeasuredWidth();
                    measuredWidth8 = i7;
                    i5 = measuredWidth7;
                }
                this.mButtons[2].layout(measuredWidth7, i6, measuredWidth8, i4);
                measuredWidth9 += this.mButtons[2].getMeasuredWidth();
            } else {
                i5 = -1;
            }
            if (isVisible(this.mButtons[1])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    measuredWidth5 = measuredWidth9 + i;
                    measuredWidth6 = this.mButtons[1].getMeasuredWidth() + measuredWidth5;
                } else {
                    if (this.mButtonGravity == GravityEnum.START) {
                        measuredWidth6 = i3 - measuredWidth9;
                        measuredWidth5 = measuredWidth6 - this.mButtons[1].getMeasuredWidth();
                    } else {
                        measuredWidth5 = this.mButtonHorizontalEdgeMargin + i;
                        measuredWidth6 = this.mButtons[1].getMeasuredWidth() + measuredWidth5;
                        measuredWidth = measuredWidth6;
                    }
                    this.mButtons[1].layout(measuredWidth5, i6, measuredWidth6, i4);
                }
                measuredWidth = -1;
                this.mButtons[1].layout(measuredWidth5, i6, measuredWidth6, i4);
            } else {
                measuredWidth = -1;
            }
            if (isVisible(this.mButtons[0])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    measuredWidth3 = i3 - this.mButtonHorizontalEdgeMargin;
                    measuredWidth4 = measuredWidth3 - this.mButtons[0].getMeasuredWidth();
                } else if (this.mButtonGravity == GravityEnum.START) {
                    measuredWidth4 = i + this.mButtonHorizontalEdgeMargin;
                    measuredWidth3 = this.mButtons[0].getMeasuredWidth() + measuredWidth4;
                } else {
                    if (measuredWidth != -1 || i5 == -1) {
                        if (i5 == -1 && measuredWidth != -1) {
                            measuredWidth2 = this.mButtons[0].getMeasuredWidth();
                        } else if (i5 == -1) {
                            measuredWidth = ((i3 - i) / 2) - (this.mButtons[0].getMeasuredWidth() / 2);
                            measuredWidth2 = this.mButtons[0].getMeasuredWidth();
                        }
                        i5 = measuredWidth + measuredWidth2;
                    } else {
                        measuredWidth = i5 - this.mButtons[0].getMeasuredWidth();
                    }
                    measuredWidth3 = i5;
                    measuredWidth4 = measuredWidth;
                }
                this.mButtons[0].layout(measuredWidth4, i6, measuredWidth3, i4);
            }
        }
        setUpDividersVisibility(this.mContent, true, true);
    }

    public void setStackingBehavior(StackingBehavior stackingBehavior) {
        this.mStackBehavior = stackingBehavior;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.mDividerPaint.setColor(i);
        invalidate();
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.mButtonGravity = gravityEnum;
        invertGravityIfNecessary();
    }

    private void invertGravityIfNecessary() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$GravityEnum[this.mButtonGravity.ordinal()];
            if (i == 1) {
                this.mButtonGravity = GravityEnum.END;
            } else {
                if (i != 2) {
                    return;
                }
                this.mButtonGravity = GravityEnum.START;
            }
        }
    }

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.internal.MDRootLayout$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$GravityEnum;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            $SwitchMap$com$afollestad$materialdialogs$GravityEnum = iArr;
            try {
                iArr[GravityEnum.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$afollestad$materialdialogs$GravityEnum[GravityEnum.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        for (MDButton mDButton : this.mButtons) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    private void setUpDividersVisibility(final View view, final boolean z, final boolean z2) {
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (canScrollViewScroll(scrollView)) {
                addScrollListener(scrollView, z, z2);
                return;
            }
            if (z) {
                this.mDrawTopDivider = false;
            }
            if (z2) {
                this.mDrawBottomDivider = false;
                return;
            }
            return;
        }
        if (view instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view;
            if (canAdapterViewScroll(adapterView)) {
                addScrollListener(adapterView, z, z2);
                return;
            }
            if (z) {
                this.mDrawTopDivider = false;
            }
            if (z2) {
                this.mDrawBottomDivider = false;
                return;
            }
            return;
        }
        if (view instanceof WebView) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (view.getMeasuredHeight() == 0) {
                        return true;
                    }
                    if (MDRootLayout.canWebViewScroll((WebView) view)) {
                        MDRootLayout.this.addScrollListener((ViewGroup) view, z, z2);
                    } else {
                        if (z) {
                            MDRootLayout.this.mDrawTopDivider = false;
                        }
                        if (z2) {
                            MDRootLayout.this.mDrawBottomDivider = false;
                        }
                    }
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
            return;
        }
        if (view instanceof RecyclerView) {
            boolean zCanRecyclerViewScroll = canRecyclerViewScroll((RecyclerView) view);
            if (z) {
                this.mDrawTopDivider = zCanRecyclerViewScroll;
            }
            if (z2) {
                this.mDrawBottomDivider = zCanRecyclerViewScroll;
            }
            if (zCanRecyclerViewScroll) {
                addScrollListener((ViewGroup) view, z, z2);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View topView = getTopView(viewGroup);
            setUpDividersVisibility(topView, z, z2);
            View bottomView = getBottomView(viewGroup);
            if (bottomView != topView) {
                setUpDividersVisibility(bottomView, false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addScrollListener(final ViewGroup viewGroup, final boolean z, final boolean z2) {
        if ((z2 || this.mTopOnScrollChangedListener != null) && !(z2 && this.mBottomOnScrollChangedListener == null)) {
            return;
        }
        if (viewGroup instanceof RecyclerView) {
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    boolean z3 = false;
                    for (MDButton mDButton : MDRootLayout.this.mButtons) {
                        if (mDButton != null && mDButton.getVisibility() != 8) {
                            z3 = true;
                            break;
                        }
                    }
                    MDRootLayout.this.invalidateDividersForScrollingView(viewGroup, z, z2, z3);
                    MDRootLayout.this.invalidate();
                }
            };
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            recyclerView.addOnScrollListener(onScrollListener);
            onScrollListener.onScrolled(recyclerView, 0, 0);
            return;
        }
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.afollestad.materialdialogs.internal.MDRootLayout.3
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                boolean z3 = false;
                for (MDButton mDButton : MDRootLayout.this.mButtons) {
                    if (mDButton != null && mDButton.getVisibility() != 8) {
                        z3 = true;
                        break;
                    }
                }
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 instanceof WebView) {
                    MDRootLayout.this.invalidateDividersForWebView((WebView) viewGroup2, z, z2, z3);
                } else {
                    MDRootLayout.this.invalidateDividersForScrollingView(viewGroup2, z, z2, z3);
                }
                MDRootLayout.this.invalidate();
            }
        };
        if (!z2) {
            this.mTopOnScrollChangedListener = onScrollChangedListener;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mTopOnScrollChangedListener);
        } else {
            this.mBottomOnScrollChangedListener = onScrollChangedListener;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mBottomOnScrollChangedListener);
        }
        onScrollChangedListener.onScrollChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateDividersForScrollingView(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (z && viewGroup.getChildCount() > 0) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (!z2 || viewGroup.getChildCount() <= 0) {
            return;
        }
        this.mDrawBottomDivider = z3 && (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() < viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateDividersForWebView(WebView webView, boolean z, boolean z2, boolean z3) {
        if (z) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            this.mDrawBottomDivider = z3 && ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) < ((float) webView.getContentHeight()) * webView.getScale();
        }
    }

    public static boolean canRecyclerViewScroll(RecyclerView recyclerView) {
        return (recyclerView == null || recyclerView.getLayoutManager() == null || !recyclerView.getLayoutManager().canScrollVertically()) ? false : true;
    }

    private static boolean canScrollViewScroll(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        return (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canWebViewScroll(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    private static boolean canAdapterViewScroll(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        return !(adapterView.getFirstVisiblePosition() == 0) || !(adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom();
    }

    private static View getBottomView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    private static View getTopView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }
}
