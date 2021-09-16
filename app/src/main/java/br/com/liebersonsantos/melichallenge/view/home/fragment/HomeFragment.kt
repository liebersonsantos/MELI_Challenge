package br.com.liebersonsantos.melichallenge.view.home.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.liebersonsantos.melichallenge.R
import br.com.liebersonsantos.melichallenge.common.getMLB
import br.com.liebersonsantos.melichallenge.data.core.Status
import br.com.liebersonsantos.melichallenge.data.model.Results
import br.com.liebersonsantos.melichallenge.databinding.FragmentHomeBinding
import br.com.liebersonsantos.melichallenge.view.home.activity.HomeActivity
import br.com.liebersonsantos.melichallenge.view.home.adapter.HomeAdapter
import br.com.liebersonsantos.melichallenge.view.home.fragment.viewmodel.HomeViewModel
import br.com.liebersonsantos.melichallenge.view.product.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

const val CATEGORY = "CATEGORY"
const val RESULT = "RESULT"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var mAdapter: ProductAdapter
    private var list = mutableListOf<Results>()

    private var pastVisibleItems = 0
    private var totalItemCount = 0
    private var loading = false
    private var pageLoad = 50
    private var textSearch = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setupToolbar()
        setAdapter()
        setHomeAdapter()
        setCategoriesRV()
        setProductsRV()
        getCategories()
        observeVMEvents()
    }

    private fun getCategories() {
        viewModel.getCategories(getMLB())
    }

    private fun observeVMEvents() {
        viewModel.categories.observe(viewLifecycleOwner) {
            if (viewLifecycleOwner.lifecycle.currentState != Lifecycle.State.RESUMED) return@observe
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility =
                        if (it.loading == true) View.VISIBLE else View.GONE
                    it.data?.let { categories ->
                        homeAdapter.submitList(categories)
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

        viewModel.products.observe(viewLifecycleOwner) {
            if (viewLifecycleOwner.lifecycle.currentState != Lifecycle.State.RESUMED) return@observe
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility =
                        if (it.loading == true) View.VISIBLE else View.GONE
                    it.data?.let { products ->
                        list.addAll(products.results)
                        mAdapter.submitList(list)
                        loading = false
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
        mAdapter = ProductAdapter {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment,
            Bundle().apply {
                 putSerializable(RESULT, it)
             })
        }

    }

    private fun setHomeAdapter() {
        homeAdapter = HomeAdapter {
            findNavController().navigate(R.id.action_homeFragment_to_productFragment,
                Bundle().apply {
                    putSerializable(CATEGORY, it)
                })
        }
    }

    private fun setProductsRV(){
        binding.productsRecycler.run {
            setHasFixedSize(true)
            adapter = mAdapter
            addOnScrollListener(object  : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0){
                        totalItemCount = layoutManager!!.itemCount
                        pastVisibleItems = (layoutManager as GridLayoutManager).findLastVisibleItemPosition()
                        if (!loading){
                            if (pastVisibleItems >= totalItemCount -1){
                                loading = true
                                pageLoad += 50
                                viewModel.getProductsByName(getMLB(), textSearch, pageLoad)
                            }
                        }

                    }
                }
            })
        }
    }

    private fun setCategoriesRV() {
        binding.categoriesRecycler.run {
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setSupportActionBar(binding.toolbar)
        (activity as HomeActivity).supportActionBar?.title = getString(R.string.toolbar_search)
    }

    private fun createSearch(menu: Menu) {
        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as SearchView
        searchView.queryHint = getString(R.string.toolbar_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    binding.productsRecycler.visibility = View.VISIBLE
                    binding.categoriesRecycler.visibility = View.GONE
                    list.clear()
                    binding.txtFeedbackUser.visibility = View.GONE
                    viewModel.getProductsByName(getMLB(), it, pageLoad)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mAdapter.submitList(mutableListOf())
                binding.productsRecycler.visibility = View.GONE
                binding.categoriesRecycler.visibility = View.VISIBLE
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
        createSearch(menu)
    }

}