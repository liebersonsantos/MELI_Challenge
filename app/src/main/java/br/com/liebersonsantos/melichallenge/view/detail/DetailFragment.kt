package br.com.liebersonsantos.melichallenge.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.liebersonsantos.melichallenge.R
import br.com.liebersonsantos.melichallenge.common.toCurrency
import br.com.liebersonsantos.melichallenge.data.model.Results
import br.com.liebersonsantos.melichallenge.databinding.FragmentDetailBinding
import br.com.liebersonsantos.melichallenge.view.home.activity.HomeActivity
import br.com.liebersonsantos.melichallenge.view.home.fragment.RESULT
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var results: Results

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getSerializable(RESULT)?.let {
            results = it as Results
        }
        setupToolbar()
        setView()
        back()
    }

    private fun setView(){
        binding.run {
            Glide.with(requireContext())
                .load(results.thumbnail)
                .fitCenter()
                .apply {
                    override(SIZE_ORIGINAL)
                    format(DecodeFormat.PREFER_ARGB_8888)
                }
                .into(productImage)

            productDescription.text = results.title
            productPrice.text = results.price.toCurrency()
        }
    }

    private fun setupToolbar() {
        (activity as HomeActivity).run {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_white_24)
            supportActionBar?.title = getString(R.string.product)
        }
    }

    private fun back() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}