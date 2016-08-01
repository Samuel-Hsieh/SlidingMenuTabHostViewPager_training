package samuel_hsieh.deerlight.com.slidingmenu_training;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by samuel_hsieh on 15/9/21.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentlists;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentlists) {
        super(fm);
        this.fragmentlists = fragmentlists;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlists.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlists.size();
    }
}
