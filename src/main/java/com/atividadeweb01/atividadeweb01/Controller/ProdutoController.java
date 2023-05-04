package com.atividadeweb01.atividadeweb01.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atividadeweb01.atividadeweb01.Model.Produto;

import jakarta.websocket.server.PathParam;

@Controller
public class ProdutoController {

    List<Produto> produtos = new ArrayList<>();

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String lista(Produto produto) {
        System.out.println(produto.getId());
        if (produto.getId() != 0) {
            Produto produtofind = new Produto();
            for (Produto p1 : produtos) {
                if (p1.getId() == produto.getId()) {
                    produtofind = p1;
                }
            }
            produtos.set(produtos.indexOf(produtofind), produto);
        } else {
            int id = produtos.size() + 1;
            produtos.add(new Produto(id, produto.getNomeProduto(), produto.getValor(), produto.getPeso(),
                    produto.getQtdEstoque()));

        }
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("Produtos", produtos);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("lista");
        for (Produto p1 : produtos) {
            if (p1.getId() == id) {
                produtos.remove(p1);
                break;
            }
        }
        mv.addObject("Produtos", produtos);
        return mv;
    }

    @GetMapping("/home/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("home");
        Produto produtoAntigo = new Produto();
        for (Produto p1 : produtos) {
            if (p1.getId() == id) {
                produtoAntigo = p1;
            }
        }
        mv.addObject("produtoAntigo", produtoAntigo);
        return mv;
    }

}
