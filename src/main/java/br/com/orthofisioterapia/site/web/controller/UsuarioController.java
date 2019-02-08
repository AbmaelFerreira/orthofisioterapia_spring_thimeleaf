package br.com.orthofisioterapia.site.web.controller;

import br.com.orthofisioterapia.site.dao.UsuarioDao;
import br.com.orthofisioterapia.site.domain.TipoSexo;
import br.com.orthofisioterapia.site.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Abmael on 05/02/2019.
 */

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao dao;


    @GetMapping("/todos")
    public ModelAndView todos(ModelMap model) {
           model.addAttribute("usuarios", dao.getTodos());
           model.addAttribute("conteudo","/user/list");
           return new ModelAndView("layout", model);
    }

//    @GetMapping("/home")
//    public ModelAndView home(ModelMap model) {
//        //model.addAttribute("usuarios", dao.getTodos());
//        //model.addAttribute("conteudo","/views/index");
//        //return new ModelAndView("layout", model);
//
//        return new ModelAndView("/index", model);
//    }

    @GetMapping("/nome")
    public ModelAndView listarPorNome(@RequestParam(value = "nome") String nome, ModelMap model) {

        if (nome == null) {
            return new ModelAndView("redirect:/usuario/todos");
        }

        model.addAttribute("usuarios", dao.getByNome(nome));
        model.addAttribute("conteudo","/user/list" );
        return new ModelAndView("layout", model);
    }

    @GetMapping("/sexo")
    public ModelAndView listarPorSexo(@RequestParam(value = "tipoSexo") TipoSexo sexo, ModelMap model) {

        if (sexo == null) {
            return new ModelAndView("redirect:/usuario/todos");
        }

        model.addAttribute("usuarios", dao.getBySexo(sexo));
        model.addAttribute("conteudo", "/user/list");
        return new ModelAndView("layout", model);
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro(Usuario usuario) {

        return new ModelAndView("layout", "conteudo", "/user/add");

    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result, RedirectAttributes attrib) {

        if (result.hasErrors()) {
            return new ModelAndView("layout", "conteudo","/user/add");
        }

        dao.salvar(usuario);
        attrib.addFlashAttribute("message", "Registro inserido com sucesso.");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {

        model.addAttribute("usuario", dao.getId(id));
        model.addAttribute("conteudo", "/user/add");
        return new ModelAndView("layout", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid Usuario usuario, BindingResult result, RedirectAttributes attrib) {

        if (result.hasErrors()) {
            return new ModelAndView("layout","conteudo", "/user/add");
        }

        dao.editar(usuario);
        attrib.addFlashAttribute("message", "Registro editado com sucesso.");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attrib) {

        dao.excluir(id);
        attrib.addFlashAttribute("message", "Usuário removido com sucesso.");
        return "redirect:/usuario/todos";
    }

    @ModelAttribute("sexos")
    public TipoSexo[] tipoSexo() {
        return TipoSexo.values();
    }
}
