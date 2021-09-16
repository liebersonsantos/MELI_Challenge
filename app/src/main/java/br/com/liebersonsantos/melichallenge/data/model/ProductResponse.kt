package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class ProductResponse (
    @SerializedName("site_id")
    val siteId : String,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone : String,
    @SerializedName("paging")
    val paging : Paging,
    @SerializedName("results")
    val results : MutableList<Results>,
    @SerializedName("sort")
    val sort : Sort,
    @SerializedName("available_sorts")
    val availableSorts : List<AvailableSorts>,
    @SerializedName("filters")
    val filters : List<Filters>,
    @SerializedName("available_filters")
    val availableFilters : List<AvailableFilters>
): Serializable