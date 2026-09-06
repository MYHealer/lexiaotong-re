package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.ubixnow.core.R;
import com.ubixnow.core.common.ui.UMNAdActivity;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO0O0 {
    public static Set<String> OooO00o = new HashSet();
    public boolean OooO0O0;
    public boolean OooO0OO;
    private WeakReference<Activity> OooO0Oo;

    public enum OooO {
        LARGE,
        MIDDLE,
        SMALL,
        TINY
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ o0OO0 OooO00o;
        public final /* synthetic */ Activity OooO0O0;

        public OooO00o(o0OO0 o0oo0, Activity activity) {
            this.OooO00o = o0oo0;
            this.OooO0O0 = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            String str;
            DisplayMetrics displayMetrics = BaseUtils.getContext().getResources().getDisplayMetrics();
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (TextUtils.isEmpty(this.OooO00o.OooOOO)) {
                return;
            }
            String[] strArrSplit = this.OooO00o.OooOOO.split("_");
            if (i2 > i3) {
                i = Integer.parseInt(strArrSplit[1]);
                str = strArrSplit[0];
            } else {
                i = Integer.parseInt(strArrSplit[0]);
                str = strArrSplit[1];
            }
            int i4 = Integer.parseInt(str);
            if (this.OooO0O0 != null) {
                o0OO0O0.this.OooO0Oo = new WeakReference(this.OooO0O0);
            }
            o0OO0O0 o0oo0o0 = o0OO0O0.this;
            o0oo0o0.OooO0O0 = i <= 50;
            o0oo0o0.OooO0OO = i4 <= 50;
            o0oo0o0.OooO00o(this.OooO00o, i, i4);
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ o0OO0 OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int OooO0OO;

        public OooO0O0(o0OO0 o0oo0, int i, int i2) {
            this.OooO00o = o0oo0;
            this.OooO0O0 = i;
            this.OooO0OO = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            float f2;
            float f3;
            try {
                int measuredHeight = this.OooO00o.OooOO0O.getMeasuredHeight();
                int measuredWidth = this.OooO00o.OooOO0O.getMeasuredWidth();
                if (this.OooO00o.OooOOOO && measuredWidth < BaseUtils.getContext().getResources().getDisplayMetrics().widthPixels / 3) {
                    ooooO000.OooO0O0("----feedback:", "容器宽度小于屏幕宽度的1/3");
                    return;
                }
                float fOooO0O0 = o0OO0O0.OooO0O0(this.OooO00o.OooOO0o);
                float fOooO00o = o0OO0O0.OooO00o(this.OooO00o.OooOO0o);
                if (measuredHeight <= 0 || measuredWidth <= 0) {
                    return;
                }
                float f4 = measuredWidth;
                float f5 = measuredHeight;
                float f6 = f5 / 100.0f;
                int i = this.OooO0O0;
                float f7 = i * (f4 / 100.0f);
                float f8 = fOooO0O0 / 2.0f;
                float f9 = 0.0f;
                if (f7 < f8 || f7 + f8 > f4) {
                    f = 0.0f;
                    f2 = 0.0f;
                } else if (i <= 50) {
                    f2 = f7 - f8;
                    f = 0.0f;
                } else {
                    f = (f4 - f7) - f8;
                    f2 = 0.0f;
                }
                int i2 = this.OooO0OO;
                float f10 = i2 * f6;
                float f11 = fOooO00o / 2.0f;
                if (f10 < f11 || f10 + f11 > f5) {
                    f3 = 0.0f;
                } else if (i2 <= 50) {
                    f3 = f10 - f11;
                } else {
                    float f12 = (f5 - f10) - f11;
                    f3 = 0.0f;
                    f9 = f12;
                }
                o0OO0O0.this.OooO00o(this.OooO00o, (int) f2, (int) f, (int) f3, (int) f9);
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0OO implements View.OnClickListener {
        public final /* synthetic */ o0OO0 OooO00o;

        public OooO0OO(o0OO0 o0oo0) {
            this.OooO00o = o0oo0;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (o0OO0O0.OooO00o.contains(this.OooO00o.OooOOOo.get(o0OO000o.o000o00))) {
                    o0OO.OooO00o("您已成功提交反馈，请勿重复提交哦！");
                } else {
                    o0OO0 o0oo0 = this.OooO00o;
                    if (o0oo0.OooOOO0 == 1) {
                        o0OO0O0.this.OooO0O0(o0oo0);
                    } else {
                        o0OO0O0.this.OooO00o(o0oo0);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ class OooO0o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            OooO.values();
            int[] iArr = new int[4];
            OooO00o = iArr;
            try {
                iArr[OooO.LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[OooO.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OooO00o[OooO.TINY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OooOO0 {
        void OooO00o(Activity activity);
    }

    public static float OooO00o(OooO oooO) {
        float f;
        int iOrdinal = oooO.ordinal();
        if (iOrdinal == 0) {
            f = 23.0f;
        } else if (iOrdinal != 2) {
            f = iOrdinal != 3 ? 18.0f : 7.0f;
        } else {
            f = 9.0f;
        }
        return oOO00000.OooO00o(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(o0OO0 o0oo0, int i, int i2) {
        ViewGroup viewGroup = o0oo0.OooOO0O;
        if (viewGroup != null) {
            viewGroup.post(new OooO0O0(o0oo0, i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(o0OO0 o0oo0, int i, int i2, int i3, int i4) {
        int i5;
        try {
            o0OOO00 o0ooo00 = new o0OOO00(o0oo0.OooOO0O.getContext());
            o0ooo00.setImageResource(R.drawable.ubixnow_dislike);
            o0ooo00.setTag("dislike_button");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) OooO0O0(o0oo0.OooOO0o), (int) OooO00o(o0oo0.OooOO0o));
            if (this.OooO0O0) {
                layoutParams.gravity = GravityCompat.START;
                layoutParams.leftMargin = i;
            } else {
                layoutParams.gravity = GravityCompat.END;
                layoutParams.rightMargin = i2;
            }
            if (this.OooO0OO) {
                layoutParams.topMargin = i3;
                i5 = layoutParams.gravity | 48;
            } else {
                layoutParams.bottomMargin = i4;
                i5 = layoutParams.gravity | 80;
            }
            layoutParams.gravity = i5;
            o0oo0.OooOO0O.addView(o0ooo00, layoutParams);
            o0ooo00.setOnClickListener(new OooO0OO(o0oo0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float OooO0O0(OooO oooO) {
        float f;
        int iOrdinal = oooO.ordinal();
        if (iOrdinal == 0) {
            f = 51.0f;
        } else if (iOrdinal != 2) {
            f = iOrdinal != 3 ? 40.0f : 15.0f;
        } else {
            f = 20.0f;
        }
        return oOO00000.OooO00o(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(o0OO0 o0oo0) {
        Intent intent = new Intent(BaseUtils.getContext(), (Class<?>) UMNAdActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("trackInfo", o0oo0.OooOOOo);
        BaseUtils.getContext().startActivity(intent);
    }

    public void OooO00o(o0OO0 o0oo0) {
        if (this.OooO0Oo.get() == null || this.OooO0Oo.get().isFinishing()) {
            return;
        }
        new oo0ooO.OooO0O0(this.OooO0Oo.get()).OooO00o(1, o0oo0.OooOOOo).show();
    }

    public void OooO00o(o0OO0 o0oo0, Activity activity) {
        try {
            BaseUtils.runInMainThread(new OooO00o(o0oo0, activity));
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            e.printStackTrace();
        }
    }
}
