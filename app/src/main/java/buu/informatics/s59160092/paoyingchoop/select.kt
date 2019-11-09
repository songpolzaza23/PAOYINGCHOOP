package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentSelectBinding

/**
 * A simple [Fragment] subclass.
 */
class select : Fragment() {
    private lateinit var binding: FragmentSelectBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_select , container , false)

        binding.playBotBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(R.id.action_select_to_playWithBotFragment) }
        binding.playFriendsBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(R.id.action_select_to_playWithFriendsFragment) }

        return binding.root
    }


}
