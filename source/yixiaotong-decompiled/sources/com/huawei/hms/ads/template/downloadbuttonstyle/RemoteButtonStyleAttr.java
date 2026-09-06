package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.graphics.drawable.Drawable;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RemoteButtonStyleAttr {
    private String bfDlBtnTxt;
    protected Drawable cancelBackground;
    protected Drawable cancelBackgroundDark;
    protected Drawable cancelBtn;
    protected Drawable cancelBtnDark;
    protected Drawable installingBackground;
    protected Drawable installingBackgroundDark;
    protected int installingTextColor;
    protected int installingTextColorDark;
    private boolean isAppRelated;
    private int mMaxWidth;
    private int mMinWidth;
    protected Drawable normalBackground;
    protected Drawable normalBackgroundDark;
    protected int normalTextColor;
    protected int normalTextColorDark;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private String priorAfDlBtnTxt;
    private String priorBfDlBtnTxt;
    protected Drawable processingBackground;
    protected Drawable processingBackgroundDark;
    protected int processingTextColor;
    protected int processingTextColorDark;
    private String promtBtnTxt;
    private String webBtnTxt;
    private boolean mFixedWidth = false;
    private boolean resetWidth = true;
    private int mTextColor = -1;
    private float mTextSize = 12.0f;
    String mFontFamily = x.dj;

    public Drawable B() {
        return this.installingBackground;
    }

    public void B(Drawable drawable) {
        this.normalBackgroundDark = drawable;
    }

    public void B(String str) {
        this.priorAfDlBtnTxt = str;
    }

    public int C() {
        return this.installingTextColor;
    }

    public void C(Drawable drawable) {
        this.cancelBackground = drawable;
    }

    public void C(String str) {
        this.webBtnTxt = str;
    }

    public Drawable Code() {
        return this.normalBackground;
    }

    public void Code(Drawable drawable) {
        this.normalBackground = drawable;
    }

    public Drawable D() {
        return this.cancelBackground;
    }

    public void D(Drawable drawable) {
        this.installingBackgroundDark = drawable;
    }

    public Drawable F() {
        return this.normalBackgroundDark;
    }

    public void F(Drawable drawable) {
        this.processingBackgroundDark = drawable;
    }

    public Drawable I() {
        return this.processingBackground;
    }

    public void I(Drawable drawable) {
        this.installingBackground = drawable;
    }

    public void I(String str) {
        this.promtBtnTxt = str;
    }

    public void I(boolean z) {
        this.isAppRelated = z;
    }

    public Drawable L() {
        return this.cancelBackgroundDark;
    }

    public void L(Drawable drawable) {
        this.cancelBtnDark = drawable;
    }

    public Drawable S() {
        return this.cancelBtn;
    }

    public void S(Drawable drawable) {
        this.cancelBackgroundDark = drawable;
    }

    public int V() {
        return this.normalTextColor;
    }

    public void V(Drawable drawable) {
        this.processingBackground = drawable;
    }

    public void V(String str) {
        this.bfDlBtnTxt = str;
    }

    public int Z() {
        return this.processingTextColor;
    }

    public void Z(Drawable drawable) {
        this.cancelBtn = drawable;
    }

    public void Z(String str) {
        this.priorBfDlBtnTxt = str;
    }

    public int a() {
        return this.normalTextColorDark;
    }

    public Drawable b() {
        return this.processingBackgroundDark;
    }

    public int c() {
        return this.processingTextColorDark;
    }

    public Drawable d() {
        return this.installingBackgroundDark;
    }

    public int e() {
        return this.installingTextColorDark;
    }

    public Drawable f() {
        return this.cancelBtnDark;
    }

    public boolean g() {
        return this.mFixedWidth;
    }

    public boolean h() {
        return this.resetWidth;
    }

    public int i() {
        return this.mMaxWidth;
    }

    public int j() {
        return this.mMinWidth;
    }

    public float l() {
        return this.mTextSize;
    }

    public String m() {
        return this.mFontFamily;
    }

    public int n() {
        return this.paddingLeft;
    }

    public int o() {
        return this.paddingRight;
    }

    public int p() {
        return this.paddingTop;
    }

    public int q() {
        return this.paddingBottom;
    }

    public String r() {
        return this.bfDlBtnTxt;
    }

    public String s() {
        return this.promtBtnTxt;
    }

    public String t() {
        return this.priorBfDlBtnTxt;
    }

    public String u() {
        return this.priorAfDlBtnTxt;
    }

    public String v() {
        return this.webBtnTxt;
    }

    public boolean w() {
        return this.isAppRelated;
    }
}
