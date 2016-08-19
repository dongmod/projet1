/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.validator;

import Com.ITsolution.gescom.Bean.Session;
import Com.ITsolution.gescom.EJB.CodejournalFacadeLocal;
import Com.ITsolution.gescom.Exception.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author SERGE
 */
@ManagedBean
@ViewScoped
public class CodejournalExiste implements Validator {

    @EJB
    private CodejournalFacadeLocal codejournalFacade;
    private static final String JOURNAL_EXISTE_DEJA = "ce journal  existe déjà ";

  @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
           
          String libelle = (String) value;
           String login = Session.renvoirSession().toString();
        try {
            if ( codejournalFacade.trouver( libelle,login ) != null ) {
                
            throw new ValidatorException(
        new FacesMessage(FacesMessage.SEVERITY_ERROR, JOURNAL_EXISTE_DEJA, null ) );
    }
        } catch ( DAOException e ) {
               
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId(facesContext ), message );
            }
        }
    }