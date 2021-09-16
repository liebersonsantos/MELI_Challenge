package br.com.liebersonsantos.melichallenge.common.mock

import br.com.liebersonsantos.melichallenge.data.model.ProductResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
fun mockProducts() =
    "{\n" +
            "  \"site_id\": \"MLB\",\n" +
            "  \"country_default_time_zone\": \"GMT-03:00\",\n" +
            "  \"paging\": {\n" +
            "    \"total\": 14639,\n" +
            "    \"primary_results\": 1000,\n" +
            "    \"offset\": 0,\n" +
            "    \"limit\": 50\n" +
            "  },\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"id\": \"MLB1962421407\",\n" +
            "      \"site_id\": \"MLB\",\n" +
            "      \"title\": \"Apple iPhone 12 (64 Gb) - Roxo\",\n" +
            "      \"seller\": {\n" +
            "        \"id\": 480263032,\n" +
            "        \"permalink\": \"http://perfil.mercadolivre.com.br/MERCADOLIVRE+ELETRONICOS\",\n" +
            "        \"registration_date\": \"2019-10-15T18:13:19.000-04:00\",\n" +
            "        \"car_dealer\": false,\n" +
            "        \"real_estate_agency\": false,\n" +
            "        \"tags\": [\n" +
            "          \"brand\",\n" +
            "          \"large_seller\",\n" +
            "          \"credits_profile\",\n" +
            "          \"messages_as_seller\"\n" +
            "        ],\n" +
            "        \"seller_reputation\": {\n" +
            "          \"transactions\": {\n" +
            "            \"total\": 2600644,\n" +
            "            \"canceled\": 173138,\n" +
            "            \"period\": \"historic\",\n" +
            "            \"ratings\": {\n" +
            "              \"negative\": 0.04,\n" +
            "              \"positive\": 0.95,\n" +
            "              \"neutral\": 0.01\n" +
            "            },\n" +
            "            \"completed\": 2427506\n" +
            "          },\n" +
            "          \"power_seller_status\": \"platinum\",\n" +
            "          \"metrics\": {\n" +
            "            \"claims\": {\n" +
            "              \"rate\": 0.0087,\n" +
            "              \"value\": 3941,\n" +
            "              \"period\": \"60 days\"\n" +
            "            },\n" +
            "            \"delayed_handling_time\": {\n" +
            "              \"rate\": 0,\n" +
            "              \"value\": 2,\n" +
            "              \"period\": \"60 days\"\n" +
            "            },\n" +
            "            \"sales\": {\n" +
            "              \"period\": \"60 days\",\n" +
            "              \"completed\": 425099\n" +
            "            },\n" +
            "            \"cancellations\": {\n" +
            "              \"rate\": 0,\n" +
            "              \"value\": 0,\n" +
            "              \"period\": \"60 days\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"level_id\": \"5_green\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"price\": 4999,\n" +
            "      \"prices\": {\n" +
            "        \"id\": \"MLB1962421407\",\n" +
            "        \"prices\": [\n" +
            "          {\n" +
            "            \"id\": \"27\",\n" +
            "            \"type\": \"standard\",\n" +
            "            \"amount\": 5399,\n" +
            "            \"regular_amount\": null,\n" +
            "            \"currency_id\": \"BRL\",\n" +
            "            \"last_updated\": \"2021-09-08T20:14:44Z\",\n" +
            "            \"conditions\": {},\n" +
            "            \"exchange_rate_context\": \"DEFAULT\",\n" +
            "            \"metadata\": {}\n" +
            "          }\n" +
            "        ],\n" +
            "        \"presentation\": {\n" +
            "          \"display_currency\": \"BRL\"\n" +
            "        },\n" +
            "        \"payment_method_prices\": [],\n" +
            "        \"reference_prices\": [\n" +
            "          {\n" +
            "            \"id\": \"37\",\n" +
            "            \"type\": \"was\",\n" +
            "            \"conditions\": {\n" +
            "              \"context_restrictions\": [],\n" +
            "              \"start_time\": \"2021-09-14T04:28:31Z\",\n" +
            "              \"end_time\": \"2021-09-17T04:28:31Z\",\n" +
            "              \"eligible\": true\n" +
            "            },\n" +
            "            \"amount\": 4999,\n" +
            "            \"currency_id\": \"BRL\",\n" +
            "            \"exchange_rate_context\": \"DEFAULT\",\n" +
            "            \"tags\": [],\n" +
            "            \"last_updated\": \"2021-09-14T04:28:31Z\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"purchase_discounts\": []\n" +
            "      },\n" +
            "      \"sale_price\": null,\n" +
            "      \"currency_id\": \"BRL\",\n" +
            "      \"available_quantity\": 168,\n" +
            "      \"sold_quantity\": 169,\n" +
            "      \"buying_mode\": \"buy_it_now\",\n" +
            "      \"listing_type_id\": \"gold_pro\",\n" +
            "      \"stop_time\": \"2041-07-23T04:00:00.000Z\",\n" +
            "      \"condition\": \"new\",\n" +
            "      \"permalink\": \"https://www.mercadolivre.com.br/apple-iphone-12-64-gb-roxo/p/MLB17935585\",\n" +
            "      \"thumbnail\": \"http://http2.mlstatic.com/D_890762-MLA46155077530_052021-I.jpg\",\n" +
            "      \"thumbnail_id\": \"890762-MLA46155077530_052021\",\n" +
            "      \"accepts_mercadopago\": true,\n" +
            "      \"installments\": {\n" +
            "        \"quantity\": 12,\n" +
            "        \"amount\": 416.58,\n" +
            "        \"rate\": 0,\n" +
            "        \"currency_id\": \"BRL\"\n" +
            "      },\n" +
            "      \"address\": {\n" +
            "        \"state_id\": \"BR-SP\",\n" +
            "        \"state_name\": \"São Paulo\",\n" +
            "        \"city_id\": \"QlItU1BDYWphbWFy\",\n" +
            "        \"city_name\": \"Cajamar\"\n" +
            "      },\n" +
            "      \"shipping\": {\n" +
            "        \"free_shipping\": true,\n" +
            "        \"mode\": \"me2\",\n" +
            "        \"tags\": [\n" +
            "          \"fulfillment\",\n" +
            "          \"mandatory_free_shipping\"\n" +
            "        ],\n" +
            "        \"logistic_type\": \"fulfillment\",\n" +
            "        \"store_pick_up\": false\n" +
            "      },\n" +
            "      \"seller_address\": {\n" +
            "        \"id\": \"\",\n" +
            "        \"comment\": \"\",\n" +
            "        \"address_line\": \"\",\n" +
            "        \"zip_code\": \"\",\n" +
            "        \"country\": {\n" +
            "          \"id\": \"BR\",\n" +
            "          \"name\": \"Brasil\"\n" +
            "        },\n" +
            "        \"state\": {\n" +
            "          \"id\": \"BR-SP\",\n" +
            "          \"name\": \"São Paulo\"\n" +
            "        },\n" +
            "        \"city\": {\n" +
            "          \"id\": \"QlItU1BDYWphbWFy\",\n" +
            "          \"name\": \"Cajamar\"\n" +
            "        },\n" +
            "        \"latitude\": \"\",\n" +
            "        \"longitude\": \"\"\n" +
            "      },\n" +
            "      \"attributes\": [\n" +
            "        {\n" +
            "          \"id\": \"BRAND\",\n" +
            "          \"value_id\": \"9344\",\n" +
            "          \"value_name\": \"Apple\",\n" +
            "          \"values\": [\n" +
            "            {\n" +
            "              \"source\": 1,\n" +
            "              \"id\": \"9344\",\n" +
            "              \"name\": \"Apple\",\n" +
            "              \"struct\": null\n" +
            "            }\n" +
            "          ],\n" +
            "          \"source\": 1,\n" +
            "          \"name\": \"Marca\",\n" +
            "          \"value_struct\": null,\n" +
            "          \"attribute_group_id\": \"OTHERS\",\n" +
            "          \"attribute_group_name\": \"Outros\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"differential_pricing\": {\n" +
            "        \"id\": 33580182\n" +
            "      },\n" +
            "      \"original_price\": 5599,\n" +
            "      \"category_id\": \"MLB1055\",\n" +
            "      \"official_store_id\": 2162,\n" +
            "      \"domain_id\": \"MLB-CELLPHONES\",\n" +
            "      \"catalog_product_id\": \"MLB17935585\",\n" +
            "      \"tags\": [\n" +
            "        \"deal_of_the_day\",\n" +
            "        \"good_quality_picture\",\n" +
            "        \"good_quality_thumbnail\",\n" +
            "        \"immediate_payment\",\n" +
            "        \"cart_eligible\",\n" +
            "        \"shipping_guaranteed\",\n" +
            "        \"best_seller_candidate\"\n" +
            "      ],\n" +
            "      \"catalog_listing\": true,\n" +
            "      \"use_thumbnail_id\": true,\n" +
            "      \"offer_score\": null,\n" +
            "      \"offer_share\": null,\n" +
            "      \"order_backend\": 1\n" +
            "    }\n" +
            "  ],\n" +
            "  \"sort\": {\n" +
            "    \"id\": \"relevance\",\n" +
            "    \"name\": \"More relevant\"\n" +
            "  },\n" +
            "  \"available_sorts\": [\n" +
            "    {\n" +
            "      \"id\": \"price_asc\",\n" +
            "      \"name\": \"Lower price\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"filters\": [\n" +
            "    {\n" +
            "      \"id\": \"category\",\n" +
            "      \"name\": \"Categories\",\n" +
            "      \"type\": \"text\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"id\": \"MLB1051\",\n" +
            "          \"name\": \"Celulares e Telefones\",\n" +
            "          \"path_from_root\": []\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"available_filters\": [\n" +
            "    {\n" +
            "      \"id\": \"category\",\n" +
            "      \"name\": \"Categories\",\n" +
            "      \"type\": \"text\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"id\": \"MLB1055\",\n" +
            "          \"name\": \"Celulares e Smartphones\",\n" +
            "          \"results\": 454\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

fun getMockProducts(): ProductResponse {
    val itemType = object : TypeToken<ProductResponse>() {}.type
    return Gson().fromJson(mockProducts(), itemType)
}