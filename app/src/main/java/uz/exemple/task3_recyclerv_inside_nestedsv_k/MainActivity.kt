package uz.exemple.task3_recyclerv_inside_nestedsv_k

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.task3_recyclerv_inside_nestedsv_k.adapter.ItemAdapter
import uz.exemple.task3_recyclerv_inside_nestedsv_k.model.DataModel

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    lateinit var recyclerView:RecyclerView

    lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    fun initViews(){
        context = this
        recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(context))

        val nestedList1 = ArrayList<String>()
        nestedList1.add("Қизлар учун")
        nestedList1.add("Ўғил болалар учун")
        nestedList1.add("Аёллар учун")
        nestedList1.add("Эркаклар учун")
        nestedList1.add("Оиладаги хаммага")
        nestedList1.add("Сумка ва Рюкзаклар")
        nestedList1.add("Пойабзаллар ва Этиклар")
        nestedList1.add("Зонтиклар ва ёмғирпўшлар")

        val nestedList2 = ArrayList<String>()
        nestedList2.add("Пишириш учун идишлар")
        nestedList2.add("Сервировка")
        nestedList2.add("Махсулот сақлагичлар")
        nestedList2.add("Идиши қуритгачлар")
        nestedList2.add("Сув филтрлари")
        nestedList2.add("Холодилниклар")
        nestedList2.add("Газ плиталари")
        nestedList2.add("Раковина ва сместителлар")

        val nestedList3 = ArrayList<String>()
        nestedList3.add("Ноутбук ва Аксесуарлар")
        nestedList3.add("Десктоплар ва Моноблоклар")
        nestedList3.add("Компютер учун аксессуарлар")
        nestedList3.add("Компютер жихозлари")
        nestedList3.add("Офис жихозлари")
        nestedList3.add("Сет учун қурилмалар")

        val nestedList4: List<String> = ArrayList()

        var mList = ArrayList<DataModel>()
        mList.add(DataModel(nestedList1, "Кийим, пойабзал ва аксессуарлар"))
        mList.add(DataModel(nestedList2, "Ошхона Жихозлари"))
        mList.add(DataModel(nestedList3, "Компьютерлар ва оргтехника"))
        mList.add(DataModel(nestedList4, "Уй ва Офис учун"))
        mList.add(DataModel(nestedList3, "Телефонлар ва Гаджетлар"))
        mList.add(DataModel(nestedList2, "Китоблар"))
        mList.add(DataModel(nestedList1, "Мебел"))

        adapter = ItemAdapter(mList)
        recyclerView.setAdapter(adapter)
    }
}