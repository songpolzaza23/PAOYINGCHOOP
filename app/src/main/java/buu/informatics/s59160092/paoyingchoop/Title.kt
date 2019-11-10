package buu.informatics.s59160092.paoyingchoop


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class Title : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_title , container , false)

        binding?.newplayBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(R.id.action_title2_to_select) }
        binding.totalBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(TitleDirections.actionTitle2ToScoreTotalFragment("")) }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
