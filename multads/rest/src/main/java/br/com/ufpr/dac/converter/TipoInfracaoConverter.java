package br.com.ufpr.dac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ufpr.dac.persistence.TipoInfracao;

@FacesConverter(forClass = TipoInfracao.class)
public class TipoInfracaoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (TipoInfracao) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof TipoInfracao) {
        	TipoInfracao entity = (TipoInfracao) value;
            if (entity != null && entity instanceof TipoInfracao && entity.getId() > 0) {
                uiComponent.getAttributes().put( String.valueOf(entity.getId()), entity);
                return String.valueOf(entity.getId());
            }
        }
        return "";
    }
	
}
