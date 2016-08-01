package samuel_hsieh.deerlight.com.slidingmenu_training;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by samuel_hsieh on 15/9/22.
 */
public class NavListAdater extends ArrayAdapter<NavItem> {

    Context context;
    int resLayout;
    List<NavItem> listNavItem;

    public NavListAdater(Context context, int resLayout, List<NavItem> listNavItem) {
        super(context, resLayout, listNavItem);
        this.context = context;
        this.resLayout = resLayout;
        this.listNavItem = listNavItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout , null);
        TextView tvTitle = (TextView) v.findViewById(R.id.title);
        TextView tvSubtitle = (TextView) v.findViewById(R.id.subtitle);
        ImageView navIcon = (ImageView) v.findViewById(R.id.nac_icon);
        LinearLayout list_layout = (LinearLayout) v.findViewById(R.id.list_layout);

        NavItem navItem = listNavItem.get(position);
        tvTitle.setText(navItem.getTitle());
        tvSubtitle.setText(navItem.getSubtitle());
        navIcon.setImageResource(navItem.getResIcon());
        list_layout.setBackgroundColor(Color.parseColor(navItem.getColor()));

        return v;
    }
}
