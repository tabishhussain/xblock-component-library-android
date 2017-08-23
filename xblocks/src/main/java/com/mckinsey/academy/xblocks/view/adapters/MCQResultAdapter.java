package com.mckinsey.academy.xblocks.view.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mckinsey.academy.xblocks.R;
import com.mckinsey.academy.xblocks.model.MCQOption;
import com.mckinsey.academy.xblocks.model.MCQResult;
import com.mckinsey.academy.xblocks.utils.XBlockUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tabish Hussain on 8/19/2017.
 */

public class MCQResultAdapter extends RecyclerView.Adapter<MCQResultAdapter.MCQResultViewHolder> {

    private HashMap<Integer, MCQResult> result;
    private List<MCQOption> options;
    private Context context;

    public void setResult(HashMap<Integer, MCQResult> result) {
        this.result = result;
    }

    public void setOptions(List<MCQOption> options) {
        this.options = options;
    }

    @Override
    public MCQResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MCQResultViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_mcq_option_result, parent, false));
    }

    @Override
    public void onBindViewHolder(MCQResultViewHolder holder, int position) {
        int optionIndex = new ArrayList<>(result.keySet()).get(position);
        MCQResult mcqResult = result.get(optionIndex);
        MCQOption option = options.get(optionIndex);
        holder.optionState.setImageResource(mcqResult.getIsCorrect() ?
                R.drawable.ic_status_correct :
                R.drawable.ic_status_incorrect);
        holder.optionText.setText(option.getContent());
        holder.resultReason.setText(XBlockUtils.getTextFromHTML(mcqResult.getMessage()));
        holder.resultReason.setTextColor(ContextCompat.getColor(context,
                mcqResult.getIsCorrect() ? R.color.color_right_answer_reason
                        : R.color.color_wrong_answer_reason));
        holder.reasonContainer.setBackgroundColor(ContextCompat.getColor(context,
                mcqResult.getIsCorrect() ? R.color.color_right_answer :
                        R.color.color_wrong_answer));
        holder.reasonIcon.setImageResource(mcqResult.getIsCorrect() ?
                R.drawable.ic_results_correct_green_18dp :
                R.drawable.ic_warning_red_18dp);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MCQResultViewHolder extends RecyclerView.ViewHolder {
        private final ImageView optionState;
        private final TextView optionText;
        private final LinearLayout reasonContainer;
        private final ImageView reasonIcon;
        private final TextView resultReason;

        MCQResultViewHolder(View itemView) {
            super(itemView);
            optionState = (ImageView) itemView.findViewById(R.id.option_state);
            optionText = (TextView) itemView.findViewById(R.id.option_text);
            resultReason = (TextView) itemView.findViewById(R.id.reason);
            reasonIcon = (ImageView) itemView.findViewById(R.id.reason_icon);
            reasonContainer = (LinearLayout) itemView.findViewById(R.id.reason_container);
        }
    }
}
