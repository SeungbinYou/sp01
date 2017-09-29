package com.java96.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;
import com.java96.service.TodoService;

import lombok.extern.java.Log;

@Controller // ��Ʈ�ѷ��� ������
@RequestMapping("/todo/*") // �ش� ��η� ������ ó���ϰڴٴ� �ǹ̴�
@Log
public class TodoController {

    @Inject
    private TodoService service;

    @GetMapping("/register")
    public void register() {

    }

    @GetMapping("/fileupload")
    public void fileupload() {

    }

    // @GetMapping("/view")
    // public @ResponseBody TodoDTO view(Long tno) {
    //
    // return service.get(tno);
    //
    // }

    @PostMapping("/remove")
    public String remPost(Long tno, RedirectAttributes rttr) {

        service.remove(tno);
        rttr.addFlashAttribute("result", "success");

        return "redirect:/todo/index";
    }

    @GetMapping("/view")
    public void view(Long tno, @ModelAttribute("cri") Criteria cri, Model model) {
        // �𵨾�Ʈ����Ʈ
        model.addAttribute("todo", service.get(tno));

    }

    // @PostMapping("/register")
    // public String register(TodoDTO dto, Model model) {
    //
    // //�⺻���� �Ķ���ʹ� ��ϵǸ� �ٷ� view�� ������ �ִ�
    // // �� �� ���� �߰����� �����͸� �ɰ������ ����Ѵ�
    // log.info("" + dto);
    //
    // service.register(dto);
    //
    // model.addAttribute("result", "success");
    // return "redirect:/todo/list";
    // //redirect ���� �ẽ
    // }

    // 2017-09-20
    // ���� ���� �ι�° �����
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {

        model.addAttribute("list", service.list(cri));

    }

    @PostMapping("/register")
    public String register(TodoDTO dto, RedirectAttributes rttr) {
        // redirectAttributes ���� �Ķ���� ���� �ѹ��� ������
        log.info("" + dto);

        service.register(dto);

        // ���ǿ� ���� ��¦ ��Ƶ�. �ѹ� ���Ǹ� �������.
        rttr.addFlashAttribute("result", "success");

        return "redirect:/todo/index";

    }
    
    @PostMapping("/fileupload")
    public String fileupload(TodoDTO dto, RedirectAttributes rttr) {
        // redirectAttributes ���� �Ķ���� ���� �ѹ��� ������
        log.info("" + dto);

        service.register(dto);

        // ���ǿ� ���� ��¦ ��Ƶ�. �ѹ� ���Ǹ� �������.
        rttr.addFlashAttribute("result", "success");

        return "redirect:/todo/index";

    }

    @GetMapping("/modify")
    public void modGet(Long tno, @ModelAttribute("cri") Criteria cri, Model model) {

        model.addAttribute("todo", service.get(tno));
    }

    @PostMapping("/modify")
    public String modPost(TodoDTO dto, Criteria cri, RedirectAttributes rttr) {

        log.info("mod post................");

        rttr.addAttribute("tno", dto.getTno());

        service.updateBoard(dto);

        log.info(cri.getURI());

        rttr.addAttribute("page", cri.getPage());

        return "redirect:/todo/index";
    }

    @GetMapping("/index")
    public void index(Criteria cri, Model model) {

        model.addAttribute("list", service.list(cri));
    }

}
