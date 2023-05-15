package com.example.cinemaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: currentAdapter
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = listOf(
            Movie("Форрест Гамп",
            "https://avatars.mds.yandex.net/i?id=67753774a70cf16c2d039ed8bfa48710f11be8d9-7999331-images-thumbs&n=13",
            8.9f,
            "Полувековая история США глазами чудака из Алабамы. Абсолютная классика Роберта Земекиса с Томом Хэнксом"),
            Movie("Интерстеллар",
                "https://avatars.mds.yandex.net/i?id=1502815e338e6989597caee596bf943150babc2f-9041799-images-thumbs&n=13",
                8.6f,
                "Путешествие, чтобы превзойти прежние ограничения " +
                        "для космических путешествий человека и найти планету с подходящими для человечества условиями."),
            Movie("Зеленая миля",
                "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/c6f19e6f-79dc-43de-80cc-11d8b31fac34/1920x",
                9.1f,
                "В тюрьме для смертников появляется заключенный с божественным даром. Мистическая драма по роману Стивена Кинга")
            )
        adapter = currentAdapter(this, movies)
        viewPager = findViewById(R.id.now_showing)
        viewPager.adapter = adapter
    }
}