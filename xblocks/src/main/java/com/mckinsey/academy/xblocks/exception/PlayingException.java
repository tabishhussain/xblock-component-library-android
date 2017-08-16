package com.mckinsey.academy.xblocks.exception;

/**
 * Thrown by player when exception occurred during playing of video
 */
public class PlayingException extends Exception {

    public PlayingException(String message, Throwable cause) {
        super(message, cause);
    }
}
