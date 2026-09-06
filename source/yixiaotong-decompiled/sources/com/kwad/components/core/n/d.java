package com.kwad.components.core.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class d<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T abm;
    public Presenter mPresenter;
    protected ViewGroup oC;

    protected abstract void a(ViewGroup viewGroup);

    protected boolean al() {
        return false;
    }

    protected abstract T an();

    protected abstract int getLayoutId();

    protected abstract void initData();

    public abstract Presenter onCreatePresenter();

    protected ViewGroup tq() {
        return null;
    }

    public d(Context context) {
        this(context, null);
    }

    private d(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView init createOnChild: " + al());
        if (al()) {
            return;
        }
        tp();
    }

    protected final void tp() {
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView createView");
        initData();
        if (getLayoutId() > 0) {
            this.oC = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        } else {
            this.oC = tq();
        }
        a(this.oC);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView onViewAttached");
        initMVP();
    }

    private void initMVP() {
        this.abm = (T) an();
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView initMVP mCallerContext: " + this.abm);
        if (this.mPresenter == null) {
            this.mPresenter = onCreatePresenter();
            com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView initMVP mPresenter: " + this.mPresenter + ", mContainerView: + " + this.oC);
            this.mPresenter.N(this.oC);
        }
        this.mPresenter.q(this.abm);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        T t = this.abm;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
