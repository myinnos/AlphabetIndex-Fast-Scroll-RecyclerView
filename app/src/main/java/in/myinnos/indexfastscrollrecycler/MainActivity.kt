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
            setIndexBarColor(R.color.color_setIndexBarColor)
            setIndexBarCornerRadius(0)
            setIndexBarTransparentValue(0.4.toFloat())
            setIndexBarTopMargin(60f)
            setIndexBarBottomMargin(100f)
            setIndexBarHorizontalMargin(20f)
            setPreviewPadding(0)
            setIndexBarTextColor(R.color.color_setIndexBarTextColor)
            setPreviewTextSize(60)
            setPreviewColor(R.color.color_setPreviewColor)
            setPreviewTextColor(R.color.color_setPreviewTextColor)
            setPreviewTransparentValue(0.6f)
            setIndexBarVisibility(true)
            setIndexBarStrokeVisibility(true)
            setIndexBarStrokeWidth(1)
            setIndexBarStrokeColor(R.color.color_setIndexBarStrokeColor)
            setIndexBarHighLightTextColor(R.color.color_setIndexBarHighLightTextColor)
            setIndexBarHighLightTextVisibility(true)
        }
        Objects.requireNonNull<RecyclerView.LayoutManager>(mRecyclerView?.layoutManager)
            .scrollToPosition(0)
    }
}