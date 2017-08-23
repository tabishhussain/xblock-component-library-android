package com.mckinsey.academy.xblocks.info;

/**
 * Factory class for creating XBlockInfo Builders.
 */
public class XBlockInfoBuilder {

    public static VideoXBlockInfoBuilder buildVideoXBlockInfo() {
        return new VideoXBlockInfoBuilder();
    }

    public static MCQXBlockInfoBuilder buildMCQXBlockInfo() {
        return new MCQXBlockInfoBuilder();
    }
}
