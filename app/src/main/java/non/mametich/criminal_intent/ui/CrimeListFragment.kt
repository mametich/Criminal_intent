package non.mametich.criminal_intent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import non.mametich.criminal_intent.CrimeAdapter
import non.mametich.criminal_intent.CrimeListViewModel
import non.mametich.criminal_intent.databinding.FragmentCrimeListBinding


class CrimeListFragment : Fragment() {

    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private lateinit var binding: FragmentCrimeListBinding
    private lateinit var adapter: CrimeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeListBinding.inflate(inflater,container,false)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.crimeRecyclerView.layoutManager = layoutManager
        updateUI()
        return binding.root
    }

    private fun updateUI() {
        val crimes = crimeListViewModel.crimes
        adapter = CrimeAdapter(crimes)
        binding.crimeRecyclerView.adapter = adapter
    }
}