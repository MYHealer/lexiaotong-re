package com.yfanads.android.custom.view;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yfanads.android.libs.utils.Util;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class NewCustomStyleDialog extends BaseDialogFragment implements Application.ActivityLifecycleCallbacks {
    public static final String CLICK_CLOSE_ID = "ccId";
    public static final String CLOSE_ID = "closeId";
    public static final String LAYOUT_ID = "layoutId";
    public static final String OFFSET_TOP = "mOffsetTop";
    private static final String TAG = "YFAds-Dialog";
    public static final String TYPE_ID = "tablet";
    private long actualExposureTime;
    public int checkTimes;
    private ScheduledExecutorService executorService;
    private boolean isCC;
    private boolean isShutDown;
    private boolean isTablet;
    public Activity mActivity;
    protected DialogDismiss mDialogDismiss;
    private int mOffsetTop;
    private int oldRequestedOrientation;
    private ScheduledFuture<?> scheduledFuture;
    private long startTime;
    private String tag = "default";
    private boolean isDismissing = false;

    public static class CustomDialogBuilder extends BaseDialogFragment.Builder<CustomDialogBuilder, NewCustomStyleDialog> {
        public int closeId;
        public boolean isClickClose;
        public boolean isTablet;
        public int layoutId;
        public int mOffsetTop;
        public String tag;
        public ViewGroup viewGroup;

        @Override // com.yfanads.android.custom.view.BaseDialogFragment.Builder
        public NewCustomStyleDialog build() {
            return NewCustomStyleDialog.instance(this);
        }

        public CustomDialogBuilder setClickClose(boolean z) {
            this.isClickClose = z;
            return this;
        }

        public CustomDialogBuilder setCloseId(int i) {
            this.closeId = i;
            return this;
        }

        public CustomDialogBuilder setLayoutId(int i) {
            this.layoutId = i;
            return this;
        }

        public CustomDialogBuilder setOffsetTop(int i) {
            this.mOffsetTop = i;
            return this;
        }

        public CustomDialogBuilder setTablet(boolean z) {
            this.isTablet = z;
            return this;
        }

        public CustomDialogBuilder setTag(String str) {
            this.tag = str;
            return this;
        }

        public CustomDialogBuilder setViewGroup(ViewGroup viewGroup) {
            this.viewGroup = viewGroup;
            return this;
        }
    }

    public interface DialogDismiss {
        void onDismiss();
    }

    public interface NewDialogBindData extends BaseDialogFragment.DialogBindData {
        void actualExposureTime();

        ViewGroup getRootView();

        void onConfigurationChanged(Context context, int i);
    }

    private void autoOrientationChanged() {
        if (!(this.mDialogBindData instanceof NewDialogBindData) || getActivity() == null) {
            return;
        }
        ((NewDialogBindData) this.mDialogBindData).onConfigurationChanged(getActivity(), this.oldRequestedOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWithWait() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (activity.getWindow() != null && this.mActivity.getWindow().getDecorView().getVisibility() == 0) {
                Log.i(TAG, "checkWithWait activity is visible and show, checkTimes: " + this.checkTimes);
                reallyShow();
                return;
            }
            Log.i(TAG, "checkWithWait activity is not visible and waite, checkTimes: " + this.checkTimes);
            int i = this.checkTimes;
            if (i >= 10) {
                this.mActivity.getApplication().registerActivityLifecycleCallbacks(this);
            } else {
                this.checkTimes = i + 1;
                Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.NewCustomStyleDialog$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.checkWithWait();
                    }
                }, 100L);
            }
        }
    }

    private void clearPreviousDialog(FragmentManager fragmentManager, String str) {
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (!(fragmentFindFragmentByTag instanceof DialogFragment)) {
            Log.i(TAG, "clearPreviousDialog not DialogFragment ");
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) fragmentFindFragmentByTag;
        String str2 = "clearPreviousDialog old " + dialogFragment.hashCode();
        if (dialogFragment.isAdded() || dialogFragment.isVisible()) {
            try {
                dialogFragment.dismissAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                String str3 = str2 + " pending transactions remove";
                if (dialogFragment.isAdded()) {
                    fragmentManager.beginTransaction().remove(dialogFragment).commitNowAllowingStateLoss();
                    sbAppend2 = new StringBuilder().append(str3).append(" commitNowAllowingStateLoss");
                } else {
                    sbAppend2 = new StringBuilder().append(str3).append(" not isAdd");
                }
                Log.i(TAG, sbAppend2.toString());
                return;
            } catch (Exception e) {
                sbAppend = new StringBuilder().append(str).append(" Failed to clear old dialog").append(e.getMessage());
            }
        } else {
            sbAppend = new StringBuilder().append(str).append(" oldDialog not isAdded or isVisible");
        }
        Log.w(TAG, sbAppend.toString());
    }

    private Activity getActivityFromManager(FragmentManager fragmentManager) {
        Fragment fragment;
        try {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (fragments != null && !fragments.isEmpty() && (fragment = fragments.get(0)) != null && fragment.getActivity() != null) {
                return fragment.getActivity();
            }
        } catch (Exception unused) {
        }
        return this.mActivity;
    }

    private void initData(String str, boolean z, boolean z2) {
        this.tag = str;
        this.checkTimes = 0;
        this.isCC = z;
        this.isTablet = z2;
    }

    public static NewCustomStyleDialog instance(CustomDialogBuilder customDialogBuilder) {
        NewCustomStyleDialog newCustomStyleDialog = new NewCustomStyleDialog();
        newCustomStyleDialog.initData(customDialogBuilder.tag, customDialogBuilder.isClickClose, customDialogBuilder.isTablet);
        Bundle argumentBundle = BaseDialogFragment.getArgumentBundle(customDialogBuilder);
        argumentBundle.putInt("layoutId", customDialogBuilder.layoutId);
        argumentBundle.putInt("closeId", customDialogBuilder.closeId);
        argumentBundle.putInt(OFFSET_TOP, customDialogBuilder.mOffsetTop);
        argumentBundle.putBoolean(CLICK_CLOSE_ID, customDialogBuilder.isClickClose);
        newCustomStyleDialog.setArguments(argumentBundle);
        return newCustomStyleDialog;
    }

    private boolean isContextInvalid(FragmentManager fragmentManager) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            Log.e(TAG, "isContextInvalid isDestroyed ");
            return true;
        }
        try {
            Activity activityFromManager = getActivityFromManager(fragmentManager);
            Log.i(TAG, "isContextInvalid isDestroyed " + activityFromManager);
            return activityFromManager == null || activityFromManager.isFinishing() || activityFromManager.isDestroyed();
        } catch (Exception unused) {
            return true;
        }
    }

    private void performShow(FragmentManager fragmentManager, String str) {
        if (isAdded() || isVisible()) {
            Log.e(TAG, "show isAdded or isVisible ");
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        if (!fragmentManager.isStateSaved()) {
            try {
                fragmentTransactionBeginTransaction.commit();
                fragmentManager.executePendingTransactions();
                Log.i(TAG, "show executePendingTransactions");
                return;
            } catch (IllegalStateException e) {
                Log.e(TAG, "show commit error " + e.getMessage());
            }
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        Log.i(TAG, "show commitAllowingStateLoss");
    }

    private void reallyShow() {
        Log.i(TAG, "reallyShow " + hashCode());
        try {
            show(this.mActivity.getFragmentManager(), this.tag);
            if (this.isCC) {
                startDetection();
            }
        } catch (Exception e) {
            Log.e(TAG, "reallyShow error" + e.getMessage());
        }
    }

    private void reallyShow(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity2 == null || activity != activity2) {
            return;
        }
        activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
        reallyShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleWithFixedDelay() {
        this.actualExposureTime = (System.currentTimeMillis() - this.startTime) + this.actualExposureTime;
        this.startTime = System.currentTimeMillis();
        if (this.actualExposureTime >= 1000) {
            if (this.mDialogBindData != null) {
                Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.custom.view.NewCustomStyleDialog$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1252x77915264();
                    }
                });
            }
            shutdown();
        }
    }

    private void updateConvertViewParams(Bundle bundle, View view) {
        int i = bundle.getInt("mWidth");
        int i2 = bundle.getInt("mHeight");
        int i3 = bundle.getInt(OFFSET_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        if (i3 > 0) {
            layoutParams.topMargin = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    public NewCustomStyleDialog bindData(BaseDialogFragment.DialogBindData dialogBindData) {
        this.mDialogBindData = dialogBindData;
        return this;
    }

    public void hide() {
        StringBuilder sbAppend;
        if (this.isDismissing) {
            return;
        }
        this.isDismissing = true;
        String str = "hide " + hashCode();
        try {
            Dialog dialog = getDialog();
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
                str = str + " dialog dismiss";
            }
            if (!isAdded() || isRemoving()) {
                return;
            }
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed()) {
                dismissAllowingStateLoss();
                sbAppend = new StringBuilder().append(str).append(" and dismissAllowingStateLoss ");
            } else if (fragmentManager.isStateSaved()) {
                dismissAllowingStateLoss();
                sbAppend = new StringBuilder().append(str).append(" 26 dismissAllowingStateLoss ");
            } else {
                dismiss();
                sbAppend = new StringBuilder().append(str).append(" and dismiss ");
            }
            Log.i(TAG, sbAppend.toString());
        } catch (Exception e) {
            String str2 = str + " error " + e.getMessage();
            try {
                dismissAllowingStateLoss();
                Log.i(TAG, str2 + " dismissAllowingStateLoss ");
            } catch (Exception e2) {
                this.isDismissing = false;
                Log.i(TAG, str2 + " error " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$scheduleWithFixedDelay$0$com-yfanads-android-custom-view-NewCustomStyleDialog, reason: not valid java name */
    /* synthetic */ void m1252x77915264() {
        BaseDialogFragment.DialogBindData dialogBindData = this.mDialogBindData;
        if (dialogBindData instanceof NewDialogBindData) {
            ((NewDialogBindData) dialogBindData).actualExposureTime();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity2 == null || activity != activity2) {
            return;
        }
        activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
        reallyShow();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(TAG, "newCustom onConfigurationChanged no:" + configuration.orientation + "|oo:" + this.oldRequestedOrientation + "|tt:" + this.isTablet);
        this.oldRequestedOrientation = configuration.orientation;
        autoOrientationChanged();
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mDialogBindData != null) {
            return new ProxyDialog(getActivity(), getTheme());
        }
        hide();
        return null;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.isDismissing = false;
    }

    @Override // com.yfanads.android.custom.view.BaseDialogFragment, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogDismiss dialogDismiss = this.mDialogDismiss;
        if (dialogDismiss != null) {
            dialogDismiss.onDismiss();
            this.mDialogDismiss = null;
        }
        Log.i(TAG, "onDismiss by dialog:" + hashCode());
        if (this.mDialogBindData != null) {
            this.mDialogBindData = null;
        }
        shutdown();
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
        this.mActivity = null;
        this.isDismissing = false;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        pauseDetection();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        resumeDetection();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override // com.yfanads.android.custom.view.BaseDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void pauseDetection() {
        if (!this.isCC || this.isShutDown) {
            return;
        }
        Log.d(Util.TAG, "actualExposure pauseDetection " + this.actualExposureTime);
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.scheduledFuture.cancel(false);
    }

    public void resumeDetection() {
        if (!this.isCC || this.isShutDown) {
            return;
        }
        Log.d(Util.TAG, "actualExposure resumeDetection " + this.actualExposureTime);
        startDetection();
    }

    public NewCustomStyleDialog setDismiss(DialogDismiss dialogDismiss) {
        this.mDialogDismiss = dialogDismiss;
        return this;
    }

    @Override // com.yfanads.android.custom.view.BaseDialogFragment
    public View setView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() == null) {
            return null;
        }
        this.oldRequestedOrientation = getActivity().getResources().getConfiguration().orientation;
        Bundle arguments = getArguments();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(arguments.getInt("layoutId"), viewGroup, false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        updateConvertViewParams(arguments, viewInflate);
        BaseDialogFragment.DialogBindData dialogBindData = this.mDialogBindData;
        if (dialogBindData instanceof NewDialogBindData) {
            NewDialogBindData newDialogBindData = (NewDialogBindData) dialogBindData;
            ViewGroup rootView = newDialogBindData.getRootView();
            if (rootView != null) {
                rootView.addView(viewInflate);
                newDialogBindData.bindViewData(rootView);
                return rootView;
            }
            newDialogBindData.bindViewData(viewInflate);
        }
        return viewInflate;
    }

    public void show(Activity activity) {
        this.mActivity = activity;
        checkWithWait();
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            Log.i(TAG, "==== show start by " + hashCode() + " ====");
            if (isContextInvalid(fragmentManager)) {
                Log.e(TAG, "show manager isDestroyed");
                return;
            }
            clearPreviousDialog(fragmentManager, str);
            performShow(fragmentManager, str);
            Log.i(TAG, "==== show end by " + hashCode() + " ====");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        ScheduledExecutorService scheduledExecutorService;
        try {
            if (this.isCC && (scheduledExecutorService = this.executorService) != null) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (Exception e) {
            Log.e(TAG, "shutdown error " + e.getMessage());
        }
        this.isShutDown = true;
    }

    public void startDetection() {
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            if (this.executorService == null) {
                this.executorService = Executors.newSingleThreadScheduledExecutor();
            }
            this.scheduledFuture = this.executorService.scheduleWithFixedDelay(new Runnable() { // from class: com.yfanads.android.custom.view.NewCustomStyleDialog$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.scheduleWithFixedDelay();
                }
            }, 0L, 100L, TimeUnit.MILLISECONDS);
            this.startTime = System.currentTimeMillis();
        }
    }
}
