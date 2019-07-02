package in.autoboon.autoboon.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.autoboon.autoboon.AutoboonApp;
import in.autoboon.autoboon.R;
import in.autoboon.autoboon.helper.OnCallTwo;

public class Home extends sFragment {
    private OnCallTwo<Integer, sFragment> callTwo;
    private View mView;

    @Override
    public void setCallTwo(OnCallTwo<Integer, sFragment> callTwo) {
        this.callTwo=callTwo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onAttach(Context context) {
        ((AutoboonApp)context.getApplicationContext()).getAppComponentDagger().inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView=view;
        setUpUI();
    }

    private void setUpUI() {
//        SearchView searchView=mView.findViewById(R.id.sv_home);
//        searchView.clearFocus();
//        CardView cardView=mView.findViewById(R.id.cv_title_1_home);
//        cardView.requestFocus();
    }

    private void callBackPress() {
        Activity activity=getActivity();
        if(activity!=null) {
            activity.onBackPressed();
        }
    }
}
