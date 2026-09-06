package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeTrimPath;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation<?, Float> endAnimation;
    private final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList();
    private final String name;
    private final BaseKeyframeAnimation<?, Float> offsetAnimation;
    private final BaseKeyframeAnimation<?, Float> startAnimation;
    private final ShapeTrimPath.Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.type = shapeTrimPath.getType();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = shapeTrimPath.getStart().createAnimation();
        this.startAnimation = baseKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation2 = shapeTrimPath.getEnd().createAnimation();
        this.endAnimation = baseKeyframeAnimationCreateAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation3 = shapeTrimPath.getOffset().createAnimation();
        this.offsetAnimation = baseKeyframeAnimationCreateAnimation3;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation3);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.endAnimation;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.offsetAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.startAnimation;
    }

    public ShapeTrimPath.Type getType() {
        return this.type;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
