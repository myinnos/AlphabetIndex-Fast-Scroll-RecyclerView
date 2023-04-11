package `in`.myinnos.indexfastscrollrecycler.adapter

import `in`.myinnos.indexfastscrollrecycler.Helpers.Companion.sectionsHelper
import `in`.myinnos.indexfastscrollrecycler.R
import android.widget.SectionIndexer
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by MyInnos on 01-02-2017.
 */
class RecyclerViewAdapter(private val mDataArray: ArrayList<String>?) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), SectionIndexer {

    private val mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#"
    private var sectionsTranslator = HashMap<Int, Int>()
    private var mSectionPositions: ArrayList<Int>? = null

    override fun getItemCount(): Int {
        return mDataArray?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = mDataArray!![position]
        holder.mImageButton.setOnClickListener {
            mDataArray.removeAt(holder.adapterPosition)
            notifyDataSetChanged()
        }
    }

    override fun getSectionForPosition(position: Int): Int {
        return 0
    }

    override fun getSections(): Array<String> {
        /* List<String> sections = new ArrayList<>(26);
        mSectionPositions = new ArrayList<>(26);
        for (int i = 0, size = mDataArray.size(); i < size; i++) {
            String section = String.valueOf(mDataArray.get(i).charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                mSectionPositions.add(i);
            }
        } */
        val sections: MutableList<String> = ArrayList(27)
        val alphabetFull = ArrayList<String>()
        mSectionPositions = ArrayList()
        run {
            var i = 0
            val size = mDataArray!!.size
            while (i < size) {
                val section = mDataArray[i][0].toString().uppercase(Locale.getDefault())
                if (!sections.contains(section)) {
                    sections.add(section)
                    mSectionPositions?.add(i)
                }
                i++
            }
        }
        for (element in mSections) {
            alphabetFull.add(element.toString())
        }
        sectionsTranslator = sectionsHelper(sections, alphabetFull)
        return alphabetFull.toTypedArray()
    }

    override fun getPositionForSection(sectionIndex: Int): Int {
        return mSectionPositions!![sectionsTranslator[sectionIndex]!!]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView
        var mImageButton: ImageButton

        init {
            mTextView = itemView.findViewById(R.id.tv_alphabet)
            mImageButton = itemView.findViewById(R.id.ib_alphabet)
        }
    }
}