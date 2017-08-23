package com.mckinsey.academy.xblocks.info;

import com.mckinsey.academy.xblocks.exception.InstantiationException;
import com.mckinsey.academy.xblocks.model.MCQOption;

import java.util.List;

/**
 * MCQXBlockInfo contains all the information required for MCQXBlockComponent. Use
 * {@link MCQXBlockInfoBuilder} to create object of MCQXBlockInfo.
 */
public class MCQXBlockInfoBuilder {

    private String title;
    private String details;
    private String question;
    private List<MCQOption> options;
    private boolean multiSelectEnable = false;

    /**
     * Set name of the video component here, which will appear below video player.
     *
     * @param title name of the video component.
     * @return MCQXBlockInfoBuilder
     */
    public MCQXBlockInfoBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set details of the video component here, which will appear below title(below video player).
     *
     * @param details description of the video component.
     * @return MCQXBlockInfoBuilder
     */
    public MCQXBlockInfoBuilder setDetails(String details) {
        this.details = details;
        return this;
    }

    public MCQXBlockInfoBuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public MCQXBlockInfoBuilder setOptions(List<MCQOption> options) {
        this.options = options;
        return this;
    }

    public MCQXBlockInfoBuilder setMultiSelectEnable(boolean multiSelectEnable) {
        this.multiSelectEnable = multiSelectEnable;
        return this;
    }

    public XBlockInfo build() {
        if (question == null) {
            throw new InstantiationException("Question has not been set");
        }
        if (options == null) {
            throw new InstantiationException("Options has not been set");
        }
        if (options.size() == 0) {
            throw new InstantiationException("Options are not available");
        }
        return new MCQXBlockInfo(title, details, question, options, multiSelectEnable);
    }
}
