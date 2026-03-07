## Padrão de Commits

Este projeto utiliza o padrão **Conventional Commits** para automatizar o versionamento da biblioteca e a geração de releases.

A versão da biblioteca é determinada automaticamente com base no tipo de commit.

### Formato do commit

```
<tipo>: <descrição curta>
```

Exemplo:

```
feat: adiciona suporte a filtros
fix: corrige deadlock no cadastro
```

### Tipos de commit

| Tipo                         | Uso                                      | Impacto na versão                    |
| ---------------------------- | ---------------------------------------- | ------------------------------------ |
| `feat`                       | Nova funcionalidade                      | Incrementa **minor** (1.2.3 → 1.3.0) |
| `fix`                        | Correção de bug                          | Incrementa **patch** (1.2.3 → 1.2.4) |
| `feat!` ou `BREAKING CHANGE` | Mudança incompatível                     | Incrementa **major** (1.2.3 → 2.0.0) |
| `docs`                       | Alterações de documentação               | Não gera release                     |
| `chore`                      | Tarefas internas (build, deps, etc.)     | Não gera release                     |
| `refactor`                   | Refatoração sem mudança de comportamento | Não gera release                     |

### Exemplos

Nova funcionalidade:

```
feat: adiciona consulta por código de produto
```

Correção de bug:

```
fix: corrige erro de concorrência na atualização de preço
```

Mudança incompatível:

```
feat!: altera contrato da API de consulta de produto
```

### Observações

- Apenas commits `feat` e `fix` geram novas versões automaticamente.
- Commits com `!` indicam **breaking changes** e geram uma nova versão **major**.
- Outros tipos de commit não geram nova versão da biblioteca.
