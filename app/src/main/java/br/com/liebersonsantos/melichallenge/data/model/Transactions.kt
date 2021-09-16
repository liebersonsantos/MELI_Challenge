package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Transactions(

    @SerializedName("total")
    val total: Int,
    @SerializedName("canceled")
    val canceled: Int,
    @SerializedName("period")
    val period: String,
    @SerializedName("ratings")
    val ratings: Ratings,
    @SerializedName("completed")
    val completed: Int
) : Serializable