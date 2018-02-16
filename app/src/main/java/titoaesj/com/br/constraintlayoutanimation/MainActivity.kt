package titoaesj.com.br.constraintlayoutanimation

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mConstraintSet1 = ConstraintSet()
        val mConstraintSet2 = ConstraintSet()

        mConstraintSet1.clone(imageRoot)
        mConstraintSet2.clone(this, R.layout.activity_main_alt)

        var setOf = true
        activity_main_appcompatimageview_image.setOnClickListener {
            TransitionManager.beginDelayedTransition(imageRoot)
            if (setOf) {
                mConstraintSet2.applyTo(imageRoot)
                setOf = false
            } else {
                mConstraintSet1.applyTo(imageRoot)
                setOf = true
            }
        }
    }
}
