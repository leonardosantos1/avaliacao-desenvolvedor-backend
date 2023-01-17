# avaliacao-desenvolvedor-backend


Endpoins API:

RequestMapping - /pessoa

**GET** - "/" lista todas as pessoas </br>
**GET** - "/{id}" tras dados uma pessoa especifica</br>
**GET** - "/{id}/enderecos" tras os endereços da pessoa do id especificado</br>

**POST** - "/" realizar a criação de uma pessoa&nbsp;
Exemplo payload de envio:&nbsp;
```bash
{
    "nome":"Leonardo",
    "dataNascimento":"01/01/2001",
    "enderecos":[
            {"logradouro":"Rua Ciclano n°3 bairro Fulano","cep":"12345678","numero":3,"cidade":"Teste1"},
            {"logradouro":"Rua Beutrano n°27 bairro Teste","cep":"87654321","numero":27,"cidade":"Teste2"}]
} 
```

**POST** - "/{id}/endereco" realiza a adição de um novo endereço da pessoa passada pelo id&nbsp;
Exemplo payload de envio:&nbsp;
```bash
{
  "logradouro":"Rua Tal n°3 bairro EsseDai",
  "cep":"12345678",
  "numero":3,
  "cidade":"Sumiu"
}
```
**PUT** - "/{id}/enderecoPrincipal" realiza a atualização do endereço principal da pessoa do id fornecido&nbsp;
Exemplo payload de envio:&nbsp;
```bash
{
  "cep":"87654321",
  "numero":27
}
```
**PUT** - "/{id}" realiza a atualização das informações da pessoa fornecida pelo parametro id&nbsp;
Exemplo payload de envio:&nbsp;
```bash
{
  "nome":"Carlos",
  "dataNascimento":"22/02/2002"
}
```


