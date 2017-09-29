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

@Controller // 컨트롤러로 설정됨
@RequestMapping("/todo/*") // 해당 경로로 들어오면 처리하겠다는 의미다
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
        // 모델어트리뷰트
        model.addAttribute("todo", service.get(tno));

    }

    // @PostMapping("/register")
    // public String register(TodoDTO dto, Model model) {
    //
    // //기본적인 파라미터는 등록되면 바로 view로 보낼수 있다
    // // 모델 은 내가 추가적인 데이터를 심고싶을때 사용한다
    // log.info("" + dto);
    //
    // service.register(dto);
    //
    // model.addAttribute("result", "success");
    // return "redirect:/todo/list";
    // //redirect 새로 써봄
    // }

    // 2017-09-20
    // 도배 금지 두번째 방법임
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {

        model.addAttribute("list", service.list(cri));

    }

    @PostMapping("/register")
    public String register(TodoDTO dto, RedirectAttributes rttr) {
        // redirectAttributes 쓰면 파라미터 값을 한번만 보낸다
        log.info("" + dto);

        service.register(dto);

        // 세션에 값을 살짝 담아둠. 한번 사용되면 사라진다.
        rttr.addFlashAttribute("result", "success");

        return "redirect:/todo/index";

    }
    
    @PostMapping("/fileupload")
    public String fileupload(TodoDTO dto, RedirectAttributes rttr) {
        // redirectAttributes 쓰면 파라미터 값을 한번만 보낸다
        log.info("" + dto);

        service.register(dto);

        // 세션에 값을 살짝 담아둠. 한번 사용되면 사라진다.
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
