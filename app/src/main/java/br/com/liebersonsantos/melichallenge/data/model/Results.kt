package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Results (
    @SerializedName("id")
    val id : String,
    @SerializedName("site_id")
    val siteId : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("seller")
    val seller : Seller,
    @SerializedName("price")
    val price : Double,
    @SerializedName("prices")
    val prices : Prices,
    @SerializedName("sale_price")
    val salePrice : String,
    @SerializedName("currency_id")
    val currencyId : String,
    @SerializedName("available_quantity")
    val availableQuantity : Int,
    @SerializedName("sold_quantity")
    val soldQuantity : Int,
    @SerializedName("buying_mode")
    val buyingMode : String,
    @SerializedName("listing_type_id")
    val listingTypeId : String,
    @SerializedName("stop_time")
    val stopTime : String,
    @SerializedName("condition")
    val condition : String,
    @SerializedName("permalink")
    val permalink : String,
    @SerializedName("thumbnail")
    val thumbnail : String,
    @SerializedName("thumbnail_id")
    val thumbnailId : String,
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago : Boolean,
    @SerializedName("installments")
    val installments : Installments,
    @SerializedName("address")
    val address : Address,
    @SerializedName("shipping")
    val shipping : Shipping,
    @SerializedName("seller_address")
    val sellerAddress : SellerAddress,
    @SerializedName("attributes")
    val attributes : List<Attributes>,
    @SerializedName("differential_pricing")
    val differentialPricing : DifferentialPricing,
    @SerializedName("original_price")
    val originalPrice : Double,
    @SerializedName("category_id")
    val categoryId : String,
    @SerializedName("official_store_id")
    val officialStoreId : Int,
    @SerializedName("domain_id")
    val domainId : String,
    @SerializedName("catalog_product_id")
    val catalogProductId : String,
    @SerializedName("tags")
    val tags : List<String>,
    @SerializedName("catalog_listing")
    val catalogListing : Boolean,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId : Boolean,
    @SerializedName("offer_score")
    val offerScore : String,
    @SerializedName("offer_share")
    val offerShare : String,
    @SerializedName("order_backend")
    val orderBackend : Int
): Serializable