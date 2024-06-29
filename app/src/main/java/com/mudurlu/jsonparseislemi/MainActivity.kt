package com.mudurlu.jsonparseislemi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val jsonCustomers = "{\"content\":[{\"id\":1,\"name\":\"Feridun Derin\",\"phone\":\"05121231235\",\"email\":\"ben-kisaca@fd.com\",\"address\":\"Kavak Yelleri\",\"city\":\"Muğla\"},{\"id\":2,\"name\":\"Jale Dogsöz\",\"phone\":\"05121231212\",\"email\":\"jale@de.jale\",\"address\":\"Kaş\",\"city\":\"Muğla\"},{\"id\":4,\"name\":\"Hande Kazanır\",\"phone\":\"05232345678\",\"email\":\"Hande@gmail.com\",\"address\":\"Nişantaşı\",\"city\":\"İstanbul\"},{\"id\":9,\"name\":\"Doğa Başoğlu\",\"phone\":\"05321234567\",\"email\":\"doga53@gmail.com\",\"address\":\"Kefken\",\"city\":\"Kocaeli\"},{\"id\":3,\"name\":\"Ferhat Sever\",\"phone\":\"05123654789\",\"email\":\"biribanagelsin@gocer.com\",\"address\":\"Huk\",\"city\":\"Göçmen\"}],\"pageable\":{\"pageNumber\":0,\"pageSize\":10,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"offset\":0,\"paged\":true,\"unpaged\":false},\"totalPages\":1,\"totalElements\":5,\"last\":true,\"size\":10,\"number\":0,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"numberOfElements\":5,\"first\":true,\"empty\":false}"

        try{
            val jsonObjesi = JSONObject(jsonCustomers)

            val musteriListesi = jsonObjesi.getJSONArray("content")

            for ( i in 0 until musteriListesi.length()){
                val cus = musteriListesi.getJSONObject(i)

                val cus_id = cus.getInt("id")
                val cus_name = cus.getString("name")
                val cus_phone = cus.getString("phone")
                val cus_email = cus.getString("email")
                val cus_address = cus.getString("address")
                val cus_city = cus.getString("city")

                println("******************")
                println("Musteri id ${cus_id.toString()}")
                println("Musteri Adı $cus_name")
                println("Musteri Telefonu $cus_phone")
                println("Musteri Mail Adresi $cus_email")
                println("Musteri Adresi $cus_address")
                println("Musteri Ikamet $cus_city")
                println("******************")

            }



        }catch (e:JSONException){
            e.printStackTrace()
        }

    }
}