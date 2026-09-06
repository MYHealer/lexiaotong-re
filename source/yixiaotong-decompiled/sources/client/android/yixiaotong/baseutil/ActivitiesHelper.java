package client.android.yixiaotong.baseutil;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ActivitiesHelper {
    public static final int EXIT_APPLICATION = 1;
    private static ActivitiesHelper instance;
    private LinkedList<Activity> mActs = new LinkedList<>();

    private ActivitiesHelper() {
    }

    public static synchronized ActivitiesHelper getInstance() {
        if (instance == null) {
            instance = new ActivitiesHelper();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        synchronized (this) {
            this.mActs.addFirst(activity);
        }
    }

    public void removeActivity(Activity activity) {
        synchronized (this) {
            LinkedList<Activity> linkedList = this.mActs;
            if (linkedList != null && linkedList.indexOf(activity) >= 0) {
                this.mActs.remove(activity);
            }
        }
    }

    public Activity getTopActivity() {
        Activity activity;
        synchronized (this) {
            LinkedList<Activity> linkedList = this.mActs;
            activity = (linkedList == null || linkedList.size() <= 0) ? null : this.mActs.get(0);
        }
        return activity;
    }

    public Activity getSecondActivity() {
        Activity activity;
        synchronized (this) {
            LinkedList<Activity> linkedList = this.mActs;
            activity = (linkedList == null || linkedList.size() <= 1) ? null : this.mActs.get(1);
        }
        return activity;
    }

    public void closeAll() {
        synchronized (this) {
            while (this.mActs.size() != 0) {
                this.mActs.poll().finish();
            }
        }
    }

    public void closeExcept(Class<?> cls) {
        synchronized (this) {
            Iterator<Activity> it = this.mActs.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (!next.getClass().getName().equals(cls.getName())) {
                    next.finish();
                    it.remove();
                }
            }
        }
    }

    public void closeTarget(Class<?> cls) {
        synchronized (this) {
            Iterator<Activity> it = this.mActs.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().getName().equals(cls.getName())) {
                    next.finish();
                    it.remove();
                }
            }
        }
    }

    public ArrayList<Activity> getTargetActivity(Class<?> cls) {
        ArrayList<Activity> arrayList = new ArrayList<>();
        synchronized (this) {
            int size = this.mActs.size();
            for (int i = 0; i < size; i++) {
                Activity activity = this.mActs.get(i);
                if (activity.getClass().getName().equals(cls.getName())) {
                    arrayList.add(activity);
                }
            }
        }
        return arrayList;
    }

    public boolean hasActivity(Class<?> cls) {
        synchronized (this) {
            int size = this.mActs.size();
            for (int i = 0; i < size; i++) {
                if (this.mActs.get(i).getClass().getName().equals(cls.getName())) {
                    return true;
                }
            }
            return false;
        }
    }
}
