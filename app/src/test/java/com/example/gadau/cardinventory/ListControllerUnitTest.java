package com.example.gadau.cardinventory;

import com.example.gadau.cardinventory.data.DataSourceInterface;
import com.example.gadau.cardinventory.data.ListItem;
import com.example.gadau.cardinventory.logic.ListController;
import com.example.gadau.cardinventory.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ListControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;
    @Mock
    ViewInterface view;

    private ListController listController;
    private ArrayList<String> ga = new ArrayList<String>(Arrays.asList("xyz", "abc"));

    private ListItem testItem = new ListItem("A",
        "B", "C", "D", 1, ga);

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        listController = new ListController(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() {
        //Set up any data we need for the Test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //Set up Mocks to return the Data we want
        Mockito.when(dataSource.getListofData())
                .thenReturn(listOfData);

        //Call the method(Unit) we are testing
        listController.getListFromDataSource();

        //Check how the Tested Class responds to the data it receives
        //or test its behavior
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        listController.onItemClick(testItem);
        Mockito.verify(view).startDetailActivity(testItem);
    }
}