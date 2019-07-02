package in.autoboon.autoboon.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import in.autoboon.autoboon.AutoboonApp;
import in.autoboon.autoboon.R;
import in.autoboon.autoboon.helper.OnCallTwo;

public class UserProfile extends sFragment {
    private OnCallTwo<Integer, sFragment> callTwo;
    private View mView;

    @Inject
    AutoboonApp autoboonApp;

    @Override
    public void setCallTwo(OnCallTwo<Integer, sFragment> callTwo) {
       this.callTwo=callTwo;
    }

    @Override
    public void onAttach(Context context) {
        ((AutoboonApp)context.getApplicationContext()).getAppComponentDagger().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView=view;
        setUpUI();
    }

    private void setUpUI() {
        //mView.findViewById(R.id.sv_home).setActivated(false);
    }
}
