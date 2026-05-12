# Nanamed Pharmacy Management System - Algoritmo de Ordenação

**Número da Lista**: 2  
**Conteúdo da Disciplina**: FGA0239 - ESTRUTURA DE DADOS 2 - T01

## Alunos

<div align = "center">
<table>
  <tr>
    <td align="center"><a href="https://github.com/victorcamaraa"><img style="border-radius: 50%;" src="https://github.com/victorcamaraa.png" width="190px;" alt=""/><br /><sub><b>Victor Camara</b></sub></a><br /><a href="Link git" title="Rocketseat"></a></td>
    <td align="center"><a href="https://github.com/yanzin00"><img style="border-radius: 50%;" src="https://github.com/yanzin00.png" width="190px;" alt=""/><br /><sub><b>Yan Guimarães </b></sub></a><br />
  </tr>
</table>

| Matrícula   | Aluno                             |
| ----------- | ---------------------------------- |
| 222006220  | Yan Lucas Souza Guimarães |
| 221031238  | Victor Augusto de Sousa Camara |
</div>

## Apresentação

[Vídeo de demonstração](https://drive.google.com/drive/folders/1iFZ5N3bZ-zTFKSO7wrfIlDC-y0j5MnkC?usp=sharing)

## Sobre

Este projeto foi originalmente desenvolvido pelo aluno **Yan Lucas** como parte da disciplina de **Orientação a Objetos**. O sistema fornece uma solução de gerenciamento de inventário para a Nanamed, uma cadeia de farmácias com várias filiais.

Como evolução para a disciplina de **Estrutura de Dados 2**, tivemos a ideia de implementar um **algoritmo de ordenação eficiente** na funcionalidade de busca e visualização de produtos em cada filial. Isso permite que o farmacêutico ou gerente organize o estoque instantaneamente por critérios críticos como Quantidade, Validade e Preço.

## Funcionalidades

- **Gestão de Filiais:** Registra e gerencia diferentes filiais da Nanamed.
- **Controle de Inventário:** Mantém um registro detalhado dos produtos disponíveis em cada filial.
- **Ordenação Dinâmica:** Permite classificar os itens em tempo real utilizando um algoritmo híbrido (Merge/Insertion Sort).
- **Atualização de Estoque:** Permite a adição e remoção de novos produtos e atualização de quantidades.

## Algoritmos de Ordenação Implementados

O projeto utiliza um **algoritmo híbrido** (padrão do Java `List.sort()`), derivado do **Merge Sort** e **Insertion Sort**. Ele foi escolhido por sua excelente performance em dados do mundo real e por ser altamente otimizado para a JVM.

### Critérios de Avaliação e Escolha
A escolha do algoritmo baseou-se nos seguintes pilares técnicos:
1. **Estabilidade:** Crucial para manter a ordem relativa de produtos com o mesmo valor (ex: dois produtos com o mesmo preço mantêm sua ordem de cadastro).
2. **Complexidade de Tempo:** 
  - Pior caso e Caso médio: **O(N log N)**.
  - Melhor caso: **O(N)** (extremamente eficiente para listas que já possuem algum nível de ordenação).
3. **Eficiência de Memória:** Otimizado para reaproveitar estruturas de dados na JVM, superando implementações manuais de Mergesort em termos de overhead.

### Comparação com Outros Algoritmos
| Algoritmo | Estável | Pior Caso | Melhor Caso | Notas |
|-----------|---------|-----------|-------------|-------|
| **Híbrido (Merge/Insertion)** | Sim | O(N log N) | O(N) | Ideal para interfaces e dados reais. |
| **Quicksort** | Não | O(N²) | O(N log N) | Rápido, mas instável e pior no pior caso. |
| **Mergesort** | Sim | O(N log N) | O(N log N) | Estável, mas com maior custo de memória. |

### Critérios de Ordenação Disponíveis
| Critério | Tipo de Dado | Ordem Aplicada |
|-----------|------|----------|
| Quantidade | Inteiro | Decrescente (Maior estoque primeiro) |
| Preço | Float/Double | Crescente (Menor preço primeiro) |
| Validade | String (ISO) | Cronológica |

## Arquitetura da Interface de Ordenação

A funcionalidade foi integrada de forma desacoplada para garantir a responsividade da interface:

- **Componente UI**: Um `JComboBox` na `TelaEstoque` atua como o gatilho. O listener detecta a mudança de critério e invoca o controlador.
- **Controlador (`ControleEstoque`)**: Centraliza a lógica de agregação. Ele combina as listas de Medicamentos e Cosméticos em uma estrutura única antes de aplicar a ordenação.
- **Modelo de Comparação**: Utiliza `Comparator.comparing` para definir a lógica de ordenação de forma limpa e extensível.

```java
// Exemplo da lógica interna de comparação
switch (criterio) {
    case "Quantidade":
        todosProdutos.sort(Comparator.comparingInt(Produto::getQuantidade).reversed());
        break;
    case "Preco":
        todosProdutos.sort(Comparator.comparingDouble(Produto::getPreco));
        break;
}
```

## Screenshot

## Requisitos

- **Java JDK 11** ou superior instalado.

## Configurando o Projeto

### 1. Clone o Projeto
```bash
git clone https://github.com/yanzin00/G1_ordenacao_EDA2-2026.1.git
cd G1_ordenacao_EDA2-2026.1
```

### 2. Compilação
A partir da raiz do projeto, execute:
```bash
# Cria o diretório de binários se não existir
mkdir -p nanamed/bin

# Gera a lista de fontes e compila
find nanamed/src -name "*.java" ! -name "Test.java" > sources.txt
javac -d nanamed/bin @sources.txt
```

### 3. Execução
```bash
java -cp nanamed/bin view.TelaMenu
```

## Como Usar

1. **Menu Principal**: Visualize a lista de filiais cadastradas.
2. **Entrar no Estoque**: Selecione uma filial para ver seus produtos.
3. **Ordenar**: Utilize o dropdown **"Classificado por:"** no canto inferior para alternar entre as visualizações de Quantidade, Validade ou Preço.
4. **Gerenciar**: Adicione novos medicamentos ou cosméticos e veja-os sendo integrados à lista ordenada.
