package com.mckinsey.academy.xblocks.model;

import java.io.Serializable;

/**
 * Created by Tabish Hussain on 8/18/2017.
 */

public class MCQOption implements Serializable {

    private String content;
    private String value;
    private OptionState optionState;

    public MCQOption() {
        optionState = OptionState.UNSELECTED;
    }

    public MCQOption(String content, String value) {
        this.content = content;
        this.value = value;
        this.optionState = OptionState.UNSELECTED;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OptionState getOptionState() {
        return optionState;
    }

    public void setOptionState(OptionState optionState) {
        this.optionState = optionState;
    }

    public void toggleState() {
        optionState = optionState == OptionState.SELECTED
                ? OptionState.UNSELECTED : OptionState.SELECTED;
    }
}
