package com.mckinsey.academy.xblocks.player;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.configuration.Options;

/**
 * Added {@link LifecycleObserver} implementation.
 */
public class ObservableOoyalaPlayer extends OoyalaPlayer implements LifecycleObserver {

    public ObservableOoyalaPlayer(String pcode, PlayerDomain domain, Options options) {
        super(pcode, domain, options);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
        this.play();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {
        this.pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy() {
        this.suspend();
        this.release();
    }
}
