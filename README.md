# Sistema de Farmácia

Projeto Pessoal Obrigatório da disciplina de Programação Orientada a Objetos (Java) - ADS / UTFPR Cornélio Procópio.

Sistema de console para uma farmácia: cadastro de produtos, clientes e registro de vendas, com controle de estoque e exigência de receita para remédios controlados.

## Classes

- `ItemFarmacia` - classe mãe dos produtos
- `Remedio`, `Cosmetico`, `Higiene`, `AparelhoMedico` - tipos de produto
- `Controlado` - remédio que exige receita
- `Cliente` e `Venda`
- `Calculo` - interface com o cálculo do total da venda
- `EstoqueInsuficienteException` e `ReceitaObrigatoriaException`
- `Leitura`, `Controle` e `Principal` - entrada de dados, menu e regras do sistema

## Como executar

```
cd src
javac *.java
java Principal
```

## Autor

Ricardo Augusto Scalada Mercante - RA a2865483
