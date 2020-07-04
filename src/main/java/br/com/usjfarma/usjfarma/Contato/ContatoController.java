package br.com.usjfarma.usjfarma.Contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.usjfarma.usjfarma.Repositorys.ContatoRepository;

@Controller
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepositorio;

    // Link Home para redirecionamento para a pagina de contatos

    @GetMapping(value = "/contatos")
    public ModelAndView getContatos() {
        ModelAndView modelo = new ModelAndView("contatos");
        return modelo;
    }

    @PostMapping(value = "/contatos")
    public String postContatos(@RequestParam String nome, @RequestParam String email, @RequestParam String titulo,
            @RequestParam String assunto) {
        // TODO: process POST request

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setTitulo(titulo);
        contato.setMensagem(assunto);

        contatoRepositorio.save(contato);

        return "contatos";
    }

}