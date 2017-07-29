package com.example.saba7.bottlespinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_main.btnSpinBottle
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random()
        val angle = random!!.nextInt() + 360f

        toast("1. დასატრიალებლად დააწექით ბოთლს")
        toast("2. გასასწორებლად დიდხანს დააწექით ბოთლს")

        btnSpinBottle!!.setOnClickListener {
            val random = Random()
            val angle = random!!.nextInt() + 360f

            Spin(0f, angle)
        }

        btnSpinBottle!!.setOnLongClickListener{
            Spin(angle % 360f, 0f)

            true
        }
    }

    fun Spin(fromDegree: Float?, toDegree: Float?) {
        var rotateAnimation: RotateAnimation? = RotateAnimation(
                fromDegree!!,
                toDegree!!,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f
        )

        rotateAnimation!!.fillAfter = true
        rotateAnimation!!.duration = 1000
        rotateAnimation!!.interpolator = AccelerateDecelerateInterpolator()

        btnSpinBottle.startAnimation(rotateAnimation)
    }
}
