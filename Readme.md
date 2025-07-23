# Mini Projeto: Sistema de Loja com Emissão de Nota de Compra

Turma 01 - Programação Orientada a Objetos 

Membros:
Cleysla Maria Santos Ferreira,
José Gabriel Silva Santana &
Maria Aparecida Nascimento dos Santos

# Uso das ferramentas 'upcast' e 'downcast'

No nosso projeto, utilizamos a ferramenta 'upcast' para armazenar objetos das subclasses NotaFiscalProduto e NotaFiscalServico em listas ou variáveis do tipo NotaFiscal, permitindo, assim, tratar diferentes tipos de nota de forma genérica e simples.

Exemplo: "notas[quantidadeNotas] = new NotaFiscalProduto(...); " <br/>

Aqui, estamos colocando um objeto da subclasse (NotaFiscalProduto) dentro de uma variável do tipo da superclasse (NotaFiscal) porque queremos guardar qualquer tipo de nota (produto ou serviço) num único array. Só conseguimos isso se usarmos a superclasse como tipo base (NotaFiscal[]), já que ela é comum a todas as subclasses.

---

Já a ferramenta 'downcast' é usado quando precisamos acessar comportamentos ou informações específicas de uma subclasse, sendo necessário converter manualmente a referência da superclasse de volta para a subclasse original.

Exemplo: if (nota instanceof NotaFiscalProduto) {
    NotaFiscalProduto nfProduto = (NotaFiscalProduto) nota;
    
}

Estamos verificando se a nota é mesmo do tipo NotaFiscalProduto, e então fazemos um downcast para acessar os métodos exclusivos dela porque o tipo NotaFiscal não conhece os métodos das subclasses. Para usá-los, precisamos converter (fazer o cast) de volta para o tipo real da nota.

Ambos são úteis para aplicar os princípios de polimorfismo e reutiluzação do código, facilitando a organização e manutenção do sistema.
