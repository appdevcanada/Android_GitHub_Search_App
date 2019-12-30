package clauber.luis

import android.text.InputFilter
import android.text.Spanned

/*
* Created by Clauber Ferreira on December 02, 2019
* Created by Luis Souza on December 02, 2019
*/
class InputFilterMinMax(min: Int, max: Int) : InputFilter {
    private var min: Int = 0
    private var max: Int = 0

    init {
        this.min = min
        this.max = max
    }

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        destination: Spanned,
        destinationStart: Int,
        destinationEnd: Int
    ): CharSequence? {
        try {
            val input = (destination.subSequence(0, destinationStart).toString() + source +
                    destination.subSequence(destinationEnd, destination.length)).toInt()
            if (isInRange(min, max, input)) {
                return null
            }
        } catch (ex: NumberFormatException) {
            // just ignore the exception
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}