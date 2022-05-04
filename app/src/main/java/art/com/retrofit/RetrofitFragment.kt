package art.com.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import art.com.R
import art.com.databinding.FragmentRetrofitBinding


class RetrofitFragment : Fragment() {

    private lateinit var binding : FragmentRetrofitBinding
    private lateinit var retrofitViewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_retrofit, container, false)
        retrofitViewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        binding.viewModel = retrofitViewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}