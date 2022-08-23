package uz.exemple.task3_recyclerv_inside_nestedsv_k.model

class DataModel {
    private var nestedList: List<String>? = null
    private var itemText: String? = null
    private var isExpandable = false

    constructor(itemList: List<String>, itemText: String) {
        nestedList = itemList
        this.itemText = itemText
        isExpandable = false
    }

    fun setExpandable(expandable: Boolean) {
        isExpandable = expandable
    }

    fun getNestedList(): List<String>? {
        return nestedList
    }

    fun getItemText(): String? {
        return itemText
    }

    fun isExpandable(): Boolean {
        return isExpandable
    }
}