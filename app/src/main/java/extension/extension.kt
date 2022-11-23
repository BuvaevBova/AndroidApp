package extension

import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(msg: String) {
    val toast: Toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.TOP, 0, 0)
    toast.show()
}