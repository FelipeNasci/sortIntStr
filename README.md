# sortIntStr
Implementação de um algoritmo para ordenar tanto números inteiros quanto strings.

O programa deve ler de um arquivo de entrada, reconhecer se é string ou número e imprimir na tela a saída ordenada.

As informações no arquivo de entrada deverão estar um por linha (seja número ou string).

## Metodologia

O algoritmo de ordenação implementado foi o MergeSort e a linguagem de programação utilizada foi Java (por sua facilidade no tratamento de Strings e na oferecer um bom suporte a interfaces gráficas na criação do executável).

## Implementação

* O programa lê apenas arquivos TXT.

* O arquivo .TXT deve conter apenas números ou Strings (não há garantias de que funcione com um arquivo contendo os 2)

* As strings não podem conter acentos ou caracteres especiais, pois o software trabalha com os caracteres [97 - 122] da tabela ASCII.

#### Verificação dos dados de entrada

Os dados de entrada são tratados na função sort(), que está contida na classe [Controller.java](https://github.com/FelipeNasci/sortIntStr/blob/master/src/controller/Controller.java).

Após a função receber os dados do arquivo .txt:

- É verificado se os dados são do tipo String ou Inteiro, através da seguinte tomada de decisão

```java

if (isStr(data))
    list = strToChar(aux);
else if (Character.isDigit(data.charAt(0)))
    list = strToInt(aux);
else 
    return "conteúdo inválido";

```

- A função isStr(data) verifica se o primeiro caractere do arquivo tem identificação entre [97 - 122] da tabela ASCII. O caractere é convertido em letra minúscula para não haver necessidade de verificar em outra faixa

- Após a verificação do tipo de dado, a variável list recebe um array de inteiros (sejam os caracteres da tabela ASCII ou os valores do arquivo).

- O [MergeSort](https://github.com/FelipeNasci/sortIntStr/blob/master/src/sort/MergeSort.java) necessitou ser generalizado para ordenar os 02 tipos de dados.

foi criado um vetor rotulando unicamente cada posição do array a ser ordenado.

``` java
int[] tag = new int [vetor.length];
        
for (int i = 0; i < tag.length; i++) tag[i] = i;
    
```

```
vetor = [José | Antenor | Maria | Barbara]
tag   = [  0  |    1    |   2   |    3   ]

Após a ordenação

vetor = [ Antenor | Barbara | José | Maria ]
tag   = [    1    |    3    |   0  |   2   ]

```

- Com o vetor tag[] e o array de entrada original conseguimos ordenar atravé da função recover()

```java
private static String[] recover(String[] original, int[] tag) {

    String[] novo = new String[original.length];

    int pos;

    for (int i = 0; i < original.length; i++) {
        pos = tag[i];               // valor ordenado da proxima posição
        novo[i] = original[pos];    //valor ordenado
    }

    return novo;
}
```

## Modo de uso

* Execute o arquivo [Sort_Int_Str.jar](https://github.com/FelipeNasci/sortIntStr/raw/master/dist/Sort_Int_Str.jar)

![1](https://github.com/FelipeNasci/sortIntStr/blob/master/img/1.PNG)

* Selecione um arquivo .txt contendo os dados a serem ordenados 

**Podem ser utilizados como instâncias de Strings**

```
Miguel
Sophia
Davi
Alice
Arthur
Julia
Pedro
Isabella
Gabriel
Manuela
Bernardo
Laura
```

**Podem ser utilizados como instâncias de inteiros**

```
5
1
2
7
8
9
4
6
8
``` 

![2](https://github.com/FelipeNasci/sortIntStr/blob/master/img/2.PNG)
![3](https://github.com/FelipeNasci/sortIntStr/blob/master/img/3.PNG)

* Click no botão Sort

![4](https://github.com/FelipeNasci/sortIntStr/blob/master/img/4.PNG)