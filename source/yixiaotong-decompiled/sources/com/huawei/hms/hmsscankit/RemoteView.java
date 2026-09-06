package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.i3;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import com.yfanads.android.libs.net.UrlHttpUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RemoteView extends FrameLayout {
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    private static boolean flagForGallery = false;
    private static boolean isOnStop = true;
    private static a mRemoteHelper;
    private Context mContext;
    private boolean mContinuouslyScan;
    private boolean mReturnedBitmap;

    public static class Builder {
        Activity mContext;
        HmsScanAnalyzerOptions mFormat;
        Rect mRect;
        boolean mIsCustomed = true;
        boolean mContinuouslyScan = true;
        boolean mReturnedBitmap = false;

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z) {
            this.mContinuouslyScan = z;
            return this;
        }

        public Builder setFormat(int i, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i, iArr).create();
            return this;
        }
    }

    private class a extends DeferredLifecycleHelper<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup f4117a;
        public Activity b;
        private OnDelegateCreatedListener<b> c;
        private IRemoteViewDelegate d;
        private IOnResultCallback e = null;
        private boolean f;
        private boolean g;
        private int h;
        private IOnLightCallback i;
        private Rect j;
        private Bundle k;
        private boolean l;
        private boolean m;
        private int n;

        /* JADX INFO: renamed from: com.huawei.hms.hmsscankit.RemoteView$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0524a implements View.OnClickListener {
            ViewOnClickListenerC0524a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z, int i, Rect rect) {
            this.f4117a = viewGroup;
            this.b = activity;
            this.f = z;
            this.h = i;
            this.j = rect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.k = bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            this.g = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.b != null) {
                this.b = null;
            }
            if (this.f4117a != null) {
                this.f4117a = null;
            }
        }

        public void b(boolean z) {
            this.l = z;
        }

        public void c(boolean z) {
            this.m = z;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper
        public void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) {
            this.c = onDelegateCreatedListener;
            if (onDelegateCreatedListener == null || getDelegate() != null) {
                return;
            }
            this.d = null;
            try {
                Bundle bundle = new Bundle();
                boolean z = this.f;
                if (!z && this.h == 0 && this.j == null) {
                    x3.c(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                } else {
                    bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z);
                    bundle.putInt(DetailRect.FORMAT_FLAG, this.h);
                    Rect rect = this.j;
                    if (rect != null) {
                        bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                    }
                }
                boolean z2 = this.l;
                if (z2) {
                    bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z2);
                }
                boolean z3 = this.g;
                if (z3) {
                    bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z3);
                    bundle.putAll(this.k);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.RETURN_BITMAP, this.m);
                bundle.putAll(i3.a(this.b));
                bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                bundle.putInt(DetailRect.SCAN_VIEWTYPE_FLAG, this.n);
                IRemoteCreator iRemoteCreatorD = f.d(this.b);
                if (iRemoteCreatorD == null) {
                    return;
                } else {
                    this.d = iRemoteCreatorD.newRemoteViewDelegate(ObjectWrapper.wrap(this.b), ObjectWrapper.wrap(bundle));
                }
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return;
            }
            try {
                IOnResultCallback iOnResultCallback = this.e;
                if (iOnResultCallback != null) {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                    this.d.setOnClickListener(ObjectWrapper.wrap(new ViewOnClickListenerC0524a()));
                }
                this.d.setOnClickListener(ObjectWrapper.wrap(new b()));
                IOnLightCallback iOnLightCallback = this.i;
                if (iOnLightCallback != null) {
                    this.d.setOnLightVisbleCallBack(iOnLightCallback);
                }
            } catch (RemoteException unused2) {
                x3.b("exception", "RemoteException");
            }
            this.c.onDelegateCreated(new b(this.f4117a, this.d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    x3.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    x3.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.e = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    x3.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    x3.b("exception", "RemoteException");
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z, int i, Rect rect, int i2) {
            this.f4117a = viewGroup;
            this.b = activity;
            this.f = z;
            this.h = i;
            this.j = rect;
            this.n = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.i = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    x3.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, Intent intent) {
            if (i2 == -1 && intent != null && i == 4371) {
                try {
                    HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(RemoteView.this.mContext, y6.a(RemoteView.this.mContext, intent), new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                    IOnResultCallback iOnResultCallback = this.e;
                    if (iOnResultCallback != null) {
                        iOnResultCallback.onResult(hmsScanArrDecodeWithBitmap);
                    }
                } catch (RemoteException unused) {
                    x3.b(RemoteView.TAG, "RemoteException in remoteview");
                } catch (Error unused2) {
                    x3.b(RemoteView.TAG, "Exception in error");
                } catch (IllegalStateException unused3) {
                    x3.b(RemoteView.TAG, "IllegalStateException in remoteview");
                } catch (Exception unused4) {
                    x3.b(RemoteView.TAG, "Exception in remoteview");
                }
            }
        }
    }

    private static class b implements LifecycleDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup f4120a;
        private View b;
        private IRemoteViewDelegate c;

        b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.f4120a = viewGroup;
            this.c = iRemoteViewDelegate;
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.c.onCreate(bundle);
                this.b = (View) ObjectWrapper.unwrap(this.c.getView());
                this.f4120a.removeAllViews();
                this.f4120a.addView(this.b);
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View(null);
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.c.onDestroy();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.c.onPause();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                if (RemoteView.isOnStop || !RemoteView.flagForGallery) {
                    this.c.onResume();
                } else {
                    this.c.onStart();
                }
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.c.onStart();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.c.onStop();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mContext = activity;
        mRemoteHelper = new a(activity, this, z, i, rect);
    }

    private void startActivityForGallery(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (y6.f(activity)) {
                if (y6.a(new Intent(), "com.android.gallery3d", activity) != null && y6.a("com.android.gallery3d", activity)) {
                    x3.c(TAG, "Start Gallery:com.android.gallery3d");
                    intent.setPackage("com.android.gallery3d");
                } else if (y6.a(new Intent(), "com.huawei.photos", activity) != null && y6.a("com.huawei.photos", activity)) {
                    intent.setPackage("com.huawei.photos");
                    x3.c(TAG, "Start Gallery:com.huawei.photos");
                }
            }
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, UrlHttpUtil.FILE_TYPE_IMAGE);
            flagForGallery = true;
            activity.startActivityForResult(intent, 4371);
        } catch (Exception unused) {
            x3.b(TAG, "startPhotoCode Exception");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i(TAG, "onActivityResult: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Log.i(TAG, "onCreate:");
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(16777216, 16777216);
        }
        mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onDestroy();
            mRemoteHelper.b();
            mRemoteHelper = null;
        }
        y6.c = true;
    }

    public final void onPause() {
        Log.i(TAG, "onPause: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onPause();
        }
        a aVar2 = mRemoteHelper;
        if (aVar2 != null && flagForGallery) {
            aVar2.onStop();
        }
        isOnStop = false;
        y6.c = false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Activity activity) {
        if (i == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        Log.i(TAG, "onResume: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onResume();
        }
        flagForGallery = false;
    }

    public final void onStart() {
        Log.i(TAG, "onStart: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onStart();
        }
        flagForGallery = false;
    }

    public final void onStop() {
        Log.i(TAG, "onStop: ");
        a aVar = mRemoteHelper;
        if (aVar != null && !flagForGallery) {
            aVar.onStop();
        }
        isOnStop = true;
        y6.c = true;
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    public void selectPictureFromLocalFileFragment(Fragment fragment) {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, UrlHttpUtil.FILE_TYPE_IMAGE);
        fragment.startActivityForResult(intent, 4371);
    }

    RemoteView setContinuouslyScan(boolean z) {
        this.mContinuouslyScan = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (y6.a((Context) activity) || activity.checkPermission(PermissionUtil.PERSSION_READ_MEDIA_IMAGES, Process.myPid(), Process.myUid()) == 0) {
                startActivityForGallery(activity);
                return;
            } else {
                activity.requestPermissions(new String[]{PermissionUtil.PERSSION_READ_MEDIA_IMAGES}, 4371);
                return;
            }
        }
        if (y6.a((Context) activity) || activity.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            startActivityForGallery(activity);
        } else {
            activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4371);
        }
    }

    RemoteView enableReturnBitmap(boolean z) {
        this.mReturnedBitmap = z;
        mRemoteHelper.c(z);
        return this;
    }

    public boolean getLightStatus() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    public void pauseContinuouslyScan() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void resumeContinuouslyScan() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a(new com.huawei.hms.hmsscankit.b(onErrorCallback));
        }
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a(new c(onLightVisibleCallBack));
        }
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a(new d(onResultCallback, this.mContinuouslyScan));
        }
    }

    public boolean switchLight() {
        if (mRemoteHelper != null) {
            return !getLightStatus() ? mRemoteHelper.g() : mRemoteHelper.f();
        }
        return false;
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect, int i2) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mContext = activity;
        mRemoteHelper = new a(activity, this, z, i, rect, i2);
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect, boolean z2) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mContext = activity;
        a aVar = new a(activity, this, z, i, rect);
        mRemoteHelper = aVar;
        aVar.b(z2);
    }

    RemoteView(Activity activity, boolean z, Bundle bundle) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, null);
        mRemoteHelper = aVar;
        aVar.a(z);
        mRemoteHelper.a(bundle);
    }
}
