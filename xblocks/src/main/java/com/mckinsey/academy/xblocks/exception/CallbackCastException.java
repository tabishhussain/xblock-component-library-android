package com.mckinsey.academy.xblocks.exception;

/**
 * Thrown to indicate that the {@link com.mckinsey.academy.xblocks.callbacks.Callback}
 * passed to XBlock is not the matching one to {@link com.mckinsey.academy.xblocks.info.XBlockInfo}
 */
public class CallbackCastException extends ClassCastException {

    public CallbackCastException(String s) {
        super(s);
    }
}