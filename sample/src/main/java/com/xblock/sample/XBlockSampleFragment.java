package com.xblock.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mckinsey.academy.xblocks.XBlock;
import com.mckinsey.academy.xblocks.info.XBlockInfo;
import com.mckinsey.academy.xblocks.info.XBlockInfoBuilder;


/**
 * This fragment demonstrate the use of Video XBlock component.
 *
 * See onActivityCreated method for XBlock code.
 *
 */
public class XBlockSampleFragment extends Fragment {

    private static final String ARG_PCODE = "pcode";
    private static final String ARG_EMBED_ID = "embed_id";
    private static final String ARG_DOMAIN = "domain";

    private static final String TITLE = "Video XBlock Example";

    private String pcode;
    private String embedId;
    private String domain;


    public XBlockSampleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pcode Parameter 1.
     * @param embedId Parameter 2.
     * @param domain
     * @return A new instance of fragment XBlockSampleFragment.
     */
    public static XBlockSampleFragment newInstance(String pcode, String embedId, String domain) {
        XBlockSampleFragment fragment = new XBlockSampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PCODE, pcode);
        args.putString(ARG_EMBED_ID, embedId);
        args.putString(ARG_DOMAIN, domain);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pcode = getArguments().getString(ARG_PCODE);
            embedId = getArguments().getString(ARG_EMBED_ID);
            domain = getArguments().getString(ARG_DOMAIN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xblock_sample, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //XBlock integration code is here
        XBlockInfo xBlockInfo = XBlockInfoBuilder.buildVideoXBlockInfo()
                .setTitle(TITLE)
                .setPcode(pcode)
                .setEmbedId(embedId)
                .setDomain(domain).build();

        final XBlock xBlock = XBlock.with(getChildFragmentManager(), R.id.xblock_container, xBlockInfo);
        xBlock.injectXBlock();
    }
}
