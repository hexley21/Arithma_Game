package com.hxl.arithmagame.presentation.fragment.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hxl.arithmagame.R
import com.hxl.arithmagame.databinding.FragmentResultBinding
import com.hxl.arithmagame.presentation.activity.MainActivity
import com.hxl.arithmagame.presentation.fragment.game_history.GameResultFormatter
import com.hxl.arithmagame.presentation.fragment.menu.MenuFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultsFragment : Fragment() {
    private val vm: ResultFragmentViewModel by activityViewModels()
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topResultsBar.setNavigationOnClickListener {
            (requireActivity() as MainActivity).replaceFragment(MenuFragment())
        }
        val rvResults = binding.rvResults
        rvResults.layoutManager = LinearLayoutManager(requireContext())
        rvResults.adapter = ResultsRecyclerAdapter(vm.questions, vm.answers, vm.compareAnswers())
        binding.topResultsBar.title = "${vm.corrects}/${vm.answers.size}"
        binding.tvResTime.text =
            "${resources.getString(R.string.time_spent)} ${GameResultFormatter.getTimerText(vm.time)}"
    }

}