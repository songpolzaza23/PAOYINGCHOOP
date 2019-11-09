package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.view.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var binding : FragmentGameBinding
    private lateinit var wordlist: MutableList<String>

    private var player1 = ""
    private var player2 = ""
    private var numPlayer = 0
    private var p1 = 0
    private var p2 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_game , container , false)

        val args = GameFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "Welcome : ${args.userPlayer1} play with ${args.userPlayer2}", Toast.LENGTH_LONG).show()

        player1 = args.userPlayer1
        player2 = args.userPlayer2
        p1 = args.pointP1
        p2 = args.pointP2

        binding.namePlayer1Text.setText("SCORE ${args.userPlayer1} :")
        binding.namePlayer2Text.setText("SCORE ${args.userPlayer2} :")
        binding.scorePlayer1Text.setText(" ${p1}")
        binding.scorePlayer2Text.setText(" ${p2}")

        checkPlayer()

        return binding.root
    }

    fun checkPlayer() {

        val args = GameFragmentArgs.fromBundle(arguments!!)

        if (player2.equals("BOT")) {
            numPlayer = 1
            playbot()
        } else {
            numPlayer = 2
            playfriend()
        }
    }

    fun playbot() {

        binding.namePlayerText.text = player1
        binding.paperHandBtn.setOnClickListener{view: View? ->
            randomChoiceForBot()
            view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, "paper" , wordlist[0] , p1 , p2))
        }
        binding.rockHandBtn.setOnClickListener{view: View? ->
            randomChoiceForBot()
            view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, "rock" ,  wordlist[0] , p1 , p2))
        }
        binding.scissorHandBtn.setOnClickListener{view: View? ->
            randomChoiceForBot()
            view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, "scissor" ,  wordlist[0] , p1 , p2))
        }
    }

    fun randomChoiceForBot() {

        wordlist = mutableListOf("paper" , "rock" , "scissor")
        wordlist.shuffle()

    }

    fun playfriend() {

        val args = GameFragmentArgs.fromBundle(arguments!!)

        if (args.num == 2) {
            binding.namePlayerText.text = player1
            binding.paperHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentSelf( args.userPlayer1 , args.userPlayer2 , "paper" , args.userResult2 , 1 , p1 , p2))
            }
            binding.rockHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentSelf( args.userPlayer1 , args.userPlayer2 , "rock" , args.userResult2 , 1   , p1 , p2))
            }
            binding.scissorHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentSelf( args.userPlayer1 , args.userPlayer2 , "scissor" , args.userResult2 , 1  , p1 , p2))
            }
        } else if (args.num == 1) {

            binding.namePlayerText.text = player2
            binding.paperHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, args.userResult1 , "paper" , p1 , p2))
            }
            binding.rockHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, args.userResult1 , "rock" , p1 , p2))
            }
            binding.scissorHandBtn.setOnClickListener{view: View? ->
                view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultGame(  player1 , player2, args.userResult1 , "scissor" , p1 , p2))
            }
        }



    }


}
