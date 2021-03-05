# Java Swing - shape manager
The Java Swing application developed for CA#1 LYIT. The app purpose is displaying, moving and rotating the shapes. 
Implementation involves the concept of Inheritance, Polymorphism, Abstract class and Interfaces.

## TesterApp
The file TesterApp.java is the entry point of application.

## ConstsApp
This file holds all constance variables like Swing window width (FRAME_WIDTH),  Swing window width (FRAME_HEIGHT),
Move units it's implemented to move shapes (MOVE_UNITS), Angle rotation it's implemented to rotate shapes (ANGLE_ROTATION)

### Shape
It's abstract class for all shapes contains protected attributes. Three abstract methods the shapes needs to implement.

#### Rectangle
Rectangle extends Shape class and implements MoveAble interface. It has two constructors:
```java
new Rectangle(Color color, int xCenter, int yCenter, int width, int height);
```

```java
new Rectangle(Color color, int xCenter, int yCenter, boolean filled, int width, int height);
```


#### Rectangle Mouse Event
On left click the shape is toggling the colour filling. 
On right click moves MOVE_UNITS defined in ConstsApp.java

#### Square
Square shape extends Rectangle class and inherits all methods from its parent. 
```java
new Square(Color color, int xCenter, int yCenter, boolean filled, int width);
```

#### Circle
extends Shape class. It has two constructors
```java
new Circle(Color color, int xCenter, int yCenter, boolean filled, int radius);
```
```java
new Circle(Color color, int xCenter, int yCenter, int radius);
```

#### Circle Mouse Event
On left click the shape is toggling the colour filling.

#### Quadrilateral
Rectangle extends Shape class and implements MoveAble interface. It has four constructors:
```java
new Quadrilateral(Point centerPoint, Point[] points );
```

```java
new Quadrilateral(Color color, boolean filled, Point centerPoint, Point[] points);
```

```java
new Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4);
```

```java
new Quadrilateral(Rectangle rect);
```

#### Quadrilateral Mouse Event
On left click the shape is toggling the colour filling.
On right click rotates ANGLE_ROTATION angles defined in ConstsApp.java
#### Author: Mariusz Januszkiewicz <L00162996@student.lyit.ie>