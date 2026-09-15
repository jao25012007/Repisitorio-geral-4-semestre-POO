# Missao 08 - Operacao Zero Trust

Projeto Java que demonstra encapsulamento, composicao de objetos e o uso de Array, ArrayList e HashSet no controle de acesso da CyberCorp.

## Pacotes

- `br.com.cybercorp.model`: entidades do dominio.
- `br.com.cybercorp.service`: sistema de seguranca.
- `br.com.cybercorp.main`: campo de provas da aplicacao.

## Executar no PowerShell do VS Code

Abra diretamente esta pasta no VS Code e execute:

```powershell
javac -encoding UTF-8 -d bin (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
java -cp bin br.com.cybercorp.main.MainTeste
```

## Comportamento esperado

O programa permite duas passagens do mesmo funcionario na catraca, aceita a credencial original, bloqueia o clone no cofre e estaciona o veiculo na vaga 0.

No ultimo teste, ele encerra propositalmente com `ArrayIndexOutOfBoundsException`, pois a garagem possui somente as vagas 0 e 1, e o enunciado exige uma tentativa na vaga 5.

## Enviar ao GitHub

```powershell
git add .
git commit -m "feat: implementa controle de acesso zero trust"
git push
```
