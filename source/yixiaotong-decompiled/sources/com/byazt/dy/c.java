package com.byazt.dy;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1335, 20})
public class c extends com.byazt.xj.c<UGFrameLayout> {
    public UGFrameLayout yo;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout c() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.tt);
        this.yo = uGFrameLayout;
        uGFrameLayout.c(this);
        return this.yo;
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        this.yo.setEventMap(this.gx);
        super.tt();
    }

    @Override // com.byazt.xj.c
    public com.byazt.xj.c.C0323c x() {
        return new C0138c(this);
    }

    /* JADX INFO: renamed from: com.byazt.dy.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1335, 44})
    public static class C0138c extends com.byazt.xj.c.C0323c {
        public int yv;

        public C0138c(com.byazt.xj.c cVar) {
            super(cVar);
            this.yv = -1;
        }

        @Override // com.byazt.xj.c.C0323c
        public void c(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.c(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.yv = c(str2);
            }
        }

        private int c(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iTt = 0;
            for (String str2 : strArrSplit) {
                iTt |= tt(str2);
            }
            return iTt;
        }

        private int tt(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.byazt.xj.c.C0323c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams c() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.c, (int) this.tt);
            layoutParams.leftMargin = (int) this.f2862a;
            layoutParams.rightMargin = (int) this.sp;
            layoutParams.topMargin = (int) this.x;
            layoutParams.bottomMargin = (int) this.i;
            layoutParams.gravity = this.yv;
            return layoutParams;
        }
    }
}
