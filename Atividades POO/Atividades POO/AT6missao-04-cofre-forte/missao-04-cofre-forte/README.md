# Missao 04 - Cofre Forte

Projeto Java criado a partir do diagrama UML e das regras de negocio RN01, RN02 e RN03.

## Estrutura do projeto

- `Agencia.java`: constantes globais e contador estatico de contas.
- `Cliente.java`: CPF imutavel, encapsulamento, `equals`, `hashCode` e `toString` seguro.
- `ContaBancaria.java`: saldo protegido, deposito e saque com taxa.
- `MainTeste.java`: campo de provas solicitado na atividade.

## Executar no PowerShell do VS Code

Abra esta pasta no VS Code e execute:

```powershell
javac -d bin src\br\com\banco\model\Agencia.java src\br\com\banco\model\Cliente.java src\br\com\banco\model\ContaBancaria.java src\br\com\banco\main\MainTeste.java
java -cp bin br.com.banco.main.MainTeste
```

## Saida esperada

```text
Os clientes sao iguais.
Saque realizado: false
Saldo atual: R$ 50.0
Total de contas abertas: 1
Cliente: Joao | Contato: joao@email.com
```

## Enviar ao GitHub

```powershell
git add .
git commit -m "feat: implementa arquitetura bancaria segura"
git push
```
