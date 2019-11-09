package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentPlayWithFriendsBinding

/**
 * A simple [Fragment] subclass.
 */
class PlayWithFriendsFragment : Fragment() {
    private lateinit var binding: FragmentPlayWithFriendsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_play_with_friends , container , false)
        binding.playBtn.setOnClickListener { view: View? ->

            if (binding.player1Text.text.isEmpty()) {
                Toast.makeText(context, "Please Insert Username Player1!!" , Toast.LENGTH_LONG).show()
            } else if (binding.player2Text.text.isEmpty()){
                Toast.makeText(context, "Please Insert Username Player2!!" , Toast.LENGTH_LONG).show()
            } else {
                view?.findNavController()?.navigate(
                    PlayWithFriendsFragmentDirections.actionPlayWithFriendsFragmentToGameFragment(
                        binding.player1Text.text.toString() , binding.player2Text.text.toString() , "" , "" , 2 , 0 , 0)
                )
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}
