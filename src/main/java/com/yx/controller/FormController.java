package com.yx.controller;

import com.yx.model.FormBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/form")
@SessionAttributes("formBean")
public class FormController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", false);
    }

    @ModelAttribute("command")
    public FormBean createFormBean() {
        return new FormBean();
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(HttpServletRequest request,BindingResult result,
                                @ModelAttribute("ajaxRequest") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return null;
        }
        String message = "Form submitted successfully.  Bound " + request;
        if (ajaxRequest) {
            model.addAttribute("message", message);
            return null;
        } else {
            redirectAttrs.addFlashAttribute("message", message);
            return "redirect:/form";
        }
    }
}