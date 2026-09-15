# Lista 12 - Operacao Big Data

Projeto Java da TechNexus com expressoes Lambda, Streams API e um desafio extra de criptografia AES/PBKDF2.

## Estrutura

- `br.com.technexus.model.Produto`: entidade do catalogo.
- `br.com.technexus.model.Loja`: relatorios com Streams.
- `br.com.technexus.main.Main`: campo de provas dos exercicios.
- `br.com.technexus.security.ForcaBruta`: desafio extra.

## Entrar na pasta interna

Depois de extrair o ZIP, execute primeiro:

```powershell
cd .\missao-08-streams
```

## Compilar

O metodo `Stream.toList()` exige Java 16 ou superior.

```powershell
javac -encoding UTF-8 -d bin (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
```

## Executar os relatorios

```powershell
java -cp bin br.com.technexus.main.Main
```

Valores esperados:

- Patrimonio total: R$ 580,00.
- Total da categoria LIVROS: R$ 180,00.
- A busca por GAMES mostra apenas The Witcher e FIFA.

## Executar o desafio extra

```powershell
java -cp bin br.com.technexus.security.ForcaBruta
```

Observacao: o texto cifrado fornecido na lista foi testado com todas as 46.656 senhas entre `lam000` e `lamzzz`. Nenhuma delas produz uma descriptografia valida usando os parametros informados (AES-256-CBC, PBKDF2/SHA-256 e 1.000 iteracoes). A classe executa corretamente toda a busca e informa essa inconsistencia ao terminar.

## Enviar ao GitHub

```powershell
git add .
git commit -m "feat: implementa relatorios com lambdas e streams"
git push
```
