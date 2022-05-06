package edu.easterbunny-school.langtrackapp.screen.about

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.about_activity.*
import edu.easterbunny-school.langtrackapp.R
import edu.easterbunny-school.langtrackapp.databinding.AboutActivityBinding
import edu.easterbunny-school.langtrackapp.util.asUri
import edu.easterbunny-school.langtrackapp.util.openInBrowser


class AboutActivity : AppCompatActivity() {

    private lateinit var mBind :AboutActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mBind = DataBindingUtil.setContentView(this, R.layout.about_activity)
        mBind.lifecycleOwner = this
        mBind.executePendingBindings()

        mBind.aboutScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            mBind.aboutTopView.isSelected = mBind.aboutScroll.canScrollVertically(-1)
        }

        mBind.aboutTopCloseButton.setOnClickListener {
            onBackPressed()
        }

        mBind.aboutFoundingTextView.text = getString(R.string.founding)

        val resourceId = resources.getIdentifier(getString(R.string.founder_image_name), "drawable", packageName)
        mBind.aboutFoundingImageView.setImageDrawable(getDrawable(resourceId))
        mBind.aboutFoundingImageView.setOnClickListener {
            getString(R.string.founding_link_address)
                .asUri().openInBrowser(this)
        }
        setTeamText()
        mBind.textView18.text = getString(R.string.about)
    }

    fun setTeamText(){

        val builder = SpannableStringBuilder()

        val spannableHeader = SpannableString(getString(R.string.team))
        val boldSpan = StyleSpan(Typeface.BOLD)
        val sizeSpan = RelativeSizeSpan(1.3f)
        val colourSpan = ForegroundColorSpan(getColor(R.color.lta_blue))
        spannableHeader.setSpan(boldSpan,0,getString(R.string.team).count(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableHeader.setSpan(sizeSpan,0,getString(R.string.team).count(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableHeader.setSpan(colourSpan,0,getString(R.string.team).count(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        builder.append(spannableHeader)
        builder.append("\n\n")

        val nameEaster = "Easter Bunny"
        val techStartIndex = getString(R.string.easterInfo).indexOf(nameEaster)
        val techEndIndex = techStartIndex + nameEaster.count()
        val spannableStringM = SpannableString(getString(R.string.easterInfo))
        spannableStringM.setSpan(ForegroundColorSpan(getColor(R.color.lta_red)), techStartIndex, techEndIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        builder.append(spannableStringM)
        builder.append("\n\n")

        val nameEaster = "Easter Bunny"
        val easterStartIndex = getString(R.string.easterInfo).indexOf(nameEaster)
        val easterEndIndex = easterStartIndex + nameEaster.count()
        val spannableStringJ = SpannableString(getString(R.string.easterInfo))
        spannableStringJ.setSpan(ForegroundColorSpan(getColor(R.color.lta_red)), easterStartIndex, easterEndIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        builder.append(spannableStringJ)
        builder.append("\n\n")

        val nameEaster = "Easter Bunny"
        val easter.bunnyStartIndex = getString(R.string.easter.bunnyInfo).indexOf(nameEaster)
        val easter.bunnyEndIndex = easter.bunnyStartIndex + nameEaster.count()
        val spannableStringH = SpannableString(getString(R.string.easter.bunnyInfo))
        spannableStringH.setSpan(ForegroundColorSpan(getColor(R.color.lta_red)), easter.bunnyStartIndex, easter.bunnyEndIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        builder.append(spannableStringH)
        builder.append("\n\n")

        val nameEaster = "Easter Bunny"
        val easterStartIndex = getString(R.string.easterInfo).indexOf(nameEaster)
        val easterEndIndex = easterStartIndex + nameEaster.count()
        val spannableStringEaster = SpannableString(getString(R.string.easterInfo))
        spannableStringEaster.setSpan(ForegroundColorSpan(getColor(R.color.lta_red)), easterStartIndex, easterEndIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        builder.append(spannableStringEaster)
        builder.append("\n\n")

        var nameEaster = "Easter Bunny"
        var easterStartIndex = getString(R.string.easterInfo).indexOf(nameEaster)
        if (easterStartIndex < 0) {
            nameEaster = "Easter Bunny"
            easterStartIndex = getString(R.string.easterInfo).indexOf(nameEaster)
        }
        val easterEndIndex = easterStartIndex + nameEaster.count()
        val spannableStringEaster = SpannableString(getString(R.string.easterInfo))
        spannableStringEaster.setSpan(ForegroundColorSpan(getColor(R.color.lta_red)), easterStartIndex, easterEndIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        builder.append(spannableStringEaster)

        mBind.aboutTeamTextView.text = builder
    }


    companion object{
        fun start(context: Context){
            context.startActivity(Intent(context, AboutActivity::class.java))
        }
    }
}
