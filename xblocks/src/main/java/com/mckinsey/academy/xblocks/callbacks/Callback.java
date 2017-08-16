package com.mckinsey.academy.xblocks.callbacks;

/**
 * Basic callback for XBlock component. Implement it in your app to get basic calls
 * from any XBlockComponent.
 */
public interface Callback {

    /**
     *Called when a XBlock Component get opened or started.
     */
    void onInit();

    /**
     * Called when a XBlock Component get completed.
     */
    void onComplete();
}
