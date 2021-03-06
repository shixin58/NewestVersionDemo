package com.bride.demon.demo

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.AttributeSet
import android.view.View

import kotlin.also

/**
 * <p>Created by shixin on 2019-05-07.
 */
class Customer public constructor(val name: String) {

    val firstProperty = "first property name = $name".also(::println)

    init {
        println("primary initializer")
    }

    val secondProperty = "second property name.length() = ${this.name.length}".also(System.err::println)

    init {
        println("second initializer")
    }

    public constructor(name: String, age: Int) : this(name) {
        println("secondary constructor")
    }
}

class DontCreateMe internal constructor(val id: Int = 0) : Any() {
    init {
        println("primary initializer")
    }
}

class MyView : View {

    constructor(ctx : Context) : super(ctx)

    constructor(ctx : Context, attrs : AttributeSet) : super(ctx, attrs)
}

fun main() {
    Customer("Victor", 30)
    DontCreateMe()
    Derived().f()

    val max = User(name = "Max", age = 20)
    val oldMax = max.copy(age = 30)
    // destructuring, Pair/Triple
    val (name, age) = max
    println("name = $name, age = $age")

    f(Past("20 years ago"))
    f(NotAString)

    val i = Outer.Nested().get()
    val k = ShorterNested().get()
    val j = Outer().Inner().retrieve()
    println("i = $i, j = $j")

    DataProviderManager.create()
    val factory = MyClass.Companion
    factory.create()

    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f))
    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -1).filter(p))
}

open class Base() {

    open val a: Int get() {
        return 1
    }

    lateinit var z: String

    open val v: String = "boy".also { println("Initializing v in Base") }

    open fun f(): Unit {
        System.out.println("Base#f()")
        if (Base::z.isLateinit) {
            z = "大器晚成"
            println("z = $z")
        }
    }
}

class Derived : Base(), Foo {

    override fun struggle() {

    }

    override fun eat() {

    }

    override val count: Int
        get() = super.a + 1

    final override val a: Int = 1.also { println("Initializing a in Derived") }

    // backing fields
    override var v: String = "Good"
        set(value) {
            if (value != null) field = value
        }

    var k: Int? = 3
        private set

    final override fun f() {
        super<Base>.f()
        super<Foo>.f()
        System.out.println("Derived#f()")
    }

    abstract inner class Sub {

        fun s() {
            super<Base>@Derived.f()
            println("Base#a = ${super@Derived.a}")
        }

        abstract fun h()
    }
}

internal interface Foo : Edible, Capable {

    val count: Int// abstract

    val name: String
        get() = "$count"

    fun f() {
        println("Foo#f()")
    }
}

internal interface Edible {
    fun eat()
}

internal interface Capable {
    fun struggle()
}

private fun func() = object : Edible, Capable{

    override fun eat() {

    }

    override fun struggle() {

    }
}

// Top-level, Compile-Time Constants
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() {

}

data class User(val name: String = "Victor", val age: Int = 30)

sealed class Times
data class Past(val d: String) : Times()
data class Present(val d: String) : Times()
data class Future(val d: String) : Times()
object NotAString : Times()
open class NextDecade : Times()

fun f(v: Times): String = when(v) {
    is Past -> v.d
    is Present -> v.d
    is Future -> v.d
    NotAString -> ""
    is NextDecade -> ""
}

// anonymous inner class, lambda expressions
val listener = View.OnClickListener {
    when(it.id) {

    }
}

val onLongClickListener = object : View.OnLongClickListener {
    override fun onLongClick(v: View?): Boolean {
        return false
    }
}

class Outer {

    class Nested {
        fun get() = 1
    }

    inner class Inner {
        fun retrieve(): Int {
            return 2
        }
    }
}

typealias ShorterNested = Outer.Nested

abstract class DataProvider {
    abstract fun create()
}

object DataProviderManager : DataProvider() {
    override fun create() {
        println("DataProviderManager#create")
    }
}

interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object : Factory<MyClass> {
        @JvmStatic
        override fun create(): MyClass {
            return MyClass()
        }
    }
}

// function type
typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(24)