package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentPlayWithBotBinding
import kotlinx.android.synthetic.main.fragment_play_with_bot.*

/**
 * A simple [Fragment] subclass.
 */
class PlayWithBotFragment : Fragment() {
    private lateinit var binding: FragmentPlayWithBotBinding
    var bot = "BOT"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_play_with_bot,container , false)

        binding.playBtn.setOnClickListener { view: View ->
            if (binding.userText.text.isEmpty()) {
                Toast.makeText(context, "Please Insert Username!!" , Toast.LENGTH_LONG).show()
            } else {
                view.findNavController().navigate(PlayWithBotFragmentDirections.actionPlayWithBotFragmentToGameFragment( binding.userText.text.toString() , bot , "" , "" , 1 , 0 , 0))
            }

        }

        return binding.root
    }


}
