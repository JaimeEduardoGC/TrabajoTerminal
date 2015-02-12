/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.struts.action;

/**
 *
 * @author Administrator
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
import com.myapp.struts.DAO.RegistroUsuarioDAO;
import com.app.struts.formbeans.UserResgisterForm;
 
public class UserRegisterAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession ses = request.getSession(true);
 
        UserResgisterForm registerForm = (UserResgisterForm) form;

        String userName = registerForm.getUserName();
        String password = registerForm.getPassword();
        RegistroUsuarioDAO dao = new RegistroUsuarioDAO();
        boolean res;
        res = dao.validar( userName, password );
        ses.setAttribute("userName", userName);
        if (res) {
            return mapping.findForward("success");
        }
        return mapping.findForward("error");
 
    }
}