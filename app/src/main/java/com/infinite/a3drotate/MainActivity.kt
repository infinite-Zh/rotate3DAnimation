package com.infinite.a3drotate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val DURATION=200L
        val DEEPZ=400f
    }

    var centerX: Float = 0f
    var centerY: Float = 0f
    private var anim: Rotate3dAnimation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rl_content.setOnClickListener({
            centerX = rl_content.width / 2.toFloat()
            centerY = rl_content.height / 2.toFloat()
            if (anim == null) {
                initAnimation()
            }
            rl_content.startAnimation(anim)
        })
    }

    private fun initAnimation() {


        anim = Rotate3dAnimation(this,0F, 90f, centerX, centerY, DEEPZ, false)
        anim!!.duration = DURATION
        anim!!.fillAfter = true
        anim!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                if (iv_1.visibility == View.GONE) {
                    iv_1.visibility = View.VISIBLE

                } else {
                    iv_1.visibility = View.GONE
                }

                if (iv_2.visibility == View.GONE) {
                    iv_2.visibility = View.VISIBLE
                } else {
                    iv_2.visibility = View.GONE
                }

                val ra = Rotate3dAnimation(this@MainActivity,270f, 360f, centerX, centerY, DEEPZ, false)
                ra.duration = DURATION
                ra.fillAfter = true
                ra.interpolator = DecelerateInterpolator()
                rl_content.startAnimation(ra)

            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
    }
}

