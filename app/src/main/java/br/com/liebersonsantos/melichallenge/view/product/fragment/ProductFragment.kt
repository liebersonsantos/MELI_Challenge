package br.com.liebersonsantos.melichallenge.view.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import br.com.liebersonsantos.melichallenge.R
import br.com.liebersonsantos.melichallenge.common.getMLB
import br.com.liebersonsantos.melichallenge.data.core.Status
import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.databinding.FragmentProductBinding
import br.com.liebersonsantos.melichallenge.view.home.activity.HomeActivity
import br.com.liebersonsantos.melichallenge.view.home.fragment.CATEGORY
import br.com.liebersonsantos.melichallenge.view.home.fragment.RESULT
import br.com.liebersonsantos.melichallenge.view.product.adapter.ProductAdapter
import br.com.liebersonsantos.melichallenge.view.product.fragment.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private lateinit var productAdapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var category: Categories

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getSerializable(CATEGORY)?.let {
            category = it as Categories
        }

        setupToolbar()
        setAdapter()
        setRecyclerView()
        getProduct()
        observeVMEvents()
        back()
    }

    private fun getProduct() {
        viewModel.getProducts(getMLB(), category.id)
    }

    private fun observeVMEvents() {
        viewModel.products.observe(viewLifecycleOwner) {
            if (viewLifecycleOwner.lifecycle.currentState != Lifecycle.State.RESUMED) return@observe
            when(it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = if (it.loading == true) View.VISIBLE else View.GONE
                    it.data?.let { products ->
                        productAdapter.submitList(products.results)
                    }
                }
                Status.ERROR -> {
                    binding.txtFeedbackUser.run {
                        visibility = View.VISIBLE
                        text = getString(R.string.text_server_error)
                    }
                }
                Status.LOADING -> {
                    it?.loading?.let { status ->
                        binding.progressBar.visibility = if (status) View.VISIBLE else View.GONE
                    }
                }
            }
        }

    }

    private fun setAdapter() {
        productAdapter = ProductAdapter {
            findNavController().navigate(R.id.action_productFragment_to_detailFragment,
                Bundle().apply {
                    putSerializable(RESULT, it)
                })
        }
    }

    private fun setRecyclerView() {
        binding.productsRecycler.run {
            setHasFixedSize(true)
            adapter = productAdapter
        }
    }

    private fun setupToolbar() {
        (activity as HomeActivity).run {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_white_24)
            supportActionBar?.title = category.name
        }
    }

    private fun back() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}