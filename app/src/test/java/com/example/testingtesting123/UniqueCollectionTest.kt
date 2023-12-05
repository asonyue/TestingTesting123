package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun removeAnItem() {

        val item1 = Item("Item1")
        val item2 = Item("Item2")
        val item3 = Item("Item3")

        collection.addItem(item1)
        collection.addItem(item2)

        val originalSize = collection.size()
        collection.remove(item1)
        collection.remove(item3)
        val newSize = collection.size()
        val booleanValue = collection.get(0) != item1 && collection.get(0) == item2

        assert(originalSize == 2 && newSize == 1 && booleanValue) {"Item not removed"}
    }
}