package in.myinnos.indexfastscrollrecycler;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;
import in.myinnos.indexfastscrollrecycler.adapter.RecyclerViewAdapter;
import in.myinnos.indexfastscrollrecycler.helper.DataHelper;
import in.myinnos.indexfastscrollrecycler.helper.NotFullDataHelper;
import in.myinnos.indexfastscrollrecycler.utility.AlphabetItem;

public class MainActivity extends AppCompatActivity
{

    //@BindView(R.id.fast_scroller_recycler)
    IndexFastScrollRecyclerView mRecyclerView;

    private List<String> mDataArray;
    private List<AlphabetItem> mAlphabetItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);

        mRecyclerView = findViewById(R.id.fast_scroller_recycler);

        initialiseData();
        initialiseUI();
    }

    protected void initialiseData() {

        //Recycler view full data
        //mDataArray = DataHelper.getAlphabetData();

        //Recycler view not full data
        mDataArray = NotFullDataHelper.getAlphabetNotFullData();


       // 123
        //Alphabet fast scroller data
        mAlphabetItems = new ArrayList<>();
        List<String> strAlphabets = new ArrayList<>();
        for (int i = 0; i < mDataArray.size(); i++) {
            String name = mDataArray.get(i);
            if (name == null || name.trim().isEmpty())
                continue;

            String word = name.substring(0, 1);
            if (!strAlphabets.contains(word)) {
                strAlphabets.add(word);
                mAlphabetItems.add(new AlphabetItem(i, word, false));
            }
        }
    }

    protected void initialiseUI() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(mDataArray));

        mRecyclerView.setIndexTextSize(12);
        mRecyclerView.setIndexBarColor("#33334c");
        mRecyclerView.setIndexBarCornerRadius(0);
        mRecyclerView.setIndexBarTransparentValue((float) 0.4);
        mRecyclerView.setIndexbarMargin(0);
        mRecyclerView.setIndexbarWidth(40);
        mRecyclerView.setPreviewPadding(0);
        mRecyclerView.setIndexBarTextColor("#FFFFFF");

        mRecyclerView.setPreviewTextSize(60);
        mRecyclerView.setPreviewColor("#33334c");
        mRecyclerView.setPreviewTextColor("#FFFFFF");
        mRecyclerView.setPreviewTransparentValue(0.6f);

        mRecyclerView.setIndexBarVisibility(true);
        mRecyclerView.setIndexbarHighLateTextColor("#33334c");
        mRecyclerView.setIndexBarHighLateTextVisibility(true);
    }
}