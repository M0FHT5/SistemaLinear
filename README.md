# SistemaLinear
Sistema de Equações Lineares - System of Linear Equations

## Descrição
O objetivo do programa é encontrar o conjunto solução de um determinado sistema de equações lineares, formado por três equações compostas por três coeficientes, três variáveis e um termo independente cada. O método utilizado para a resolução do sistema, é o método de eliminação de Gauss, que consiste em seguir os seguintes passos:
   1. Escreve-se a matriz aumentada do sistema.
   2. Usa-se operações elementares com as linhas para reduzir a matriz aumentada à forma escalonada por linhas.
   3. Usando substituição de trás pra frente, resolve-se o sistema correspondente à matriz linha-reduzida de (2).
   
O conjunto solução encontrado em (3) é o conjunto solução do sistema de equações lineares dado.
O objetivo desse procedimento é fornecer, para um dado sistema linear, um *sistema equivalente* que seja muito fácil de resolver. Considere por exemplo o sistema:

![sistemalinear](https://user-images.githubusercontent.com/34487807/33915097-9fa63e5c-df88-11e7-86be-42c6fefd8ba7.png)

A matriz aumentada do sistema é:

imagemMatriz

Vamos, então, achar o conjunto solução do sistema usando escalonamento:

imagemSistemaEMatriz

Usa-se o termo em x1 da primeira equação para eliminá-lo das outras. Como x1 não aparece na segunda equação (o seu coeficiente já é zero), basta “zerar” seu coeficiente na terceira. Para isso, substitui-se a terceira equação pela soma dela própria com três vezes a primeira equação:

imagemPrimeiraOperacao

O novo sistema, portanto é:

imagemResultadoPrimeiraOperacao

Em seguida, usa-se o termo em x2 da segunda equação para eliminá-lo das outras. Mas, antes de fazê-lo, multiplica-se a segunda equação por 1/3 para simplificar as contas:

imagemresultadoSegundaOperacao

Elimina-se o termo em x2 da terceira equação:

imagemTerceiraOperacao

O novo sistema é:

imagemResultadoTerceiraOperacao

Elimina-se o termo em x2 da primeira equação. Mas é mais eficiente eliminar, primeiro, os termos em x3 da primeira e da segunda equação, usando a terceira:

quartaOperacao

Substituindo essas novas equações no sistema temos:

resultadoQuartaOperacao

Elimina-se o termo em x2 da primeira equação, usando a segunda. Observe que, graças ao trabalho feito previamente com o x3, não será necessário fazer mais conta alguma envolvendo os seus coeficientes:

quintaOperacao

O novo sistema, finalmente, é:

resultadoQuintaOperacao

Este sistema é tão simples que pode-se imediatamente “ler” seu conjunto-solução: é o conjunto que contém, como único elemento, a lista (x1, x2, x3) = (24, 7, 4).
