# AlphabetIndex Fast Scroll RecyclerView
A Powerful AlphabetIndex FastScroller for Android's RecyclerView!

 ![AlphabetIndex-Fast-Scroll-RecyclerView - Example1](https://raw.githubusercontent.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/0d6c4f2f0b9f3b573a4f2abf2c87b62237081286/images-gif/AlphabetIndex-Fast-Scroll-RecyclerView_1.gif)
 `` `` `` `` `` `` `` ``
  ![AlphabetIndex-Fast-Scroll-RecyclerView - Example2](https://raw.githubusercontent.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/0d6c4f2f0b9f3b573a4f2abf2c87b62237081286/images-gif/AlphabetIndex-Fast-Scroll-RecyclerView_2.gif)
  `` `` `` `` `` `` `` ``
  ![AlphabetIndex-Fast-Scroll-RecyclerView - Example3](https://raw.githubusercontent.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/master/images-gif/AlphabetIndex-Fast-Scroll-RecyclerView_3.gif)
  
#### Kindly use the following links to use this library:

In build.gradle (Project)
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
```java
dependencies {
    // AppCompat version
    // compile 'com.github.myinnos:AlphabetIndex-Fast-Scroll-RecyclerView:1.0.92'
	
	// AndroidX version
	compile 'com.github.myinnos:AlphabetIndex-Fast-Scroll-RecyclerView:1.0.94'
}
```          
How to use
-----
**Step 1:** add this to your xml:
```xml
<in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView
    android:id="@+id/fast_scroller_recycler"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
**Step 2:** implement SectionIndexer to RecyclerViewAdapter.
```java
public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> implements SectionIndexer {

private List<String> mDataArray;
private ArrayList<Integer> mSectionPositions;
    
.....
    
@Override
public int getSectionForPosition(int position) {
    return 0;
}
 
@Override
public Object[] getSections() {
    List<String> sections = new ArrayList<>(26);
    mSectionPositions = new ArrayList<>(26);
    for (int i = 0, size = mDataArray.size(); i < size; i++) {
        String section = String.valueOf(mDataArray.get(i).charAt(0)).toUpperCase();
        if (!sections.contains(section)) {
            sections.add(section);
            mSectionPositions.add(i);
        }
    }
    return sections.toArray(new String[0]);
}
 
@Override
public int getPositionForSection(int sectionIndex) {
    return mSectionPositions.get(sectionIndex);
}
    
}
```
#### Note: mDataArray: this is your recycler data array model.

Features
-----
- Change IndexTextSize:
```java
 mRecyclerView.setIndexTextSize(12);
```
- Change IndexBarTextColor:
```java
 mRecyclerView.setIndexBarTextColor("#FFFFFF");

 mRecyclerView.setIndexBarTextColor(R.color.index_bar_text_color);
```
- Change IndexBarColor:
```java
 mRecyclerView.setIndexBarColor("#33334c");

 mRecyclerView.setIndexBarColor(R.color.index_bar_color);
```
- Change IndexBarCornerRadius:
```java
 mRecyclerView.setIndexBarCornerRadius(3);
```
- Change IndexBarTransparentValue:
```java
mRecyclerView.setIndexBarTransparentValue((float) 0.4);
```
- Change IndexbarMargin:
```java
 mRecyclerView.setIndexbarMargin(4);
```
- Change IndexbarWidth:
```java
 mRecyclerView.setIndexbarWidth(40);
```
- Change PreviewPadding:
```java
 mRecyclerView.setPreviewPadding(2);
```
- Change PreviewVisibility:
```java
 mRecyclerView.setPreviewVisibility(false);
```
- Change Typeface:
```java
 Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Custom-Font.ttf");
 mRecyclerView.setTypeface(typeface);
```
- To hide/show Fast Scroll IndexBar:
```java
mRecyclerView.setIndexBarVisibility(true);
```
- Change IndexBarHighLateTextColor:
```java
mRecyclerView.setIndexbarHighLateTextColor("#33334c);

mRecyclerView.setIndexbarHighLateTextColor(R.color.index_bar_highlight_text_color);
```
- To hide/show IndexBarHighLateText:
```java
mRecyclerView.setIndexBarHighLateTextVisibility(true);
```
Compatibility
-----
This library works with any layout manager but is optimized for the use with a LinearLayoutManager.

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")   

### Special Contributors
[@jonas-arkulpa](https://github.com/jonas-arkulpa "jonas-arkulpa")   
[@MFlisar](https://github.com/MFlisar "MFlisar")   
[@RaphaelMarion](https://github.com/RaphaelMarion "RaphaelMarion")   
[@appspell](https://github.com/appspell "appspell")   
[@Libernys](https://github.com/Libernys "Libernys")   

License
-------

    Copyright 2017 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
