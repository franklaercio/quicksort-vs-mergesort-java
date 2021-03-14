# Quicksort vs Mergesort

Universidade Federal do Rio Grande do Norte

Instituto Metrópole Digital

DIM0119 - ESTRUTURA DE DADOS BÁSICAS I - T02 (2020.2)

Docente: Guilherme Fernandes de Araujo

Alunos: Frank Laércio da Costa Santos Júnior <br />
        Ohanna de Macena Dezidério

## Resumo

Este trabalho irá comparar dois algoritmos de ordenação, o Quicksort e o Mergesort. Eles partem da mesma estratégia de dividir para conquistar e possuem a mesma complexidade no melhor e pior caso. Sendo no melhor caso O (n log n) e no pior caso O (n²). Para realizar as análises os algoritmos foram implementados na linguagem Java e os gráficos foram gerados no Google Sheets.

## Quicksort

Esse algoritmo foi criado em 1960 por C.A.R Hoare. Ele baseia-se em um usar um número como pivô para realizar as comparações e separar em duas listas de elementos, uma com os elementos menores que o pivô e outra com os elementos maiores que o pivô.

```java
private static void quickSort(int[] numbers, int start, int end) {
    if(start < end) {
        int pivot = partition(numbers, start, end);

        quickSort(numbers, start, pivot - 1);
        quickSort(numbers, pivot + 1, end);
    }
}
```

No exemplo acima, é possível perceber que somente é possível chamar a função *quickSort* se o elemento de início foi menor que o elemento final e que primeiro chama-se recursivamente a função *quickSort* dos elementos anteriores ao pivô e depois disso os elementos posteriores ao pivô.

```java
private static int partition(int[] numbers, int start, int end) {
    int pivot = numbers[end];
    int index = start;

    for (int j = start; j < end; j++) {
        if(numbers[j] < pivot) {
            swap(numbers, index, j);
            index += 1;
        }
    }

    swap(numbers, index, end);

    return index;
}
```

```java
private static void swap(int[] numbers, int start, int end) {
    int aux = numbers[start];
    numbers[start] = numbers[end];
    numbers[end] = aux;
}
```

Nesse pseudocódigo é possível identificar que o pivô é definido como o último elemento e que a troca é feita sempre que um elemento for menor que o pivô e antes de ter um retorno é feito a troca do último número. Além disso, no final é retornado o meu próximo pivô, sendo o último elemento que foi percorrido nessa lista.

## Mergesort

Esse algoritmo foi criado em 1945 por John van Neumann. Ele baseia-se na estratégia de definir o elemento do meio da lista e assim ir separando em listas cada vez menores até que chegue em uma de tamanho 1. Após isso, é feita uma comparação com os elementos a esquerda e a direita dessas listas, verificando se o elemento menor ou maior.

```java
private static void mergeSort(int[] numbers, int start, int end) {
    if(start >= end){
        return;
    }

    int middle = start + ((end-start)/2);

    mergeSort(numbers, start, middle);
    mergeSort(numbers, middle + 1, end);

    merge(numbers, start, middle, end);
}
```

No pseudocódigo acima é possível verificar a condição de parada do algoritmo recursivo que é se o elemento de início é maior ou igual ao elemento final. Além disso, nessa parte é definido o elemento do meio que é o do início mais a média do final e início. Da mesma forma que ocorre no Quicksorte no Mergesort também é feita a chamada recursiva passando os elementos do início até uma determinada posição e dessa posição até o final. No final é feito o merge dessa chamada recursiva até que toda lista seja ordenada.

Como a parte do merge no Mergesort é um pouco mais complexa de ser entendida iremos dividir ela em 3 partes. A primeira é a parte que definimos o tamanho dos elementos da esquerda e o tamanho dos elementos da direita e inserimos nesses vetores, respectivamente do início até antes do meio e do meio até o final.

```java
int lengthLeft = middle - start + 1;
int lengthRight = end - middle;

int[] left = new int[lengthLeft];
int[] right = new int[lengthRight];

for (int i = 0; i < lengthLeft; i++) {
    left[i] = numbers[start + i];
}

for (int j = 0; j < lengthRight; j++) {
    right[j] = numbers[middle + 1 + j];
}
```

Na segunda parte é onde será feito de fato a ordenação dos números e o "merge" deles na lista principal de elementos, pois é nessa parte onde será comparado se o elemento da esquerda é menor ou igual ao elemento da direita.

```java
while (topLeft < lengthLeft && topRight < lengthRight) {
    if (left[topLeft] <= right[topRight]) {
        numbers[k] = left[topLeft];
        topLeft++;
    } else {
        numbers[k] = right[topRight];
        topRight++;
    }
    k++;
}
```

Na última parte do merge são adicionados os elementos que não foram adicionados no merge que compara os elementos da esquerda e direita, para que nenhum elemento fique faltando na lista principal.

```java
while (topLeft < lengthLeft) {
    numbers[k] = left[topLeft];
    topLeft++;
    k++;
}

while (topRight < lengthRight) {
    numbers[k] = right[topRight];
    topRight++;
    k++;
}
```

## Quicksort vs Mergesort

Para comparar os dois algoritmos de ordenação foram utilizadas as instâncias de quantidade de elementos de 5, 10, 20, 40, 80, 160, 320, 640, 1280 e 2560 elementos do tipo inteiro. Além disso, dividiu-se em dois casos de testes, um com elementos já ordenados e outros com elementos não ordenados e mediu-se o tempo de execução desses testes em nanosegundos no algoritmo, mas no Google Sheets converteu-se para mile segundos para ajudar na elaboração do gráfico.

![Quicksort%20vs%20Mergesort%2066f29d3d76e0491e90903251a7e40cc5/Quicksort_e_Mergesort_com_Nmeros_Ordenados.svg](Quicksort%20vs%20Mergesort%2066f29d3d76e0491e90903251a7e40cc5/Quicksort_e_Mergesort_com_Nmeros_Ordenados.svg)

Imagem 1: gráfico comparativo do Quicksort em relação ao Mergesort

![Quicksort%20vs%20Mergesort%2066f29d3d76e0491e90903251a7e40cc5/Quicksort_e_Mergesort_com_Nmeros_no_Ordenados.svg](Quicksort%20vs%20Mergesort%2066f29d3d76e0491e90903251a7e40cc5/Quicksort_e_Mergesort_com_Nmeros_no_Ordenados.svg)