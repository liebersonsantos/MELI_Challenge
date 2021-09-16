package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Address (
    @SerializedName("state_id")
    val stateId : String,
    @SerializedName("state_name")
    val stateName : String,
    @SerializedName("city_id")
    val cityId : String,
    @SerializedName("city_name")
    val cityName : String
): Serializable