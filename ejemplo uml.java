@startuml Figura 

abstract class Figura {
    -color: String
    +Figura(color: String)
    +(abstract) area(): Double
    +(abstract) perimetro(): Double
    +mostrarColor() : void
}

class Circulo {
    -raio: Double
    +Circulo(color : String, radio: Double)
    +area(): Double
    +perimetro(): Double
}

class Retangulo {
    -ancho : double 
    -alto : double 
    +Rectangulo(color : String, ancho : double, alto : double)
    +area(): Double
    +perimetro(): Double
}

Figura <|-- Circulo
Figura <|-- Retangulo

@enduml