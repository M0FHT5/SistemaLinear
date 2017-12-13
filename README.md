# SistemaLinear
Sistema de Equações Lineares - System of Linear Equations

## Descrição
O objetivo do programa é encontrar o conjunto solução de um determinado sistema de equações lineares, formado por três equações compostas por três coeficientes, três variáveis e um termo independente cada. O método utilizado para a resolução do sistema, é o método de eliminação de Gauss, que consiste em seguir os seguintes passos:
```
(a) Escreve-se a matriz aumentada do sistema.
(b) Usa-se operações elementares com as linhas para reduzir a matriz aumentada à forma escalonada por linhas.
(c) Usa-se substituição de trás pra frente e resolvemos o sistema correspondente à matriz linha-reduzida de (b).
```   
O conjunto solução encontrado em (c) é o conjunto solução do sistema de equações lineares dado.
O objetivo desse procedimento é fornecer, para um dado sistema linear, um *sistema equivalente* que seja muito fácil de resolver. Considere por exemplo o sistema:

![sistemalinear](https://user-images.githubusercontent.com/34487807/33915097-9fa63e5c-df88-11e7-86be-42c6fefd8ba7.png)

A matriz aumentada do sistema é:

![matrizaumentada](https://user-images.githubusercontent.com/34487807/33916746-786b69bc-df91-11e7-8683-c6d8292fd629.png)

Vamos, então, achar o conjunto solução do sistema usando escalonamento:

![matrizesistema](https://user-images.githubusercontent.com/34487807/33916770-b2a80c7a-df91-11e7-9af5-a3488c916abf.png)

Usa-se o termo em x1 da primeira equação para eliminá-lo das outras. Como x1 não aparece na segunda equação (o seu coeficiente já é zero), basta “zerar” seu coeficiente na terceira. Para isso, substitui-se a terceira equação pela soma dela própria com três vezes a primeira equação:

![primeiraoperacao](https://user-images.githubusercontent.com/34487807/33916787-c7b92fb8-df91-11e7-8fdb-57b9b9ec8cb2.png)

O novo sistema, portanto é:

![resultadoprimeiraoperacao](https://user-images.githubusercontent.com/34487807/33916798-e1128bf8-df91-11e7-9854-8b1235465fb5.png)

Em seguida, usa-se o termo em x2 da segunda equação para eliminá-lo das outras. Mas, antes de fazê-lo, multiplica-se a segunda equação por 1/3 para simplificar as contas:

![resultadosegundaoperacao](https://user-images.githubusercontent.com/34487807/33916850-2ea6e544-df92-11e7-800a-56587a36034e.png)

Elimina-se o termo em x2 da terceira equação:

![terceiraoperacao](https://user-images.githubusercontent.com/34487807/33916875-492fd8e4-df92-11e7-8db6-1c5a19ea41a7.png)

O novo sistema é:

![resultadoterceiraoperacao](https://user-images.githubusercontent.com/34487807/33916889-5781f03a-df92-11e7-9277-b1c7c0f9104a.png)

Elimina-se o termo em x2 da primeira equação. Mas é mais eficiente eliminar, primeiro, os termos em x3 da primeira e da segunda equação, usando a terceira:

![quartaoperacao](https://user-images.githubusercontent.com/34487807/33916896-5f3bf37a-df92-11e7-96f0-53bc3b9272ba.png)

Substituindo essas novas equações no sistema temos:

![resultadoquartaoperacao](https://user-images.githubusercontent.com/34487807/33916959-b64b9490-df92-11e7-9ab8-021376fda25c.png)

Elimina-se o termo em x2 da primeira equação, usando a segunda. Observe que, graças ao trabalho feito previamente com o x3, não será necessário fazer mais conta alguma envolvendo os seus coeficientes:

![quintaoperacao](https://user-images.githubusercontent.com/34487807/33916980-cd2f749c-df92-11e7-9ba7-c7930f3cec39.png)

O novo sistema, finalmente, é:

![resultadoquintaoperacao](https://user-images.githubusercontent.com/34487807/33916987-d873efc2-df92-11e7-9aee-fd67a68ececd.png)

Este sistema é tão simples que pode-se imediatamente “ler” seu conjunto-solução: é o conjunto que contém, como único elemento, a lista (x1, x2, x3) = (24, 7, 4). Este sistema linear é do tipo que possui única solução.

Para um sistema de equações lineares S com coeficientes reais, temos uma, e somente uma das possibilidades abaixo verdadeiras:
```
(a) S admite uma única solução, ou seja, é possível e determinado.
(b) S admite infinítas soluções, ou seja, é possível e indeterminado.
(c) S não admite solução, ou seja, é impossível.
```
