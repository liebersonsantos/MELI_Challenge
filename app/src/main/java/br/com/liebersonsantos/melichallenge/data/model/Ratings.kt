package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Ratings(

    @SerializedName("negative")
    val negative: Double,
    @SerializedName("positive")
    val positive: Double,
    @SerializedName("neutral")
    val neutral: Double
) : Serializable