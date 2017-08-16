package com.mckinsey.academy.xblocks.exception;

/**
 * Thrown when an {@link com.mckinsey.academy.xblocks.info.XBlockInfoBuilder} tries to create an
 * instance of a {@link com.mckinsey.academy.xblocks.info.XBlockInfo}
 * using the {@code newInstance} method in class
 * {@code Class}, but the specified class object cannot be instantiated.
 */
public class InstantiationException extends RuntimeException {

    public InstantiationException(String message) {
        super(message);
    }
}
