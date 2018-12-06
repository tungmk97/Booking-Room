package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cnpm.service.AccountService;

@Controller
public class AccountController {
	@Autowired
    private AccountService accountService;

    @GetMapping("/manage-account")
    public String index(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "manage-account";
    }
//    @GetMapping("/account/{id_user}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("account", accountService.findOne(id));
//        return "form";
//    }
    @GetMapping("/account/{id_user}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        accountService.delete(id);
        redirect.addFlashAttribute("success", "Xóa tài khoản thành công!");
        return "redirect:/account";
     }
//    @GetMapping("/account/search")
//    public String search(@RequestParam("q") String q, Model model) {
//        if (q.equals("")) {
//            return "redirect:/account";
//        }
//
//        model.addAttribute("accounts", accountService.search(q));
//        return "list-account";
//    }
}
