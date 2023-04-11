package in.myinnos.indexfastscrollrecycler.adapter;

/**
 * Created by MyInnos on 01-02-2017.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import in.myinnos.indexfastscrollrecycler.Helpers;
import in.myinnos.indexfastscrollrecycler.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
        implements SectionIndexer {

    private List<String> mDataArray;

    private String mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
    private HashMap<Integer, Integer> sectionsTranslator = new HashMap<>();
    private ArrayList<Integer> mSectionPositions;

    public RecyclerViewAdapter(List<String> dataset) {
        mDataArray = dataset;
    }

    @Override
    public int getItemCount() {
        if (mDataArray == null)
            return 0;
        return mDataArray.size();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTextView.setText(mDataArray.get(position));
        holder.mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataArray.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    @Override
    public Object[] getSections() {
       /* List<String> sections = new ArrayList<>(26);
        mSectionPositions = new ArrayList<>(26);
        for (int i = 0, size = mDataArray.size(); i < size; i++) {
            String section = String.valueOf(mDataArray.get(i).charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                mSectionPositions.add(i);
            }
        } */

        List<String> sections = new ArrayList<>(27);
        ArrayList<String> alphabetFull = new ArrayList<>();

        mSectionPositions = new ArrayList<>();
        for (int i = 0, size = mDataArray.size(); i < size; i++) {
            String section = String.valueOf(mDataArray.get(i).charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                mSectionPositions.add(i);
            }
        }
        for (int i = 0; i < mSections.length(); i++) {
            alphabetFull.add(String.valueOf(mSections.charAt(i)));
        }

        sectionsTranslator = Helpers.Companion.sectionsHelper(sections, alphabetFull);



        return alphabetFull.toArray(new String[0]);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return mSectionPositions.get(sectionsTranslator.get(sectionIndex));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        //@BindView(R.id.tv_alphabet)
        TextView mTextView;
        //@BindView(R.id.ib_alphabet)
        ImageButton mImageButton;

        ViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            mTextView = itemView.findViewById(R.id.tv_alphabet);
            mImageButton = itemView.findViewById(R.id.ib_alphabet);
        }
    }

}