package com.mudurlu.jsonparseislemi

import org.json.JSONException
import org.json.JSONObject

fun main(){
    val filmlerJsonSonuc = "{\"filmler\":[{\"film_id\":\"1\",\"film_ad\":\"Interstellar\",\"film_yil\":\"2015\",\"film_resim\":\"interstellar.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"2\",\"film_ad\":\"Inception\",\"film_yil\":\"2010\",\"film_resim\":\"inception.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"3\",\"film_ad\":\"The Pianist\",\"film_yil\":\"2002\",\"film_resim\":\"thepianist.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"4\",\"yonetmen_ad\":\"Roman Polanski\"}},{\"film_id\":\"4\",\"film_ad\":\"Bir Zamanlar Anadolu'da\",\"film_yil\":\"2011\",\"film_resim\":\"birzamanlaranadoluda.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"3\",\"yonetmen_ad\":\"Nuri Bilge Ceylan\"}},{\"film_id\":\"5\",\"film_ad\":\"The Hateful Eight\",\"film_yil\":\"2015\",\"film_resim\":\"thehatefuleight.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}},{\"film_id\":\"18\",\"film_ad\":\"Django\",\"film_yil\":\"2013\",\"film_resim\":\"django.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}}],\"success\":1}"

    try {

        val jsonDosyasi = JSONObject(filmlerJsonSonuc)

        val filmListesi = jsonDosyasi.getJSONArray("filmler")

        for (i in 0 until filmListesi.length()){
            val film = filmListesi.getJSONObject(i)

            val film_id = film.getInt("film_id")
            val film_ad = film.getString("film_ad")
            val film_yil = film.getInt("film_yil")
            val film_resim = film.getString("film_resim")

            val kategori = film.getJSONObject("kategori")
            val kategori_id = kategori.getInt("kategori_id")
            val kategori_ad = kategori.getString("kategori_ad")

            val yonetmen = film.getJSONObject("yonetmen")
            val yonetmen_id = yonetmen.getInt("yonetmen_id")
            val yonetmen_ad = yonetmen.getString("yonetmen_ad")

        }
    }

    catch (e:JSONException){
        e.printStackTrace()
    }
}