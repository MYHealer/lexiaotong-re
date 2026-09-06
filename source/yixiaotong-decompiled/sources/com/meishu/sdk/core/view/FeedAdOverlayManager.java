package com.meishu.sdk.core.view;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.x;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.service.a;
import com.meishu.sdk.core.service.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.q;
import com.meishu.sdk.core.utils.s1;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FeedAdOverlayManager {
    private static final String KEY_DAILY_COUNT_SUFFIX = "_slide_overlay_daily";
    private static final String KEY_SUFFIX = "_slide_overlay";
    private static final String TAG = "FeedAdOverlayManager";
    private static volatile FeedAdOverlayManager sInstance;
    private final List<OverlayEntry> entries = new ArrayList();
    private final a appStateListener = new a() { // from class: com.meishu.sdk.core.view.FeedAdOverlayManager.2
        @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
        public void onActivityDestroyed(Activity activity) {
            FeedAdOverlayManager.this.removeByPosIdOrActivity(null, activity, null);
        }

        @Override // com.meishu.sdk.core.service.e
        public boolean onAppStateUpdate(boolean z) {
            return true;
        }
    };

    public interface OnOverlayTriggerAction {
        void onOverlayAttached();

        void onTrigger(boolean z, boolean z2, float f, float f2, long j, float f3, float f4, int i);
    }

    public static class OverlayEntry {
        public final WeakReference<Activity> activityRef;
        public WeakReference<View> adContainerRef;
        public final int ecpm;
        public final FeedAdOverlayView overlayView;
        public final String posId;
        public final OnOverlayTriggerAction triggerAction;
        public final String uniqueId;

        public OverlayEntry(Activity activity, View view, FeedAdOverlayView feedAdOverlayView, String str, String str2, int i, OnOverlayTriggerAction onOverlayTriggerAction) {
            this.activityRef = new WeakReference<>(activity);
            this.adContainerRef = new WeakReference<>(view);
            this.overlayView = feedAdOverlayView;
            this.posId = str;
            this.uniqueId = str2;
            this.ecpm = i;
            this.triggerAction = onOverlayTriggerAction;
        }
    }

    private FeedAdOverlayManager() {
    }

    private OverlayEntry findEntryByUniqueId(String str) {
        if (str == null) {
            return null;
        }
        try {
            for (OverlayEntry overlayEntry : this.entries) {
                if (str.equals(overlayEntry.uniqueId)) {
                    return overlayEntry;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getTodayCount() {
        String strA = q.a().a(KEY_DAILY_COUNT_SUFFIX, "");
        String todayString = getTodayString();
        if (!strA.startsWith(todayString + x.bQ)) {
            return 0;
        }
        try {
            return Integer.parseInt(strA.substring(todayString.length() + 1));
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String getTodayString() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    private void handleClick(boolean z, boolean z2, TouchPoint touchPoint, TouchPoint touchPoint2, int i, View view, String str) {
        if (this.entries.isEmpty()) {
            return;
        }
        OverlayEntry overlayEntry = null;
        OverlayEntry overlayEntry2 = null;
        for (OverlayEntry overlayEntry3 : this.entries) {
            if (overlayEntry3.overlayView.getVisibility() == 0 && s1.a(overlayEntry3.overlayView, touchPoint.downX, touchPoint.downY) && (overlayEntry2 == null || overlayEntry3.ecpm > overlayEntry2.ecpm)) {
                overlayEntry2 = overlayEntry3;
            }
            View view2 = overlayEntry3.adContainerRef.get();
            if (view2 != null && s1.a(view2, touchPoint.downX, touchPoint.downY)) {
                overlayEntry = overlayEntry3;
                break;
            }
        }
        if (overlayEntry == null) {
            overlayEntry = overlayEntry2;
        }
        if (overlayEntry == null) {
            m992x21797d12(str);
            return;
        }
        q.a().b(overlayEntry.posId + KEY_SUFFIX, System.currentTimeMillis());
        if (!z2) {
            incrementTodayCount();
        }
        removeByPosIdOrActivity(overlayEntry.posId, overlayEntry.activityRef.get(), str);
        OnOverlayTriggerAction onOverlayTriggerAction = overlayEntry.triggerAction;
        if (onOverlayTriggerAction != null) {
            onOverlayTriggerAction.onTrigger(z, z2, touchPoint2.downX, touchPoint2.downY, touchPoint2.downTime, touchPoint2.upX, touchPoint2.upY, i);
        }
    }

    private void incrementTodayCount() {
        q.a().b(KEY_DAILY_COUNT_SUFFIX, getTodayString() + x.bQ + (getTodayCount() + 1));
    }

    private void releaseEntriesAdContainerRef(View view) {
        if (view == null) {
            return;
        }
        try {
            for (OverlayEntry overlayEntry : this.entries) {
                if (overlayEntry.adContainerRef.get() == view) {
                    overlayEntry.overlayView.releaseAdContainerRef();
                    overlayEntry.adContainerRef = new WeakReference<>(null);
                    LogUtil.dev(TAG, "releaseEntriesAdContainerRef released uniqueId=" + overlayEntry.uniqueId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeByPosIdOrActivity(String str, Activity activity, String str2) {
        int i;
        int i2 = 0;
        try {
            Iterator<OverlayEntry> it = this.entries.iterator();
            i = 0;
            while (it.hasNext()) {
                try {
                    OverlayEntry next = it.next();
                    boolean z = true;
                    boolean z2 = str != null && str.equals(next.posId);
                    boolean z3 = activity != null && activity == next.activityRef.get();
                    if (str2 == null || !str2.equals(next.uniqueId)) {
                        z = false;
                    }
                    if (z2 || z3 || z) {
                        next.overlayView.detach();
                        it.remove();
                        i++;
                    }
                } catch (Exception e) {
                    e = e;
                    i2 = i;
                    e.printStackTrace();
                    i = i2;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        LogUtil.d(TAG, "removeByPosIdOrActivity removed=" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: removeInvalidEntryByUniqueId, reason: merged with bridge method [inline-methods] */
    public void m992x21797d12(String str) {
        if (str == null) {
            return;
        }
        try {
            Iterator<OverlayEntry> it = this.entries.iterator();
            while (it.hasNext()) {
                OverlayEntry next = it.next();
                if (str.equals(next.uniqueId)) {
                    if (next.activityRef.get() == null) {
                        next.overlayView.detach();
                        it.remove();
                        LogUtil.dev(TAG, "removeInvalidEntryByUniqueId uniqueId=" + str);
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addOverlay(Activity activity, final View view, String str, int i, BaseAdSlot baseAdSlot, String str2, final OnOverlayTriggerAction onOverlayTriggerAction) {
        int i2;
        if (activity != null && view != null && str != null && baseAdSlot != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    int iMax = Math.max(0, baseAdSlot.getExtend_up());
                    int iMax2 = Math.max(0, baseAdSlot.getExtend_down());
                    int iMax3 = Math.max(0, baseAdSlot.getExtend_left());
                    int iMax4 = Math.max(0, baseAdSlot.getExtend_right());
                    int extend_interval = baseAdSlot.getExtend_interval();
                    int extend_max_count = baseAdSlot.getExtend_max_count();
                    int ecpm = baseAdSlot.getEcpm();
                    boolean z = (baseAdSlot.getAct_type() & 512) == 512;
                    if (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) {
                        LogUtil.dev(TAG, "addOverlay return. extend all 0, feature disabled");
                        return;
                    }
                    if (extend_max_count > 0 && getTodayCount() >= extend_max_count) {
                        LogUtil.dev(TAG, "addOverlay return. daily count limit reached");
                        return;
                    }
                    boolean z2 = z;
                    if (extend_interval > 0) {
                        i2 = iMax3;
                        if (System.currentTimeMillis() - q.a().a(str + KEY_SUFFIX, 0L) < ((long) extend_interval) * 60000) {
                            LogUtil.dev(TAG, "addOverlay return. interval");
                            return;
                        }
                    } else {
                        i2 = iMax3;
                    }
                    int i3 = activity.getResources().getDisplayMetrics().heightPixels;
                    int measuredHeight = view.getMeasuredHeight();
                    if (measuredHeight * 2 > i3) {
                        LogUtil.dev(TAG, "addOverlay return. adContainer h > 50% screenH adH=" + measuredHeight + " screenH=" + i3);
                        return;
                    }
                    int i4 = ((int) ((i3 * iMax) / 100.0f)) + measuredHeight + ((int) ((i3 * iMax2) / 100.0f));
                    if (i4 * 2 > i3) {
                        float f = i3;
                        iMax = Math.round(((((f / 2.0f) - measuredHeight) / f) * 100.0f) / 2.0f);
                        LogUtil.dev(TAG, "addOverlay: extended height > 50% screen, result=" + iMax + " extendedH=" + i4 + " screenH=" + i3);
                        iMax2 = iMax;
                    }
                    OverlayEntry overlayEntryFindEntryByUniqueId = findEntryByUniqueId(str2);
                    if (overlayEntryFindEntryByUniqueId != null) {
                        if (overlayEntryFindEntryByUniqueId.overlayView.getVisibility() == 0) {
                            LogUtil.dev(TAG, "addOverlay return. same ad already has overlay, posId=" + str + " uniqueId=" + str2);
                            return;
                        } else {
                            LogUtil.dev(TAG, "addOverlay: overlay exists but invisible, requestPositionUpdate posId=" + str + " uniqueId=" + str2);
                            overlayEntryFindEntryByUniqueId.overlayView.requestPositionUpdate();
                            return;
                        }
                    }
                    releaseEntriesAdContainerRef(view);
                    ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
                    if (viewGroup == null) {
                        LogUtil.dev(TAG, "addOverlay return. content is null");
                        return;
                    }
                    FeedAdOverlayView feedAdOverlayView = new FeedAdOverlayView(activity, view, new FeedAdOverlayView.OnOverlayClickListener() { // from class: com.meishu.sdk.core.view.FeedAdOverlayManager$$ExternalSyntheticLambda0
                        @Override // com.meishu.sdk.core.view.FeedAdOverlayView.OnOverlayClickListener
                        public final void onOverlayClick(boolean z3, boolean z4, TouchPoint touchPoint, TouchPoint touchPoint2, int i5, String str3) {
                            this.f$0.m991xabff56d1(view, z3, z4, touchPoint, touchPoint2, i5, str3);
                        }
                    });
                    feedAdOverlayView.setOverlayUniqueId(str2);
                    feedAdOverlayView.setMinSlideDistanceDp(i);
                    feedAdOverlayView.setExtendRatios(iMax, iMax2, i2, iMax4);
                    feedAdOverlayView.setInvalidityChecker(new FeedAdOverlayView.InvalidityCheckerListener() { // from class: com.meishu.sdk.core.view.FeedAdOverlayManager$$ExternalSyntheticLambda1
                        @Override // com.meishu.sdk.core.view.FeedAdOverlayView.InvalidityCheckerListener
                        public final void onInvalid(String str3) {
                            this.f$0.m992x21797d12(str3);
                        }
                    });
                    feedAdOverlayView.setAttachListener(new FeedAdOverlayView.OnOverlayAttachListener() { // from class: com.meishu.sdk.core.view.FeedAdOverlayManager.1
                        @Override // com.meishu.sdk.core.view.FeedAdOverlayView.OnOverlayAttachListener
                        public void onOverlayDetached() {
                        }

                        @Override // com.meishu.sdk.core.view.FeedAdOverlayView.OnOverlayAttachListener
                        public void onOverlayAttached() {
                            OnOverlayTriggerAction onOverlayTriggerAction2 = onOverlayTriggerAction;
                            if (onOverlayTriggerAction2 != null) {
                                onOverlayTriggerAction2.onOverlayAttached();
                            }
                        }
                    });
                    feedAdOverlayView.attachToContent(viewGroup);
                    this.entries.add(new OverlayEntry(activity, view, feedAdOverlayView, str, str2, ecpm, onOverlayTriggerAction));
                    try {
                        d.a(this.appStateListener);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LogUtil.dev(TAG, "add posId=" + str + " slideClickEnabled=" + z2 + " uniqueId:" + str2);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        LogUtil.dev(TAG, "addOverlay return. is null");
    }

    public void clear() {
        d.b(this.appStateListener);
        Iterator<OverlayEntry> it = this.entries.iterator();
        while (it.hasNext()) {
            it.next().overlayView.detach();
        }
        this.entries.clear();
    }

    /* JADX INFO: renamed from: lambda$addOverlay$0$com-meishu-sdk-core-view-FeedAdOverlayManager, reason: not valid java name */
    /* synthetic */ void m991xabff56d1(View view, boolean z, boolean z2, TouchPoint touchPoint, TouchPoint touchPoint2, int i, String str) {
        try {
            handleClick(z, z2, touchPoint, touchPoint2, i, view, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAdClickedIfOverlayExists(String str, String str2, Activity activity) {
        if (findEntryByUniqueId(str) != null) {
            q.a().b(str2 + KEY_SUFFIX, System.currentTimeMillis());
            incrementTodayCount();
        }
        removeByPosIdOrActivity(str2, activity, str);
    }

    public void removeOverlay(String str) {
        OverlayEntry overlayEntryFindEntryByUniqueId = findEntryByUniqueId(str);
        if (overlayEntryFindEntryByUniqueId != null) {
            overlayEntryFindEntryByUniqueId.overlayView.detach();
            this.entries.remove(overlayEntryFindEntryByUniqueId);
        }
    }

    public void updateAdContainer(String str, View view) {
        OverlayEntry overlayEntryFindEntryByUniqueId = findEntryByUniqueId(str);
        if (overlayEntryFindEntryByUniqueId == null || view == null || overlayEntryFindEntryByUniqueId.adContainerRef.get() == view) {
            return;
        }
        releaseEntriesAdContainerRef(view);
        overlayEntryFindEntryByUniqueId.overlayView.updateAdContainer(view);
        overlayEntryFindEntryByUniqueId.adContainerRef = new WeakReference<>(view);
        overlayEntryFindEntryByUniqueId.overlayView.requestPositionUpdate();
        LogUtil.dev(TAG, "updateAdContainer uniqueId=" + str);
    }

    public static FeedAdOverlayManager getInstance() {
        if (sInstance == null) {
            synchronized (FeedAdOverlayManager.class) {
                if (sInstance == null) {
                    sInstance = new FeedAdOverlayManager();
                }
            }
        }
        return sInstance;
    }
}
