package com.mckinsey.academy.xblocks.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mckinsey.academy.xblocks.R;
import com.mckinsey.academy.xblocks.listener.RecyclerViewItemSelectListener;
import com.mckinsey.academy.xblocks.model.MCQOption;
import com.mckinsey.academy.xblocks.utils.XBlockUtils;

import java.util.List;

/**
 * Created by Tabish Hussain on 8/17/2017.
 */

public class MCQOptionsAdapter extends
        RecyclerView.Adapter<MCQOptionsAdapter.MCQOptionsViewHolder> {

    private List<MCQOption> options;
    private RecyclerViewItemSelectListener itemSelectListener;
    private boolean multiSelectEnable = false;

    public void setItemSelectListener(RecyclerViewItemSelectListener itemSelectListener) {
        this.itemSelectListener = itemSelectListener;
    }

    public void setOptions(List<MCQOption> options) {
        this.options = options;
        notifyDataSetChanged();
    }

    public void setMultiSelectEnable(boolean multiSelectEnable) {
        this.multiSelectEnable = multiSelectEnable;
    }

    @Override
    public MCQOptionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MCQOptionsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_mcq_option, parent, false));
    }

    @Override
    public void onBindViewHolder(final MCQOptionsViewHolder holder, int position) {
        MCQOption mcqOption = options.get(position);
        holder.optionText.setText(XBlockUtils.getTextFromHTML(mcqOption.getContent()));
        updateOptionState(holder, mcqOption);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelectListener.onItemSelect(holder.getAdapterPosition());
            }
        });
    }

    private void updateOptionState(MCQOptionsViewHolder holder, MCQOption mcqOption) {
        int resourceId = R.drawable.option_state_unselected;
        switch (mcqOption.getOptionState()) {
            case UNSELECTED:
                resourceId = multiSelectEnable ? R.drawable.ic_checkbox_inactive_32dp :
                        R.drawable.ic_radio_inactive_32dp;
                break;
            case SELECTED:
                resourceId = multiSelectEnable ? R.drawable.ic_checkbox_active_32dp :
                        R.drawable.ic_radio_active_32dp;
                break;
        }
        holder.optionState.setImageResource(resourceId);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    class MCQOptionsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView optionState;
        private final TextView optionText;

        MCQOptionsViewHolder(View view) {
            super(view);
            optionState = (ImageView) view.findViewById(R.id.option_state);
            optionText = (TextView) view.findViewById(R.id.option_text);
        }
    }
}
