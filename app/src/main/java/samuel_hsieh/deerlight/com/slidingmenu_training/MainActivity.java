package samuel_hsieh.deerlight.com.slidingmenu_training;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    TextView title;
    List<NavItem> listNavItems;
    ArrayList<android.support.v4.app.Fragment> listFragments;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*** custom 寫action bar 主要修改成置中*/
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0x5C6BC000));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*** ------------------------------- */
        title = (TextView) findViewById(R.id.action_bar_title);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (ListView) findViewById(R.id.nav_list);
        listNavItems = new ArrayList<>();
        listNavItems.add(new NavItem("HOME", "HOME Page", R.drawable.ic_action_home, "#008800"));
        listNavItems.add(new NavItem("Setting", "Change something", R.drawable.ic_action_settings,"#00AA00"));
        listNavItems.add(new NavItem("About", "My information", R.drawable.ic_action_about , "#00DD00"));
        NavListAdater navListAdater = new NavListAdater(getApplicationContext(), R.layout.item_nv_list ,listNavItems);
        lvNav.setAdapter(navListAdater);
        listFragments = new ArrayList<>();
        listFragments.add(new MyHome());
        listFragments.add(new MySettings());
        listFragments.add(new MyAbout());
        // Load first fragment as default:
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content,listFragments.get(0)).commit();
        title.setText(listNavItems.get(0).getTitle());
        lvNav.setItemChecked(0, true); //預設listView選中的項目
        drawerLayout.closeDrawer(drawerPane); //預設關閉左側選單
        //set listener fot navigation items
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //replace the fragment with the selection correspondingly
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_content, listFragments.get(position))
                        .commit();
                title.setText(listNavItems.get(position).getTitle());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });

        //create listener for drawer layout
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout
                ,R.string.drawer_opened,R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); //更新menu
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
