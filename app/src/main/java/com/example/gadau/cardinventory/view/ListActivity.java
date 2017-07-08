package com.example.gadau.cardinventory.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gadau.cardinventory.R;
import com.example.gadau.cardinventory.data.FakeDataSource;
import com.example.gadau.cardinventory.data.ListItem;
import com.example.gadau.cardinventory.logic.ListController;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface{
    private static final String EXTRA_LIST_ITEM = "EXTRA_LIST_ITEM";

    private RecyclerView recyclerView;
    private LayoutInflater layoutInflater;
    private CustomAdapter adapter;

    private List<ListItem> listOfData;

    private ListController listController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        listController = new ListController(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(ListItem listItem) {
        //TODO: Pull up Comprehesive View
        Intent i = new Intent(this, DetailsActivity.class);

        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);

            //set status circle color
            //((GradientDrawable)holder.coloredCircle.getBackground()).setColor(currentItem.getStatus());
            holder.coloredCircle.setBackgroundResource(currentItem.getStatus());

            //set text
            holder.itemID.setText("#" + currentItem.getCardID());
            holder.itemPosition.setText(currentItem.getColumn() + currentItem.getRow());
            holder.itemVendor.setText(currentItem.getVendor());

            //set tags
            //TODO: make proper tag list later
            ArrayList<String> tags = currentItem.getTagList();
            String taglist = "";
            StringBuffer sb = new StringBuffer(taglist);
            for (int i = 0; i < tags.size(); i++){
                String s = tags.get(i);
                sb.append(s);
                if (i != tags.size()-1){
                    sb.append(", ");
                }
            }
            taglist = sb.toString();
            holder.tagList.setText(taglist);
        }

        @Override
        public int getItemCount() { return listOfData.size(); }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ImageView coloredCircle;
            private TextView itemID;
            private TextView itemVendor;
            private TextView itemPosition;
            //TODO: Make actual Tag List
            private TextView tagList;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = (ImageView) itemView.findViewById(R.id.imv_list_item_circle);
                //this.coloredCircle = (ImageView)itemView.findViewById(R.id.imv_list_item_circle);
                this.itemID = (TextView) itemView.findViewById(R.id.lbl_item_id);
                this.itemVendor = (TextView) itemView.findViewById(R.id.lbl_item_vendor);
                this.itemPosition = (TextView) itemView.findViewById(R.id.lbl_item_position);
                this.tagList = (TextView) itemView.findViewById(R.id.tags_list);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(this.getAdapterPosition());

                listController.onItemClick(listItem);
            }
        }
    }
}
