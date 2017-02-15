# AlphabetIndex Fast Scroll RecyclerView
A Powerful AlphabetIndex FastScroller for Android's RecyclerView!

 ![AlphabetIndex-Fast-Scroll-RecyclerView - Example1](https://raw.githubusercontent.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/0d6c4f2f0b9f3b573a4f2abf2c87b62237081286/images-gif/AlphabetIndex-Fast-Scroll-RecyclerView_1.gif)
 `` `` `` `` `` `` `` ``
  ![AlphabetIndex-Fast-Scroll-RecyclerView - Example2](https://raw.githubusercontent.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/0d6c4f2f0b9f3b573a4f2abf2c87b62237081286/images-gif/AlphabetIndex-Fast-Scroll-RecyclerView_2.gif)
 
#### Kindly use the following links to use this library:

In build.gradle (Project)

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
	
	 dependencies {
	        compile 'com.github.myinnos:AlphabetIndex-Fast-Scroll-RecyclerView:1.0.1'
	        }
          
How to use
-----
**Step 1:** add this to your xml:

    <in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView
        android:id="@+id/fast_scroller_recycler"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

**Step 2:** implement SectionIndexer to RecyclerViewAdapter.

    public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> implements SectionIndexer {

     private List<String> mDataArray;
     private String mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    .....
    
     @Override
     public int getPositionForSection(int section) {
         // If there is no item for current section, previous section will be selected
         for (int i = section; i >= 0; i--) {
             for (int j = 0; j < getItemCount(); j++) {
                 if (i == 0) {
                     // For numeric section
                     for (int k = 0; k <= 9; k++) {
                         if (StringMatcher.match(String.valueOf(mDataArray.get(j).charAt(0)), String.valueOf(k)))
                             return j;
                     }
                 } else {
                     if (StringMatcher.match(String.valueOf(mDataArray.get(j).charAt(0)), String.valueOf(mSections.charAt(i))))
                         return j;
                 }
             }
         }
         return 0;
     }

     @Override
     public int getSectionForPosition(int position) {
         return 0;
     }

     @Override
     public Object[] getSections() {
         String[] sections = new String[mSections.length()];
         for (int i = 0; i < mSections.length(); i++)
             sections[i] = String.valueOf(mSections.charAt(i));
         return sections;
     }
    
    }

#### Note: mDataArray: this is your recycler data array model.

Feature
-----
- Change IndexTextSize:
```java
 mRecyclerView.setIndexTextSize(12);
```
- Change IndexBarTextColor:
```java
 mRecyclerView.setIndexBarTextColor("#FFFFFF");
```
- Change IndexBarColor:
```java
 mRecyclerView.setIndexBarColor("#33334c");
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
##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/AlphabetIndex-Fast-Scroll-RecyclerView/issues/new)!

## Contact
#### Prabhakar Thota
* Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* e-mail: contact@myinnos.in
* Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")         

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
