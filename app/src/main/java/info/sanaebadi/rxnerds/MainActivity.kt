package info.sanaebadi.rxnerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
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
            //  Log.i(TAG, "Student 1 is : " + it)

        }

        Thread.sleep(3000)

        cold.subscribe {
            //   Log.i(TAG, "Student 2 is : " + it)

        }


        val hot: ConnectableObservable<Long> =
            ConnectableObservable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS).publish()
        hot.connect()


        hot.subscribe {
            // Log.i(TAG, "Student 1 is : " + it)

        }

        Thread.sleep(3000)

        hot.subscribe {
            // Log.i(TAG, "Student 2 is : " + it)

        }


        //Hot Observable Publish Subject

        val subject: PublishSubject<String> = PublishSubject.create()
        subject.subscribe {
            //    Log.i(TAG, "Student First : " + it)

        }


        subject.onNext("A")
        sleep(1000)

        subject.onNext("B")
        sleep(1000)

        subject.onNext("C")
        sleep(1000)

        subject.onNext("D")
        sleep(1000)

        subject.subscribe {
            //  Log.i(TAG, "Student Second : " + it)

        }



        subject.onNext("E")
        sleep(1000)

        subject.onNext("F")
        sleep(1000)

        subject.onNext("G")
        sleep(1000)


        //Hot observable BehaviorSubject

        val behaviorSubject: BehaviorSubject<String> = BehaviorSubject.create()
        behaviorSubject.subscribe {
           //    Log.i(TAG, "Student First : " + it)

        }

        behaviorSubject.onNext("A")
        sleep(1000)

        behaviorSubject.onNext("B")
        sleep(1000)

        behaviorSubject.onNext("C")
        sleep(1000)

        behaviorSubject.onNext("D")
        sleep(1000)

        behaviorSubject.subscribe {
            //   Log.i(TAG, "Student Second : " + it)

        }



        behaviorSubject.onNext("E")
        sleep(1000)

        behaviorSubject.onNext("F")
        sleep(1000)

        behaviorSubject.onNext("G")
        sleep(1000)


        //Hot observable ReplaySubject

        val replaySubject: ReplaySubject<String> = ReplaySubject.create()
        replaySubject.subscribe {
            Log.i(TAG, "Student First : " + it)

        }


        replaySubject.onNext("A")
        sleep(1000)

        replaySubject.onNext("B")
        sleep(1000)

        replaySubject.onNext("C")
        sleep(1000)

        replaySubject.onNext("D")
        sleep(1000)

        replaySubject.subscribe {
            Log.i(TAG, "Student Second : " + it)

        }



        replaySubject.onNext("E")
        sleep(1000)

        replaySubject.onNext("F")
        sleep(1000)

        replaySubject.onNext("G")
        sleep(1000)

    }


    fun sleep(i: Long) {
        Thread.sleep(i)
    }
}
