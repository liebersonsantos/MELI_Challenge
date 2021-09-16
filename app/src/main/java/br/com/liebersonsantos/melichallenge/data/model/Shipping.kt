package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Shipping(

    @SerializedName("free_shipping")
    val freeShipping: Boolean,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("logistic_type")
    val logisticType: String,
    @SerializedName("store_pick_up")
    val storePickUp: Boolean
) : Serializable