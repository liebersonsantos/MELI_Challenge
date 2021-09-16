package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Seller(
    @SerializedName("id")
    val id: Int,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("registration_date")
    val registrationDate: String,
    @SerializedName("car_dealer")
    val carDealer: Boolean,
    @SerializedName("real_estate_agency")
    val realEstateAgency: Boolean,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("seller_reputation")
    val sellerReputation: SellerReputation
) : Serializable