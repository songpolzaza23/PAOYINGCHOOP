package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: ScoreFragmentViewModel
    private lateinit var viewModelFactory: ScoreFragmentViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_score , container , false)

        val args = ScoreFragmentArgs.fromBundle(arguments!!)

        viewModelFactory = ScoreFragmentViewModelFactory(args.namePlayer1 , args.namePlayer2 , args.scorePlayer1 , args.scorePlayer2)
        viewModel = ViewModelProviders.of(this ,viewModelFactory).get(ScoreFragmentViewModel::class.java)
        viewModel.name1.observe(this, Observer { newName1 ->
            binding.namePlayerScore1.text = newName1.toString()
        })
        viewModel.name2.observe(this, Observer { newName2 ->
            binding.namePlayerScore2.text = newName2.toString()
        })
        viewModel.point1.observe(this, Observer { newPoint1 ->
            binding.scorePlayer1.text = newPoint1.toString()
        })
        viewModel.point2.observe(this, Observer { newPoint2 ->
            binding.scorePlayer2.text = newPoint2.toString()
        })

//        viewModel.name1 = args.namePlayer1
//        viewModel.name2 = args.namePlayer2
//        viewModel.point1 = args.scorePlayer1
//        viewModel.point2 = args.scorePlayer2


//        binding.namePlayerScore1.setText(viewModel.name1.value)
//        binding.namePlayerScore2.setText(viewModel.name2.value)
//        binding.scorePlayer1.setText(viewModel.point1.toString())
//        binding.scorePlayer2.setText(viewModel.point2.toString())

//        sendDate()
        binding.homeBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(ScoreFragmentDirections.actionScoreFragmentToTitle2()) }
        binding.totalScoreBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(ScoreFragmentDirections.actionScoreFragmentToScoreTotalFragment("pop")) }

        return binding.root
    }

//    private fun sendDate() {
//        val action = Score
//    }


}
