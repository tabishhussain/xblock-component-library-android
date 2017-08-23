package com.mckinsey.academy.xblocks.model;

/**
 * Created by Tabish Hussain on 8/23/2017.
 */

public class MCQResult {

    private boolean isCorrect;
    private String message;

    public MCQResult(boolean isCorrect, String message) {
        this.isCorrect = isCorrect;
        this.message = message;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
