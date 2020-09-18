package sim.coder.introslider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(

        listOf(
            IntroSlide(
                "Welcome to MAFQOUD",
                "you can search for any thing you lost",
                R.drawable.back
            ),
            IntroSlide(
                "About the app",
                "this app let you find what ever you lost in yemen",
                R.drawable.baa
            ),
            IntroSlide(
                "Version",
                "this app has version 1.0 and we will upload new version",
                R.drawable.rr
            )

        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
//        setCurrent(0)
//        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                setCurrent(position)
//            }
//        })

        next.setOnClickListener {
           if (introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount ){
               introSliderViewPager.currentItem+=1

           }else{
               var i = Intent(this, NewActivity::class.java)
               startActivity(i)
               finish()
           }
        }

        tvSkipIntro.setOnClickListener {
            var i = Intent(this, NewActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    private fun setupIndicators(){

        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){


            indicators[i]= ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )

                this?.layoutParams = layoutParams

            }
            indicatorsContainer.addView(indicators[i])
        }

    }

//   private fun  setCurrent(index:Int){
//       val childCount = indicatorsContainer.childCount
//       for (i in 0 until childCount){
//           val imageView = indicatorsContainer[i] as ImageView
//           if (i == index ){
//               imageView.setImageDrawable(
//                   ContextCompat.getDrawable(
//                       applicationContext,
//                       R.drawable.indicator_active
//                   )
//               )
//           }else
//           {
//               imageView.setImageDrawable(
//                   ContextCompat.getDrawable(
//                       applicationContext,
//                       R.drawable.indicator_inactive
//                   )
//               )
//
//           }
//       }
//   }

}
