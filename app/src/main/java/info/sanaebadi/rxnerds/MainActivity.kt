package info.sanaebadi.rxnerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Student is Observer and Professor is Observable

        //Observable is for List of data


        val cold: Observable<Long> = Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
    }
}
