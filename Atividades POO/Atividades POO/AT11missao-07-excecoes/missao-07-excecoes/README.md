# Lista Protocolo de Resiliencia

Projeto Java da Nexus Tech com os exercicios de tratamento de excecoes, programacao defensiva, excecoes customizadas, interfaces e polimorfismo.

## Pacotes

- `br.com.nexustech.main`: execucao dos exercicios 1 a 14.
- `br.com.nexustech.exception`: excecoes customizadas.
- `br.com.nexustech.model`: masmorra, modos de jogo e matchmaker.
- `br.com.fronteira.main`: desafio extra de criptografia.

## Entrar na pasta interna

Depois de extrair o ZIP, abra o terminal na pasta externa e execute primeiro:

```powershell
cd .\missao-07-excecoes
```

## Compilar

```powershell
javac -encoding UTF-8 -d bin (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
```

## Executar os exercicios 1 a 14

```powershell
java -cp bin br.com.nexustech.main.Main
```

## Executar o desafio extra

```powershell
java -cp bin br.com.fronteira.main.App
```

## Enviar ao GitHub

```powershell
git add .
git commit -m "feat: implementa protocolo de resiliencia"
git push
```
