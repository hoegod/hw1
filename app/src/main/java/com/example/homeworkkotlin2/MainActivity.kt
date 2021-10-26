package com.example.homeworkkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.gamer)
        val tv_text = findViewById<TextView>(R.id.status)
        val tv_name = findViewById<TextView>(R.id.name)
        val tv_winner = findViewById<TextView>(R.id.winner)
        val btn_scissor = findViewById<RadioButton>(R.id.scissor)
        val btn_stone = findViewById<RadioButton>(R.id.stone)
        val btn_papper = findViewById<RadioButton>(R.id.papper)
        val tv_cmora = findViewById<TextView>(R.id.cmora)
        val tv_mmora = findViewById<TextView>(R.id.mmora)
        val btn_mora = findViewById<Button>(R.id.mora)
        btn_mora.setOnClickListener {
            if (ed_name.length() < 1) tv_text.text = "請輸入玩家姓名" else {
                tv_name.text = String.format(
                    "名字\n%s",
                    ed_name.text.toString()
                )
                if (btn_scissor.isChecked) tv_mmora.text =
                    "我方出拳\n剪刀" else if (btn_stone.isChecked) tv_mmora.text =
                    "我方出拳\n石頭" else tv_mmora.text = "我方出拳\n布"
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tv_cmora.text =
                    "電腦出拳\n剪刀" else if (computer == 1) tv_cmora.text =
                    "電腦出拳\n石頭" else tv_cmora.text = "電腦出拳\n布"
                if (btn_scissor.isChecked && computer == 2 ||
                    btn_stone.isChecked && computer == 0 ||
                    btn_papper.isChecked && computer == 1
                ) {
                    tv_winner.text = """
                        勝利者
                        ${ed_name.text}
                        """.trimIndent()
                    tv_text.text = "恭喜你獲勝了!!!"
                } else if (btn_scissor.isChecked && computer == 1 ||
                    btn_stone.isChecked && computer == 2 ||
                    btn_papper.isChecked && computer == 0
                ) {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜,電腦獲勝了!"
                } else {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局,請再試一次!"
                }
            }
        }
    }
}