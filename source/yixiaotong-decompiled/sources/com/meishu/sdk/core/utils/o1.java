package com.meishu.sdk.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;

/* JADX INFO: compiled from: UiUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o1 {

    /* JADX INFO: compiled from: UiUtil.java */
    public class a extends com.meishu.sdk.core.safe.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4928a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public a(ViewGroup viewGroup, String str, long j) {
            this.f4928a = viewGroup;
            this.b = str;
            this.c = j;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            try {
                Class.forName("com.ms.test_tools.activity.MsTestToolActivity").getMethod("startSelf", Context.class, String.class, Long.TYPE).invoke(null, this.f4928a.getContext(), this.b, Long.valueOf(this.c));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(ViewGroup viewGroup, String str, long j) {
        if (viewGroup == null || !AdSdk.isTestMode) {
            return;
        }
        float f = viewGroup.getContext().getResources().getDisplayMetrics().density;
        int i = (int) (60.0f * f);
        int i2 = (int) (f * 30.0f);
        Button button = new Button(viewGroup.getContext());
        button.setBackgroundResource(R.drawable.ms_pid_config);
        button.setOnClickListener(new a(viewGroup, str, j));
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(12);
            layoutParams.leftMargin = 10;
            layoutParams.bottomMargin = i;
            viewGroup.addView(button, layoutParams);
            return;
        }
        if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i2);
            layoutParams2.gravity = 80;
            layoutParams2.leftMargin = 10;
            layoutParams2.bottomMargin = i;
            viewGroup.addView(button, layoutParams2);
            return;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i2);
            layoutParams3.gravity = 80;
            layoutParams3.leftMargin = 10;
            layoutParams3.bottomMargin = i;
            viewGroup.addView(button, layoutParams3);
        }
    }

    public static void b(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (str != null && str.length() > 0) {
                            z.a(AdSdk.getContext(), str.replace("__MS_EVENT__", "11").replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", "").replace("__ERROR_MESSAGE__", ""), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void c(String[] strArr, int i, String str) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.length() > 0) {
                            z.a(AdSdk.getContext(), str2.replace("__MS_EVENT__", BaseWrapper.ENTER_ID_GAME_CENTER).replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", h0.b(String.valueOf(i))).replace("__ERROR_MESSAGE__", h0.b(str)), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(String[] strArr, int i, String str) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.length() > 0) {
                            z.a(AdSdk.getContext(), str2.replace("__MS_EVENT__", "12").replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", h0.b(String.valueOf(i))).replace("__ERROR_MESSAGE__", h0.b(str)), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr, int i, String str) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (!TextUtils.isEmpty(str2)) {
                            z.a(AdSdk.getContext(), str2.replace("__MS_EVENT__", BaseWrapper.ENTER_ID_GAME_CENTER).replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", h0.b(String.valueOf(i))).replace("__ERROR_MESSAGE__", h0.b(str)), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr, int i, int i2, String str) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.length() > 0) {
                            z.a(AdSdk.getContext(), str2.replace("__MS_EVENT__", String.valueOf(i)).replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", h0.b(String.valueOf(i2))).replace("__ERROR_MESSAGE__", h0.b(str)), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (str != null && str.length() > 0) {
                            z.a(AdSdk.getContext(), str.replace("__MS_EVENT__", BaseWrapper.ENTER_ID_AD_SDK).replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", "").replace("__ERROR_MESSAGE__", ""), new i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr, String str, Throwable th) {
        try {
            a(strArr, 1000, 0, "{\"dp_link\":\"" + str + "\",\"error_msg\":\"" + th.getClass().getSimpleName() + "\"}");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String[] strArr, String str) {
        if (q0.i > 0) {
            b(strArr, ErrorCodeUtil.RENDER_AD_STEP, str);
        }
    }

    public static boolean a(String str, int i, int i2) {
        long jA = q.a().a("adg_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis - jA >= ((long) i2) * 1000 && jCurrentTimeMillis - q.a().a(new StringBuilder().append(str).append("_adp").toString(), 0L) >= ((long) i) * 1000;
    }
}
