package edu.easterbunny-school.langtrackapp.screen.surveyContainer.header

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.header_fragment.view.*
import edu.easterbunny-school.langtrackapp.R
import edu.easterbunny-school.langtrackapp.data.model.Question
import edu.easterbunny-school.langtrackapp.databinding.HeaderFragmentBinding
import edu.easterbunny-school.langtrackapp.interfaces.OnQuestionInteractionListener
import edu.easterbunny-school.langtrackapp.screen.surveyContainer.SurveyContainerViewModel
import edu.easterbunny-school.langtrackapp.screen.surveyContainer.SurveyContainerViewModelFactory

class HeaderFragment : Fragment(){

    private var listener: OnQuestionInteractionListener? = null
    lateinit var binding: HeaderFragmentBinding
    lateinit var question: Question
    private lateinit var viewModel : SurveyContainerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //return super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.header_fragment, container,false)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        viewModel = ViewModelProviders.of(this,
            SurveyContainerViewModelFactory(binding.root.context)
        ).get(SurveyContainerViewModel::class.java)
        val v = binding.root
        v.headerCancelButton.setOnClickListener {
            listener?.closeSurvey()
        }
        v.headerStartButton.setOnClickListener {
            listener?.nextQuestion(current = question)
        }
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnQuestionInteractionListener) {
            listener = context
            if (::binding.isInitialized) {
                setText()
            }
        }else {
            throw RuntimeException("$context must implement OnHeaderInteractionListener")
        }
    }

    fun setText(){
        if (context is OnQuestionInteractionListener) {
            if (::binding.isInitialized) {
                binding.headerTitleTextView.text = question.title
                binding.headerTextTextView.text = question.text
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setText()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HeaderFragment().apply {

            }
    }
}
