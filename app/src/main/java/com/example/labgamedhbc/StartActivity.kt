package com.example.labgamedhbc

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Collections
import java.util.Random

class StartActivity : Activity(), View.OnClickListener {
    private val btnMng = ArrayList<Button?>()
    private val btnAnsMng = ArrayList<Button?>()
    private val questionsMng = ArrayList<Question>()
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private var btn9: Button? = null
    private var btn10: Button? = null
    private var btn11: Button? = null
    private var btn12: Button? = null
    private var btn13: Button? = null
    private var btn14: Button? = null
    private var btn15: Button? = null
    private var btn16: Button? = null

    private var btnNext: Button? = null
    private var btnAnswer1: Button? = null
    private var btnAnswer4: Button? = null
    private var btnAnswer3: Button? = null
    private var btnAnswer2: Button? = null
    private var btnAnswer5: Button? = null
    private var btnAnswer6: Button? = null
    private var btnAnswer7: Button? = null
    private var btnAnswer8: Button? = null
    private var btnAnswer9: Button? = null
    private var btnAnswer10: Button? = null
    private var btnAnswer11: Button? = null
    private var btnAnswer12: Button? = null
    private var btnAnswer13: Button? = null
    private var btnAnswer14: Button? = null
    private var btnAnswer15: Button? = null
    private var btnAnswer16: Button? = null

    private var ivPicture: ImageView? = null
    private var tvResult: TextView? = null
    private var tvScore: TextView? = null
    private var tvHeart: TextView? = null

    private var rd: Random? = null
    private var count = 0
    private var heart = 0
    private var score = 0

    private var answer: String? = null
    private var question: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        init()
        starQuestion()
    }

    private fun init() {
        count = 0
        heart = HEART
        rd = Random()
        answer = ""
        question = ""

        ivPicture = findViewById<View>(R.id.iv_picture) as ImageView
        tvResult = findViewById<View>(R.id.tv_result) as TextView
        tvScore = findViewById<View>(R.id.tv_score) as TextView
        tvHeart = findViewById<View>(R.id.tv_heart) as TextView

        btn1 = findViewById<View>(R.id.btn_1) as Button
        btn2 = findViewById<View>(R.id.btn_2) as Button
        btn3 = findViewById<View>(R.id.btn_3) as Button
        btn4 = findViewById<View>(R.id.btn_4) as Button
        btn5 = findViewById<View>(R.id.btn_5) as Button
        btn6 = findViewById<View>(R.id.btn_6) as Button
        btn7 = findViewById<View>(R.id.btn_7) as Button
        btn8 = findViewById<View>(R.id.btn_8) as Button
        btn9 = findViewById<View>(R.id.btn_9) as Button
        btn10 = findViewById<View>(R.id.btn_10) as Button
        btn11 = findViewById<View>(R.id.btn_11) as Button
        btn12 = findViewById<View>(R.id.btn_12) as Button
        btn13 = findViewById<View>(R.id.btn_13) as Button
        btn14 = findViewById<View>(R.id.btn_14) as Button
        btn15 = findViewById<View>(R.id.btn_15) as Button
        btn16 = findViewById<View>(R.id.btn_16) as Button

        btnNext = findViewById<View>(R.id.btn_next) as Button
        btnNext!!.setOnClickListener(this)


        btnMng.add(btn1)
        btnMng.add(btn2)
        btnMng.add(btn3)
        btnMng.add(btn4)
        btnMng.add(btn5)
        btnMng.add(btn6)
        btnMng.add(btn7)
        btnMng.add(btn8)
        btnMng.add(btn9)
        btnMng.add(btn10)
        btnMng.add(btn11)
        btnMng.add(btn12)
        btnMng.add(btn13)
        btnMng.add(btn14)
        btnMng.add(btn15)
        btnMng.add(btn16)
        for (i in btnMng.indices) {
            btnMng[i]!!.setOnClickListener(this)
        }
        btnAnswer1 = findViewById<View>(R.id.btn_Answer1) as Button
        btnAnswer2 = findViewById<View>(R.id.btn_Answer2) as Button
        btnAnswer3 = findViewById<View>(R.id.btn_Answer3) as Button
        btnAnswer4 = findViewById<View>(R.id.btn_Answer4) as Button
        btnAnswer5 = findViewById<View>(R.id.btn_Answer5) as Button
        btnAnswer6 = findViewById<View>(R.id.btn_Answer6) as Button
        btnAnswer7 = findViewById<View>(R.id.btn_Answer7) as Button
        btnAnswer8 = findViewById<View>(R.id.btn_Answer8) as Button
        btnAnswer9 = findViewById<View>(R.id.btn_Answer9) as Button
        btnAnswer10 = findViewById<View>(R.id.btn_Answer10) as Button
        btnAnswer11 = findViewById<View>(R.id.btn_Answer11) as Button
        btnAnswer12 = findViewById<View>(R.id.btn_Answer12) as Button
        btnAnswer13 = findViewById<View>(R.id.btn_Answer13) as Button
        btnAnswer14 = findViewById<View>(R.id.btn_Answer14) as Button
        btnAnswer15 = findViewById<View>(R.id.btn_Answer15) as Button
        btnAnswer16 = findViewById<View>(R.id.btn_Answer16) as Button

        btnAnsMng.add(btnAnswer1)
        btnAnsMng.add(btnAnswer2)
        btnAnsMng.add(btnAnswer3)
        btnAnsMng.add(btnAnswer4)
        btnAnsMng.add(btnAnswer5)
        btnAnsMng.add(btnAnswer6)
        btnAnsMng.add(btnAnswer7)
        btnAnsMng.add(btnAnswer8)
        btnAnsMng.add(btnAnswer9)
        btnAnsMng.add(btnAnswer10)
        btnAnsMng.add(btnAnswer11)
        btnAnsMng.add(btnAnswer12)
        btnAnsMng.add(btnAnswer13)
        btnAnsMng.add(btnAnswer14)
        btnAnsMng.add(btnAnswer15)
        btnAnsMng.add(btnAnswer16)

        for (i in btnAnsMng.indices) {
            btnAnsMng[i]!!.visibility = View.GONE
            btnAnsMng[i]!!.setOnClickListener(this)
        }

        val Q1 = Question(R.drawable.aomua, "AOMUA")
        val Q2 = Question(R.drawable.baocao, "BAOCAO")
        val Q3 = Question(R.drawable.canthiep, "CANTHIEP")
        val Q4 = Question(R.drawable.cattuong, "CATTUONG")
        val Q5 = Question(R.drawable.chieutre, "CHIEUTRE")
        val Q6 = Question(R.drawable.danhlua, "DANHLUA")
        val Q7 = Question(R.drawable.danong, "DANONG")
        val Q8 = Question(R.drawable.giandiep, "GIANDIEP")
        val Q9 = Question(R.drawable.giangmai, "GIANGMAI")
        val Q10 = Question(R.drawable.hoidong, "HOIDONG")
        val Q11 = Question(R.drawable.baocao, "BAOCAO")
        val Q12 = Question(R.drawable.hongtam, "HONGTAM")
        val Q13 = Question(R.drawable.khoailang, "KHOAILANG")
        val Q14 = Question(R.drawable.kiemchuyen, "KIEMCHUYEN")
        val Q15 = Question(R.drawable.lancan, "LANCAN")
        val Q16 = Question(R.drawable.masat, "MASAT")

        questionsMng.add(Q1)
        questionsMng.add(Q2)
        questionsMng.add(Q3)
        questionsMng.add(Q4)
        questionsMng.add(Q5)
        questionsMng.add(Q6)
        questionsMng.add(Q7)
        questionsMng.add(Q8)
        questionsMng.add(Q9)
        questionsMng.add(Q10)
        questionsMng.add(Q11)
        questionsMng.add(Q12)
        questionsMng.add(Q13)
        questionsMng.add(Q14)
        questionsMng.add(Q15)
        questionsMng.add(Q16)

        Collections.shuffle(questionsMng)
    }

    private fun starQuestion() {
        ivPicture!!.setImageResource(questionsMng[count].idPicture)
        tvScore!!.text = "$score"
        tvHeart!!.text = "$heart"
        btnNext!!.visibility = View.GONE
        tvResult!!.visibility = View.GONE

        answer = questionsMng[count].answer

        if (answer != null) {
            val allChars = answer!!.toMutableList()
            val randomChars = ('A'..'Z').filterNot { it in allChars }.shuffled().take(16 - allChars.size)
            allChars.addAll(randomChars)
            allChars.shuffle()

            for (i in btnMng.indices) {
                btnMng[i]!!.visibility = View.VISIBLE
                btnMng[i]!!.text = allChars[i].toString()
            }

            for (i in btnAnsMng.indices) {
                if (i < answer!!.length) {
                    btnAnsMng[i]!!.visibility = View.VISIBLE
                    btnAnsMng[i]!!.text = ""
                    btnAnsMng[i]!!.setBackgroundResource(R.drawable.tile_question) // Đặt nền mặc định
                } else {
                    btnAnsMng[i]!!.visibility = View.GONE
                }
            }
        } else {
            for (btn in btnMng) {
                btn?.visibility = View.GONE
            }
        }

        question = ""
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_next) {
            if (btnNext!!.text == "Câu tiếp") {
                if (count == questionsMng.size - 1) {
                    Toast.makeText(this, "Bạn đã hoàn thành", Toast.LENGTH_SHORT).show()
                } else {
                    count++
                    starQuestion()
                }
            } else {
                starQuestion()
            }
            return
        }

        for (i in btnMng.indices) {
            if (view.id == btnMng[i]!!.id) {
                val selectedChar = btnMng[i]!!.text.toString()
                btnMng[i]!!.visibility = View.INVISIBLE

                for (j in btnAnsMng.indices) {
                    if (btnAnsMng[j]!!.visibility == View.VISIBLE && btnAnsMng[j]!!.text.isEmpty()) {
                        btnAnsMng[j]!!.text = selectedChar
                        break
                    }
                }

                question = ""
                for (btn in btnAnsMng) {
                    if (btn!!.visibility == View.VISIBLE) {
                        question += btn.text.toString()
                    }
                }

                if (question!!.length == answer!!.length) {
                    if (question == answer) {
                        tvResult!!.text = "Bạn đã tìm ra đáp án!"
                        tvResult!!.setTextColor(Color.GREEN)
                        tvResult!!.visibility = View.VISIBLE
                        score += 100
                        tvScore!!.text = "$score"
                        btnNext!!.text = "Câu tiếp"
                        btnNext!!.visibility = View.VISIBLE

                        for (btn in btnAnsMng) {
                            if (btn!!.visibility == View.VISIBLE) {
                                btn.setBackgroundResource(R.drawable.ic_tile_true)
                            }
                        }
                    } else {
                        tvResult!!.text = "Bạn đã chọn sai đáp án rồi!"
                        tvResult!!.setTextColor(Color.RED)
                        tvResult!!.visibility = View.VISIBLE

                        for (btn in btnAnsMng) {
                            if (btn!!.visibility == View.VISIBLE) {
                                btn.setBackgroundResource(R.drawable.ic_tile_false)
                            }
                        }

                        heart -= 1
                        tvHeart!!.text = "$heart"
                        if (heart == 0) {
                            Toast.makeText(this, "GAME OVER!", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            btnNext!!.text = "Chơi lại"
                            btnNext!!.visibility = View.VISIBLE
                        }
                    }
                }
                break
            }
        }
    }

    companion object {
        private const val HEART = 5
    }
}
