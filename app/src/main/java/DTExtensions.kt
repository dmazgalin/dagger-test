import android.app.Activity
import com.dagger.test.DTApplication

fun Activity.coreComponent() = DTApplication.coreComponent(this)
fun Activity.appComponent() = DTApplication.appComponent(this)