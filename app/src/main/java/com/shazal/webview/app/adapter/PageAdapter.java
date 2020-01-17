package com.shazal.webview.app.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shazal.webview.app.R;
import com.shazal.webview.app.listener.ListItemClickListener;
import com.shazal.webview.app.model.PageItem;

import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHolder> {

    private ArrayList<PageItem> pageItems;
    private Context context;
    private ListItemClickListener itemClickListener;

    public PageAdapter(Context context, ArrayList<PageItem> pageItems) {
        this.context = context;
        this.pageItems = pageItems;
    }

    public void setItemClickListener(ListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new ViewHolder(view, viewType, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return (null != pageItems ? pageItems.size() : 0);
    }

    @Override
    public void onBindViewHolder(PageAdapter.ViewHolder mainHolder, int position) {
        final PageItem pageItem = pageItems.get(position);

        // setting data over views
        mainHolder.menuTitle.setText(Html.fromHtml(pageItem.getPageTitle()));
        mainHolder.menuIcon.setImageResource(pageItem.getPageIcon());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout llMenuItem;
        TextView menuTitle;
        ImageView menuIcon;

        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;

            // Find all view ids
            this.llMenuItem = itemView.findViewById(R.id.pageItem);
            this.menuTitle = itemView.findViewById(R.id.title);
            this.menuIcon = itemView.findViewById(R.id.icon);

            // Implement click listener over views
            llMenuItem.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}
