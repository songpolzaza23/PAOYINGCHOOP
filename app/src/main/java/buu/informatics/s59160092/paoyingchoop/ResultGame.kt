package buu.informatics.s59160092.paoyingchoop


import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentResultGameBinding
import kotlinx.android.synthetic.main.fragment_result_game.*

/**
 * A simple [Fragment] subclass.
 */
class ResultGame : Fragment() {

    private lateinit var binding: FragmentResultGameBinding
//    private lateinit var viewModel: ResultViewModel
//    private lateinit var viewModelFactory: ResultViewModelFactory

//    private lateinit var wordlist: MutableList<String>
    var pointPlayer1 = 0
    var pointPlayer2 = 0
    var checkStutus = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_result_game , container , false)

//        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)

        val args = ResultGameArgs.fromBundle(arguments!!)
        binding.namePlayerResult1.text = args.nmPlayer1
        binding.namePlayerResult2.text = args.nmPlayer2

        pointPlayer1 = args.pointPY1
        pointPlayer2 = args.pointPY2

//        wordlist = mutableListOf("paper" , "rock" , "scissor")

//        var wordList = mutableListOf<String>( "paper" , "rock" , "scissor")
//        wordList.shuffle()

//        wordlist.shuffle()

        object : CountDownTimer(3000, 100) {
            override fun onTick(millisUntilFinished: Long) {

                var check:Long = millisUntilFinished/100
                var thrid:Long = 3
                var num:Int = check.rem(thrid).toInt()

                if (num == 0) {
                    binding.resultPic1.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                    )
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                    )
                } else if (num == 1) {
                    binding.resultPic1.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                    )
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                    )
                } else if (num == 2) {
                    binding.resultPic1.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                    )
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                    )
                }

            }

            override fun onFinish() {
                setImageResult()
                if (args.nmPlayer2.equals("BOT")) {
                    checkStutus = 1
                    checkResultBot()
                } else {
                    checkStutus = 2
                    checkResult()
                }

            }
        }.start()


        binding.totalScoreBtn.setOnClickListener { view: View? ->

            view?.findNavController()?.navigate(
                ResultGameDirections.actionResultGameToGameFragment(
                    args.nmPlayer1, args.nmPlayer2 , args.rePlayer1 , args.rePlayer2 , checkStutus , pointPlayer1 , pointPlayer2)
            )

        }
        binding.endBtn.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(
                ResultGameDirections.actionResultGameToScoreFragment(args.nmPlayer1, args.nmPlayer2 , pointPlayer1 , pointPlayer2)
            )
        }

        return binding.root
    }


    fun setImageResult() {

        val args = ResultGameArgs.fromBundle(arguments!!)

        if(args.nmPlayer2.equals("BOT")) {
            if (args.rePlayer1.equals("paper")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                )
            } else if (args.rePlayer1.equals("rock")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                )
            } else if (args.rePlayer1.equals("scissor")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                )
            }
        } else {
            if (args.rePlayer1.equals("paper")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                )
                if (args.rePlayer2.equals("paper")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                    )
                } else if (args.rePlayer2.equals("rock")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                    )
                } else if (args.rePlayer2.equals("scissor")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                    )
                }
            } else if (args.rePlayer1.equals("rock")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                )
                if (args.rePlayer2.equals("paper")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                    )
                } else if (args.rePlayer2.equals("rock")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                    )
                } else if (args.rePlayer2.equals("scissor")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                    )
                }
            } else if (args.rePlayer1.equals("scissor")) {
                binding.resultPic1.setImageDrawable(
                    context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                )
                if (args.rePlayer2.equals("paper")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
                    )
                } else if (args.rePlayer2.equals("rock")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
                    )
                } else if (args.rePlayer2.equals("scissor")) {
                    binding.resultPic2.setImageDrawable(
                        context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
                    )
                }
            }
        }
    }

    fun checkResultBot() {

        val args = ResultGameArgs.fromBundle(arguments!!)

        if (args.rePlayer2.equals("paper")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
            )

        } else if (args.rePlayer2.equals("rock")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
            )
        } else if (args.rePlayer2.equals("scissor")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
            )
        }

        checkWinBot()
    }

    fun checkResult() {

        val args = ResultGameArgs.fromBundle(arguments!!)

        Toast.makeText(context , "${args.rePlayer2}" , Toast.LENGTH_LONG).show()

        if (args.rePlayer1.equals("paper")) {
            binding.resultPic1.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
            )
        } else if (args.rePlayer1.equals("rock")) {
            binding.resultPic1.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
            )
        } else if (args.rePlayer1.equals("scissor")) {
            binding.resultPic1.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
            )
        } else if (args.rePlayer2.equals("paper")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.stop) }
            )
        } else if (args.rePlayer2.equals("rock")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.fist) }
            )
        } else if (args.rePlayer2.equals("scissor")) {
            binding.resultPic2.setImageDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.victory) }
            )
        }

        checkWin()

    }

    fun checkWinBot() {

        val args = ResultGameArgs.fromBundle(arguments!!)

        if (args.rePlayer1.equals(args.rePlayer2)) {
            binding.resultGame.setText("Draw!!")
        } else if (args.rePlayer1.equals("paper") && args.rePlayer2.equals("rock")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        } else if (args.rePlayer1.equals("paper") && args.rePlayer2.equals("scissor")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("rock") && args.rePlayer2.equals("paper")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("rock") && args.rePlayer2.equals("scissor")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        } else if (args.rePlayer1.equals("scissor") && args.rePlayer2.equals("rock")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("scissor") && args.rePlayer2.equals("paper")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        }
    }

    fun checkWin() {

        val args = ResultGameArgs.fromBundle(arguments!!)

        if (args.rePlayer1.equals(args.rePlayer2)) {
            binding.resultGame.setText("Draw!!")
        } else if (args.rePlayer1.equals("paper") && args.rePlayer2.equals("rock")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        } else if (args.rePlayer1.equals("paper") && args.rePlayer2.equals("scissor")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("rock") && args.rePlayer2.equals("paper")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("rock") && args.rePlayer2.equals("scissor")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        } else if (args.rePlayer1.equals("scissor") && args.rePlayer2.equals("rock")) {
            binding.resultGame.setText(" ${args.nmPlayer2} WIN!! ")
            pointPlayer2++
        } else if (args.rePlayer1.equals("scissor") && args.rePlayer2.equals("paper")) {
            binding.resultGame.setText(" ${args.nmPlayer1} WIN!! ")
            pointPlayer1++
        }

    }
}
