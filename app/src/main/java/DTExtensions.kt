import android.app.Activity
import com.dagger.test.DTApplication

fun Activity.coreComponent() = DTApplication.coreComponent(this)