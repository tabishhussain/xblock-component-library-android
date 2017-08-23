package com.mckinsey.academy.xblocks.view;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v4.app.Fragment;

import com.mckinsey.academy.xblocks.callbacks.Callback;
import com.mckinsey.academy.xblocks.callbacks.XBlockComponentFragment;

import java.util.Observer;

/**
 * Fragment with {@link LifecycleRegistryOwner} implementation.
 */
public abstract class LifecycleOwnerFragment extends Fragment implements LifecycleRegistryOwner,
        Observer, XBlockComponentFragment {

    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    /**
     * set the {@link Callback} which is passed to {@link com.mckinsey.academy.xblocks.XBlock}
     * during integration.
     * @param callback
     */
    public abstract void setCallback(Callback callback);
}
