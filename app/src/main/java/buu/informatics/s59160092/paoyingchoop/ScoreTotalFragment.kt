package buu.informatics.s59160092.paoyingchoop


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160092.paoyingchoop.databinding.FragmentScoreTotalBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreTotalFragment : Fragment() {

    private lateinit var binding: FragmentScoreTotalBinding
    private lateinit var viewModel: ScoreTotalViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_score_total , container , false)

        val args = ScoreTotalFragmentArgs.fromBundle(arguments!!)

        viewModel = ViewModelProviders.of(this).get(ScoreTotalViewModel::class.java)

        binding.homeBtn.setOnClickListener { view: View? -> view?.findNavController()?.navigate(ScoreTotalFragmentDirections.actionScoreTotalFragmentToTitle2()) }

        setHasOptionsMenu(true)
        return binding.root
    }
//

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.score_menu, menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            menu?.findItem(R.id.share)?.setVisible(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent {

        val args = ScoreTotalFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)

        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text))

        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
}
