package `in`.myinnos.indexfastscrollrecycler


import `in`.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView
import `in`.myinnos.indexfastscrollrecycler.adapter.RecyclerViewAdapter
import `in`.myinnos.indexfastscrollrecycler.helper.DataHelper
import `in`.myinnos.indexfastscrollrecycler.utility.AlphabetItem
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    var mRecyclerView: IndexFastScrollRecyclerView? = null

    private val mAlphabetItems by lazy { ArrayList<AlphabetItem>() }

    // getAlphabetFullData() - full data, getAlphabetNotFullData() - not full data
    private val mDataArray by lazy { DataHelper.getAlphabetFullData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.fast_scroller_recycler)
        initialiseData()
        initialiseUI()
    }

    private fun initialiseData() {
        //Alphabet fast scroller data
        val strAlphabets: MutableList<String> = ArrayList()
        for (i in mDataArray.indices) {
            val name = mDataArray[i]
            if (name.trim { it <= ' ' }.isEmpty()) continue
            val word = name.substring(0, 1)
            if (!strAlphabets.contains(word)) {
                strAlphabets.add(word)
                mAlphabetItems.add(AlphabetItem(i, word, false))
            }
        }
    }

    private fun initialiseUI() {
        mRecyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(mDataArray)
            setIndexTextSize(12)
            setIndexBarColor("#33334c")
            setIndexBarCornerRadius(0)
            setIndexBarTransparentValue(0.4.toFloat())
            setIndexbarTopMargin(60f)
            setIndexbarBottomMargin(100f)
            setIndexbarHorizontalMargin(20f)
            setPreviewPadding(0)
            setIndexBarTextColor("#FFFFFF")
            setPreviewTextSize(60)
            setPreviewColor("#33334c")
            setPreviewTextColor("#FFFFFF")
            setPreviewTransparentValue(0.6f)
            setIndexBarVisibility(true)
            setIndexBarStrokeVisibility(true)
            setIndexBarStrokeWidth(1)
            setIndexBarStrokeColor("#000000")
            setIndexbarHighLightTextColor("#33334c")
            setIndexBarHighLightTextVisibility(true)
        }
        Objects.requireNonNull<RecyclerView.LayoutManager>(mRecyclerView?.layoutManager)
            .scrollToPosition(0)
    }
}