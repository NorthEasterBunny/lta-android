package edu.easterbunny-school.langtrackapp.screen.overview.overviewQuestionViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.overview_header.view.*
import edu.easterbunny-school.langtrackapp.R
import edu.easterbunny-school.langtrackapp.data.model.Question

class OverviewHeaderView @JvmOverloads constructor(

    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr)  {
    init {
        LayoutInflater.from(context).inflate(R.layout.overview_header, this, true)
    }

    fun setText(question: Question){
        overviewHeaderTextView.text = question.text
    }
}
