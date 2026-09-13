# Literales

Un token de tipo literal es la representación de un valor
en forma de caracteres de texto dentro del código fuente.

En Java los únicos valores representables de manera literal en código son:
1. Tipos primitivos
2. Tipo String (cadenas de caracteres)
3. Tipo nulo

## 1. Literales de tipos primitivos
### 1.1 Literales enteros

Un literal entero se considera un valor de tipo **int** por defecto.
- Si se añade el sufijo L entonces se considera un valor de tipo **long**.


Un literal de valor entero se puede expresan e 4 bases:
* decimal (base 10) 
* hexadecimal (base 16) 
* octal (base 8)
* binario (base 2)

Se permite usar el _ para separar las cifras (digitos) del número.

---
#### 1.1.1 Decimal
El 0 y cualquier sucesión de dígitos que no empiece por el 0

Ejemplos:
- 0
- 15
- 124
- 1200
- 1_500
- 1_000_000

El mayor valor literal de tipo entero en decimal es el equivalente a 

2^31 = 2147483648

Y solo se puede usar precedido del operador -

Ya que para positivos el valor máximo permitido es el inmediatamente anterior 
2^31 - 1 = 2147483647

---
#### 1.1.2 Hexadecimal
Empezando por 0x o 0X (seguido de uno o más dígitos hexadecimales)
Los dígitos hexadecimales son: 0 1 2 3 4 5 6 7 8 9 A B C D E F

Ejemplos:
- 0xFA
- 0xFF12CDBA
- 0xFF_12_CB_DA

El mayor valor literal positivo de tipo int en hexadecimal sería (2^31-1):
* 0x7fff_ffff
El valor más negativo sería:
* 0x8000_0000

---
#### 1.1.3 Octal
Empezando por 0 (seguido de uno o más dígitos octales)
Los dígitos octales son: 0 1 2 3 4 5 6 7

Ejemplos:
- 00
- 010
- 027
- 01_000_00

---
#### 1.1.4 Binario
Empezando por 0b o 0B (seguido de uno o más dígitos binarios)
Los dígitos binarios son: 0 1

Ejemplos:
- 0b0
- 0b1111_0101_1100_1110_0101_1101_0001_1001

El mayor valor positivo int:
* 0b0111_1111_1111_1111_1111_1111_1111_1111
El mas negativo int:
* 0b1000_0000_0000_0000_0000_0000_0000_0000
El valor -1
* 0b1111_1111_1111_1111_1111_1111_1111_1111


