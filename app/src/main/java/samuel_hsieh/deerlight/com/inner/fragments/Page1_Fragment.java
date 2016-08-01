package samuel_hsieh.deerlight.com.inner.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import samuel_hsieh.deerlight.com.slidingmenu_training.R;

public class Page1_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page1_fragment, container, false);
        return v;
    }

}
