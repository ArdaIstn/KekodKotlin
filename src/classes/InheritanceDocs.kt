package classes

fun main() {
    val shape = Shape()
    shape.draw()
    val circle = Circle()
    circle.draw()
    val rectangle = Rectangle()
    rectangle.draw()
    val triangle = Triangle()
    triangle.draw()

    println("************")

    val rectangle2 = Rectangle2()
    rectangle2.draw()
    println(rectangle2.borderColor)

    val filledRectangle = FilledRectangle()
    filledRectangle.draw()
    println(filledRectangle.borderColor)


}

class Example : Any() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
    // Bu funlar open fun ise ben bunlari override edebilirim.

}

open class Shape {
    open fun draw() {
        println("Draw Shape")
    }

    fun fill() {}
}

class Circle() : Shape() {
    override fun draw() {
        super.draw()
        println("Draw Circle")
    }

}

open class Rectangle : Shape() {
    final override fun draw() {
        super.draw()
        println("Draw Rectangle")
    }
}

class Triangle : Rectangle() {
    /**
     *  override fun draw() {
     *         super.draw()
     *         println("Draw Triangle")
     *     } draw artik override edilemez.
     */

}

open class Rectangle2 {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle2() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}












