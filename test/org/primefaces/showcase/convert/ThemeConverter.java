//package org.primefaces.showcase.convert;
// 
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//import org.primefaces.showcase.domain.Theme;
//import org.primefaces.showcase.service.ThemeService;
// 
//@FacesConverter("themeConverter")
//public class ThemeConverter implements Converter {
// 
//    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//        if(value != null && value.trim().length() > 0) {
//            ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
//            return service.getThemes().get(Integer.parseInt(value));
//        }
//        else {
//            return null;
//        }
//    }
// 
//    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//        if(object != null) {
//            return String.valueOf(((Theme) object).getId());
//        }
//        else {
//            return null;
//        }
//    }
//     
//}
//                   