package com.example.a15056112.p10_knowyourfacts;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.crazyhitty.chdev.ks.rssmanager.Channel;
import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag4 extends Fragment implements RssReader.RssCallback {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    private RssReader rssReader = new RssReader(this);

    public Frag4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag4, container, false);
        String[] url = new String[]{"https://www.gov.sg/rss/factuallyrss"};
        rssReader.loadFeeds(url);
        lv = (ListView)view.findViewById(R.id.lv);

        return view;
    }

    private void loadFeeds(String[] urls) {
        rssReader.loadFeeds(urls);
    }

    @Override
    public void rssFeedsLoaded(final List<RSS> rssList) {
        al = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
        for(Channel.Item i : rssList.get(0).getChannel().getItems()){
            al.add(i.getTitle());
        }

        aa.notifyDataSetChanged();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String urls = rssList.get(0).getChannel().getItems().get(position).getLink();
                intent.setData(Uri.parse(urls));
                startActivity(intent);
            }
        });
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {

    }
}
