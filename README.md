
# 🌳 PjBL 2 - Árvore Binária 🌳

Em Java, uma árvore é uma estrutura de dados que consiste em nós interconectados, onde cada nó tem zero ou mais nós filhos. Essa estrutura é amplamente utilizada para representar hierarquias de dados e é usada em várias aplicações, como em estruturas de dados, análise sintática de linguagens de programação (árvores sintáticas), organização de sistemas de arquivos, entre outros.


## Desenvoldido por:

- [@elvisclaudino](https://github.com/elvisclaudino)
- [@GabrielFasolim](https://github.com/GabrielFasolim)


# [Árvore Binária de Busca (ABB)](https://www.freecodecamp.org/portuguese/news/arvores-binarias-de-busca-bst-explicada-com-exemplos/)

Uma Árvore Binária de Busca (ABB) é uma estrutura de dados hierárquica em que cada nó tem no máximo dois filhos: um à esquerda, com valores menores, e um à direita, com valores maiores que o nó pai. Isso cria uma organização eficiente dos elementos, facilitando a busca, inserção e remoção com complexidade média de O(log n) em árvores balanceadas. As ABBs são amplamente utilizadas em aplicações que requerem armazenamento ordenado e busca rápida, como bancos de dados, sistemas de busca e implementações de dicionários.

![ABB](https://i.imgur.com/6dkbWTs.png)

## Estrutura da Árvore

- A classe `No` representa os nós da árvore, cada um contendo um valor (ou dado) e referências para os filhos esquerdo e direito, de acordo com as regras de ABB.

- A classe `ArvoreABB` representa a ABB propriamente dita e contém um nó raiz como ponto de entrada para a árvore.

## Funcionalidades


- **Inserção**: A inserção de elementos segue as regras de ABB, onde valores menores são colocados à esquerda e valores maiores à direita.

- **Busca**: A busca em uma ABB é eficiente, permitindo localizar um valor específico na árvore de forma rápida.

- **Remoção**: A remoção de elementos é implementada mantendo a propriedade da ABB e reorganizando os nós, se necessário.

- **Impressão**: A impressão da árvore pode ser feita em ordem, pré-ordem ou pós-ordem, facilitando a visualização dos elementos.

## Uso

O exemplo de uso pode ser encontrado no arquivo `Teste.java` dentro da pasta ABB, onde são demonstradas as operações de inserção, busca e impressão em uma ABB.


# [Árvore AVL (Balanceada)](https://www.freecodecamp.org/portuguese/news/insercao-rotacao-e-fator-de-balanceamento-da-arvore-avl-explicados/)

Uma Árvore AVL (Adelson-Velsky e Landis) é uma variação de uma Árvore Binária de Busca (ABB) em que é mantido um fator de balanceamento em cada nó para garantir que a árvore permaneça balanceada. O balanceamento é alcançado através de rotações simples ou duplas quando um nó se torna desbalanceado após uma operação de inserção ou remoção. Uma AVL oferece uma complexidade de tempo média O(log n) para operações de busca, inserção e remoção, tornando-a adequada para cenários em que a eficiência na manipulação de dados é essencial, como bancos de dados e sistemas de busca.

![AVL](https://i.imgur.com/yTAp9ee.png)





