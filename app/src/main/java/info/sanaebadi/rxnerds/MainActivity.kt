package info.sanaebadi.rxnerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Student is Observer and Professor is Observable

        //Observable is for List of data

        //Cold Observable

        val cold: Observable<Long> = Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
        cold.subscribe {
            Log.i(TAG, "Student 1 is : " + it)

        }

        Thread.sleep(3000)

        cold.subscribe {
            Log.i(TAG, "Student 2 is : " + it)

        }


        val hot: ConnectableObservable<Long> =
            ConnectableObservable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS).publish()
        hot.connect()


        hot.subscribe {
            Log.i(TAG, "Student 1 is : " + it)

        }

        Thread.sleep(3000)

        hot.subscribe {
            Log.i(TAG, "Student 2 is : " + it)

        }
    }

}
