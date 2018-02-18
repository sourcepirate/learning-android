package news.rss.org.rssfeed;

import android.app.ListFragment;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * Created by plasmashadow on 2/15/18.
 */

public class RSSListFragment extends ListFragment implements OnItemClickListener {
    // to be don

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.rss_feeds, android.R.layout.simple_list_item_1);
        this.setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Resources resource = getResources();
        String array[] = resource.getStringArray(R.array.rss_feeds);
        Toast.makeText(getActivity(), array[i], Toast.LENGTH_SHORT).show();
    }
}
