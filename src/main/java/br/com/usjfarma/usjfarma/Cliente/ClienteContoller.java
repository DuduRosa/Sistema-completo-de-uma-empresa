package br.com.usjfarma.usjfarma.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.usjfarma.usjfarma.Repositorys.ClienteRepository;

@Controller
public class ClienteContoller {
    
    
    // Instanciando objeto do repositorio ClienteRepository

    @Autowired
    ClienteRepository ClienteRepositorio;

//======================================= Cliente Mappings =======================================//

    //------------------------------------- Get's---------------------------------------//

    // Link Home para redirecionamento para a pagina de clientes

    @GetMapping(value = "/clientes")
    public ModelAndView getClientes() {
        // Retorna Lista de Medicamentos
        List<Cliente> clientes = ClienteRepositorio.findAll();
        // Retorna ModelAndView com a lista
        ModelAndView modelo = new ModelAndView("./pastaClientes/clientes");
        modelo.addObject("lista", clientes);
        return modelo;
    }

     // Link Clientes para Cadastrar Cliente

     @GetMapping(value = "/cadastrocliente")
    public String getCadastroCliente() {
        return "./pastaClientes/cadastrocliente";
    }

    // Link cliente Excluir

    @GetMapping(value = "/excluircliente/{id}")
    public ModelAndView getExcluirCliente(@PathVariable("id") int id) {

        // Faz a conversão do id int para newId long
        Long newId = Long.valueOf(id);

        // Chama repositorio e indica o id long para excluir do banco
        ClienteRepositorio.deleteById(newId);

        // Retorna pagina clientes
        return getClientes();
    }

    // Link Cliente Visualizar

    @GetMapping(value = "/visualizarcliente/{id}")
    public ModelAndView getVisualizarCliente(@PathVariable("id") int id) {

        // Faz a conversão do id int para newId long
        Long newId = Long.valueOf(id);

        ModelAndView modelo = new ModelAndView("./pastaClientes/visualizar");
        modelo.addObject("cliente", ClienteRepositorio.findById(newId).get());
        // Retorna pagina cliente
        return modelo;
    }

    // Link Cliente Editar

    @GetMapping(value = "/editarcliente/{id}")
    public ModelAndView getEditarCliente(@PathVariable("id") int id) {
        // Converte id Int para Long
        Long nId = Long.valueOf(id);
        // Chama Lista de Contatos do repositorio
        Cliente clienteLista = ClienteRepositorio.findById(nId).get();
        // Envia Lista atraves do modelo
        ModelAndView modelo = new ModelAndView("./pastaClientes/editar");
        modelo.addObject("cliente", clienteLista);
        return modelo;
    }

    //--------------------------------- Post's ------------------------------------------------//

    // Post mapping do formulario de cadastro de Cliente
    @PostMapping(value = "/cadastrocliente")
    public ModelAndView postCadastroCliente(@RequestParam String nome, @RequestParam String telefone,
            @RequestParam String endereco, @RequestParam String cpf, @RequestParam int idade) {

        // Instacia Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);;
        cliente.setEndereco(endereco);;
        cliente.setCpf(cpf);;
        cliente.setIdade(idade);;

        // Instancia Repositorio e salve no banco a instancia do cliente
        ClienteRepositorio.save(cliente);

        ModelAndView modelo = new ModelAndView("./pastaClientes/cadastrocliente");
        return modelo;
    }

    // Post mapping do formulario de edição de cliente
    @PostMapping(value = "/editarcliente")
    public ModelAndView postEditarCliente(@RequestParam String nome, @RequestParam String telefone,
            @RequestParam String endereco, @RequestParam String cpf, @RequestParam int idade,
            @RequestParam int id) {

        // Faz conversão do id int para id Long
        Long newId = Long.valueOf(id);

        // Instacia medicamento
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);;
        cliente.setCpf(cpf);;
        cliente.setIdade(idade);
        cliente.setId(newId);

        // Instancia Repositorio e salve no banco a instancia do medicamento
        ClienteRepositorio.save(cliente);

        // Retorna metodo getMedicamentos
        return getClientes();
    }


}