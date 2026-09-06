package com.baidu.mobads.sdk.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class XNativeViewManager {
    private static XNativeViewManager sInstance;
    private final ArrayList<XNativeView> mViewList = new ArrayList<>();

    private XNativeViewManager() {
    }

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                if (sInstance == null) {
                    sInstance = new XNativeViewManager();
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        for (XNativeView xNativeView2 : this.mViewList) {
            if (xNativeView2 != xNativeView) {
                xNativeView2.stop();
                xNativeView2.handleCover();
            }
        }
    }

    public void removeNativeView(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }
}
