package art.com.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import art.com.R
import art.com.databinding.FragmentRetrofitBinding


class RetrofitFragment : Fragment() {

    private lateinit var binding : FragmentRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
        return inflater.inflate(R.layout.fragment_retrofit, container, false)
    }

}