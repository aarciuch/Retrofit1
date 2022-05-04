package art.com.retrofit

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import art.com.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView : ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.b)
                .error(R.drawable.a))
            .into(imgView)
    }
}