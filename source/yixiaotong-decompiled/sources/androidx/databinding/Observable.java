package androidx.databinding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface Observable {

    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable sender, int propertyId);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback callback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback);
}
