# Missao 03 - Encapsulamento e GitIgnore

Projeto em Java que demonstra o uso de encapsulamento, getters, setters e validacao de regras de negocio.

## Estrutura

- `src/Carro.java`: classe com atributos privados, getters e setters.
- `src/Sistema.java`: classe principal que tenta definir uma velocidade negativa.
- `.gitignore`: impede que arquivos compilados e configuracoes locais sejam enviados ao GitHub.

## Executar no terminal

Dentro da pasta do projeto, use:

```bash
javac -d bin src/Carro.java src/Sistema.java
java -cp bin Sistema
```

Saida esperada:

```text
Erro: Velocidade nao pode ser negativa!
Modelo: Fusca
Cor: Azul
Velocidade: 0 km/h
```

## Enviar ao GitHub

```bash
git add .
git commit -m "feat: aplica encapsulamento e gitignore"
git push
```

Observacao: foi usado `*.class` no `.gitignore`, pois esse e o padrao correto para ignorar todos os arquivos compilados com a extensao `.class`.
