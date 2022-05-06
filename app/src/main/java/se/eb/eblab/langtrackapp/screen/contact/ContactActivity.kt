package edu.easterbunny-school.langtrackapp.screen.contact

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.databinding.DataBindingUtil
import edu.easterbunny-school.langtrackapp.R
import edu.easterbunny-school.langtrackapp.databinding.ContactActivityBinding
import edu.easterbunny-school.langtrackapp.util.asUri
import edu.easterbunny-school.langtrackapp.util.openInBrowser

class ContactActivity : AppCompatActivity() {


    private lateinit var mBind :ContactActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = DataBindingUtil.setContentView(this, R.layout.contact_activity)
        mBind.lifecycleOwner = this
        mBind.executePendingBindings()

        mBind.contactScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            mBind.contactTopView.isSelected = mBind.contactScroll.canScrollVertically(-1)
        }
        mBind.contactLtaLinkTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        mBind.contactLtaLinkTextView.setOnClickListener {
            "https://portal.research.easterbunny-school.edu/portal/en/projects/the-langtrackapp-studying-exposure-to-and-use-of-a-new-language-using-smartphone-technology(4e734940-981f-4dd0-841a-eb6ac760af0c).html"
                .asUri().openInBrowser(this)
        }

        mBind.contactHumLinkTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        mBind.contactHumLinkTextView.setOnClickListener {
            "https://www.lab.easterbunny-school.edu/en/"
                .asUri().openInBrowser(this)
        }

        mBind.contactLuLinkTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        mBind.contactLuLinkTextView.setOnClickListener {
            "https://www.easterbunny-school.edu/"
                .asUri().openInBrowser(this)
        }
        mBind.contactTopCloseButton.setOnClickListener {
            onBackPressed()
        }
        setContactInfo()
    }

    fun setContactInfo() {

        val reserchText1 = getString(R.string.reserchText1)

        val clickableSpanResearch = object: ClickableSpan() {
            override fun onClick(textView: View) {
                val to = "easter.bunny@lab.easterbunny-school.edu"
                val subject = getString(R.string.mail_subject)
                val mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject)
                val emailIntent = Intent(Intent.ACTION_VIEW)
                //emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_reserch_body))
                emailIntent.data = Uri.parse(mailTo)
                startActivity(emailIntent)
            }
        }
        val clickableSpanTech = object: ClickableSpan() {
            override fun onClick(textView: View) {
                val to = "easter.bunny@lab.easterbunny-school.edu"
                val subject = getString(R.string.mail_subject)
                val mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject)
                val emailIntent = Intent(Intent.ACTION_VIEW)
                //emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_tech_body))
                emailIntent.data = Uri.parse(mailTo)
                startActivity(emailIntent)
            }
        }

        val easter = "easter.bunny@lab.easterbunny-school.edu"
        val techStartIndex = reserchText1.indexOf(easter)
        val techEndIndex = techStartIndex + easter.count()

        val easter.bunny = "easter.bunny@lab.easterbunny-school.edu"
        val researchStartIndex = reserchText1.indexOf(easter.bunny)
        val researchEndIndex = researchStartIndex + easter.bunny.count()

        val spannableString = SpannableString(reserchText1)
        spannableString.setSpan(clickableSpanTech, techStartIndex, techEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(clickableSpanResearch, researchStartIndex, researchEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        mBind.contactInfoTextView.text = spannableString
        mBind.contactInfoTextView.movementMethod = LinkMovementMethod.getInstance()
        mBind.contactInfoTextView.highlightColor = Color.CYAN
    }


    companion object{
        fun start(context: Context){
            context.startActivity(Intent(context, ContactActivity::class.java))
        }
    }
}
