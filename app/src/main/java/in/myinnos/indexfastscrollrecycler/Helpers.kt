package `in`.myinnos.indexfastscrollrecycler

import java.util.ArrayList
import java.util.HashMap

class Helpers {
    companion object {
        fun sectionsHelper(sections: MutableList<String>, test: ArrayList<String>): HashMap<Int, Int> {
            val mapOfSections = hashMapOf<Int, Int>()
            var lastFound = 0
            test.forEachIndexed { index, s ->
                if (sections.any { it == s }) {
                    val value = sections.indexOfFirst { it == s }
                    mapOfSections[index] = value
                    lastFound = value
                } else {
                    mapOfSections[index] = lastFound
                }
            }
            return mapOfSections
        }
    }
}