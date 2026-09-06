package com.kwad.components.core.page.widget.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.t.q;
import com.kwad.components.core.t.w;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b extends j implements DialogInterface.OnKeyListener {
    private int agB;
    protected a agC;
    protected Fragment agD;
    protected int agx;
    protected int agy;
    private boolean agz;
    protected View mRootView;
    protected boolean agv = false;
    protected boolean agw = true;
    protected boolean agA = true;
    private boolean agE = true;
    private int agF = -1;
    private float agG = -1.0f;
    private final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    private boolean agH = true;
    protected int agI = R.style.ksad_Theme_Dialog_Translucent;

    public interface a {
        Fragment vj();
    }

    private boolean vd() {
        return this.agw;
    }

    private boolean ve() {
        return this.agv;
    }

    private boolean vg() {
        return this.agE;
    }

    public final void a(a aVar) {
        this.agC = aVar;
    }

    public final b bB(int i) {
        this.agB = i;
        return this;
    }

    public final void j(float f) {
        this.agG = f;
    }

    protected int uW() {
        return this.agI;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return this.mBackPressDelete.onBackPressed();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        a aVar = this.agC;
        if (aVar != null) {
            this.agD = aVar.vj();
            try {
                getChildFragmentManager().beginTransaction().replace(R.id.ksad_half_container_content_fragment, this.agD).commitAllowingStateLoss();
                getChildFragmentManager().executePendingTransactions();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(getLayoutId(), viewGroup, true);
        }
        return this.mRootView;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnKeyListener(this);
        dialogOnCreateDialog.setCanceledOnTouchOutside(this.agH);
        if (uW() != 0) {
            setStyle(1, uW());
        }
        return dialogOnCreateDialog;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Dialog dialog = getDialog();
        b(dialog);
        Window window = dialog != null ? dialog.getWindow() : null;
        super.onActivityCreated(bundle);
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.agF < 0 && !Objects.equals(getTag(), "sensitive_words")) {
                this.agF = w.aR(StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext())) ? -2 : -1;
            }
            window.setLayout(-1, this.agF);
            if (this.agG > -1.0f) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = this.agG;
                window.setAttributes(attributes);
            }
        }
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.page.widget.a.b.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (!(b.this.agD instanceof DialogInterface.OnKeyListener)) {
                        return false;
                    }
                    ((DialogInterface.OnKeyListener) b.this.agD).onKey(dialogInterface, i, keyEvent);
                    return false;
                }
            });
        }
    }

    private void b(Dialog dialog) {
        int iK;
        Window window = dialog == null ? null : dialog.getWindow();
        if (window != null) {
            int i = -2;
            if (vd()) {
                iK = -2;
            } else {
                iK = this.agy;
                if (iK == 0) {
                    iK = com.kwad.sdk.c.a.a.k(getActivity());
                }
            }
            if (!ve() && (i = this.agx) == 0) {
                i = -1;
            }
            window.setLayout(i, iK);
            window.setGravity(17);
            if (!this.agA) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setDimAmount(0.0f);
            }
            boolean zVh = vh();
            int i2 = this.agB;
            if (i2 == 0) {
                if (vg()) {
                    window.setWindowAnimations(vf());
                }
            } else {
                window.setWindowAnimations(i2);
            }
            window.setGravity((this.agz && zVh) ? 21 : 81);
        }
    }

    private static int vf() {
        return R.style.ksad_Theme_Slide;
    }

    private boolean vh() {
        Activity activity = getActivity();
        if (q.isInMultiWindowMode(activity)) {
            return q.e(activity);
        }
        Resources resources = StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext()).getResources();
        return (resources == null || resources.getConfiguration() == null || resources.getConfiguration().orientation != 2) ? false : true;
    }

    protected int getLayoutId() {
        return R.layout.ksad_half_container_dialog_fragment;
    }

    public final void bC(int i) {
        this.agF = i;
        vi();
    }

    private void vi() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, this.agF);
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        this.agH = z;
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(this.agH);
        }
    }
}
