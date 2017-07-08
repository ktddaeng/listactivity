package com.example.gadau.cardinventory.logic;

/**
 * Created by gadau on 7/7/2017.
 */

import com.example.gadau.cardinventory.data.DataSourceInterface;
import com.example.gadau.cardinventory.data.ListItem;
import com.example.gadau.cardinventory.view.ViewInterface;

public class ListController {
    private ViewInterface view;
    private DataSourceInterface dataSource;

    public ListController(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource(){
        view.setUpAdapterAndView(
                dataSource.getListofData()
        );
    }

    public void onItemClick(ListItem listItem){
        view.startDetailActivity(listItem);
    }
}
