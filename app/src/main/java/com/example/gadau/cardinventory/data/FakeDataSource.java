package com.example.gadau.cardinventory.data;

import com.example.gadau.cardinventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gadau on 7/7/2017.
 */

public class FakeDataSource implements DataSourceInterface {

    private static final int sizeOfCollection = 12;

    private final String[] cardIDs = {
            "17769", //birthday, friend, flowers
            "67328", //baby, birthday, teddybear
            "17110", //thankyou, bird, flowers
            "71449", //birthday, butterfly, flowers
    };

    private final int[] status = {
            R.color.GREEN,  //In Stock
            R.color.RED,    //Out of Stock
            R.color.YELLOW, //Retired
    };

    private final String vendor = "Gallant";

    private final String row[] ={"4", "12", "3", "7"};
    private final String col[] ={"A", "C", "T", "P"};

    private ArrayList<ArrayList<String>> tagLists = new ArrayList<ArrayList<String>>();

    @Override
    public List<ListItem> getListofData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        Random rand = new Random();

        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("birthday"); a1.add("friend"); a1.add("flowers");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("baby"); a2.add("birthday"); a2.add("teddybear");
        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("thankyou"); a3.add("bird"); a3.add("flowers");
        ArrayList<String> a4 = new ArrayList<String>();
        a4.add("birthday"); a4.add("butterfly"); a4.add("flowers");

        tagLists.add(a1);
        tagLists.add(a2);
        tagLists.add(a3);
        tagLists.add(a4);

        for (int i = 0; i < sizeOfCollection; i++){
            int randOne = rand.nextInt(3);
            int randTwo = rand.nextInt(3);
            int randThree = rand.nextInt(3);

            ListItem listItem = new ListItem(
                    cardIDs[randOne],
                    row[randTwo],
                    col[randThree],
                    vendor,
                    status[randThree],
                    tagLists.get(randOne)
            );

            listOfData.add(listItem);
        }

        return listOfData;

    }
}
