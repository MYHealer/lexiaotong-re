package client.android.yixiaotong.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import lxt.com.a.S;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TitleBar extends LinearLayout {
    private TextView mLeftTextView;
    private RelativeLayout mRelTitle;
    private TextView mRightTextView;
    private int mTheme;
    private TextView mTitleTextView;
    private TextView mTitleTextView2;

    public TextView getRightView() {
        return this.mRightTextView;
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(attributeSet);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTheme = 0;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.mTheme = getContext().obtainStyledAttributes(attributeSet, R.styleable.TitleBar).getInt(R.styleable.TitleBar_barTheme, 0);
        }
        if (this.mTheme == 0) {
            LayoutInflater.from(getContext()).inflate(R.layout.titlebar_view_dark, this);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.titlebar_view_light, this);
        }
        if (isInEditMode()) {
            return;
        }
        this.mRelTitle = (RelativeLayout) findViewById(R.id.rel_title);
        this.mLeftTextView = (TextView) findViewById(R.id.leftTextView);
        this.mTitleTextView = (TextView) findViewById(R.id.titleTextView);
        this.mTitleTextView2 = (TextView) findViewById(R.id.titleTextView2);
        this.mRightTextView = (TextView) findViewById(R.id.rightTextView);
    }

    public void setLeftView(String str) {
        this.mLeftTextView.setText(str);
        ViewUtils.clearCompoundDrawable(this.mLeftTextView);
    }

    public void setLeftViewTextColor(int i) {
        this.mLeftTextView.setTextColor(i);
    }

    public void setLeftView(int i) {
        this.mLeftTextView.setText("");
        ViewUtils.setLeftDrawable(this.mLeftTextView, getResources().getDrawable(i));
    }

    public void setLeftView(String str, int i) {
        this.mLeftTextView.setText(str);
        ViewUtils.setLeftDrawable(this.mLeftTextView, getResources().getDrawable(i));
    }

    public void setLeftView(Bitmap bitmap) {
        this.mLeftTextView.setText("");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        ViewUtils.setRightDrawable(this.mRightTextView, bitmapDrawable);
    }

    public void setLeftView(Drawable drawable) {
        this.mLeftTextView.setText("");
        ViewUtils.setRightDrawable(this.mLeftTextView, drawable);
    }

    public void setLeftViewIsBack() {
        if (this.mTheme == 0) {
            setLeftView(R.mipmap.back);
        } else {
            setLeftView(R.mipmap.back);
        }
    }

    public void setLeftViewIsGone() {
        setLeftView("");
    }

    public void setLeftViewOnClickBack(final Activity activity) {
        this.mLeftTextView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.widget.TitleBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (S.b(activity)) {
                    activity.finish();
                    return;
                }
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addFlags(268435456);
                intent.addCategory("android.intent.category.HOME");
                activity.startActivity(intent);
            }
        });
    }

    public void setLeftViewOnClick(View.OnClickListener onClickListener) {
        this.mLeftTextView.setOnClickListener(onClickListener);
    }

    public void setLeftViewOnClickBackConnect(final Activity activity) {
        this.mLeftTextView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.widget.TitleBar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                activity.finish();
            }
        });
    }

    public void setLeftViewOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftTextView.setOnClickListener(onClickListener);
    }

    public void setRightView(String str) {
        this.mRightTextView.setText(str);
        ViewUtils.clearCompoundDrawable(this.mRightTextView);
        setRightViewIsVisible();
    }

    public void setRightViewTextColor(int i) {
        this.mRightTextView.setTextColor(i);
        setRightViewIsVisible();
    }

    public void setRightViewsetBackground(int i) {
        if (i > 0) {
            this.mRightTextView.setBackgroundResource(i);
            this.mRightTextView.setPadding(getResources().getDimensionPixelSize(R.dimen.margin_8), 0, getResources().getDimensionPixelSize(R.dimen.margin_8), 0);
        } else {
            this.mRightTextView.setBackgroundResource(i);
            this.mRightTextView.setPadding(0, 0, 0, 0);
        }
        setRightViewIsVisible();
    }

    public void setRightView(int i) {
        ViewUtils.setRightDrawable(this.mRightTextView, getResources().getDrawable(i));
        setRightViewIsVisible();
    }

    public void setRightView(String str, int i) {
        this.mRightTextView.setText(str);
        ViewUtils.setRightDrawable(this.mRightTextView, getResources().getDrawable(i));
        setRightViewIsVisible();
    }

    public void setRightView(Bitmap bitmap) {
        this.mRightTextView.setText("");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        ViewUtils.setRightDrawable(this.mRightTextView, bitmapDrawable);
        setRightViewIsVisible();
    }

    public void setRightView(Drawable drawable) {
        this.mRightTextView.setText("");
        ViewUtils.setRightDrawable(this.mRightTextView, drawable);
        setRightViewIsVisible();
    }

    public void setRightViewOnClickListener(View.OnClickListener onClickListener) {
        this.mRightTextView.setOnClickListener(onClickListener);
    }

    public void setRightViewIsGone() {
        this.mRightTextView.setVisibility(4);
    }

    public void setRightViewIsVisible() {
        this.mRightTextView.setVisibility(0);
    }

    public void setTitleView(String str) {
        if (!StringUtils.isChinese(str)) {
            str = StringUtils.getUpperCaseStr(str);
        }
        this.mTitleTextView.setText(str);
        this.mTitleTextView.setTextSize(16.0f);
        this.mTitleTextView.getPaint().setFakeBoldText(true);
        ViewUtils.clearCompoundDrawable(this.mTitleTextView);
    }

    public String getTitleViewContent() {
        return this.mTitleTextView.getText().toString();
    }

    public void setTitleView2(String str) {
        this.mTitleTextView2.setText(str);
        this.mTitleTextView2.setTextSize(16.0f);
        ViewUtils.clearCompoundDrawable(this.mTitleTextView2);
    }

    public void setTitleViewTextColor() {
        this.mTitleTextView.setTextColor(-14776091);
    }

    public void setTitleViewTextColor1() {
        this.mTitleTextView.setTextColor(16631399);
    }

    public void setTitleViewBackground() {
        this.mRelTitle.setBackgroundResource(R.mipmap.l_shouye_bottom_background);
    }

    public void setTitleViewTextColor2() {
        this.mTitleTextView2.setTextColor(-1);
    }

    public void setTitleViewTextColorCard() {
        this.mTitleTextView.setTextColor(-1);
    }

    public void setTitleViewTextColorCard2() {
        this.mTitleTextView2.setTextColor(-14776091);
    }

    public void setTitleViewImg() {
        this.mTitleTextView.setBackgroundResource(R.drawable.titlebackgroundleft1);
    }

    public void setTitleViewImg2() {
        this.mTitleTextView2.setBackgroundResource(R.drawable.titlebackgroundright1);
    }

    public void setTitleViewImgCard() {
        this.mTitleTextView.setBackgroundResource(R.drawable.titlebackgroundleft2);
    }

    public void setTitleViewImgCard2() {
        this.mTitleTextView2.setBackgroundResource(R.drawable.titlebackgroundright2);
    }

    public void setTitleViewOnClickListener(View.OnClickListener onClickListener) {
        this.mTitleTextView.setOnClickListener(onClickListener);
    }

    public void setTitleViewOnClickListener2(View.OnClickListener onClickListener) {
        this.mTitleTextView2.setOnClickListener(onClickListener);
    }

    public void setTitleViewIsGone() {
        this.mTitleTextView.setVisibility(4);
    }

    public void setTitleViewIsGone2() {
        this.mTitleTextView2.setVisibility(4);
    }

    public void setTitleViewIsVisible() {
        this.mTitleTextView.setVisibility(0);
    }

    public void setTitleViewIsVisible2() {
        this.mTitleTextView2.setVisibility(0);
    }
}
