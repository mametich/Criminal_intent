package non.mametich.criminal_intent.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import non.mametich.criminal_intent.Crime
import non.mametich.criminal_intent.R
import non.mametich.criminal_intent.databinding.FragmentCrimeBinding


class CrimeFragment : Fragment(R.layout.fragment_crime) {

    private lateinit var crime: Crime
    private lateinit var binding: FragmentCrimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeBinding.inflate(inflater,container,false)

        binding.crimeTitle.text.toString()
        binding.crimeDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        binding.crimeSolved.setOnCheckedChangeListener { _, isChecked ->
            crime.isSolved = isChecked
        }
        return binding.root
    }
}

