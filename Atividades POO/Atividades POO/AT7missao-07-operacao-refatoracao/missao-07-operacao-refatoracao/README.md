# Missao 07 - Operacao Refatoracao

Projeto Java que substitui o codigo legado de frete pelo padrao Strategy, aplicando polimorfismo, OCP e uma excecao personalizada.

## Pacotes

- `br.com.ecommerce.model`: estrategia, tipos de frete e calculadora.
- `br.com.ecommerce.exception`: excecao de frete invalido.
- `br.com.ecommerce.main`: classe de teste da aplicacao.

## Executar no PowerShell do VS Code

Abra diretamente esta pasta no VS Code e execute:

```powershell
javac -d bin (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
java -cp bin br.com.ecommerce.main.MainTeste
```

## Saida esperada

```text
Frete SEDEX: R$ 10,00
Frete PAC: R$ 5,00
Frete Motoboy: R$ 15,00
Erro: tipo de frete invalido.
```

Dependendo da configuracao regional do Java, os valores podem aparecer com ponto no lugar da virgula.

## Enviar ao GitHub

```powershell
git add .
git commit -m "refactor: aplica strategy no calculo de frete"
git push
```
