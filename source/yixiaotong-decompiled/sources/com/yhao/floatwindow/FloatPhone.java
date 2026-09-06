package com.yhao.floatwindow;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class FloatPhone extends FloatView {
    private boolean isRemove = false;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private PermissionListener mPermissionListener;
    private View mView;
    private final WindowManager mWindowManager;
    private int mX;
    private int mY;

    @Override // com.yhao.floatwindow.FloatView
    int getX() {
        return this.mX;
    }

    @Override // com.yhao.floatwindow.FloatView
    int getY() {
        return this.mY;
    }

    @Override // com.yhao.floatwindow.FloatView
    public void setView(View view) {
        this.mView = view;
    }

    FloatPhone(Context context, PermissionListener permissionListener) {
        this.mContext = context;
        this.mPermissionListener = permissionListener;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams = layoutParams;
        layoutParams.format = 1;
        layoutParams.flags = MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE;
        layoutParams.windowAnimations = 0;
    }

    @Override // com.yhao.floatwindow.FloatView
    public void setSize(int i, int i2) {
        this.mLayoutParams.width = i;
        this.mLayoutParams.height = i2;
    }

    @Override // com.yhao.floatwindow.FloatView
    public void setGravity(int i, int i2, int i3) {
        this.mLayoutParams.gravity = i;
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        this.mX = i2;
        layoutParams.x = i2;
        WindowManager.LayoutParams layoutParams2 = this.mLayoutParams;
        this.mY = i3;
        layoutParams2.y = i3;
    }

    @Override // com.yhao.floatwindow.FloatView
    public void init() {
        req();
    }

    /* JADX INFO: renamed from: com.yhao.floatwindow.FloatPhone$1, reason: invalid class name */
    class AnonymousClass1 implements PermissionListener {
        AnonymousClass1() {
        }

        @Override // com.yhao.floatwindow.PermissionListener
        public void onSuccess() {
            FloatPhone.this.mWindowManager.addView(FloatPhone.this.mView, FloatPhone.this.mLayoutParams);
            if (FloatPhone.this.mPermissionListener != null) {
                FloatPhone.this.mPermissionListener.onSuccess();
            }
        }

        @Override // com.yhao.floatwindow.PermissionListener
        public void onFail() {
            if (FloatPhone.this.mPermissionListener != null) {
                FloatPhone.this.mPermissionListener.onFail();
            }
        }
    }

    private void req() {
        this.mLayoutParams.type = 2038;
        FloatActivity.request(this.mContext, new PermissionListener() { // from class: com.yhao.floatwindow.FloatPhone.2
            @Override // com.yhao.floatwindow.PermissionListener
            public void onSuccess() {
                FloatPhone.this.mWindowManager.addView(FloatPhone.this.mView, FloatPhone.this.mLayoutParams);
                if (FloatPhone.this.mPermissionListener != null) {
                    FloatPhone.this.mPermissionListener.onSuccess();
                }
            }

            @Override // com.yhao.floatwindow.PermissionListener
            public void onFail() {
                if (FloatPhone.this.mPermissionListener != null) {
                    FloatPhone.this.mPermissionListener.onFail();
                }
            }
        });
    }

    @Override // com.yhao.floatwindow.FloatView
    public void dismiss() {
        this.isRemove = true;
        this.mWindowManager.removeView(this.mView);
    }

    @Override // com.yhao.floatwindow.FloatView
    public void updateXY(int i, int i2) {
        if (this.isRemove) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        this.mX = i;
        layoutParams.x = i;
        WindowManager.LayoutParams layoutParams2 = this.mLayoutParams;
        this.mY = i2;
        layoutParams2.y = i2;
        this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
    }

    @Override // com.yhao.floatwindow.FloatView
    void updateX(int i) {
        if (this.isRemove) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        this.mX = i;
        layoutParams.x = i;
        this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
    }

    @Override // com.yhao.floatwindow.FloatView
    void updateY(int i) {
        if (this.isRemove) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        this.mY = i;
        layoutParams.y = i;
        this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
    }
}
