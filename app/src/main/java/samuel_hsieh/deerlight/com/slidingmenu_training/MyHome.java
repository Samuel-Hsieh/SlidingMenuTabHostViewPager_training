package samuel_hsieh.deerlight.com.slidingmenu_training;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import java.util.ArrayList;
import java.util.List;
import samuel_hsieh.deerlight.com.inner.fragments.Page1_Fragment;
import samuel_hsieh.deerlight.com.inner.fragments.Page2_Fragment;
import samuel_hsieh.deerlight.com.inner.fragments.Page3_Fragment;


/**
 * Created by samuel_hsieh on 15/9/22.
 */
public class MyHome extends Fragment implements ViewPager.OnPageChangeListener
        ,TabHost.OnTabChangeListener{
    private ViewPager mViewPager;
    private TabHost tabHost;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    int i = 0;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tabs_viewpager_layout,container,false);
        // We put TabHostView here:
        /*part1************************************************************************************/
        initViewPager();
        initTabHost();
        /*part1************************************************************************************/
        return v;
    }
    public class FakeContent implements TabHost.TabContentFactory{

        Context context;
        public FakeContent(Context context){
            this.context = context;
        }
        @Override
        public View createTabContent(String tag) {
            View fakeview = new View(context);
            fakeview.setMinimumHeight(0);
            fakeview.setMinimumWidth(0);
            return fakeview;
        }
    }
    private void initTabHost() {
        tabHost = (TabHost) v.findViewById(R.id.tabHost);
        tabHost.setup();
        final String[] tabNames = {"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6"};
        for(i = 0;i<tabNames.length;i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);
    }

    private void initViewPager() {
        List<Fragment> fragmentLists = new ArrayList<>();
        fragmentLists.add(new Page1_Fragment());
        fragmentLists.add(new Page2_Fragment());
        fragmentLists.add(new Page3_Fragment());
        fragmentLists.add(new Page1_Fragment());
        fragmentLists.add(new Page2_Fragment());
        fragmentLists.add(new Page3_Fragment());
        this.myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(),fragmentLists);
        this.mViewPager = (ViewPager) v.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.myFragmentPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this); //replace setOnPageChangeListener with this method
    }
    /*Tab Listener*/
    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        mViewPager.setCurrentItem(selectedItem);
        HorizontalScrollView HscrollView = (HorizontalScrollView) v.findViewById(R.id.HscrollView);
        View tabView = tabHost.getCurrentTabView();
        int scorllPos = tabView.getLeft() - (HscrollView.getWidth() - tabView.getWidth()) / 2;
        HscrollView.smoothScrollTo(scorllPos, 0);
        /*Log.i("tabView.getLeft()","tabView.getLeft() = "+tabView.getLeft()); //當前tab左邊多長
        Log.i("HscrollView.getWidth()","HscrollView.getWidth() = "+HscrollView.getWidth()); //螢幕內scroll呈現的寬度
        Log.i("tabView.getWidth()","tabView.getWidth() = "+tabView.getWidth()); //tab按鈕的寬度
        Log.i("Hscroll-tabView","Hscroll-tabView = "+(HscrollView.getWidth() - tabView.getWidth())); //scroll呈現的寬度扣掉按鈕長度
        Log.i("scorllPos","scrollPos = "+scorllPos); //距離預設中心的位置 */
    }
    /*ViewPager Listener*/
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int selectedItem = mViewPager.getCurrentItem();
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageSelected(int selectedItem) {
        mViewPager.setCurrentItem(selectedItem);
    }
}

