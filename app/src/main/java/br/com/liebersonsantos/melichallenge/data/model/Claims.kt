package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Claims(

    @SerializedName("rate")
    val rate: Double,
    @SerializedName("value")
    val value: Int,
    @SerializedName("period")
    val period: String
) : Serializable