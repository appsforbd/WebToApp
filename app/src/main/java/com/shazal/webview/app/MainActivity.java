package com.shazal.webview.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shazal.webview.app.adapter.PageAdapter;
import com.shazal.webview.app.listener.ListItemClickListener;
import com.shazal.webview.app.model.PageItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AppConstant {

    private AppCompatActivity mActivity;
    private Context mContext;

    private List<PageItem> pageItems;
    private PageAdapter pageAdapter;
    private RecyclerView rvMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = MainActivity.this;
        mContext = mActivity.getApplicationContext();

        rvMenuItems = (RecyclerView) findViewById(R.id.rvMenuItem);

        createMenu();

        pageAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                final PageItem pageItem = pageItems.get(position);
                switch (view.getId()) {
                    case R.id.pageItem:
                        Intent intent = new Intent(mContext, WebViewActivity.class);
                        intent.putExtra("title", pageItem.getPageTitle());
                        intent.putExtra("url", pageItem.getPageLink());
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void createMenu() {
        setupData();
        rvMenuItems.setHasFixedSize(true);
        rvMenuItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pageAdapter = new PageAdapter(MainActivity.this, (ArrayList<PageItem>) pageItems);
        rvMenuItems.setAdapter(pageAdapter);
    }

    private void setupData() {
        pageItems = new ArrayList<>();
        pageItems.add(new PageItem("1", "প্রথম অধ্যায়", pageIndex, R.drawable.ic_point));
        pageItems.add(new PageItem("2", "দ্বিতীয় অধ্যায়", pageIndex, R.drawable.ic_point));
        pageItems.add(new PageItem("3", "তৃতীয় অধ্যায়", "", R.drawable.ic_point));
        pageItems.add(new PageItem("4", "চতুর্থ অধ্যায়", "", R.drawable.ic_point));
        pageItems.add(new PageItem("5", "প্রঞ্চম অধ্যায়", "", R.drawable.ic_point));
    }
}
