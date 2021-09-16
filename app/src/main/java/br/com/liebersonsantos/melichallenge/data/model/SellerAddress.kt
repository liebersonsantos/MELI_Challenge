package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class SellerAddress(

    @SerializedName("id")
    val id: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("address_line")
    val addressLine: String,
    @SerializedName("zip_code")
    val zipCode: String,
    @SerializedName("country")
    val country: Country,
    @SerializedName("state")
    val state: State,
    @SerializedName("city")
    val city: City,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
) : Serializable