package com.mckinsey.academy.xblocks.info;

import android.support.v4.app.Fragment;

import com.mckinsey.academy.xblocks.callbacks.Callback;
import com.mckinsey.academy.xblocks.model.MCQOption;
import com.mckinsey.academy.xblocks.model.OptionState;
import com.mckinsey.academy.xblocks.view.MCQXBlockFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tabish Hussain on 8/17/2017.
 */

public class MCQXBlockInfo extends XBlockInfo {

    private String question;
    private List<MCQOption> options;
    private Boolean multiSelectEnable;

    /*
    * This constructor is not public, so Doc comment is not added.
    * The parameter question is name of the title of the question component
    * which will appear in the sub menu.
    * The parameter options is the list of the possible options of the question.
    */
    MCQXBlockInfo(String title, String details, String question, List<MCQOption> options,
                  boolean multiSelectEnable) {
        super(title, details);
        this.question = question;
        this.options = options;
        this.multiSelectEnable = multiSelectEnable;
    }

    public String getQuestion() {
        return question;
    }

    public List<MCQOption> getOptions() {
        return options;
    }

    public Boolean getMultiSelectEnable() {
        return multiSelectEnable;
    }

    @Override
    public Fragment getViewComponent(Callback callback) {
        MCQXBlockFragment fragment = MCQXBlockFragment.newInstance(this);
        if (callback != null) {
            fragment.setCallback(callback);
        }
        return fragment;
    }

    /***
     * Filter out the options who's status is {@link OptionState} is SELECTED
     * @return return the list of the Selected Options
     */
    public List<Integer> getSelectedOptions() {
        List<Integer> selectedOptions = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getOptionState() == OptionState.SELECTED) {
                selectedOptions.add(i);
            }
        }
        return selectedOptions;
    }

    /***
     * Reset the state of the options to {@link OptionState} UNSELECTED to retry the question
     */
    public void resetOptionState() {
        for (MCQOption option : options) {
            option.setOptionState(OptionState.UNSELECTED);
        }
    }

    @Override
    public Fragment getViewComponent() {
        return getViewComponent(null);
    }
}
