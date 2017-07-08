package com.example.gadau.cardinventory.view;

import com.example.gadau.cardinventory.data.ListItem;

import java.util.List;

/**
 * Created by gadau on 7/7/2017.
 */

public interface ViewInterface {
    void startDetailActivity(ListItem listItem);
    void setUpAdapterAndView(List<ListItem> listOfData);
}
