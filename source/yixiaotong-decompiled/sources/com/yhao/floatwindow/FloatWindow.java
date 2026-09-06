package com.yhao.floatwindow;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FloatWindow {
    private static B mBuilder = null;
    private static final String mDefaultTag = "default_float_window_tag";
    private static Map<String, IFloatWindow> mFloatWindowMap;

    private FloatWindow() {
    }

    public static IFloatWindow get() {
        return get(mDefaultTag);
    }

    public static IFloatWindow get(String str) {
        Map<String, IFloatWindow> map = mFloatWindowMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static B with(Context context) {
        B b = new B(context);
        mBuilder = b;
        return b;
    }

    public static void destroy() {
        destroy(mDefaultTag);
    }

    public static void destroy(String str) {
        Map<String, IFloatWindow> map = mFloatWindowMap;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        mFloatWindowMap.get(str).dismiss();
        mFloatWindowMap.remove(str);
    }

    public static class B {
        Class[] mActivities;
        Context mApplicationContext;
        boolean mDesktopShow;
        TimeInterpolator mInterpolator;
        private int mLayoutId;
        PermissionListener mPermissionListener;
        int mSlideLeftMargin;
        int mSlideRightMargin;
        View mView;
        ViewStateListener mViewStateListener;
        int xOffset;
        int yOffset;
        int mWidth = -2;
        int mHeight = -2;
        int gravity = BadgeDrawable.TOP_START;
        boolean mShow = true;
        int mMoveType = 3;
        long mDuration = 300;
        private String mTag = FloatWindow.mDefaultTag;

        public B setDesktopShow(boolean z) {
            this.mDesktopShow = z;
            return this;
        }

        public B setFilter(boolean z, Class... clsArr) {
            this.mShow = z;
            this.mActivities = clsArr;
            return this;
        }

        public B setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        public B setMoveStyle(long j, TimeInterpolator timeInterpolator) {
            this.mDuration = j;
            this.mInterpolator = timeInterpolator;
            return this;
        }

        public B setMoveType(int i, int i2, int i3) {
            this.mMoveType = i;
            this.mSlideLeftMargin = i2;
            this.mSlideRightMargin = i3;
            return this;
        }

        public B setPermissionListener(PermissionListener permissionListener) {
            this.mPermissionListener = permissionListener;
            return this;
        }

        public B setTag(String str) {
            this.mTag = str;
            return this;
        }

        public B setView(int i) {
            this.mLayoutId = i;
            return this;
        }

        public B setView(View view) {
            this.mView = view;
            return this;
        }

        public B setViewStateListener(ViewStateListener viewStateListener) {
            this.mViewStateListener = viewStateListener;
            return this;
        }

        public B setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        public B setX(int i) {
            this.xOffset = i;
            return this;
        }

        public B setY(int i) {
            this.yOffset = i;
            return this;
        }

        private B() {
        }

        B(Context context) {
            this.mApplicationContext = context;
        }

        public B setWidth(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = Util.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = Util.getScreenHeight(this.mApplicationContext);
            }
            this.mWidth = (int) (screenHeight * f);
            return this;
        }

        public B setHeight(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = Util.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = Util.getScreenHeight(this.mApplicationContext);
            }
            this.mHeight = (int) (screenHeight * f);
            return this;
        }

        public B setX(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = Util.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = Util.getScreenHeight(this.mApplicationContext);
            }
            this.xOffset = (int) (screenHeight * f);
            return this;
        }

        public B setY(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = Util.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = Util.getScreenHeight(this.mApplicationContext);
            }
            this.yOffset = (int) (screenHeight * f);
            return this;
        }

        public B setMoveType(int i) {
            return setMoveType(i, 0, 0);
        }

        public void build() {
            if (FloatWindow.mFloatWindowMap == null) {
                Map unused = FloatWindow.mFloatWindowMap = new HashMap();
            }
            if (FloatWindow.mFloatWindowMap.containsKey(this.mTag)) {
                throw new IllegalArgumentException("FloatWindow of this tag has been added, Please set a new tag for the new FloatWindow");
            }
            View view = this.mView;
            if (view == null && this.mLayoutId == 0) {
                throw new IllegalArgumentException("View has not been set!");
            }
            if (view == null) {
                this.mView = Util.inflate(this.mApplicationContext, this.mLayoutId);
            }
            FloatWindow.mFloatWindowMap.put(this.mTag, new IFloatWindowImpl(this));
        }
    }
}
