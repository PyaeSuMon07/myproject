package com.cgm.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *<h2>HomeControllerClass</h2>
 *<p>
 *Process for DisplayingHomeController
 *</p>
 *
 * @author PyaeSuMon
 *
 */
@Controller
public class HomeController {

    /**
     *<h2>viewHome
     *<p>
     *
     *</p>
     *
     * @return
     *@return String
     */
    @RequestMapping(value= {"/"})
    public String viewHome() {
        return "home";
    }

    /**
     *<h2>viewLogin
     *<p>
     *
     *</p>
     *
     * @return
     *@return String
     */
    @RequestMapping("/login")
    public String viewLogin() {
        return "login";
    }

    /**
     *<h2>viewPasswordReset
     *<p>
     *
     *</p>
     *
     * @return
     *@return String
     */
    @RequestMapping("/passwordReset")
    public String viewPasswordReset() {
        return "passwordReset";
    }

    /**
     *<h2>error
     *<p>
     *
     *</p>
     *
     * @return
     *@return String
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "denied";
    }
}