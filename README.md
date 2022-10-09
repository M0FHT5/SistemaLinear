# Sistema Linear
Sistema de Equações Lineares

Método de Eliminação de Gauss

Link para download: 
https://github.com/M0FHT5/SistemaLinear.git
---
## 1.Autor
Wellington Santos

Todos os bugs e fixes podem ser enviados para wss.m0fht5@gmail.com

Bubs/Fixes reportados serão submetidos a correção.

## 2.Descrição
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
## 3.Funcionamento

O programa foi desenvolvido com base nos padrões de arquitetura MVC(bem simplificado) e está dividido em três partes:
   - Classe de inicialização do aplicativo.
   - Classe de controle, onde se encontram os métodos, eventos e funções do programa.
   - Classe de interface, responsável por criar o Frame e organizar os componentes gráficos, tais como campos, botões, painéis, etc.

Ao executar a aplicação a seguinte tela será apresentada:

![tela1telainicial](https://user-images.githubusercontent.com/34487807/33921054-926e3148-dfa8-11e7-9e5a-dbde07f364a1.png)

#### 3.1 Sistema Possível e Determinado

No exemplo a seguir, os campos foram preenchidos com valores, de tal forma, que a solução do sistema é única. Portanto o sistema é **possível** e **determinado**:

![tela2solucaounica](https://user-images.githubusercontent.com/34487807/33921056-9294c574-dfa8-11e7-8806-7b3989f99de9.png)

O método `imprimeMatriz()` imprimirá no console do framework eclipse as respectivas matrizes durante o processo de escalonamento. Aqui devo frisar que os processos internos do programa, podem em certas circunstâncias alterar a ordem das equações, por exemplo, a equação que possuir o coeficiente de X mais próximo ou igual a 1, se tornará a primeira equação do sistema, o que não interfere no resultado final. O método `imprimeMatriz()` também admite apenas duas casas decimais após a vírgula, realizando o arredondamento, já que não representam os valores reais que fazem parte do processo de resolução do sistema, pois tem apenas propósito ilustrativo. As matrizes geradas no sistema do exemplo anterior são as seguintes:

![matrizsolucaounica](https://user-images.githubusercontent.com/34487807/33921052-9220672e-dfa8-11e7-84e1-ad811e21c9f3.png)

Note que a última matriz representa a forma mais simplificada do processo de escalonamento, e portanto nos fornece a solução final do sistema. Geometricamente representam retas concorrentes, onde há um ponto (x1, y2, z3) de intersecção que é solução única do sistema.

#### 3.2 Sistema Possível e Indeterminado

No exemplo a seguir, os campos foram preenchidos com valores, de tal forma, que o sistema admite infinitas soluções. Portanto o sistema é **possivel** e **indeterminado**.

![tela3possivelindeterminada](https://user-images.githubusercontent.com/34487807/33921057-92bac2d8-dfa8-11e7-9a0a-0b5eb77b31d3.png)

As matrizes geradas no processo de escalonamento foram as seguintes:

![matrizpossivelind](https://user-images.githubusercontent.com/34487807/33921062-93a85b10-dfa8-11e7-842d-7238bb440c33.png)

A equação assinalada da última matriz, satisfaz a condição que, geometricamente representam retas coincidentes, onde infinitos pontos comuns fazem parte do conjunto solução do sistema.

#### 3.3 Sistema Impossível

No exemplo a seguir, os campos foram preenchidos com valores, de tal forma, que o sistema não admite solução, ou seja, é **impossível**.

![tela4solucaoimpossivel](https://user-images.githubusercontent.com/34487807/33921058-92fe20fa-dfa8-11e7-974a-ac705b6c0a1a.png)

As matrizes geradas foram as seguintes:

![matrizsolucaoimpossivel](https://user-images.githubusercontent.com/34487807/33921051-91f7c58a-dfa8-11e7-99a1-db3c221fd41a.png)

Não há solução matemática para a equação assinalada na última matriz. Geometricamente representam retas paralelas, onde não há nenhum ponto solução do sistema.

#### 3.4 Notas

O programa admite números reais, de quantidades diferentes de casas decimais na entrada de valores. Porém o resultado final será truncado, limitando-o a até quatro casas decimais após a vírgula. O exemplo a seguir ilustra essa possibilidade:

![tela5numerosfracionais](https://user-images.githubusercontent.com/34487807/33921059-932a2b1e-dfa8-11e7-8326-7ae91b19c8fa.png)

A imagem a seguir representa a prova real do resultado obtido com o programa:

![provareal](https://user-images.githubusercontent.com/34487807/33921053-9246e8fe-dfa8-11e7-95d5-d387a70bac23.png)

A seguir temos as matrizes geradas:

![matriznumerosfracionais](https://user-images.githubusercontent.com/34487807/33921061-93801d4e-dfa8-11e7-87dd-6b72326ffef2.png)

O programa possui alguns tratamentos de erros e impede que valores inválidos sejam processados(Ex.: Letras, campos vazios, etc...). Também lançará uma mensagem de erro, caso todos os coeficientes de um dos tipos das variáveis `(X,Y,Z)` forem nulos, ou seja iguais a zero. Exemplo de mensagem de erro:

![tela6dadosinvalidos](https://user-images.githubusercontent.com/34487807/33921060-9358d8a6-dfa8-11e7-90f4-6400ae5619bb.png)
