package in.autoboon.autoboon.fragments;

import android.support.v4.app.Fragment;

import in.autoboon.autoboon.helper.OnCallTwo;

public abstract class sFragment extends Fragment{
    public abstract void setCallTwo(OnCallTwo<Integer, sFragment> callTwo);
}
