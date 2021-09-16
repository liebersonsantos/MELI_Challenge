package br.com.liebersonsantos.melichallenge.common.mock

import br.com.liebersonsantos.melichallenge.data.model.Categories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by lieberson on 9/13/21.
 * @author lieberson.xsantos@gmail.com
 */

private fun mockCategories() =
    "[\n" +
            "  {\n" +
            "    \"id\": \"MLB5672\",\n" +
            "    \"name\": \"Acessórios para Veículos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB271599\",\n" +
            "    \"name\": \"Agro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1403\",\n" +
            "    \"name\": \"Alimentos e Bebidas\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1071\",\n" +
            "    \"name\": \"Animais\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1367\",\n" +
            "    \"name\": \"Antiguidades e Coleções\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1368\",\n" +
            "    \"name\": \"Arte, Papelaria e Armarinho\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1384\",\n" +
            "    \"name\": \"Bebês\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1246\",\n" +
            "    \"name\": \"Beleza e Cuidado Pessoal\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1132\",\n" +
            "    \"name\": \"Brinquedos e Hobbies\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1430\",\n" +
            "    \"name\": \"Calçados, Roupas e Bolsas\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1039\",\n" +
            "    \"name\": \"Câmeras e Acessórios\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1743\",\n" +
            "    \"name\": \"Carros, Motos e Outros\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1574\",\n" +
            "    \"name\": \"Casa, Móveis e Decoração\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1051\",\n" +
            "    \"name\": \"Celulares e Telefones\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1500\",\n" +
            "    \"name\": \"Construção\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB5726\",\n" +
            "    \"name\": \"Eletrodomésticos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1000\",\n" +
            "    \"name\": \"Eletrônicos, Áudio e Vídeo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1276\",\n" +
            "    \"name\": \"Esportes e Fitness\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB263532\",\n" +
            "    \"name\": \"Ferramentas\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB12404\",\n" +
            "    \"name\": \"Festas e Lembrancinhas\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1144\",\n" +
            "    \"name\": \"Games\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1459\",\n" +
            "    \"name\": \"Imóveis\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1499\",\n" +
            "    \"name\": \"Indústria e Comércio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1648\",\n" +
            "    \"name\": \"Informática\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB218519\",\n" +
            "    \"name\": \"Ingressos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1182\",\n" +
            "    \"name\": \"Instrumentos Musicais\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB3937\",\n" +
            "    \"name\": \"Joias e Relógios\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1196\",\n" +
            "    \"name\": \"Livros, Revistas e Comics\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1168\",\n" +
            "    \"name\": \"Música, Filmes e Seriados\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB264586\",\n" +
            "    \"name\": \"Saúde\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1540\",\n" +
            "    \"name\": \"Serviços\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MLB1953\",\n" +
            "    \"name\": \"Mais Categorias\"\n" +
            "  }\n" +
            "]"

fun getMockCategories(): MutableList<Categories> {
    val itemType = object : TypeToken<MutableList<Categories>>() {}.type
    return Gson().fromJson(mockCategories(), itemType)
}


