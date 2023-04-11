package in.myinnos.indexfastscrollrecycler.utility;

/**
 * Created by MyInnos on 01-02-2017.
 */

public class AlphabetItem {

    public int position;
    public String word;
    public boolean isActive;

    public AlphabetItem(int pos, String word, boolean isActive) {
        this.position = pos;
        this.word = word;
        this.isActive = isActive;
    }
}