package titoaesj.com.br.constraintlayoutanimation

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
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
                circle_left.visibility = View.VISIBLE
                circle_rigth.visibility = View.VISIBLE
                dotted_line.visibility = View.VISIBLE
                qrcode.visibility = View.VISIBLE
                terminal_label.visibility = View.VISIBLE
                terminal_value.visibility = View.VISIBLE
                gate_label.visibility = View.VISIBLE
                gate_value.visibility = View.VISIBLE
                boarding_label.visibility = View.VISIBLE
                boarding_value.visibility = View.VISIBLE
                setOf = false
            } else {
                mConstraintSet1.applyTo(imageRoot)
                circle_left.visibility = View.GONE
                circle_rigth.visibility = View.GONE
                dotted_line.visibility = View.GONE
                qrcode.visibility = View.GONE
                terminal_label.visibility = View.GONE
                terminal_value.visibility = View.GONE
                gate_label.visibility = View.GONE
                gate_value.visibility = View.GONE
                boarding_label.visibility = View.GONE
                boarding_value.visibility = View.GONE
                setOf = true
            }
        }
    }
}
