package com.mckinsey.academy.xblocks.callbacks;

import com.mckinsey.academy.xblocks.info.XBlockUserAnswer;

/**
 * Interface to be implemented by the XBlock components to return user answer
 */

public interface XBlockComponentFragment {

    public XBlockUserAnswer getUserAnswer();

}
