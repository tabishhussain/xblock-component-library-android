package com.mckinsey.academy.xblocks.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mckinsey.academy.xblocks.R;
import com.mckinsey.academy.xblocks.callbacks.Callback;
import com.mckinsey.academy.xblocks.callbacks.MCQXBlockCallback;
import com.mckinsey.academy.xblocks.info.MCQXBlockInfo;
import com.mckinsey.academy.xblocks.info.XBlockInfo;
import com.mckinsey.academy.xblocks.info.XBlockUserAnswer;
import com.mckinsey.academy.xblocks.listener.RecyclerViewItemSelectListener;
import com.mckinsey.academy.xblocks.model.MCQResult;
import com.mckinsey.academy.xblocks.model.OptionState;
import com.mckinsey.academy.xblocks.utils.XBlockUtils;
import com.mckinsey.academy.xblocks.view.adapters.MCQOptionsAdapter;
import com.mckinsey.academy.xblocks.view.adapters.MCQResultAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import static com.mckinsey.academy.xblocks.common.Constants.EXTRA_XBLOCK_INFO;

/**
 * Created by Tabish Hussain on 8/17/2017.
 */

public class MCQXBlockFragment extends LifecycleOwnerFragment
        implements RecyclerViewItemSelectListener, MCQXBlockCallback {

    private static final String TAG = VideoXBlockFragment.class.getSimpleName();
    private TextView questionTitle;
    private RecyclerView optionsList;
    private MCQOptionsAdapter mcqOptionsAdapter;
    private MCQXBlockInfo xBlockInfo;

    public static MCQXBlockFragment newInstance(XBlockInfo xBlockInfo) {
        MCQXBlockFragment fragment = new MCQXBlockFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_XBLOCK_INFO, xBlockInfo);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        xBlockInfo = (MCQXBlockInfo) args.getSerializable(EXTRA_XBLOCK_INFO);

        questionTitle.setText(XBlockUtils.getTextFromHTML(xBlockInfo.getQuestion()));
        mcqOptionsAdapter = new MCQOptionsAdapter();
        mcqOptionsAdapter.setItemSelectListener(this);
        int padding = (int) getResources().getDimension(R.dimen.option_list_padding);
        optionsList.setPadding(padding, padding, padding, padding);
        optionsList.setAdapter(mcqOptionsAdapter);
        mcqOptionsAdapter.setMultiSelectEnable(xBlockInfo.getMultiSelectEnable());
        mcqOptionsAdapter.setOptions(xBlockInfo.getOptions());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xblock_mcq, container, false);
        questionTitle = (TextView) view.findViewById(R.id.question_title);
        optionsList = (RecyclerView) view.findViewById(R.id.options_list);
        optionsList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void setCallback(Callback callback) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void onItemSelect(int position) {
        if (xBlockInfo.getMultiSelectEnable()) {
            xBlockInfo.getOptions().get(position).toggleState();
        } else {
            xBlockInfo.resetOptionState();
            xBlockInfo.getOptions().get(position).setOptionState(OptionState.SELECTED);
        }
        mcqOptionsAdapter.setOptions(xBlockInfo.getOptions());
    }

    /***
     * Receive results about the selected options i.e either the option is correct or incorrect
     * from the app using the XBlock
     * @param result SparseBooleanArray store result against the options position
     */
    @Override
    public void onReceiveResult(HashMap<Integer, MCQResult> result) {
        optionsList.setPadding(0, 0, 0, 0);
        MCQResultAdapter mcqResultAdapter = new MCQResultAdapter();
        mcqResultAdapter.setOptions(xBlockInfo.getOptions());
        mcqResultAdapter.setResult(result);
        optionsList.setAdapter(mcqResultAdapter);
    }

    /***
     * Call this function if the user wants to retry a question, it reset the options state to
     * UnSelected and update the adapter
     */
    @Override
    public void onRetry() {
        int padding = (int) getResources().getDimension(R.dimen.option_list_padding);
        optionsList.setPadding(padding, padding, padding, padding);
        mcqOptionsAdapter.setOptions(xBlockInfo.getOptions());
        xBlockInfo.resetOptionState();
        optionsList.setAdapter(mcqOptionsAdapter);
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onComplete() {

    }

    /***
     * Called by the parent activity or fragment in order to get the selected options
     * @return List of selected option's position wrapped inside {@link XBlockUserAnswer}
     */
    @Override
    public XBlockUserAnswer getUserAnswer() {
        XBlockUserAnswer<List<Integer>> xBlockUserAnswer = new XBlockUserAnswer<>();
        xBlockUserAnswer.setUserAnswer(xBlockInfo.getSelectedOptions());
        return xBlockUserAnswer;
    }
}
