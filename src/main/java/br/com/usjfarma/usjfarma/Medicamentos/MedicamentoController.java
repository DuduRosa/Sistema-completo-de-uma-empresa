package br.com.usjfarma.usjfarma.Medicamentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.usjfarma.usjfarma.Repositorys.MedicamentosRepository;

@Controller
public class MedicamentoController {
    
    // Instanciando objeto do repositorio MedicamentosRepository
    @Autowired
    MedicamentosRepository MedicamentoRepositorio;

    //==================================================== MEDICAMENTOS ====================================//

    //------------------------------------- Get's---------------------------------------//

    // Link Home para redirecionamento para a pagina de medicamentos

    @GetMapping(value = "/medicamentos")
    public ModelAndView getMedicamentos() {
        // Retorna Lista de Medicamentos
        List<Medicamento> medicamentos = MedicamentoRepositorio.findAll();
        // Retorna ModelAndView com a lista
        ModelAndView modelo = new ModelAndView("./pastaMedicamentos/medicamentos");
        modelo.addObject("lista", medicamentos);
        return modelo;
    }

    // Link Medicamentos cadastro medicamentos

    @GetMapping(value = "/cadastromedicamento")
    public String getCadastroMedicamento() {
        return "./pastaMedicamentos/cadastromedicamento";
    }


    // Link Medicamentos Excluir

    @GetMapping(value = "/excluir/{id}")
    public ModelAndView getExcluir(@PathVariable("id") int id) {

        // Faz a conversão do id int para newId long
        Long newId = Long.valueOf(id);

        // Chama repositorio e indica o id long para excluir do banco
        MedicamentoRepositorio.deleteById(newId);

        // Retorna pagina medicamentos
        return getMedicamentos();
    }

    // Link Medicamentos Visualizar

    @GetMapping(value = "/visualizar/{id}")
    public ModelAndView getVisualizar(@PathVariable("id") int id) {

        // Faz a conversão do id int para newId long
        Long newId = Long.valueOf(id);

        ModelAndView modelo = new ModelAndView("./pastaMedicamentos/visualizar");
        modelo.addObject("medicamento", MedicamentoRepositorio.findById(newId).get());
        // Retorna pagina medicamentos
        return modelo;
    }

    // Link Medicamentos Editar

    @GetMapping(value = "/editar/{id}")
    public ModelAndView getEditar(@PathVariable("id") int id) {
        // Converte id Int para Long
        Long nId = Long.valueOf(id);
        // Chama Lista de Contatos do repositorio
        Medicamento medicamentosLista = MedicamentoRepositorio.findById(nId).get();
        // Envia Lista atraves do modelo
        ModelAndView modelo = new ModelAndView("./pastaMedicamentos/editar");
        modelo.addObject("medicamento", medicamentosLista);
        return modelo;
    }

    //--------------------------------- Post's ------------------------------------------------//

    // Post mapping do formulario de cadastro de medicamentos
    @PostMapping(value = "/cadastromedicamento")
    public ModelAndView postCadastroMedicamento(@RequestParam String nome, @RequestParam String dosagem,
            @RequestParam String quantidade, @RequestParam String tarja, @RequestParam String tipo) {

        // Instacia medicamento
        Medicamento medicamento = new Medicamento();
        medicamento.setNome(nome);
        medicamento.setDosagem(dosagem);
        medicamento.setQuantidade(quantidade);
        medicamento.setTarja(tarja);
        medicamento.setTipo(tipo);

        // Instancia Repositorio e salve no banco a instancia do medicamento
        MedicamentoRepositorio.save(medicamento);

        ModelAndView modelo = new ModelAndView("./pastaMedicamentos/cadastromedicamento");
        return modelo;
    }

    // Post mapping do formulario de edição de medicamentos
    @PostMapping(value = "/editarmedicamento")
    public ModelAndView postEditarMedicamento(@RequestParam String nome, @RequestParam String dosagem,
            @RequestParam String quantidade, @RequestParam String tarja, @RequestParam String tipo,
            @RequestParam int id) {

        // Faz conversão do id int para id Long
        Long newId = Long.valueOf(id);

        // Instacia medicamento
        Medicamento medicamento = new Medicamento();
        medicamento.setNome(nome);
        medicamento.setDosagem(dosagem);
        medicamento.setQuantidade(quantidade);
        medicamento.setTarja(tarja);
        medicamento.setTipo(tipo);
        medicamento.setId(newId);

        // Instancia Repositorio e salve no banco a instancia do medicamento
        MedicamentoRepositorio.save(medicamento);

        // Retorna metodo getMedicamentos
        return getMedicamentos();
    }


}